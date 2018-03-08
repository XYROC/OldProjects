package lc.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

import lc.util.GameStateManager;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener{
	private static final long serialVersionUID = 1L;
	
	private Timer timer;
	private GameStateManager gameStateManagerIn;
	private BufferedImage img;
	
	public GamePanel() {
		super();
		addMouseListener(this);
		addKeyListener(this);
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocus();
		
		img = new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB);
		gameStateManagerIn = new GameStateManager(GameStateManager.INGAME);
		timer = new Timer(60, this);
		timer.start();
	}
	
	private void update(){
		gameStateManagerIn.update();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) img.getGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		gameStateManagerIn.render(g2);
		g.drawImage(img.getScaledInstance(560, 560, Image.SCALE_DEFAULT), 0, 0, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
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
		gameStateManagerIn.onMousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		gameStateManagerIn.onMouseReleased(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gameStateManagerIn.onKeyPressed(e, e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gameStateManagerIn.onKeyReleased(e, e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
