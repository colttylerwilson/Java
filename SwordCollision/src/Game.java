import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


@SuppressWarnings("serial")
public class Game extends JPanel {
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	private Player player = new Player(this);
	private Enemy enemy = new Enemy();
	private Sword sword = new Sword(player);

	// Adding key bindings
	private static final String SPACE_KEY_PRESSED = "up key pressed";
	private static final String SPACE_KEY_RELEASED = "up key released";
	private static final int UP_TIMER_DELAY = 50;
	private Timer upTimer;

	public Game() {
		setFocusable(true);
		setPreferredSize(new Dimension(500, 500));
		int condition = WHEN_IN_FOCUSED_WINDOW;
		InputMap inputMap = getInputMap(condition);
		ActionMap actionMap = getActionMap();
		KeyStroke spaceKeyPressed = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false);
		KeyStroke saceKeyReleased = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true);

		inputMap.put(spaceKeyPressed, SPACE_KEY_PRESSED);
		inputMap.put(saceKeyReleased, SPACE_KEY_RELEASED);

		actionMap.put(SPACE_KEY_PRESSED, new UpAction(false));
		actionMap.put(SPACE_KEY_RELEASED, new UpAction(true));

		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent ke) {
				// TODO Auto-generated method stub
				player.keyPressed(ke);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	private class UpAction extends AbstractAction {
		private boolean onKeyRelease;

		public UpAction(boolean onKeyRelease) {
			this.onKeyRelease = onKeyRelease;
		}

		@Override
		public void actionPerformed(ActionEvent evt) {
			if (!onKeyRelease) {
				if (upTimer != null) {
					return;
				}
				System.out.println("key pressed");
				sword.swing(player.getDirection());
				upTimer = new Timer();
			} else {
				System.out.println("Key released");
				if (upTimer != null) {
					upTimer.cancel();
					upTimer = null;
				}
			}
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gg = (Graphics2D) g;
		player.paintComponent(gg);
		sword.paintComponent(gg);
		if (enemy.isVisible()) {
			enemy.paintComponent(gg);
		}
		checkCollision();
	}

	public void checkCollision() {
		Rectangle r1 = player.getBounds();
		Rectangle r2 = enemy.getBounds();
		if (r1.intersects(r2)) {
			enemy.setVisible(false);
		}
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public static void main(String[] args) throws InterruptedException {
		// Create frame with title
		JFrame frame = new JFrame("Sword Collision");
		frame.setSize(500, 500);
		// Set the program to close when exit
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create a new game object
		Game game = new Game();
		// Add the Jpanel to this Jframe
		frame.add(game);
		// Set the frame to visible
		frame.setVisible(true);

		// !Important: run the game
		while (true) {
			game.repaint();
			// Set thred to sleep so game doesnt run all at once?
			// Thread.sleep(10);
		}
	}
}