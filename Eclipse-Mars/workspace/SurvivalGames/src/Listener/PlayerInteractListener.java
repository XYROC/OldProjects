package Listener;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import main.SurvivalGames;

public class PlayerInteractListener implements Listener {

	private SurvivalGames plugin;
	private int time;
	private int countdown;

	public PlayerInteractListener(SurvivalGames plugin) {
		this.plugin = plugin;

	}

	@EventHandler
	public void onInteract(PlayerInteractEvent evt) {
		
		Player p = evt.getPlayer();
		if (this.plugin.dead.contains(p)) {
			if ((evt.getAction() == Action.RIGHT_CLICK_AIR || (evt.getAction() == Action.RIGHT_CLICK_BLOCK))) {
				if (p.getItemInHand().getType() == Material.COMPASS) {
					Random rnd = new Random();
					Player p1 = (Player) this.plugin.online.get(rnd.nextInt(this.plugin.online.size()));
					p.teleport(p1);

				}
				if (p.getItemInHand().getType() == Material.DIAMOND) {
					if (p.getItemInHand().getItemMeta().getDisplayName().equals("§6S§4§a§1t§ea§5r§6t")) {
						p.setLevel(10);
						this.time = 10;
						p.sendMessage(this.plugin.prefix + ChatColor.GREEN + "Set Countdown to 10!");
						countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable() {

							@Override
							public void run() {
								time--;
								if (time == 10) {
									p.setLevel(time);
									p.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
											+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
								}
								if (time == 5) {
									p.setLevel(time);
									p.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
											+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
								}
								if (time == 4) {
									p.setLevel(time);
									p.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
											+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
								}
								if (time == 3) {
									p.setLevel(time);
									p.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
											+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
								}
								if (time == 2) {
									p.setLevel(time);
									p.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
											+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
								}
								if (time == 1) {
									p.setLevel(time);
									p.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
											+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
								}
								if (time == 0) {
									p.setLevel(0);
									p.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt!");
									Bukkit.getScheduler().cancelTask(countdown);
								}
							}
						}, 0, 20);
					}
				}

			}

		}

	}

}
