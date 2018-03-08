package Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import main.SurvivalGames;

public class PlayerDeathListener implements Listener{
	
	private SurvivalGames plugin;
	
	public PlayerDeathListener(SurvivalGames plugin){
		this.plugin = plugin;
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent evt){
		Player p = evt.getEntity();
		// Removes dropped Items [NOT ENABLED]
		// evt.getDrops().clear();
		String deathname = p.getName();
		String killername = p.getKiller().getName();
		evt.setDeathMessage(this.plugin.prefix+ChatColor.RED+deathname+ChatColor.GREEN+
				"wurde von "+ChatColor.BLUE+killername+ChatColor.GREEN+"getötet!");
		p.setVelocity(p.getVelocity().setY(2.5));
		p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,1000000,15));
		p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,1000000,15));
		p.setHealth(20.0);
		p.getInventory().clear();
		p.setFoodLevel(20);
		p.setFireTicks(0);
		
		this.plugin.online.remove(p);
		this.plugin.dead.add(p);
		
		for(Player all : Bukkit.getOnlinePlayers()){
			
			all.hidePlayer(p);
			
			
		}
		
		if(this.plugin.dead.size() == Bukkit.getOnlinePlayers().size()-1){
			Bukkit.broadcastMessage(this.plugin.prefix+ChatColor.GREEN+"Der Spieler "+ChatColor.GOLD
					+p.getKiller()+ChatColor.GREEN+" hat die SurvivalGames gewonnen!");
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin,new Runnable() {
			
			@Override
			public void run() {
				for(Player all : Bukkit.getOnlinePlayers()){
					
					all.kickPlayer(PlayerDeathListener.this.plugin.prefix+ChatColor.GREEN+"Die SurvivalGames sind zu Ende!");
					
				}
				Bukkit.shutdown();
				
			}
			
		});
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
