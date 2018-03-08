package terramigna.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private int size;
	private int column;
	BufferedImage sprite;
	
	public SpriteSheet(int column, int blockSize) {
		this.column = column;
		this.size = blockSize;
		load();
	}
	
	public BufferedImage getTexture(int id){
		int y = (id/column) * size;
		int x = (id%column) * size;
		return sprite.getSubimage(x, y, size, size);
	}
	private void load() {	
		try {
			sprite = ImageIO.read(new File("img/terrain.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
