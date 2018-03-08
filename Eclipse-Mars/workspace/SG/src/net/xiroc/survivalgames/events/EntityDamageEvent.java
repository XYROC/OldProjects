package net.xiroc.survivalgames.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import net.xiroc.survivalgames.main.SurvivalGames;

public class EntityDamageEvent implements Listener{
	
	private SurvivalGames plugin;
	
	public EntityDamageEvent(SurvivalGames plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		System.out.println("[SurvivalGames] Loaded EntityDamageEvent");

	}
	@EventHandler
	public void onDamage(org.bukkit.event.entity.EntityDamageEvent e){
		if(this.plugin.peace){
			e.setCancelled(true);
		}
	}

}
