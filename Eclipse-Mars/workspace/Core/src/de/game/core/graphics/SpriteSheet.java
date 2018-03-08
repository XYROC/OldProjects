package de.game.core.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);
	public static SpriteSheet lv0 = new SpriteSheet("/textures/icons_.png", 256);
	
	public SpriteSheet(String path,int SIZE){
		this.path = path;
		this.SIZE = SIZE;
		this.pixels = new int[SIZE*SIZE];
		this.loadImage();
	}
	private void loadImage(){
		try {
			BufferedImage bimg = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = bimg.getWidth();
			int h = bimg.getHeight();
			bimg.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
