package me.xiroc.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KitZombie {
	
	private KitItems ki = new KitItems();

	public void setKitItems(int level, Player player){
		player.getInventory().clear();
		ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		ItemStack leggins = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		leggins.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		switch (level){
		case 1:
			player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getZombieArmor(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 2:
			player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getZombieArmor(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 3:
			player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getZombieArmor(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 4:
			player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getZombieArmor(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 5:
			player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getZombieArmor(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 6:
			player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getZombieArmor(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 7:
			player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getZombieArmor(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 8:
			player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getZombieArmor(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 9:
			player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(ki.getZombieArmor(level));
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		default: break;
		}
		player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF,64));
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 3));
	}
}
