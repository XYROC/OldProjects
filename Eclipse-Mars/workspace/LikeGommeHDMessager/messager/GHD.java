package messager;

import java.io.PrintStream;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GHD extends JavaPlugin {
	String msg = "";
	ConsoleCommandSender console = Bukkit.getConsoleSender();

	/*    */ public void onEnable()

	/*    */ {

		/* 11 */ System.out.println("[LikeGommeHDMessager aktivert!]");
		/*    */ }

	/*    */
	/*    */ public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	/*    */ {
		if (!(sender instanceof Player)) {
			console.sendMessage(ChatColor.RED+"You must be a Player");
			return true;
		}
		/* 18 */ if (cmd.getName().equalsIgnoreCase("msg")) {
			/* 19 */ Player p = (Player) sender;

			/* 20 */ Player z = Bukkit.getPlayer(args[0]);
			/* 21 */ if (z != null) {
				for (int i = 1; i < args.length; i++) {
					msg = msg + args[i] + " ";
				}

				if (args.length >= 2) {
					/* 22 */ p.sendMessage(ChatColor.GRAY + "Du" + ChatColor.DARK_GRAY +
							/* 23 */ "->" + ChatColor.GRAY + z.getDisplayName() + " " +
							/* 24 */ ChatColor.YELLOW + msg);
					/*    */
					/* 26 */ z.sendMessage(ChatColor.GRAY + p.getDisplayName() + ChatColor.DARK_GRAY +
							/* 27 */ "->" + ChatColor.GRAY + "Dir " + ChatColor.YELLOW +
							/* 28 */ msg);

					msg = "";
					/* 29 */ return true;
					/*    */ }
			}
			/* 31 */ p.sendMessage(ChatColor.RED + "Player not found!");
			/*    */ }
		/*    */
		/* 35 */ return false;
		/*    */ }
	/*    */ }