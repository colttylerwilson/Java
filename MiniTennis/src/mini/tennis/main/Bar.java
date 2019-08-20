package mini.tennis.main;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Bar {
	private int x;
	private int xa;
	private Game game;
	
	public Bar(Game game) {
		x = 0;
		xa = 0;
		this.game = game;
	}
	
	public void keyReleased() {
		xa = 0;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -2;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = 2;
		}
	}
	
	public void move() {
		if(x + xa > 0 && x + xa < game.getWidth() - 60) {
			x = x + xa;
		}
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(x, 330, 60, 10);
	}
}

	