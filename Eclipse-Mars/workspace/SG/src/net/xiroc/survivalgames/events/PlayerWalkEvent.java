package net.xiroc.survivalgames.events;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.xiroc.survivalgames.main.SurvivalGames;

public class PlayerWalkEvent implements Listener {

	private SurvivalGames sg;
	public File manager = new File("plugins//SurvivalGames//Game//Config" + "config.yml");
	public FileConfiguration mcfg = YamlConfiguration.loadConfiguration(manager);

	public PlayerWalkEvent(SurvivalGames plugin) {
		this.sg = plugin;
		this.sg.getServer().getPluginManager().registerEvents(this, sg);
	}

	@EventHandler
	public void onWalk(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (sg.ingame.contains(p)) {
			String world = p.getWorld().getName();
			if (mcfg.contains("World." + world + ".blockmove")) {
				boolean block = mcfg.getBoolean("World." + world + ".blockmove");
				if (block) {
					p.teleport(p);
				}
			}

		}
	}

}
