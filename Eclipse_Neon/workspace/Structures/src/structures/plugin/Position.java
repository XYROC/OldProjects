package structures.plugin;

import org.bukkit.entity.Player;

public class Position {

	private int x;
	private int y;
	private int z;
	private Player player;
	private int posNumber;

	public Position(Player player, int x, int y, int z, int posNumber) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.player = player;
		this.posNumber = posNumber;
	}

	public Player getPlayer() {
		return player;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int getPosNumber() {
		return posNumber;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}

}
