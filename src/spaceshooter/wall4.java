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
    public class wall4  {
        private int size;
        private Color color;
        private ImageIcon ii;
        private Image img;
        private int x = 1066;
        private int y = 450;
        private int width =10 ;
        private int height =275 ;
    public wall4(int size) {
        super();
        this.size = size;
        this.color = Color.BLACK;
        this.ii = new ImageIcon(getClass().getResource("/images/wall4.png"));
        this.img = ii.getImage();
        }
    public wall4() {
        this(100);
    }
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ImageIcon getIi() {
        return ii;
    }

    public void setIi(ImageIcon ii) {
        this.ii = ii;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
 
    
   
     public void draw(Graphics g) {
        g.setColor(color);
        //g.fillOval(x, y, size, size);
        g.fillRect( x, y, width, height);

        }
    
}

