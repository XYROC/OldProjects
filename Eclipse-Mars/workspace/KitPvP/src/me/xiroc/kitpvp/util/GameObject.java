package me.xiroc.kitpvp.util;

import org.bukkit.Location;

public class GameObject {
	
	private Game game;
	private Location signLocation;
	
	public GameObject(Game game, Location signLocation) {
		this.game = game;
		this.signLocation = signLocation;
	}
	public Game getGame() {
		return game;
	}
	public Location getSignLocation() {
		return signLocation;
	}

}
