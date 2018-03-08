package mi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage img;

	public Panel() {
		super();
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocus();

		img = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		for(int x = 0;x<13;x++){
			for(int y = 0;y<8;y++){
				if(y == 0){
					g2.drawImage(Texture.GRASS.getImage().getScaledInstance(80, 80, 0), x*80, y*80, null);
					continue;
				}
				g2.drawImage(Texture.DIRT.getImage().getScaledInstance(80, 80, 0), x*80, y*80, null);
			}
		}
	}

}
