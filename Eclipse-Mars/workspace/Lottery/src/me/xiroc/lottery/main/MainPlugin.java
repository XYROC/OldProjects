package me.xiroc.lottery.main;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin{
	
	@Override
	public void onEnable() {
		this.loadFile();
		this.runBroadCast();
		System.out.println("[Lottery] Lottery Enabled!");
	}
	@Override
	public void onDisable() {
		System.out.println("[Lottery] Lottery Disabled!");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(cmd.getName().equals("register")){
				File file = new File("plugins//Lottery//Players","list.yml");
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				if(cfg.contains("Lottery.Players."+p.getName())){
					p.sendMessage(ChatColor.RED+"Du hast dich bereits eingetragen!");
				}else{
					int i = cfg.getInt("Lottery.Players.Count");
					int n = i+1;
					if(i == 0){
						cfg.set("Lottery.Players."+p.getName(), true);
						cfg.set("Lottery.Players.List.p"+0, p.getName());
						cfg.set("Lottery.Players.Count", 0);
					}else{
						cfg.set("Lottery.Players."+p.getName(), true);
						cfg.set("Lottery.Players.List.p"+n, p.getName());
						cfg.set("Lottery.Players.Count", n);
					}
					
					
					try {
						cfg.save(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.sendMessage(ChatColor.GREEN+"Du hast dich erfolgreich eingetragen!");
				}
			}
			if(cmd.getName().equals("lottery")){
				if(p.isOp()){
					File file = new File("plugins//Lottery//Players","list.yml");
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					int i = cfg.getInt("Lottery.Players.Count");
					int w = new Random().nextInt(i+1);
					String name = cfg.getString("Lottery.Players.List.p"+w);
					p.sendMessage(ChatColor.GREEN+"Der Gewinner ist:"+ChatColor.YELLOW+name+ChatColor.GREEN+"!");
				}else{
					p.sendMessage(ChatColor.RED+"Du darfst dieses Kommando nicht ausführen!");
				}
			}
		}
		
		return true;
	}
	public void registerEvents(){
		
		
		
	}
	public void loadFile(){
		File file = new File("plugins//Lottery//Players", "list.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

		String prize = cfg.getString("Lottery.Prize");
		String count = cfg.getString("Lottery.Prize.Count");
		
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void runBroadCast(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			File file = new File("plugins//Lottery//Players","list.yml");
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			
			String prize = cfg.getString("Lottery.Prize");
			String count = cfg.getString("Lottery.Prize.Count");

			@Override
			public void run() {
				for (Player pl : Bukkit.getOnlinePlayers()) {
					pl.sendMessage(ChatColor.GREEN
							+ "NEU: Wöchentliche Lotterie! Preis: "+ChatColor.YELLOW+count+ChatColor.GREEN+" "+prize+"!");
				}
			}
		}, 7400, 7400);
	}

}
