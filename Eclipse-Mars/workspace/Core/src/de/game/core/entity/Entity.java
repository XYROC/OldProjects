package de.game.core.entity;

import java.util.Random;

import de.game.core.graphics.Screen;
import de.game.core.levels.Level;

public abstract class Entity {
	
	public int x;
	public int y;
	
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update(){
		
	}
	public void render(Screen screen){
		
	}
	public void remove(){
		removed = true;
	}
	public boolean isRemoved(){
		return this.removed;
	}
	
}
