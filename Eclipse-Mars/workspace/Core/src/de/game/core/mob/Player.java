package de.game.core.mob;

import de.game.core.graphics.Screen;
import de.game.core.graphics.Sprite;
import de.game.core.input.Listener;

public class Player extends Mob {
	
	private Listener input;
	private Sprite sprite;
	private int health;

	public Player(Listener input) {
		this.input = input;
		this.health = 24;
	}

	public Player(int x, int y, Listener input) {
		this.x = x;
		this.y = y;
		this.input = input;
		this.health = 24;
	}
	public void update(){
		int xa = 0, ya = 0;
		if(input.up && y-1 >= 0) ya--;
		if(input.down) ya++;
		if(input.left && x-1 >= 0) xa--;
		if(input.right) xa++;
		
		if(xa != 0 || ya != 0) move(xa, ya);
	}
	public void render(Screen screen){
		sprite = Sprite.player_b2;
		if(dir == 0) sprite = Sprite.player_f3;
		if(dir == 2) sprite = Sprite.player_b2;
		if(dir == 3) sprite = Sprite.player_l1;
		if(dir == 1) sprite = Sprite.player_r0;
		screen.renderPlayer(x, y, sprite);
	}
	public Listener getInput() {
		return input;
	}
	public int getHealth() {
		return health;
	}
	public Sprite getSprite() {
		return sprite;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}
