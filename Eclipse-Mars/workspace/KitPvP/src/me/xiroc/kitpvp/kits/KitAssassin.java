package me.xiroc.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitAssassin {

	private KitItems ki;
	
	public void setKitItems(Player player, int level){
		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		ItemStack leggins = new ItemStack(Material.IRON_LEGGINGS);
		leggins.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		leggins.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		sword.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3 + level);
		player.getInventory().setHelmet(helmet);
		player.getInventory().setLeggings(leggins);
		player.getInventory().setBoots(boots);
		player.getInventory().setChestplate(ki.getAssasinChestPlate(level));
		player.getInventory().addItem(sword);
	}
	
}
