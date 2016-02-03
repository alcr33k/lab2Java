package lab2.level;

import java.util.Observable;

import lab2.level.Room;

public class Level extends Observable {
	//public Room[] rooms;
	Room[] rooms = new Room[100];
	Room location = null;
	int numRooms = 0;
  	public boolean place(Room r, int x, int y)  {
	for(int i = 0; i < rooms.length; i++) { // check x-range
				if(!(((r.dx + x)<rooms[i].px) || (x > (rooms[i].px+rooms[i].dx)))){
					if(!(((r.dy + y)<rooms[i].py) || (y > (rooms[i].py+rooms[i].dy)))){
						return false;
					}
				}
			}
			// all ok, add room
       		r.px = x;
       		r.dx = y;
        	rooms[numRooms] = r;
        	numRooms++;
        	return true;
  	}
	
	public void firstLocation(Room r) {
		// add here 
		location = r;
	}
	
}
