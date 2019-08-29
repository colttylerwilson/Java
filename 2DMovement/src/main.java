import javax.swing.JFrame;

public class main {

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("2D Movement");
		Game game = new Game();
		frame.add(game);
		frame.setSize(game.getWidth() + 100, game.getHeight() + 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while(true) {
			game.repaint();
			Thread.sleep(1);
		}
	}
}