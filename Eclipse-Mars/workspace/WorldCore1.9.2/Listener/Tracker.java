package Listener;

import mainpackage.MainPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginManager;

public class Tracker implements Listener {
	private MainPlugin plugin;

	public Tracker(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((e.getMaterial() == Material.COMPASS)) {
			e.setCancelled(true);
			Player target = getNearest(p);
			if(getNearest(p) != null){
			
			int blocks = (int) p.getLocation().distance(getNearest(p).getLocation());

			p.sendMessage(ChatColor.DARK_PURPLE + "Spieler " + ChatColor.YELLOW + getNearest(p).getName()
					+ ChatColor.DARK_PURPLE + "getrackt! | " + ChatColor.YELLOW + blocks
					+ (blocks == 1 ? "Block" : "Blöcke") + ChatColor.DARK_PURPLE + " Blöcke entfernt!");
			p.setCompassTarget(getNearest(p).getLocation());
			}else{
				p.sendMessage(ChatColor.RED+"Keine Spieler Gefunden!");
			}
		}
	}

	public Player getNearest(Player p) {
		double distance = 1.7976931348623157E+308D;
		Player target = null;

		for (Entity entity : p.getNearbyEntities(500.0D, 500.0D, 500.0D)) {
			if (entity != null) {
				if ((entity instanceof Player)) {
					double dist = p.getLocation().distance(entity.getLocation());

					if (dist < distance) {
						distance = dist;
						target = (Player) entity;
					}

				}
			}

		}

		return target;
	}
}