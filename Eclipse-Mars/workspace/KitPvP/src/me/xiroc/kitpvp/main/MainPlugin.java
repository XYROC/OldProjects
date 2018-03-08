package me.xiroc.kitpvp.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.xiroc.kitpvp.listener.ListenerFoodChangeEvent;
import me.xiroc.kitpvp.listener.ListenerKitShopClick;
import me.xiroc.kitpvp.listener.ListenerKitShopMain;
import me.xiroc.kitpvp.listener.ListenerPlayerDeathEvent;
import me.xiroc.kitpvp.util.Game;
import me.xiroc.kitpvp.util.GameManager;
import me.xiroc.kitpvp.util.GameObject;

public class MainPlugin extends JavaPlugin {

	public static final String prefix = "§7[§aKitPvP§7] ";
	public static ArrayList<GameObject> games;
	private GameManager gameManager;

	public boolean foodchange;
	public boolean healkiller;

	@Override
	public void onEnable() {
		this.gameManager = new GameManager();
		this.registerEvents();
		this.loadKits();
		this.loadConfig();
		this.foodchange = false;
		System.out.println("[KitPvP] KitPvP Enabled!");
	}

	@Override
	public void onDisable() {
		System.out.println("[KitPvP] KitPvP Disabled!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equals("kitpvp")) {
				if (args.length == 2) {
					if (args[0].equals("healafterkill")) {
						if (p.isOp()) {
							if (args[1].equals("false")) {
								this.healkiller = false;
								p.sendMessage(prefix + ChatColor.GREEN + "HealKiller auf " + ChatColor.RED + "FALSE"
										+ ChatColor.GREEN + " gesetzt!");
							} else if (args[1].equals("true")) {
								this.healkiller = true;
								p.sendMessage(prefix + ChatColor.GREEN + "HealKiller auf TRUE gesetzt!");
							} else {
								p.sendMessage(prefix + ChatColor.RED + "Bitte gib true/false ein!");
							}
						} else {
							p.sendMessage(prefix + ChatColor.RED
									+ "Du hast nicht die nötige Berechtigung, um dieses Kommando auszuführen!");
						}
					}
					if (args[0].equalsIgnoreCase("setPlayerSpawn")) {
						if (p.isOp()) {
							int nmb = Integer.valueOf(args[1]);
							FileConfiguration cfg = YamlConfiguration
									.loadConfiguration(new File("plugins//KitPvP//Data//Maps//MapManager.yml"));
							if (!cfg.getString("map." + p.getWorld().getName() + ".name").equals("")) {
								if (!(cfg.getInt("map." + p.getWorld().getName() + ".maxplayers") > nmb)) {
									cfg.set("map." + p.getWorld().getName() + ".spawn" + nmb + ".x",
											p.getLocation().getBlockX());
									cfg.set("map." + p.getWorld().getName() + ".spawn" + nmb + ".y",
											p.getLocation().getBlockY());
									cfg.set("map." + p.getWorld().getName() + ".spawn" + nmb + ".z",
											p.getLocation().getBlockZ());
									cfg.set("map." + p.getWorld().getName() + ".spawn" + nmb + ".yaw",
											p.getLocation().getYaw());
									cfg.set("map." + p.getWorld().getName() + ".spawn" + nmb + ".pitch",
											p.getLocation().getPitch());
									p.sendMessage(prefix + ChatColor.YELLOW + "Spawn" + ChatColor.YELLOW + nmb
											+ ChatColor.GREEN + " für die Map "
											+ cfg.getString(
													"map." + ChatColor.YELLOW + p.getWorld().getName() + ".name")
											+ ChatColor.GREEN + " gesetzt!");
								} else {
									p.sendMessage(prefix + ChatColor.RED + "Diese Map kann nur " + ChatColor.YELLOW
											+ nmb + ChatColor.RED + " Spawns haben!");
								}
							} else {
								p.sendMessage(prefix + ChatColor.RED
										+ "Diese Map wurde noch nicht hinzugefügt. Füge sie mit /kitpvp addworld <name> <spieleranzahl> hinzu!");
							}
						} else {
							p.sendMessage(prefix + ChatColor.RED + "Du darfst dieses Kommando nicht ausführen!");
						}
					}
				}
				if (args.length == 4) {
					if (args[0].equalsIgnoreCase("addworld")) {
						if (p.isOp()) {
							String name = args[1];
							int players = Integer.valueOf(args[2]);
							int teams = Integer.valueOf(args[1]);
							FileConfiguration cfg = YamlConfiguration
									.loadConfiguration(new File("plugins//KitPvP//Data//Maps//MapManager.yml"));
							int mapc = cfg.getInt("mapcount");
							cfg.set("mapcount", mapc+1);
							cfg.set("maps."+mapc+".world", p.getWorld().getName());
							cfg.set("maps."+mapc+".name", name);
							cfg.set("maps."+name+".world", p.getWorld().getName());
							cfg.set("maps."+name+".number", mapc);
							cfg.set("maps."+name+".maxplayers", players);
							cfg.set("maps."+name+".teams", teams);
							cfg.set("map." + p.getWorld().getName() + ".name", name);
							cfg.set("map." + p.getWorld().getName() + ".maxplayers", players);
							cfg.set("map." + p.getWorld().getName() + ".teams", teams);
							p.sendMessage(prefix + ChatColor.YELLOW + "Welt '" + ChatColor.YELLOW + name
									+ ChatColor.GREEN + "' " + "mit [" + ChatColor.YELLOW + "world="
									+ p.getWorld().getName() + ";maxplayers="
									+ cfg.getInt("map." + ChatColor.YELLOW + p.getWorld().getName() + ".maxplayers")
									+ ";teams="+teams+ChatColor.GREEN + "] hinzugefügt!");
						} else {
							p.sendMessage(prefix + ChatColor.RED + "Du darfst dieses Kommando nicht ausführen!");
						}
					}
				}
			}
			if (cmd.getName().equals("kitchest")) {
				ItemStack kitchest = new ItemStack(Material.CHEST);
				ItemMeta kitchestmeta = kitchest.getItemMeta();
				kitchestmeta.setDisplayName("§6Kits");
				kitchest.setItemMeta(kitchestmeta);
				p.getInventory().addItem(kitchest);
			}
			if (cmd.getName().equals("powerups")) {
				ItemStack kitchest = new ItemStack(Material.EMERALD);
				ItemMeta kitchestmeta = kitchest.getItemMeta();
				kitchestmeta.setDisplayName("§aPowerups");
				kitchest.setItemMeta(kitchestmeta);
				p.getInventory().addItem(kitchest);
			}
			if (cmd.getName().equals("coins")) {
				if (args.length == 3) {
					if (args[0].equals("set")) {
						if (p.isOp()) {
							Player z = Bukkit.getPlayer(args[1]);
							int coins = Integer.valueOf(args[2]);
							this.setCoins(z, coins);
							p.sendMessage(prefix + ChatColor.GREEN + "Coins von " + ChatColor.YELLOW + args[1]
									+ ChatColor.GREEN + " auf " + ChatColor.YELLOW + coins + ChatColor.GREEN
									+ " gesetzt!");
						}

					}
				}
				if (args.length == 0) {
					p.sendMessage(prefix + ChatColor.GREEN + "Du besitzt " + ChatColor.YELLOW + this.getCoins(p)
							+ ChatColor.GREEN + " Coins!");
				}
			}
			if (cmd.getName().equals("food")) {
				if (p.isOp()) {
					if (args.length == 1) {
						if (args[0].equals("true")) {
							this.foodchange = true;
							p.sendMessage(prefix + ChatColor.GREEN + "BlockFoodChange: TRUE");
						}
						if (args[0].equals("false")) {
							this.foodchange = false;
							p.sendMessage(prefix + ChatColor.GREEN + "BlockFoodChange: " + ChatColor.RED + "FALSE");
						}

					}
				}
			}
		}
		return true;
	}

	public void registerEvents() {
		ListenerKitShopMain lstshmn = new ListenerKitShopMain(this);
		ListenerKitShopClick lstshclck = new ListenerKitShopClick(this);
		ListenerFoodChangeEvent lstfdchngevt = new ListenerFoodChangeEvent(this);
		ListenerPlayerDeathEvent lstpldthevt = new ListenerPlayerDeathEvent(this);
	}

	public void loadKits() {
		File file = new File("plugins//KitPvP//Data//Kits", "Kits.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			cfg.set("Kits.Default.ID", 0);
			cfg.set("Kits.Warrior.ID", 1);
			cfg.set("Kits.Archer.ID", 2);
			cfg.set("Kits.Zombie.ID", 3);
			cfg.set("Kits.Wizard.ID", 4);
			cfg.set("Kits.Tank.ID", 5);
			cfg.set("Kits.Hunter.ID", 6);
			cfg.set("Kits.Assasin.ID", 7);

			cfg.set("Kit." + 1 + ".Cost", 300);
			cfg.set("Kit." + 2 + ".Cost", 350);
			cfg.set("Kit." + 3 + ".Cost", 300);
			cfg.set("Kit." + 4 + ".Cost", 450);
			cfg.set("Kit." + 5 + ".Cost", 950);
			cfg.set("Kit." + 6 + ".Cost", 950);
			cfg.set("Kit." + 7 + ".Cost", 500);
		}

		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getKitCost(int id) {
		File file = new File("plugins//KitPvP//Data//Kits", "Kits.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		return cfg.getInt("Kit." + id + ".Cost");
	}

	public int getCoins(Player player) {
		File file = new File("plugins//KitPvP//Player//Kits", player.getName() + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		return cfg.getInt("Player.State.Coins");
	}

	public int getUpgradeCostToLevel(int kit, int level) {
		switch (kit) {
		case 1:
			switch (level) {
			case 2:
				return 350;
			case 3:
				return 450;
			case 4:
				return 550;
			case 5:
				return 650;
			case 6:
				return 750;
			case 7:
				return 800;
			case 8:
				return 950;
			case 9:
				return 1000;
			}
		case 2:
			switch (level) {
			case 2:
				return 350;
			case 3:
				return 450;
			case 4:
				return 550;
			case 5:
				return 650;
			case 6:
				return 750;
			case 7:
				return 800;
			case 8:
				return 950;
			case 9:
				return 1000;
			}
		case 3:
			switch (level) {
			case 2:
				return 350;
			case 3:
				return 450;
			case 4:
				return 550;
			case 5:
				return 650;
			case 6:
				return 750;
			case 7:
				return 800;
			case 8:
				return 950;
			case 9:
				return 1000;
			}
		case 4:
			switch (level) {
			case 2:
				return 400;
			case 3:
				return 500;
			case 4:
				return 600;
			case 5:
				return 700;
			case 6:
				return 800;
			case 7:
				return 900;
			case 8:
				return 1000;
			case 9:
				return 1250;
			}
		case 5:
			switch (level) {
			case 2:
				return 1000;
			case 3:
				return 1100;
			case 4:
				return 1200;
			case 5:
				return 1300;
			case 6:
				return 1400;
			case 7:
				return 1500;
			case 8:
				return 1600;
			case 9:
				return 2000;
			}
		case 6:
			switch (level) {
			case 2:
				return 1000;
			case 3:
				return 1100;
			case 4:
				return 1200;
			case 5:
				return 1300;
			case 6:
				return 1400;
			case 7:
				return 1500;
			case 8:
				return 1600;
			case 9:
				return 2000;
			}
		case 7:
			switch (level) {
			case 2:
				return 350;
			case 3:
				return 450;
			case 4:
				return 550;
			case 5:
				return 650;
			case 6:
				return 750;
			case 7:
				return 800;
			case 8:
				return 950;
			case 9:
				return 1000;
			}
		case 8:
			switch (level) {
			case 2:
				return 800;
			case 3:
				return 950;
			case 4:
				return 1100;
			case 5:
				return 1250;
			case 6:
				return 1400;
			case 7:
				return 1550;
			case 8:
				return 1700;
			case 9:
				return 1850;
			}
		default:
			return 0;
		}
	}

	public void setCoins(Player player, int coins) {
		File file = new File("plugins//KitPvP//Player//Kits", player.getName() + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Player.State.Coins", coins);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadConfig() {
		File file = new File("plugins//KitPvP//Data//Settings", "settings.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			cfg.set("HealKiller", false);
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.healkiller = cfg.getBoolean("HealKiller");
	}

	public int getCurrentKit(Player player) {
		int kit = 0;
		FileConfiguration cfg = YamlConfiguration
				.loadConfiguration(new File("plugins//KitPvP//Player//" + player.getName() + ".yml"));
		kit = cfg.getInt("Player.State.currentKit");
		return kit;
	}

	public void setCurrentKit(Player player, int kit) {
		FileConfiguration cfg = YamlConfiguration
				.loadConfiguration(new File("plugins//KitPvP//Player//" + player.getName() + ".yml"));
		cfg.set("Player.State.currentKit", kit);
	}
	
	public GameManager getGameManager() {
		return gameManager;
	}
}
