package me.xiroc.zombieapocalypse.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.xiroc.zombieapocalypse.listener.ListenerPlayerInteractEvent;
import me.xiroc.zombieapocalypse.listener.ListenerSignChangeEvent;

public class MainPlugin extends JavaPlugin {

	public String prefix = "§7[§2ZOMBIE§7] ";

	

	@Override
	public void onEnable() {
		this.registerListeners();
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(ChatColor.GRAY+"["+ChatColor.GREEN+"ZOMBIE"+ChatColor.GRAY+"]"+ChatColor.GOLD+" >"+ChatColor.RED+">"+ChatColor.GOLD+">"+ChatColor.GREEN+" Zombie-Apocalypse Enabled!");
	}

	@Override
	public void onDisable() {
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(ChatColor.GRAY+"["+ChatColor.GREEN+"ZOMBIE"+ChatColor.GRAY+"]"+ChatColor.GOLD+" >"+ChatColor.RED+">"+ChatColor.GOLD+">"+ChatColor.GREEN+" Zombie-Apocalypse Disabled!");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("za")) {
				if (args.length == 4) {
					if (args[0].equalsIgnoreCase("addmap")) {
						if (p.isOp()) {
							// za addmap name spieleranzahl
							int i = Integer.valueOf(args[3]);
							if (i >= 2) {
								String world = args[1];
								String name = args[2];
								File file = new File("plugins//ZombieApocalypse//Worlds", name + ".yml");
								if (!file.exists()) {
									FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
									cfg.set("World.Name", world);
									cfg.set("Players.Count", i);
									try {
										cfg.save(file);
									} catch (IOException e) {
										e.printStackTrace();
									}
									p.sendMessage(prefix + ChatColor.GREEN + "Die Karte " + ChatColor.YELLOW + name
											+ ChatColor.GREEN + " aus der Welt " + ChatColor.YELLOW + world
											+ ChatColor.GREEN + " mit " + ChatColor.YELLOW + i + ChatColor.GREEN
											+ " Spielern wurde erfolgreich hinzugefügt!");
								} else {
									p.sendMessage(prefix + ChatColor.RED + "Die Karte " + ChatColor.YELLOW + name
											+ ChatColor.RED + " gibt es bereits!");
								}

							} else {
								p.sendMessage(prefix + ChatColor.RED + "Bitte wähle eine Spielerzahl über "
										+ ChatColor.YELLOW + 1 + ChatColor.RED + "!");
							}

						} else {
							p.sendMessage(prefix+ChatColor.RED+"Du hast nicht die nötige Berechtigung um dieses Kommando auszuführen!");
						}
					}
					
				}
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("help")){
						if(p.isOp()){
							p.sendMessage(prefix+ChatColor.GREEN+"ZOMBIE-APOCALYSPE Help:");
							p.sendMessage(ChatColor.AQUA+"/za: Hauptkommando");
							p.sendMessage(ChatColor.AQUA+"/za <addmap> <welt> <name> <spieleranzahl>");
							p.sendMessage(ChatColor.AQUA+"/za <help>");
						}else{
							p.sendMessage(prefix+ChatColor.RED+"Du hast nicht die nötige Berechtigung um dieses Kommando auszuführen!");
						}
					}
				}
				if(args.length == 2){
					if(args[0].equals("setlobby")){
						String name = args[1];
						File file = new File("plugins//ZombieApocalypse//Worlds", name + ".yml");
						if(file.exists()){
							FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
							int x = p.getLocation().getBlockX();
							int y = p.getLocation().getBlockY();
							int z = p.getLocation().getBlockZ();
							
							String world = p.getWorld().getName();
							cfg.set("World.Lobby.x", x);
							cfg.set("World.Lobby.y", y);
							cfg.set("World.Lobby.z", z);
							cfg.set("World.Lobby.world", world);
							try {
								cfg.save(file);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(prefix+ChatColor.GREEN+"Lobbypunkt erfolgreich gesetzt!");
						}else{
							p.sendMessage(prefix+ChatColor.RED+"Karte nicht gefunden!");
						}
					}
				}
				if(args.length == 3){
					if(args[0].equals("setSpawnPoint")){
						String name = args[1];
						int nmb = Integer.valueOf(args[2]);
						File file = new File("plugins//ZombieApocalypse//Worlds", name + ".yml");
						if(file.exists()){
							FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
							int max = cfg.getInt("Players.Count");
							if(nmb > max || nmb < 0){
								p.sendMessage(prefix+ChatColor.RED+"Bitte wähle eine Zahl zwischen 0 und der maximalen Spieleranzahl!");
							}else{
							int x = p.getLocation().getBlockX();
							int y = p.getLocation().getBlockY();
							int z = p.getLocation().getBlockZ();
							
							String world = p.getWorld().getName();
							cfg.set("World.Spawn."+nmb+".x", x);
							cfg.set("World.Spawn."+nmb+".y", y);
							cfg.set("World.Spawn."+nmb+".z", z);
							cfg.set("World.Spawn.World", world);
							try {
								cfg.save(file);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(prefix+ChatColor.GREEN+"Spawnpunkt "+ChatColor.YELLOW+nmb+ChatColor.GREEN+" erfolgreich gesetzt!");
							}
						}else{
							p.sendMessage(prefix+ChatColor.RED+"Karte nicht gefunden!");
						}
					}
					if(args[0].equals("setCountdownStart")){
						String name = args[1];
						int nmb = Integer.valueOf(args[2]);
						File file = new File("plugins//ZombieApocalypse//Worlds", name + ".yml");
						if(file.exists()){
							FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
							int max = cfg.getInt("Players.Count");
							if(nmb > max || nmb < 0){
								p.sendMessage(prefix+ChatColor.RED+"Bitte wähle eine Zahl zwischen 0 und der maximalen Spieleranzahl!");
							}else{
							cfg.set("Game.Countdown.Start", nmb);
							try {
								cfg.save(file);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage(prefix+ChatColor.GREEN+"Countdownstart erfolgreich auf "+ChatColor.YELLOW+nmb+ChatColor.GREEN+" gesetzt!");
							}
						}else{
							p.sendMessage(prefix+ChatColor.RED+"Karte nicht gefunden!");
						}
					}
				}
			}
		}
		return true;
	}
	public void registerListeners(){
		ListenerSignChangeEvent l1 = new ListenerSignChangeEvent(this);
		ListenerPlayerInteractEvent l2 = new ListenerPlayerInteractEvent(this);
	}

}
