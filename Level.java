
package lab2.level;

import java.util.Observable;

import lab2.level.Room;

public class Level extends Observable {
	public Room[] rooms;
	// Room[] array = new Room[100];
	Room location = null;
  	public boolean place(Room r, int x, int y)  {
	for(int i = 0; i < rooms.length; i++) { // check x-range
          	if((x > rooms[i].px) && (x < rooms[i].px)) {
          	      return false;
            	}
        	}
       		for(int i = 0; i < rooms.length; i++) { // check y-range
       	     		if((y > rooms[i].py) && (y < rooms[i].py)) {
        	        	return false;
        	  	 }
        	} // all ok, add room
       		r.px = x;
       		r.dx = y;
        	rooms[rooms.length-1] = r;
        	return true;
    	}
	
	public void firstLocation(Room r) {
		// add here 
		location = r;
	}
	
}
