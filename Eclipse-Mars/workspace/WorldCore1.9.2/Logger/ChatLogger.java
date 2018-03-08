package Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import mainpackage.MainPlugin;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.PluginManager;

public class ChatLogger implements Listener {
	private MainPlugin plugin4;

	public void checkChatlogFile() {
		File logFile = new File("plugins//WorldCore//ChatLog//ChatLog.txt");

		if (!logFile.exists())
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public ChatLogger(MainPlugin plugin4) {
		this.plugin4 = plugin4;
		plugin4.getServer().getPluginManager().registerEvents(this, plugin4);
		System.out.println("[WorldCore] Activated Class ChatLogger (alpha0.1)");
		checkChatlogFile();
	}

	@EventHandler
	public void plchat(AsyncPlayerChatEvent chtevt) {
		Date date = new Date();
		SimpleDateFormat sdt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

		String dateString = sdt.format(date);

		String chtname = chtevt.getPlayer().getName();
		Player s = chtevt.getPlayer();
		String chtmessage = chtevt.getMessage();
		try {
			FileWriter fw = new FileWriter(new File("plugins//WorldCore//ChatLog//ChatLog.txt"));
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.newLine();
			bw.write(String.format("[" + dateString + "] " + chtname + " :" + chtmessage));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}