package mini.tennis.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	public static final int DIAMETER = 30;
	private int x = 0;
	private int y = 0;
	private int xa = 1;
	private int ya = 1;
	private Game game;
	
	public Ball(Game game) {
		this.game = game;
	}
	
	public void move() {
		if(x + xa < 0) {
			xa = 1;
		}
		if(x + xa > game.getWidth() - DIAMETER) {
			xa = -1;
		}
		if(y + ya < 0) {
			ya = 1;
		}
		if(y + ya > game.getWidth() - DIAMETER) {
			ya = -1;
			game.gameOver();
		}
		if(collision()) {
			ya = -1;
			y = game.bar.getTopY() - DIAMETER;
		}
		
		x = x + xa;
		y = y + ya;
	}
	
	public void paint(Graphics2D g) {
		g.fillOval(x,y,30,30);
	}
	
	private boolean collision() {
		return game.bar.getBounds().intersects(getBounds());
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y, DIAMETER, DIAMETER);
	}
}
