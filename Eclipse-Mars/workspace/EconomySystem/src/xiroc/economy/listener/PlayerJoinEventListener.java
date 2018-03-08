package xiroc.economy.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import xiroc.economy.Economy;

public class PlayerJoinEventListener implements Listener{
	
	private Economy plugin;
	
	public PlayerJoinEventListener(Economy plugin){
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		this.plugin.updateScoreBoard(e.getPlayer());
	}

}
