import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;

public class pong implements ActionListener, KeyListener{
  // Properties
  JFrame theframe;
  animationpong thepanel;
  Timer thetimer;
  boolean w = false;
  boolean s = false;
  boolean i = false;
  boolean k = false;
  boolean a = false;
  boolean d = false;
  boolean j = false;
  boolean l = false;
  //int intR = (int)(Math.random()*10 + 5);
  
  // Methods
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource() == thetimer){
      Ellipse2D.Double ball = new Ellipse2D.Double(thepanel.intBX, thepanel.intBY, 50, 50);
      Rectangle2D.Double screen = new Rectangle.Double(0, 0, 800, 800);
      Rectangle2D.Double left = new Rectangle.Double(0, thepanel.intY1, 10, 100);
      Rectangle2D.Double right = new Rectangle.Double(790, thepanel.intY2, 10, 100);
      Rectangle2D.Double up = new Rectangle.Double(thepanel.intX1, 0, 100, 10);
      Rectangle2D.Double down = new Rectangle.Double(thepanel.intX2, 790, 100, 10);
      if(ball.intersects(left)){
        thepanel.intX = (int)(Math.random()*10 + 5);
        thepanel.intY = (int)(Math.random()*10 + -10);
      }if(ball.intersects(right)){
        thepanel.intX = -(int)(Math.random()*10 + 5);
        thepanel.intY = -(int)(Math.random()*10 + -10);
      }if(ball.intersects(up)){
        thepanel.intX =  (int)(Math.random()*10 + -10);
        thepanel.intY =  (int)(Math.random()*10 + 5);
      }if(ball.intersects(down)){
        thepanel.intX = -(int)(Math.random()*10 + -10);
        thepanel.intY = -(int)(Math.random()*10 + 5);
      }if(!screen.contains(ball.getBounds2D())){
        thepanel.intBX = 400;
        thepanel.intBY = 400;
      }
      
      if(s){
        thepanel.intY1 += 10;
      }if(w){
        thepanel.intY1 -= 10; 
      }if(k){
        thepanel.intY2 += 10;
      }if(i){
        thepanel.intY2 -= 10;
      }if(a){
        thepanel.intX1 -= 10;
      }if(d){
        thepanel.intX1 += 10;
      }if(j){
        thepanel.intX2 -= 10; 
      }if(l){
        thepanel.intX2 += 10;
      }
    }
    thepanel.repaint();
  }
  public void keyReleased(KeyEvent evt){
    if(evt.getKeyChar() == 'w'){
      w = false;
    }if(evt.getKeyChar() == 's'){
      s = false;
    }if(evt.getKeyChar() == 'i'){
      i = false;
    }if(evt.getKeyChar() == 'k'){
      k = false;
    }if(evt.getKeyChar() == 'a'){
      a = false;
    }if(evt.getKeyChar() == 'd'){
      d = false;
    }if(evt.getKeyChar() == 'j'){
      j = false;
    }if(evt.getKeyChar() == 'l'){
      l = false;
    }
  }
  public void keyPressed(KeyEvent evt){
    if(evt.getKeyChar() == 'w'){
      w = true;
    }if(evt.getKeyChar() == 's'){
      s = true;
    }if(evt.getKeyChar() == 'i'){
      i = true;
    }if(evt.getKeyChar() == 'k'){
      k = true;
    }if(evt.getKeyChar() == 'a'){
      a = true;
    }if(evt.getKeyChar() == 'd'){
      d = true;
    }if(evt.getKeyChar() == 'j'){
      j = true;
    }if(evt.getKeyChar() == 'l'){
      l = true;
    }
  }
  public void keyTyped(KeyEvent evt){
    
  }
  
  // Constructor
  public pong(){
    thepanel = new animationpong();
    thepanel.setLayout(null);
    thepanel.setPreferredSize(new Dimension(800, 800));
    thepanel.addKeyListener(this);
    
    theframe = new JFrame("4 Player Pong");
    theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theframe.setContentPane(thepanel);
    theframe.pack();
    theframe.setVisible(true);
    theframe.addKeyListener(this);
    
    thetimer = new Timer(1000/60, this);
    thetimer.start();
  }
  // Main Program
  public static void main(String[] args){
    new pong();
  }
}