package me.xiroc.farmworld.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import me.xiroc.farmworld.listener.ListenerSignChangeEvent;
import me.xiroc.farmworld.listener.ListenerSignInteract;

public class MainPlugin extends JavaPlugin {

	public boolean blockNether;
	public boolean blockEnd;

	@Override
	public void onEnable() {
		this.loadConfig();
		this.registerEvents();
		this.registerCommands();
		System.out.println("[FarmWorld] Enabled Farmworld!");
	}

	@Override
	public void onDisable() {
		System.out.println("[FarmWorld] Disabled Farmworld!");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return true;
	}

	public void registerEvents() {
		ListenerSignChangeEvent signch = new ListenerSignChangeEvent(this);
		ListenerSignInteract signint = new ListenerSignInteract(this);
	}

	public void registerCommands() {

	}

	public void loadConfig() {
		File file = new File("plugins//FarmWorld//Config", "config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if (!cfg.contains("blockNether")) {
			cfg.set("blockNether", true);
		}
		if (!cfg.contains("blockEnd")) {
			cfg.set("blockEnd", true);
		}
		
		this.blockEnd = cfg.getBoolean("blockEnd");
		this.blockNether = cfg.getBoolean("blockNether");
		
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
