package me.xiroc.plugin.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.xiroc.plugin.game.Game;
import me.xiroc.plugin.game.Listeners;
import me.xiroc.plugin.game.PlayerObject;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;

public class Main extends JavaPlugin {
	public ConsoleCommandSender CONSOLE = Bukkit.getConsoleSender();
	public static final String PREFIX = ChatColor.GRAY + "[" + ChatColor.GREEN + "War" + ChatColor.GRAY + "] ";
	public Game game;

	@Override
	public void onEnable() {
		Listeners listeners = new Listeners(this);
	}

	@Override
	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("fg")) {
				if (p.isOp()) {
					if (args.length == 3) {
						if (args[0].equalsIgnoreCase("setTeamSpawn")) {
							String name = args[1];
							String team = ChatColor.BLUE + "None";
							File file = new File("plugins//War//Worlds//" + name + ".yml");
							FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
							double x = p.getLocation().getX();
							double y = p.getLocation().getY();
							double z = p.getLocation().getZ();
							double pitch = p.getLocation().getPitch();
							double yaw = p.getLocation().getYaw();
							if (args[2].equals("Blue")) {
								team = ChatColor.BLUE + "Blue";
								cfg.set("game.spawns.blue.x", x);
								cfg.set("game.spawns.blue.y", y);
								cfg.set("game.spawns.blue.z", z);
								cfg.set("game.spawns.blue.pitch", pitch);
								cfg.set("game.spawns.blue.yaw", yaw);
							}
							if (args[2].equals("Red")) {
								team = ChatColor.RED + "Red";
								cfg.set("game.spawns.red.x", x);
								cfg.set("game.spawns.red.y", y);
								cfg.set("game.spawns.red.z", z);
								cfg.set("game.spawns.red.pitch", pitch);
								cfg.set("game.spawns.red.yaw", yaw);
							}
							if (args[2].equals("Green")) {
								team = ChatColor.GREEN + "Green";
								cfg.set("game.spawns.green.x", x);
								cfg.set("game.spawns.green.y", y);
								cfg.set("game.spawns.green.z", z);
								cfg.set("game.spawns.green.pitch", pitch);
								cfg.set("game.spawns.green.yaw", yaw);
							}
							if (args[2].equals("Yellow")) {
								team = ChatColor.YELLOW + "Yellow";
								cfg.set("game.spawns.yellow.x", x);
								cfg.set("game.spawns.yellow.y", y);
								cfg.set("game.spawns.yellow.z", z);
								cfg.set("game.spawns.yellow.pitch", pitch);
								cfg.set("game.spawns.yellow.yaw", yaw);
							} else {

							}
							try {
								cfg.save(file);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(PREFIX + ChatColor.GREEN + "Spawn für Team " + team + ChatColor.GREEN
									+ " gesetzt!");
						}
						if (args[0].equalsIgnoreCase("startGame")) {
							p.sendMessage(PREFIX + ChatColor.GREEN + "Starting game...");
							String name = args[2];
							String gameName = args[1];
							this.game = new Game(name, gameName);
							p.sendMessage(PREFIX + ChatColor.GREEN + "Started game '§g" + name + "§a'[Map=§6" + gameName
									+ "§a]");
							IChatBaseComponent chat = ChatSerializer.a(
									"{\"text\":\"§7Ein War-Spiel wurde gestartet - \",\"extra\":[{\"text\":\"§ahier joinen\",\"hoverEvent\":{\"action\":\"show_text\", \"value\":\"§aDirekt Joinen\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/fg join\"}}]}");
							PacketPlayOutChat packet = new PacketPlayOutChat(chat);
							for (Player o : Bukkit.getOnlinePlayers()) {
								((CraftPlayer) o).getHandle().playerConnection.sendPacket(packet);
							}

						}
					}
					if (args.length == 4) {
						if (args[0].equalsIgnoreCase("addGameWorld")) {
							p.sendMessage(PREFIX + ChatColor.GREEN + "Setting up world...");
							String world = p.getWorld().getName();
							String name = args[1];
							int playersperteam = Integer.valueOf(args[2]);
							int teams = Integer.valueOf(args[3]);
							if (teams > 4)
								teams = 4;
							if (teams < 1)
								teams = 1;
							File file = new File("plugins//War//Worlds//" + name + ".yml");
							FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
							cfg.set("game.world", world);
							cfg.set("game.name", name);
							cfg.set("game.ppt", playersperteam);
							cfg.set("game.teams", teams);
							try {
								cfg.save(file);
							} catch (IOException e) {
								e.printStackTrace();
							}
							File con = new File("plugins//War//Data//WorldGameManager.yml");
							FileConfiguration wcfg = YamlConfiguration.loadConfiguration(con);
							int i = wcfg.getInt("games.count");
							i += 1;
							wcfg.set("games.count", i);
							wcfg.set("games.game" + i + ".name", name);
							wcfg.set("games.game" + i + ".world", world);
							wcfg.set("games.game" + i + ".file", file.getAbsolutePath());
							try {
								wcfg.save(con);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(PREFIX + ChatColor.GREEN + "Setup for [§6" + name + "§a/§6" + world
									+ "§a], [teams:§6" + teams + ",§aplayersperteam:§6" + playersperteam
									+ "§a] finished!");
						}
					}
					if (args.length == 2) {
						if (args[0].equalsIgnoreCase("setLobby")) {
							p.sendMessage(PREFIX + ChatColor.GREEN + "Setting Lobby...");
							File con = new File("plugins//War//Data//Lobby.yml");
							FileConfiguration wcfg = YamlConfiguration.loadConfiguration(con);
							double x = p.getLocation().getX();
							double y = p.getLocation().getY();
							double z = p.getLocation().getZ();
							double pitch = p.getLocation().getPitch();
							double yaw = p.getLocation().getYaw();
							wcfg.set("lobby.name", args[1]);
							wcfg.set("lobby.world", p.getWorld().getName());
							wcfg.set("lobby.x", x);
							wcfg.set("lobby.y", y);
							wcfg.set("lobby.z", z);
							wcfg.set("lobby.pitch", pitch);
							wcfg.set("lobby.yaw", yaw);
							try {
								wcfg.save(con);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(PREFIX + ChatColor.GREEN + "Lobby set!");

						}
						if (args[0].equalsIgnoreCase("setLobbyLeavePoint")) {
							p.sendMessage(PREFIX + ChatColor.GREEN + "Setting LobbyLeavePoint...");
							File con = new File("plugins//War//Data//Lobby.yml");
							FileConfiguration wcfg = YamlConfiguration.loadConfiguration(con);
							double x = p.getLocation().getX();
							double y = p.getLocation().getY();
							double z = p.getLocation().getZ();
							double pitch = p.getLocation().getPitch();
							double yaw = p.getLocation().getYaw();
							wcfg.set("lobby.leave.name", args[1]);
							wcfg.set("lobby.leave.world", p.getWorld().getName());
							wcfg.set("lobby.leave.x", x);
							wcfg.set("lobby.leave.y", y);
							wcfg.set("lobby.leave.z", z);
							wcfg.set("lobby.leave.pitch", pitch);
							wcfg.set("lobby.leave.yaw", yaw);
							try {
								wcfg.save(con);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(PREFIX + ChatColor.GREEN + "LobbyLeavePoint set!");

						}
					}
					if (args.length == 1) {
						// OP
						if (args[0].equalsIgnoreCase("join")) {
							if (this.game != null) {
								PlayerObject pl = new PlayerObject(p, this.game);
								if (!this.containsPlayer(pl)) {
									this.game.addPlayer(pl);
									File con = new File("plugins//War//Data//Lobby.yml");
									FileConfiguration wcfg = YamlConfiguration.loadConfiguration(con);
									String world = wcfg.getString("lobby.world");
									double x = wcfg.getDouble("lobby.x");
									double y = wcfg.getDouble("lobby.y");
									double z = wcfg.getDouble("lobby.z");
									double yaw = wcfg.getDouble("lobby.yaw");
									double pitch = wcfg.getDouble("lobby.pitch");
									Location lc = new Location(Bukkit.getWorld(world), x, y, z, (float) yaw,
											(float) pitch);
									p.teleport(lc);
								}
							}
						}
						if (args[0].equalsIgnoreCase("leave")) {
							if (this.game != null) {
								PlayerObject pl = new PlayerObject(p, this.game);
								if (this.containsPlayer(pl)) {
									this.game.removePlayer(pl);
									File con = new File("plugins//War//Data//Lobby.yml");
									FileConfiguration wcfg = YamlConfiguration.loadConfiguration(con);
									String world = wcfg.getString("lobby.leave.world");
									double x = wcfg.getDouble("lobby.leave.x");
									double y = wcfg.getDouble("lobby.leave.y");
									double z = wcfg.getDouble("lobby.leave.z");
									double yaw = wcfg.getDouble("lobby.leave.yaw");
									double pitch = wcfg.getDouble("lobby.leave.pitch");
									Location lc = new Location(Bukkit.getWorld(world), x, y, z, (float) yaw,
											(float) pitch);
									p.teleport(lc);
								}
							}
						}

					}
				} else {
					if (args.length == 1) {
						// NotOP
						if (args[0].equalsIgnoreCase("join")) {
							if (this.game != null) {
								PlayerObject pl = new PlayerObject(p, this.game);
								if (!this.containsPlayer(pl)) {
									this.game.addPlayer(pl);
									File con = new File("plugins//War//Data//Lobby.yml");
									FileConfiguration wcfg = YamlConfiguration.loadConfiguration(con);
									String world = wcfg.getString("lobby.world");
									double x = wcfg.getDouble("lobby.x");
									double y = wcfg.getDouble("lobby.y");
									double z = wcfg.getDouble("lobby.z");
									double yaw = wcfg.getDouble("lobby.yaw");
									double pitch = wcfg.getDouble("lobby.pitch");
									Location lc = new Location(Bukkit.getWorld(world), x, y, z, (float) yaw,
											(float) pitch);
									p.teleport(lc);
								}
							}

						}
						if (args[0].equalsIgnoreCase("leave")) {
							if (this.game != null) {
								PlayerObject pl = new PlayerObject(p, this.game);
								if (this.containsPlayer(pl)) {
									this.game.removePlayer(pl);
									File con = new File("plugins//War//Data//Lobby.yml");
									FileConfiguration wcfg = YamlConfiguration.loadConfiguration(con);
									String world = wcfg.getString("lobby.leave.world");
									double x = wcfg.getDouble("lobby.leave.x");
									double y = wcfg.getDouble("lobby.leave.y");
									double z = wcfg.getDouble("lobby.leave.z");
									double yaw = wcfg.getDouble("lobby.leave.yaw");
									double pitch = wcfg.getDouble("lobby.leave.pitch");
									Location lc = new Location(Bukkit.getWorld(world), x, y, z, (float) yaw,
											(float) pitch);
									p.teleport(lc);
								}
							}
						}

					}
				}
			}
		} else {

		}
		return true;
	}
	public boolean containsPlayer(PlayerObject playerObject){
		for(PlayerObject obj: this.game.getPlayers()){
			if(obj.getPlayer() == playerObject.getPlayer()){
				return true;
			}
		}
		return false;
	}

}
