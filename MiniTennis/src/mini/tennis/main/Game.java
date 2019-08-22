package mini.tennis.main;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel {
	private int width;
	private int height;
	Ball ball = new Ball(this);
	Bar bar = new Bar(this);
	
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				bar.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				bar.keyReleased();
			}
			
		});
		setFocusable(true);
	}
	
	private void moveBall() {
		ball.move();
		bar.move();
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this,"Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		bar.paint(g2d);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game(400, 400);
		frame.add(game);
		frame.setSize(game.getWidth(),game.getHeight());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while(true) {
			game.moveBall();
			game.repaint();
			Thread.sleep(10);
		}
	}
}
