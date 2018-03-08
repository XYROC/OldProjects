package me.xiroc.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class KitDefault {
		
	public void setKitItems(Player p){
		for (PotionEffect effect : p.getActivePotionEffects())
			p.removePotionEffect(effect.getType());
		p.getInventory().clear();
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
		p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
		p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
	}
	
	
}
