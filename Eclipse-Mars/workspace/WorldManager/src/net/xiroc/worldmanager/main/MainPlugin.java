package net.xiroc.worldmanager.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.World.Environment;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {

	File worlds = new File("plugins//WorldManager//Data", "worlds.yml");

	FileConfiguration wcfg = YamlConfiguration.loadConfiguration(worlds);

	public void loadWorlds() {
		System.out.println("[WorldManager] Loading Worlds... This may takes a while...");
		int worldcount = wcfg.getInt("Manager.Worlds");
		String world = "Worlds.ldworld";
		if (!wcfg.contains("Manager.Worlds")) {
			wcfg.set("Manager.Worlds", 0);
			System.out.println("[Worldmanager] Worldfile is corrupt! Correcting it... No other worlds will be loaded!");
		}
		if (worldcount <= 0) {
			System.out.println("[Worldmanager] There are no Worlds to load!");
		} else {
			for (int i = 0; i < worldcount + 1; i++) {
				if (i == 0) {
					i = 1;
				}
				String name = world + i;
				String worldnameprev = name + ".name";
				String worldtypeprev = name + ".type";
				String worldname = wcfg.getString(worldnameprev);
				String worldtype = wcfg.getString(worldtypeprev);
				System.out.println("[WorldManager] Loading World:" + worldname + " Type:" + worldtype);
				if (worldtype.equals("normal")) {
					WorldCreator c = (WorldCreator) WorldCreator.name(worldname).environment(Environment.NORMAL)
							.type(WorldType.AMPLIFIED);
					Bukkit.createWorld(c);
				}
				if (worldtype.equals("end")) {
					WorldCreator c = (WorldCreator) WorldCreator.name(worldname).environment(Environment.THE_END)
							.type(WorldType.AMPLIFIED);
					Bukkit.createWorld(c);
				}
				if (worldtype.equals("nether")) {
					WorldCreator c = (WorldCreator) WorldCreator.name(worldname).environment(Environment.NETHER)
							.type(WorldType.AMPLIFIED);
					Bukkit.createWorld(c);
				}
			}
			System.out.println("[WorldManager] Loaded Worlds!");
		}
		try {
			wcfg.save(worlds);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onEnable() {
		System.out.println("[WorldManager] Loaded WorldManager!");
		this.loadWorlds();
	}

	@Override
	public void onDisable() {
		System.out.println("[WorldManager] Unloaded WorldManager!");

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {

		} else {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("wmimport")) {
				if (args.length == 2) {
					if (args[1].equals("normal")) {
						p.sendMessage("Importiere " + ChatColor.GREEN + args[0] + ChatColor.WHITE + "! Bitte warte...");
						WorldCreator c = (WorldCreator) WorldCreator.name(args[0]).environment(Environment.NORMAL)
								.type(WorldType.AMPLIFIED);
						Bukkit.createWorld(c);
						p.sendMessage(ChatColor.GREEN + "Fertig!");

					}
					if (args[1].equals("nether")) {
						p.sendMessage("Importiere " + ChatColor.GREEN + args[0] + ChatColor.WHITE + "! Bitte warte...");
						WorldCreator c = (WorldCreator) WorldCreator.name(args[0]).environment(Environment.NETHER)
								.type(WorldType.AMPLIFIED);
						Bukkit.createWorld(c);
						p.sendMessage(ChatColor.GREEN + "Fertig!");

					}
					if (args[1].equals("end")) {
						p.sendMessage("Importiere " + ChatColor.GREEN + args[0] + ChatColor.WHITE + "! Bitte warte...");
						WorldCreator c = (WorldCreator) WorldCreator.name(args[0]).environment(Environment.THE_END)
								.type(WorldType.AMPLIFIED);
						Bukkit.createWorld(c);
						p.sendMessage(ChatColor.GREEN + "Fertig!");
					}

				} else if (args.length == 3) {
					if (args[2].equals("reload")) {
						if (args[1].equals("normal")) {
							p.sendMessage("Importiere " + ChatColor.GREEN + args[0] + ChatColor.WHITE
									+ "(Reload Modus) Bitte warte");
							WorldCreator c = (WorldCreator) WorldCreator.name(args[0]).environment(Environment.NORMAL)
									.type(WorldType.AMPLIFIED);
							Bukkit.createWorld(c);
							int count = wcfg.getInt("Manager.Worlds");
							int count1 = count + 1;
							wcfg.set("Worlds.ldworld" + count1 + ".name", args[0]);
							wcfg.set("Worlds.ldworld" + count1 + ".type", "normal");
							wcfg.set("Manager.Worlds", count + 1);
							try {
								wcfg.save(worlds);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(ChatColor.GREEN + "Fertig!");

						}
						if (args[1].equals("nether")) {
							p.sendMessage("Importiere " + ChatColor.GREEN + args[0] + ChatColor.WHITE
									+ "(Reload Modus) Bitte warte...");
							WorldCreator c = (WorldCreator) WorldCreator.name(args[0]).environment(Environment.NETHER)
									.type(WorldType.AMPLIFIED);
							Bukkit.createWorld(c);
							int count = wcfg.getInt("Manager.Worlds");
							int count1 = count + 1;
							wcfg.set("Worlds.ldworld" + count1 + ".name", args[0]);
							wcfg.set("Worlds.ldworld" + count1 + ".type", "nether");
							wcfg.set("Manager.Worlds", count + 1);
							try {
								wcfg.save(worlds);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(ChatColor.GREEN + "Fertig!");

						}
						if (args[1].equals("end")) {
							p.sendMessage("Importiere" + ChatColor.GREEN + args[0] + ChatColor.WHITE
									+ "(Reload Modus) Bitte warte...");
							WorldCreator c = (WorldCreator) WorldCreator.name(args[0]).environment(Environment.THE_END)
									.type(WorldType.AMPLIFIED);
							Bukkit.createWorld(c);
							int count = wcfg.getInt("Manager.Worlds");
							int count1 = count + 1;
							wcfg.set("Worlds.ldworld" + count1 + ".name", args[0]);
							wcfg.set("Worlds.ldworld" + count1 + ".type", "end");
							wcfg.set("Manager.Worlds", count + 1);
							try {
								wcfg.save(worlds);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(ChatColor.GREEN + "Fertig!");
						}
					}
				} else {

					p.sendMessage(ChatColor.GOLD + "Das " + ChatColor.RED + ChatColor.BOLD + "ist nicht " + ChatColor.GOLD
							+ "die richtige Syntax! Probiere das hier:" + ChatColor.GREEN + " /<wmimport>" + ChatColor.GOLD
							+ " <name> <normal/nether/end>");
				}

			}
			if (cmd.getName().equalsIgnoreCase("wmtp")) {
				if (args.length == 1) {
					World world = Bukkit.getWorld(args[0]);
					if (world != null) {
						p.teleport(world.getSpawnLocation());
					} else {
						p.sendMessage(ChatColor.RED + "World " + ChatColor.BOLD + "not" + ChatColor.RED + " found.");
					}
				} else {

					p.sendMessage(ChatColor.GOLD + "Das " + ChatColor.RED + ChatColor.BOLD + "ist nicht "
							+ ChatColor.GOLD + "die richtige Syntax! Probiere das hier:" + ChatColor.GREEN + " /<wmtp>"
							+ ChatColor.GOLD + " <name>");

				}
			}
			if (cmd.getName().equals("worlds")) {
				p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "ALLE WELTEN" + ChatColor.GREEN + ":");
				for (World w : Bukkit.getWorlds()) {
					String name = w.getName();
					String name2 = name;
					if (name.equals(p.getWorld().getName()))
						name2 = name + ChatColor.GOLD + " (Diese Welt)";
					p.sendMessage(ChatColor.GREEN + " - " + name2 + ChatColor.GRAY + " /wmtp " + name);
				}
				p.sendMessage(ChatColor.GOLD + "Laden / Generieren einer Welt: /wmimport <name> <normal/nether/end>");
				p.sendMessage(ChatColor.GOLD + "Teleportation zu einer Welt: /wmtp <name>");
			}
			if (cmd.getName().equals("myWorld")) {
				String worldn = p.getWorld().getName();
				p.sendMessage(ChatColor.GREEN + "Deine Welt: '" + ChatColor.YELLOW + worldn + "'");
			}
			if (cmd.getName().equals("copymyWorld")) {
				if (args.length == 1) {
					if (p.isOp()) {
						World w = p.getWorld();
						File f = w.getWorldFolder();
						File newFile = new File("plugins//WorldManager//CopyedWorlds//" + args[0]);
						f.compareTo(newFile);
						p.sendMessage(ChatColor.AQUA + "[WorldManager]" + ChatColor.GREEN + "Completed!");
					} else {
						p.sendMessage(ChatColor.GOLD + "Das " + ChatColor.RED + ChatColor.BOLD + "ist nicht "
								+ ChatColor.GOLD + "die richtige Syntax! Probiere das hier:" + ChatColor.GREEN
								+ " /<copymyWorld>" + ChatColor.GOLD + " <name-der-neuen-datei>");
					}
				}
			}
		}

		return true;
	}

}
