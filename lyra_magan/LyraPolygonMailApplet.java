import java.awt.*;
import java.applet.*;

public class LyraPolygonMailApplet extends Applet {
	public void init() {
		setSize(200,120);
		setBackground(Color.GRAY);
	}
	public void paint(Graphics g) {
		
		// ORANGE
		g.setColor(Color.ORANGE);
		int x[] = {0,100,200,100,0};
		int y[] = {40,0,40,80,40};
		g.fillPolygon(x, y, 4);
		
		// WHITE BOX
		g.setColor(Color.WHITE);
		g.fillRoundRect(30,15,140,80,10,10);
		
		// LEFT YELLOW
		g.setColor(Color.YELLOW);
		int x2[] = {0,100,0,0};
		int y2[] = {40,80,120,40};
		g.fillPolygon(x2, y2, 3);
		
		// RIGHT YELLOW
		g.setColor(Color.YELLOW);
		int x3[] = {100,200,200,100};
		int y3[] = {80,40,120,80};
		int xy3 = 3;
		g.fillPolygon(x3, y3, xy3);
		
		// BOTTOM LIGHT YELLOW
		g.setColor(Color.getHSBColor(100,100,100));
		int x4[] = {0,100,200,0};
		int y4[] = {120,80,120,120};
		int xy4 = 3;
		g.fillPolygon(x4, y4, xy4);
		
		// MAGENTA CIRCLE
		g.setColor(Color.magenta);
		g.fillOval(40, 20, 40, 40);
		
		// RECTANGLES
		g.setColor(Color.cyan);
		g.fillRect(110,25,40,10);
		
		g.setColor(Color.black);
		g.fillRect(110,40,40,5);
		g.fillRect(110,50,40,5);
	}
	
}
