package lc.blocks;

import java.awt.image.BufferedImage;

import lc.Main;

public enum Material {
	
	//Blocks
	AIR(0,true),
	STONE(1, false),
	DIRT(2, false),
	GRASS(3, false);

	private int id;
	private boolean walkable;
	private BufferedImage image;
	
	private Material(int id, boolean walkable) {
		this.id = id;
		this.walkable = walkable;
		this.image = Main.spriteSheetIn.getTexture(id); 
	}
	public int getId() {
		return id;
	}
	public boolean isWalkable() {
		return walkable;
	}
	public BufferedImage getImage() {
		return image;
	}
	
}
