package de.game.core.levels;

public class TileEntity {
	
	private int x;
	private int z;
	
	public TileEntity(int x, int z) {
		this.x = x;
		this.z = z;
	}
	
	public int getX() {
		return x;
	}
	
	public int getZ() {
		return z;
	}

}
