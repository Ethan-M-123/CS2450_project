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

/**
 *
 * @author Simon Nguyen
 */
public class DisplayInfo extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        InfoScreen temp = new InfoScreen();
        temp.show();
    }
}
