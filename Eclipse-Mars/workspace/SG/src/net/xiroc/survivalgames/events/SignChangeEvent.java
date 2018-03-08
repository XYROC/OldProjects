package net.xiroc.survivalgames.events;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.yaml.snakeyaml.Yaml;

import net.xiroc.survivalgames.main.SurvivalGames;

public class SignChangeEvent implements Listener{
	
	private SurvivalGames sg;
	
	public SignChangeEvent(SurvivalGames plugin){
		this.sg = plugin;
		this.sg.getServer().getPluginManager().registerEvents(this, sg);
	}
	
	@EventHandler
	public void onChange(org.bukkit.event.block.SignChangeEvent e){
		Player p = e.getPlayer();
		String prefix = sg.prefix;
		if(e.getLine(0).equals("[SG]")){
			if(!e.getLine(1).equals("")){
				String world = e.getLine(1);
				File theworld = new File("plugins//SurvivalGames//Worlds", world + ".yml");
				if(theworld.exists()){
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(theworld);
					int size = cfg.getInt("World.Size");
					e.setLine(0, "§7[§6SG§7]");
					e.setLine(2, "§7[§a"+size+"x1§7]");
					e.setLine(3, ""+0);
					p.sendMessage(prefix+ChatColor.GREEN+"Schild für "+ChatColor.YELLOW+world+ChatColor.GREEN+" erfolgreich gesetzt!");
					e.setCancelled(false);
				}else{
					p.sendMessage(prefix+ChatColor.RED+"Diese Map existiert nicht!");
					e.setCancelled(true);
				}
			}else{
				p.sendMessage(prefix+ChatColor.RED+"Bitte gib einen Namen ein!");
				e.setCancelled(true);
			}
		}
	}

}
