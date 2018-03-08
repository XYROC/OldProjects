package me.xiroc.killdeath.main;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		this.registerEvents();
		System.out.println("[KillDeath] KillDeath Enabled!");
	}

	@Override
	public void onDisable() {
		System.out.println("[KillDeath] KillDeath Disabled!");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equals("stats")) {
				if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "Deine Stats werden geladen... Bitte warte kurz");
					File fd = new File("plugins//KillDeath//Files" + p.getName() + ".yml");
					FileConfiguration fdc = YamlConfiguration.loadConfiguration(fd);
					int kills = fdc.getInt("Player.Kills");
					int deaths = fdc.getInt("Player.Deaths");
					int kd = fdc.getInt("Player.KD");
					p.sendMessage(ChatColor.GRAY + "####" + ChatColor.DARK_GRAY + "(Stats von " + ChatColor.YELLOW
							+ p.getDisplayName() + ChatColor.DARK_GRAY + ")" + ChatColor.GRAY + "####");
					p.sendMessage(ChatColor.GRAY + "Kills: " + ChatColor.YELLOW + kills);
					p.sendMessage(ChatColor.GRAY + "Tode: " + ChatColor.YELLOW + deaths);
					p.sendMessage(ChatColor.GRAY + "KD: " + ChatColor.YELLOW + kd);
					p.sendMessage(ChatColor.GRAY + "#######################");
				}
			}
		}

		return true;
	}

	public void registerEvents() {
		ListenerPlayerDeathEvent func_000000_a = new ListenerPlayerDeathEvent(this);
	}
}
