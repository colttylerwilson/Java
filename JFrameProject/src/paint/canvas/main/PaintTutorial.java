package paint.canvas.main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import paint.canvas.main.CloseJFrameAction;
import javax.swing.JFrame;


public class PaintTutorial extends Canvas{
	
	public static void main(String[] args) {
		MovingObject mv = new MovingObject(200, 200);
		//PaintTutorial pt = new PaintTutorial();
		JFrame frame = new CloseJFrameAction();
		frame.add(mv);
	}
}

