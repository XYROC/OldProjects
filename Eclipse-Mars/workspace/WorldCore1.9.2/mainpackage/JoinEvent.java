package mainpackage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
	private MainPlugin plugin2;

	public JoinEvent(MainPlugin plugin2) {
		plugin2.getServer().getPluginManager().registerEvents(this, plugin2);
		System.out.println("[WorldCore] Activated Class JoinEvent (v 0.1)");
		this.plugin2 = plugin2;
	}

	@EventHandler
	public void OnPlayerJoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String n = p.getName();
		//p.sendMessage(ChatColor.YELLOW + "Wilkommen " + ChatColor.GREEN + n + ChatColor.YELLOW + "!");
		//p.sendMessage(ChatColor.RED+"Soll eine Farmwelt eingerichtet werden? Wenn ja bitte gib ein /vote Farmwelt!");
		if (this.plugin2.colorednames) {
			if (p.isOp()) {
				p.setDisplayName("§4" + p.getName() + "§r");
				p.setPlayerListName("§4" + p.getName() + "§r");
			} else {
				p.setDisplayName("§a" + p.getName() + "§2");
				p.setPlayerListName("§a" + p.getName() + "§r");
			}
		}

	}
}