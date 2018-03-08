package me.xiroc.lobbysystem.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.xiroc.lobbysystem.main.MainPlugin;

public class LeaveEvent implements Listener{
	
	private MainPlugin plugin;
	
	public LeaveEvent(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		e.setQuitMessage("");
	}

}
