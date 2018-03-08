package me.xiroc.warp.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		this.checkForFiles();
		System.out.println("[Warp] Enabled Warp!");
	}

	@Override
	public void onDisable() {
		System.out.println("[Warp] Disabled Warp!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equals("warp")) {
				if(args.length == 1){
					if (args[0].equals("list")){
						File w2 = new File("plugins//Warp//Warps", p.getUniqueId().toString()+".yml");
						FileConfiguration c = YamlConfiguration.loadConfiguration(w2);
						int warps = c.getInt("warps");
						if(warps <= 0){
							p.sendMessage(ChatColor.RED+"Du besitzt keine Warps!");
							return true;
						}
						p.sendMessage(ChatColor.GREEN+"Du besitzt "+ChatColor.YELLOW+warps+ChatColor.GREEN+" Warp(s).");
						for(int i = 1; i < warps+1; i++){
							String wp = ChatColor.RED+"nein";
							if(c.getBoolean("warp_"+i+".public")) wp = ChatColor.DARK_GREEN+"ja";
							p.sendMessage(ChatColor.GREEN+"- "+ChatColor.YELLOW+c.getString("warp_"+i+".name")+ChatColor.GREEN+" (Öffentlich: "+wp+ChatColor.GREEN+")");
						}
					}
				}
				if (args.length == 2) {
					if (args[0].equals("set")) {
						File warps = new File("plugins//Warp//Warps", "warps.yml");
						FileConfiguration cfg = YamlConfiguration.loadConfiguration(warps);
						String name = args[1];
						String pname = p.getName();
						if (cfg.contains(pname + ".warps." + name)) {
							p.sendMessage(ChatColor.RED + "Dieser Warp existiert Bereits!");
						} else {
							double x = p.getLocation().getX();
							double y = p.getLocation().getY();
							double z = p.getLocation().getZ();

							String world = p.getWorld().getName();

							cfg.set(pname + ".warps." + name + ".x", x);
							cfg.set(pname + ".warps." + name + ".y", y);
							cfg.set(pname + ".warps." + name + ".z", z);

							cfg.set(pname + ".warps." + name + ".world", world);

							cfg.set(pname + ".warps." + name + ".public", false);

							try {
								cfg.save(warps);
							} catch (IOException e) {
								e.printStackTrace();
							}
							
							File w2 = new File("plugins//Warp//Warps", p.getUniqueId().toString()+".yml");
							FileConfiguration c = YamlConfiguration.loadConfiguration(w2);
							int i = 0;
							i = c.getInt("warps");
							i++;
							c.set("warps", i);
							c.set("warp_"+i+".name", name);
							c.set("warp_"+i+".x", x);
							c.set("warp_"+i+".y", y);
							c.set("warp_"+i+".z", z);
							c.set("warp_"+i+".world", world);
							c.set("warp_"+i+".public", false);
							try {
								c.save(w2);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(
									ChatColor.GREEN + "Warp " + ChatColor.YELLOW + name + ChatColor.GREEN + " set!");
						}
					} else if (args[0].equals("tp")) {
						File warps = new File("plugins//Warp//Warps", "warps.yml");
						FileConfiguration cfg = YamlConfiguration.loadConfiguration(warps);
						String name = args[1];
						String pname = p.getName();
						if (!cfg.contains(pname + ".warps." + name)) {
							p.sendMessage(ChatColor.RED + "Dieser Warp existiert nicht!");
						} else {
							

							String world = cfg.getString(pname + ".warps." + name + ".world");
							if(Bukkit.getWorld(world) != null){
								double x = cfg.getDouble(pname + ".warps." + name + ".x");
								double y = cfg.getDouble(pname + ".warps." + name + ".y");
								double z = cfg.getDouble(pname + ".warps." + name + ".z");
								
								if(y == 0){
									p.sendMessage(ChatColor.RED+"Ein Fehler ist aufgetreten. Bitte versuche es erneut!");
									return true;
								}
								
								Location loc = new Location(Bukkit.getWorld(world), x, y, z);

								p.teleport(loc);

								p.sendMessage(ChatColor.GREEN + "Warping...");
							}else{
								p.sendMessage(ChatColor.RED+"Welt nicht gefunden!");
							}

							
						}
					} else if (args[0].equals("publish")) {
						File warps = new File("plugins//Warp//Warps", "warps.yml");
						FileConfiguration cfg = YamlConfiguration.loadConfiguration(warps);
						String name = args[1];
						String pname = p.getName();
						if (!cfg.contains(pname + ".warps." + name)) {
							p.sendMessage(ChatColor.RED + "Dieser Warp existiert nicht!");
						} else {
							cfg.set(pname + ".warps." + name + ".public", true);
							try {
								cfg.save(warps);
							} catch (IOException e) {
								e.printStackTrace();
							}
							File w2 = new File("plugins//Warp//Warps", p.getUniqueId().toString()+".yml");
							FileConfiguration c = YamlConfiguration.loadConfiguration(w2);
							int w = 0;
							w = c.getInt("warps");
							for(int i = 1; i < w+1; i++){
								if(c.getString("warp_"+i+".name").equals(name)){
									c.set("warp_"+i+".public", true);
									break;
								}
							}
							try {
								c.save(w2);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(ChatColor.GREEN + "Der Warp " + ChatColor.YELLOW + name + ChatColor.GREEN
									+ " ist nun öffentlich!");
						}
					} else if (args[0].equals("unpublish")) {
						File warps = new File("plugins//Warp//Warps", "warps.yml");
						FileConfiguration cfg = YamlConfiguration.loadConfiguration(warps);
						String name = args[1];
						String pname = p.getName();
						if (!cfg.contains(pname + ".warps." + name)) {
							p.sendMessage(ChatColor.RED + "Dieser Warp existiert nicht!");
						} else {
							cfg.set(pname + ".warps." + name + ".public", false);
							try {
								cfg.save(warps);
							} catch (IOException e) {
								e.printStackTrace();
							}
							File w2 = new File("plugins//Warp//Warps", p.getUniqueId().toString()+".yml");
							FileConfiguration c = YamlConfiguration.loadConfiguration(w2);
							int w = 0;
							w = c.getInt("warps");
							for(int i = 1; i < w+1; i++){
								if(c.getString("warp_"+i+".name").equals(name)){
									c.set("warp_"+i+".public", false);
									break;
								}
							}
							try {
								c.save(w2);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(ChatColor.RED + "Der Warp " + ChatColor.YELLOW + name + ChatColor.RED
									+ " ist nun nicht mehr öffentlich!");
						}
					} else{
						
					}
				} else if (args.length == 3) {
					if (args[0].equals("tp")) {
						String warp = args[2];
						String player = args[1];
						File warps = new File("plugins//Warp//Warps", "warps.yml");
						FileConfiguration cfg = YamlConfiguration.loadConfiguration(warps);
						if (!cfg.contains(player + ".warps." + warp)) {
							p.sendMessage(ChatColor.RED + "Dieser Warp existiert nicht!");
						} else {
							if (!cfg.contains(player + ".warps." + warp + ".public")) {
								cfg.set(player + ".warps." + warp + ".public", false);
								p.sendMessage(ChatColor.RED + "Dieser Warp existiert nicht!");
							} else {
								boolean publ = cfg.getBoolean(player + ".warps." + warp + ".public");
								if (publ) {
									String name = warp;
									double x = cfg.getDouble(player + ".warps." + name + ".x");
									double y = cfg.getDouble(player + ".warps." + name + ".y");
									double z = cfg.getDouble(player + ".warps." + name + ".z");
									
									if(y == 0){
										p.sendMessage(ChatColor.RED+"Ein Fehler ist aufgetreten. Bitte versuche es erneut!");
										return true;
									}

									String world = cfg.getString(player + ".warps." + name + ".world");

									Location loc = new Location(Bukkit.getWorld(world), x, y, z);

									p.teleport(loc);

									p.sendMessage(ChatColor.GREEN + "Warping to " + ChatColor.YELLOW + player + "'s"
											+ ChatColor.GREEN + " Warp " + ChatColor.YELLOW + name + ChatColor.GREEN
											+ " !");
								} else {
									p.sendMessage(ChatColor.RED + "Dieser Warp existiert nicht!");
								}
							}
						}
					}

				} else if (args.length == 4) {
					if (args[0].equals("tp")) {
						String warp = args[2];
						String player = args[1];
						File warps = new File("plugins//Warp//Warps", "warps.yml");
						FileConfiguration cfg = YamlConfiguration.loadConfiguration(warps);
						if (!cfg.contains(player + ".warps." + warp)) {
							p.sendMessage(ChatColor.RED + "Dieser Warp existiert nicht!");
						} else {
							if (!cfg.contains(player + ".warps." + warp)) {
								p.sendMessage(ChatColor.RED + "Dieser Warp existiert nicht!");
							} else {
								if (args[3].equals("op")) {
									if (p.isOp()) {
										String name = warp;
										double x = cfg.getDouble(player + ".warps." + name + ".x");
										double y = cfg.getDouble(player + ".warps." + name + ".y");
										double z = cfg.getDouble(player + ".warps." + name + ".z");
										
										if(y == 0){
											p.sendMessage(ChatColor.RED+"Ein Fehler ist aufgetreten. Bitte versuche es erneut!");
											return true;
										}

										String world = cfg.getString(player + ".warps." + name + ".world");

										Location loc = new Location(Bukkit.getWorld(world), x, y, z);

										p.teleport(loc);

										p.sendMessage(ChatColor.GREEN + "Warping to " + ChatColor.YELLOW + player + "'s"
												+ ChatColor.GREEN + " Warp " + ChatColor.YELLOW + name + ChatColor.GREEN
												+ "!");
									} else {
										p.sendMessage(ChatColor.RED + "Unkown Command!");
									}

								}
							}
						}
					}
					if (args[0].equals("debug")) {
						if (p.isOp()) {
							if (args[1].equals("tp")) {
								p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loading Yaml-File 'warps.yml'");
								File warps = new File("plugins//Warp//Warps", "warps.yml");
								p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loaded Yaml-File 'warps.yml'");
								p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loading Yaml-Configuration for 'warps.yml'");
								FileConfiguration cfg = YamlConfiguration.loadConfiguration(warps);
								p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loaded Yaml-Configuration 'warps.yml'");
								p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loading Warp-Name 'name' (args[1])");
								String name = args[2];
								p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loaded Warp-Name 'name' (args[1])");
								p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loading Player-Name 'name' (p.getName())");
								String pname = p.getName();
								p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loaded Player-Name 'name' (p.getName())");
								p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Checking wether this warp exists...");
								if (!cfg.contains(pname + ".warps." + name)) {
									p.sendMessage(ChatColor.RED + "Dieser Warp existiert nicht!");
								} else {
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Checking returned true. Continuing..");
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loading x...");
									double x = cfg.getDouble(pname + ".warps." + name + ".x");
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loaded x...");
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loading y...");
									double y = cfg.getDouble(pname + ".warps." + name + ".y");
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loaded y...");
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loading z...");
									double z = cfg.getDouble(pname + ".warps." + name + ".z");
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loaded z...");
									if(y == 0){
										p.sendMessage(ChatColor.RED+"Ein Fehler ist aufgetreten. Bitte versuche es erneut! (y = 0)");
										return true;
									}
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loading world...");
									String world = cfg.getString(pname + ".warps." + name + ".world");
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Loaded world...");
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Creating Location 'loc '(Location loc = new Location(Bukkit.getWorld(world), x, y, z);) ...");
									Location loc = new Location(Bukkit.getWorld(world), x, y, z);
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Created Location 'loc '(Location loc = new Location(Bukkit.getWorld(world), x, y, z);) ...");
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Teleporting Player 'p' (p.teleport(loc); ...");
									p.teleport(loc);
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Teleported Player 'p' (p.teleport(loc); ...");
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Sending Message to Player 'p'...");
									p.sendMessage(ChatColor.GREEN + "Warping...");
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Sent Message to Player 'p'...");
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Trying to save File 'warps.yml'...");
									try {
										cfg.save(warps);
									} catch (IOException e) {
										StackTraceElement[] stackTrace = e.getStackTrace();
										p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Exeption: "+ChatColor.GRAY+stackTrace.toString());
									}
									p.sendMessage(ChatColor.RED+"[Warp] [DEBUG] "+ChatColor.GRAY+"Saved File 'warps.yml'...");
								}
							}
						}

					}
				}
			}
		}

		return true;
	}

	public void checkForFiles() {
		System.out.println("[Warp] Checking files...");
		File warps = new File("plugins//Warp//Warps", "warps.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(warps);
		try {
			cfg.save(warps);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sayHi(Player player){
		player.sendMessage("hi");
	}
}
