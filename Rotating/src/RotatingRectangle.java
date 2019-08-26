import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class RotatingRectangle {
	private int x;
	private int y;
	private static final int WIDTH = 30;
	private static final int HEIGHT = 20;
	private Game game;
	private double ro;
	private int accel;
	
	public RotatingRectangle(Game game) {
		x = game.getWidth() / 2;
		y = game.getHeight() / 2;
		this.game = game;
		ro = 0;
		accel = 0;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			ro = ro - accel;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ro = ro + accel;
		}
		if(e.getKeyCode() == KeyEvent.VK_Q) {
			accel = accel + 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			accel = accel - 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			y = y - accel;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			y = y + accel;
		}
	}
	
	public void paintComponent(Graphics2D g) {
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.rotate(Math.toRadians(ro), x + (WIDTH / 2), y + (HEIGHT / 2));
		g2d.fillRect(x, y, WIDTH, HEIGHT);
		g2d.dispose();
	}
}