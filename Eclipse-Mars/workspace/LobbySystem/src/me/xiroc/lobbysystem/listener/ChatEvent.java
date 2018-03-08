package me.xiroc.lobbysystem.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.xiroc.lobbysystem.main.MainPlugin;

public class ChatEvent implements Listener{
	
	private MainPlugin plugin;
	
	public ChatEvent(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		
	}

}
