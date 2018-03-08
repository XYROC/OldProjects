package lc;

import javax.swing.JFrame;

import lc.graphics.GamePanel;
import lc.util.SpriteSheet;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	public static SpriteSheet spriteSheetIn = new SpriteSheet(16, 16);
	public static final int BLOCKSIZE = 16;
	
	private int xSize = 1600;
	private int ySize = 900;
	
	public static Main main;
	
	public Main() {
		super("");
		setSize(xSize, ySize);
		//setUndecorated(true)
		add(new GamePanel());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void updateSize(int xSize, int ySize){
		setVisible(false);
		setLayout(null);
		setSize(xSize,ySize);
		setVisible(true);
	}
	
	public int getScreenXSize() {
		return xSize;
	}
	
	public int getScreenYSize() {
		return ySize;
	}
	
	public static void main(String[] args){
		main = new Main();
	}
	
}
