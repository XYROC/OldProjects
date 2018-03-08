package me.xiroc.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KitWizard {
	
	private KitItems ki;
	
	public void setKitItems(int kitLevel, Player player){
		// Effects[]: Count of Effects, Regeneration, Fire Resistance, Night Vision, Resistance 
		
		ItemStack sword = new ItemStack(Material.IRON_SWORD);
		sword.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		
		ItemStack staff = new ItemStack(Material.STICK);
		staff.addUnsafeEnchantment(Enchantment.FIRE_ASPECT,2);
		for (PotionEffect effect : player.getActivePotionEffects())
			player.removePotionEffect(effect.getType());
		player.getInventory().clear();
		player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
		player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
		player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
		
		switch(kitLevel){
		case 1:
			player.getInventory().addItem(sword);
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, ki.getWizardEffectLevel(kitLevel)[2]));
			break;
		case 2:
			player.getInventory().addItem(sword);
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, /*ki.getWizardEffectLevel(kitLevel)[2]*/ 1));
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000,/*ki.getWizardEffectLevel(kitLevel)[3]*/ 1));
			break;
		case 3:
			player.getInventory().addItem(sword);
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 2));
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 1));
			break;
		case 4:
			player.getInventory().addItem(sword);
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 2));
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 1));
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 1));
			break;
		case 5:
			player.getInventory().addItem(sword);
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 1));
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 1));
			break;
		case 6:
			player.getInventory().addItem(sword);
			player.getInventory().addItem(staff);
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 1));
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 1));
			break;
		case 7:
			player.getInventory().addItem(sword);
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 1));
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 1));
			break;
		case 8:
			player.getInventory().addItem(sword);
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 1));
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 1));
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 1));
			break;
		case 9:
			player.getInventory().addItem(sword);
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 3));
			player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 1));
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 1));
			player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 2));
			break;
		default: break;
		}
		//player.getInventory().addItem(Kit.addEnchantment(new ItemStack(Material.STICK), Enchantment.FIRE_ASPECT, 1));
	}
}
