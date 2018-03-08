package me.xiroc.admintools.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.yaml.snakeyaml.Yaml;

import me.xiroc.admintools.listener.ListenerPlayerJoinEvent;
import me.xiroc.admintools.listener.ListenerSettingsMain;

public class MainPlugin extends JavaPlugin {

	public Inventory inv;
	public int daysnb = 0;
	public int hoursnb = 0;
	public int minutesnb = 0;
	public int monthsnb = 0;
	public int yearsnb = 0;
	public int frday = 0;
	public int frhour = 0;
	public int frminute = 0;
	public int frmonth = 0;
	public int fryear = 0;

	public ConsoleCommandSender CONSOLE = Bukkit.getConsoleSender();

	@Override
	public void onEnable() {
		this.loadFiles();
		this.registerEvents();
		System.out.println("[AdminTools] Enabled AdminTools");
	}

	@Override
	public void onDisable() {
		System.out.println("[AdminTools] Disabled AdminTools");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if (sender instanceof Player) {
			if (cmd.getName().equals("rnick")) {
				Player p = (Player) sender;
				if (p.isOp()) {
					File nicks = new File("plugins//AdminTools//Nick", "nicks.yml");
					FileConfiguration ncfg = YamlConfiguration.loadConfiguration(nicks);

					boolean colored = ncfg.getBoolean("Nick.Colorize");

					int nickcount = ncfg.getInt("Nick.Count");
					if (nickcount > 0) {

						int randnick = new Random().nextInt(nickcount);

						if (randnick <= 0) {
							randnick = 1;
						}

						String choosednick = ncfg.getString("Nick.Nicks.nick" + randnick);

						if (colored) {
							Player n = Bukkit.getPlayer(choosednick);
							if (n != null) {
								if (n.isOp()) {
									p.setDisplayName("§4" + choosednick + "§r");
									p.setPlayerListName("§4" + choosednick + "§r");
								} else {
									p.setDisplayName("§a" + choosednick + "§r");
									p.setPlayerListName("§a" + choosednick + "§r");
								}
							} else {
								p.setDisplayName("§a" + choosednick + "§r");
								p.setPlayerListName("§a" + choosednick + "§r");
							}
						} else {
							p.setDisplayName(choosednick);
							p.setPlayerListName(choosednick);
						}

						p.sendMessage(ChatColor.GREEN + "Nick: " + ChatColor.YELLOW + choosednick);
					} else {
						p.sendMessage(ChatColor.RED + "No nicks found!");
					}

				} else {
					p.sendMessage(ChatColor.RED + "You must be OP!");
				}
			}
			if (cmd.getName().equals("nick")) {
				Player p = (Player) sender;
				if (p.isOp()) {
					File nicks = new File("plugins//AdminTools//Nick", "nicks.yml");
					FileConfiguration ncfg = YamlConfiguration.loadConfiguration(nicks);

					if (args.length == 1) {

						boolean colored = ncfg.getBoolean("Nick.Colorize");
						if (colored) {
							Player n = Bukkit.getPlayer(args[0]);
							if (n != null) {
								if (n.isOp()) {
									p.setDisplayName("§4" + args[0] + "§r");
									p.setPlayerListName("§4" + args[0] + "§r");
								} else {
									p.setDisplayName("§7" + args[0] + "§r");
									p.setPlayerListName("§7" + args[0] + "§r");
								}
							} else {
								p.setDisplayName("§7" + args[0] + "§r");
								p.setPlayerListName("§7" + args[0] + "§r");
							}
						} else {
							p.setDisplayName(args[0]);
							p.setPlayerListName(args[0]);
						}
						p.sendMessage(ChatColor.GREEN + "Nick: " + ChatColor.YELLOW + args[0]);

					} else if (args.length == 2) {
						if (args[0].equals("add")) {
							if (ncfg.contains(args[1])) {
								p.sendMessage(ChatColor.RED + "Dieser Nick existiert bereits!");
							} else {
								int i = ncfg.getInt("Nick.Count") + 1;
								ncfg.set("Nick.Nicks.nick" + i, args[1]);
								ncfg.set("Nick.Count", i);
								try {
									ncfg.save(nicks);
								} catch (IOException e) {
									e.printStackTrace();
								}
								p.sendMessage(ChatColor.GREEN + "Added Nick:" + ChatColor.YELLOW + args[1]
										+ ChatColor.GREEN + "!");
							}
						}
					}
				} else {
					p.sendMessage(ChatColor.RED + "You must be OP!");
				}
			}
			if (cmd.getName().equals("admintools")) {
				Player p = (Player) sender;
				if (p.isOp()) {
					if (args.length == 1) {
						if (args[0].equals("settings")) {
							this.inv = p.getServer().createInventory(null, 9, "Einstellungen");
							ItemStack redstone = new ItemStack(Material.REDSTONE);
							ItemStack sugar = new ItemStack(Material.SUGAR);
							ItemStack skull = new ItemStack(Material.SKULL_ITEM);
							ItemMeta skullmeta = skull.getItemMeta();
							skullmeta.setDisplayName("§aSpieler");
							skull.setItemMeta(skullmeta);

							ItemMeta redstonememeta = redstone.getItemMeta();

							redstonememeta.setDisplayName("§a");
							inv.setItem(4, skull);
							p.openInventory(inv);
						}
						if (args[0].equals("vanish")) {
							p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 10));
						}
						if (args[0].equals("fly")) {
							p.setAllowFlight(true);
							p.setFlying(true);
						}
					}
					if (args.length == 2) {
						if (args[0].equals("sfb")) {
							if (args[1].equals("Chest")) {
								p.getWorld().spawnFallingBlock(p.getLocation(), Material.CHEST, (byte) 1);
								p.sendMessage(ChatColor.GRAY + "[" + p.getName() + "]{ Object sucessfully summoned!}");
							} else if (args[1].equals("Wood")) {
								p.getWorld().spawnFallingBlock(p.getLocation(), 17, (byte) 7);
								p.sendMessage(ChatColor.GRAY + "[" + p.getName() + "]{ Object sucessfully summoned!}");
							}
						} else if (args[0].equals("disguise")) {
							// p.sendMessage(ChatColor.RED+"Unkown Command!");
							if (args[1].equals("Pig")) {

							} else {
								p.sendMessage(ChatColor.RED + "Unkown Mob!");
							}
						}
					}

				}

			}
			if (cmd.getName().equalsIgnoreCase("tban")) {
				Player p = (Player) sender;
				if (p.isOp()) {
					if (args.length == 3) {
						// Player
						String s01 = args[0];
						// Duration
						String s02 = args[1];
						// Reason
						String s03 = args[2];
						String[] s2 = s02.split("");
						Player target = Bukkit.getPlayer(s01);
						File file = new File("plugins//AdminTools//Bans", target.getUniqueId().toString() + ".yml");
						FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
						boolean permanent = false;
						int length = Integer.parseInt(s2[0]);
						int type = 1;
						if (s02.length() > 1) {
							String types = s2[1];
							if(s2[1].equalsIgnoreCase("P")){
								permanent = true;
							}
							if(!permanent){
							if (types.equalsIgnoreCase("h")) {
								type = 0;
							} else if (types.equalsIgnoreCase("d")) {
								type = 1;
							} else if (types.equalsIgnoreCase("w")) {
								type = 2;
							} else if (types.equalsIgnoreCase("m")) {
								type = 3;
							} else if (types.equalsIgnoreCase("j")) {
								type = 4;
							}
							}
						}
						if(!permanent){
						SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyy hh");
						Calendar c = Calendar.getInstance();
						c.setTime(new Date());
						switch(type){
						case 0:
							c.add(Calendar.HOUR_OF_DAY, length);
							break;
						case 1:
							c.add(Calendar.DAY_OF_WEEK, length);
							break;
						case 2:
							c.add(Calendar.DAY_OF_WEEK, length*7);
							break;
						case 3:
							c.add(Calendar.MONTH, length);
							break;
						case 4:
							c.add(Calendar.YEAR, length);
							break;
						}
						long l = c.getTimeInMillis();
						fc.set("time", l);
						}
						fc.set("type", permanent);
						fc.set("reason", Integer.parseInt(s03));
						fc.set("banned", true);
						try {
							fc.save(file);
						} catch (IOException e) {
							e.printStackTrace();
						}
						if(target != null){
							target.kickPlayer(ChatColor.RED+"Du wurdest für "+parseReason(Integer.parseInt(s03))+ChatColor.RED+" gebannt!");
						}
						p.sendMessage(ChatColor.GRAY+"Der Spieler "+ChatColor.RED+target.getName()+ChatColor.GRAY+" wurde wegen "+parseReason(Integer.parseInt(s03))+ChatColor.GRAY+" gebannt!");
					}
				} else {
					p.sendMessage(ChatColor.RED + "You're not allowed to perform this command!");
				}
			}
			if(cmd.getName().equals("unban")){
				Player p = (Player) sender;
				if(p.isOp()){
					if(args.length == 1){
						File file = new File("plugins//AdminTools//Bans",getUUID(args[0])+ ".yml");
						FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
						fc.set("banned", false);
						try {
							fc.save(file);
						} catch (IOException e) {
							e.printStackTrace();
						}
						p.sendMessage(ChatColor.GRAY+"Der Spieler "+ChatColor.RED+args[0]+ChatColor.GRAY+" wurde entbannt.");
					}
				}
			}
			if (cmd.getName().equals("now")) {
				Player p = (Player) sender;

				SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				String now = date.format(new Date());
				p.sendMessage(ChatColor.GREEN + "Datum:" + ChatColor.YELLOW + now);
			}
		}
		return true;
	}

	public void loadFiles() {
		System.out.println("[AdminTools] Loading Files");
		File nicks = new File("plugins//AdminTools//Nick", "nicks.yml");
		FileConfiguration ncfg = YamlConfiguration.loadConfiguration(nicks);
		if (!ncfg.contains("Nick.Count")) {
			ncfg.set("Nick.Count", 0);
		}
		if (!ncfg.contains("Nick.Colorize")) {
			ncfg.set("Nick.Colorize", true);
		}
		try {
			ncfg.save(nicks);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("[AdminTools] Loaded Files");
	}
	
	public String parseReason(int reason){
		switch(reason){
		case 0:
			return ChatColor.DARK_RED+"Hacking / Hack Client";
		case 1:
			return ChatColor.DARK_RED+"Chatvergehen / Beleidigung";
		case 2:
			return ChatColor.DARK_RED+"Cheating / Bugusing";
		case 3:
			return ChatColor.DARK_RED+"Scamming";
		case 4:
			return ChatColor.DARK_RED+"Drohung / Bestechung";
		case 5:
			return ChatColor.DARK_RED+"Griefing";
		case 6:
			return ChatColor.DARK_RED+"";
		}
		return ChatColor.DARK_RED+"Genereller Ban";
	}

	public void registerEvents() {
		ListenerSettingsMain lstngmin = new ListenerSettingsMain(this);
		ListenerPlayerJoinEvent lstpplj = new ListenerPlayerJoinEvent(this);
	}
	
	public String getUUID(String name){
		FileConfiguration fg = YamlConfiguration.loadConfiguration(new File("plugins//AdminTools","UUID_List.yml"));
		return fg.getString(name);
	}

}
