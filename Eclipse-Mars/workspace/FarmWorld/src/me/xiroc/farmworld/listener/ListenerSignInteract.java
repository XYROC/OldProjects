package me.xiroc.farmworld.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.xiroc.farmworld.main.MainPlugin;

public class ListenerSignInteract implements Listener {

	private MainPlugin plugin;

	public ListenerSignInteract(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType() == Material.SIGN_POST
					|| e.getClickedBlock().getType() == Material.WALL_SIGN) {
				Block b = e.getClickedBlock();
				Sign s = (Sign) b.getState();
				if (s.getLine(1).equals("   §1[Warp]   ")) {
					if (s.getLine(2).equals("§2Bed")) {
						Location l = p.getBedSpawnLocation();
						if (l != null) {
							p.teleport(p.getBedSpawnLocation());
							p.sendMessage(ChatColor.GREEN + "Warping to: " + ChatColor.YELLOW + "Your bed");
						} else {
							p.sendMessage(ChatColor.RED + "Bed not found!");
						}

					} else {
						World w = Bukkit.getWorld(s.getLine(2));
						if (w != null) {
							if (s.getLine(2).endsWith("_nether")) {
								if (this.plugin.blockNether) {
									p.sendMessage(
											ChatColor.RED + "Teleporting to the Nether using a Warpsign is disabled!");
								} else {
									p.teleport(w.getSpawnLocation());
									p.sendMessage(ChatColor.GREEN + "Warping to: " + ChatColor.YELLOW + w.getName());
								}
							} else if (s.getLine(2).endsWith("_the_end")) {
								if (this.plugin.blockEnd) {
									e.setCancelled(true);
									p.sendMessage(
											ChatColor.RED + "Teleporting to the End using a Warpsign is disabled!");
								} else {
									p.teleport(w.getSpawnLocation());
									p.sendMessage(ChatColor.GREEN + "Warping to: " + ChatColor.YELLOW + w.getName());
								}
							} else {
								p.teleport(w.getSpawnLocation());
								p.sendMessage(ChatColor.GREEN + "Warping to: " + ChatColor.YELLOW + w.getName());
							}

						} else {
							p.sendMessage(ChatColor.RED + "World not found!");
						}

					}

				}
			}
		}
	}

}
