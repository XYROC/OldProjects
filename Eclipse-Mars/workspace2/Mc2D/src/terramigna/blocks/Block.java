package terramigna.blocks;

import java.awt.Graphics2D;

import terramigna.util.GameObject;

public class Block extends GameObject {
	
	private float hardness;
	private Material material;
	
	public Block(float x, float y, int width, int height, Material material) {
		super(x, y, width, height);
		this.hardness = 0;
		this.material = material;
	}
	public void setHardness(float hardness) {
		this.hardness = hardness;
	}
	public float getHardness() {
		return hardness;
	}
	public Material getMaterial() {
		return material;
	}
	public void update(){
		
	}
	public void render(Graphics2D g){
		g.drawImage(material.getImage(), (int)x, (int)y, null);
	}
	

}
