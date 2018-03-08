package terramigna.util;

import java.awt.Rectangle;

public abstract class GameObject {
	
	protected float x;
	protected float y;
	protected int width;
	protected int height;
	
	public GameObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public void setLocation(float x, float y){
		this.x = x;
		this.y = y;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public void setX(float x) {
		this.x = x;
	}
	public void setY(float y) {
		this.y = y;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Rectangle getBoundingBox(){
		Rectangle rectangle = new Rectangle();
		rectangle.setBounds((int)x, (int)y, width, height);
		return rectangle;
	}

}
