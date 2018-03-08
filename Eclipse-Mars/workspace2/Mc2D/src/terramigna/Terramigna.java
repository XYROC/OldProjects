package terramigna;

import javax.swing.JFrame;

import terramigna.graphics.GamePanel;
import terramigna.util.SpriteSheet;

public class Terramigna extends JFrame {

	private static final long serialVersionUID = 1L;
	public static SpriteSheet spriteSheetIn = new SpriteSheet(16, 16);
	public static final int BLOCKSIZE = 16;
	
	public Terramigna() {
		super("Terramigna");
		setSize(900, 600);
		add(new GamePanel());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args){
		new Terramigna();
	}
	
}
