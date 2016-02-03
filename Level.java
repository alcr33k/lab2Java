
package lab2.level;

import java.util.Observable;


public class Level extends Observable {
	public static int[] minX;
    	public static int[] maxX;
    	public static int[] minY;
    	public static int[] maxY;
   
  	public boolean place(Room r, int x, int y)  {
	for(int i = 0; i < minX.length; i++) { // check x-range
          	if((x > minX[i]) && (x < maxX[i])) {
          	      return false;
            	}
        	}
       		for(int i = 0; i < minY.length; i++) { // check y-range
       	     		if((y > minY[i]) && (y < maxY[i])) {
        	        	return false;
        	  	 }
        	} // all ok, add room
        	minX[minX.length-1] = x;
        	minY[minY.length-1] = y;
        	maxY[minY.length-1] = y + Room.y;
        	maxX[minX.length-1] = x + Room.x;   
        	return true;
    	}
	
	public void firstLocation(Room r) {
			
	}
	
}
