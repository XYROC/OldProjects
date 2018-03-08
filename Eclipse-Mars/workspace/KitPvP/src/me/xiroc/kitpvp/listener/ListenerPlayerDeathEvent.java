package me.xiroc.kitpvp.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.xiroc.kitpvp.kits.KitArcher;
import me.xiroc.kitpvp.kits.KitDefault;
import me.xiroc.kitpvp.kits.KitTank;
import me.xiroc.kitpvp.kits.KitHunter;
import me.xiroc.kitpvp.kits.KitManager;
import me.xiroc.kitpvp.kits.KitTankOLD;
import me.xiroc.kitpvp.kits.KitWarrior;
import me.xiroc.kitpvp.kits.KitWizard;
import me.xiroc.kitpvp.kits.KitZombie;
import me.xiroc.kitpvp.main.MainPlugin;

public class ListenerPlayerDeathEvent implements Listener {

	private MainPlugin plugin;
	private KitManager km;
	private KitDefault kitdefault;
	private KitWarrior kitwarrior;
	private KitArcher kitarcher;
	private KitWizard kitwizard;
	private KitHunter kithunter;
	private KitTank kitdragon;
	private KitZombie kitzombie;
	private KitTankOLD kittank;

	public ListenerPlayerDeathEvent(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (p.getKiller() instanceof Player) {
			Player k = (Player) p.getKiller();
			File file = new File("plugins//KitPvP//Player//Powerups", k.getName() + ".yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			if (!file.exists()) {
				cfg.set("Powerups.CoinBoost", false);
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			boolean coinboost = cfg.getBoolean("Powerups.CoinBoost");
			int gc = 10;
			if (coinboost) {
				gc *= 3;
			} else {
			}
			int kc = plugin.getCoins(k) + gc;
			plugin.setCoins(k, kc);
			k.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast " + ChatColor.YELLOW + p.getName()
					+ ChatColor.GREEN + " getötet und " + ChatColor.YELLOW + gc + ChatColor.GREEN + " Coins erhalten!");
			k.playSound(p.getLocation(), Sound.LEVEL_UP, 20, 20);
			if(plugin.healkiller){
				k.setHealth(20);
			}
		}
	}

}
