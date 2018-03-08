package net.xiroc.survivalgames.events;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.xiroc.survivalgames.main.SurvivalGames;

public class InteractEvent implements Listener {

	private SurvivalGames plugin;
	private int time;
	private int countdown;
	private int countdownstart;
	private int countdownpeace;
	private int timestart;
	private float xp;
	private float xpstart;
	private String wrld;
	public File manager = new File("plugins//SurvivalGames//Game//Config" + "config.yml");
	public FileConfiguration mcfg = YamlConfiguration.loadConfiguration(manager);

	public InteractEvent(SurvivalGames plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.loadManager();
		System.out.println("[SurvivalGames] Loaded InteractEvent");
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block b = e.getClickedBlock();
			if (b.getType() == Material.ANVIL) {
				if (this.plugin.blockchest) {
					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}

			}
			if (b.getType() == Material.FURNACE) {
				if (this.plugin.blockchest) {
					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}
			}
			if (b.getType() == Material.BURNING_FURNACE) {
				if (this.plugin.blockchest) {
					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}
			}
			if (b.getType() == Material.ENDER_CHEST) {
				if (this.plugin.blockchest) {
					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}
			}
			if (b.getType() == Material.ENCHANTMENT_TABLE) {
				if (this.plugin.blockchest) {
					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}
			}
			if (b.getType() == Material.BREWING_STAND) {
				if (this.plugin.blockchest) {
					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}
			}
			if (b.getType() == Material.CHEST) {
				e.setCancelled(true);
			}
			if (b.getType() == Material.HOPPER) {
				if (this.plugin.blockchest) {
					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}
			}
			if (b.getType() == Material.DROPPER) {
				if (this.plugin.blockchest) {
					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}
			}
			if (b.getType() == Material.WORKBENCH) {
				if (this.plugin.blockchest) {
					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}
			}
			if (b.getType() == Material.DISPENSER) {
				if (this.plugin.blockchest) {
					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}
			}
			if (b.getType() == Material.WALL_SIGN || b.getType() == Material.SIGN_POST) {
				Sign s = (Sign) b.getState();
				if (s.getLine(0).equals("§7[§6SG§7]")) {
					String world = s.getLine(1);
					File theworld = new File("plugins//SurvivalGames//Worlds", world + ".yml");
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(theworld);
					String lobbyworld = cfg.getString("World.Lobby.World");
					int in = Integer.valueOf(s.getLine(3));
					int max = cfg.getInt("World.Size");
					if (in == max) {
						p.sendMessage(this.plugin.prefix + ChatColor.RED + "Dieses Spiel ist bereits voll!");
					} else {
						if (!cfg.contains("World.Lobby.x") || !cfg.contains("World.Lobby.y")
								|| !cfg.contains("World.Lobby.z")) {

						}
						mcfg.set("World." + world + ".blockmove", false);
						try {
							mcfg.save(manager);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						this.plugin.ingame.add(p);
						int newin = in + 1;
						s.setLine(3, "" + newin);
						s.update();

						int countdownstart = cfg.getInt("Game.Countdownstart");

						if (newin == countdownstart) {
							time = 60;
							xp = 1;
							String wname = world;
							wrld = world;
							countdown = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

								@Override
								public void run() {
									for (Player pl : plugin.ingame) {
										pl.setExp(xp);
										pl.setLevel(time);
									}
									if (time == 60) {
										for (Player pl : plugin.ingame) {
											pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
													+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
											pl.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
										}
									}
									if (time == 50) {
										for (Player pl : plugin.ingame) {
											pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
													+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
											pl.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
										}
									}
									if (time == 40) {
										for (Player pl : plugin.ingame) {
											pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
													+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
											pl.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
										}

									}
									if (time == 30) {
										for (Player pl : plugin.ingame) {
											pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
													+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
											pl.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
										}
									}
									if (time == 20) {
										for (Player pl : plugin.ingame) {
											pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
													+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
											pl.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
										}
									}
									if (time == 10) {
										for (Player pl : plugin.ingame) {
											pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
													+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
											pl.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
										}
									}
									if (time == 5) {
										for (Player pl : plugin.ingame) {
											pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
													+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
											pl.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
										}
									}
									if (time == 4) {
										for (Player pl : plugin.ingame) {
											pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
													+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
											pl.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
										}
									}
									if (time == 3) {
										for (Player pl : plugin.ingame) {
											pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
													+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
											pl.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
										}
									}
									if (time == 2) {
										for (Player pl : plugin.ingame) {
											pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
													+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
											pl.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
										}
									}
									if (time == 1) {
										for (Player pl : plugin.ingame) {
											pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
													+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
											pl.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
										}
									}
									if (time == 0) {
										for (Player pl : plugin.ingame) {
											pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in "
													+ ChatColor.YELLOW + time + ChatColor.GREEN + " Sekunden!");
											pl.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
										}
										Bukkit.getScheduler().cancelTask(countdown);
										int i = 1;
										for (Player pl : plugin.ingame) {

											double xn = cfg.getDouble("World.Spawn.Spawn" + i + ".x");
											double yn = cfg.getDouble("World.Spawn.Spawn" + i + ".y");
											double zn = cfg.getDouble("World.Spawn.Spawn" + i + ".z");

											String worldt = cfg.getString("World.Spawn.Spawn" + i + ".world");

											Location locn = new Location(Bukkit.getWorld(worldt), xn, yn, zn);

											// p.sendMessage(plugin.prefix+ChatColor.RED+"[DEBUG]
											// X:"+xn+"|Y:"+yn+"|Z:"+zn);

											mcfg.set("World." + wname + ".blockmove", true);
											try {
												mcfg.save(manager);
											} catch (IOException e2) {
												e2.printStackTrace();
											}
											pl.getInventory().clear();
											pl.teleport(locn);
											startPhase();

											i++;
										}

									}
									time--;
									xp = xp - 0.0166F;

								}
							}, 0, 20);
						}

						ItemStack lobby = new ItemStack(Material.GLOWSTONE_DUST);
						ItemMeta lobbyMeta = lobby.getItemMeta();
						lobbyMeta.setDisplayName("§6Lobby");
						lobby.setItemMeta(lobbyMeta);

						ItemStack start = new ItemStack(Material.DIAMOND);
						ItemMeta startMeta = start.getItemMeta();
						startMeta.setDisplayName("§6S§at§6a§ar§6t");
						start.setItemMeta(startMeta);

						double x = cfg.getDouble("World.Lobby.x");
						double y = cfg.getDouble("World.Lobby.y");
						double z = cfg.getDouble("World.Lobby.z");

						Location loc = new Location(Bukkit.getWorld(lobbyworld), x, y, z);

						p.getInventory().clear();

						p.getInventory().setItem(8, lobby);
						if (p.isOp()) {
							p.getInventory().setItem(0, start);
						}
						p.teleport(loc);

					}
				}
			}
			if (b.getType() == Material.OBSIDIAN) {

				if (this.plugin.obsidianchest) {

					if (this.plugin.sgchest.containsKey(e.getClickedBlock().getLocation())) {
						p.openInventory((Inventory) this.plugin.sgchest.get(e.getClickedBlock().getLocation()));
					} else {

						e.setCancelled(true);
						p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);

						Random rnd = new Random();
						int n = 1;
						n = rnd.nextInt(6);
						Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST);
						List<ItemStack> items = new ArrayList<ItemStack>();

						// items.add(new ItemStack(Material.DIAMOND));
						items.add(new ItemStack(Material.WOOD_SWORD));
						items.add(new ItemStack(Material.WOOD_SWORD));
						items.add(new ItemStack(Material.WOOD_SWORD));
						items.add(new ItemStack(Material.WOOD_SWORD));
						items.add(new ItemStack(Material.WOOD_SWORD));
						items.add(new ItemStack(Material.WOOD_SWORD));
						items.add(new ItemStack(Material.WOOD_SWORD));
						items.add(new ItemStack(Material.WOOD_SWORD));
						items.add(new ItemStack(Material.WOOD_SWORD));
						items.add(new ItemStack(Material.WOOD_SWORD));
						items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
						items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
						items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
						items.add(new ItemStack(Material.COOKED_BEEF, 5));
						items.add(new ItemStack(Material.COOKED_BEEF, 5));
						items.add(new ItemStack(Material.COOKED_BEEF, 2));
						items.add(new ItemStack(Material.COOKED_BEEF, 2));
						items.add(new ItemStack(Material.COOKED_BEEF, 2));
						items.add(new ItemStack(Material.COOKED_BEEF, 2));
						items.add(new ItemStack(Material.COOKED_BEEF, 2));
						items.add(new ItemStack(Material.COOKED_BEEF, 2));
						items.add(new ItemStack(Material.SEEDS));
						items.add(new ItemStack(Material.GOLD_HOE));
						items.add(new ItemStack(Material.GOLD_HOE));
						items.add(new ItemStack(Material.IRON_SWORD));
						items.add(new ItemStack(Material.IRON_CHESTPLATE));
						items.add(new ItemStack(Material.GOLD_CHESTPLATE));
						items.add(new ItemStack(Material.GOLD_SWORD));
						items.add(new ItemStack(Material.ARROW, 5));
						items.add(new ItemStack(Material.ARROW, 2));
						items.add(new ItemStack(Material.GOLDEN_APPLE));
						items.add(new ItemStack(Material.GOLD_SPADE));
						items.add(new ItemStack(Material.GOLD_SPADE));
						items.add(new ItemStack(Material.GOLD_SPADE));
						items.add(new ItemStack(Material.GOLDEN_CARROT, 1));
						items.add(new ItemStack(Material.GOLDEN_CARROT, 1));
						items.add(new ItemStack(Material.BOW));
						items.add(new ItemStack(Material.BOW));
						items.add(new ItemStack(Material.BOW));
						items.add(new ItemStack(Material.BOW));
						items.add(new ItemStack(Material.GOLD_AXE));
						items.add(new ItemStack(Material.GOLD_AXE));
						items.add(new ItemStack(Material.GOLD_AXE));
						items.add(new ItemStack(Material.GOLD_AXE));
						items.add(new ItemStack(Material.CHAINMAIL_LEGGINGS));
						items.add(new ItemStack(Material.CHAINMAIL_LEGGINGS));
						items.add(new ItemStack(Material.CHAINMAIL_LEGGINGS));
						items.add(new ItemStack(Material.GOLD_BOOTS));
						items.add(new ItemStack(Material.GOLD_BOOTS));
						items.add(new ItemStack(Material.GOLD_BOOTS));
						items.add(new ItemStack(Material.CHAINMAIL_HELMET));
						items.add(new ItemStack(Material.CHAINMAIL_HELMET));
						items.add(new ItemStack(Material.CHAINMAIL_HELMET));
						items.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
						items.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
						items.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
						items.add(new ItemStack(Material.STICK, 4));
						items.add(new ItemStack(Material.STICK, 2));
						items.add(new ItemStack(Material.STICK));
						items.add(new ItemStack(Material.IRON_LEGGINGS));
						items.add(new ItemStack(Material.RAW_BEEF, 10));
						items.add(new ItemStack(Material.RAW_BEEF, 10));
						items.add(new ItemStack(Material.RAW_BEEF, 10));
						items.add(new ItemStack(Material.RAW_BEEF, 10));
						items.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
						items.add(new ItemStack(Material.FLINT_AND_STEEL));
						items.add(new ItemStack(Material.FLINT_AND_STEEL));
						items.add(new ItemStack(Material.IRON_BOOTS));
						items.add(new ItemStack(Material.POTATO, 5));
						items.add(new ItemStack(Material.POTATO, 5));
						items.add(new ItemStack(Material.POTATO, 5));
						items.add(new ItemStack(Material.CARROT, 7));
						items.add(new ItemStack(Material.DIAMOND_HELMET));
						items.add(new ItemStack(Material.DIAMOND_HOE));
						items.add(new ItemStack(Material.IRON_HOE));
						// items.add(new ItemStack(Material.DIAMOND, 2));
						items.add(new ItemStack(Material.DIAMOND_SWORD));
						items.add(new ItemStack(Material.STONE_SWORD));
						items.add(new ItemStack(Material.STONE_SWORD));
						items.add(new ItemStack(Material.STONE_SWORD));
						items.add(new ItemStack(Material.STONE_SWORD));
						items.add(new ItemStack(Material.STONE_SWORD));
						items.add(new ItemStack(Material.STONE_SWORD));
						items.add(new ItemStack(Material.STONE_HOE));
						items.add(new ItemStack(Material.STONE_HOE));
						items.add(new ItemStack(Material.STONE_HOE));
						// items.add(new ItemStack(Material.STONE_PICKAXE));
						items.add(new ItemStack(Material.STONE_AXE));
						// items.add(new ItemStack(Material.REDSTONE, 3));
						// items.add(new ItemStack(Material.REDSTONE, 5));
						// items.add(new ItemStack(Material.DIRT, 7));
						// items.add(new ItemStack(Material.SAND, 4));
						// items.add(new ItemStack(Material.SANDSTONE, 6));
						// items.add(new ItemStack(Material.COBBLESTONE, 2));
						items.add(new ItemStack(Material.DIAMOND_PICKAXE));
						items.add(new ItemStack(Material.GOLD_PICKAXE));
						items.add(new ItemStack(Material.APPLE, 8));
						items.add(new ItemStack(Material.APPLE, 8));
						items.add(new ItemStack(Material.APPLE, 8));
						items.add(new ItemStack(Material.BAKED_POTATO, 6));
						items.add(new ItemStack(Material.BAKED_POTATO, 6));
						items.add(new ItemStack(Material.BAKED_POTATO, 6));
						items.add(new ItemStack(Material.RAW_CHICKEN));
						items.add(new ItemStack(Material.RAW_CHICKEN));
						items.add(new ItemStack(Material.RAW_CHICKEN));
						items.add(new ItemStack(Material.COOKED_CHICKEN));
						items.add(new ItemStack(Material.COOKED_CHICKEN));
						items.add(new ItemStack(Material.COOKED_CHICKEN));
						items.add(new ItemStack(Material.ENDER_PEARL));
						items.add(new ItemStack(Material.ENDER_PEARL));
						items.add(new ItemStack(Material.ENDER_PEARL));
						items.add(new ItemStack(Material.GOLD_CHESTPLATE));
						items.add(new ItemStack(Material.GOLD_CHESTPLATE));
						items.add(new ItemStack(Material.GOLD_CHESTPLATE));
						items.add(new ItemStack(Material.GOLD_CHESTPLATE));
						items.add(new ItemStack(Material.GOLD_CHESTPLATE));
						items.add(new ItemStack(Material.GOLD_CHESTPLATE));

						while (n != 0) {
							n--;
							Random rnd2 = new Random();
							Random rnd3 = new Random();

							int n2 = rnd2.nextInt(items.size());
							int n3 = rnd3.nextInt(27);

							inv.setItem(n3, (ItemStack) items.get(n2));

						}
						this.plugin.sgchest.put(e.getClickedBlock().getLocation(), inv);
						p.openInventory(inv);
						return;

					}
					return;
				} else {
					e.setCancelled(true);
				}
			}

		}
		if (p.getItemInHand().getType() == Material.DIAMOND) {
			if (p.getItemInHand().getItemMeta().getDisplayName().equals("§6S§at§6a§ar§6t")) {
				if (this.time > 10) {
					this.time = 10;
					this.xp = 0.167F;
				}
			}
		}
		if (p.getItemInHand().getType() == Material.GLOWSTONE_DUST) {
			if (p.getItemInHand().getItemMeta().getDisplayName().equals("§6Lobby")) {
				File theworld = new File("plugins//SurvivalGames//Worlds", "LobbyLeave" + ".yml");
				if (theworld.exists()) {
					FileConfiguration cfg = YamlConfiguration.loadConfiguration(theworld);

					double x = cfg.getDouble("Game.Lobbyleavepoint.x");
					double y = cfg.getDouble("Game.Lobbyleavepoint.y");
					double z = cfg.getDouble("Game.Lobbyleavepoint.z");

					String world = cfg.getString("Game.Lobbyleavepoint.world");

					Location l = new Location(Bukkit.getWorld(world), x, y, z);
					this.plugin.ingame.remove(p);
					p.teleport(l);
				} else {
					p.sendMessage(plugin.prefix + ChatColor.RED + "Lobby nicht gefunden!");
				}

			}
		}

	}

	public void startPhase() {
		timestart = 20;
		xpstart = 1;
		countdownstart = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			@Override
			public void run() {
				if (timestart == 20) {
					for (Player pl : plugin.ingame) {
						pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in " + ChatColor.YELLOW
								+ timestart + ChatColor.GREEN + " Sekunden!");
						pl.playSound(pl.getLocation(), Sound.NOTE_PIANO, 10, 10);
					}
				}
				if (timestart == 10) {
					for (Player pl : plugin.ingame) {
						pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in " + ChatColor.YELLOW
								+ timestart + ChatColor.GREEN + " Sekunden!");
						pl.playSound(pl.getLocation(), Sound.NOTE_PIANO, 10, 10);
					}
				}
				if (timestart == 5) {
					for (Player pl : plugin.ingame) {
						pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in " + ChatColor.YELLOW
								+ timestart + ChatColor.GREEN + " Sekunden!");
						pl.playSound(pl.getLocation(), Sound.NOTE_PIANO, 10, 10);
					}
				}
				if (timestart == 4) {
					for (Player pl : plugin.ingame) {
						pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in " + ChatColor.YELLOW
								+ timestart + ChatColor.GREEN + " Sekunden!");
						pl.playSound(pl.getLocation(), Sound.NOTE_PIANO, 10, 10);
					}
				}
				if (timestart == 3) {
					for (Player pl : plugin.ingame) {
						pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in " + ChatColor.YELLOW
								+ timestart + ChatColor.GREEN + " Sekunden!");
						pl.playSound(pl.getLocation(), Sound.NOTE_PIANO, 10, 10);
					}
				}
				if (timestart == 2) {
					for (Player pl : plugin.ingame) {
						pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in " + ChatColor.YELLOW
								+ timestart + ChatColor.GREEN + " Sekunden!");
						pl.playSound(pl.getLocation(), Sound.NOTE_PIANO, 10, 10);
					}
				}
				if (timestart == 1) {
					for (Player pl : plugin.ingame) {
						pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in " + ChatColor.YELLOW
								+ timestart + ChatColor.GREEN + " Sekunden!");
						pl.playSound(pl.getLocation(), Sound.NOTE_PIANO, 10, 10);
					}
				}
				if (timestart == 0) {
					for (Player pl : plugin.ingame) {
						pl.sendMessage(plugin.prefix + ChatColor.GREEN + "Das Spiel beginnt in " + ChatColor.YELLOW
								+ timestart + ChatColor.GREEN + " Sekunden!");
						pl.playSound(pl.getLocation(), Sound.NOTE_PLING, 10, 10);

					}
					peacePhase();
					String w = wrld;
					mcfg.set("World." + w + ".blockmove", false);
					try {
						mcfg.save(manager);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				timestart--;
				xpstart = xpstart - 0.05F;
			}
		}, 0, 20);
	}

	public void peacePhase() {

	}

	public void loadManager() {
		mcfg.set("Info", "Managerfile für Survivalgames - NICHT LÖSCHEN!");
		try {
			mcfg.save(manager);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
