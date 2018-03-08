package messenger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GHD extends JavaPlugin {

	ConsoleCommandSender console = Bukkit.getConsoleSender();
	String msg = "";

	public void onEnable() {
		System.out.println("[LikeGommeHDMessenger] Messager Aktiviert!");

	}

	public void onDisable() {
		System.out.println("[LikeGommeHDMessenger] Messager Deaktiviert!");

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {

			console.sendMessage(ChatColor.RED + "You must be a Player!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("msg")) {
			if (args.length < 2) {
				p.sendMessage(ChatColor.RED + "Too few arguments!");
			} else {
				@SuppressWarnings("deprecation")
				Player z = Bukkit.getServer().getPlayer(args[0]);
				if(z == null){
					p.sendMessage(ChatColor.RED+"Player not found!");
				}else{
					
				for (int i = 1; i < args.length; i++) {
					msg = msg + " " + args[i];
					
				}
				p.sendMessage(ChatColor.GRAY + "Du" + ChatColor.YELLOW + "-->" + ChatColor.GRAY + z.getName()
						+ ChatColor.YELLOW + msg);
				z.sendMessage(ChatColor.GRAY + p.getName() + ChatColor.YELLOW + "-->" + ChatColor.GRAY + "Dir"
						+ ChatColor.YELLOW + msg);
				msg = "";
				
				}
			}

		}

		return true;
	}

}
