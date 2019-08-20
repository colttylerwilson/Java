package paint.canvas.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingObject extends JPanel implements ActionListener {
	Timer t = new Timer(5, this);
	private double x = 0, y = 0, VX = 2, VY = 2;
	KeyAdapter listener = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_DOWN:
				t.start();
				break;
			}
		}
	};
	
	public MovingObject(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40);
		g2.fill(circle);
		t.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		x += VX;
		y += VY;
		repaint();
	}
}
