package mainpackage;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerDeathEvent
  implements Listener
{
  private MainPlugin plugin;

  public PlayerDeathEvent(MainPlugin plugin)
  {
    this.plugin = plugin;
    this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }
  @EventHandler
  public void onDeath(org.bukkit.event.entity.PlayerDeathEvent evt) {
    Player p = evt.getEntity();
    if ((p instanceof Player)) {
      Player killer = p.getKiller();
      Player dead = evt.getEntity();
      //evt.setDeathMessage(ChatColor.RED + dead.getName() + ChatColor.BLUE + " wurde von " + ChatColor.RED + killer.getName() + ChatColor.BLUE + " getötet!");
      if(this.plugin.warrior.contains(dead)){
    	  dead.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 1));
      }
      if(this.plugin.archer.contains(dead)){
    	  dead.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 1));
      }
      if(this.plugin.assasin.contains(dead)){
    	  dead.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 1));
		  dead.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 1));
      }
      if(this.plugin.zombie.contains(dead)){
    	  dead.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 1));
      }
      if(this.plugin.wizard.contains(dead)){
    	  dead.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 1));
		  dead.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 1));
		  dead.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1000000, 1));
      }
      if(this.plugin.hunter.contains(dead)){
    	  dead.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 3));
      }
      if(this.plugin.dragon.contains(dead)){
    	  dead.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 3));
    	  dead.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 3));
      }
    }
  }
}