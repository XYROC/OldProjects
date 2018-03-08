package Methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import main.SurvivalGames;

public class MapTeleport {
	
	private SurvivalGames plugin;
	
	public MapTeleport(SurvivalGames plugin){
		
		this.plugin = plugin;
		
	}
	
	
	public void mapTeleport(){
		this.plugin.expid = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable(){
			
			
			public void run(){
				MapTeleport.this.plugin.exp -=1;
				
				for(Player all : Bukkit.getOnlinePlayers()){
					all.setLevel(MapTeleport.this.plugin.exp);
					
				}
				if(MapTeleport.this.plugin.exp == 10){
					for(Player all : Bukkit.getOnlinePlayers()){	
						all.sendMessage(MapTeleport.this.plugin.prefix+ ChatColor.GREEN+"Das Spiel beginnt in "
					+ChatColor.YELLOW+"10"+ChatColor.GREEN+" Sekunden!");
					}
					
					
					
				}
				if(MapTeleport.this.plugin.exp == 0){
					
					
				}
				
			}
		}
		,0L,20L);
		
		
		
		
		
	}
	
	















}