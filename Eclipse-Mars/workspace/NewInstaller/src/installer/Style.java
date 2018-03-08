package installer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Style extends JPanel{

	private static final long serialVersionUID = 1L;

	Image img;
	
	public Style() {
		setFocusable(true);
		ImageIcon ig = new ImageIcon("/res/txt/main.png");
		img = ig.getImage();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D f2 = (Graphics2D) g;
		f2.drawImage(img, 0, 0, null);
	}
}
