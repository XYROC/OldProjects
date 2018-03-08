package me.xiroc.servermanager.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayerData {
	private Player player;
	public PlayerData(Player player) {
		this.player = player;
	}
	public String getNamePrefix(){
		String nameprefix = ChatColor.GRAY+"Spieler";
		File file = new File("plugins//ServerManager//Data//PlayerData//"+player.getName()+".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(!cfg.getString("nameprefix").equals("")){
		nameprefix = cfg.getString("nameprefix");
		}
		return nameprefix;
	}
	public void setNamePrefix(String prefix){
		File file = new File("plugins//ServerManager//Data//PlayerData//"+player.getName()+".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("nameprefix", prefix);
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
