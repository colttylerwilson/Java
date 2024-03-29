package mini.tennis.events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyboardExample extends JPanel{
	
	public KeyboardExample() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Key pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("Key released: " + KeyEvent.getKeyText(e.getKeyCode()));
				
			}
		});
		setFocusable(true);
	}
	
	public static void main(String [] args) {
		JFrame frame = new JFrame("Mini Tennis");
		KeyboardExample ke = new KeyboardExample();
		frame.add(ke);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
