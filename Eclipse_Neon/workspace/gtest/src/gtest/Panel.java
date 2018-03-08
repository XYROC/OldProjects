package gtest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	public Panel() {
		setBackground(Color.BLACK);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Main.table == null)
			return;
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < Main.lines; i++) {
			for (int j = 0; j < Main.maxLineLength; j++) {
				g2.setColor(Color.CYAN);
				g2.fillRect(30 * j, 20 * i, 30, 30);
				g2.setColor(Color.WHITE);
				g2.setFont(new Font("Consolas", 10, 10));
				g2.drawString(Main.table[i][j], 10 + 30 * j, 10 + 20 * i);

			}
		}

	}
}
