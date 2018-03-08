package lc.world;

import java.awt.Graphics2D;

import lc.blocks.Block;

public class Chunk {
	
	private int chunkSize;
	private Block[][] blocks;
	
	public Chunk(Block[][] world, int startX, int startY, int chunkSize) {
		this.chunkSize = chunkSize;
		blocks = new Block[chunkSize][chunkSize];
		
		for(int row = 0;row < chunkSize;row++){
			for(int col = 0;col<chunkSize;col++){
				blocks[row][col] = world[startY+row][startX+col];
			}
		}
	}
	public void update(){
		for(int row = 0;row < chunkSize;row++){
			for(int col = 0;col<chunkSize;col++){
				blocks[row][col].update();
			}
		}
	}
	public void render(Graphics2D g){
		for(int row = 0;row < chunkSize;row++){
			for(int col = 0;col<chunkSize;col++){
				blocks[row][col].render(g);
			}
		}
	}

}
