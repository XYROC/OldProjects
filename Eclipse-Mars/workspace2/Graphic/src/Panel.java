import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;

	Color[] colors = new Color[] { Color.BLUE, Color.MAGENTA, Color.PINK, Color.RED, Color.YELLOW, Color.GREEN,
			Color.CYAN };

	private Color c = colors[5];

	public Panel() {
		super();
		addMouseListener(this);
		addKeyListener(this);
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocus();
	}

	@Override
	public void updateUI() {
		/*
		 * if(this.r<255){ this.r++; }else if (this.g<255){ this.r= 0; this.g++;
		 * }else if(this.g<255){ this.r=0; this.g=0; this.b++; }else{ this.r=0;
		 * this.g=0; this.b=0; }
		 */
		super.updateUI();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		/*
		 * for(int i = -500;i<500;i++){ g2.drawLine(i+100, (int) Main.a(i),
		 * i+101, (int) Main.a(i+1)); }
		 */
		g2.setColor(c);
		g2.drawRect(0, 0, 50, 50);
		for (double d = -500.0; d < 500.0; d += 0.1) {
			//g2.drawLine((int) d + 1000, (int) Main.f(d, 0.02, 0, 0), (int) d + 1001, (int) Main.f(d + 1, 0.02, 0, 0));
			//g2.drawLine((int) Main.f(d, 0.02, 0, 0), (int) d + 600, (int) Main.f(d + 1, 0.02, 0, 0), (int) d + 601);
			g2.drawLine((int) d + 1000, (int) -Main.f(d, 0.02, 0, 0)+1400, (int) d + 1001, (int) -Main.f(d + 1, 0.02, 0, 0)+1400);
			//g2.drawLine((int) -Main.f(d, 0.02, 0, 0)+1900, (int) d + 600, (int) -Main.f(d + 1, 0.02, 0, 0)+1900, (int) d + 601);
		}
		for (double d = -5000.0; d < 5000.0; d += 0.1) {
			//g2.drawLine((int)d,(int) Main.f(d, 0.5, 0),(int) d+1,(int) Main.f(d+1, 0.5, 0));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
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
		if(e.getKeyCode() == 0){
			System.exit(0);
		}
	}

}
