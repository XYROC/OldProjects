package me.xiroc.admintools.listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import me.xiroc.admintools.main.MainPlugin;

public class ListenerPlayerJoinEvent implements Listener {

	private MainPlugin plugin;
	public ConsoleCommandSender CONSOLE = Bukkit.getConsoleSender();

	public ListenerPlayerJoinEvent(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onJoin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		CONSOLE.sendMessage(
				ChatColor.YELLOW + "Player " + p.getName() + " is logging in from " + e.getAddress().getHostAddress());
		CONSOLE.sendMessage(ChatColor.YELLOW + "Logging UUID... (" + p.getUniqueId().toString() + ")");
		FileConfiguration fg = YamlConfiguration.loadConfiguration(new File("plugins//AdminTools", "UUID_List.yml"));
		fg.set(p.getName(), p.getUniqueId().toString());
		try {
			fg.save(new File("plugins//AdminTools", "UUID_List.yml"));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		if (p.isBanned()) {
			e.disallow(Result.KICK_OTHER, ChatColor.RED + "");
			return;
		}
		File file = new File("plugins//AdminTools//Bans", p.getUniqueId().toString() + ".yml");
		if (file.exists()) {
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			boolean b = cfg.getBoolean("banned");
			if (b) {
				int reason = cfg.getInt("reason");
				if (cfg.getBoolean("permanent")) {
					e.disallow(Result.KICK_OTHER, ChatColor.RED + "Du wurdest wegen " + plugin.parseReason(reason)
							+ " §4PERMANENT " + ChatColor.RED + " gebannt.");
					return;
				}
				long time = cfg.getLong("time");
				Date d = new Date(time);
				Calendar c = Calendar.getInstance();
				c.setTime(new Date());
				if (!(c.getTimeInMillis() > time)) {
					e.disallow(Result.KICK_OTHER,
							ChatColor.RED + "Du wurdest bis " + ChatColor.YELLOW + d.toString() + ChatColor.RED
									+ " wegen " + plugin.parseReason(reason) + ChatColor.RED + " gebannt.");
					return;
				}
				CONSOLE.sendMessage(ChatColor.YELLOW + "Player " + p.getName() + " was banend until "
						+ c.getTime().toString() + ". Today is " + new Date().toString() + ".");
				cfg.set("banned", false);
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	/*@EventHandler
	public void onFinishJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.isOp()) {
			p.setDisplayName("§4" + p.getName() + "§r");
			p.setPlayerListName("§4" + p.getName() + "§r");
		} else {
			p.setDisplayName("§7" + p.getName() + "§r");
			p.setPlayerListName("§7" + p.getName() + "§r");
		}
	}*/

}
