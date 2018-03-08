package Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import main.SurvivalGames;

public class PlayerMoveListener implements Listener {

	private SurvivalGames plugin;

	public PlayerMoveListener(SurvivalGames plugin) {

		this.plugin = plugin;
	}

	@EventHandler
	public void onMove(PlayerMoveEvent evt) {
		Player p = evt.getPlayer();
		if (!this.plugin.onspawn) {
			if ((evt.getFrom().getBlockX() == evt.getTo().getBlockX()
					&& (evt.getFrom().getBlockY() == evt.getTo().getBlockY()
							&& (evt.getFrom().getBlockZ() == evt.getTo().getBlockZ())))) return;
				
				p.teleport(p);
		}

	}

}
