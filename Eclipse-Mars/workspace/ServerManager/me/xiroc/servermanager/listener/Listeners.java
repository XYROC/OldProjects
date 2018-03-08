package me.xiroc.servermanager.listener;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;

import me.xiroc.servermanager.main.ServerManager;

public class Listeners implements Listener {

	private ServerManager manager;

	public Listeners(ServerManager manager) {
		this.manager = manager;
		this.manager.getServer().getPluginManager().registerEvents(this, manager);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		// e.setCancelled(true);
		/*for (Player p : Bukkit.getOnlinePlayers()) {
			// p.sendMessage(EnumChatFormat.GRAY+"Spieler |
			// "+e.getPlayer().getDisplayName()+EnumChatFormat.GRAY+":
			// "+e.getMessage());
		}*/
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		// e.setQuitMessage(EnumChatFormat.GRAY+"Spieler |
		// "+e.getPlayer().getDisplayName()+EnumChatFormat.AQUA+" hat das Spiel
		// verlassen");
	}
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e){
		if(manager.blockHunger){
			e.setFoodLevel(20);
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (manager.build.contains(p.getName())) {
			p.sendMessage(ChatColor.GREEN + "Du besitzt " + ChatColor.BOLD + "Baurechte" + ChatColor.GREEN + "!");
			p.setGameMode(GameMode.CREATIVE);
		}
	}

	public void onDeath(PlayerDeathEvent e) {

	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {

	}

	@EventHandler
	public void onExplode(EntityExplodeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onPing(ServerListPingEvent e) {
		e.setMotd(ServerManager.modt);
		e.setMaxPlayers(this.manager.getMaxPlayers());
	}

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		String world = e.getPlayer().getWorld().getName();
		if (manager.activeProtection.contains(world) && !manager.build.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void onPlaced(BlockPlaceEvent e) {
		String world = e.getPlayer().getWorld().getName();
		if (manager.activeProtection.contains(world) && !manager.build.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		String world = e.getPlayer().getWorld().getName();
		if (manager.activeProtection.contains(world) && !manager.build.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
			return;
		}
	}
}
