/***************************************************************  
*  file: ColorPickerGame.java
*  author: Shane, Simon, Dixon, Ethan, Marvin
*  class: CS 2450.01  
*  
*  assignment: Project V1.3 
*  date last modified: 09/24/2022
*  
*  purpose: 
*   Creates JFrame and objects to hold player information and 
*   high score, then adds the game panel
****************************************************************/


package hangman;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.*;



public class ColorPickerGame {

    static Player p = new Player("test", 0);
    static HighscoresController hsc;

    /** Constructor
     * Sets up player and high score controller for 
     * the color picker game
     * 
     * @param p object that holds the player's name and score
     * @param hsc high score controller that is passed from caller
     */
    public ColorPickerGame(Player p, HighscoresController hsc) {
        this.p = p;
        this.hsc = hsc;
        startGui();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                startGui();
            }
        });
    }

    /** StartGui
     * Sets up JFrame and adds game panel to the 
     * frame.
     */
    private static void startGui() {
        System.out.println("Gui on EDT? " + SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Color Picker Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);

        ColorPickerPanel cpp = new ColorPickerPanel(p);

        cpp.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {

            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {
                System.out.println(p.getName() + " - Total Score: " + p.getScore());
                System.out.println("End Game");
                //p.recordPlayerScore();

//                int[] temp = hsc.giveTopXScores(5);
//                if (temp[4] > p.getScore()){
//                    MainMenu mm = new MainMenu();
//                    mm.show();
//                }
//                else{
//                    EndScreen endPage = new EndScreen();
//                    endPage.show();
//                }
                Sudoku s = new Sudoku(p, hsc);
                s.show();

                f.dispose();
            }
        });
        f.add(cpp);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
}
