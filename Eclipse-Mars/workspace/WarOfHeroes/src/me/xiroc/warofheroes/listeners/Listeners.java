package me.xiroc.warofheroes.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.xiroc.warofheroes.main.Main;
import me.xiroc.warofheroes.utils.ServerInventoryManager;

public class Listeners implements Listener{
	
	private Main main;
	
	public Listeners(Main main) {
		this.main = main;
		this.main.getServer().getPluginManager().registerEvents(this, main);
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction() != Action.PHYSICAL){
			if(p.getItemInHand().getType() == Material.COAL){
				e.setCancelled(true);
				int pr = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
					int i = 0;
					@Override
					public void run() {
						p.closeInventory();
						p.openInventory(new ServerInventoryManager().getSearchInventory(i));
						if(i == 9){
							i = 0;
						}else{
							i+=1;
						}
					}
				}, 0, 4);
				int kp = Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
					
					@Override
					public void run() {
						Bukkit.getScheduler().cancelTask(pr);
						p.closeInventory();
						//p.sendMessage(ChatColor.RED+"Kein Server gefunden!");
						
					}
				}, 200);
			}
		}
	}

}
