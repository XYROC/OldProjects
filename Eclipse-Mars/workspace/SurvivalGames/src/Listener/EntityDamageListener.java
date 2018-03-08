package Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import main.SurvivalGames;

public class EntityDamageListener implements Listener{
	
	
	private SurvivalGames plugin;
	
	public EntityDamageListener(SurvivalGames plugin){
		this.plugin = plugin;
		
		
	
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent evt){
		
		if(this.plugin.friendly){
			
			evt.setCancelled(true);
			
		}else{
			
			evt.setCancelled(false);
			
		}
		
		
		
		
	}
	

}
