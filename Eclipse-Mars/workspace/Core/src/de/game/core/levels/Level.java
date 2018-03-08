package de.game.core.levels;

import java.util.Random;

import de.game.core.graphics.Screen;
import de.game.core.graphics.State;
import de.game.core.levels.tile.Tile;

public class Level {

	public static int width, height;
	protected int[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		this.tiles = new int[width * height];
		generateRandomLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}

	public void loadLevel(String path) {

	}

	public void generateRandomLevel() {

	}

	public void update() {

	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				this.getTile(x, y).render(x, y, screen);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (y < 0 || x < 0 || x >= width || y >= height) {
			return Tile.voidTile;
		}
		if (tiles[x + y * width] == 0) {
			return Tile.grass;
		} else if (tiles[x + y * width] == 1) {
			return Tile.grass;
		} else if (tiles[x + y * width] == 2) {
			return Tile.grass;
		} else if (tiles[x + y * width] == 3) {
			return Tile.magmastone;
		} else if (tiles[x + y * width] == 4) {
			return Tile.magmastone;
		} else if (tiles[x + y * width] == 5) {
			return Tile.wall_0;
		} else if (tiles[x + y * width] == 6) {
			return Tile.oak_log;
		} else if (tiles[x + y * width] == 8) {
			return Tile.magmastone;
		} else if (tiles[x + y * width] == 9) {
			return Tile.magmastone;
		} else {
			return Tile.grass;
		}

	}
}
