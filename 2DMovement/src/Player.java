import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

public class Player {
	private int x;
	private int y;
	private int speed;
	private int radius;
	private enum Compass {
		NORTH (1), EAST (2), SOUTH (3), WEST(4);
		
		private int dir;
		
		private Compass(int x) {
			dir = x;
		}
		
		public int getDirection() {
			return dir;
		}
	}
	private Compass direction;

	public Player(Game game) {
		radius = 30;
		x = game.getWidth() / 2;
		y = game.getHeight() / 2;
		direction = Compass.NORTH;
		speed = 3;
	}

	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
			direction = Compass.WEST;
			x = x - speed;
		}
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			direction = Compass.EAST;
			x = x + speed;
		}
		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			direction = Compass.NORTH;
			y = y - speed;
		}
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			direction = Compass.SOUTH;
			y = y + speed;
		}
	}

	public void paintComponent(Graphics2D g) {
		// TODO Auto-generated method stub
		Graphics2D gg = (Graphics2D)g.create();
		gg.draw(new Ellipse2D.Double(x,y,radius,radius));
	}
	
	public int getRadius() {
		return radius;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,radius,radius);
	}
}
