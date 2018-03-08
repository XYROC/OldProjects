package Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import main.SurvivalGames;

public class PlayerPickupItemListener implements Listener{
	
	private SurvivalGames plugin;
	
	public PlayerPickupItemListener(SurvivalGames plugin){
		
		this.plugin = plugin;
	}

	@EventHandler
	public void onPickup(PlayerPickupItemEvent evt){
		Player p = evt.getPlayer();
		if(!this.plugin.dead.contains(p)){
			
			evt.setCancelled(true);
		
		}else{
			
			evt.setCancelled(false);
			
		}
		
		
		
		
		
	}
	
}
	
	
	
	