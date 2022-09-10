/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hangman;

/**
 *
 * @author Shane
 */
public class Hangman {
    
    /**
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
