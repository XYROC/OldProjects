package Listener;

import mainpackage.MainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreBoard
  implements Listener
{
  private MainPlugin plugin;
  int scheduler;

  public ScoreBoard(MainPlugin plugin)
  {
    this.plugin = plugin;
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();

    if (!Bukkit.getScheduler().isCurrentlyRunning(this.scheduler))
      this.scheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable()
      {
        public void run()
        {
        }
      }
      , 1000L, 1000L);
  }

  public void updateScoreBoard(Player p)
  {
    Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
    Objective obj = board.registerNewObjective("---", "+++");

    int KILL = 24;
    int DEATH = 11;
    double KD = KILL / DEATH;
    int GEM = 24;

    obj.setDisplayName("ｧ4[SCOREBOARD]");
    obj.setDisplaySlot(DisplaySlot.SIDEBAR);

    Score kills = obj.getScore(Bukkit.getOfflinePlayer("ﾃつｧ4Kills"));

    Score killsc = obj.getScore(Bukkit.getOfflinePlayer("ﾃつｧ4" + KILL));

    Score death = obj.getScore(Bukkit.getOfflinePlayer("ﾃつｧ2Deaths"));

    Score deathc = obj.getScore(Bukkit.getOfflinePlayer("ﾃつｧ2" + DEATH + " "));

    Score killdeath = obj.getScore(Bukkit.getOfflinePlayer("ﾃつｧ3KD"));

    Score killdeathc = obj.getScore(Bukkit.getOfflinePlayer("ﾃつｧ3" + KD + "  "));

    Score Gems = obj.getScore(Bukkit.getOfflinePlayer("ﾃつｧ5Gems"));

    Score Gemsc = obj.getScore(Bukkit.getOfflinePlayer("ﾃつｧ5" + GEM));

    Score zero = obj.getScore(Bukkit.getOfflinePlayer("====="));

    kills.setScore(8);
    killsc.setScore(7);
    death.setScore(6);
    deathc.setScore(5);
    killdeath.setScore(4);
    killdeathc.setScore(3);
    Gems.setScore(2);
    Gemsc.setScore(1);
    zero.setScore(0);
  }
}