package paint.canvas.main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class CloseJFrameAction extends JFrame {
	public CloseJFrameAction(){
		setTitle("Painting with Canvas and JFrame");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KeyAdapter listener = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_ESCAPE:
					dispose();
					break;
				case KeyEvent.VK_DOWN:
					//some function
					break;
				}
			}
		};
		
		addKeyListener(listener);
	}
}
