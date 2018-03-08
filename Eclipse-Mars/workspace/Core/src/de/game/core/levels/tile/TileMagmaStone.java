package de.game.core.levels.tile;

import de.game.core.graphics.Screen;
import de.game.core.graphics.Sprite;

public class TileMagmaStone extends Tile{

	public TileMagmaStone(Sprite sprite) {
		super(sprite);
	}
	public void render(int x,int y,Screen screen){
		screen.renderTile(x<<4, y<<4, this);
	}


}
