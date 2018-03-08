package me.xiroc.warofheroes.utils;

import org.bukkit.entity.Player;

public class PlayerElement {
	
	private Player player;
	private int team;
	private int points;
	
	public PlayerElement(Player player, int team) {
		this.player = player;
		this.team = team;
	}
	public PlayerElement(Player player) {
		this.player = player;
		this.team = 0;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public void addPoint(){
		this.points += 1;
	}
	public void addPoint(int amount){
		this.points += amount;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	public Player getPlayer() {
		return player;
	}
	public int getPoints() {
		return points;
	}

}
