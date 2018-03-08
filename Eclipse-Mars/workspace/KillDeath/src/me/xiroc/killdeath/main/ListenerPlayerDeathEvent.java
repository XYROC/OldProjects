package me.xiroc.killdeath.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class ListenerPlayerDeathEvent implements Listener {

	private MainPlugin plugin;

	public ListenerPlayerDeathEvent(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player d = e.getEntity();
		if (d.getKiller() instanceof Player) {
			Player k = d.getKiller();
			File kd = new File("plugins//KillDeath//Files" + d.getName() + ".yml");
			FileConfiguration kdc = YamlConfiguration.loadConfiguration(kd);
			if (kd.exists()) {
				int i = kdc.getInt("Player.Deaths");
				kdc.set("Player.Deaths", i + 1);
				double kld = kdc.getInt("Player.Kills") / kdc.getInt("Player.Deaths");
				kdc.set("Player.KD", kld);
			} else {
				kdc.set("Player.Deaths", 1);
			}
			try {
				kdc.save(kd);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			File fd = new File("plugins//KillDeath//Files" + k.getName() + ".yml");
			FileConfiguration fdc = YamlConfiguration.loadConfiguration(fd);
			if (fd.exists()) {
				int i = fdc.getInt("Player.Kills");
				fdc.set("Player.Kills", i + 1);

			} else {
				fdc.set("Player.Kills", 1);
			}
			double kld = fdc.getInt("Player.Kills") / fdc.getInt("Player.Deaths");
			fdc.set("Player.KD", kld);
			try {
				fdc.save(fd);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			// e.setDeathMessage(ChatColor.AQUA+"Spieler
			// "+d.getDisplayName()+ChatColor.AQUA+" wurde von
			// "+d.getKiller().getDisplayName()+ChatColor.AQUA+" getötet!");
		} else {
			// e.setDeathMessage(ChatColor.AQUA+"Spieler
			// "+d.getDisplayName()+ChatColor.AQUA+" ist gestorben");
		}

	}

}
