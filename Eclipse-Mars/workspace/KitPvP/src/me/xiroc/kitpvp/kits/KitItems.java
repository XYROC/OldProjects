package me.xiroc.kitpvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class KitItems {

	public KitItems() {

	}

	public ItemStack getWarriorSword(int level) {
		ItemStack DefSchwert = new ItemStack(Material.IRON_SWORD, 1);
		DefSchwert.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		switch (level) {
		case 1:
			ItemStack Schwert1 = new ItemStack(Material.IRON_SWORD, 1);
			Schwert1.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert1.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
			return Schwert1;
		case 2:
			ItemStack Schwert2 = new ItemStack(Material.IRON_SWORD, 1);
			Schwert2.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert2.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
			return Schwert2;
		case 3:
			ItemStack Schwert3 = new ItemStack(Material.IRON_SWORD, 1);
			Schwert3.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert3.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
			Schwert3.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
			return Schwert3;
		case 4:
			ItemStack Schwert4 = new ItemStack(Material.IRON_SWORD, 1);
			Schwert4.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert4.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
			Schwert4.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			return Schwert4;
		case 5:
			ItemStack Schwert5 = new ItemStack(Material.IRON_SWORD, 1);
			Schwert5.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert5.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
			Schwert5.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			return Schwert5;
		case 6:
			ItemStack Schwert6 = new ItemStack(Material.IRON_SWORD, 1);
			Schwert6.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert6.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
			Schwert6.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			return Schwert6;
		case 7:
			ItemStack Schwert7 = new ItemStack(Material.IRON_SWORD, 1);
			Schwert7.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert7.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
			Schwert7.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			Schwert7.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
			return Schwert7;
		case 8:
			ItemStack Schwert8 = new ItemStack(Material.IRON_SWORD, 1);
			Schwert8.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert8.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
			Schwert8.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			Schwert8.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
			return Schwert8;
		case 9:
			ItemStack Schwert9 = new ItemStack(Material.DIAMOND_SWORD, 1);
			Schwert9.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert9.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
			Schwert9.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			Schwert9.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
			return Schwert9;
		default:
			return DefSchwert;

		}
	}

	public ItemStack getArchersBow(int level) {
		ItemStack DefBow = new ItemStack(Material.BOW, 1);
		DefBow.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		DefBow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 3);

		switch (level) {
		case 1:
			ItemStack Bow1 = new ItemStack(Material.BOW, 1);
			Bow1.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Bow1.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
			Bow1.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
			return Bow1;
		case 2:
			ItemStack Bow2 = new ItemStack(Material.BOW, 1);
			Bow2.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Bow2.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
			Bow2.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
			return Bow2;
		case 3:
			ItemStack Bow3 = new ItemStack(Material.BOW, 1);
			Bow3.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Bow3.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
			Bow3.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
			return Bow3;
		case 4:
			ItemStack Bow4 = new ItemStack(Material.BOW, 1);
			Bow4.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Bow4.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
			Bow4.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
			return Bow4;
		case 5:
			ItemStack Bow5 = new ItemStack(Material.BOW, 1);
			Bow5.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Bow5.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 3);
			Bow5.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
			return Bow5;
		case 6:
			ItemStack Bow6 = new ItemStack(Material.BOW, 1);
			Bow6.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Bow6.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
			Bow6.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
			return Bow6;
		case 7:
			ItemStack Bow7 = new ItemStack(Material.BOW, 1);
			Bow7.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Bow7.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
			Bow7.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
			Bow7.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
			return Bow7;
		case 8:
			ItemStack Bow8 = new ItemStack(Material.BOW, 1);
			Bow8.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Bow8.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
			Bow8.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
			Bow8.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
			return Bow8;
		case 9:
			ItemStack Bow9 = new ItemStack(Material.BOW, 1);
			Bow9.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Bow9.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
			Bow9.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
			Bow9.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
			Bow9.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
			return Bow9;
		default:
			return DefBow;

		}
	}

	public ItemStack getZombieArmor(int level) {
		ItemStack DefCh = new ItemStack(Material.GOLD_CHESTPLATE, 1);
		DefCh.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		switch (level) {
		case 1:
			ItemStack Schwert1 = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			Schwert1.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			return Schwert1;
		case 2:
			ItemStack Schwert2 = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			Schwert2.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			return Schwert2;
		case 3:
			ItemStack Schwert3 = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			Schwert3.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			Schwert3.addUnsafeEnchantment(Enchantment.THORNS, 1);
			return Schwert3;
		case 4:
			ItemStack Schwert4 = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			Schwert4.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert4.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			Schwert4.addUnsafeEnchantment(Enchantment.THORNS, 2);
			return Schwert4;
		case 5:
			ItemStack Schwert5 = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			Schwert5.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert5.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			Schwert5.addUnsafeEnchantment(Enchantment.THORNS, 2);
			return Schwert5;
		case 6:
			ItemStack Schwert6 = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			Schwert6.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert6.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			Schwert6.addUnsafeEnchantment(Enchantment.THORNS, 2);
			return Schwert6;
		case 7:
			ItemStack Schwert7 = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			Schwert7.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert7.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			Schwert7.addUnsafeEnchantment(Enchantment.THORNS, 3);
			return Schwert7;
		case 8:
			ItemStack Schwert8 = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			Schwert8.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert8.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			Schwert8.addUnsafeEnchantment(Enchantment.THORNS, 4);
			return Schwert8;
		case 9:
			ItemStack Schwert9 = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			Schwert9.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			Schwert9.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Schwert9.addUnsafeEnchantment(Enchantment.THORNS, 5);
			return Schwert9;
		default:
			return DefCh;

		}
	}

	public ItemStack getTankChestPlate(int level) {
		ItemStack DefItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
		DefItem.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		switch (level) {
		case 1:
			ItemStack Item1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
			Item1.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			Item1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			return Item1;
		case 2:
			ItemStack Item2 = new ItemStack(Material.DIAMOND_CHESTPLATE);
			Item2.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			Item2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			return Item2;
		case 3:
			ItemStack Item3 = new ItemStack(Material.DIAMOND_CHESTPLATE);
			Item3.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			Item3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			Item3.addUnsafeEnchantment(Enchantment.THORNS, 1);
			return Item3;
		case 4:
			ItemStack Item4 = new ItemStack(Material.DIAMOND_CHESTPLATE);
			Item4.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			Item4.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			Item4.addUnsafeEnchantment(Enchantment.THORNS, 1);
			return Item4;
		case 5:
			ItemStack Item5 = new ItemStack(Material.DIAMOND_CHESTPLATE);
			Item5.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			Item5.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			Item5.addUnsafeEnchantment(Enchantment.THORNS, 2);
			return Item5;
		case 6:
			ItemStack Item6 = new ItemStack(Material.DIAMOND_CHESTPLATE);
			Item6.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			Item6.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			Item6.addUnsafeEnchantment(Enchantment.THORNS, 2);
			return Item6;
		case 7:
			ItemStack Item7 = new ItemStack(Material.DIAMOND_CHESTPLATE);
			Item7.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			Item7.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Item7.addUnsafeEnchantment(Enchantment.THORNS, 2);
			return Item7;
		case 8:
			ItemStack Item8 = new ItemStack(Material.DIAMOND_CHESTPLATE);
			Item8.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			Item8.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Item8.addUnsafeEnchantment(Enchantment.THORNS, 3);
			return Item8;
		case 9:
			ItemStack Item9 = new ItemStack(Material.DIAMOND_CHESTPLATE);
			Item9.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			Item9.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			Item9.addUnsafeEnchantment(Enchantment.THORNS, 4);
		default:
			return DefItem;
		}
	}

	public int[] getWizardEffectLevel(int level) {
		int[] def = { 0, 0 };
		// Effects[]: Count of Effects, Regeneration, Fire Resistance, Night
		// Vision, Resistance
		switch (level) {
		case 1:
			int[] lv1 = { 1, 1 };
			return lv1;
		case 2:
			int[] lv2 = { 2, 1, 1 };
			return lv2;
		case 3:
			int[] lv3 = { 2, 2, 1 };
			return lv3;
		case 4:
			int[] lv4 = { 3, 2, 1, 1 };
			return lv4;
		case 5:
			int[] lv5 = { 3, 3, 1, 1 };
			return lv5;
		case 6:
			// + Staff
			int[] lv6 = { 3, 2, 1, 1 };
			return lv6;
		case 7:
			// Better Staff
			int[] lv7 = { 3, 2, 1, 1 };
			return lv7;
		case 8:
			int[] lv8 = { 4, 2, 1, 1, 1 };
			return lv8;
		case 9:
			int[] lv9 = { 4, 2, 1, 1, 2 };
			return lv9;
		default:
			return def;
		}
	}

	public ItemStack getAssasinChestPlate(int level) {
		ItemStack def = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		def.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		def.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		switch (level) {
		case 1:
			ItemStack i1 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			i1.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			i1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			return i1;
		case 2:
			ItemStack i2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			i2.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			i2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			return i2;
		case 3:
			ItemStack i3 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			i3.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			i3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			i3.addUnsafeEnchantment(Enchantment.THORNS, 1);
			return i3;
		case 4:
			ItemStack i4 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			i4.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			i4.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			i4.addUnsafeEnchantment(Enchantment.THORNS, 1);
			return i4;
		case 5:
			ItemStack i5 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			i5.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			i5.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
			i5.addUnsafeEnchantment(Enchantment.THORNS, 2);
			return i5;
		case 6:
			ItemStack i6 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			i6.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			i6.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			i6.addUnsafeEnchantment(Enchantment.THORNS, 2);
			return i6;
		case 7:
			ItemStack i7 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			i7.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
			i7.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			i7.addUnsafeEnchantment(Enchantment.THORNS, 3);
			return i7;
		default:
			return def;
		}
	}
}
