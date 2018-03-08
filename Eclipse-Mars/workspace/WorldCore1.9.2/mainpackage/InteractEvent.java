package mainpackage;

import java.io.PrintStream;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginManager;

public class InteractEvent
  implements Listener
{
  private MainPlugin plugin3;

  public InteractEvent(MainPlugin plugin3)
  {
    plugin3.getServer().getPluginManager().registerEvents(this, plugin3);
    System.out.println("[WorldCore] Activated Class InteractEvent (v 0.1 INACTIVE)");
    this.plugin3 = plugin3;
  }
  @EventHandler
  public void Event(PlayerInteractEvent pl) {
    if (pl.getAction() == Action.RIGHT_CLICK_BLOCK) {
      Material b = pl.getClickedBlock().getType();
      Player localPlayer = pl.getPlayer();
    }
  }
}