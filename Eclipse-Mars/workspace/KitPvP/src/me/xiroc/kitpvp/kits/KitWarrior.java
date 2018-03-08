package me.xiroc.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KitWarrior {
	
	private KitItems ki = new KitItems();
	
	public void setKitItems(int kitlevel,Player player){
		player.getInventory().clear();
		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
		ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack leggins = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		leggins.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		switch (kitlevel){
		case 1:
			player.getInventory().addItem(ki.getWarriorSword(kitlevel));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(chestplate);
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 2:
			player.getInventory().addItem(ki.getWarriorSword(kitlevel));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(chestplate);
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 3:
			player.getInventory().addItem(ki.getWarriorSword(kitlevel));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(chestplate);
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 4:
			player.getInventory().addItem(ki.getWarriorSword(kitlevel));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(chestplate);
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 5:
			player.getInventory().addItem(ki.getWarriorSword(kitlevel));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(chestplate);
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 6:
			player.getInventory().addItem(ki.getWarriorSword(kitlevel));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(chestplate);
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 7:
			player.getInventory().addItem(ki.getWarriorSword(kitlevel));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(chestplate);
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 8:
			player.getInventory().addItem(ki.getWarriorSword(kitlevel));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(chestplate);
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		case 9:
			player.getInventory().addItem(ki.getWarriorSword(kitlevel));
			player.getInventory().setHelmet(helmet);
			player.getInventory().setChestplate(chestplate);
			player.getInventory().setLeggings(leggins);
			player.getInventory().setBoots(boots);
			break;
		default: break;
		}
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 2));
	}

}
