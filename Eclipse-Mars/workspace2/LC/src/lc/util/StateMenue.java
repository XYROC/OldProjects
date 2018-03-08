package lc.util;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import lc.Main;

public class StateMenue extends GameState {

	private ArrayList<Button> buttons;

	private Main main;

	public StateMenue(GameStateManager gameStateManager) {
		super(gameStateManager);
		buttons = new ArrayList<Button>();
		main = Main.main;
		buttons.add(new Button("Grafikoptionen", main.getScreenXSize() / 4 + 70, main.getScreenYSize() / 4 * 2, 100, 20,
				1));
		buttons.add(
				new Button("Neuer Level", main.getScreenXSize() / 4 - 50, main.getScreenYSize() / 4 * 3, 100, 20, 0));
		buttons.add(new Button("Level laden", main.getScreenXSize() / 4 - 50, main.getScreenYSize() / 4 * 3 - 40, 100,
				20, 0));
	}

	public ArrayList<Button> getButtons() {
		return buttons;
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics2D g) {
		for(Button b : buttons){
			b.render(g);
		}
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
