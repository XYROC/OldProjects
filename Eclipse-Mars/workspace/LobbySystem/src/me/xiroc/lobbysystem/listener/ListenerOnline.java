package me.xiroc.lobbysystem.listener;

import org.bukkit.event.Listener;

import me.xiroc.lobbysystem.main.MainPlugin;

public class ListenerOnline implements Listener{
	
	private MainPlugin plugin;
	
	public ListenerOnline(MainPlugin plugin){
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	

}
