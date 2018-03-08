package me.xiroc.bedwars.util;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.xiroc.bedwars.main.MainPlugin;

public class ConfigManager {
	
	private MainPlugin plugin;
	private File file;
	private FileConfiguration cfg;
	
	public ConfigManager(MainPlugin plugin) {
		this.plugin = plugin;
		file = new File(plugin.getDataFolder(),"config.yml");
		cfg = YamlConfiguration.loadConfiguration(file);
	}
	public void load(){
		if(!file.exists()){
			cfg.options().copyDefaults(true);
			save();
		}else{
			try {
				cfg.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void save() {
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveLocation(Location location, String name){
		cfg.set(name+".x", location.getX());
		cfg.set(name+".y", location.getY());
		cfg.set(name+".z", location.getZ());
		cfg.set(name+".yaw", location.getYaw());
		cfg.set(name+".pitch", location.getPitch());
		cfg.set(name+".world", location.getWorld());
		save();
	}
	public void saveBlockLocation(Location location, String name){
		cfg.set(name+".x", location.getX());
		cfg.set(name+".y", location.getY());
		cfg.set(name+".z", location.getZ());
		cfg.set(name+".world", location.getWorld());
		save();
	}
	public Location loadLocation(String name){
		double x = cfg.getDouble(name+".x");
		double y = cfg.getDouble(name+".y");
		double z = cfg.getDouble(name+".z");
		double yaw = cfg.getDouble(name+".yaw");
		double pitch = cfg.getDouble(name+".pitch");
		World world = Bukkit.getWorld(cfg.getString(name+".world"));
		Location location = new Location(world, x, y, z);
		location.setYaw((float)yaw);
		location.setPitch((float)pitch);
		return location;
	}
	public Location loadBlockLocation(String name){
		double x = cfg.getDouble(name+".x");
		double y = cfg.getDouble(name+".y");
		double z = cfg.getDouble(name+".z");
		World world = Bukkit.getWorld(cfg.getString(name+".world"));
		Location location = new Location(world, x, y, z);
		return location;
	}
	public FileConfiguration getConfig() {
		return cfg;
	}

}
