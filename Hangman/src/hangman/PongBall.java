/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

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

public class PongBall extends Rectangle{
    
    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 2;
    
    /* Constructor for a new Pong ball that also uses the super()
    constructor from the Rectangle class. Starts at position x,y with a set 
    width and height */
    
    public PongBall(int x, int y, int width, int height){
        super(x,y,width,height);
        random = new Random();
        
        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0){
            randomXDirection--;
        }
        setXDirection(randomXDirection*initialSpeed);
        
        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0){
            randomYDirection--;
        }
        setYDirection(randomYDirection*initialSpeed);
    }
    
    public void setXDirection(int randomXDirection){
        xVelocity = randomXDirection;
    }
    
    public void setYDirection(int randomYDirection){
        yVelocity = randomYDirection;
    }
    
    /*Method that actually moves the pong ball, based on the x and y 
    velocities of the ball*/
    public void move () {
        x += xVelocity;
        y += yVelocity;
    }
    
    public void draw (Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y, width, height);
    }
}
