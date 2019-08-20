package mini.tennis.main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {
	private int x = 0;
	private int y = 0;
	/**
	 * @param args
	 */
	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(x,y,30,30);
	}
	
	public void moveBall() {
		x++;
		y++;
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Mini Tennis");
		Game g = new Game();
		frame.add(g);
		frame.setSize(300,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while(true) {
			g.moveBall();
			g.repaint();
			Thread.sleep(10);
		}
	}

}
