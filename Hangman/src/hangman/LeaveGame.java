/***************************************************************  
*  file: LeaveGame.java  
*  author: Simon Nguyen
*  class: CS 2450.01  
*  
*  assignment: Project V1.3
*  date last modified: 10/10/2022
*  
*  purpose: Creates the action that leaves the game whenever
*           the escape key is pressed in any of the windows
*  
****************************************************************/

package hangman;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

 
public class LeaveGame extends AbstractAction {
    
    /**Method: actionPerformed 
     * Ends program when action is performed
     * 
     * @param e ActionEvent that triggers the action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
