package Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import main.SurvivalGames;

public class PlayerLoginListener implements Listener{
	
	private SurvivalGames plugin;
	
	public PlayerLoginListener(SurvivalGames plugin){
		
		this.plugin = plugin;
	}

	@EventHandler
	public void onLogin(PlayerLoginEvent evt){
		Player p = evt.getPlayer();
		if(!this.plugin.joinable){
			
			p.kickPlayer(this.plugin.prefix+ChatColor.DARK_RED+"Der Server ist voll!");
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
