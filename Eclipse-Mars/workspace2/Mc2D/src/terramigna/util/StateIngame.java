package terramigna.util;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import terramigna.world.World;

public class StateIngame extends GameState {
	
	World world;
	
	public StateIngame(GameStateManager gameStateManager) {
		super(gameStateManager);
		world = new World("world/world.TEreg", 5, true);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics2D g) {
		world.getChunks()[0][0].render(g);
		world.getChunks()[1][0].render(g);
		world.getChunks()[0][1].render(g);
		world.getChunks()[1][1].render(g);
	}

	@Override
	public void onKeyPressed(KeyEvent keyEvent, int key) {

	}

	@Override
	public void onKeyReleased(KeyEvent keyEvent, int key) {

	}

	@Override
	public void onMousePressed(MouseEvent mouseEvent) {

	}

	@Override
	public void onMouseReleased(MouseEvent mouseEvent) {

	}

}
