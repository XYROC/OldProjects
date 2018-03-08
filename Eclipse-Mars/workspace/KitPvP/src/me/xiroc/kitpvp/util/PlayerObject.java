package me.xiroc.kitpvp.util;

import org.bukkit.entity.Player;

public class PlayerObject {
	
	private Player player;
	private int team;
	
	public PlayerObject(Player player) {
		this.player = player;
		this.team = 0;
	}
	
	public PlayerObject(Player player, int team) {
		this.player = player;
		this.team = team;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getTeam() {
		return team;
	}
	
	public void setTeam(int team) {
		this.team = team;
	}

}
