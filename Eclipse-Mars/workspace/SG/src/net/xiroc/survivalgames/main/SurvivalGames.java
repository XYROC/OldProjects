package net.xiroc.survivalgames.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.xiroc.survivalgames.events.BlockBreakEvent;
import net.xiroc.survivalgames.events.BlockPlaceEvent;
import net.xiroc.survivalgames.events.EntityDamageEvent;
import net.xiroc.survivalgames.events.FoodChangeEvent;
import net.xiroc.survivalgames.events.InteractEvent;
import net.xiroc.survivalgames.events.PlayerWalkEvent;
import net.xiroc.survivalgames.events.SignChangeEvent;

public class SurvivalGames extends JavaPlugin {

	public boolean peace;
	public boolean protect;
	public boolean obsidianchest;
	public boolean blockchest;
	
	public List<Player> ingame = new ArrayList<Player>();

	public HashMap<Location, Inventory> sgchest = new HashMap<Location, Inventory>();

	public String prefix = ChatColor.GRAY + "[" + ChatColor.GOLD + "SurvivalGames" + ChatColor.GRAY + "] ";

	public void onEnable() {
		this.registerEvents();
		this.checkFiles();
		System.out.println("");
	}

	public void obDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			System.out.println("You must be a Player!");
		} else {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("peace")) {
				if (p.isOp()) {
					if (args.length == 1) {
						if (args[0].equals("true")) {
							this.peace = true;
							p.sendMessage(this.prefix + ChatColor.AQUA + "Set Peace to " + ChatColor.GREEN + "TRUE"
									+ ChatColor.AQUA + "!");
							return true;
						}
						if (args[0].equals("false")) {
							this.peace = false;
							p.sendMessage(this.prefix + ChatColor.AQUA + "Set Peace to " + ChatColor.RED + "FALSE"
									+ ChatColor.AQUA + "!");
							return true;
						}
					} else {

					}
				} else {

				}
			}
			if (cmd.getName().equalsIgnoreCase("protect")) {
				if (p.isOp()) {
					if (args.length == 1) {
						if (args[0].equals("true")) {
							this.protect = true;
							p.sendMessage(this.prefix + ChatColor.AQUA + "Set Protection to " + ChatColor.GREEN + "TRUE"
									+ ChatColor.AQUA + "!");
							return true;
						}
						if (args[0].equals("false")) {
							this.protect = false;
							p.sendMessage(this.prefix + ChatColor.AQUA + "Set Protection to " + ChatColor.RED + "FALSE"
									+ ChatColor.AQUA + "!");
							return true;
						}
					} else {

					}
				} else {

				}
			}
			if (cmd.getName().equalsIgnoreCase("sgchest")) {
				if (p.isOp()) {
					if (args.length == 1) {
						if (args[0].equals("true")) {
							this.obsidianchest = true;
							p.sendMessage(this.prefix + ChatColor.AQUA + "Set SurvivalGamesChest to " + ChatColor.GREEN
									+ "TRUE" + ChatColor.AQUA + "!");
							return true;
						}
						if (args[0].equals("false")) {
							this.obsidianchest = false;
							p.sendMessage(this.prefix + ChatColor.AQUA + "Set SurvivalGamesChest to " + ChatColor.RED
									+ "FALSE" + ChatColor.AQUA + "!");
							return true;
						}
					} else {

					}
				} else {

				}
			}
			if (cmd.getName().equalsIgnoreCase("sg")) {
				if (p.isOp()) {
					if (args.length == 1) {
						if (args[0].equals("tools")) {

							ItemStack start = new ItemStack(Material.DIAMOND);
							ItemMeta startMeta = start.getItemMeta();
							startMeta.setDisplayName("§6S§at§6a§ar§6t");
							start.setItemMeta(startMeta);
							p.getInventory().addItem(start);
							if (p.getInventory().contains(start)) {
								p.getInventory().setItem(0, start);
							}

						}
						if(args[0].equals("setlobbyleavespawn")){
							
							File theworld = new File("plugins//SurvivalGames//Worlds", "LobbyLeave" + ".yml");
								FileConfiguration cfg = YamlConfiguration.loadConfiguration(theworld);
								
								double x = p.getLocation().getX();
								double y = p.getLocation().getY();
								double z = p.getLocation().getZ();
								
								cfg.set("Game.Lobbyleavepoint.x", x);
								cfg.set("Game.Lobbyleavepoint.y", y);
								cfg.set("Game.Lobbyleavepoint.z", z);
								cfg.set("Game.Lobbyleavepoint.world", p.getWorld().getName());
								
								try {
									cfg.save(theworld);
								} catch (IOException e) {
									e.printStackTrace();
								}
								
								p.sendMessage(prefix+ChatColor.GREEN+"Lobbyverlasspunkt gesetzt!");
							
						}

					}
					if (args.length == 2) {

						if (args[0].equalsIgnoreCase("setNewWorld")) {
							String worldname = p.getWorld().getName();
							int size = Integer.valueOf(args[1]);
							if (size > 1 || size < 64) {
								File world = new File("plugins//SurvivalGames//Worlds", worldname + ".yml");
								if (world.exists()) {
									p.sendMessage(prefix + ChatColor.RED + "Diese Welt gibt es bereits!");
								} else {
									FileConfiguration fcfg = YamlConfiguration.loadConfiguration(world);
									fcfg.set("World.Size", size);
									try {
										fcfg.save(world);
									} catch (IOException e) {
										e.printStackTrace();
									}
									p.sendMessage(prefix + ChatColor.GREEN + "Map " + ChatColor.YELLOW + worldname
											+ ChatColor.GREEN + " Erfolgreich hinzugefügt! Größe: " + ChatColor.YELLOW
											+ size);
								}
							} else {
								p.sendMessage(prefix + ChatColor.RED
										+ "Zu wenige oder zu viele Spieler! Es müssen mindestens 2 und höchstens 64 sein! ");
							}

						}
						if (args[0].equalsIgnoreCase("setSpawn")) {
							String world = p.getWorld().getName();
							int number = Integer.valueOf(args[1]);
							File theworld = new File("plugins//SurvivalGames//Worlds", world + ".yml");
							if (theworld.exists()) {
								FileConfiguration cfg = YamlConfiguration.loadConfiguration(theworld);
								int max = cfg.getInt("World.Size");
								if (number > max || number < 1) {
									p.sendMessage(
											prefix + ChatColor.RED + "Zu viele oder zu wenige Spieler! Höchstens: "
													+ ChatColor.YELLOW + max + ChatColor.RED + ", Mindestens: "
													+ ChatColor.YELLOW + "2" + ChatColor.RED + "!");
								} else {
									Location loc = p.getLocation();
									
									double x = loc.getX();
									double y = loc.getY();
									double z = loc.getZ();
									
									cfg.set("World.Spawn.Spawn"+number+".x",x );
									cfg.set("World.Spawn.Spawn"+number+".y",y );
									cfg.set("World.Spawn.Spawn"+number+".z",z );
									cfg.set("World.Spawn.Spawn"+number+".world", p.getWorld().getName());
									
									try {
										cfg.save(theworld);
									} catch (IOException e) {
										e.printStackTrace();
									}
									
									p.sendMessage(prefix+ChatColor.GREEN+"Spawn "+ChatColor.YELLOW+number+ChatColor.GREEN+" Erfolgreich gesetzt!");
								}
							} else {
								p.sendMessage(prefix + ChatColor.RED + "Diese Map existiert nicht!");
							}

						}
						if(args[0].equalsIgnoreCase("setLobby")){
							String world = args[1];
							File theworld = new File("plugins//SurvivalGames//Worlds", world + ".yml");
							if(theworld.exists()){
								FileConfiguration cfg = YamlConfiguration.loadConfiguration(theworld);
								Location loc = p.getLocation();
								
								double x = loc.getX();
								double y = loc.getY();
								double z = loc.getZ();
								
								cfg.set("World.Lobby.x",x );
								cfg.set("World.Lobby.y",y );
								cfg.set("World.Lobby.z",z );
								
								cfg.set("World.Lobby.World", p.getWorld().getName());
								
								try {
									cfg.save(theworld);
								} catch (IOException e) {
									e.printStackTrace();
								}
								
								p.sendMessage(prefix+ChatColor.GREEN+"Lobby für "+ChatColor.YELLOW+world+ChatColor.GREEN+" Erfolgreich gesetzt!");
							}else{
								p.sendMessage(prefix+ChatColor.RED+"Diese Map existiert nicht!");
							}
						}
						
						
					}
					if(args.length == 3){
						if (args[0].equals("setCountdownstart")) {
							String world = args[1];
							int start = Integer.valueOf(args[2]);
							File theworld = new File("plugins//SurvivalGames//Worlds", world + ".yml");
							FileConfiguration cfg = YamlConfiguration.loadConfiguration(theworld);
							int size = cfg.getInt("World.Size");
							if(start > size || start < 1){
								p.sendMessage(prefix+ChatColor.RED+"Bitte wähle eine geeignete Zahl! (Nicht unter 1, Nicht über dem Spielerlimit)");
							}else{
								cfg.set("Game.Countdownstart", start);
								try {
									cfg.save(theworld);
								} catch (IOException e) {
									e.printStackTrace();
								}
								p.sendMessage(prefix+ChatColor.GREEN+"Countdownstart auf "+ChatColor.YELLOW+start+ChatColor.GREEN+" gesetzt!");
							}
						}
					}
				} else {
					p.sendMessage(this.prefix + ChatColor.RED + "Du darfst dieses Kommando nicht ausführen!");
				}
			}
		}

		return true;

	}

	public void registerEvents() {
		InteractEvent ivt = new InteractEvent(this);
		BlockBreakEvent brck = new BlockBreakEvent(this);
		BlockPlaceEvent bplc = new BlockPlaceEvent(this);
		FoodChangeEvent fch = new FoodChangeEvent(this);
		EntityDamageEvent edmg = new EntityDamageEvent(this);
		SignChangeEvent sgnchgect = new SignChangeEvent(this);
		PlayerWalkEvent plwlkevt = new PlayerWalkEvent(this);
		
	}
	

	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	public void checkFiles() {
		File config = new File("plugins//SurvivalGames//Config//", "config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(config);
		if (!cfg.contains("SurvivalGames.peace")) {
			cfg.set("SurvivalGames.peace", true);
		}
		if (!cfg.contains("SurvivalGames.protect")) {
			cfg.set("SurvivalGames.protect", true);
		}
		if (cfg.contains("SurvivalGames.survivalgameschest")) {
			cfg.set("SurvivalGames.survivalgameschest", false);
		}
		this.peace = 
		cfg.getBoolean("SurvivalGames.peace");
		this.protect = 
		cfg.getBoolean("SurvivalGames.protect");
		this.obsidianchest = 
		cfg.getBoolean("SurvivalGames.survivalgameschest");
		try {
			cfg.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}