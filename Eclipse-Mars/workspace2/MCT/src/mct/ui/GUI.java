package mct.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class GUI extends JPanel implements KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;

	public GUI() {
		super();
		addMouseListener(this);
		addKeyListener(this);
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocus();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 9; y++) {
				if (y == 0) {
					g2.drawImage(Texture.GRASS.getImage().getScaledInstance(80, 80, 0), x * 80, y * 80, null);
					continue;
				}
				g2.drawImage(Texture.DIRT.getImage().getScaledInstance(80, 80, 0), x * 80, y * 80, null);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
