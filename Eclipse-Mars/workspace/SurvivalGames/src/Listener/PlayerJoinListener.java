package Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import main.SurvivalGames;

public class PlayerJoinListener implements Listener{
	
	private SurvivalGames plugin;
	
	public PlayerJoinListener(SurvivalGames plugin){
		this.plugin = plugin;
		
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent  evt){
		final Player p = evt.getPlayer();
		if(this.plugin.joinable){
			String joinname = p.getName();
			evt.setJoinMessage(this.plugin.prefix+ChatColor.GREEN+joinname+" hat das Spiel betreten");
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin,new Runnable() {
				
				@Override
				public void run() {
					p.getInventory().clear();
					p.getInventory().setArmorContents(null);
					p.setHealth(20.0);
					p.setFoodLevel(20);
					p.setFlying(false);
					PlayerJoinListener.this.plugin.online.add(p);
					
					World w = Bukkit.getWorld(PlayerJoinListener.this.plugin.cfg.getString("SurvivalGames.Lobby.World"));
					double wx = PlayerJoinListener.this.plugin.cfg.getDouble("SurvivalGames.Lobby.World.X");
					double wy = PlayerJoinListener.this.plugin.cfg.getDouble("SurvivalGames.Lobby.World.Y");
					double wz = PlayerJoinListener.this.plugin.cfg.getDouble("SurvivalGames.Lobby.World.Z");
					
					p.teleport(new Location(w,wx,wy,wz));
					
				}
			});
			
			
			if(Bukkit.getOnlinePlayers().size() == 2){
				
				
			}
		}else if(!this.plugin.joinable){
			
			
			p.kickPlayer(this.plugin.prefix+ChatColor.DARK_RED+"Der Server ist voll!");
		}
		
		
	}

}
