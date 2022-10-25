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

package hangman;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.Calendar;
import javax.swing.JButton;
import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;


public class PongFrame extends JFrame{
    
    PongPanel panel;
    JPanel top;
    JPanel bottom;
    JPanel paneHolder;
    JPanel buttonHolder;
    JLabel title;
    JLabel timeStamp;
    JTextArea player1;
    JTextArea player2;
    JButton quit;
    
    /* Constructor for the Pong JFrame, initializes components and starts the 
    game. */
    public PongFrame(){
        
        this.setPreferredSize(new Dimension(600, 400));
        this.setLayout(new BorderLayout());
        
        initComponents();

        // Updates timeStamp!
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    timeStamp.setText(" " + Calendar.getInstance().getTime().toString() + " ");

                }
            }
        }.start();

        
        
        this.setTitle("Pong");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    /** Method calls for the main menu page to 
     * be called and disposes of current frame
     * 
     */
    public void gameOver(){
        
        MainMenu menu = new MainMenu();
        menu.show();
        this.dispose();
    }
    
    /** Method initiates the components of the Pong game
     * 
     */
    public void initComponents() {
        
        panel = new PongPanel(this);
        top = new JPanel();
        bottom = new JPanel();
        paneHolder = new JPanel();
        buttonHolder = new JPanel();
        title = new JLabel("  Pong");
        timeStamp = new JLabel("Month Day, Year");
        player1 = new JTextArea();
        player2 = new JTextArea();
        quit = new JButton("Quit");
        

        // Set top panel sizing
        top.setPreferredSize(new Dimension(600, 40));
        top.setLayout(new BorderLayout());
        top.setBackground(this.getBackground());
        
        
        //Set title
        title.setFont(new java.awt.Font("Chiller", 0, 30));
        title.setLocation(0, 0);
        top.add(title, BorderLayout.LINE_START);
        

        // Set timeStamp
        timeStamp.setBackground(Color.LIGHT_GRAY);
        timeStamp.setOpaque(true);
        timeStamp.setFont(new java.awt.Font("Times New Roman", 0, 14));
        paneHolder.add(timeStamp);
        top.add(paneHolder, BorderLayout.LINE_END);
        
        // Escape Key Exit
        timeStamp.getInputMap(WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("ESCAPE"), "leaveGame");
        timeStamp.getActionMap().put("leaveGame", new LeaveGame());
        
        //F1 key display
        timeStamp.getInputMap(WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("F1"), "displayInfo");
        timeStamp.getActionMap().put("displayInfo", new DisplayInfo());

        
        
        // Set Player stats
        player1.setEditable(false);
        player1.setFont(new java.awt.Font("Tahoma", 0, 15));
        player1.setLineWrap(true);
        player1.setWrapStyleWord(true);
        player1.setBackground(this.getBackground());
        player1.setPreferredSize(new Dimension(92, 50));
        player1.setFocusable(false);
        
        player2.setEditable(false);
        player2.setFont(new java.awt.Font("Tahoma", 0, 15));
        player2.setLineWrap(true);
        player2.setWrapStyleWord(true);
        player2.setBackground(this.getBackground());
        player2.setPreferredSize(new Dimension(92, 50));
        player2.setFocusable(false);
        
        player1.setText("\n\nPlayer 1 Score:\n" + panel.score.player1);
        player2.setText("\n\nPlayer 2 Score:\n" + panel.score.player2);
        
        // Add Game to Frame
        this.add(player1, BorderLayout.LINE_START);
        this.add(player2, BorderLayout.LINE_END);
        this.add(panel, BorderLayout.CENTER);
        
        
        
        //Set Bottom of the Frame
        bottom.setPreferredSize(new Dimension(600, 100));
        bottom.setLayout(new BorderLayout());
        bottom.setBackground(this.getBackground());
        
        //Set up quit botton
        quit.setPreferredSize(new Dimension(60, 40));
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameOver();
            }
        });
        quit.setToolTipText("Quit Game");
        buttonHolder.add(quit);
        bottom.add(buttonHolder, BorderLayout.LINE_END);

        //Add Top and Bottom to Frame
        add(top, BorderLayout.PAGE_START);
        add(bottom, BorderLayout.PAGE_END);
    }

 
}