/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package hangman;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.*;

/**
 *
 * @author mrnoo, Simon
 */
public class ColorPickerGame{
    static Player p = new Player("test",0); //FIXME: replace with real player info
    
    public ColorPickerGame(Player p){
        this.p = p;
        startGui();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                startGui();
            }
        });
    }
    
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
                p.recordPlayerScore();
                
                EndScreen endPage = new EndScreen();
                endPage.show();
                
                
                f.dispose();
            }
        });
        f.add(cpp);
        
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
        
    }
}