package xiroc;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;

	private Thread thread;
	private JFrame frame;
	public boolean running = false;
	
	public Game(){
		
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop(){
		running = false;
		try{
		thread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(running){
			
		}
	}
}
