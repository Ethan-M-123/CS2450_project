/***************************************************************  
*  file: DisplayInfo.java  
*  author: Simon Nguyen
*  class: CS 2450.01  
*  
*  assignment: Project V1.2
*  date last modified: 10/10/2022
*  
*  purpose: Creates the action that displays info about the game 
*           when the F1 key is pressed in any window 
*  
****************************************************************/

package hangman;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JFrame;


public class DisplayInfo extends AbstractAction {
    //InfoScreen temp;
    JFrame frame;

    /** Creates an dialog box that displays
     *  Information about the game
     * 
     * @param e ActionEvent that is received from 
     *          the caller
     */
    @Override
    public void actionPerformed(ActionEvent e) {
                
        frame = new JFrame();
        
        String [] names = { "Term: Fall 2022\n\nCredits:",
                            "Dixon Dai, 014899781", 
                            "Shane Baxter, 013655473", 
                            "Ethan Melero, 014669369",
                            "Marvin Sevilla, 014646346",
                            "Simon Nguyen, 016372824"};
        String title = "Point and Click Game v1.2";

        JOptionPane.showMessageDialog(frame, names, title, JOptionPane.PLAIN_MESSAGE);
    }
}
