package me.xiroc.kitpvp.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.xiroc.kitpvp.main.MainPlugin;
import me.xiroc.kitpvp.util.Game;
import me.xiroc.kitpvp.util.MapObject;
import me.xiroc.kitpvp.util.PlayerObject;

public class Listeners implements Listener{
	
	private MainPlugin plugin;
	
	public Listeners(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		if(e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.SIGN_POST){
				Sign sign = (Sign) e.getClickedBlock();
				if(sign.getLine(0).equals("§7[§aKitPvP§7]")){
					Game game = plugin.getGameManager().getGameObjectFromSign(e.getClickedBlock().getLocation()).getGame();
					game.add(new PlayerObject(e.getPlayer()));
				}
			}
			
		}
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent e){
		Sign sign = (Sign) e.getBlock();
		if(sign.getLine(0).equals("[KitPvP]")){
			if(e.getPlayer().isOp()){
				MapObject map = plugin.getGameManager().getRandomMap();
				Game game = new Game(map, map.getMaxPlayers(), map.getTeams());
				plugin.getGameManager().addGameObject(game, e.getBlock().getLocation());
				e.setLine(0, plugin.prefix);
				e.setLine(1, "§a");
				e.setLine(2, "0/"+map.getMaxPlayers());
				e.setLine(3, "");
			}else{
				e.setCancelled(true);
				e.getPlayer().sendMessage(plugin.prefix+ChatColor.RED+"Du darfst kein KitPvp - Schild erstellen!");
			}
		}
	}

}
