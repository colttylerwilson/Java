import java.awt.Graphics2D;

public class Sword {
	private int x;
	private int y;
	private int width;
	private int height;
	Player p;
	
	public Sword(Player p) {
		this.p = p;
		x = p.getBounds().x + (p.getRadius() / 2);
		y = p.getBounds().y - (p.getRadius());
		width = p.getRadius() / 10;
		height = p.getRadius();
	}
	
	public void paintComponent(Graphics2D g) {
		Graphics2D gg = (Graphics2D) g.create();
		gg.fillRect(p.getBounds().x + (p.getRadius() / 2), p.getBounds().y - (p.getRadius()), width, height);
	}
}
