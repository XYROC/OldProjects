package me.xiroc.warofheroes.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.xiroc.warofheroes.listeners.Listeners;
import me.xiroc.warofheroes.utils.GameState;

public class Main extends JavaPlugin{
	
	private GameState gamestate;
	
	@Override
	public void onEnable() {
		this.gamestate = GameState.LOADING;
		registerListeners();
		System.out.println("[WarOfHeroes] Enabled WarOfHeroes!");
	}
	@Override
	public void onDisable() {
		System.out.println("[WarOfHeroes] Disabled WarOfHeroes!");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			if(cmd.getName().equals("warofheroes")){
				
			}
		}else{
			
		}
		return true;
	}
	public void registerListeners(){
		Listeners listeners = new Listeners(this);
		
	}
	public GameState getGamestate() {
		return gamestate;
	}
	public void setGamestate(GameState gamestate) {
		this.gamestate = gamestate;
	}

}
