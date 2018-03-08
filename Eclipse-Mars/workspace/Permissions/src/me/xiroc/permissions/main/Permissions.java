package me.xiroc.permissions.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.xiroc.permissions.listener.BlockBreakEvent;
import me.xiroc.permissions.listener.BlockPlaceEvent;
import me.xiroc.permissions.listener.PlayerJoinEvent;
public class Permissions extends JavaPlugin{
	
	public boolean protect;
	public boolean peace;
	
	
	public void onEnable(){
		loadBooleans();
		registerEvents();
		registerCommands();
		System.out.println("[Permissions] Enabled Permissions");
	}
	public void onDisable(){
		System.out.println("[Permissions] Disabled Permissions");
	}
	
	
	
	
	
	
	public void registerEvents(){
		BlockBreakEvent brk = new BlockBreakEvent(this);
		BlockPlaceEvent bplc = new BlockPlaceEvent(this);
		PlayerJoinEvent plj = new PlayerJoinEvent(this);
	}
	public void registerCommands(){
		
	}
	public void loadBooleans(){
		File bin = new File("plugins//Permissions//Data");
		File file = new File("plugins//Permissions//Data", "data.yml");
		if(!bin.exists()){
			bin.mkdirs();
		}
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		boolean protect = cfg.getBoolean("Configuration.protection");
		boolean peace = cfg.getBoolean("Configuration.peace");
		
		this.protect = protect;
		this.peace = peace;

		
	}

}
