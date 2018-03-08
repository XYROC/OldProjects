package mct;

import javax.swing.JFrame;

import mct.ui.GUI;
import mct.ui.SpriteSheet;

public class MCT extends JFrame{
	
	public static SpriteSheet spriteSheet = new SpriteSheet(16, 16);
	
	private static final long serialVersionUID = 1L;
	
	public static MCT mct;

	public MCT() {
		super("MCT");
		setVisible(false);
		setSize(1280, 720);
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new GUI());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		mct = new MCT();
	}

}
