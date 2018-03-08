package me.xiroc.servermanager.main;

import me.xiroc.servermanager.listener.JoinEvent;
import me.xiroc.servermanager.listener.Listeners;
import me.xiroc.servermanager.listener.RealJoinEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ServerManager extends JavaPlugin {

	public boolean join;
	public static String modt = "§4DarkStar \n+" + ChatColor.BOLD + ChatColor.BLUE + "+Survival";
	private int modtState;
	private int maxPlayers;

	private String modt1;
	private String modt2;
	private String modt3;// modt1;
	private String modt4;// modt2;

	ArrayList<String> used = new ArrayList<>();
	public ArrayList<Player> admins = new ArrayList<>();
	public ArrayList<String> activeProtection = new ArrayList<String>();
	public ArrayList<String> build = new ArrayList<String>();

	private boolean protect;
	public boolean blockHunger;

	public void onEnable() {
		modt1 = "§4Unknown Modt(1)";
		modt2 = "§4Unknown Modt(2)";
		modt = modt1;
		protect = true;
		blockHunger = true;
		loadFiles();
		// System.out.println("[ServerManager] Motd 1:"+modt1);
		// System.out.println("[ServerManager] Motd 2:"+modt2);
		// System.out.println("[ServerManager] Motd 3:"+modt3);
		// System.out.println("[ServerManager] Motd 4:"+modt4);
		System.out.println("[ServerManager] Protection: " + protect);
		this.modtState = 0;
		this.runPingChange();
		this.join = true;
		this.registerEvents();
		this.reloadWorlds(protect);
		System.out.println("[ServerManager] Enabled ServerManager!");
	}

	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {

		} else {
			Player p = (Player) sender;

			if (cmd.getName().equalsIgnoreCase("adPrem")) {
				if (p.isOp()) {
					if (args.length == 1) {
						Player z = Bukkit.getPlayer(args[0]);
						if (z != null) {
							boolean done = addpremium(z);
							if (done) {
								p.sendMessage(ChatColor.YELLOW + "Added Premium to " + ChatColor.GREEN + z.getName()
										+ ChatColor.YELLOW + "!");
								z.sendMessage(ChatColor.GOLD + "Du bist nun ein Premium - Spieler!");

							} else {
								p.sendMessage(ChatColor.RED + "Es gab einen Fehler!");
							}

						}
					}

				} else {
					p.sendMessage(ChatColor.RED + "You must be OP!");
				}
			}
			if (cmd.getName().equalsIgnoreCase("rmPrem")) {
				if (p.isOp()) {
					if (args.length == 1) {
						Player z = Bukkit.getPlayer(args[0]);
						if (z != null) {
							boolean done = removepremium(z);
							if (done) {
								p.sendMessage(ChatColor.YELLOW + "Removed Premium from " + ChatColor.GREEN + z.getName()
										+ ChatColor.YELLOW + "!");
								z.sendMessage(ChatColor.GREEN + "Du bist nun kein Premium - Spieler mehr!");

							} else {
								p.sendMessage(ChatColor.RED + "Es gab einen Fehler!");
							}

						}
					}

				} else {
					p.sendMessage(ChatColor.RED + "You must be OP!");
				}
			}
			if (cmd.getName().equalsIgnoreCase("testforprm")) {
				if (args.length == 1) {
					String prm = args[0];
					if (p.hasPermission(prm)) {
						p.sendMessage(ChatColor.YELLOW + "You have the permission " + ChatColor.GREEN + prm
								+ ChatColor.YELLOW + "!");
					} else {
						p.sendMessage(ChatColor.RED + "You don't have the permission " + ChatColor.GREEN + prm
								+ ChatColor.RED + "!");
					}
				}
			}
			if (cmd.getName().equalsIgnoreCase("build")) {
				if (p.isOp()) {
					if (!build.contains(p.getName())) {
						build.add(p.getName());
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(ChatColor.GREEN + "Du besitzt nun " + ChatColor.BOLD + "Baurechte" + ChatColor.GREEN
								+ "!");
					} else {
						build.remove(p.getName());
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(ChatColor.RED + "Du besitzt nun " + ChatColor.BOLD + "keine Baurechte"
								+ ChatColor.RED + " mehr!");
					}
				} else {
					p.sendMessage(ChatColor.RED + "Du hast " + ChatColor.BOLD + "nicht" + ChatColor.RED
							+ " die nötigen Rechte!");
				}
			}
			if (cmd.getName().equals("kickplayer")) {
				if (p.isOp()) {
					if (args.length >= 1) {
						Player z = Bukkit.getPlayer(args[0]);
						if (z != null) {
							String msg = "";
							for (int i = 1; i < args.length; i++) {
								msg = msg + " " + args[i];
							}
							z.kickPlayer("§4<§2<§4<§5Kick§4>§2>§4> §5" + msg);

						} else {

						}
					} else {

					}
				} else {
					p.sendMessage(ChatColor.RED + "Dazu bist du nicht berechtigt!");
				}

			}
			if (cmd.getName().equalsIgnoreCase("darkstaraccount")) {
				File file = new File("plugins//Permissions//Players", p.getName() + ".yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				boolean bool = cfg.getBoolean("DarkStar.Premium");
				p.sendMessage(ChatColor.RED + "[DarkStar] " + ChatColor.GREEN + "Dein DarkStar-Account:");
				if (bool) {
					p.sendMessage(ChatColor.GOLD + "" + ChatColor.YELLOW + "----------------------------");
					p.sendMessage(ChatColor.GREEN + "Accounttyp:" + ChatColor.GOLD + "PREMIUM");
					p.sendMessage(ChatColor.GOLD + "" + ChatColor.YELLOW + "----------------------------");
				} else {
					p.sendMessage(ChatColor.GOLD + "" + ChatColor.YELLOW + "----------------------------");
					p.sendMessage(ChatColor.GREEN + "Accounttyp:" + ChatColor.GREEN + "Standard");
					p.sendMessage(ChatColor.GOLD + "" + ChatColor.YELLOW + "----------------------------");
				}

			}
			if (cmd.getName().equals("join")) {
				if (p.isOp()) {
					if (args.length == 1) {
						if (args[0].equals("false")) {
							this.join = false;
							p.sendMessage(ChatColor.GREEN + "Joinable: " + ChatColor.RED + "FALSE");
						}
						if (args[0].equals("true")) {
							this.join = true;
							p.sendMessage(ChatColor.GREEN + "Joinable: TRUE");
						}
					}
				}
			}
			if (cmd.getName().equalsIgnoreCase("servermanager")) {
				if (p.isOp()) {
					if (args.length == 2) {
						if (args[0].equalsIgnoreCase("protect")) {
							if (args[1].equalsIgnoreCase("true")) {
								protect = true;
								reloadWorlds(protect);
								p.sendMessage(ChatColor.AQUA + "Protection " + ChatColor.GREEN + "enabled.");
							}
							if (args[1].equalsIgnoreCase("false")) {
								protect = false;
								reloadWorlds(protect);
								p.sendMessage(ChatColor.AQUA + "Protection " + ChatColor.RED + "disabled.");
							}
						}
						if(args[0].equalsIgnoreCase("blockHunger")){
							if(p.isOp()){
								if(args[1].equalsIgnoreCase("true")){
									this.blockHunger = true;
									p.sendMessage(ChatColor.GREEN+"Hunger wird nun "+ChatColor.BOLD+"GEBLOCKT");
								}
								if(args[1].equalsIgnoreCase("false")){
									this.blockHunger = false;
									p.sendMessage(ChatColor.GREEN+"Hunger wird nun "+ChatColor.RED+ChatColor.BOLD+"NICHT MEHR GEBLOCKT");
								}
							}else{
								p.sendMessage(ChatColor.RED+"Du besitzt "+ChatColor.BOLD+"nicht"+ChatColor.RED+" die nötigen Rechte.");
							}
						}
						if (args[0].equalsIgnoreCase("op")) {
							String name = args[1];
							Player s = Bukkit.getPlayer(name);
							if (s != null) {
								s.setOp(true);
								s.setDisplayName("§4" + s.getName() + "§r");
								s.setPlayerListName("§4" + s.getName() + "§r");
								s.sendMessage(ChatColor.GRAY + "[" + p.getName() + ": Opped " + s.getName() + "]");
								p.sendMessage(ChatColor.GRAY + "[" + p.getName() + ": Opped " + s.getName() + "]");
							} else {
								p.sendMessage(ChatColor.RED + "Player not found!");
							}
						}
						if (args[0].equalsIgnoreCase("deop")) {
							String name = args[1];
							Player s = Bukkit.getPlayer(name);
							if (s != null) {
								s.setOp(false);
								s.setDisplayName("§a" + s.getName() + "§r");
								s.setPlayerListName("§a" + s.getName() + "§r");
								s.sendMessage(ChatColor.GRAY + "[" + p.getName() + ": Deopped " + s.getName() + "]");
								p.sendMessage(ChatColor.GRAY + "[" + p.getName() + ": Deopped " + s.getName() + "]");
							} else {
								p.sendMessage(ChatColor.RED + "Player not found!");
							}
						}
						if(args[0].equalsIgnoreCase("setmaxplayers")){
							try{
								this.maxPlayers = Integer.parseInt(args[1]);
								p.sendMessage(ChatColor.GREEN+""+ChatColor.BOLD+"Die maximale Spieleranzahl wurde auf "+maxPlayers+" gesetzt!");
							}catch(Exception e){
								p.sendMessage(ChatColor.RED+"Ein Fehler ist aufgetreten.");
							}
						}
					}
					if (args.length == 3) {
						if (args[0].equalsIgnoreCase("setProtection")) {
							if (args[1].equals("permanent")) {
								String world = args[2];
								World w = Bukkit.getWorld(world);
								if (w != null) {
									File file = new File("plugins//ServerManager//Data//Protection//config.yml");
									FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
									cfg.set(world + ".mode", "permanent");
									try {
										cfg.save(file);
									} catch (IOException e) {
										e.printStackTrace();
									}
									File file2 = new File("plugins//ServerManager//Data//Protection//worlds.yml");
									FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
									int i = cfg2.getInt("worlds");
									world = "world" + i;
									cfg2.set(world + ".world", w.getName());
									cfg2.set(world + ".mode", "permanent");
									try {
										cfg2.save(file2);
									} catch (IOException e) {
										e.printStackTrace();
									}
									p.sendMessage(ChatColor.GREEN + "Protection '" + args[1] + "' set!");
								} else {
									p.sendMessage(ChatColor.RED + "World not found.");
								}
							}
							if (args[1].equals("never")) {
								String world = args[2];
								World w = Bukkit.getWorld(world);
								if (w != null) {
									File file = new File("plugins//ServerManager//Data//Protection//config.yml");
									FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
									cfg.set(world + ".mode", "never");
									try {
										cfg.save(file);
									} catch (IOException e) {
										e.printStackTrace();
									}
									File file2 = new File("plugins//ServerManager//Data//Protection//worlds.yml");
									FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
									int i = cfg2.getInt("worlds");
									world = "world" + i;
									cfg2.set(world + ".world", w.getName());
									cfg2.set(world + ".mode", "never");
									try {
										cfg2.save(file2);
									} catch (IOException e) {
										e.printStackTrace();
									}
									p.sendMessage(ChatColor.GREEN + "Protection '" + args[1] + "' set!");
								} else {
									p.sendMessage(ChatColor.RED + "World not found.");
								}
							}
							if (args[1].equals("toggle")) {
								String world = args[2];
								World w = Bukkit.getWorld(world);
								if (w != null) {
									File file = new File("plugins//ServerManager//Data//Protection//config.yml");
									FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
									cfg.set(world + ".mode", "toggle");
									try {
										cfg.save(file);
									} catch (IOException e) {
										e.printStackTrace();
									}
									File file2 = new File("plugins//ServerManager//Data//Protection//worlds.yml");
									FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
									int i = cfg2.getInt("worlds");
									world = "world" + i;
									cfg2.set(world + ".world", w.getName());
									cfg2.set(world + ".mode", "toggle");
									try {
										cfg2.save(file2);
									} catch (IOException e) {
										e.printStackTrace();
									}
									p.sendMessage(ChatColor.GREEN + "Protection '" + args[1] + "' set!");
								} else {
									p.sendMessage(ChatColor.RED + "World not found.");
								}
							}
						}
					}
				}

			}
			if (cmd.getName().equalsIgnoreCase("report")) {
				if (args.length == 1) {
					if (!used.contains(p.getUniqueId().toString())) {
						Player t = Bukkit.getPlayer(args[0]);
						if (t != null) {
							for (Player admin : admins) {
								admin.sendMessage("§7[§4Report§7] " + ChatColor.RED + "Der Spieler §7" + t.getName()
										+ ChatColor.RED + " wurde von §7" + p.getName() + ChatColor.RED
										+ " für Hacking reportet");
							}
						} else {
							p.sendMessage(ChatColor.RED + "UUID für " + t.getName() + "nicht gefunden");
						}
					}
				} else {
					p.sendMessage(ChatColor.RED + "/report <Spieler>");
				}

			}
			if (cmd.getName().equals("view")) {
				if (p.isOp()) {
					if (args.length == 1) {
						Player t = Bukkit.getPlayer(args[0]);
						if (t != null) {
							p.teleport(t);
							p.setGameMode(GameMode.CREATIVE);
							p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 2));
							p.sendMessage("§7[§4Report§7] " + ChatColor.RED + "Teleportiere zu §7" + t.getName());
						} else {
							p.sendMessage(ChatColor.RED + "Spieler nicht gefunden");
						}
					} else if (args.length == 2) {
						if (args[0].equalsIgnoreCase("uuid")) {
						}
					} else {
						p.sendMessage(ChatColor.RED + "/view <Spieler> oder /view uuid <UUid>");
					}
				} else {
					p.sendMessage(ChatColor.RED + "Permission denied.");
				}
			}
		}

		return true;
	}

	public boolean addpremium(Player player) {

		File file = new File("plugins//Permissions//Players", player.getName() + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("DarkStar.Premium", true);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// PermissionAttachment patt = player.addAttachment(this);
		// patt.setPermission(permission, true);
		return true;
	}

	public boolean removepremium(Player player) {
		File file = new File("plugins//Permissions//Players", player.getName() + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("DarkStar.Premium", false);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public void registerEvents() {
		JoinEvent jevt = new JoinEvent(this);
		RealJoinEvent tjevt = new RealJoinEvent(this);
		Listeners listeners = new Listeners(this);
	}

	public void runPingChange() {
		int prc = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				if (modtState == 0) {
					modtState = 1;
					modt = modt2 + "\n" + modt4;
					// modt = "§4DarkStar \n" + ChatColor.GREEN + ChatColor.BOLD
					// + "Update 29.7.2016!";
				} else {
					modtState = 0;
					modt = modt1 + "\n" + modt3;
					// modt = "§4DarkStar \n" + ChatColor.BLUE + ChatColor.BOLD
					// + "Survival";
				}
			}
		}, 0, 400);
	}

	public void loadFiles() {
		// ServerConfig
		File file = new File("plugins//ServerManager//Data//Server//config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!file.exists()) {
			cfg.set("server.maxplayers", 20);
			cfg.set("server.modt1", "New Modt 1");
			cfg.set("server.modt2", "New Modt 2");
			cfg.set("server.modt3", "New Modt 3");
			cfg.set("server.modt4", "New Modt 4");
			cfg.set("server.protect", true);
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		maxPlayers = cfg.getInt("server.maxplayers");
		modt1 = cfg.getString("server.modt1");
		modt2 = cfg.getString("server.modt2");
		modt3 = cfg.getString("server.modt3");
		modt4 = cfg.getString("server.modt4");
		protect = cfg.getBoolean("server.protect");
		// Other
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public boolean isProtected() {
		return protect;
	}

	public void reloadWorlds(boolean toggle) {
		File file = new File("plugins//ServerManager//Data//Protection//worlds.yml");
		if (file.exists()) {
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			int worlds = cfg.getInt("worlds") + 1;
			for (int i = 0; i < worlds; i++) {
				String name = cfg.getString("world" + i + ".world");
				String mode = cfg.getString("world" + i + ".mode");
				if (mode.equals("permanent") || (mode.equals("toggle") && toggle)) {
					activeProtection.add(name);
				}
			}
		}
	}

}