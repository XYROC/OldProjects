package me.xiroc.zombieapocalypse.listener;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import me.xiroc.zombieapocalypse.game.Game;
import me.xiroc.zombieapocalypse.game.GameBoundManager;
import me.xiroc.zombieapocalypse.game.GameManager;
import me.xiroc.zombieapocalypse.main.MainPlugin;

public class ListenerSignChangeEvent implements Listener{
	
	private MainPlugin plugin;
	
	public ListenerSignChangeEvent(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	GameManager gm = new GameManager();
	public void onChange(SignChangeEvent e){
		Player p = e.getPlayer();
		Sign s = (Sign) e.getBlock().getState();
		if(s.getLine(0).equals("[ZA]")){
			String name = s.getLine(1);
			File file = new File("plugins//ZombieApocalypse//Worlds", name + ".yml");
			if(file.exists()){
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			Game game = new Game(cfg.getInt("Players.Count"), false);
			GameBoundManager bnd = new GameBoundManager(e.getBlock(), game);
			gm.registerGameBoundManager(bnd);
			s.setLine(1, "§7[§aZOMBIE§7]");
			s.setLine(2, "§a"+name);
			s.setLine(3, "["+0+"/"+game.getMaxSize()+"]");
			s.update();
			p.sendMessage(plugin.prefix+ChatColor.GREEN+"Schild erfolgreich hinzugefügt!");
			}else{
				p.sendMessage(plugin.prefix+ChatColor.RED+"Karte nicht gefunden!");
				e.setCancelled(true);
				e.getBlock().breakNaturally();
			}
		}
	}

}
