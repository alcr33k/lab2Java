package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

	public void run() {
		Room room1 = new Room(1,1,Color.blue);
		Room room2 = new Room(1,1,Color.blue);
		Room room3 = new Room(1,1,Color.blue);
       		Level lvl1 = new Level();
        	lvl1.place(room1, 100, 200);
        	lvl1.place(room2, 200, 100);
        	lvl1.place(room3, 200, 200); // overlaps
		room1.connectNorthTo(room2);
		room2.connectSouthTo(room1);
		room3.connectSouthTo(room2);		
		room2.connectNorthTo(room3);
		
	}

}
