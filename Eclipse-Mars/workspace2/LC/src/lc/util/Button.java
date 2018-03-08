package lc.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Button {

	private int x;
	private int y;
	private int xSize;
	private int ySize;
	private int id;
	private String text;

	public Button(String text, int x, int y, int xSize, int ySize, int id) {
		this.id = id;
		this.text = text;
		this.x = x;
		this.y = y;
		this.xSize = xSize;
		this.ySize = ySize;
	}
	
	public void render(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.CYAN);
		g2.drawRect(x, y, xSize, ySize);
	}
	
	public int getID() {
		return id;
	}
	
	public String getText() {
		return text;
	}

	public int getXPos() {
		return x;
	}

	public int getYPos() {
		return y;
	}

	public int getXSize() {
		return xSize;
	}

	public int getYSize() {
		return ySize;
	}

}
