package xiroc.economy.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import xiroc.economy.Economy;

public class ShopBuyBlocksListener implements Listener {

	private Economy plugin;

	public ShopBuyBlocksListener(Economy plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		System.out.println("[Economy] ShopBuyBlocksListener Enabled");
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equals("Blöcke")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STONE) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Kaufe Stein")) {
					if (this.plugin.getMoney(p.getName()) - 1 < 0) {
						p.sendMessage(Economy.prefix + ChatColor.RED + "Du hast nicht genug Gems!");
					} else {
						this.plugin.removeMoney(p.getName(), 1);
						p.getInventory().addItem(new ItemStack(Material.STONE, 2));
					}
				}
			}
			if (e.getCurrentItem().getType() == Material.BRICK) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Kaufe Ziegel")) {
					if (this.plugin.getMoney(p.getName()) - 1 < 0) {
						p.sendMessage(Economy.prefix + ChatColor.RED + "Du nicht genug Gems!");
					} else {
						this.plugin.removeMoney(p.getName(), 1);
						p.getInventory().addItem(new ItemStack(Material.BRICK, 2));
					}
				}
			}
			if (e.getCurrentItem().getType() == Material.SANDSTONE) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Kaufe Sandstein")) {
					if (this.plugin.getMoney(p.getName()) - 1 < 0) {
						p.sendMessage(Economy.prefix + ChatColor.RED + "Du hast nicht genug Gems!");
					} else {
						this.plugin.removeMoney(p.getName(), 1);
						p.getInventory().addItem(new ItemStack(Material.SANDSTONE, 2));
					}
				}
			}
			if (e.getCurrentItem().getType() == Material.COBBLESTONE) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Kaufe Bruchstein")) {
					if (this.plugin.getMoney(p.getName()) - 1 < 0) {
						p.sendMessage(Economy.prefix + ChatColor.RED + "Du hast nicht genug Gems!");
					} else {
						this.plugin.removeMoney(p.getName(), 1);
						p.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 2));
					}
				}
			}
			if (e.getCurrentItem().getType() == Material.RED_SANDSTONE) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Kaufe roten Sandstein")) {
					if (this.plugin.getMoney(p.getName()) - 1 < 0) {
						p.sendMessage(Economy.prefix + ChatColor.RED + "Du hast nicht genug Gems!");
					} else {
						this.plugin.removeMoney(p.getName(), 1);
						p.getInventory().addItem(new ItemStack(Material.RED_SANDSTONE, 2));
					}
				}
			}
			if(e.getCurrentItem().getType() == Material.LAVA_BUCKET){
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Zurück")){
					e.getView().close();
					p.getPlayer().openInventory(this.plugin.shopmain);
				}
			}
		}

	}

}
