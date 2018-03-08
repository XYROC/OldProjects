package me.xiroc.kitpvp.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import me.xiroc.kitpvp.main.MainPlugin;

public class ListenerFoodChangeEvent implements Listener{
	
	private MainPlugin plugin;
	
	public ListenerFoodChangeEvent(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onChange(FoodLevelChangeEvent e){
		if(plugin.foodchange){
			e.setCancelled(true);
		}
	}

}
