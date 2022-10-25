/***************************************************************  
*  file: PongScore.java
*  author: Shane, Simon, Dixon, Ethan, Marvin
*  class: CS 2450.01  
*  
*  assignment: Project V1.3 
*  date last modified: 10/24/2022
*  
*  purpose: 
*   Creates the line in the middle of the pong game, separating the 
*   two sides, and holds the scores for both players of the game.
*  
****************************************************************/

package hangman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


public class PongScore extends Rectangle{
    
    static int PANEL_WIDTH;
    static int PANEL_HEIGHT;
    int player1;
    int player2;
    
    public PongScore(int PANEL_WIDTH, int PANEL_HEIGHT){
        PongScore.PANEL_WIDTH = PANEL_WIDTH;
        PongScore.PANEL_HEIGHT = PANEL_HEIGHT;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Comic Sans", Font.PLAIN, 60));
        
        g.drawLine(PANEL_WIDTH/2, 0, PANEL_WIDTH/2, PANEL_HEIGHT);
        
        //g.drawString(String.valueOf(player1), (PANEL_WIDTH/2)-75, 50);
        //g.drawString(String.valueOf(player2), (PANEL_WIDTH/2)+10, 50);
        
    }
}
