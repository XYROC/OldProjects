package me.xiroc.permissions.listener;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import me.xiroc.permissions.main.Permissions;

public class BlockBreakEvent implements Listener{
	
	private Permissions plugin;
	
	public BlockBreakEvent(Permissions plugin){
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
		System.out.println("[Permissions] Loading Protection (1/2) (50%)");
	}
	@EventHandler
	public void onBreak(org.bukkit.event.block.BlockBreakEvent e){
		Player p = e.getPlayer();
		if(this.plugin.protect){
			e.setCancelled(true);
		}else{
			File file = new File("plugins//Permissions//Player",p.getName()+".yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			if(cfg.getBoolean("World.canBreakBlock")){
				e.setCancelled(false);
			}else{
				e.setCancelled(true);
			}
			
		}
		
	}

}
