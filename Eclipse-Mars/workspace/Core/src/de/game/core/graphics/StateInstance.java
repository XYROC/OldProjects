package de.game.core.graphics;

public class StateInstance {
	public int xSize;
	public int ySize;
	private int x,y;
	public int[] pixels;
	private State state;
	
	public StateInstance(int xSize, int ySize,int x,int y,State state){
		this.xSize = xSize;
		this.ySize = ySize;
		this.pixels = new int[xSize*ySize];
		this.state = state;
		this.x = x * xSize;
		this.y = y * ySize;
		load();
	}
	private void load(){
		for(int y = 0;y < ySize;y++){
			for(int x = 0;x < xSize; x++){
				pixels[x+y*xSize] = this.state.pixels[(x+this.x) + (y+this.y)*this.state.xSize];
			}
		}
	}
	public void setColor(int color){
		for(int i = 0;i<xSize;i++){
			pixels[i] = color;
		}
	}

}
