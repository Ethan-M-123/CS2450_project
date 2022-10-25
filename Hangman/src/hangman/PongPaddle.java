/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/***************************************************************  
*  file: ColorPickerGame.java
*  author: Shane, Simon, Dixon, Ethan, Marvin
*  class: CS 2450.01  
*  
*  assignment: Project V1.3 
*  date last modified: 10/24/2022
*  
*  purpose: ,
*            
*           . 
*  
****************************************************************/

public class PongPaddle extends Rectangle{
    
    int id;
    int yVelocity;
    int speed = 10;
    
    //PongPaddle constructor uses inherited constructor from class Rectangle
    public PongPaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id = id;
    }
    
    //moves a paddle based on which key is pressed
    public void keyPressed(KeyEvent e){
        switch(id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }
    
    //Makes a paddle stop moving once a key is released
    public void keyReleased(KeyEvent e){
        switch(id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(0);
                    move();
                }
                break;
        }
    }
    
    public void setYDirection(int yDirection){
        yVelocity = yDirection;
    }
    
    //moves the paddles based on yVelocity
    public void move() {
        y = y + yVelocity;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,y,width,height);
    }
}
