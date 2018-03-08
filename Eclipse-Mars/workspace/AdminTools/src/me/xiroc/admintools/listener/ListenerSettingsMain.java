package me.xiroc.admintools.listener;


import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.xiroc.admintools.main.MainPlugin;

public class ListenerSettingsMain implements Listener{
	
	private MainPlugin plugin;
	private Inventory spieler;
	
	public ListenerSettingsMain(MainPlugin plugin){
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void inClick(InventoryClickEvent e){
		if(e.getInventory().getName().equals("Einstellungen")){
			if(e.getCurrentItem().getType() == Material.SKULL_ITEM){
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("Spieler")){
					ItemStack back = new ItemStack(Material.LAVA_BUCKET);
					ItemMeta backmeta = back.getItemMeta();
					backmeta.setDisplayName("§4Zurück");
					back.setItemMeta(backmeta);
					spieler.setItem(8, back);
					e.getWhoClicked().openInventory(spieler);
				}
			}
		}
	}

}
