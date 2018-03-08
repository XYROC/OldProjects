package graphics.graphics2d;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Panel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BufferedImage img;
	
	public Panel() {
		super();
		img = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) img.getGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.drawImage(img.getScaledInstance(560, 560, Image.SCALE_DEFAULT), 0, 0, null);
		g2.drawString("String", 10, 10);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

}
