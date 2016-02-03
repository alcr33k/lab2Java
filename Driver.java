package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

	public void run() {
		Room room1 = new Room(200,200,Color.blue);
		Room room2 = new Room(200,200,Color.magenta);
		Room room3 = new Room(200,200,Color.cyan);
		Room room4 = new Room(200,200, Color.yellow);
		Room room5 = new Room(200,200, Color.green);
		Room room6 = new Room(800,800, Color.pink);
		room1.connectSouthTo(room3);
		room3.connectNorthTo(room1);
		room2.connectEastTo(room3);
		room3.connectWestTo(room2);
		room3.connectEastTo(room4);
		room4.connectWestTo(room3);
		room3.connectSouthTo(room5);
		room5.connectNorthTo(room3);
		Level maze = new Level();
		maze.place(room1, 202, 1);
		maze.place(room2, 1, 202);
		maze.place(room3, 202, 202);
		maze.place(room4, 403, 202);
		maze.place(room5, 202, 403);
		//maze.place(room6, 0, 0);
		maze.firstLocation(room1);
		new LevelGUI(maze, "fiskmas");
	}

}
