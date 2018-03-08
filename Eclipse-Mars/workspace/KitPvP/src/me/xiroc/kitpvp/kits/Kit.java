package me.xiroc.kitpvp.kits;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Kit {
	
	public static final int STANDARD = 0;
	public static final int WARRIOR = 1;
	public static final int ARCHER = 2;
	public static final int ZOMBIE = 3;
	public static final int WIZARD = 4;
	public static final int TANK = 5;
	public static final int HUNTER = 6;
	public static final int ASSASSIN = 7;
	
	public static ItemStack addEnchantment(ItemStack itemStack, Enchantment ench, int level){
		itemStack.addUnsafeEnchantment(ench, level);
		return itemStack;
	}
	public static ItemStack setDurability(int durability, ItemStack stack){
		stack.setDurability((short) durability);
		return stack;
	}
	
}
