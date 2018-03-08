package Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import main.SurvivalGames;

public class PlayerChangeFoodLevel implements Listener{
	
	
	private SurvivalGames plugin;
	
	public PlayerChangeFoodLevel(SurvivalGames plugin){
		this.plugin = plugin;
		
		
	
		
	}
	
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent evt){

		if(this.plugin.friendly){
			
			evt.setCancelled(true);
			
		}else{
			
			evt.setCancelled(false);
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}