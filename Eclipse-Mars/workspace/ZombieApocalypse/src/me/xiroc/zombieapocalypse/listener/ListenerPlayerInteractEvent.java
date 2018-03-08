package me.xiroc.zombieapocalypse.listener;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.xiroc.zombieapocalypse.game.Game;
import me.xiroc.zombieapocalypse.game.GameBoundManager;
import me.xiroc.zombieapocalypse.game.GameManager;
import me.xiroc.zombieapocalypse.main.MainPlugin;

public class ListenerPlayerInteractEvent implements Listener{
	
	private MainPlugin plugin;
	
	public ListenerPlayerInteractEvent(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);	
		}
	GameManager gm = new GameManager();
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN){
				Sign s = (Sign) e.getClickedBlock().getState();
				if(s.getLine(1).equals("§7[§aZOMBIE§7]")){
					String name = s.getLine(2);
					File file = new File("plugins//ZombieApocalypse//Worlds", name + ".yml");
					if(file.exists()){
						FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
						GameBoundManager gameboundmanager = gm.getGameBoundManager(e.getClickedBlock());
						Game game = gameboundmanager.getGame();
						if(game.getPlayerSize() == game.getMaxSize()){
							p.sendMessage(plugin.prefix+ChatColor.RED+"Der Server ist voll!");
						}else{
							game.addPlayer(p);
							int x = cfg.getInt("World.Lobby.x");
							int y = cfg.getInt("World.Lobby.y");
							int z = cfg.getInt("World.Lobby.z");
							String wn = cfg.getString("World.Lobby.world");
							World world = Bukkit.getWorld(wn);
							Location loc = new Location(world, x, y, z);
							p.teleport(loc);
						}
					}else{
						p.sendMessage(plugin.prefix+ChatColor.RED+"Die Karte konnte nicht geladen werden!");
					}
				}
			}
		}
	}
}
