package me.xiroc.permissions.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.xiroc.permissions.main.Permissions;

public class PlayerJoinEvent implements Listener{
	
	private Permissions plugin;
	
	public PlayerJoinEvent(Permissions plugin){
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
		System.out.println("[Permissions] Loading PlayerJoinEvent");
	}
	@EventHandler
	public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent e){
		Player p = e.getPlayer();
		System.out.println("Joined!");
		File bin = new File("plugins//Permissions//Player");
		File file = new File("plugins//Permissions//Player",p.getName()+".yml");
		if(!bin.exists()){
			bin.mkdir();
		}
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		//boolean canBreakBlock = cfg.getBoolean("World.canBreakBlock");
		//boolean canPlaceBlock = cfg.getBoolean("World.canPlaceBlock");
		
	}

}
