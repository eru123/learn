/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Snowman.java to edit this template
 */
package labexer9;

import javax.swing.*;
import java.awt.*;

public class Snowman extends JFrame{
    Font f1;
    public Snowman() {
        this.setTitle("Doraemon");
        this.setVisible(true);
        this.setSize(500,400);
        f1 = new Font("Mistral",Font.ITALIC,58); 
    }
    public void paint(Graphics g) {
        // background
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 500, 400);
        
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
 		
 		
    }
    public static void main(String[] args) {
        Snowman app = new Snowman();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
