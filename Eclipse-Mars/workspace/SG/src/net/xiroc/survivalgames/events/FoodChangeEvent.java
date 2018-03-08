package net.xiroc.survivalgames.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import net.xiroc.survivalgames.main.SurvivalGames;

public class FoodChangeEvent implements Listener{
	
	private SurvivalGames plugin;
	
	public FoodChangeEvent(SurvivalGames plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		System.out.println("[SurvivalGames] Loaded FoodChangeEvent");

	}
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e){
		if(this.plugin.peace){
			e.setCancelled(true);
		}
	}

}
