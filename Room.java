
package lab2.level;

import java.awt.Color;

import lab2.Driver;


public class Room {
	int dx, dy, px, py;
	Color color;
	Room north, west, east, south = null;
	
	public Room(int dx, int dy, Color color) {
		this.dx = dx;
		this.dy = dy;
		this.color = color;
	}
/*
 * connect a room to another room in a direction.
 */
	public void connectNorthTo(Room r) {
		this.north = r;
	}
	public void connectEastTo(Room r) {
		this.east = r;
	}
	public void connectSouthTo(Room r) {
		this.south = r;
	}
	public void connectWestTo(Room r) {
		this.west = r;
	}
}
