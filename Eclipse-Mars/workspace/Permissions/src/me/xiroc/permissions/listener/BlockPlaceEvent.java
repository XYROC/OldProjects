package me.xiroc.permissions.listener;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.xiroc.permissions.main.Permissions;

public class BlockPlaceEvent implements Listener{
	
	private Permissions plugin;
	
	public BlockPlaceEvent(Permissions plugin){
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
		System.out.println("[Permissions] Loading Protection (2/2) (100%)");
	}
	public void onPlace(org.bukkit.event.block.BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(this.plugin.protect){
			e.setCancelled(true);
		}else{
			File file = new File("plugins//Permissions//Player",p.getName()+".yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			if(cfg.getBoolean("World.canPlaceBlock")){
				e.setCancelled(false);
			}else{
				e.setCancelled(true);
			}
		}
	}

}
