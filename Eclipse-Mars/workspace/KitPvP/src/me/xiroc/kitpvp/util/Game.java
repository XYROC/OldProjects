package me.xiroc.kitpvp.util;

import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.xiroc.kitpvp.main.MainPlugin;

public class Game extends ArrayList<PlayerObject> {

	private static final long serialVersionUID = 1L;
	private int maxplayers;
	private int teams;
	private int ppt;
	private MapObject map;
	private EnumGameState gameState;
	private ArrayList<PlayerObject> blue;
	private ArrayList<PlayerObject> red;
	private ArrayList<PlayerObject> yellow;
	private ArrayList<PlayerObject> green;
	private ArrayList<PlayerObject> turquoise;
	private ArrayList<PlayerObject> pink;
	private ArrayList<PlayerObject> orange;
	private ArrayList<PlayerObject> black;
	private ArrayList<PlayerObject> white;
	private ArrayList<PlayerObject> gray;

	public Game(MapObject map, int maxplayers, int teams) {
		this.map = map;
		this.maxplayers = maxplayers;
		this.teams = teams;
		this.ppt = maxplayers / teams;
		this.gameState = EnumGameState.LOBBY;
		for (int i = 0; i < teams; i++) {
			switch (i) {
			case 0:
				blue = new ArrayList<PlayerObject>();
				break;
			case 1:
				red = new ArrayList<PlayerObject>();
				break;
			case 2:
				yellow = new ArrayList<PlayerObject>();
				break;
			case 3:
				green = new ArrayList<PlayerObject>();
				break;
			case 4:
				turquoise = new ArrayList<PlayerObject>();
				break;
			case 5:
				pink = new ArrayList<PlayerObject>();
				break;
			case 6:
				orange = new ArrayList<PlayerObject>();
				break;
			case 7:
				black = new ArrayList<PlayerObject>();
				break;
			case 8:
				white = new ArrayList<PlayerObject>();
				break;
			case 9:
				gray = new ArrayList<PlayerObject>();
				break;
			}
		}
	}

	public void autoSetTeams() {
		int ticker = 0;
		int team = 0;
		for (PlayerObject p : this) {
			switch (team) {
			case 0:
				blue.add(p);
				p.setTeam(team);
				break;
			case 1:
				red.add(p);
				p.setTeam(team);
				break;
			case 2:
				yellow.add(p);
				p.setTeam(team);
				break;
			case 3:
				green.add(p);
				p.setTeam(team);
				break;
			case 4:
				turquoise.add(p);
				p.setTeam(team);
				break;
			case 5:
				pink.add(p);
				p.setTeam(team);
				break;
			case 6:
				orange.add(p);
				p.setTeam(team);
				break;
			case 7:
				black.add(p);
				p.setTeam(team);
				break;
			case 8:
				white.add(p);
				p.setTeam(team);
				break;
			case 9:
				gray.add(p);
				p.setTeam(team);
				break;
			}
			ticker += 1;
			if (ticker >= ppt) {
				ticker = 0;
				team += 1;
			}
		}
	}

	public void teleport() {
		FileConfiguration cfg = YamlConfiguration
				.loadConfiguration(new File("plugins//KitPvP//Data//Maps//MapManager.yml"));
		Location sblue = null;
		Location sred = null;
		Location syellow = null;
		Location sgreen = null;
		Location sturqouise = null;
		Location spink = null;
		Location sorange = null;
		Location sblack = null;
		Location swhite = null;
		Location sgray = null;
		for (int i = 0; i < teams; i++) {
			int x = cfg.getInt("map." + map.getName() + ".spawn" + i + ".x");
			int y = cfg.getInt("map." + map.getName() + ".spawn" + i + ".y");
			int z = cfg.getInt("map." + map.getName() + ".spawn" + i + ".z");
			int yaw = cfg.getInt("map." + map.getName() + ".spawn" + i + ".yaw");
			int pitch = cfg.getInt("map." + map.getName() + ".spawn" + i + ".pitch");
			switch (i) {
			case 0:
				sblue = new Location(map.getWorld(), x, y, z, yaw, pitch);
				break;
			case 1:
				sred = new Location(map.getWorld(), x, y, z, yaw, pitch);
				break;
			case 2:
				syellow = new Location(map.getWorld(), x, y, z, yaw, pitch);
				break;
			case 3:
				sgreen = new Location(map.getWorld(), x, y, z, yaw, pitch);
				break;
			case 4:
				sturqouise = new Location(map.getWorld(), x, y, z, yaw, pitch);
				break;
			case 5:
				spink = new Location(map.getWorld(), x, y, z, yaw, pitch);
				break;
			case 6:
				sorange = new Location(map.getWorld(), x, y, z, yaw, pitch);
				break;
			case 7:
				sblack = new Location(map.getWorld(), x, y, z, yaw, pitch);
				break;
			case 8:
				swhite = new Location(map.getWorld(), x, y, z, yaw, pitch);
				break;
			case 9:
				sgray = new Location(map.getWorld(), x, y, z, yaw, pitch);
				break;
			}
			if (blue != null) {
				for (PlayerObject pbj : blue) {
					Player p = pbj.getPlayer();
					p.setHealth(20);
					p.setFireTicks(0);
					p.setFallDistance(0F);
					p.setFoodLevel(20);
					p.teleport(sblue);
				}
			}
			if (red != null) {
				for (PlayerObject pbj : red) {
					Player p = pbj.getPlayer();
					p.setHealth(20);
					p.setFireTicks(0);
					p.setFallDistance(0F);
					p.setFoodLevel(20);
					p.teleport(sred);
				}
			}
			if (yellow != null) {
				for (PlayerObject pbj : yellow) {
					Player p = pbj.getPlayer();
					p.setHealth(20);
					p.setFireTicks(0);
					p.setFallDistance(0F);
					p.setFoodLevel(20);
					p.teleport(syellow);
				}
			}
			if (green != null) {
				for (PlayerObject pbj : green) {
					Player p = pbj.getPlayer();
					p.setHealth(20);
					p.setFireTicks(0);
					p.setFallDistance(0F);
					p.setFoodLevel(20);
					p.teleport(sgreen);
				}
			}
			if (turquoise != null) {
				for (PlayerObject pbj : turquoise) {
					Player p = pbj.getPlayer();
					p.setHealth(20);
					p.setFireTicks(0);
					p.setFallDistance(0F);
					p.setFoodLevel(20);
					p.teleport(sturqouise);
				}
			}
			if (pink != null) {
				for (PlayerObject pbj : pink) {
					Player p = pbj.getPlayer();
					p.setHealth(20);
					p.setFireTicks(0);
					p.setFallDistance(0F);
					p.setFoodLevel(20);
					p.teleport(spink);
				}
			}
			if (orange != null) {
				for (PlayerObject pbj : orange) {
					Player p = pbj.getPlayer();
					p.setHealth(20);
					p.setFireTicks(0);
					p.setFallDistance(0F);
					p.setFoodLevel(20);
					p.teleport(sorange);
				}
			}
			if (black != null) {
				for (PlayerObject pbj : black) {
					Player p = pbj.getPlayer();
					p.setHealth(20);
					p.setFireTicks(0);
					p.setFallDistance(0F);
					p.setFoodLevel(20);
					p.teleport(sblack);
				}
			}
			if (white != null) {
				for (PlayerObject pbj : white) {
					Player p = pbj.getPlayer();
					p.setHealth(20);
					p.setFireTicks(0);
					p.setFallDistance(0F);
					p.setFoodLevel(20);
					p.teleport(swhite);
				}
			}
			if (gray != null) {
				for (PlayerObject pbj : gray) {
					Player p = pbj.getPlayer();
					p.setHealth(20);
					p.setFireTicks(0);
					p.setFallDistance(0F);
					p.setFoodLevel(20);
					p.teleport(sgray);
				}
			}
		}
	}

	public void addPlayer(Player player) {
		boolean canBeAdded = true;
		for (PlayerObject p : this) {
			if (p.getPlayer() == player) {
				canBeAdded = false;
				player.sendMessage(MainPlugin.prefix + ChatColor.RED + "Fehler '" + ChatColor.YELLOW + "0"
						+ ChatColor.RED + "' ist aufgetreten!");
				break;
			}
		}
		if(gameState != EnumGameState.LOBBY){
			canBeAdded = false;
		}
		if (canBeAdded) {
			add(new PlayerObject(player));
		}
		if(this.size() == map.getMaxPlayers()){
			this.gameState = EnumGameState.INGAME;
		}
	}

	public void removePlayer(Player player) {
		ListIterator<PlayerObject> listIreator = this.listIterator();
		listIreator.next();
		for (PlayerObject p : this) {
			if (player == p.getPlayer()) {
				listIreator.remove();
				break;
			} else {
				listIreator.next();
			}
		}
	}
	
	public EnumGameState getGameState() {
		return gameState;
	}
	
	public int getMaxplayers() {
		return maxplayers;
	}
}
