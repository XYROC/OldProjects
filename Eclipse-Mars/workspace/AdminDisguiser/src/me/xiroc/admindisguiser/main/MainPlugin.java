package me.xiroc.admindisguiser.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.robingrether.idisguise.api.DisguiseAPI;
import de.robingrether.idisguise.disguise.DisguiseType;
import de.robingrether.idisguise.disguise.MobDisguise;

public class MainPlugin extends JavaPlugin{
	
	public static DisguiseAPI api;
	
	@Override
	public void onEnable() {
		api = Bukkit.getServicesManager().getRegistration(DisguiseAPI.class).getProvider();
		System.out.println("[AD] AdminDisguiser Enabled!");
	}
	@Override
	public void onDisable() {
		System.out.println("[AD] AdminDisguiser Disabled!");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if (cmd.getName().equals("admindisguiser")) {
				if(args.length == 2){
					if(args[0].equals("disguise")){
						if(args[1].equals("Cow")){
							this.api.disguiseToAll(p, new MobDisguise(DisguiseType.COW, true));
							p.sendMessage(ChatColor.GRAY+"Disguised as:"+args[1]);
						}
						if(args[1].equals("Blaze")){
							this.api.disguiseToAll(p, new MobDisguise(DisguiseType.BLAZE, true));
							p.sendMessage(ChatColor.GRAY+"Disguised as:"+args[1]);
						}
						if(args[1].equals("Chicken")){
							this.api.disguiseToAll(p, new MobDisguise(DisguiseType.CHICKEN, true));
							p.sendMessage(ChatColor.GRAY+"Disguised as:"+args[1]);
						}
					}
					if(args[0].equals("undisguise")){
						
					}
				}
				if(args.length == 1){
					if(args[0].equals("undisguise")){
						this.api.undisguiseToAll(p);
						p.sendMessage(ChatColor.GRAY+"Undisguised!");
					}
				}
			}
		}
		
		return true;
	}

}
