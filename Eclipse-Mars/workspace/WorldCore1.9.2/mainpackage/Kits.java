package mainpackage;

import java.io.PrintStream;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Kits implements Listener {
	private MainPlugin plugin;

	public Kits(MainPlugin plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		System.out.println("[WorldCore] Activated Class Kits (v 0.2)");
	}

	@EventHandler
	public void Inventory(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		int lv = p.getLevel();
		if (event.getInventory().getName().equalsIgnoreCase("Kits")) {
			event.setCancelled(true);

			ItemStack HuntersSword = new ItemStack(Material.IRON_SWORD);
			HuntersSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
			HuntersSword.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

			ItemStack HuntersBow = new ItemStack(Material.BOW);
			HuntersBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 8);
			HuntersBow.addUnsafeEnchantment(Enchantment.DURABILITY, 10);

			ItemStack Schwert = new ItemStack(Material.IRON_SWORD, 1);
			Schwert.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			Schwert.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

			ItemStack DragonFire = new ItemStack(Material.FIREBALL);
			ItemMeta dragonfiremeta = DragonFire.getItemMeta();
			dragonfiremeta.setDisplayName("§4DRAGONFIRE");
			DragonFire.setItemMeta(dragonfiremeta);
			DragonFire.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);

			ItemStack DragonChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
			DragonChestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			DragonChestplate.addUnsafeEnchantment(Enchantment.THORNS, 3);
			DragonChestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

			ItemStack DragonSword = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta dragonmeta = DragonSword.getItemMeta();
			dragonmeta.setDisplayName("§4DRAGON SWORD");
			DragonSword.setItemMeta(dragonmeta);
			DragonSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
			DragonSword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			DragonSword.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

			ItemStack DragonBow = new ItemStack(Material.BOW);
			DragonBow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
			DragonBow.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			DragonBow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
			DragonBow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
			DragonBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 5);

			ItemStack AssasinR = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
			AssasinR.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			AssasinR.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

			ItemStack AssasinB = new ItemStack(Material.IRON_BOOTS, 1);
			AssasinB.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 3);

			ItemStack Bogen = new ItemStack(Material.BOW, 1);
			Bogen.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
			Bogen.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
			Bogen.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

			ItemStack woodensword = new ItemStack(Material.WOOD_SWORD, 1);
			woodensword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
			woodensword.addUnsafeEnchantment(Enchantment.DURABILITY, 3);

			ItemStack AssasinBow = new ItemStack(Material.BOW);
			AssasinBow.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			AssasinBow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);

			ItemStack AssasinSword = new ItemStack(Material.IRON_SWORD);
			AssasinSword.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
			AssasinSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);

			if (event.getCurrentItem().getType() == Material.IRON_SWORD) {
				this.plugin.warrior.add(p);
				this.plugin.archer.remove(p);
				this.plugin.zombie.remove(p);
				this.plugin.dragon.remove(p);
				this.plugin.hunter.remove(p);
				this.plugin.wizard.remove(p);
				this.plugin.assasin.remove(p);
				this.plugin.nuker.remove(p);
				if (p.getLevel() >= 45) {
					for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					p.getInventory().clear();
					p.getInventory().addItem(new ItemStack[] { Schwert });
					p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
					p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
					p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
					p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COOKED_BEEF, 32) });
					p.sendMessage(ChatColor.YELLOW + "Du hast das Kit " + ChatColor.GREEN + "Krieger" + ChatColor.YELLOW
							+ " ausgewählt!");
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 1));
					event.getView().close();
				} else {
					p.sendMessage(ChatColor.RED + "Du hast zu wenig Erfahrungspunkte!" + ChatColor.GREEN + "("
							+ ChatColor.RED + lv + ChatColor.GREEN + "/45) EP");
				}
			}

			if (event.getCurrentItem().getType() == Material.POTION) {
				this.plugin.warrior.remove(p);
				this.plugin.archer.remove(p);
				this.plugin.zombie.remove(p);
				this.plugin.dragon.remove(p);
				this.plugin.hunter.remove(p);
				this.plugin.wizard.add(p);
				this.plugin.assasin.remove(p);
				this.plugin.nuker.remove(p);
				if (p.getLevel() >= 40) {
					for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					p.getInventory().clear();
					p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
					p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
					p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.IRON_SWORD) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COOKED_BEEF, 32) });
					p.sendMessage(ChatColor.YELLOW + "Du hast das Kit " + ChatColor.GREEN + "Magier" + ChatColor.YELLOW
							+ " ausgewählt!");
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1000000, 1));
					event.getView().close();
				} else {
					p.sendMessage(ChatColor.RED + "Du hast zu wenig Erfahrungspunkte!" + ChatColor.GREEN + "("
							+ ChatColor.RED + lv + ChatColor.GREEN + "/40) EP");
				}
			}

			if (event.getCurrentItem().getType() == Material.ROTTEN_FLESH) {
				this.plugin.warrior.remove(p);
				this.plugin.archer.remove(p);
				this.plugin.zombie.add(p);
				this.plugin.dragon.remove(p);
				this.plugin.hunter.remove(p);
				this.plugin.wizard.remove(p);
				this.plugin.assasin.remove(p);
				this.plugin.nuker.remove(p);
				if (p.getLevel() >= 25) {
					for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					p.getInventory().clear();
					p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
					p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
					p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
					p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GOLD_SWORD) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COOKED_BEEF, 32) });
					p.sendMessage(ChatColor.YELLOW + "Du hast das Kit " + ChatColor.GREEN + "Zombie" + ChatColor.YELLOW
							+ " ausgewählt!");
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 1));
					event.getView().close();
				} else {
					p.sendMessage(ChatColor.RED + "Du hast zu wenig Erfahrungspunkte!" + ChatColor.GREEN + "("
							+ ChatColor.RED + lv + ChatColor.GREEN + "/25) EP");
				}
			}
			if (event.getCurrentItem().getType() == Material.BOW) {
				this.plugin.warrior.remove(p);
				this.plugin.archer.add(p);
				this.plugin.zombie.remove(p);
				this.plugin.dragon.remove(p);
				this.plugin.hunter.remove(p);
				this.plugin.wizard.remove(p);
				this.plugin.assasin.remove(p);
				this.plugin.nuker.remove(p);
				if (p.getLevel() >= 30) {
					for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					p.getInventory().clear();
					p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
					p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
					p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
					p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
					p.getInventory().addItem(new ItemStack[] { Bogen });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 1) });
					p.getInventory().addItem(new ItemStack[] { woodensword });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COOKED_BEEF, 20) });
					p.sendMessage(ChatColor.YELLOW + "Du hast das Kit " + ChatColor.GREEN + "BogenschÃƒÂ¼tze"
							+ ChatColor.YELLOW + " ausgewählt!");
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 1));

					event.getView().close();
				} else {
					p.sendMessage(ChatColor.RED + "Du hast zu wenig Erfahrungspunkte!" + ChatColor.GREEN + "("
							+ ChatColor.RED + lv + ChatColor.GREEN + "/30) EP");
				}
			}
			if (event.getCurrentItem().getType() == Material.TNT) {
				if (p.getName().equals("Bene85609")) {
					p.sendMessage(ChatColor.RED + "Du wurdest für dieses Kit gesperrt!");
				} else if (p.getLevel() >= 60) {
					for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					p.getInventory().clear();
					p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
					p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
					p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
					p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 1));
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.TNT, 32) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.FLINT_AND_STEEL) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.IRON_SWORD) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COOKED_BEEF, 32) });
					p.sendMessage(ChatColor.YELLOW + "Du hast das Kit " + ChatColor.GREEN + "Nuker" + ChatColor.YELLOW
							+ " ausgewählt!");
					event.getView().close();
				} else {
					p.sendMessage(ChatColor.RED + "Du hast zu wenig Erfahrungspunkte!" + ChatColor.GREEN + "("
							+ ChatColor.RED + lv + ChatColor.GREEN + "/60) EP");
				}

			}

			if (event.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE) {
				this.plugin.warrior.remove(p);
				this.plugin.archer.remove(p);
				this.plugin.zombie.remove(p);
				this.plugin.dragon.remove(p);
				this.plugin.hunter.remove(p);
				this.plugin.wizard.remove(p);
				this.plugin.assasin.add(p);
				this.plugin.nuker.remove(p);
				if (p.getLevel() >= 50) {
					for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					p.getInventory().clear();
					p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
					p.getInventory().setChestplate(AssasinR);
					p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
					p.getInventory().setBoots(AssasinB);
					p.getInventory().addItem(new ItemStack[] { new ItemStack(AssasinSword) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(AssasinBow) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COOKED_BEEF, 32) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW) });
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 1));
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 1));
					event.getView().close();
					p.sendMessage(ChatColor.YELLOW + "Du hast das Kit " + ChatColor.GREEN + "Assasin" + ChatColor.YELLOW
							+ " ausgewählt!");
				} else {
					p.sendMessage(ChatColor.RED + "Du hast zu wenig Erfahrungspunkte!" + ChatColor.GREEN + "("
							+ ChatColor.RED + lv + ChatColor.GREEN + "/50) EP");
				}
			}

			if (event.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
				this.plugin.warrior.remove(p);
				this.plugin.archer.remove(p);
				this.plugin.zombie.remove(p);
				this.plugin.dragon.add(p);
				this.plugin.hunter.remove(p);
				this.plugin.wizard.remove(p);
				this.plugin.assasin.remove(p);
				this.plugin.nuker.remove(p);
				if (p.getLevel() >= 180) {
					for (PotionEffect effect : p.getActivePotionEffects()){
						p.removePotionEffect(effect.getType());
					}
					p.getInventory().clear();
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 3));
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 3));
					p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
					p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
					p.getInventory().setChestplate(DragonChestplate);
					p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
					p.getInventory().addItem(new ItemStack[] { DragonSword });
					p.getInventory().addItem(new ItemStack[] { DragonBow });
					p.getInventory().addItem(new ItemStack[] { DragonFire });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW) });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COOKED_BEEF, 64) });
					p.sendMessage(ChatColor.YELLOW + "Du hast das Kit " + ChatColor.RED + "DRAGON" + ChatColor.YELLOW
							+ " ausgewählt!");
					event.getView().close();
				} else {
					p.sendMessage(ChatColor.RED + "Du hast zu wenig Erfahrungspunkte!" + ChatColor.GREEN + "("
							+ ChatColor.RED + lv + ChatColor.GREEN + "/180) EP");
				}
			}
			if(event.getCurrentItem().getType() == Material.GOLD_AXE){
				this.plugin.warrior.remove(p);
				this.plugin.archer.remove(p);
				this.plugin.zombie.remove(p);
				this.plugin.dragon.add(p);
				this.plugin.hunter.remove(p);
				this.plugin.wizard.remove(p);
				this.plugin.assasin.remove(p);
				this.plugin.nuker.remove(p);
				if(p.getLevel() >= 180){
					for (PotionEffect effect : p.getActivePotionEffects()){
						p.removePotionEffect(effect.getType());
					}
					p.getInventory().clear();
					p.getInventory().addItem(HuntersSword);
					p.getInventory().addItem(HuntersBow);
					p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF,64));
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 3));
					p.sendMessage(ChatColor.YELLOW + "Du hast das Kit " + ChatColor.RED + "Hunter" + ChatColor.YELLOW
							+ " ausgewählt!");
				}else {
					p.sendMessage(ChatColor.RED + "Du hast zu wenig Erfahrungspunkte!" + ChatColor.GREEN + "("
							+ ChatColor.RED + lv + ChatColor.GREEN + "/180) EP");
				}
			}
		}
	}
}