/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jword
 */
    public class wallno1  {
        private int size;
        private Color color;
        private ImageIcon ii;
        private Image img;
    public wallno1(int size) {
        super();
        this.size = size;
        this.color = Color.BLACK;
        this.ii = new ImageIcon(getClass().getResource("/images/wall1.png"));
        this.img = ii.getImage();
        }

    public wallno1() {
        this(100);
    }
    
 
    
   
    public void draw(Graphics g) {
        //g.setColor(color);
        //g.fillOval(x, y, size, size);
        g.drawImage(img, 540,100, size, 645, null);

        }
    
}
