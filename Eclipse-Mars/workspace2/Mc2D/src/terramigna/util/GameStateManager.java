package terramigna.util;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameStateManager {
	
	public static final int INGAME = 0;
	
	private int state;
	private GameState[] states;
		
	public GameStateManager(int state) {
		states = new GameState[1];
		states[0] = new StateIngame(this);
	}
	
	public  void update(){
		states[state].update();
	}
	public  void render(Graphics2D g){
		states[state].render(g);
	}
	public  void onKeyPressed(KeyEvent keyEvent, int key){
		states[state].onKeyPressed(keyEvent, key);
	}
	public  void onKeyReleased(KeyEvent keyEvent, int key){
		states[state].onKeyReleased(keyEvent, key);
	}
	public  void onMousePressed(MouseEvent mouseEvent){
		states[state].onMousePressed(mouseEvent);
	}
	public  void onMouseReleased(MouseEvent mouseEvent){
		states[state].onMouseReleased(mouseEvent);
	}

}
