package mainpackage;

import java.io.PrintStream;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;

public class DragonFire
  implements Listener
{
  private MainPlugin plugin;

  public DragonFire(MainPlugin plugin)
  {
    this.plugin = plugin;
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
    System.out.println("[WorldCore] Activated Class DragonFire (v.0.1)");
  }

  @EventHandler
  public void onFire(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    if (((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && 
      (e.getMaterial() == Material.FIREBALL) && 
      (e.getItem().getItemMeta().getDisplayName().equals("Â§4DRAGONFIRE"))) {
      if (this.plugin.dragonfire) {
        e.setCancelled(true);
        p.launchProjectile(Fireball.class);
      } else {
        e.setCancelled(true);
        p.sendMessage(ChatColor.RED + "Die DRAGONFIRE - Funktion ist deaktiviert!");
      }

    }

    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (e.getMaterial() == Material.FIREBALL) && 
      (e.getItem().getItemMeta().getDisplayName().equals("Â§4DRAGONFIRE")))
      e.setCancelled(true);
  }
}