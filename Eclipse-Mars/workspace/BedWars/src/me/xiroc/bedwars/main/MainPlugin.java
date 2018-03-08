/**
 * @author XIROC
 */
package me.xiroc.bedwars.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.xiroc.bedwars.listeners.PlayerListeners;
import me.xiroc.bedwars.util.ConfigManager;
import me.xiroc.bedwars.util.GameState;

public class MainPlugin extends JavaPlugin{
	
	public static String prefix = ChatColor.GRAY+"["+ChatColor.AQUA+"BedWars"+ChatColor.GRAY+"] ";
	
	ConfigManager configManager;
	PlayerListeners playerListeners;
	
	public GameState gameState;
	
	@Override
	public void onEnable() {
		load();
	}
	@Override
	public void onDisable() {
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			
		}else{
			
		}
		return true;
	}
	public void load(){
		configManager = new ConfigManager(this);
		playerListeners = new PlayerListeners(this);
		
	}
	public ConfigManager getConfigManager() {
		return configManager;
	}
	public GameState getGameState() {
		return gameState;
	}
	

}
