package de.game.core.graphics;

import java.util.Random;

import de.game.core.Game;
import de.game.core.levels.tile.Tile;
import de.game.core.mob.Player;

public class Screen {

	public int width;
	public int height;
	public int[] pixels;
	public int xOffset;
	public int yOffset;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
	private Random random = new Random();
	
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i  = 0; i < MAP_SIZE*MAP_SIZE;i++){
			tiles[i] = random.nextInt(0xffffff);
			
		}
	}
	public void clear(){
		for(int i = 0; i < pixels.length;i++){
			pixels[i] = 0;
		}
		
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0;y < 16;y++){
			int ya = y + yp;
			for(int x = 0;x<16;x++){
				int xa = x + xp;
				if (xa < -16 || xa >= width || ya < -16 || ya >= height) break;
				if(xa < 0) xa = 0;
				if(ya < 0) ya = 0;
				int color = sprite.pixels[x+y*16];
				if(color != Game.transparent_color) pixels[xa+ya*width] = color;	
			}
		}
	}
	public void renderState(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0;y < 16;y++){
			int ya = y + yp;
			for(int x = 0;x<16;x++){
				int xa = x + xp;
				if (xa < -16 || xa >= width || ya < -16 || ya >= height) break;
				if(xa < 0) xa = 0;
				if(ya < 0) ya = 0;
				int color = sprite.pixels[x+y*16];
				if(color != Game.transparent_color) pixels[xa+ya*width] = color;	
			}
		}
	}
	public void renderTile(int xp,int yp, Tile tile){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0;y < tile.sprite.SIZE;y++){
			int ya = y + yp;
			for(int x = 0;x<tile.sprite.SIZE;x++){
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < -tile.sprite.SIZE || ya >= height) break;
				if(xa < 0) xa = 0;
				if(ya < 0) ya = 0;
				pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
				
			}
		}
	}
	public void renderGState(int xp, int yp, int health, State state){
		if(health > 24) health = 24;
		if(health < 1) health = 1;
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0;y < 256;y++){
			int ya = y + yp;
			for(int x = 0;x<health;x++){
				int xa = x + xp;
				if (xa < -24 || xa >= width || ya < -256 || ya >= height) break;
				if(xa < 0) xa = 0;
				if(ya < 0) ya = 0;
				int color = state.pixels[x+y*256];
				if(color != Game.transparent_color) pixels[xa+ya*width] = color;	
			}
		}
	}
	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
}
