package me.xiroc.kitpvp.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.xiroc.kitpvp.main.MainPlugin;
import net.minecraft.server.v1_8_R3.Block;

public class ListenerKitShopMain implements Listener {

	public Inventory inv;
	public Inventory inv2;

	private MainPlugin plugin;

	public ListenerKitShopMain(MainPlugin plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.CHEST) {
			if (!(p.getItemInHand().getItemMeta().getDisplayName() == null)) {
				if (p.getItemInHand().getItemMeta().getDisplayName().equals("§6Kits")) {
					e.setCancelled(true);
					p.playSound(p.getLocation(), Sound.CHEST_OPEN, 5, 5);
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
					istackMeta6.setDisplayName("§1Assasin");
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
		}
		if (p.getItemInHand().getType() == Material.EMERALD) {
			if (p.getItemInHand().getItemMeta().getDisplayName().equals("§aPowerups")) {
				e.setCancelled(true);
				File file = new File("plugins//KitPvP//Player//Powerups", p.getName() + ".yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				if (file.exists()) {
				} else {
					cfg.set("Powerups.CoinBoost", false);
					try {
						cfg.save(file);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				boolean hasCoinBoost = cfg.getBoolean("Powerups.CoinBoost");
				boolean hasRage = cfg.getBoolean("Powerups.Rage");
				this.inv2 = p.getPlayer().getServer().createInventory(null, 9, "§aPowerups");
				ItemStack istack0 = new ItemStack(Material.GOLD_INGOT);
				ItemStack istack1 =  new ItemStack(Material.DIAMOND_SWORD);
				ItemMeta istackMeta0 = istack0.getItemMeta();
				ItemMeta istackMeta1 = istack1.getItemMeta();
				istackMeta0.setDisplayName("§6Coin-Boost");
				istackMeta1.setDisplayName("§4RAGE");
				istack0.setItemMeta(istackMeta0);
				istack1.setItemMeta(istackMeta1);
				if (hasCoinBoost) {
					istack0.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				}
				if(hasRage){
					istack1.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				}
				this.inv2.setItem(3, istack0);
				this.inv2.setItem(5, istack1);
				p.getPlayer().openInventory(this.inv2);
			}
		}
	}

}
