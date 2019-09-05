import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	private Player player = new Player(this);
	private Enemy enemy = new Enemy();
	private Sword sword = new Sword(player);
	
	
	public Game() {
		setFocusable(true);
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent ke) {
				// TODO Auto-generated method stub
				player.keyPressed(ke);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gg = (Graphics2D) g;
		player.paintComponent(gg);
		sword.paintComponent(gg);
		if(enemy.isVisible()) {
			enemy.paintComponent(gg);
		}
		checkCollision();
	}
	
	public void checkCollision() {
		Rectangle r1 = player.getBounds();
		Rectangle r2 = enemy.getBounds();
		if(r1.intersects(r2)) {
			enemy.setVisible(false);
		}
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
}