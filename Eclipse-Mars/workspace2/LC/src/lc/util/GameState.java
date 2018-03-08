package lc.util;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class GameState {

	protected GameStateManager gsm;
	
	public GameState(GameStateManager gameStateManager) {
		this.gsm = gameStateManager;
	}
	
	public abstract void update();
	public abstract void render(Graphics2D g);
	public abstract void onKeyPressed(KeyEvent keyEvent, int key);
	public abstract void onKeyReleased(KeyEvent keyEvent, int key);
	public abstract void onMousePressed(MouseEvent mouseEvent);
	public abstract void onMouseReleased(MouseEvent mouseEvent);
	
}
