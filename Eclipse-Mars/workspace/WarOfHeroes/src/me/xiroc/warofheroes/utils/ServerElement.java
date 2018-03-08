package me.xiroc.warofheroes.utils;

import java.util.ArrayList;

public class ServerElement {

	private Map map;
	private ArrayList<PlayerElement> players;

	public ServerElement(Map map) {
		this.players = new ArrayList<PlayerElement>();
		this.map = map;
	}

	public ArrayList<PlayerElement> getPlayers() {
		return players;
	}

	public Map getMap() {
		return map;
	}

	public void addPlayer(PlayerElement playerElement) {
		this.players.add(playerElement);
	}

	public void removePlayer(PlayerElement playerElement) {
		this.players.remove(playerElement);
	}

}
