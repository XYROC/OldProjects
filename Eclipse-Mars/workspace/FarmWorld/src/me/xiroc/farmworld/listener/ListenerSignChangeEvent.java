package me.xiroc.farmworld.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import me.xiroc.farmworld.main.MainPlugin;

public class ListenerSignChangeEvent implements Listener{
	
	private MainPlugin plugin;
	
	public ListenerSignChangeEvent(MainPlugin plugin){
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onChange(SignChangeEvent e) {
		if(e.getLine(0).equals("[Warp]")){
			Player p = e.getPlayer();
			String world = e.getLine(1);
			if(e.getLine(1).equals("Bed")){
				e.setLine(0, "----------------");
				e.setLine(1, "   §1[Warp]   ");
				e.setLine(2, "§2Bed");
				e.setLine(3, "----------------");
			}else{
				e.setLine(0, "----------------");
				e.setLine(1, "   §1[Warp]   ");
				e.setLine(2,world);
				e.setLine(3, "----------------");
				e.getBlock().getState().update();	
			}
			
			p.sendMessage(ChatColor.GREEN+"Warp set!");
		}
		
		
	}

}
