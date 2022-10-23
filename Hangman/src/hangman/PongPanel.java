/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangman;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

/**
 *
 * @author mrnoo
 */
public class PongPanel extends JPanel implements Runnable{
    
    static final int PANEL_WIDTH = 1000;
    static final int PANEL_HEIGHT = (int)(PANEL_WIDTH * ((double)5/9));
    static final Dimension SCREEN_SIZE = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    PongPaddle paddle1;
    PongPaddle paddle2;
    PongBall ball;
    PongScore score;
    PongFrame parent;
    JButton quitButton;
    
    public PongPanel(PongFrame parent){
        newPaddles();
        newBall();
        score = new PongScore(PANEL_WIDTH, PANEL_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        
        gameThread = new Thread(this);
        gameThread.start();
        
        this.parent = parent;
    }
    
    public void newBall(){
        random = new Random();
        int randomY = random.nextInt(PANEL_HEIGHT - BALL_DIAMETER);
        //ball = new PongBall((PANEL_WIDTH/2) - (BALL_DIAMETER/2), (PANEL_HEIGHT/2) - (BALL_DIAMETER/2), BALL_DIAMETER, BALL_DIAMETER);
        ball = new PongBall((PANEL_WIDTH/2) - (BALL_DIAMETER/2), randomY, BALL_DIAMETER, BALL_DIAMETER);
    }
    
    public void newPaddles(){
        paddle1 = new PongPaddle(0,(PANEL_HEIGHT/2) - (PADDLE_HEIGHT/2),PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddle2 = new PongPaddle(PANEL_WIDTH - PADDLE_WIDTH,(PANEL_HEIGHT/2) - (PADDLE_HEIGHT/2),PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }
    
    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    
    public void draw(Graphics g){
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }
    
    public void move(){
        paddle1.move();
        paddle2.move();
        ball.move();
    }
    
    public void checkCollision(){
        //bounce ball off top & bottom of window edges
        if(ball.y <= 0){
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.y >= PANEL_HEIGHT - BALL_DIAMETER){
            ball.setYDirection(-ball.yVelocity);
        }
        
        //bounces ball off paddles
        if(ball.intersects(paddle1)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ++ball.xVelocity;
            if(ball.yVelocity > 0){
                ++ball.yVelocity;
            }
            else{
                --ball.yVelocity;
            }
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        
        if(ball.intersects(paddle2)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ++ball.xVelocity;
            if(ball.yVelocity > 0){
                ++ball.yVelocity;
            }
            else{
                --ball.yVelocity;
            }
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        
        
        //stops paddles at window edges
        if(paddle1.y <= 0){
            paddle1.y = 0;
        }
        if(paddle1.y >= (PANEL_HEIGHT-PADDLE_HEIGHT)){
            paddle1.y = PANEL_HEIGHT-PADDLE_HEIGHT;
        }
        
        if(paddle2.y <= 0){
            paddle2.y = 0;
        }
        if(paddle2.y >= (PANEL_HEIGHT-PADDLE_HEIGHT)){
            paddle2.y = PANEL_HEIGHT-PADDLE_HEIGHT;
        }
        
        //give a player 1 point and creates new paddles and ball
        if(ball.x <= 0){
            score.player2+=10;
            if(score.player2 < 100){
                newPaddles();
                newBall();
                System.out.println(score.player1 + " " + score.player2);
            } else {
                JOptionPane.showMessageDialog(null, "Player 2 Wins!",
                    "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
                parent.gameOver();
                score.player1 = 0;
                score.player2 = 0;
            }
        }
        if(ball.x >= PANEL_WIDTH-BALL_DIAMETER){
            score.player1+=10;
            if(score.player1 < 100){
                newPaddles();
                newBall();
                System.out.println(score.player1 + " " + score.player2);
            } else {
                JOptionPane.showMessageDialog(null, "Player 1 Wins!",
                    "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
                parent.gameOver();
                score.player1 = 0;
                score.player2 = 0;
                    
            }
        }
        
    }
    
    public void run(){
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1){
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
        
    }
    
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        
        public void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
