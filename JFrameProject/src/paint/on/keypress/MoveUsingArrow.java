package paint.on.keypress;

//Step 1: import packages
import java.awt.*;
import java.awt.event.*;

//Step 2: Create subclass of Frame?
public class MoveUsingArrow extends Frame implements KeyListener {
	
	int x=40, y=50;

	// Step 3: Add keyListener and WindowListener in class constr.

	public MoveUsingArrow() {
		addKeyListener(this); //Add KeyListener
		
		addWindowListener(new WindowAdapter() { //Add Window Listener for closing frame window

			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public void paint(Graphics g) {
		g.drawString("x=" + x + ", y=" + y, 40, 50);
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
