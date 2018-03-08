package xiroc.economy.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import xiroc.economy.Economy;

public class ShopBuyFoodListener implements Listener {

	private Economy plugin;

	String prefix = ChatColor.GREEN + "[" + ChatColor.AQUA + "Economy" + ChatColor.GREEN + "] ";

	public ShopBuyFoodListener(Economy plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		System.out.println("[Economy] ShopBuyFoodListener Enabled");
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getName().equals("Essen")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.COOKED_BEEF) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Kaufe Steak")) {
					if (this.plugin.getMoney(p.getName()) - 1 < 0) {
						p.sendMessage(prefix + ChatColor.RED + "Du hast zu wenig Geld!");
					} else {
						this.plugin.removeMoney(p.getName(), 1);
						p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 1));
					}
				}
			}
			if (e.getCurrentItem().getType() == Material.APPLE) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Kaufe Apfel")) {
					if (this.plugin.getMoney(p.getName()) - 1 < 0) {
						p.sendMessage(prefix + ChatColor.RED + "Du hast zu wenig Geld!");
					} else {
						this.plugin.removeMoney(p.getName(), 1);
						p.getInventory().addItem(new ItemStack(Material.APPLE, 1));
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
