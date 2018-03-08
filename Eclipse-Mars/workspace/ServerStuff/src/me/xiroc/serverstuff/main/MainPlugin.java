package me.xiroc.serverstuff.main;

import java.lang.reflect.Field;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.ItemMultiTexture;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class MainPlugin extends JavaPlugin implements Listener {

	private int interval = 1000;

	@Override
	public void onEnable() {
		this.registerEvents();
		this.runBroadCast();
		this.runHalloweenFeatures();
		this.getServer().getPluginManager().registerEvents(this, this);
		System.out.println("[ServerEssentials] ServerEssentials Enabled!");
	}

	@Override
	public void onDisable() {
		System.out.println("[ServerEssentials] ServerEssentials Disabled!");
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		e.getPlayer().getInventory().clear();
		ItemStack axe = new ItemStack(Material.GOLD_AXE);
		axe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
		axe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
		ItemMeta m = axe.getItemMeta();
		m.setDisplayName("§5§lHalloween §4§lAxe");
		axe.setItemMeta(m);
		
		ItemStack chest = new ItemStack(Material.ENDER_CHEST);
		ItemMeta m2 = chest.getItemMeta();
		m2.setDisplayName("§5§lHalloween §4§lChest");
		chest.setItemMeta(m2);
		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 2));
		e.getPlayer().getInventory().addItem(axe);
		e.getPlayer().getInventory().addItem(chest);
		int i = new Random().nextInt(2);
		if(i == 0){
			e.getPlayer().getInventory().setHelmet(new ItemStack(Material.JACK_O_LANTERN));
		}else{
			e.getPlayer().getInventory().setHelmet(new ItemStack(Material.PUMPKIN));
		}
		this.sendTablist(e.getPlayer(), "§4DARKSTAR §7[§a1.8.x§7] §5Hallo§4ween", "");
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void damage(PlayerDeathEvent e){
		e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.LIGHTNING);
		e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ZOMBIE);
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onBreak(PlayerItemBreakEvent e){
		if(e.getBrokenItem().getType() == Material.GOLD_AXE && e.getBrokenItem().getItemMeta().getDisplayName().equals("§5§lHalloween §4§lAxe")){
			ItemStack axe = new ItemStack(Material.GOLD_AXE);
			axe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
			axe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
			//axe.setDurability((short) 50);
			ItemMeta m = axe.getItemMeta();
			m.setDisplayName("§5§lHalloween §4§lAxe");
			axe.setItemMeta(m);
			e.getPlayer().getInventory().addItem(axe);
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if(e.getCurrentItem().getType() == Material.PUMPKIN ||e.getCurrentItem().getType() == Material.JACK_O_LANTERN){
			e.setCancelled(true);
		}
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("setSign")) {
				if (p.isOp()) {
					String world = p.getWorld().getName();

					double x = p.getLocation().getX();
					double y = p.getLocation().getY();
					double z = p.getLocation().getZ();

					this.getConfig().set("Sign.World", world);
					this.getConfig().set("Sign.Pos.x", x);
					this.getConfig().set("Sign.Pos.y", y);
					this.getConfig().set("Sign.Pos.z", z);

					this.saveConfig();

					Block b = p.getLocation().getBlock();

					b.setType(Material.WALL_SIGN);

					this.runSign();

					p.sendMessage(ChatColor.GREEN + "[ServerEssentials] " + ChatColor.GOLD + "Sign Set!");
				}else{
					p.sendMessage(ChatColor.RED+"Dazu bist du nicht berechtigt!");
				}
			}
			
			if(cmd.getName().equalsIgnoreCase("nopumpkin")){
				p.getInventory().setHelmet(null);
			}
		}
		return true;
	}

	public void registerEvents() {

	}

	public void runSign() {
		String world = this.getConfig().getString("Sign.World");

		World w = Bukkit.getWorld(world);

		double x = this.getConfig().getDouble("Sign.Pos.x");
		double y = this.getConfig().getDouble("Sign.Pos.y");
		double z = this.getConfig().getDouble("Sign.Pos.z");

		Location loc = new Location(w, x, y, z);

		Block b = loc.getBlock();

		if (b.getState() instanceof Sign) {
			Sign s = (Sign) b.getState();

			s.setLine(1, "  DarkStar      ");
			s.update();

			System.out.println("[ServerEssentials] Running Sign!");

			Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

				@Override
				public void run() {
					if (interval <= 100) {
						interval = 1000;
					}
					if (interval != 0) {
						interval -= 100;
					}
					if (interval == 900) {
						s.setLine(1, "§eDarkStar      ");
						s.update();
					}
					if (interval == 800) {
						s.setLine(1, "§4DarkStar      ");
						s.update();

					}
					if (interval == 700) {
						s.setLine(1, "§1DarkStar      ");
						s.update();

					}
					if (interval == 600) {
						s.setLine(1, "§6DarkStar      ");
						s.update();

					}
					if (interval == 500) {
						s.setLine(1, "§5DarkStar      ");
						s.update();

					}
					if (interval == 400) {
						s.setLine(1, "§7DarkStar      ");
						s.update();

					}
					if (interval == 300) {
						s.setLine(1, "  DarkStar      ");
						s.update();

					}
					if (interval == 200) {
						s.setLine(1, "§eDarkStar      ");
						s.update();

					}
					if (interval == 100) {
						s.setLine(1, "§4DarkStar      ");
						s.update();
					}
					if (interval == 1000) {
						s.setLine(1, "§3DarkStar      ");
						s.update();

					}

				}
			}, 100, 100);
		}
	}

	public void runBroadCast() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				for (Player pl : Bukkit.getOnlinePlayers()) {
					pl.sendMessage(ChatColor.GOLD
							+ "Der Kürbis nervt? /nopumpkin");
				}
			}
		}, 5000, 5000);

	}
	
	public void runHalloweenFeatures(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
				int p = new Random().nextInt(Bukkit.getOfflinePlayers().length);
				int c = 0;
				for (Player pl : Bukkit.getOnlinePlayers()) {
					c++;
					if(c == p){
						pl.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
						pl.playSound(pl.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 1);
						pl.getWorld().spawnEntity(pl.getLocation(), EntityType.LIGHTNING);
						c = 0;
						p = new Random().nextInt(Bukkit.getOfflinePlayers().length);
					}
				}
			}
		}, 2000, 2000);
	}
	public void sendTablist(Player player, String header, String footer){
		if(header == null) header = "";
		if(footer == null) footer = "";
		
		header = ChatColor.translateAlternateColorCodes('6', header);
		footer = ChatColor.translateAlternateColorCodes('6', footer);
		
		PlayerConnection c = ((CraftPlayer)player).getHandle().playerConnection;
		
		IChatBaseComponent tabheader = ChatSerializer.a("{\"text\": \""+header+"\"}");
		IChatBaseComponent tabfooter = ChatSerializer.a("{\"text\": \""+footer+"\"}");
		
		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter(tabheader);
		
		try {
			Field f = packet.getClass().getDeclaredField("b");
			f.setAccessible(true);
			f.set(packet, tabfooter);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			c.sendPacket(packet);
		}
	}

}
