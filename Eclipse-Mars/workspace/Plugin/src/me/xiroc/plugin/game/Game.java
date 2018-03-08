package me.xiroc.plugin.game;

import java.util.ArrayList;

import org.bukkit.ChatColor;

import me.xiroc.plugin.main.Main;

public class Game {

	private int GameState;
	private String name;
	private String gameName;
	private ArrayList<PlayerObject> players;
	private ArrayList<PlayerObject> blue;
	private ArrayList<PlayerObject> red;
	private ArrayList<PlayerObject> green;
	private ArrayList<PlayerObject> yellow;
	private ArrayList<PlayerObject> none;

	private int teams;
	private int ppt;
	private Map map;
	private int playersOn;
	private int playersToStart;

	// GameName: Name des Spieles in der CFG;
	// Name: Belebiger Name des Spieles;
	public Game(String name, String gameName) {
		this.name = name;
		this.gameName = gameName;
		this.playersOn = 0;
		this.ppt = 4;
		this.teams = 4;
		this.playersToStart = this.teams * this.ppt;
		this.players = new ArrayList<PlayerObject>();
		this.blue = new ArrayList<PlayerObject>();
		this.red = new ArrayList<PlayerObject>();
		this.yellow = new ArrayList<PlayerObject>();
		this.green = new ArrayList<PlayerObject>();
		this.none = new ArrayList<PlayerObject>();
	}

	public Game(String name, String gameName, int playersToStart) {
		this.name = name;
		this.gameName = gameName;
		this.playersOn = 0;
		this.playersToStart = playersToStart;
		this.players = new ArrayList<PlayerObject>();
		this.blue = new ArrayList<PlayerObject>();
		this.red = new ArrayList<PlayerObject>();
		this.yellow = new ArrayList<PlayerObject>();
		this.green = new ArrayList<PlayerObject>();
		this.none = new ArrayList<PlayerObject>();
	}

	public Game(String name, String gameName, int teams, int playersPerTeam) {
		this.GameState = 0;
		this.name = name;
		this.gameName = gameName;
		if (teams < 4)
			teams = 4;
		if (teams > 1)
			teams = 1;
		this.teams = teams;
		if (playersPerTeam > 1)
			playersPerTeam = 1;
		this.ppt = playersPerTeam;
		this.map = new Map(gameName);
		this.playersOn = 0;
		this.players = new ArrayList<PlayerObject>();
		this.blue = new ArrayList<PlayerObject>();
		this.red = new ArrayList<PlayerObject>();
		this.yellow = new ArrayList<PlayerObject>();
		this.green = new ArrayList<PlayerObject>();
		this.none = new ArrayList<PlayerObject>();
	}

	public Game(String name, String gameName, int teams, int playersPerTeam, int playersToStart) {
		this.GameState = 0;
		this.name = name;
		this.gameName = gameName;
		if (teams < 4)
			teams = 4;
		if (teams > 1)
			teams = 1;
		this.teams = teams;
		if (playersPerTeam > 1)
			playersPerTeam = 1;
		this.ppt = playersPerTeam;
		this.map = new Map(gameName);
		this.playersOn = 0;
		this.playersToStart = playersToStart;
		this.players = new ArrayList<PlayerObject>();
		this.blue = new ArrayList<PlayerObject>();
		this.red = new ArrayList<PlayerObject>();
		this.yellow = new ArrayList<PlayerObject>();
		this.green = new ArrayList<PlayerObject>();
		this.none = new ArrayList<PlayerObject>();
	}

	public String getGameName() {
		return gameName;
	}

	public String getName() {
		return name;
	}

	public ArrayList<PlayerObject> getPlayers() {
		return players;
	}

	public int getPlayersPerTeam() {
		return ppt;
	}

	public void setGameState(int gameState) {
		GameState = gameState;
	}

	public int getTeams() {
		return teams;
	}

	public void addPlayer(PlayerObject playerObject) {
		playerObject.ready();
		this.players.add(playerObject);
		playersOn += 1;
		String team = "§1Team";
		if (this.blue.size() >= ppt) {
			if (this.red.size() >= ppt) {
				if (this.green.size() >= ppt) {
					this.yellow.add(playerObject);
					team = ChatColor.YELLOW + "Yellow";
				} else {
					this.green.add(playerObject);
					team = ChatColor.GREEN + "Green";
				}
			} else {
				this.red.add(playerObject);
				team = ChatColor.RED + "Red";
			}
		} else {
			this.blue.add(playerObject);
			team = ChatColor.BLUE + "Blue";
		}
		if (playersOn >= playersToStart) {
			setGameState(1);
			// runGameStage1();
		}
		for (PlayerObject p : players) {
			p.getPlayer().sendMessage(
					Main.PREFIX + "§8>> §7" + p.getPlayer().getDisplayName() + " §7hat das Spiel betreten §8(§7"+playersOn+"§8/§7"+playersToStart+"§8)");
			p.getPlayer().sendMessage(Main.PREFIX + team + " §7" + p.getPlayer().getDisplayName() + " §7hat das Team "
					+ team + " §7betreten");
			p.getPlayer().setDisplayName("§1" + p.getPlayer().getName() + "§r");
		}
	}

	public void removePlayer(PlayerObject playerObject) {
		playerObject.ready();
		players.remove(playerObject);
		playersOn -= 1;
		for (PlayerObject obj : none) {
			if (obj == playerObject)
				none.remove(obj);
		}
		for (PlayerObject obj : blue) {
			if (obj == playerObject)
				blue.remove(obj);
		}
		for (PlayerObject obj : red) {
			if (obj == playerObject)
				red.remove(obj);
		}
		for (PlayerObject obj : green) {
			if (obj == playerObject)
				green.remove(obj);
		}
		for (PlayerObject obj : yellow) {
			if (obj == playerObject)
				yellow.remove(obj);
		}
		for (PlayerObject obj : players) {
			obj.getPlayer().sendMessage(
					Main.PREFIX + "§8>> §7" + obj.getPlayer().getDisplayName() + " §7hat das Spiel verlassen §8(§7"+playersOn+"§8/§7"+playersToStart+"§8)");
		}

	}

	public void end(Main main) {
		GameState = 3;
	}

	public int getGameState() {
		return GameState;
	}

	public Map getMap() {
		return map;
	}

	public int getPlayersOn() {
		return playersOn;
	}

	public void runGameStage1() {
		for (PlayerObject pl : blue) {
			pl.getPlayer().teleport(getMap().getMapSpawnForTeam(0));
		}
		for (PlayerObject pl : red) {
			pl.getPlayer().teleport(getMap().getMapSpawnForTeam(1));
		}
		for (PlayerObject pl : green) {
			pl.getPlayer().teleport(getMap().getMapSpawnForTeam(2));
		}
		for (PlayerObject pl : yellow) {
			pl.getPlayer().teleport(getMap().getMapSpawnForTeam(3));
		}

	}

}
