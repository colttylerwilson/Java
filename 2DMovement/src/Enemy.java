import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Enemy {
	private int x;
	private int y;
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;
	private boolean visible = true;
	
	public Enemy() {
		x = 20;
		y = 20;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
	
	public void paintComponent(Graphics2D g) {
		Graphics2D gg = (Graphics2D) g;
		gg.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
