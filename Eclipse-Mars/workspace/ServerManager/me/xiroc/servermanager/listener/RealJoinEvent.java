package me.xiroc.servermanager.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.xiroc.servermanager.main.ServerManager;
import net.minecraft.server.v1_8_R3.EnumChatFormat;

public class RealJoinEvent implements Listener {

	private ServerManager plugin;

	public RealJoinEvent(ServerManager plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		File file = new File("plugins//Permissions//Players", p.getName() + ".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		boolean bool = cfg.getBoolean("DarkStar.Premium");
		if (!file.exists()) {
			cfg.set("DarkStar.Premium", false);
			try {
				cfg.save(file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//p.sendMessage("§7]§m------§r§8[§aDarkStar§8]§7§m------§r§7[");
		p.sendMessage("§aWillkommen "+p.getDisplayName()+"§a!");
		if(bool){
			p.sendMessage("§7Du besitzt §6Premium§7!");
		}
		//p.sendMessage("§7]§m-------------------§r§7[");
		//ItemStack compass = new ItemStack(Material.COMPASS);
		//ItemMeta m = compass.getItemMeta();
		//m.setDisplayName(ChatColor.GOLD+"Teleporter");
		//compass.setItemMeta(m);
		//e.getPlayer().getInventory().addItem(compass);
		//e.setJoinMessage(EnumChatFormat.GRAY+"Spieler | "+e.getPlayer().getDisplayName()+EnumChatFormat.AQUA+" hat das Spiel betreten");
		
	}

}
