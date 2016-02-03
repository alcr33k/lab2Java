package lab2.level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class LevelGUI implements Observer {
	
	private Level lv;
	private Display d;
	private int doorWidth = 20;
	private int levelSize = 1000;
	
	public LevelGUI(Level level, String name) {
		
		this.lv = level;
		
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO: You should change 200 to a value 
		// depending on the size of the level
		d = new Display(lv,levelSize,levelSize);
		
		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0,0);
		frame.setVisible(true);
		lv.addObserver(this);
	}
	
	
	public void update(Observable arg0, Object arg1) {
		d.repaint();
	}
	
	private class Display extends JPanel {
		
		
		public Display(Level fp, int x, int y) {
		
			
			addKeyListener(new Listener());
			
			setBackground(Color.white);
			setPreferredSize(new Dimension(x+20,y+20));
			setFocusable(true);
		}
	
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i = 0; i<lv.numRooms; i++){ // längen på arrayn
				g.setColor(lv.rooms[i].color); // rename to what we change to
				g.fillRect(lv.rooms[i].px, lv.rooms[i].py, lv.rooms[i].dx, lv.rooms[i].dy);
				if(lv.rooms[i] == lv.location){
					g.setColor(Color.red);
					g.drawRect(lv.rooms[i].px, lv.rooms[i].py, lv.rooms[i].dx, lv.rooms[i].dy);
				}
				paintConnections(g, lv.rooms[i]);
			}
			
		}
		private void paintConnections(Graphics g, Room r){
			g.setColor(Color.black);
			if(r.north != null){
				g.fillRect((r.px+((r.dx/2))-doorWidth), r.py, doorWidth*2, doorHeight);
				//g.drawLine((r.px+((r.dx/2))-doorWidth), r.py,(r.px+((r.dx/2))+doorWidth) , r.py);
			}
			if(r.south != null){
				g.fillRect((r.px+((r.dx/2))-doorWidth), r.py+r.dy-doorHeight, doorWidth*2, doorHeight);
				//g.drawLine((r.px+((r.dx/2))-doorWidth), r.py+r.dy, (r.px+((r.dx/2))+doorWidth), r.py+r.dy);
			}
			if(r.east != null){
				g.fillRect(r.dx+r.px-doorHeight, (r.py+((r.dy/2))-doorWidth), doorHeight, doorWidth*2);
				//g.drawLine(r.dx+r.px, (r.py+((r.dy/2))-doorWidth), r.dx+r.px, (r.py+((r.dy/2))+doorWidth));
			}
			if(r.west != null){
				g.fillRect(r.px, (r.py+((r.dy/2))-doorWidth), doorHeight, doorWidth*2);
				//g.drawLine(r.px, (r.py+((r.dy/2))-doorWidth), r.px, (r.py+((r.dy/2))+doorWidth));
			}
		}
		

	 	private class Listener implements KeyListener {

	 		
	 		public void keyPressed(KeyEvent arg0) {
	 		}

	 		public void keyReleased(KeyEvent arg0) {
	 		}

	 		public void keyTyped(KeyEvent event) {
	 			switch (event.getKeyChar()) {
	 		/*	case 'w': lv.moveNorth(); break; // senare grej
	 			case 'a': lv.moveWest(); break;
	 			case 's': lv.moveSouth(); break;
	 			case 'd': lv.moveEast(); break;	*/
	 			}
	 		}
	 	}

	}
	
}
