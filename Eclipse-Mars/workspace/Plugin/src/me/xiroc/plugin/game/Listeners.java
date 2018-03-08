package me.xiroc.plugin.game;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.xiroc.plugin.main.Main;

public class Listeners implements Listener {

	private Main main;

	public Listeners(Main main) {
		this.main = main;
		this.main.getServer().getPluginManager().registerEvents(this, main);
	}

	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			File con = new File("plugins//War//Data//Lobby.yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(con);
			if (p.getWorld() == Bukkit.getWorld(cfg.getString("lobby.world"))) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			File con = new File("plugins//War//Data//Lobby.yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(con);
			if (p.getWorld() == Bukkit.getWorld(cfg.getString("lobby.world"))) {
				e.setCancelled(true);
			}
		}
	}
	/*
	 	@EventHandler
	 	public void onChat(AsyncPlayerChatEvent e) {
		Player p = (Player) e.getPlayer();
		File con = new File("plugins//War//Data//Lobby.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(con);
		if (p.getWorld() == Bukkit.getWorld(cfg.getString("lobby.world"))) {
			e.setCancelled(true);
			e.setMessage(Main.PREFIX+ChatColor.GREEN+p.getDisplayName()+"§7|");
		}
	}*/

}
