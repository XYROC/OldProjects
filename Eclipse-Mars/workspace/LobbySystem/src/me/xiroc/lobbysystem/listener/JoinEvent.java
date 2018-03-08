package me.xiroc.lobbysystem.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.xiroc.lobbysystem.main.MainPlugin;

public class JoinEvent implements Listener{
	
	private MainPlugin plugin;
	
	public JoinEvent(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		e.setJoinMessage("");
	}

}
