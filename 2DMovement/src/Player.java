import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player {
	private int x;
	private int y;
	private int speed;
	private int width;
	private int height;
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
		width = 30;
		height = 10;
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
			width = 10;
			height = 30;
		}
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			direction = Compass.EAST;
			x = x + speed;
			width = 10;
			height = 30;
		}
		if (ke.getKeyCode() == KeyEvent.VK_UP) {
			direction = Compass.NORTH;
			y = y - speed;
			width = 30;
			height = 10;
		}
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
			direction = Compass.SOUTH;
			y = y + speed;
			width = 30;
			height = 10;
		}
	}

	public void paintComponent(Graphics2D g) {
		// TODO Auto-generated method stub
		Graphics2D gg = (Graphics2D)g.create();
		gg.fillRect(x - width / 2, y - height / 2, width, height);
	}
	
	private int getRectWidth() {
		if(direction == Compass.NORTH || direction == Compass.SOUTH) {
			return 30;
		}
		else {
			return 10;
		}
	}
	
	private int getRectHeight() {
		if(direction == Compass.NORTH || direction == Compass.SOUTH) {
			return 10;
		}
		else {
			return 30;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}
}
