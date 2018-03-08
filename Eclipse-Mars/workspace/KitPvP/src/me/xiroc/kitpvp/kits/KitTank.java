package me.xiroc.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitTank {

	public void setKit(Player p, int kitLevel) {
		p.getInventory().clear();
		if (kitLevel < 7) {
			p.getInventory().setHelmet(Kit.addEnchantment(Kit.addEnchantment(new ItemStack(Material.DIAMOND_HELMET), Enchantment.PROTECTION_ENVIRONMENTAL, kitLevel+1), Enchantment.DURABILITY, 10));
			p.getInventory().setChestplate(Kit.addEnchantment(Kit.addEnchantment(new ItemStack(Material.IRON_CHESTPLATE), Enchantment.PROTECTION_ENVIRONMENTAL, kitLevel+1), Enchantment.DURABILITY, 10));
			p.getInventory().setLeggings(Kit.addEnchantment(Kit.addEnchantment(new ItemStack(Material.DIAMOND_LEGGINGS), Enchantment.PROTECTION_ENVIRONMENTAL, kitLevel+1), Enchantment.DURABILITY, 10));
			p.getInventory().setBoots(Kit.addEnchantment(Kit.addEnchantment(new ItemStack(Material.DIAMOND_BOOTS), Enchantment.PROTECTION_ENVIRONMENTAL, kitLevel+1), Enchantment.DURABILITY, 10));
			p.getInventory().setHeldItemSlot(0);
			p.getInventory().addItem(Kit.setDurability(-1, Kit.addEnchantment(new ItemStack(Material.WOOD_SWORD), Enchantment.DURABILITY, 255)));
		} else {
			p.getInventory().setHelmet(Kit.addEnchantment(Kit.addEnchantment(new ItemStack(Material.DIAMOND_HELMET), Enchantment.PROTECTION_ENVIRONMENTAL, kitLevel+1), Enchantment.DURABILITY, 10));
			p.getInventory().setChestplate(Kit.addEnchantment(Kit.addEnchantment(new ItemStack(Material.DIAMOND_CHESTPLATE), Enchantment.PROTECTION_ENVIRONMENTAL, kitLevel+1), Enchantment.DURABILITY, 10));
			p.getInventory().setLeggings(Kit.addEnchantment(Kit.addEnchantment(new ItemStack(Material.DIAMOND_LEGGINGS), Enchantment.PROTECTION_ENVIRONMENTAL, kitLevel+1), Enchantment.DURABILITY, 10));
			p.getInventory().setBoots(Kit.addEnchantment(Kit.addEnchantment(new ItemStack(Material.DIAMOND_BOOTS), Enchantment.PROTECTION_ENVIRONMENTAL, kitLevel+1), Enchantment.DURABILITY, 10));
			p.getInventory().setHeldItemSlot(0);
			p.getInventory().addItem(Kit.setDurability(-1, Kit.addEnchantment(new ItemStack(Material.WOOD_SWORD), Enchantment.DURABILITY, 255)));
		}
	}

}
