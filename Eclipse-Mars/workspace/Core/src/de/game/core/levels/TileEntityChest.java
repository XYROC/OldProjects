package de.game.core.levels;

public class TileEntityChest extends TileEntity{
	
	private int[][] items;
	private int size;

	public TileEntityChest(int x, int z, int size) {
		super(x, z);
		this.size = size;
		this.items = new int[size][1];
	}
	
	

}
