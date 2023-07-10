package labexer9;

import javax.swing.*;
import java.awt.*;

public class Doraemon extends JFrame{
    public Doraemon() {
        this.setTitle("Doraemon");
        this.setVisible(true);
        this.setSize(370,460);
    }
    public void paint(Graphics graphics) {
        
        super.paint(graphics);
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, 370, 450);
        Color blue = new Color(0,100,255);
        graphics.setColor(blue);
        graphics.fillOval(65,60,240,230);
        graphics.fillRect(109, 290, 150, 120);

        int xValues[] = {109,70,63,109};
        int yValues[] = {290, 278, 308, 321};

        graphics.fillPolygon(xValues,yValues,4);

        int xValues2[] = {259,305, 295, 259};
        int yValues2[] = {290, 308, 332, 321};

        graphics.fillPolygon(xValues2,yValues2,4);

        graphics.setColor(Color.white);
        graphics.fillOval(41,271,40,40);
        graphics.fillOval(292, 305, 40, 40);
        graphics.fillOval(73, 402, 20, 20);
        graphics.fillOval(90, 405, 90, 25);
        graphics.fillOval(186, 405, 90, 25);
        graphics.setColor(Color.black);
        graphics.drawOval(41,271,40,40);
        graphics.drawOval(292, 305, 40, 40);
        graphics.drawOval(90, 405, 90, 35);
        graphics.drawOval(186, 405, 90, 35);


        graphics.setColor(Color.white);
        graphics.fillOval(85, 100, 200, 180);
        graphics.fillOval(123, 280, 120, 112);
        graphics.setColor(Color.red);
        graphics.fillRoundRect(103, 275, 166, 16, 15, 15);
        graphics.setColor(new Color(204,204,0));
        graphics.fillOval(169, 278, 30, 30);
        graphics.setColor(Color.black);
        graphics.drawLine(171, 285, 197, 285);
        graphics.drawLine(169,290,200, 290);
        graphics.fillOval(179, 293, 10, 10);
        graphics.drawLine(184, 300, 184, 307);


        graphics.drawArc(148, 290, 70, 70, 0, -180);
        graphics.drawLine(148, 325, 218, 325);
        graphics.setColor(Color.white);
        graphics.fillOval(123,	80, 60, 70);
        graphics.fillOval(183, 80, 60, 70);
        graphics.setColor(Color.black);
        graphics.drawOval(123,80,60,70);
        graphics.drawOval(183,80,60,70);
        graphics.fillOval(160, 108, 20 ,20);
        graphics.fillOval(186, 108, 20, 20);
        graphics.setColor(Color.white);
        graphics.fillOval(167, 114, 6 ,6);
        graphics.fillOval(190, 114, 6, 6);
        graphics.setColor(Color.red);
        graphics.fillOval(169, 158, 27, 27);
        graphics.setColor(Color.black);
        graphics.drawOval(169,158,27,27);
        graphics.setColor(Color.white);
        graphics.fillOval(184, 161, 10, 13);



        graphics.setColor(Color.black);
        graphics.drawArc(90, 60, 190, 190, -45,-90);
        graphics.drawLine(183, 185, 183, 250);
        graphics.drawLine(100,182,148, 189);
        graphics.drawLine(93, 200, 148, 200);
        graphics.drawLine(98, 217, 148, 211);

        graphics.drawLine(219, 189, 268, 182);
        graphics.drawLine(219,200, 272, 200);
        graphics.drawLine(219, 211, 269, 218);

        graphics.setFont(new Font("kai body",Font.PLAIN,24));


    }
    public static void main(String[] args) {
        Doraemon app = new Doraemon();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
