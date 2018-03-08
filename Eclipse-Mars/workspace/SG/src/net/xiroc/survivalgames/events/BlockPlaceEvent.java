package net.xiroc.survivalgames.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import net.xiroc.survivalgames.main.SurvivalGames;

public class BlockPlaceEvent implements Listener{
	
	private SurvivalGames plugin;
	
	public BlockPlaceEvent(SurvivalGames plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		System.out.println("[SurvivalGames] Loaded BlockPlaceEvent");

	}
	@EventHandler
	public void onPlace(org.bukkit.event.block.BlockPlaceEvent e){
		if(this.plugin.protect){
			e.setCancelled(true);
		}
	}

}
