package xiroc.economy.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import xiroc.economy.Economy;

public class ShopMainListener implements Listener{
	
	private Economy plugin;
	
	Inventory buyBlocks;
	Inventory buyFood;
	
	public ShopMainListener(Economy plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this,plugin);
		System.out.println("[Economy] ShopMainListener Enabled");
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		
		
		if(e.getInventory().getName().equals("Shop")){
			e.setCancelled(true);
			if(e.getCurrentItem().getType() == Material.STONE){
				e.getView().close();
				
				buyBlocks = p.getServer().createInventory(null, 9,"Blöcke");
				
				ItemStack buyStone = new ItemStack(Material.STONE);
				ItemMeta buyStoneMeta = buyStone.getItemMeta();
				buyStoneMeta.setDisplayName("Kaufe Stein");
				buyStone.setItemMeta(buyStoneMeta);
				
				ItemStack buyBricks = new ItemStack(Material.BRICK);
				ItemMeta buyBricksMeta = buyBricks.getItemMeta();
				buyBricksMeta.setDisplayName("Kaufe Ziegel");
				buyBricks.setItemMeta(buyBricksMeta);
				
				ItemStack buySandStone = new ItemStack(Material.SANDSTONE);
				ItemMeta buySandStoneMeta = buyStone.getItemMeta();
				buySandStoneMeta.setDisplayName("Kaufe Sandstein");
				buySandStone.setItemMeta(buySandStoneMeta);
				
				ItemStack buyCobble = new ItemStack(Material.COBBLESTONE);
				ItemMeta buyCobbleMeta = buyStone.getItemMeta();
				buyCobbleMeta.setDisplayName("Kaufe Bruchstein");
				buyCobble.setItemMeta(buyCobbleMeta);
				
				ItemStack buyRedSandstone = new ItemStack(Material.RED_SANDSTONE);
				ItemMeta buyRedSandstoneMeta = buyStone.getItemMeta();
				buyRedSandstoneMeta.setDisplayName("Kaufe roten Sandstein");
				buyRedSandstone.setItemMeta(buyRedSandstoneMeta);
				
				ItemStack back = new ItemStack(Material.LAVA_BUCKET);
				ItemMeta backMeta = back.getItemMeta();
				backMeta.setDisplayName("§4Zurück");
				back.setItemMeta(backMeta);
				
				
				
				
				buyBlocks.setItem(1, buyStone);
				buyBlocks.setItem(2, buyBricks);
				buyBlocks.setItem(3, buySandStone);
				buyBlocks.setItem(4, buyCobble);
				buyBlocks.setItem(5, buyRedSandstone);
				buyBlocks.setItem(8, back);
				
				p.getPlayer().openInventory(buyBlocks);
				
				
			}
			
			if(e.getCurrentItem().getType() == Material.COOKED_BEEF){
				
				e.getView().close();
				
				buyFood = p.getPlayer().getServer().createInventory(null, 9,"Essen");
				
				ItemStack buyCookedBeef = new ItemStack(Material.COOKED_BEEF);
				ItemMeta buyCookedBeefMeta = buyCookedBeef.getItemMeta();
				buyCookedBeefMeta.setDisplayName("Kaufe Steak");
				buyCookedBeef.setItemMeta(buyCookedBeefMeta);
				
				ItemStack buyApple = new ItemStack(Material.COOKED_BEEF);
				ItemMeta buyAppleMeta = buyCookedBeef.getItemMeta();
				buyAppleMeta.setDisplayName("Kaufe Apfel");
				buyApple.setItemMeta(buyAppleMeta);
				
				ItemStack back = new ItemStack(Material.LAVA_BUCKET);
				ItemMeta backMeta = back.getItemMeta();
				backMeta.setDisplayName("§4Zurück");
				back.setItemMeta(backMeta);
				
				buyFood.setItem(0, buyCookedBeef);
				buyFood.setItem(8, back);
				
				p.getPlayer().openInventory(buyFood);
				
				
			}
			
		}
	}

}
