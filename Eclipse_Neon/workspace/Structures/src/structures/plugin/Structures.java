package structures.plugin;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Structures extends JavaPlugin implements Listener {

	private ArrayList<Position> positions;

	@Override
	public void onEnable() {
		positions = new ArrayList<Position>();
		System.out.println("[Structures] Enabled Structures.");
	}

	@Override
	public void onDisable() {
		System.out.println("[Structures] Disabled Structures.");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("structures")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("save")) {
						if (containsPosition(player, 1) && containsPosition(player, 2)) {
							player.sendMessage(ChatColor.AQUA + "Trying to save a Structure-File...");
							Position pos1 = getPosition(player, 1);
							Position pos2 = getPosition(player, 2);
						} else {
							player.sendMessage(ChatColor.RED + "You have to select an area first!");
						}
					}
				}
			}
		}
		return true;
	}

	public boolean containsPosition(Player player, int posNumber) {
		for (Position position : positions) {
			if (position.getPlayer() == player && position.getPosNumber() == posNumber) {
				return true;
			}
		}
		return false;
	}

	public Position getPosition(Player player, int posNumber) {
		for (Position position : positions) {
			if (position.getPlayer() == player && position.getPosNumber() == posNumber) {
				return position;
			}
		}
		return null;
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getItem().getType() == Material.DIAMOND_AXE && e.getPlayer().isOp()) {
			Player p = e.getPlayer();
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				if (containsPosition(p, 2)) {
					for (Position pos : positions) {
						if (pos.getPlayer() == p && pos.getPosNumber() == 2) {
							pos.setX(e.getClickedBlock().getLocation().getBlockX());
							pos.setY(e.getClickedBlock().getLocation().getBlockY());
							pos.setZ(e.getClickedBlock().getLocation().getBlockZ());
							break;
						}
					}
				} else {
					Position pos = new Position(p, e.getClickedBlock().getLocation().getBlockX(),
							e.getClickedBlock().getLocation().getBlockY(),
							e.getClickedBlock().getLocation().getBlockZ(), 2);
					positions.add(pos);
				}
				p.sendMessage(ChatColor.GREEN + "Set Position 2 to " + e.getClickedBlock().getLocation().getBlockX()
						+ " " + e.getClickedBlock().getLocation().getBlockY() + " "
						+ e.getClickedBlock().getLocation().getBlockZ());
			}
			if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
				e.setCancelled(true);
				if (containsPosition(p, 1)) {
					for (Position pos : positions) {
						if (pos.getPlayer() == p && pos.getPosNumber() == 1) {
							pos.setX(e.getClickedBlock().getLocation().getBlockX());
							pos.setY(e.getClickedBlock().getLocation().getBlockY());
							pos.setZ(e.getClickedBlock().getLocation().getBlockZ());
							break;
						}
					}
				} else {
					Position pos = new Position(p, e.getClickedBlock().getLocation().getBlockX(),
							e.getClickedBlock().getLocation().getBlockY(),
							e.getClickedBlock().getLocation().getBlockZ(), 1);
					positions.add(pos);
				}
				p.sendMessage(ChatColor.GREEN + "Set Position 1 to " + e.getClickedBlock().getLocation().getBlockX()
						+ " " + e.getClickedBlock().getLocation().getBlockY() + " "
						+ e.getClickedBlock().getLocation().getBlockZ());
			}
		}
	}

}
