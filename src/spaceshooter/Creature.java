/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Graphics;

/**
 *
 * @author jword
 */
public abstract class Creature {
    
    //Fields
    protected int x;
    protected int y;
    protected int vx;
    protected int vy;
    private int height;
    private int width;
    //(int) (Math.random()* 800) ;
   // (int) (Math.random()* 660)+ 100;
    //Constructor
    public Creature(int x, int y) {
        //this.x = 500;
        //this.y = 320;
        this.x =(int) (Math.random()* 600) + 100;
        this.y = (int) (Math.random()* 560)+ 100;
        this.vx = 8;
        this.vy = 8;
    }

    public Creature() {
        this(100,100);
    }
    
    public abstract void draw(Graphics g);
    
    public void update() {
        move();
    }
    
    public void move() {
        x += vx;
        y += vy;
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

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

   

}
