package me.xiroc.plugin.game;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class PlayerObject {

	private Player player;
	private String displayName;
	private int team;
	private Game game;

	public PlayerObject(Player player, int team, Game game) {
		if (team < game.getTeams())
			team = game.getTeams();
		if (team > 1)
			team = 1;
		this.team = team;
		this.player = player;
		this.displayName = player.getName();
		this.game = game;
	}
	public PlayerObject(Player player, Game game) {
		if (team < game.getTeams())
			team = game.getTeams();
		if (team > 1)
			team = 1;
		this.team = 0;
		this.player = player;
		this.displayName = player.getName();
		this.game = game;
	}

	public PlayerObject(Player player, int team, Game game, String displayName) {
		if (team < game.getTeams())
			team = game.getTeams();
		if (team > 1)
			team = 1;
		this.team = team;
		this.player = player;
		this.displayName = displayName;
		this.game = game;
	}
	public PlayerObject(Player player, Game game, String displayName) {
		if (team < game.getTeams())
			team = game.getTeams();
		if (team > 1)
			team = 1;
		this.team = 0;
		this.player = player;
		this.displayName = displayName;
		this.game = game;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setTeam(int team) {
		this.team = team;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public int getTeam() {
		return team;
	}

	public Player getPlayer() {
		return player;
	}
	public Game getGame() {
		return game;
	}
	
	public void ready(){
		player.setHealth(20);
		player.setFoodLevel(20);
		player.setFallDistance(0);
		player.setFireTicks(0);
		player.getInventory().clear();
		for(PotionEffect e: player.getActivePotionEffects()){
			player.removePotionEffect(e.getType());
		}
	}
	public void transferToLobby(){
		File con = new File("plugins//War//Data//Lobby.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(con);
		double x = cfg.getDouble("lobby.x");
		double y = cfg.getDouble("lobby.y");
		double z = cfg.getDouble("lobby.z");
		double pitch = cfg.getDouble("lobby.pitch");
		double yaw = cfg.getDouble("lobby.yaw");
		String world = cfg.getString("lobby.world");
		Location loc = new Location(Bukkit.getWorld(world), x, yaw, z, (float)yaw, (float)pitch);
		player.teleport(loc);
		ready();
	}

}
