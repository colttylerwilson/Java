import java.awt.Graphics2D;

public class Sword {
	private int x;
	private int y;
	private int width;
	private int height;
	Player p;
	public enum Compass {
		NORTH (1), EAST (2), SOUTH (3), WEST(4);
		
		private int dir;
		
		private Compass(int x) {
			dir = x;
		}
		
		public int getDirection() {
			return dir;
		}
	}
	
	public Sword(Player p) {
		this.p = p;
		x = p.getBounds().x + (p.getRadius() / 2);
		y = p.getBounds().y - (p.getRadius());
		width = p.getRadius() / 10;
		height = p.getRadius();
	}
	
	public void swing(Player.Compass compass) {
		System.out.println(compass.getDirection());
		switch(compass.getDirection()) {
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			break;
		}
	}
	
	public void paintComponent(Graphics2D g) {
		Graphics2D gg = (Graphics2D) g.create();
		gg.fillRect(p.getBounds().x + (p.getRadius() / 2), p.getBounds().y - (p.getRadius()), width, height);
	}
}
