package me.xiroc.lobbysystem.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.xiroc.lobbysystem.listener.ChatEvent;
import me.xiroc.lobbysystem.listener.JoinEvent;
import me.xiroc.lobbysystem.listener.LeaveEvent;

public class MainPlugin extends JavaPlugin{
	
	private MainPlugin instance;
	
	public static final String prefix = ChatColor.DARK_GRAY+"["+ChatColor.AQUA+"Lobby"+ChatColor.DARK_GRAY+"] "+ChatColor.GRAY;
	
	@Override
	public void onEnable(){
		this.registerEvents();
		this.instance = this;
		System.out.println("[LobbySystem] Enabled!");
	}
	@Override
	public void onDisable(){
		System.out.println("[LobbySystem] Disabled!");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(cmd.getName().equals("setPos")){
				if(args.length == 1){
					File file = new File("plugins//Lobby//positions.yml");
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					Location pos = p.getLocation();
					cfg.set(args[0]+".world", pos.getWorld().getName());
					cfg.set(args[0]+".x", pos.getBlockX());
					cfg.set(args[0]+".y", pos.getBlockY());
					cfg.set(args[0]+".z", pos.getBlockZ());
					try {
						cfg.save(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.sendMessage(prefix+"Die Position '"+ChatColor.GREEN+args[0]+ChatColor.GRAY+"'wurde erfolgreich gesetzt.");
				}
			}
		}
		return true;
	}
	public void registerEvents(){
		JoinEvent joinevent = new JoinEvent(this);
		LeaveEvent leavevent = new LeaveEvent(this);
		ChatEvent chatevent = new ChatEvent(this);
	}
	
	public MainPlugin getInstance() {
		return instance;
	}
	
}
