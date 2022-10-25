/***************************************************************  
*  file: Hangman.java  
*  author: Shane, Marvin
*  class: CS 2450.01  
*  
*  assignment: Project V1.0 
*  date last modified: 9/21/2022
*  
*  purpose: drives the opening screen and main menu open and close operations
*  
****************************************************************/  

package hangman;

/**
 *
 * @author Shane
 */
public class Hangman {
    
    /** method: main
     * purpose: Called when class is created and sets
     *  up the opening screen, then the main menu
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OpeningScreen firstFrame = new OpeningScreen();
        firstFrame.show();                              //show opening screen
        
        try {
            Thread.sleep(3000);   //wait 3 seconds before showing menu
        } catch(InterruptedException ex) {  
            ex.printStackTrace();
        }
        
        MainMenu secondFrame = new MainMenu();  //show main menu then dispose opening screen
        secondFrame.show();
        firstFrame.dispose();
        
    }
    
}
