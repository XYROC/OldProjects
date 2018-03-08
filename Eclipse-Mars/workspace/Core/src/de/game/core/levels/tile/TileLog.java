package de.game.core.levels.tile;

import de.game.core.graphics.Screen;
import de.game.core.graphics.Sprite;

public class TileLog extends Tile{

	public TileLog(Sprite sprite) {
		super(sprite);
	}
	public void render(int x,int y,Screen screen){
		screen.renderTile(x<<4, y<<4, this);
	}
	@Override
	public boolean isSolid() {
		return true;
	}

}
