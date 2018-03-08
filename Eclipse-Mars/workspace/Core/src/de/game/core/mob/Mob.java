package de.game.core.mob;

import de.game.core.entity.Entity;
import de.game.core.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = -1;
	protected boolean isMoving = false;

	public void move(int xa,int ya) {
		if(xa > 0) dir = 1; // right
		if(xa < 0) dir = 3; // left
		if(ya > 0) dir = 2; // down
		if(ya < 0) dir = 0; // up
		
		if(!collision()){
		x += xa;
		y += ya;
		}
	}

	public void update() {

	}

	public void render() {

	}

	private boolean collision() {
		return false;
	}
}
