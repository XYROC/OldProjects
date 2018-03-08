package de.game.core.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	private State state;

	public static Sprite grass = new Sprite(16, 5, 0, SpriteSheet.tiles);
	public static Sprite magmastone = new Sprite(16, 6, 0, SpriteSheet.tiles);
	public static Sprite voidsprite = new Sprite(16, 3, 0, SpriteSheet.tiles);

	public static Sprite player_r0 = new Sprite(16, 2, 12, SpriteSheet.tiles);
	public static Sprite player_l1 = new Sprite(16, 3, 12, SpriteSheet.tiles);
	public static Sprite player_b2 = new Sprite(16, 2, 13, SpriteSheet.tiles);
	public static Sprite player_f3 = new Sprite(16, 3, 13, SpriteSheet.tiles);

	public static Sprite lv_0 = new Sprite(16, 0, 12, SpriteSheet.tiles);
	public static Sprite l_0 = new Sprite(256, 0, 0, SpriteSheet.lv0);
	public static Sprite wall_0 = new Sprite(16, 7, 0, SpriteSheet.tiles);
	public static Sprite dest_grass_0 = new Sprite(16, 8, 0, SpriteSheet.tiles);
	public static Sprite oak_log = new Sprite(16, 9, 0, SpriteSheet.tiles);
	public static Sprite chest_ground = new Sprite(16, 10, 0, SpriteSheet.tiles);

	public Sprite(int size, int color) {
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.setColor(color);
	}

	public Sprite(int SIZE, int x, int y, SpriteSheet sheet) {
		this.SIZE = SIZE;
		this.pixels = new int[SIZE * SIZE];
		this.sheet = sheet;
		this.x = x * SIZE;
		this.y = y * SIZE;
		load();
	}

	public Sprite(int SIZE, int x, int y, State state) {
		this.SIZE = SIZE;
		this.pixels = new int[SIZE * SIZE];
		this.state = state;
		this.x = x * SIZE;
		this.y = y * SIZE;
		load();
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = this.sheet.pixels[(x + this.x) + (y + this.y) * this.sheet.SIZE];
			}
		}
	}

	public void setColor(int color) {
		for (int i = 0; i < SIZE; i++) {
			pixels[i] = color;
		}
	}
}
