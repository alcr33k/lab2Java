package lab2.level;

import java.util.Observable;

import lab2.level.Room;

public class Level extends Observable {
	//public Room[] rooms;
	Room[] rooms = new Room[100];
	Room location = null;
	int numRooms = 0;
  	public boolean place(Room r, int x, int y)  {
	for(int i = 0; i < numRooms; i++) { // check x-range
				if(!(((r.dx + x)<rooms[i].px) || (x > (rooms[i].px+rooms[i].dx)))){
					if(!(((r.dy + y)<rooms[i].py) || (y > (rooms[i].py+rooms[i].dy)))){
						return false;
					}
				}
			}
			// all ok, add room
       		r.px = x;
       		r.py = y;
        	rooms[numRooms] = r;
        	numRooms++;
        	return true;
  	}
	
	public void firstLocation(Room r) {
		// add here 
		location = r;
	}
	
}
	void moveEast(){
		if(location.east != null){
			location = location.east;
			changedPlace();
		}
	}
	void moveWest(){
		if(location.west != null){
			location = location.west;
			changedPlace();
		}
	}
	void moveNorth(){
		if(location.north != null){
			location = location.north;
			changedPlace();
		}
	}
	void moveSouth(){
		if(location.south != null){
			location = location.south;
			changedPlace();
		}
	}
	
	private void changedPlace(){
		setChanged();
		notifyObservers();
	}
 
}
