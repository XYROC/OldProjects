package me.xiroc.kitpvp.util;

import java.io.File;

import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MapObject {

	private World world;
	private String name;
	private int id;

	public MapObject(String name, World world, int id) {
		this.name = name;
		this.world = world;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public World getWorld() {
		return world;
	}
	
	public int getId() {
		return id;
	}
	
	public int getMaxPlayers(){
		int max = 0;
		FileConfiguration cfg = YamlConfiguration
				.loadConfiguration(new File("plugins//KitPvP//Data//Maps//MapManager.yml"));
		max = cfg.getInt("maps."+getName()+".maxplayers");
		return max;
	}
	
	public int getTeams(){
		int teams = 0;
		FileConfiguration cfg = YamlConfiguration
				.loadConfiguration(new File("plugins//KitPvP//Data//Maps//MapManager.yml"));
		teams = cfg.getInt("maps."+getName()+".teams");
		return teams;
	}

}
