package de.game.core.levels.tile;

import de.game.core.graphics.Screen;
import de.game.core.graphics.Sprite;

public class Tile {

	public int x,y;
	public Sprite sprite;
	
	public static Tile grass = new TileGrass(Sprite.grass);
	public static Tile magmastone = new  TileMagmaStone(Sprite.magmastone);
	public static Tile voidTile = new TileVoid(Sprite.voidsprite);
	public static Tile wall_0 = new TileWall0(Sprite.wall_0);
	public static Tile dest_grass_0 = new TileDestroyGrass0(Sprite.dest_grass_0);
	public static Tile oak_log = new TileDestroyGrass0(Sprite.oak_log);
	public static Tile chest_ground = new TileDestroyGrass0(Sprite.chest_ground);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
		
	}
	public void render(int x,int y,Screen screen){
		
	}
	public boolean isSolid(){
		return false;
	}
}
