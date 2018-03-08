package me.xiroc.servermanager.listener;

import me.xiroc.servermanager.main.ServerManager;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class JoinEvent implements Listener {
	private ServerManager plugin;

	public JoinEvent(ServerManager plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		if(plugin.getMaxPlayers() < Bukkit.getMaxPlayers()){
			
		}
		Player p = e.getPlayer();
		File file = new File("plugins//Permissions//Players", p.getName() + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		boolean bool = cfg.getBoolean("DarkStar.Premium");
		if (this.plugin.join) {
			if (Bukkit.getOnlinePlayers().size() < Bukkit.getMaxPlayers() && Bukkit.getOnlinePlayers().size() >= plugin.getMaxPlayers()) {
				if (bool) {
					/*for (Player onp : Bukkit.getOnlinePlayers()) {
						File fileonp = new File("plugins//Permissions//Players", onp.getName() + ".yml");
						FileConfiguration cfgonp = YamlConfiguration.loadConfiguration(fileonp);
						boolean boolonp = cfgonp.getBoolean("DarkStar.Premium");
						if (boolonp) {
						} else {
							onp.kickPlayer("§4Um einem Premium-Spieler Platz zu gewähren, wurdest du gekickt!");
							e.allow();
							break;
						}
					}*/
				} else {
					e.disallow(Result.KICK_OTHER, ChatColor.RED + "Das Spielerlimit von "+ChatColor.YELLOW+plugin.getMaxPlayers()+ChatColor.RED+" Spielern ist erreicht.\n§7Du benötigst den "+ChatColor.YELLOW+"Premiumrang"+"§7 um trotzdem joinen zu können.");
				}
			}else if(Bukkit.getOnlinePlayers().size() < plugin.getMaxPlayers()){
				
			}else{
				e.disallow(Result.KICK_OTHER, ChatColor.RED + "Das Spielerlimit von "+ChatColor.YELLOW+plugin.getMaxPlayers()+ChatColor.RED+" Spielern ist erreicht.\n§7Du benötigst den "+ChatColor.YELLOW+"Premiumrang"+"§7 um trotzdem joinen zu können.");
			}
		}else{
			if(!e.getPlayer().isOp()){
				e.disallow(Result.KICK_OTHER, ChatColor.RED+"Du kannst den Server derzeit nicht betreten!");
			}
		}

	}
}