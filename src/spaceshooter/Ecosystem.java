/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author jword
 */
public class Ecosystem extends JPanel {

    private Timer timer;
    private  net1 net1;
    private  net2 net2;
    private  goalie1 goalie1;
    private  goalie2 goalie2;
    private  fans1 fans1;
    private  wall1 wall1;
    private  wall2 wall2;
    private  wall3 wall3;
    private  wall4 wall4;
    private  wall5 wall5;
    private  wall6 wall6;
    private  wallno1 wallno1;
    private  blackc blackc;
    private  goaliebox1 goaliebox1;
    private  goaliebox2 goaliebox2;
    
    
    
 
    private ArrayList<Creature> creatures;
    private ArrayList<Creature1> creatures1;
    private ArrayList<Creature2> creatures2;
    
        
    public Ecosystem() {
        super();
        setSize(1200, 960);
        timer = new Timer();
        
        creatures1 =new ArrayList<>(10);
        creatures2 =new ArrayList<>(10);
        creatures =new ArrayList<>(1);
        for(int i = 0 ; i < 10;i++ ){
        creatures2.add(new BluePlayer ());
        }
        for(int i = 0 ; i < 10;i++ ){
        creatures1.add(new redplayer ());
        }
        
        creatures.add(new ball ());
        net1 = new net1();
        net2 = new net2();
        goalie1 = new goalie1();
        goalie2 = new goalie2();
        fans1 = new fans1();
        wall1 = new wall1();
        wall2 = new wall2();
        wall3 = new wall3();
        wall4 = new wall4();
        wall5 = new wall5();
        wall6 = new wall6();
        wallno1 = new wallno1();
        blackc = new blackc();
        goaliebox1 = new goaliebox1();
        goaliebox2 = new goaliebox2();
        timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 1000/24);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.GREEN) ;
        net2.draw(g);
        net1.draw(g);
        goalie1.draw(g);
        goalie2.draw(g);
        fans1.draw(g);
        wall1.draw(g);
        wall2.draw(g);
        wall3.draw(g);
        wall4.draw(g);
        wall5.draw(g);
        wall6.draw(g);
        wallno1.draw(g);
        blackc.draw(g);
        goaliebox1.draw(g);
        goaliebox2.draw(g);
     
       // blob.draw(g);
       for (Creature creature : creatures){
           creature.draw(g);
       }
       for (Creature1 creature1 : creatures1){
           creature1.draw(g);
       }
       for (Creature2 creature2 : creatures2){
           creature2.draw(g);
       }
       
    }
    
    private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            
               for (Creature creature : creatures){
           creature.update();
               //wallCollisions(creature);
               characterVsCharacter((ball)creature,wall1);
               characterVsCharacter((ball)creature,wall2);
               characterVsCharacter((ball)creature,wall3);
               characterVsCharacter((ball)creature,wall4);
               characterVsCharacter((ball)creature,wall5);
               characterVsCharacter((ball)creature,wall6);
               characterVsCharacter((ball)creature,net1);
               characterVsCharacter((ball)creature,net2);
       }
               
               for (Creature1 creature1 : creatures1){
           creature1.update();
           if(creature1==null)
               continue;
               //wallCollisions(creature1);
               characterVsCharacter((redplayer)creature1,wall1);
               characterVsCharacter((redplayer)creature1,wall2);
               characterVsCharacter((redplayer)creature1,wall3);
               characterVsCharacter((redplayer)creature1,wall4);
               characterVsCharacter((redplayer)creature1,wall5);
               characterVsCharacter((redplayer)creature1,wall6);
               characterVsCharacter((redplayer)creature1,creature);
       }
               
               for (Creature2 creature2 : creatures2){
           creature2.update();
           if(creature2==null)
               continue;
               //wallCollisions(creature2);
               characterVsCharacter((BluePlayer)creature2,wall1);
               characterVsCharacter((BluePlayer)creature2,wall2);
               characterVsCharacter((BluePlayer)creature2,wall3);
               characterVsCharacter((BluePlayer)creature2,wall4);
               characterVsCharacter((BluePlayer)creature2,wall5);
               characterVsCharacter((BluePlayer)creature2,wall6);
               characterVsCharacter((BluePlayer)creature2,creature);
       }
                    
            repaint();
        }
    }
    private void wallCollisions(Creature c) {
       
        if (c.getX() <= 0 || c.getX() + 30 >= 1050){
            c.setVx(-c.getVx());
            c.move();
        }
        if (c.getY() <= 0 || c.getY() + 30 >= 450){
            c.setVy(-c.getVy());
            c.move();
        }
    }
    private void wallCollisions(Creature1 c) {
       
        if (c.getX() <= 0 || c.getX() + 30 >= 1050){
            c.setVx(-c.getVx());
            c.move();
        }
        if (c.getY() <= 0 || c.getY() + 30 >= 450){
            c.setVy(-c.getVy());
            c.move();
        }
    }
    private void wallCollisions(Creature2 c) {
       
        if (c.getX() <= 0 || c.getX() + 30 >= 1050){
            c.setVx(-c.getVx());
            c.move();
        }
        if (c.getY() <= 0 || c.getY() + 30 >= 450){
            c.setVy(-c.getVy());
            c.move();
        }
    }
    
    
    private void characterVsCharacter(redplayer c1, wall1 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVx(-c1.getVx());
        c1.move();
        }
    }
    private void characterVsCharacter(redplayer c1, wall2 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVx(-c1.getVx());
        c1.move();
        }
    }
    private void characterVsCharacter(redplayer c1, wall3 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVx(-c1.getVx());
        c1.move();
        }
    }
    private void characterVsCharacter(redplayer c1, wall4 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVx(-c1.getVx());
        c1.move();
        }
    }
    private void characterVsCharacter(redplayer c1, wall5 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVy(-c1.getVy());
        c1.move();
        }
    }
    private void characterVsCharacter(redplayer c1, wall6 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVy(-c1.getVy());
        c1.move();
        }
    }
        
        
    private void characterVsCharacter(BluePlayer c1, wall1 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVx(-c1.getVx());
        c1.move();
        }
    }
    private void characterVsCharacter(BluePlayer c1, wall2 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVx(-c1.getVx());
        c1.move();
        }
    }
    private void characterVsCharacter(BluePlayer c1, wall3 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVx(-c1.getVx());
        c1.move();
        }
    }
    private void characterVsCharacter(BluePlayer c1, wall4 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVx(-c1.getVx());
        c1.move();
        }
    }
    private void characterVsCharacter(BluePlayer c1, wall5 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVy(-c1.getVy());
        c1.move();
        }
    }
    private void characterVsCharacter(BluePlayer c1, wall6 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVy(-c1.getVy());
        c1.move();
        }
    }
    
    
    
    private void characterVsCharacter(ball c1, wall1 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVx(-c1.getVx());
        c1.move();
        }
    }
    private void characterVsCharacter(ball c1, wall2 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVx(-c1.getVx());
        c1.move();
        }
    }
    private void characterVsCharacter(ball c1, wall3 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVx(-c1.getVx());
        c1.move();
        }
    }
    private void characterVsCharacter(ball c1, wall4 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVx(-c1.getVx());
        c1.move();
        }
    }
    private void characterVsCharacter(ball c1, wall5 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVy(-c1.getVy());
        c1.move();
        }
    }
    private void characterVsCharacter(ball c1, wall6 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVy(-c1.getVy());
        c1.move();
        }
    }
    
    
    private void characterVsCharacter(ball c1, net1 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVy(-c1.getVy());
        c1.x = 600;
        c1.y = 360;
        }
    }
    private void characterVsCharacter(ball c1, net2 c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVy(-c1.getVy());
        c1.x = 600;
        c1.y = 360;
        }
    }
        
    
    
    private void characterVsCharacter(ball c1, BluePlayer c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVy(-c1.getVy());
        c1.setVx(-c1.getVx());
        c2.setVy(-c2.getVy());
        c2.setVx(-c2.getVx());
        c1.move();
        }
    } 
    private void characterVsCharacter(ball c1, redplayer c2) {
        if (c1.getX() + c1.getWidth() > c2.getX() 
        && c1.getX() < c2.getX() + c2.getWidth() 
        && c1.getY() + c1.getHeight() > c2.getY()
        && c1.getY() < c2.getY() + c2.getHeight() ) {
        c1.setVy(-c1.getVy());
        c1.setVx(-c1.getVx());
        c2.setVy(-c2.getVy());
        c2.setVx(-c2.getVx());
        c1.move();
        }
    }
   

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            
            
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            
            
        if (e.getKeyCode() == KeyEvent.VK_UP)
            
            
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            
        }
            
    }   
    
    
    
    
    
}