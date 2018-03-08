package de.game.core.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class State {
	
	private String path;
	public int xSize;
	public int ySize;
	public int[] pixels;
	
	public static State graphics = new State("/textures/icons_.png", 256, 256);
	
	public State(String path,int xSize, int ySize){
		this.path = path;
		this.xSize = xSize;
		this.ySize = ySize;
		this.pixels = new int[xSize*ySize];
		this.loadImage();
	}
	private void loadImage(){
		try {
			BufferedImage bimg = ImageIO.read(State.class.getResource(path));
			int w = bimg.getWidth();
			int h = bimg.getHeight();
			bimg.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
