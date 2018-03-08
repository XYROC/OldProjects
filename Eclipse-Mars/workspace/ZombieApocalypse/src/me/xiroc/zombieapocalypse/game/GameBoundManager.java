package me.xiroc.zombieapocalypse.game;

import org.bukkit.World;
import org.bukkit.block.Block;

public class GameBoundManager {
	private int x;
	private int y;
	private int z;
	private World world;
	private Game game;
	private Block block;
	
	private GameManager gm = new GameManager();
		
	public GameBoundManager(Block block, Game game) {
		this.x = block.getX();
		this.y = block.getY();
		this.z = block.getZ();
		this.world = block.getWorld();
		this.game = game;
		this.block = block;
		gm.registerBlock(block);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getZ(){
		return z;
	}
	public World getWorld(){
		return world;
	}
	public Game getGame(){
		return game;
	}
	public Block getBlock(){
		return block;
	}

}
