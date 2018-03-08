package me.xiroc.warofheroes.utils;

import org.bukkit.World;

public class Map {
	
	private String name;
	private World world;
	
	public Map(World world, String name) {
		this.world = world;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public World getWorld() {
		return world;
	}

}
