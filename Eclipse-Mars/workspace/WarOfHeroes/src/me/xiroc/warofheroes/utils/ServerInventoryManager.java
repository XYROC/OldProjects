package me.xiroc.warofheroes.utils;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ServerInventoryManager{
	
	private Inventory inv;
	
	@SuppressWarnings("deprecation")
	public Inventory getSearchInventory(int process){
		inv = Bukkit.getServer().createInventory(null, 9,"§aSuche...");
		if(process > 9) process = 9;
		if(process < 0) process = 0;
		inv.setItem(0, new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData()));
		inv.setItem(1, new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData()));
		inv.setItem(2, new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData()));
		inv.setItem(3, new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData()));
		inv.setItem(4, new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData()));
		inv.setItem(5, new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData()));
		inv.setItem(6, new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData()));
		inv.setItem(7, new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData()));
		inv.setItem(8, new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData()));
		for(int i = 0; i<process;i++){
			inv.setItem(i, new ItemStack(Material.WOOL, 1, DyeColor.LIME.getWoolData()));
		}
		return inv;
	}

}
