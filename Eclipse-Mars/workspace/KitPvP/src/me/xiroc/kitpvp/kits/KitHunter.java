package me.xiroc.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class KitHunter {
	
	public void setKitItems(Player p, int level){
		for (PotionEffect effect : p.getActivePotionEffects())
			p.removePotionEffect(effect.getType());
		p.getInventory().clear();
		p.getInventory().setChestplate(Kit.addEnchantment(new ItemStack(Material.IRON_CHESTPLATE), Enchantment.PROTECTION_ENVIRONMENTAL, 4 + (level-3)));
		p.getInventory().setHelmet(Kit.addEnchantment(new ItemStack(Material.IRON_HELMET), Enchantment.PROTECTION_ENVIRONMENTAL, 3 + (level-2)));
		p.getInventory().setLeggings(Kit.addEnchantment(new ItemStack(Material.IRON_LEGGINGS), Enchantment.PROTECTION_ENVIRONMENTAL, 3 + (level-2)));
		p.getInventory().setBoots(Kit.addEnchantment(new ItemStack(Material.IRON_BOOTS), Enchantment.PROTECTION_ENVIRONMENTAL, 3 + (level-2)));
		p.getInventory().addItem(Kit.addEnchantment(new ItemStack(Material.IRON_SWORD), Enchantment.DAMAGE_ALL, 3 + (level-2)));
		p.getInventory().addItem(Kit.addEnchantment(Kit.addEnchantment(new ItemStack(Material.BOW), Enchantment.ARROW_INFINITE, 1), Enchantment.ARROW_DAMAGE, 3 + (level-4)));
	}
	
	
}
