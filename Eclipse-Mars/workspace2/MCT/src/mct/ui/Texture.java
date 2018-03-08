package mct.ui;

import java.awt.image.BufferedImage;

import mct.MCT;

public enum Texture {
	
	//Blocks
	AIR(0),
	STONE(1),
	DIRT(2),
	GRASS(3),
	NETHERRACK(4),
	NR_PAXE(5);

	private int id;
	private BufferedImage image;
	
	private Texture(int id) {
		this.id = id;
		this.image = MCT.spriteSheet.getTexture(id); 
	}
	public int getId() {
		return id;
	}
	public BufferedImage getImage() {
		return image;
	}
	
}
