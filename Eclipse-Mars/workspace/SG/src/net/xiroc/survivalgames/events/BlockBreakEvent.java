package net.xiroc.survivalgames.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import net.xiroc.survivalgames.main.SurvivalGames;

public class BlockBreakEvent implements Listener{
	
	private SurvivalGames plugin;
	
	public BlockBreakEvent(SurvivalGames plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		System.out.println("[SurvivalGames] Loaded BlockBreakEvent");

	}
	
	@EventHandler
	public void onBreak(org.bukkit.event.block.BlockBreakEvent e){
		Player p = e.getPlayer();
		Block b = e.getBlock();
		if(this.plugin.protect){
			e.setCancelled(true);
		}else{
			
		}
		
			
	}

}
