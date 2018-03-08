package me.xiroc.plugin.game;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Map {
	
	private String name;
	File file;
	FileConfiguration cfg;
	public Map(String name) {
		this.name = name;
		this.file = new File("plugins//War//Worlds//"+name+".yml");
		this.cfg = YamlConfiguration.loadConfiguration(file);
	}
	public String getName() {
		return name;
	}
	public FileConfiguration getFileConfiguration() {
		return cfg;
	}
	public File getFile() {
		return file;
	}
	public int getTeams(){
		int i = 0;
		i = cfg.getInt("game.teams");
		return i;
	}
	public int getPlayersPerTeam(){
		int i = 0;
		i = cfg.getInt("game.ppt");
		return i;
	}
	public String getWorld(){
		return cfg.getString("game.world");
	}
	public String getMapName(){
		return cfg.getString("game.name");
	}
	public Location getMapSpawnForTeam(int team){
		if(team > 4) team = 4;
		if(team < 1) team = 1;
		World world = Bukkit.getWorld(cfg.getString("game.world"));
		switch(team){
		case 1:
			double x = cfg.getDouble("game.spawns.blue.x");
			double y = cfg.getDouble("game.spawns.blue.y");
			double z = cfg.getDouble("game.spawns.blue.z");
			double yaw = cfg.getDouble("game.spawns.blue.yaw");
			double pitch = cfg.getDouble("game.spawns.blue.pitch");
			return new Location(world, x, y, z, (float) yaw, (float)pitch);
		case 2:
			double x1 = cfg.getDouble("game.spawns.red.x");
			double y1 = cfg.getDouble("game.spawns.red.y");
			double z1 = cfg.getDouble("game.spawns.red.z");
			double yaw1 = cfg.getDouble("game.spawns.red.yaw");
			double pitch1 = cfg.getDouble("game.spawns.red.pitch");
			return new Location(world, x1, y1, z1, (float) yaw1, (float)pitch1);
		case 3:
			double x2 = cfg.getDouble("game.spawns.green.x");
			double y2 = cfg.getDouble("game.spawns.green.y");
			double z2 = cfg.getDouble("game.spawns.green.z");
			double yaw2 = cfg.getDouble("game.spawns.green.yaw");
			double pitch2 = cfg.getDouble("game.spawns.green.pitch");
			return new Location(world, x2, y2, z2, (float) yaw2, (float)pitch2);
		case 4:
			double x3 = cfg.getDouble("game.spawns.yellow.x");
			double y3 = cfg.getDouble("game.spawns.yellow.y");
			double z3 = cfg.getDouble("game.spawns.yellow.z");
			double yaw3 = cfg.getDouble("game.spawns.yellow.yaw");
			double pitch3 = cfg.getDouble("game.spawns.yellow.pitch");
			return new Location(world, x3, y3, z3, (float) yaw3, (float)pitch3);
		default:
			double x4 = cfg.getDouble("game.spawns.blue.x");
			double y4 = cfg.getDouble("game.spawns.blue.y");
			double z4 = cfg.getDouble("game.spawns.blue.z");
			double yaw4 = cfg.getDouble("game.spawns.blue.yaw");
			double pitch4 = cfg.getDouble("game.spawns.blue.pitch");
			return new Location(world, x4, y4, z4, (float) yaw4, (float)pitch4);
		}
	}

}
