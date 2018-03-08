package de.game.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import de.game.core.graphics.Screen;
import de.game.core.graphics.State;
import de.game.core.input.Listener;
import de.game.core.levels.Level;
import de.game.core.levels.RandomLevel;
import de.game.core.mob.Player;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static int transparent_color = 0xff00FF24;

	public static int width = 250;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static boolean gui;

	public static String title = "Core";
	public static String version = "0.1";

	private Thread thread;
	private JFrame frame;
	private Listener key;
	public static Level level;
	private boolean running = false;

	private JProgressBar loading;

	private Player player;

	public int loadingprogress = 0;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	private Screen screen;

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		gui = false;
		screen = new Screen(width, height);
		frame = new JFrame();
		loading = new JProgressBar();
		key = new Listener();
		level = new RandomLevel(256, 256);
		player = new Player(key);
		addKeyListener(key);
		player.x = 3200;
		player.y = 3200;

	}

	public synchronized void start() {

		running = true;
		thread = new Thread(this, "Display");
		thread.start();

	}

	public synchronized void stop() {

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				SimpleDateFormat datenow = new SimpleDateFormat("dd:MM:yyy hh:mm:ss");
				String datestring = datenow.format(new Date());
				System.out.println(
						"[" + datestring + "] " + "[CORE]" + "[CONSOLE]" + updates + " ups, " + frames + " fps");
				frame.setTitle(title + " " + version + " |" + frames + " FPS");
				frames = 0;
				updates = 0;
			}

		}
		stop();

	}

	public void update() {
		key.update();
		player.update();

	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		player.setHealth(24);

		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		int xRight = player.x + screen.width / 2 - 16;
		int yRight = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		screen.renderGState(player.x - (player.getHealth() / 6), player.y - 6, player.getHealth(), State.graphics);
		// screen.renderState(xRight, yRight, Sprite.lv_0);
		// screen.render(x,y);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];

		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Vardana", 0, 20));
		g.drawString("[X: " + player.x + " | Y: " + player.y + "]", 10, 35);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(true);
		game.frame.setTitle(title + " " + version);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.loading.setLayout(null);
		game.loading.setVisible(true);
		game.loading.setBounds(100, 100, 50, 100);
		game.loading.setForeground(Color.RED);
		game.loading.setBackground(Color.WHITE);

		game.start();
	}
}
