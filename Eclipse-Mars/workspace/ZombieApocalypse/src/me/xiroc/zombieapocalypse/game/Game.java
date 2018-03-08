package me.xiroc.zombieapocalypse.game;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Game {
	
	private ArrayList<Player> players;
	private int maxSize;
	private boolean isRunning;
	
	public Game(int maxSize, boolean isRunning) {
		this.players = new ArrayList<Player>();
		this.maxSize = maxSize;
		this.isRunning = isRunning;
	}
	public ArrayList<Player> getPlayers(){
		return players;
	}
	public int getPlayerSize(){
		return players.size();
	}
	public void addPlayer(Player player){
		players.add(player);
	}
	public void removePlayer(Player player){
		players.remove(player);
	}
	public int getMaxSize(){
		return maxSize;
	}
	public void setRunning(boolean value){
		this.isRunning = value;
	}
	public boolean isGameRunning(){
		return isRunning;
	}
}
