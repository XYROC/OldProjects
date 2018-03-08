package me.xiroc.kitpvp.kits;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class KitManager {
	
	public int getCurrentKit(Player player){
		File file = new File("plugins//KitPvP//Player//Kits",player.getName()+".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		int kit = cfg.getInt("Player.State.Kit.Id");
		return kit;
	}
	public boolean hasKit(int id, Player player){
		File file = new File("plugins//KitPvP//Player//Kits",player.getName()+".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		switch(id){
		case 0: return true;
		case 1: return cfg.getBoolean("Player.State.Kits.Warrior.Own");
		case 2: return cfg.getBoolean("Player.State.Kits.Archer.Own");
		case 3: return cfg.getBoolean("Player.State.Kits.Zombie.Own");
		case 4: return cfg.getBoolean("Player.State.Kits.Wizard.Own");
		case 5: return cfg.getBoolean("Player.State.Kits.Tank.Own");
		case 6: return cfg.getBoolean("Player.State.Kits.Hunter.Own");
		case 7:	return cfg.getBoolean("Player.State.Kits.Assasin.Own");
		default: return false;
		}
	}
	public int getCurrentKitLevel(Player player){
		File file = new File("plugins//KitPvP//Player//Kits",player.getName()+".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		int level = cfg.getInt("Player.State.Kits."+getCurrentKit(player)+"");
		return level;
	}
	public int getKitLevel(int id,Player player){
		File file = new File("plugins//KitPvP//Player//Kits",player.getName()+".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		switch(id){
		case 0: return cfg.getInt("Player.State.Kits.Standard.Level");
		case 1: return cfg.getInt("Player.State.Kits.Warrior.Level");
		case 2: return cfg.getInt("Player.State.Kits.Archer.Level");
		case 3: return cfg.getInt("Player.State.Kits.Zombie.Level");
		case 4: return cfg.getInt("Player.State.Kits.Wizard.Level");
		case 5: return cfg.getInt("Player.State.Kits.Tank.Level");
		case 6: return cfg.getInt("Player.State.Kits.Hunter.Level");
		case 7: return cfg.getInt("Player.State.Kits.Assasin.Level");
		default: return 0;
		}
	}
	public void setKitLevel(int id,int level, Player player){
		File file = new File("plugins//KitPvP//Player//Kits",player.getName()+".yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		switch(id){
		case 0: cfg.set("Player.State.Kits.Standard.Level", level);
		case 1: cfg.set("Player.State.Kits.Warrior.Level", level);
		case 2: cfg.set("Player.State.Kits.Archer.Level", level);
		case 3: cfg.set("Player.State.Kits.Zombie.Level", level);
		case 4: cfg.set("Player.State.Kits.Wizard.Level", level);
		case 5: cfg.set("Player.State.Kits.Tank.Level", level);
		case 6: cfg.set("Player.State.Kits.Hunter.Level", level);
		case 7: cfg.set("Player.State.Kits.Assasin.Level", level);
		}
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
