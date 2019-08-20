package mini.tennis.main;

import java.awt.Graphics2D;

public class Ball {
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
		if(x + xa > game.getWidth() - 30) {
			xa = -1;
		}
		if(y + ya < 0) {
			ya = 1;
		}
		if(y + ya > game.getWidth() - 30) {
			ya = -1;
		}
		
		x = x + xa;
		y = y + ya;
	}
	
	public void paint(Graphics2D g) {
		g.fillOval(x,y,30,30);
	}
}
