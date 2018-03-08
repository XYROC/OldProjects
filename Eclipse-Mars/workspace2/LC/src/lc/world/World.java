package lc.world;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import lc.Main;
import lc.blocks.Block;
import lc.blocks.Material;

public class World {

	private int blockX;
	private int blockY;
	private String path;
	private int chunkSize;
	private Block[][] blocks;
	private Chunk[][] chunks;

	public World(String path, int chunkSize, boolean generated) {
		this.path = path;
		this.chunkSize = chunkSize;
		if (!generated) {
			load();
		} else {
			generate(10, 10);
		}
		setChunks();
	}

	public void render(Graphics2D g) {
		/*
		 * Old Method for (int row = 0; row < blockY; row++) { for (int col = 0;
		 * col < blockX; col++) { blocks[row][col].render(g); } }
		 */
		for (int row = 0; row < chunks.length; row++) {
			for (int col = 0; col < chunks[0].length; col++) {
				chunks[row][col].render(g);
			}
		}
	}

	public void generate(int xSize, int ySize) {
		blockX = xSize;
		blockY = ySize;
		blocks = new Block[ySize][xSize];
		for (int row = 0; row < ySize; row++) {
			for (int col = 0; col < xSize; col++) {
				if (row < 6) {
					blocks[row][col] = new Block(col * Main.BLOCKSIZE, row * Main.BLOCKSIZE,
							Main.BLOCKSIZE, Main.BLOCKSIZE, Material.AIR);
					// System.out.println("[World/Generate] Generated AIR at " +
					// row + " | " + col);
				} else if (row == 6) {
					if (blocks[row][col] == null) {
						int b = new Random().nextInt(3);
						switch (b) {
						case 1:
							blocks[row][col] = new Block(col * Main.BLOCKSIZE, row * Main.BLOCKSIZE,
									Main.BLOCKSIZE, Main.BLOCKSIZE, Material.GRASS);
							// System.out.println("[World/Generate] Generated
							// GRASS at " + row + " | " + col);
							break;
						default:
							blocks[row][col] = new Block(col * Main.BLOCKSIZE, row * Main.BLOCKSIZE,
									Main.BLOCKSIZE, Main.BLOCKSIZE, Material.AIR);
							// System.out.println("[World/Generate] Generated
							// AIR at " + row + " | " + col);
							break;
						}
					}
				} else if (row >= 7 && row <= 12) {
					if (blocks[row - 1][col].getMaterial() == Material.GRASS
							|| blocks[row - 2][col].getMaterial() == Material.GRASS
							|| blocks[row - 3][col].getMaterial() == Material.GRASS
							|| blocks[row - 4][col].getMaterial() == Material.GRASS
							|| blocks[row - 5][col].getMaterial() == Material.GRASS
							|| blocks[row - 6][col].getMaterial() == Material.GRASS) {
						blocks[row][col] = new Block(col * Main.BLOCKSIZE, row * Main.BLOCKSIZE,
								Main.BLOCKSIZE, Main.BLOCKSIZE, Material.DIRT);
						// System.out.println("[World/Generate] Generated DIRT
						// at " + row + " | " + col);
					} else {
						blocks[row][col] = new Block(col * Main.BLOCKSIZE, row * Main.BLOCKSIZE,
								Main.BLOCKSIZE, Main.BLOCKSIZE, Material.GRASS);
						// System.out.println("[World/Generate] Generated GRASS
						// at " + row + " | " + col);
					}
				} else if (row == 13) {
					if (blocks[row - 1][col].getMaterial() == Material.GRASS) {
						blocks[row][col] = new Block(col * Main.BLOCKSIZE, row * Main.BLOCKSIZE,
								Main.BLOCKSIZE, Main.BLOCKSIZE, Material.DIRT);
						// System.out.println("[World/Generate] Generated DIRT
						// at " + row + " | " + col);
					} else {
						blocks[row][col] = new Block(col * Main.BLOCKSIZE, row * Main.BLOCKSIZE,
								Main.BLOCKSIZE, Main.BLOCKSIZE, Material.STONE);
						// System.out.println("[World/Generate] Generated STONE
						// at " + row + " | " + col);
					}
				} else if (row > 13) {
					blocks[row][col] = new Block(col * Main.BLOCKSIZE, row * Main.BLOCKSIZE,
							Main.BLOCKSIZE, Main.BLOCKSIZE, Material.STONE);
					// System.out.println("[World/Generate] Generated STONE at "
					// + row + " | " + col);
				} else {
					blocks[row][col] = new Block(col * Main.BLOCKSIZE, row * Main.BLOCKSIZE,
							Main.BLOCKSIZE, Main.BLOCKSIZE, Material.STONE);
					// System.out.println("[World/Generate] Generated STONE at "
					// + row + " | " + col);
				}
			}
		}
	}

	public void load() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
			blockX = Integer.parseInt(reader.readLine());
			blockY = Integer.parseInt(reader.readLine());
			blocks = new Block[blockY][blockX];
			for (int row = 0; row < blockY; row++) {
				String line = reader.readLine();
				// TODO Array
				String[] tokens = line.split(" ");
				for (int col = 0; col < blockX; col++) {
					int id = Integer.parseInt(tokens[col]);
					blocks[row][col] = new Block(col * Main.BLOCKSIZE, row * Main.BLOCKSIZE,
							Main.BLOCKSIZE, Main.BLOCKSIZE, Material.values()[id]);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setChunks() {
		int chunksX = blockX / chunkSize;
		int chunksY = blockY / chunkSize;
		chunks = new Chunk[chunksY][chunksX];
		for (int row = 0; row < chunksY; row++) {
			for (int col = 0; col < chunksX; col++) {
				chunks[row][col] = new Chunk(blocks, col * chunkSize, row * chunkSize, chunkSize);
			}
		}
	}

	public Chunk[][] getChunks() {
		return chunks;
	}

	public int getRowTile(int y){
		return y / Main.BLOCKSIZE;
	}
	
	public int getColumnTile(int x){
		return x / Main.BLOCKSIZE;
	}
	public Block[][] getBlocks(){
		return blocks;
	}
	public Block getBlock(int x, int y){
		return blocks[getRowTile(y)][getColumnTile(x)];
	}

}
