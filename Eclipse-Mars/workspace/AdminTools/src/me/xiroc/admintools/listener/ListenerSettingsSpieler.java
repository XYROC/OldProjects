package me.xiroc.admintools.listener;

import org.bukkit.event.Listener;

import me.xiroc.admintools.main.MainPlugin;

public class ListenerSettingsSpieler implements Listener{
	
	private MainPlugin plugin;
	
	public ListenerSettingsSpieler(MainPlugin plugin){
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

}
