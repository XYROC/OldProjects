package Chest;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import main.SurvivalGames;

public class ChestManager implements Listener{
	
	private SurvivalGames plugin;
	
	public ChestManager(SurvivalGames plugin){
		
		this.plugin = plugin;
	}
	
	@EventHandler
	public void InteractEvent(PlayerInteractEvent evt){
		Player p = evt.getPlayer();	
		if((evt.getAction() == Action.RIGHT_CLICK_BLOCK)&&
			(evt.getClickedBlock().getType() == Material.OBSIDIAN)){
			if(this.plugin.sgchest.containsKey(evt.getClickedBlock().getLocation())){
				p.openInventory((Inventory) this.plugin.sgchest.get(evt.getClickedBlock().getLocation()));
			}else{
				
				Random rnd = new Random();
				int n = 1;
				n = rnd.nextInt(6);
				Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST);
				List<ItemStack> items = new ArrayList<ItemStack>();
				
				items.add(new ItemStack(Material.DIAMOND));
				items.add(new ItemStack(Material.WOOD_SWORD));
				items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
				items.add(new ItemStack(Material.COOKED_BEEF,5));
				items.add(new ItemStack(Material.COOKED_BEEF,2));
				items.add(new ItemStack(Material.SEEDS));
				items.add(new ItemStack(Material.GOLD_HOE));
				items.add(new ItemStack(Material.IRON_SWORD));
				items.add(new ItemStack(Material.IRON_CHESTPLATE));
				items.add(new ItemStack(Material.GOLD_CHESTPLATE));
				items.add(new ItemStack(Material.GOLD_SWORD));
				items.add(new ItemStack(Material.ARROW,5));
				items.add(new ItemStack(Material.ARROW,2));
				items.add(new ItemStack(Material.GOLDEN_APPLE));
				items.add(new ItemStack(Material.GOLD_SPADE));
				items.add(new ItemStack(Material.GOLDEN_CARROT,1));
				items.add(new ItemStack(Material.BOW));
				items.add(new ItemStack(Material.GOLD_AXE));
				items.add(new ItemStack(Material.CHAINMAIL_LEGGINGS));
				items.add(new ItemStack(Material.GOLD_BOOTS));
				items.add(new ItemStack(Material.CHAINMAIL_HELMET));
				items.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
				items.add(new ItemStack(Material.STICK,4));
				items.add(new ItemStack(Material.STICK,2));
				items.add(new ItemStack(Material.STICK));
				items.add(new ItemStack(Material.IRON_LEGGINGS));
				items.add(new ItemStack(Material.RAW_BEEF,10));
				items.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
				items.add(new ItemStack(Material.FLINT_AND_STEEL));
				items.add(new ItemStack(Material.IRON_BOOTS));
				items.add(new ItemStack(Material.POTATO,5));
				items.add(new ItemStack(Material.CARROT,7));
				items.add(new ItemStack(Material.DIAMOND_HELMET));
				items.add(new ItemStack(Material.DIAMOND_HOE));
				items.add(new ItemStack(Material.IRON_HOE));
				items.add(new ItemStack(Material.DIAMOND,2));
				items.add(new ItemStack(Material.DIAMOND_SWORD));
				items.add(new ItemStack(Material.STONE_SWORD));
				items.add(new ItemStack(Material.STONE_HOE));
				items.add(new ItemStack(Material.STONE_PICKAXE));
				items.add(new ItemStack(Material.STONE_AXE));
				items.add(new ItemStack(Material.TNT,2));
				items.add(new ItemStack(Material.TNT,4));
				items.add(new ItemStack(Material.TNT));
				items.add(new ItemStack(Material.REDSTONE,3));
				items.add(new ItemStack(Material.REDSTONE,5));
				items.add(new ItemStack(Material.DIRT,7));
				items.add(new ItemStack(Material.SAND,4));
				items.add(new ItemStack(Material.SANDSTONE,6));
				items.add(new ItemStack(Material.COBBLESTONE,2));
				items.add(new ItemStack(Material.DIAMOND_PICKAXE));
				items.add(new ItemStack(Material.GOLD_PICKAXE));
				items.add(new ItemStack(Material.APPLE,8));
				items.add(new ItemStack(Material.BAKED_POTATO,6));
				items.add(new ItemStack(Material.RAW_CHICKEN));
				items.add(new ItemStack(Material.COOKED_CHICKEN));
				items.add(new ItemStack(Material.ENDER_PEARL));
				items.add(new ItemStack(Material.GOLD_CHESTPLATE));
				
				
				
				while(n != 0){
					n--;
					Random rnd2 = new Random();
					Random rnd3 = new Random();
					
					int n2 = rnd2.nextInt(items.size());
					int n3 = rnd3.nextInt(27);
					
					inv.setItem(n3, (ItemStack) items.get(n2));
							
				}
				this.plugin.sgchest.put(evt.getClickedBlock().getLocation(), inv);
				p.openInventory(inv);
				return;
				
				
			}
			return;
			
				
				
			}
			
		
			
			
			
			
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
