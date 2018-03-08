package mainpackage;

import Listener.ScoreBoard;
import Listener.Tracker;
import Logger.ChatLogger;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class MainPlugin extends JavaPlugin {
	
	public boolean kiblock;
	public boolean dragonfire;
	public boolean colorednames;
	private Inventory inv = null;
	JoinEvent jv = null;
	Kits kits = null;
	InteractEvent ievt = null;
	ChatLogger chtlog = null;
	DragonFire drf = null;
	PlayerDeathEvent death = null;
	Tracker track = null;

	ConsoleCommandSender console = Bukkit.getConsoleSender();

	String nick = null;

	File kitblock = new File("plugins//WorldCore//Kits//kitblock.yml");
	File Kits = new File("plugins//WorldCore//Kits");
	File file = new File("plugins//WorldCore");
	File config = new File("plugins//WorldCore//Config", "config.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(config);
	YamlConfiguration kitconf = YamlConfiguration.loadConfiguration(this.kitblock);

	public ArrayList<Player> dragon = new ArrayList<Player>();
	public ArrayList<Player> archer = new ArrayList<Player>();
	public ArrayList<Player> warrior = new ArrayList<Player>();
	public ArrayList<Player> wizard = new ArrayList<Player>();
	public ArrayList<Player> zombie = new ArrayList<Player>();
	public ArrayList<Player> hunter = new ArrayList<Player>();
	public ArrayList<Player> assasin = new ArrayList<Player>();
	public ArrayList<Player> nuker = new ArrayList<Player>();

	public void checkFiles() {
		File config = new File("plugins//WorldCore//Config//config.yml");
		File votes = new File("plugins//WorldCore//Voting//votes.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(config);
		FileConfiguration vcfg = YamlConfiguration.loadConfiguration(votes);
		if (!cfg.contains("Config.Colorednames")) {
			cfg.set("Config.colorednames", false);
			this.colorednames = cfg.getBoolean("Config.Colorednames");
		} else {
			this.colorednames = cfg.getBoolean("Config.Colorednames");
		}
		if (!vcfg.contains("Votes.Farmwelt")) {
			vcfg.set("Votes.Farmwelt", 0);
		} else {

		}
		try {
			vcfg.save(votes);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (!this.file.isDirectory()) {
			this.file.mkdir();
		}

		if (!this.Kits.isDirectory()) {
			this.Kits.mkdir();
		}
		if (!this.kitblock.exists()) {
			try {
				this.kitblock.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			cfg.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadConfig() {
		this.kiblock = cfg.getBoolean("Config.KitBlock");
		this.colorednames = cfg.getBoolean("Config.ColoredNames");

		if (!cfg.contains("Config.Colorednames") || !cfg.contains("Config.KitBlock")) {
			cfg.set("Config.Colorednames", true);
			cfg.set("Config.KitBlock", true);
		}
		try {
			this.cfg.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onEnable() {
		this.dragonfire = false;

		System.out.println("[WorldCore] Activated MainPlugin");
		checkFiles();
		JoinEvent jv = new JoinEvent(this);
		Kits kits = new Kits(this);
		InteractEvent ievt = new InteractEvent(this);
		ChatLogger chtlog = new ChatLogger(this);
		PlayerDeathEvent death = new PlayerDeathEvent(this);
		ScoreBoard brd = new ScoreBoard(this);
		// Tracker track = new Tracker(this);
		DragonFire drf = new DragonFire(this);
		EnumLoader el = new EnumLoader(this);

		this.loadConfig();
	}

	public void onDisable() {
		System.out.println("[WorldCore] Deactivated MainPlugin");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			this.console.sendMessage(ChatColor.RED + "You must be a Player!");
			return true;
		}

		Player p = (Player) sender;
		ItemMeta istackMeta2;
		if (cmd.getName().equalsIgnoreCase("Kits")) {
			if (this.kiblock) {
				p.sendMessage(ChatColor.RED + "Die Kit Funktion ist deaktiviert!");
				return true;
			}

			this.inv = p.getPlayer().getServer().createInventory(null, 9, "Kits");
			ItemStack istack = new ItemStack(Material.IRON_SWORD);
			ItemMeta istackMeta = istack.getItemMeta();
			istackMeta.setDisplayName("§1Krieger");
			istack.setItemMeta(istackMeta);

			ItemStack istack2 = new ItemStack(Material.POTION);
			istackMeta2 = istack2.getItemMeta();
			istackMeta2.setDisplayName("§1Magier");
			istack2.setItemMeta(istackMeta2);

			ItemStack istack3 = new ItemStack(Material.ROTTEN_FLESH);
			ItemMeta istackMeta3 = istack3.getItemMeta();
			istackMeta3.setDisplayName("§1Zombie");
			istack3.setItemMeta(istackMeta3);

			ItemStack istack4 = new ItemStack(Material.BOW);
			ItemMeta istackMeta4 = istack4.getItemMeta();
			istackMeta4.setDisplayName("§1BogenschÃƒÂ¼tze");
			istack4.setItemMeta(istackMeta4);

			ItemStack istack5 = new ItemStack(Material.TNT);
			ItemMeta istackMeta5 = istack5.getItemMeta();
			istackMeta5.setDisplayName("§1Nuker");
			istack5.setItemMeta(istackMeta5);

			ItemStack istack6 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			ItemMeta istackMeta6 = istack6.getItemMeta();
			istackMeta6.setDisplayName("§1Assasin");
			istack6.setItemMeta(istackMeta6);

			ItemStack istack7 = new ItemStack(Material.DIAMOND_CHESTPLATE);
			ItemMeta istackMeta7 = istack7.getItemMeta();
			istackMeta7.setDisplayName("§4DRAGON");
			istack7.setItemMeta(istackMeta7);

			ItemStack istack8 = new ItemStack(Material.GOLD_AXE);
			ItemMeta istackMeta8 = istack8.getItemMeta();
			istackMeta8.setDisplayName("§4Hunter");
			istack8.setItemMeta(istackMeta8);

			this.inv.setItem(1, istack);
			this.inv.setItem(2, istack5);
			this.inv.setItem(3, istack7);
			this.inv.setItem(4, istack2);
			this.inv.setItem(5, istack6);
			this.inv.setItem(6, istack4);
			this.inv.setItem(7, istack3);
			this.inv.setItem(8, istack8);

			p.getPlayer().openInventory(this.inv);
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("kitconf")) {
			if ((p.isOp()) && (args.length == 1)) {
				if (args[0].equals("true")) {
					this.kiblock = true;
					p.sendMessage(
							ChatColor.AQUA + "Set KitBlock to " + ChatColor.GREEN + "TRUE" + ChatColor.AQUA + "!");
					return true;
				}
				if (args[0].equals("false")) {
					this.kiblock = false;
					p.sendMessage(ChatColor.AQUA + "Set KitBlock to " + ChatColor.RED + "FALSE" + ChatColor.AQUA + "!");
					return true;
				}

			}

		}

		if (cmd.getName().equalsIgnoreCase("brdcst")) {
			String Message = "";
			for (int i = 0; i < args.length; i++) {
				Message = Message + args[i] + " ";
			}
			for (Player player : Bukkit.getOnlinePlayers()) {
				String n = player.getName();

				player.sendMessage(ChatColor.GREEN + "[" + ChatColor.GRAY + "-" + ChatColor.YELLOW + "Breaking News"
						+ ChatColor.GRAY + "-" + ChatColor.GREEN + "]" + ChatColor.BLUE + "+++" + ChatColor.GREEN
						+ Message + ChatColor.BLUE + "+++");
				System.out.println(n + " broadcasted: " + Message);
			}
			return true;
		}

		if (cmd.getName().equals("home")) {
			Location bed = p.getBedSpawnLocation();

			if (bed == null) {
				p.sendMessage(ChatColor.RED + "Bed not found!");
				return true;
			}
			p.teleport(bed);
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("universe")) {
			if (args[0].equalsIgnoreCase("tp")) {
				if (args.length == 2) {
					String world = args[1];
					World w = Bukkit.getWorld(world);
					if (w != null) {
						p.sendMessage(ChatColor.AQUA + "Teleporting...");
						p.teleport(w.getSpawnLocation());
						return true;
					}
					p.sendMessage(ChatColor.RED + "World not found!");
					return true;
				}

				if (args.length == 3) {
					Player t = Bukkit.getPlayer(args[1]);
					String world = args[2];
					World w = Bukkit.getWorld(world);

					if (t != null) {
						if (w != null) {
							p.sendMessage(ChatColor.AQUA + "Teleporting " + t.getName() + "...");
							t.teleport(w.getSpawnLocation());
							return true;
						}
						p.sendMessage(ChatColor.RED + "World not found!");
					} else {
						p.sendMessage(ChatColor.RED + "Player not found");
						return true;
					}
				} else {
					p.sendMessage(ChatColor.RED + " Invalid count of arguments!");
					return true;
				}
			} else if (args[0].equalsIgnoreCase("create")) {
				if (args.length == 2) {
					String worldName = args[1];

					p.sendMessage(ChatColor.GREEN + "Creating world " + worldName + "...");

					WorldCreator c = WorldCreator.name(worldName).environment(World.Environment.NORMAL)
							.type(WorldType.AMPLIFIED);

					Bukkit.createWorld(c);
					p.sendMessage(ChatColor.GREEN + "Finished!!");
					return true;
				}

				return true;
			}

			return true;
		}
		if (cmd.getName().equalsIgnoreCase("myname")) {
			if (args.length == 1) {
				if (p.getName().equals("XIROC")) {
					String nick = args[0];
					Player nckp = Bukkit.getPlayer(nick);
					if (nckp != null) {
						if (nckp.isOp()) {
							if (colorednames) {
								p.setDisplayName("§4" + args[0] + "§r");
								p.setPlayerListName("§4" + args[0] + "§r");
							} else {
								p.setDisplayName(args[0]);
								p.setPlayerListName(args[0]);
							}
						} else {
							if (colorednames) {
								p.setDisplayName("§2" + args[0] + "§r");
								p.setPlayerListName("§2" + args[0] + "§r");
							} else {
								p.setDisplayName(args[0]);
								p.setPlayerListName(args[0]);
							}
						}
					} else {
						if (colorednames) {
							p.setDisplayName("§2" + args[0] + "§r");
							p.setPlayerListName("§2" + args[0] + "§r");
						} else {
							p.setDisplayName(args[0]);
							p.setPlayerListName(args[0]);
						}
					}

					p.sendMessage(ChatColor.YELLOW + "Nick: " + ChatColor.GREEN + args[0]);
					return true;
				}
				p.sendMessage(ChatColor.RED + "Zum Ausführen dieses Kommandos bist du nicht berechtigt!");
			} else {
				p.sendMessage(ChatColor.RED + "Invalid count of arguments!");
			}
		}
		if (cmd.getName().equalsIgnoreCase("ConInf")) {
			int conn = (int) Bukkit.getConnectionThrottle();
			int port = Bukkit.getPort();
			int slots = Bukkit.getMaxPlayers();
			int idleTimeout = Bukkit.getIdleTimeout();
			String IP = Bukkit.getServer().getIp();
			if (p.getName().equals("XIROC")) {
				p.sendMessage(ChatColor.GREEN + "Server/Verbindungsinformationen:");
				p.sendMessage(ChatColor.GREEN + "ConnectionThrottle:" + ChatColor.YELLOW + conn);
				p.sendMessage(ChatColor.GREEN + "Port:" + ChatColor.YELLOW + port);
				p.sendMessage(ChatColor.GREEN + "Slots: " + ChatColor.YELLOW + slots);
				p.sendMessage(ChatColor.GREEN + "IdleTimeout: " + ChatColor.YELLOW + idleTimeout);
				p.sendMessage(ChatColor.GREEN + "IP: " + ChatColor.YELLOW + IP);
			} else {
				p.sendMessage(ChatColor.RED + "Du bist nicht dazu berechtigt dieses Kommando auszufÃƒÂ¼hren!");
			}

			return true;
		}

		if (cmd.getName().equals("fakeOP")) {
			Player z = Bukkit.getPlayer(args[0]);
			z.sendMessage(ChatColor.YELLOW + "You are now op");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("invsee")) {
			if (p.getName().equals("XIROC")) {
				Player z = Bukkit.getServer().getPlayer(args[0]);
				if (z != null) {
					SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
					String current = date.format(new Date());

					if (args.length == 1) {
						p.openInventory(z.getInventory());
						p.sendMessage("§2Invontory of " + z.getName() + " | Time: " + current);
					} else if (args.length == 2) {
						if (args[1].equalsIgnoreCase("enderch")) {
							p.openInventory(z.getEnderChest());

							p.sendMessage("§2EnderChestInvontory of " + z.getName() + " | Time: " + current);
						}
					} else {
						p.sendMessage("§4Invalid count of Arugments!");
					}
				} else {
					p.sendMessage(ChatColor.RED + "Player not found!");
				}
			} else {
				p.sendMessage("§4Permission denied!");
			}
			return true;
		}
		if (cmd.getName().equals("vote")) {
			if (args.length == 1) {
				if (args[0].equals("Farmwelt")) {
					File votes = new File("plugins//WorldCore//Voting//votes.yml");
					FileConfiguration vcfg = YamlConfiguration.loadConfiguration(votes);
					int i = vcfg.getInt("Votes.Farmwelt");
					i += 1;
					p.sendMessage(ChatColor.GOLD + "Du hast für eine Farmwelt gevotet!");

				}
			} else {
				p.sendMessage(ChatColor.RED + "Zu wenige Argumente!");
			}
		}

		return true;
	}

	private void registerEvents() {
	}

	private void registerCommands() {
	}
}