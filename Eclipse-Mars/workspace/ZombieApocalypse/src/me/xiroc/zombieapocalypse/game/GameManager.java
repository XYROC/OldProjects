package me.xiroc.zombieapocalypse.game;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class GameManager {
	public ArrayList<GameBoundManager> gameboundmanagerlist = new ArrayList<GameBoundManager>();
	public ArrayList<Block> blocklist = new ArrayList<Block>();

	public void addGametoSign(Block block) {
		if (block.getType() == Material.SIGN_POST || block.getType() == Material.WALL_SIGN) {

		}
	}

	public void registerGameBoundManager(GameBoundManager gameboundmanager) {
		gameboundmanagerlist.add(gameboundmanager);
	}

	public void unregisterGameBoundManager(GameBoundManager gameboundmanager) {
		gameboundmanagerlist.remove(gameboundmanager);
	}

	public void registerBlock(Block block) {
		blocklist.add(block);
	}

	public void unregisterBlock(Block block) {
		blocklist.remove(block);
	}

	public GameBoundManager getGameBoundManager(Block block) {
		if (block != null) {
			if (hasBlockGameBoundManager(block)) {
				for (GameBoundManager m : gameboundmanagerlist) {
					if (block.getWorld() == m.getWorld()) {
						if (block.getX() == m.getX()) {
							if (block.getY() == m.getY()) {
								if (block.getZ() == m.getZ()) {
									return m;
								}
							}
						}
					}
				}
				return null;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public boolean hasBlockGameBoundManager(Block block) {
		int i = 0;
		for (GameBoundManager m : gameboundmanagerlist) {
			if (block.getWorld() == m.getWorld()) {
				if (block.getX() == m.getX()) {
					if (block.getY() == m.getY()) {
						if (block.getZ() == m.getZ()) {
							i += 1;
						}
					}
				}
			}
		}
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

}
