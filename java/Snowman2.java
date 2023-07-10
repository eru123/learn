import java.awt.*;
import java.applet.*;

public class Snowman extends Applet {
	Font f1;
	public void init() {
		setSize(500,400);
		setBackground(Color.CYAN);
		f1 = new Font("Mistral",Font.ITALIC,58); 
	}
	public void paint(Graphics g) {
		
		// snowman body
		g.setColor(Color.WHITE);
		g.fillOval(150,250,130,130); // ball 1
		g.fillOval(165, 180, 100, 100); // ball 2
		g.fillOval(175, 115, 80, 80); // ball 3
		
		
		// snowman hat
		g.setColor(Color.BLACK);
		g.fillRect(190, 70, 50, 50);
		g.fillOval(175, 115, 80, 15);
		
		// snowman eyes
		g.fillOval(192, 130, 15, 15);
		g.fillOval(222, 130, 15, 15);
		
		// snowman nose
		g.setColor(Color.orange);
		int noseX[] = {207,222,215};
		int noseY[] = {145,145,160};
 		g.fillPolygon(noseX,noseY,3);
 		
 		// snowman smile
 		g.setColor(Color.BLACK);
 		g.drawArc(190, 150, 50, 20, 180, 180);
 		
 		// snowman scarf
 		g.setColor(Color.RED);
 		g.fillRect(175, 175, 80, 20); // horizontal
 		g.fillRect(220, 175, 20, 80);
 		
 		// snowman foots
 		g.setColor(Color.BLACK);
 		g.fillOval(150, 350, 40, 30);
 		g.fillOval(240, 350, 40, 30);
 		
 		// snowman arm
 		g.drawLine(165, 220, 100, 175);
 		g.drawLine(265, 220, 335, 175);
 		
 		// snowman left hand
 		g.drawLine(100, 175, 75, 175);
 		g.drawLine(100, 175, 75, 160);
 		g.drawLine(100, 175, 90, 150);
 		
 		// snowman left hand
 		g.drawLine(335, 175, 360, 175);
 		g.drawLine(335, 175, 360, 160);
 		g.drawLine(335, 175, 345, 150);
 		
 		// left cloud
 		g.setColor(Color.WHITE);
 		g.fillOval(20, 40, 45, 30);
 		g.fillOval(35, 25, 50, 35);
 		g.fillOval(45, 35, 80, 35);
 		
 		// right cloud
 		g.fillOval(320, 20, 80, 40);
 		g.fillOval(360, 5, 75, 40);
 		g.fillOval(370, 20, 100, 40);
 		
 		// left snow flakes
 		g.fillOval(75,80,15,15);
 		g.fillOval(130,100,15,15);
 		g.fillOval(50,230,15,15);
 		g.fillOval(120,220,15,15);
 		g.fillOval(90,285,15,15);
 		g.fillOval(130,280,15,15);
 		
 		// right snow flakes
 		g.fillOval(360,100,15,15);
 		g.fillOval(420,105,15,15);
 		g.fillOval(370,200,15,15);
 		g.fillOval(320,240,15,15);
 		g.fillOval(410,250,15,15);
 		g.fillOval(360,300,15,15);
 		g.fillOval(300,330,15,15);
 		
 		// Snowman
 		g.setFont(f1);
 		g.drawString("Snowman", 310, 395);
	}
}
