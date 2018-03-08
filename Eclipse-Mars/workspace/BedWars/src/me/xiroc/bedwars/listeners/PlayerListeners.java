package me.xiroc.bedwars.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.xiroc.bedwars.main.MainPlugin;
import me.xiroc.bedwars.util.GameState;

public class PlayerListeners implements Listener{
	
	private MainPlugin plugin;
	
	public PlayerListeners(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player player = e.getPlayer();
		e.setJoinMessage(plugin.prefix+ChatColor.WHITE+">> "+player.getDisplayName()+ChatColor.DARK_GRAY+" hat das Spiel betreten");
		if(plugin.getGameState() == GameState.LOBBY){
			e.setJoinMessage(plugin.prefix+ChatColor.WHITE+">> "+player.getDisplayName()+ChatColor.DARK_GRAY+" hat das Spiel betreten");
			readyPlayer(player);
			if(plugin.getConfigManager().getConfig().contains("Lobby")){
				player.teleport(plugin.getConfigManager().loadLocation("Lobby"));
			}else{
				player.sendMessage(ChatColor.RED+"[err: #0L E]");
			}
			return;
		}
		e.setJoinMessage(null);
		readySpectator(player);
		if(plugin.getConfigManager().getConfig().contains("Spectator")){
			player.teleport(plugin.getConfigManager().loadLocation("Spectator"));
		}else{
			player.sendMessage(ChatColor.RED+"[err: #0I E]");
		}
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player player = e.getPlayer();
		e.setQuitMessage(plugin.prefix+ChatColor.WHITE+">> "+player.getDisplayName()+ChatColor.DARK_GRAY+" hat das Spiel verlassen");
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		
	}
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		
	}
	public void readyPlayer(Player player){
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		player.setHealth(20);
		player.setFoodLevel(20);
		player.setFireTicks(0);
		player.setAllowFlight(false);
		player.setFlying(false);
		player.setGameMode(GameMode.SURVIVAL);
		player.setLevel(0);
		player.setExp(0F);
		for(PotionEffect effect: player.getActivePotionEffects()){
			player.removePotionEffect(effect.getType());	
		}
	}
	public void readySpectator(Player player){
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		player.setHealth(20);
		player.setFoodLevel(20);
		player.setFireTicks(0);
		player.setAllowFlight(true);
		player.setFlying(true);
		player.setGameMode(GameMode.SURVIVAL);
		player.setLevel(0);
		player.setExp(0F);
		for(PotionEffect effect: player.getActivePotionEffects()){
			player.removePotionEffect(effect.getType());	
		}
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 3));
	}

}
