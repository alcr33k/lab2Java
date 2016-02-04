
package lab2.level;

import java.util.Observable;
import java.util.Vector;

import lab2.Driver;


public class Level extends Observable {
	Vector<Room> vector = new Vector<Room>();
	//Room[] vector = new Room[100];
	int numRooms = 0;
	Room location = null;
	
	public Level(){
	}
	/*
	 * Place room in an vector, check to see if the newly placed room is going to fit over another room on the map.
	 */
	public boolean place(Room r, int x, int y) {
			for(int i = 0; i<numRooms; i++){
				if(!(((r.dx + x)<vector.get(i).px) || (x > (vector.get(i).px+vector.get(i).dx)))){
					if(!(((r.dy + y)<vector.get(i).py) || (y > (vector.get(i).py+vector.get(i).dy)))){
						return false;
					}
				}
			}
			r.px = x;
			r.py = y;
			vector.add(r);
			numRooms++;
			return true;
	}
	/*
	 * Set first location.
	 */
	public void firstLocation(Room r) {
			location = r;
	}
	/*
	 * move to another room if possible, also set changed and notify observers in changedPlace.
	 */
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
