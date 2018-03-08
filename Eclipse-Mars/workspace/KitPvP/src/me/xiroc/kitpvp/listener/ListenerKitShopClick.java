package me.xiroc.kitpvp.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import me.xiroc.kitpvp.kits.Kit;
import me.xiroc.kitpvp.kits.KitArcher;
import me.xiroc.kitpvp.kits.KitAssassin;
import me.xiroc.kitpvp.kits.KitDefault;
import me.xiroc.kitpvp.kits.KitManager;
import me.xiroc.kitpvp.kits.KitTank;
import me.xiroc.kitpvp.kits.KitWarrior;
import me.xiroc.kitpvp.kits.KitWizard;
import me.xiroc.kitpvp.kits.KitZombie;
import me.xiroc.kitpvp.main.MainPlugin;

public class ListenerKitShopClick implements Listener {

	private Inventory inv2;
	
	private KitManager kit = new KitManager();

	/*private KitArcher kitarcher = new KitArcher();
	private KitWarrior kitwarrior = new KitWarrior();
	private KitZombie kitzombie = new KitZombie();
	private KitWizard kitwizard = new KitWizard();
	private KitAssassin kitassassin = new KitAssassin();
	private KitTank kitTank = new KitTank();*/

	private MainPlugin plugin;
	private Inventory inv;

	public ItemStack choose = new ItemStack(Material.FLINT_AND_STEEL);
	public ItemMeta chooseMeta = choose.getItemMeta();
	public ItemStack back = new ItemStack(Material.LAVA_BUCKET);
	public ItemMeta backMeta = choose.getItemMeta();
	public ItemStack upgrade = new ItemStack(Material.EMERALD);
	public ItemMeta upgradeMeta = upgrade.getItemMeta();

	public ListenerKitShopClick(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory i = e.getInventory();
		ItemStack s = e.getCurrentItem();
		if (i.getName().equals("§aKits")) {
			e.setCancelled(true);
			if (s.getType() == Material.IRON_SWORD) {
				if (s.getItemMeta().getDisplayName().equals("§1Krieger")) {
					this.inv = this.plugin.getServer().createInventory(null, 9, "§1Krieger");
					this.chooseMeta.setDisplayName("§aAuswählen");
					this.choose.setItemMeta(this.chooseMeta);
					this.backMeta.setDisplayName("§4Zurück");
					this.back.setItemMeta(this.backMeta);
					this.upgradeMeta.setDisplayName("§6Upgrade");
					this.upgrade.setItemMeta(upgradeMeta);
					this.inv.setItem(4, upgrade);
					this.inv.setItem(8, back);
					this.inv.setItem(0, choose);
					e.getWhoClicked().openInventory(this.inv);
				}
			}
			if (s.getType() == Material.POTION) {
				if (s.getItemMeta().getDisplayName().equals("§1Magier")) {
					this.inv = this.plugin.getServer().createInventory(null, 9, "§1Magier");
					this.chooseMeta.setDisplayName("§aAuswählen");
					this.choose.setItemMeta(this.chooseMeta);
					this.backMeta.setDisplayName("§4Zurück");
					this.back.setItemMeta(this.backMeta);
					this.upgradeMeta.setDisplayName("§6Upgrade");
					this.upgrade.setItemMeta(upgradeMeta);
					this.inv.setItem(4, upgrade);
					this.inv.setItem(8, back);
					this.inv.setItem(0, choose);
					e.getWhoClicked().openInventory(this.inv);
				}
			}
			if (s.getType() == Material.ROTTEN_FLESH) {
				if (s.getItemMeta().getDisplayName().equals("§1Zombie")) {
					this.inv = this.plugin.getServer().createInventory(null, 9, "§1Zombie");
					this.chooseMeta.setDisplayName("§aAuswählen");
					this.choose.setItemMeta(this.chooseMeta);
					this.backMeta.setDisplayName("§4Zurück");
					this.back.setItemMeta(this.backMeta);
					this.upgradeMeta.setDisplayName("§6Upgrade");
					this.upgrade.setItemMeta(upgradeMeta);
					this.inv.setItem(4, upgrade);
					this.inv.setItem(8, back);
					this.inv.setItem(0, choose);
					e.getWhoClicked().openInventory(this.inv);
				}
			}
			if (s.getType() == Material.DIAMOND_CHESTPLATE) {
				if (s.getItemMeta().getDisplayName().equals("§4Tank")) {
					this.inv = this.plugin.getServer().createInventory(null, 9, "§4Tank");
					this.chooseMeta.setDisplayName("§aAuswählen");
					this.choose.setItemMeta(this.chooseMeta);
					this.backMeta.setDisplayName("§4Zurück");
					this.back.setItemMeta(this.backMeta);
					this.upgradeMeta.setDisplayName("§6Upgrade");
					this.upgrade.setItemMeta(upgradeMeta);
					this.inv.setItem(4, upgrade);
					this.inv.setItem(8, back);
					this.inv.setItem(0, choose);
					e.getWhoClicked().openInventory(this.inv);
				}
			}
			if (s.getType() == Material.BOW) {
				if (s.getItemMeta().getDisplayName().equals("§1Bogenschütze")) {
					this.inv = this.plugin.getServer().createInventory(null, 9, "§1Bogenschütze");
					this.chooseMeta.setDisplayName("§aAuswählen");
					this.choose.setItemMeta(this.chooseMeta);
					this.backMeta.setDisplayName("§4Zurück");
					this.back.setItemMeta(this.backMeta);
					this.upgradeMeta.setDisplayName("§6Upgrade");
					this.upgrade.setItemMeta(upgradeMeta);
					this.inv.setItem(4, upgrade);
					this.inv.setItem(8, back);
					this.inv.setItem(0, choose);
					e.getWhoClicked().openInventory(this.inv);
				}
			}
			if (s.getType() == Material.GOLD_AXE) {
				if (s.getItemMeta().getDisplayName().equals("§4Hunter")) {
					this.inv = this.plugin.getServer().createInventory(null, 9, "§4Hunter");
					this.chooseMeta.setDisplayName("§aAuswählen");
					this.choose.setItemMeta(this.chooseMeta);
					this.backMeta.setDisplayName("§4Zurück");
					this.back.setItemMeta(this.backMeta);
					this.upgradeMeta.setDisplayName("§6Upgrade");
					this.upgrade.setItemMeta(upgradeMeta);
					this.inv.setItem(4, upgrade);
					this.inv.setItem(8, back);
					this.inv.setItem(0, choose);
					e.getWhoClicked().openInventory(this.inv);
				}
			}
			if (s.getType() == Material.CHAINMAIL_CHESTPLATE) {
				if (s.getItemMeta().getDisplayName().equals("§1Assassine")) {
					this.inv = this.plugin.getServer().createInventory(null, 9, "§1Assasin");
					this.chooseMeta.setDisplayName("§aAuswählen");
					this.choose.setItemMeta(this.chooseMeta);
					this.backMeta.setDisplayName("§4Zurück");
					this.back.setItemMeta(this.backMeta);
					this.upgradeMeta.setDisplayName("§6Upgrade");
					this.upgrade.setItemMeta(upgradeMeta);
					this.inv.setItem(4, upgrade);
					this.inv.setItem(8, back);
					this.inv.setItem(0, choose);
					e.getWhoClicked().openInventory(this.inv);
				}
			}
			if (s.getType() == Material.STONE_PICKAXE) {
				if (s.getItemMeta().getDisplayName().equals("§1Standard")) {
					this.inv = this.plugin.getServer().createInventory(null, 9, "§1Standard");
					this.chooseMeta.setDisplayName("§aAuswählen");
					this.choose.setItemMeta(this.chooseMeta);
					this.backMeta.setDisplayName("§4Zurück");
					this.back.setItemMeta(this.backMeta);
					//this.upgradeMeta.setDisplayName("§6Upgrade");
					//this.upgrade.setItemMeta(upgradeMeta);
					//this.inv.setItem(4, upgrade);
					this.inv.setItem(8, back);
					this.inv.setItem(0, choose);
					e.getWhoClicked().openInventory(this.inv);
				}
			}
		}
		if (e.getInventory().getName().equals("§1Krieger")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.FLINT_AND_STEEL) {
				File file = new File("plugins//KitPvP//Player//Kits", e.getWhoClicked().getName() + ".yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				boolean b = cfg.getBoolean("Player.State.Kits.Warrior.Own");
				if (b) {
					/*for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					int lv = cfg.getInt("Player.State.Kits.Warrior.Level");
					kitwarrior.setKitItems(lv, p);
					*/
					p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 5, 5);
					plugin.setCurrentKit(p, Kit.WARRIOR);
					e.getView().close();
				} else {
					if (plugin.getCoins(p) >= plugin.getKitCost(1)) {
						cfg.set("Player.State.Kits.Warrior.Own", true);
						cfg.set("Player.State.Kits.Warrior.Level", 1);
						try {
							cfg.save(file);
						} catch (IOException e2) {
							e2.printStackTrace();
						}
						plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(1));

						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + ChatColor.YELLOW
								+ "Krieger" + ChatColor.GREEN + " gekauft!");
					} else {
						int c = plugin.getKitCost(1) - plugin.getCoins(p);
						p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + c
								+ ChatColor.RED + " Coins um das Kit " + ChatColor.YELLOW + "Krieger" + ChatColor.RED
								+ " zu kaufen!");
					}
				}
			}
			if (s.getType() == Material.EMERALD) {
				e.setCancelled(true);
				if (s.getItemMeta().getDisplayName().equals("§6Upgrade")) {
					if (kit.hasKit(1, p)) {
						int level = kit.getKitLevel(1, p);
						if (level != 9) {
							int coins = plugin.getCoins(p);
							int cost = plugin.getUpgradeCostToLevel(1, level+1);
							if (coins >= cost) {
								int newlevel = kit.getKitLevel(1, p) + 1;
								kit.setKitLevel(1, newlevel, p);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 5);
								plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(2));
								p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + ChatColor.YELLOW
										+ "Krieger" + ChatColor.GREEN + " auf das Level " + ChatColor.YELLOW + newlevel
										+ ChatColor.GREEN + " upgegraded!");
							} else {
								int cc = cost - coins;
								p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + cc
										+ ChatColor.RED + " Coins um das Kit " + ChatColor.YELLOW + "Krieger"
										+ ChatColor.RED + " upzugraden!");
							}
						} else {
							p.sendMessage(
									plugin.prefix + ChatColor.GREEN + "Dieses Kit befindet sich bereits auf Level "
											+ ChatColor.YELLOW + 9 + ChatColor.GREEN + " !");
						}

					} else {
						p.sendMessage(plugin.prefix + ChatColor.RED + "Du besitzt dieses Kit nicht!");
					}

				}
			}
			if (s.getType() == Material.LAVA_BUCKET) {
				if (s.getItemMeta().getDisplayName().equals("§4Zurück")) {
					e.setCancelled(true);
					openGui(p);
				}
			}

		}
		if (e.getInventory().getName().equals("§1Bogenschütze")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.FLINT_AND_STEEL) {
				File file = new File("plugins//KitPvP//Player//Kits", e.getWhoClicked().getName() + ".yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				if (cfg.getBoolean("Player.State.Kits.Archer.Own") == true) {
					/*p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 5, 5);
					for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					int lv = cfg.getInt("Player.State.Kits.Archer.Level");
					kitarcher.setKitItems(lv, p);
					*/
					plugin.setCurrentKit(p, Kit.ARCHER);
					e.getView().close();
				} else {
					if (plugin.getCoins(p) >= plugin.getKitCost(2)) {
						cfg.set("Player.State.Kits.Archer.Own", true);
						cfg.set("Player.State.Kits.Archer.Level", 1);
						plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(2));
						try {
							cfg.save(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + ChatColor.YELLOW
								+ "Bogenschütze" + ChatColor.GREEN + " gekauft!");
					} else {
						int c = plugin.getKitCost(1) - plugin.getCoins(p);
						p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + c
								+ ChatColor.RED + " Coins um das Kit " + ChatColor.YELLOW + "Bogenschütze"
								+ ChatColor.RED + " zu kaufen!");
					}
				}
			}
			if (s.getType() == Material.EMERALD) {
				e.setCancelled(true);
				if (s.getItemMeta().getDisplayName().equals("§6Upgrade")) {
					if (kit.hasKit(2, p)) {
						int level = kit.getKitLevel(2, p);
						if (level != 9) {
							int coins = plugin.getCoins(p);
							int cost = plugin.getUpgradeCostToLevel(2, level+1);
							if (coins >= cost) {
								int newlevel = kit.getKitLevel(2, p) + 1;
								kit.setKitLevel(2, newlevel, p);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 5);
								plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(2));
								p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + ChatColor.YELLOW
										+ "Bogenschütze" + ChatColor.GREEN + " auf das Level " + ChatColor.YELLOW
										+ newlevel + ChatColor.GREEN + " upgegraded!");
							} else {
								int cc = cost - coins;
								p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + cc
										+ ChatColor.RED + " Coins um das Kit " + ChatColor.YELLOW + "Bogenschütze"
										+ ChatColor.RED + " upzugraden!");
							}
						} else {
							p.sendMessage(
									plugin.prefix + ChatColor.GREEN + "Dieses Kit befindet sich bereits auf Level "
											+ ChatColor.YELLOW + 9 + ChatColor.GREEN + " !");
						}

					} else {
						p.sendMessage(plugin.prefix + ChatColor.RED + "Du besitzt dieses Kit nicht!");
					}

				}
			}
			if (s.getType() == Material.LAVA_BUCKET) {
				if (s.getItemMeta().getDisplayName().equals("§4Zurück")) {
					e.setCancelled(true);
					openGui(p);
				}
			}
		}
		if (i.getName().equals("§4Tank")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.FLINT_AND_STEEL) {
				File file = new File("plugins//KitPvP//Player//Kits", e.getWhoClicked().getName() + ".yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				if (cfg.getBoolean("Player.State.Kits.Tank.Own") == true) {
					/*for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					int lv = cfg.getInt("Player.State.Kits.Tank.Level");
					kitTank.setKit(p, lv);
					*/
					plugin.setCurrentKit(p, Kit.TANK);
					p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 5, 5);
					e.getView().close();
				} else {
					if (plugin.getCoins(p) >= plugin.getKitCost(2)) {
						cfg.set("Player.State.Kits.Tank.Own", true);
						cfg.set("Player.State.Kits.Tank.Level", 1);
						plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(2));
						try {
							cfg.save(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + ChatColor.YELLOW + "Tank"
								+ ChatColor.GREEN + " gekauft!");
					} else {
						int c = plugin.getKitCost(1) - plugin.getCoins(p);
						p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + c
								+ ChatColor.RED + " Coins um das Kit " + ChatColor.YELLOW + "Tank" + ChatColor.RED
								+ " zu kaufen!");
					}
				}
			}
			if (s.getType() == Material.EMERALD) {
				e.setCancelled(true);
				if (s.getItemMeta().getDisplayName().equals("§6Upgrade")) {

					if (kit.hasKit(Kit.TANK, p)) {
						int level = kit.getKitLevel(Kit.TANK, p);
						if (level != 9) {
							int coins = plugin.getCoins(p);
							int cost = plugin.getUpgradeCostToLevel(Kit.TANK, level+1);
							if (coins >= cost) {
								int newlevel = kit.getKitLevel(Kit.TANK, p) + 1;
								kit.setKitLevel(Kit.TANK, newlevel, p);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 5);
								plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(2));
								p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + ChatColor.YELLOW
										+ "Tank" + ChatColor.GREEN + " auf das Level " + ChatColor.YELLOW + newlevel
										+ ChatColor.GREEN + " upgegraded!");
							} else {
								int cc = cost - coins;
								p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + cc
										+ ChatColor.RED + " Coins um das Kit " + ChatColor.YELLOW + "Tank"
										+ ChatColor.RED + " upzugraden!");
							}
						} else {
							p.sendMessage(
									plugin.prefix + ChatColor.GREEN + "Dieses Kit befindet sich bereits auf Level "
											+ ChatColor.YELLOW + 9 + ChatColor.GREEN + " !");
						}

					} else {
						p.sendMessage(plugin.prefix + ChatColor.RED + "Du besitzt dieses Kit nicht!");
					}

				}
			}
			if (s.getType() == Material.LAVA_BUCKET) {
				if (s.getItemMeta().getDisplayName().equals("§4Zurück")) {
					e.setCancelled(true);
					openGui(p);
				}
			}
		}
		if (i.getName().equals("§1Zombie")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.FLINT_AND_STEEL) {
				File file = new File("plugins//KitPvP//Player//Kits", e.getWhoClicked().getName() + ".yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				if (cfg.getBoolean("Player.State.Kits.Zombie.Own") == true) {
					/*for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					int lv = cfg.getInt("Player.State.Kits.Zombie.Level");
					kitzombie.setKitItems(lv, p);
					*/
					plugin.setCurrentKit(p, Kit.ZOMBIE);
					p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 5, 5);
					e.getView().close();
				} else {
					if (plugin.getCoins(p) >= plugin.getKitCost(Kit.ZOMBIE)) {
						cfg.set("Player.State.Kits.Zombie.Own", true);
						cfg.set("Player.State.Kits.Zombie.Level", 1);
						plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(2));
						try {
							cfg.save(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + ChatColor.YELLOW + "Zombie"
								+ ChatColor.GREEN + " gekauft!");
					} else {
						int c = plugin.getKitCost(1) - plugin.getCoins(p);
						p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + c
								+ ChatColor.RED + " Coins um das Kit " + ChatColor.YELLOW + "Zombie" + ChatColor.RED
								+ " zu kaufen!");
					}
				}
			}
			if (s.getType() == Material.EMERALD) {
				if (s.getItemMeta().getDisplayName().equals("§6Upgrade")) {
					if (kit.hasKit(3, p)) {
						int level = kit.getKitLevel(3, p);
						if (level != 9) {
							int coins = plugin.getCoins(p);
							int cost = plugin.getUpgradeCostToLevel(3, level+1);
							if (coins >= cost) {
								int newlevel = kit.getKitLevel(3, p) + 1;
								kit.setKitLevel(3, newlevel, p);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 5);
								plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(3));
								p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + ChatColor.YELLOW
										+ "Zombie" + ChatColor.GREEN + " auf das Level " + ChatColor.YELLOW
										+ newlevel + ChatColor.GREEN + " upgegraded!");
							} else {
								int cc = cost - coins;
								p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + cc
										+ ChatColor.RED + " Coins um das Kit " + ChatColor.YELLOW + "Zombie"
										+ ChatColor.RED + " upzugraden!");
							}
						} else {
							p.sendMessage(
									plugin.prefix + ChatColor.GREEN + "Dieses Kit befindet sich bereits auf Level "
											+ ChatColor.YELLOW + 9 + ChatColor.GREEN + " !");
						}

					} else {
						p.sendMessage(plugin.prefix + ChatColor.RED + "Du besitzt dieses Kit nicht!");
					}

				}
			}
			if (s.getType() == Material.LAVA_BUCKET) {
				if (s.getItemMeta().getDisplayName().equals("§4Zurück")) {
					e.setCancelled(true);
					openGui(p);
				}
			}
		}
		if (i.getName().equals("§1Magier")) {
			e.setCancelled(true);
			if(s.getType() == Material.FLINT_AND_STEEL){
				File file = new File("plugins//KitPvP//Player//Kits", e.getWhoClicked().getName() + ".yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				if (cfg.getBoolean("Player.State.Kits.Wizard.Own") == true) {
					/*for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					int lv = cfg.getInt("Player.State.Kits.Wizard.Level");
					p.getInventory().clear();
					kitwizard.setKitItems(lv, p);
					*/
					plugin.setCurrentKit(p, Kit.WIZARD);
					p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 5, 5);
					e.getView().close();
				} else {
					if (plugin.getCoins(p) >= plugin.getKitCost(Kit.WIZARD)) {
						cfg.set("Player.State.Kits.Wizard.Own", true);
						cfg.set("Player.State.Kits.Wizard.Level", 1);
						plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(2));
						try {
							cfg.save(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + ChatColor.YELLOW + "Magier"
								+ ChatColor.GREEN + " gekauft!");
					} else {
						int c = plugin.getKitCost(1) - plugin.getCoins(p);
						p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + c
								+ ChatColor.RED + " Coins um das Kit " + ChatColor.YELLOW + "Magier" + ChatColor.RED
								+ " zu kaufen!");
					}
				}
			}
			if (s.getType() == Material.EMERALD) {
				if (s.getItemMeta().getDisplayName().equals("§6Upgrade")) {
					if (kit.hasKit(Kit.WIZARD, p)) {
						int level = kit.getKitLevel(Kit.WIZARD, p);
						if (level != 9) {
							int coins = plugin.getCoins(p);
							int cost = plugin.getUpgradeCostToLevel(Kit.WIZARD, level+1);
							if (coins >= cost) {
								int newlevel = kit.getKitLevel(Kit.WIZARD, p) + 1;
								kit.setKitLevel(4, newlevel, p);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 5);
								plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(3));
								p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + ChatColor.YELLOW
										+ "Magier" + ChatColor.GREEN + " auf das Level " + ChatColor.YELLOW
										+ newlevel + ChatColor.GREEN + " upgegraded!");
							} else {
								int cc = cost - coins;
								p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + cc
										+ ChatColor.RED + " Coins um das Kit " + ChatColor.YELLOW + "Magier"
										+ ChatColor.RED + " upzugraden!");
							}
						} else {
							p.sendMessage(
									plugin.prefix + ChatColor.GREEN + "Dieses Kit befindet sich bereits auf Level "
											+ ChatColor.YELLOW + 9 + ChatColor.GREEN + " !");
						}

					} else {
						p.sendMessage(plugin.prefix + ChatColor.RED + "Du besitzt dieses Kit nicht!");
					}

				}
			}
			if (s.getType() == Material.LAVA_BUCKET) {
				if (s.getItemMeta().getDisplayName().equals("§4Zurück")) {
					e.setCancelled(true);
					openGui(p);
				}
			}
		}
		if (i.getName().equals("§1Assassine")) {
			e.setCancelled(true);
			if(s.getType() == Material.FLINT_AND_STEEL){
				File file = new File("plugins//KitPvP//Player//Kits", e.getWhoClicked().getName() + ".yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				if (cfg.getBoolean("Player.State.Kits.Assassin.Own") == true) {
					for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					int lv = cfg.getInt("Player.State.Kits.Assassin.Level");
					p.getInventory().clear();
					//kitassassin.setKitItems(p, lv);
					p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 5, 5);
				} else {
					if (plugin.getCoins(p) >= plugin.getKitCost(Kit.ASSASSIN)) {
						cfg.set("Player.State.Kits.Assassin.Own", true);
						cfg.set("Player.State.Kits.Assassin.Level", 1);
						plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(2));
						try {
							cfg.save(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + ChatColor.YELLOW + "Assassin"
								+ ChatColor.GREEN + " gekauft!");
					} else {
						int c = plugin.getKitCost(1) - plugin.getCoins(p);
						p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + c
								+ ChatColor.RED + " Coins um das Kit " + ChatColor.YELLOW + "Assassin" + ChatColor.RED
								+ " zu kaufen!");
					}
				}
			}
			if (s.getType() == Material.EMERALD) {
				if (s.getItemMeta().getDisplayName().equals("§6Upgrade")) {
					if (kit.hasKit(Kit.ASSASSIN, p)) {
						int level = kit.getKitLevel(Kit.ASSASSIN, p);
						if (level != 7) {
							int coins = plugin.getCoins(p);
							int cost = plugin.getUpgradeCostToLevel(Kit.ASSASSIN, level+1);
							if (coins >= cost) {
								int newlevel = kit.getKitLevel(Kit.ASSASSIN, p) + 1;
								kit.setKitLevel(4, newlevel, p);
								p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 5);
								plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(3));
								p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + ChatColor.YELLOW
										+ "Assassin" + ChatColor.GREEN + " auf das Level " + ChatColor.YELLOW
										+ newlevel + ChatColor.GREEN + " upgegraded!");
							} else {
								int cc = cost - coins;
								p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + cc
										+ ChatColor.RED + " Coins um das Kit " + ChatColor.YELLOW + "Assassin"
										+ ChatColor.RED + " upzugraden!");
							}
						} else {
							p.sendMessage(
									plugin.prefix + ChatColor.GREEN + "Dieses Kit befindet sich bereits auf Level "
											+ ChatColor.YELLOW + 9 + ChatColor.GREEN + " !");
						}

					} else {
						p.sendMessage(plugin.prefix + ChatColor.RED + "Du besitzt dieses Kit nicht!");
					}

				}
			}
			if (s.getType() == Material.LAVA_BUCKET) {
				if (s.getItemMeta().getDisplayName().equals("§4Zurück")) {
					e.setCancelled(true);
					openGui(p);
				}
			}
		}
		if (i.getName().equals("§4Hunter")) {
			e.setCancelled(true);
			if(s.getType() == Material.FLINT_AND_STEEL){
				File file = new File("plugins//KitPvP//Player//Kits", e.getWhoClicked().getName() + ".yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				if (cfg.getBoolean("Player.State.Kits.Hunter.Own") == true) {
					/*for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());
					int lv = cfg.getInt("Player.State.Kits.Hunter.Level");
					kitHunter.setKitItems(lv, p);
					*/
					plugin.setCurrentKit(p, Kit.HUNTER);
					p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 5, 5);
					e.getView().close();
				} else {
					if (plugin.getCoins(p) >= plugin.getKitCost(Kit.HUNTER)) {
						cfg.set("Player.State.Kits.Hunter.Own", true);
						cfg.set("Player.State.Kits.Hunter.Level", 1);
						plugin.setCoins(p, plugin.getCoins(p) - plugin.getKitCost(2));
						try {
							cfg.save(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						p.sendMessage(plugin.prefix + ChatColor.GREEN + "Du hast das Kit " + "§4Hunter"
								+ ChatColor.GREEN + " gekauft!");
					} else {
						int c = plugin.getKitCost(1) - plugin.getCoins(p);
						p.sendMessage(plugin.prefix + ChatColor.RED + "Dir fehlen noch " + ChatColor.YELLOW + c
								+ ChatColor.RED + " Coins um das Kit " + "§4Hunter" + ChatColor.RED
								+ " zu kaufen!");
					}
				}
			}
			if (s.getType() == Material.EMERALD) {
				if (s.getItemMeta().getDisplayName().equals("§6Upgrade")) {

				}
			}
			if (s.getType() == Material.LAVA_BUCKET) {
				if (s.getItemMeta().getDisplayName().equals("§4Zurück")) {
					e.setCancelled(true);
					openGui(p);
				}
			}
		}
		if (i.getName().equals("§1Standard")) {
			e.setCancelled(true);
			if(s.getType() == Material.FLINT_AND_STEEL){
				if(s.getItemMeta().getDisplayName().equals("§aAuswählen")){
					new KitDefault().setKitItems(p);
				}
			}
			if (s.getType() == Material.LAVA_BUCKET) {
				if (s.getItemMeta().getDisplayName().equals("§4Zurück")) {
					e.setCancelled(true);
					openGui(p);
				}
			}
		}
		if(i.getName().equals("§aPowerups")){
			e.setCancelled(true);
			File file = new File("plugins//KitPvP//Player//Powerups",p.getName()+".yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			if (!file.exists()) {
			
				cfg.set("Powerups.CoinBoost", false);
				cfg.set("Powerups.Rage", false);
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if(e.getCurrentItem().getType() == Material.GOLD_INGOT){
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Coin-Boost")){
					boolean hasCoinBoost = cfg.getBoolean("Powerups.CoinBoost");
					if(hasCoinBoost){
						p.sendMessage(plugin.prefix+ChatColor.RED+"Du besitzt dieses Powerup bereits!");
					}else{
						if(plugin.getCoins(p) >= 500){
							cfg.set("Powerups.CoinBoost", true);
							try {
								cfg.save(file);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							plugin.setCoins(p, plugin.getCoins(p)-500);
							p.sendMessage(plugin.prefix+ChatColor.GREEN+"Du hast das Powerup "+ChatColor.YELLOW+"Coin-Boost"+ChatColor.GREEN+" gekauft!");
							e.getView().close();
							File file2 = new File("plugins//KitPvP//Player//Powerups",p.getName()+".yml");
							FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
							boolean h2 = cfg2.getBoolean("Powerups.CoinBoost");
							boolean h3 = cfg.getBoolean("Powerups.Rage");
							this.inv2 = p.getPlayer().getServer().createInventory(null, 9, "§aPowerups");
							ItemStack istack0 = new ItemStack(Material.GOLD_INGOT);
							ItemStack istack1 = new ItemStack(Material.DIAMOND_SWORD);
							ItemMeta istackMeta0 = istack0.getItemMeta();
							ItemMeta istackMeta1 = istack1.getItemMeta();
							istackMeta0.setDisplayName("§6Coin-Boost");
							istackMeta1.setDisplayName("§4RAGE");
							istack0.setItemMeta(istackMeta0);
							istack1.setItemMeta(istackMeta1);
							if (h2) {
								istack0.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
							}
							if(h3){
								istack1.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
							}
							this.inv2.setItem(3, istack0);
							this.inv2.setItem(5, istack1);
							p.getPlayer().openInventory(this.inv2);
						}
					}
				}
			}
			if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§4RAGE")){
					boolean hasRage = cfg.getBoolean("Powerups.Rage");
					if(hasRage){
						p.sendMessage(plugin.prefix+ChatColor.RED+"Du besitzt dieses Powerup bereits!");
					}else{
						if(plugin.getCoins(p) >= 650){
							cfg.set("Powerups.Rage", true);
							try {
								cfg.save(file);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							plugin.setCoins(p, plugin.getCoins(p)-650);
							p.sendMessage(plugin.prefix+ChatColor.GREEN+"Du hast das Powerup "+ChatColor.YELLOW+"RAGE"+ChatColor.GREEN+" gekauft!");

							e.getView().close();
						}
					}
				}
			}
		}
	}
	public void openGui(Player p){
		this.inv = p.getPlayer().getServer().createInventory(null, 9, "§aKits");
		ItemStack istack = new ItemStack(Material.IRON_SWORD);
		ItemMeta istackMeta = istack.getItemMeta();
		istackMeta.setDisplayName("§1Krieger");
		istack.setItemMeta(istackMeta);

		ItemStack istack2 = new ItemStack(Material.POTION);
		ItemMeta istackMeta2 = istack2.getItemMeta();
		istackMeta2.setDisplayName("§1Magier");
		istack2.setItemMeta(istackMeta2);

		ItemStack istack3 = new ItemStack(Material.ROTTEN_FLESH);
		ItemMeta istackMeta3 = istack3.getItemMeta();
		istackMeta3.setDisplayName("§1Zombie");
		istack3.setItemMeta(istackMeta3);

		ItemStack istack4 = new ItemStack(Material.BOW);
		ItemMeta istackMeta4 = istack4.getItemMeta();
		istackMeta4.setDisplayName("§1Bogenschütze");
		istack4.setItemMeta(istackMeta4);

		ItemStack istack5 = new ItemStack(Material.TNT);
		ItemMeta istackMeta5 = istack5.getItemMeta();
		istackMeta5.setDisplayName("§1Nuker");
		istack5.setItemMeta(istackMeta5);

		ItemStack istack6 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta istackMeta6 = istack6.getItemMeta();
		istackMeta6.setDisplayName("§1Assassin");
		istack6.setItemMeta(istackMeta6);

		ItemStack istack7 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta istackMeta7 = istack7.getItemMeta();
		istackMeta7.setDisplayName("§4Tank");
		istack7.setItemMeta(istackMeta7);

		ItemStack istack8 = new ItemStack(Material.GOLD_AXE);
		ItemMeta istackMeta8 = istack8.getItemMeta();
		istackMeta8.setDisplayName("§4Hunter");
		istack8.setItemMeta(istackMeta8);

		ItemStack istack0 = new ItemStack(Material.STONE_PICKAXE);
		ItemMeta istackMeta0 = istack0.getItemMeta();
		istackMeta0.setDisplayName("§1Standard");
		istack0.setItemMeta(istackMeta0);

		this.inv.setItem(0, istack0);
		this.inv.setItem(1, istack);
		this.inv.setItem(2, istack7);
		this.inv.setItem(3, istack2);
		this.inv.setItem(4, istack6);
		this.inv.setItem(5, istack4);
		this.inv.setItem(6, istack3);
		this.inv.setItem(7, istack8);

		p.getPlayer().openInventory(this.inv);
	}

}
