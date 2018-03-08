package xiroc.economy;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import xiroc.economy.listener.PlayerJoinEventListener;
import xiroc.economy.listener.ShopBuyBlocksListener;
import xiroc.economy.listener.ShopBuyFoodListener;
import xiroc.economy.listener.ShopMainListener;

public class Economy extends JavaPlugin {

	public Inventory shopmain;
	public static final String prefix = ChatColor.GRAY + "[" + ChatColor.GREEN + ChatColor.BOLD + "Economy"
			+ ChatColor.GRAY + "] ";

	public void onEnable() {
		System.out.println("[Economy] MainPlugin enabled");
		registerEvents();
	}

	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {

		} else {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("money")) {
				if (args.length == 0) {
					p.sendMessage(prefix + ChatColor.YELLOW + "Dein Geld: " + ChatColor.GREEN + getMoney(p.getName())
							+ ChatColor.YELLOW + " Gems");
				}
				if (args.length == 3) {
					if (args[0].equalsIgnoreCase("add")) {
						if (p.isOp()) {
							Player z = Bukkit.getPlayer(args[1]);
							if (z != null) {
								Integer amount = Integer.valueOf(args[2]);

								if (getMoney(z.getName()) + amount > 999999999) {
									p.sendMessage(prefix + ChatColor.RED + "Die Mindestanzahl an Gems ist "
											+ ChatColor.GREEN + "0" + ChatColor.YELLOW + "!");
								} else {
									addMoney(z.getName(), amount);
									p.sendMessage(prefix + ChatColor.YELLOW + "Der Spieler " + ChatColor.GREEN
											+ z.getName() + ChatColor.YELLOW + " hat nun " + ChatColor.GREEN
											+ getMoney(z.getName()) + ChatColor.YELLOW + " Gems!");
									updateScoreBoard(z);
								}

							} else {
								p.sendMessage(prefix + ChatColor.RED + "Spieler nicht gefunden!");
							}
						} else {
							p.sendMessage(prefix + ChatColor.RED
									+ "Du besitzt nicht die nötige Berechtigung, um dieses Kommando auszuführen!");
						}

					} else if (args[0].equalsIgnoreCase("remove")) {
						if (p.isOp()) {
							Player z = Bukkit.getPlayerExact(args[1]);
							if (z != null) {
								Integer amount = Integer.valueOf(args[2]);
								if (getMoney(z.getName()) - amount < 0) {
									p.sendMessage(prefix + ChatColor.RED + "Die Mindestanzahl an Gems ist "
											+ ChatColor.GREEN + "0" + ChatColor.YELLOW + "!");
								} else {
									removeMoney(z.getName(), amount);
									p.sendMessage(prefix + ChatColor.YELLOW + "Der Spieler " + ChatColor.GREEN
											+ z.getName() + ChatColor.YELLOW + " hat nun " + ChatColor.GREEN
											+ getMoney(z.getName()) + ChatColor.YELLOW + " Gems!");
									updateScoreBoard(z);
								}

							} else {
								p.sendMessage(prefix + ChatColor.RED + "Spieler nicht gefunden!");
							}
						} else {
							p.sendMessage(prefix + ChatColor.RED
									+ "Du besitzt nicht die nötige Berechtigung, um dieses Kommando auszuführen!");
						}

					} else if (args[0].equalsIgnoreCase("set")) {
						if (p.isOp()) {
							Player z = Bukkit.getPlayerExact(args[1]);
							if (z != null) {
								Integer amount = Integer.valueOf(args[2]);
								if (amount < 0) {
									p.sendMessage(prefix + ChatColor.RED + "Die Mindestanzahl an Gems ist  "
											+ ChatColor.GREEN + "0" + ChatColor.YELLOW + "!");
								} else {
									setMoney(z.getName(), amount);
									p.sendMessage(prefix + ChatColor.YELLOW + "Der Spieler " + ChatColor.GREEN
											+ z.getName() + ChatColor.YELLOW + " hat nun " + ChatColor.GREEN
											+ getMoney(z.getName()) + ChatColor.YELLOW + " Gems!");
									updateScoreBoard(z);
								}

							} else {
								p.sendMessage(prefix + ChatColor.RED + "Spieler nicht gefunden!");
							}
						} else {
							p.sendMessage(prefix + ChatColor.RED
									+ "Du besitzt nicht die nötige Berechtigung,um dieses Kommando auszuführen!");
						}

					} else if (args[0].equalsIgnoreCase("pay")) {
						Integer amount = Integer.valueOf(args[2]);
						if (amount <= 0) {
							p.sendMessage(prefix + ChatColor.RED + "Bitte wähle eine Zahl über 0!");
						} else {
							int gotmoney = getMoney(p.getName());
							if (gotmoney < amount) {
								p.sendMessage(prefix + ChatColor.RED + "Du hast nicht genug Gems!");
							} else {
								Player t = Bukkit.getPlayer(args[1]);
								removeMoney(p.getName(), amount);
								addMoney(t.getName(), amount);
								p.sendMessage(prefix + ChatColor.GREEN + "Du hast " + ChatColor.YELLOW + amount
										+ ChatColor.GREEN + " Gems an " + ChatColor.YELLOW + t.getName()
										+ ChatColor.GREEN + " ausgezahlt!");
								t.sendMessage(prefix + ChatColor.GREEN + "Du hast " + ChatColor.YELLOW + amount
										+ ChatColor.GREEN + " Gems von " + ChatColor.YELLOW + t.getName()
										+ ChatColor.GREEN + " bekommen!");
								updateScoreBoard(t);

							}
						}
					}

				}

			}
			if (cmd.getName().equalsIgnoreCase("shop")) {

				shopmain = p.getPlayer().getServer().createInventory(null, 9, "Shop");

				ItemStack selBlock = new ItemStack((Material.STONE));
				ItemMeta selStoneMeta = selBlock.getItemMeta();
				selStoneMeta.setDisplayName(ChatColor.GOLD + "Blöcke");
				selBlock.setItemMeta(selStoneMeta);

				ItemStack selFood = new ItemStack(Material.COOKED_BEEF);
				ItemMeta selFoodMeta = selFood.getItemMeta();
				selFoodMeta.setDisplayName(ChatColor.GOLD + "Essen");
				selFood.setItemMeta(selFoodMeta);

				shopmain.setItem(1, selBlock);
				shopmain.setItem(7, selFood);

				p.getPlayer().openInventory(shopmain);

			}
			updateScoreBoard(p);
		}
		return true;
	}

	public Integer getMoney(String name) {
		// File dataFile = new File("plugins//Economy");
		File data = new File("plugins//Economy", "data.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(data);
		int money = cfg.getInt(name + ".money");
		return money;

	}

	public String getMoneyString(String name) {
		int gems = getMoney(name);
		String money = gems + "";
		String lc = "k";
		int length = money.length();
		if (length > 3) {
			double x = (double) gems / 1000.0D;
			money = x+"";
			if (x > 999) {
				x /= 1000.0D;
				money = x+"";
				lc="m";
			}
			if(money.length() > 4){
				return money.substring(1, 5)+lc;
			}
		}
		return money+lc;
	}

	public void addMoney(String name, int amount) {
		// File dataFile = new File("plugins//Economy");
		File data = new File("plugins//Economy", "data.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(data);

		int money = cfg.getInt(name + ".money");

		money = money + amount;

		cfg.set(name + ".money", money);
		try {
			cfg.save(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeMoney(String name, int amount) {
		// File dataFile = new File("plugins//Economy");
		File data = new File("plugins//Economy", "data.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(data);

		int money = cfg.getInt(name + ".money");

		money = money - amount;

		cfg.set(name + ".money", money);
		try {
			cfg.save(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setMoney(String name, int amount) {
		File data = new File("plugins//Economy", "data.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(data);
		cfg.set(name + ".money", amount);
		try {
			cfg.save(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean hasEnoughMoney(String name, int amount) {
		File data = new File("plugins//Economy", "data.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(data);

		int money = cfg.getInt(name + ".money");
		if (money >= amount) {
			return true;
		} else {
			return false;
		}

	}

	@SuppressWarnings("deprecation")
	public void updateScoreBoard(Player p) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("---", "+++");

		int KILL = 24;
		int DEATH = 11;
		double KD = KILL / DEATH;
		int GEM = 5;

		obj.setDisplayName(
				ChatColor.RED + "" + ChatColor.BOLD + "Dark" + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Star");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score kills = obj.getScore(Bukkit.getOfflinePlayer("§4Kills"));
		Score killsc = obj.getScore(Bukkit.getOfflinePlayer("§4" + KILL));
		Score death = obj.getScore(Bukkit.getOfflinePlayer("§2Deaths"));
		Score deathc = obj.getScore(Bukkit.getOfflinePlayer("§2" + DEATH + " "));
		Score killdeath = obj.getScore(Bukkit.getOfflinePlayer("§3KD"));
		Score killdeathc = obj.getScore(Bukkit.getOfflinePlayer("§3" + KD + "  "));
		Score player = obj.getScore(ChatColor.AQUA+p.getName());
		Score Gems = obj.getScore(Bukkit
				.getOfflinePlayer("" + getMoneyString(p.getName()) + "" + ChatColor.GREEN + " Gems"));
		// Score Gemsc = obj.getScore(Bukkit.getOfflinePlayer("§7" + GEM));
		// Score zero = obj.getScore(Bukkit.getOfflinePlayer("-----"));

		// kills.setScore(8);
		// killsc.setScore(7);
		// death.setScore(6);
		// deathc.setScore(5);
		// killdeath.setScore(4);
		// killdeathc.setScore(3);
		player.setScore(10);
		Gems.setScore(9);
		// Gemsc.setScore(1);
		// zero.setScore(0);

		p.setScoreboard(board);
	}

	public void registerEvents() {
		ShopMainListener shpmainlst = new ShopMainListener(this);
		ShopBuyBlocksListener shbyblckslst = new ShopBuyBlocksListener(this);
		ShopBuyFoodListener shbyfdlst = new ShopBuyFoodListener(this);
		PlayerJoinEventListener pljlst = new PlayerJoinEventListener(this);
	}

}
