package me.xiroc.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class KitTankOLD {
	
	private KitItems ki;
	
	public void setKitItems(int level, Player player){
		player.getInventory().clear();
		ItemStack sword = new ItemStack(Material.WOOD_SWORD);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		sword.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemStack leggins = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		leggins.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		player.getInventory().addItem(sword);
		switch (level){
		case 1:
			player.getInventory().addItem(sword);
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getTankChestPlate(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 2:
			player.getInventory().addItem(sword);
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getTankChestPlate(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 3:
			player.getInventory().addItem(sword);
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getTankChestPlate(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 4:
			player.getInventory().addItem(sword);
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getTankChestPlate(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 5:
			player.getInventory().addItem(sword);
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getTankChestPlate(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 6:
			player.getInventory().addItem(sword);
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getTankChestPlate(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 7:
			player.getInventory().addItem(sword);
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getTankChestPlate(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 8:
			player.getInventory().addItem(sword);
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getTankChestPlate(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 9:
			player.getInventory().addItem(sword);
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getTankChestPlate(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		default: break;
		}
		player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF,64));
		player.getInventory().addItem(new ItemStack(Material.ARROW));
	}

}
