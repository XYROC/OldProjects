package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
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
import Chest.ChestManager;

public class SurvivalGames extends JavaPlugin {

	public String prefix = ChatColor.GRAY + "[" + ChatColor.GOLD + "SurvivalGames" + ChatColor.GRAY + "] ";

	public ArrayList<Player> dead = new ArrayList<Player>();
	public ArrayList<Player> online = new ArrayList<Player>();

	public HashMap<Location, Inventory> sgchest = new HashMap<Location, Inventory>();

	public File file = new File("plugins/Survivalgames", "config.yml");
	public FileConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);

	public boolean joinable;
	public boolean onspawn;
	public boolean friendly;

	public int expid;
	public int exp;

	public int startid;
	public int start;

	public int peace;
	public int peaceid;

	public void onEnable() {

		System.out.println("[SurvivalGames] Starting Survivalgames!");

		this.joinable = true;
		this.onspawn = false;
		this.friendly = true;

		this.exp = 120;
		this.start = 15;
		this.peace = 60;

		Bukkit.getPluginManager().registerEvents(new ChestManager(this), this);

	}

	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("sg")) {
			if (args.length == 0) {

			}
			if (args.length == 1) {
				// /sg start
				if (args[0].equals("start")) {
					if (p.hasPermission("sg.start")) {
						this.exp = 11;
					} else {

					}

				}
				if (args[0].equals("setlobby")) {
					if (p.hasPermission("sg.setlobby")) {
						this.cfg.set("SurvivalGames.Lobby.World", p.getWorld().getName());
						this.cfg.set("SurvivalGames.Lobby.X", Double.valueOf(p.getLocation().getX()));
						this.cfg.set("SurvivalGames.Lobby.Y", Double.valueOf(p.getLocation().getY()));
						this.cfg.set("SurvivalGames.Lobby.Z", Double.valueOf(p.getLocation().getZ()));
						this.cfg.set("SurvivalGames.Lobby.Yaw", Double.valueOf(p.getLocation().getYaw()));
						this.cfg.set("SurvivalGames.Lobby.Pitch", Double.valueOf(p.getLocation().getPitch()));

						try {

							this.cfg.save(this.file);
							p.sendMessage(prefix + ChatColor.GREEN + "Lobby set!");
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {

					}

				}
				if (args[0].equals("setspawn")) {
					if (p.hasPermission("sg.setspawn")) {
						this.cfg.set("SurvivalGames.Spawn.World", p.getWorld().getName());
						this.cfg.set("SurvivalGames.Spawn.X", Double.valueOf(p.getLocation().getX()));
						this.cfg.set("SurvivalGames.Spawn.Y", Double.valueOf(p.getLocation().getY()));
						this.cfg.set("SurvivalGames.Spawn.Z", Double.valueOf(p.getLocation().getZ()));
						this.cfg.set("SurvivalGames.Spawn.Yaw", Double.valueOf(p.getLocation().getYaw()));
						this.cfg.set("SurvivalGames.Spawn.Pitch", Double.valueOf(p.getLocation().getPitch()));

						try {

							this.cfg.save(this.file);
							p.sendMessage(prefix + ChatColor.GREEN + "Spawn set!");
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {

					}

				}
				if (args[0].equals("tools")) {
					if (p.isOp()) {
						ItemStack start = new ItemStack(Material.DIAMOND);
						ItemMeta startMeta = start.getItemMeta();
						startMeta.setDisplayName("§6S§4§a§1t§ea§5r§6t");
						start.setItemMeta(startMeta);
						p.getInventory().addItem(start);
						if (p.getInventory().contains(start)) {
							p.getInventory().setItem(0, start);
						}
					} else {
						p.sendMessage(
								prefix + ChatColor.RED + "You don't have the permission to perform this command!");
					}
				}

			}

		}

		return false;
	}

	

}
