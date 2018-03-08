package me.xiroc.kitpvp.util;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

import org.bukkit.Location;

import me.xiroc.kitpvp.main.MainPlugin;

public class GameManager {
	
	private ArrayList<MapObject> maps;

	public void addGameObject(Game game, Location signLocation) {
		MainPlugin.games.add(new GameObject(game, signLocation));
	}

	public void removeGame(GameObject gameObject) {
		ListIterator<GameObject> listIterator = MainPlugin.games.listIterator();
		for (GameObject go : MainPlugin.games) {
			if (gameObject == go) {
				listIterator.remove();
				break;
			} else {
				listIterator.next();
			}
		}
	}
	
	public void addMap(MapObject mapOBJ){
		maps.add(mapOBJ);
	}
	
	public MapObject getRandomMap(){
		return maps.get(new Random().nextInt(maps.size()));
	}
	
	public GameObject getGameObjectFromSign(Location signLocation){
		for(GameObject gameOBJ : MainPlugin.games){
			if(gameOBJ.getSignLocation() == signLocation){
				return gameOBJ;
			}
		}
		return null;
	}

}
