package Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import main.SurvivalGames;

public class EntityDamagebyEntityListener implements Listener{
	
	
	private SurvivalGames plugin;
	
	public EntityDamagebyEntityListener(SurvivalGames plugin){
		this.plugin = plugin;
		
		
	
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent evt){
		
		if(this.plugin.friendly){
			
			evt.setCancelled(true);
			
		}else{
			
			evt.setCancelled(false);
			
		}
		
		
		
		
	}
	

}
