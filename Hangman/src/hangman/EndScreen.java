/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hangman;
import java.io.*;
import java.util.*;

/***************************************************************  
*  file: EndScreen.java  
*  author: M. Sevilla, others 
*  class: CS 2450.01  
*  
*  assignment: Project V1.0 
*  date last modified: 9/21/2022
*  
*  purpose: Shows the user their final score after playing the game, allows them
*  to name themselves, and records the user's score before exiting to the main
*  menu
*  
****************************************************************/  

public class EndScreen extends javax.swing.JFrame {

    /**
     * Creates new form EndScreen
     */
    public EndScreen() {
        initComponents();
        setSize(600,400);
        setLocationRelativeTo(null);
        setScore(retrieveLatestScore());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private int retrieveLatestScore()
    {
        String playerName = null;
        Integer score = 0;
        
        try
        {
            File scores = new File (".\\src\\hangman\\LastScore.txt");
            Scanner reader = new Scanner(scores);

            while(!Objects.equals(playerName, "lastScore"))
            {
                String playerHolder[];
                playerHolder = reader.nextLine().split(" ", 2);
                
                playerName = playerHolder[0];
                score = Integer.parseInt(playerHolder[1]);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        
        return score;
    }
    
    private void setScore(int x)
    {
      label_ScoreDisplay.setText(String.valueOf(x));  
    } 
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_YourScore = new javax.swing.JLabel();
        label_ScoreDisplay = new javax.swing.JLabel();
        btn_End = new javax.swing.JButton();
        playerNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(636, 400));
        jPanel1.setRequestFocusEnabled(false);

        label_YourScore.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        label_YourScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_YourScore.setText("YOUR SCORE");

        label_ScoreDisplay.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        label_ScoreDisplay.setForeground(new java.awt.Color(255, 0, 0));
        label_ScoreDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_ScoreDisplay.setText("0");

        btn_End.setFont(new java.awt.Font("SWIsot3", 0, 18)); // NOI18N
        btn_End.setText("END");
        btn_End.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EndActionPerformed(evt);
            }
        });

        playerNameField.setText("ABC");
        playerNameField.setName(""); // NOI18N
        playerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerNameFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter Your Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(label_YourScore, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(btn_End))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(label_ScoreDisplay))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(playerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(label_YourScore, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_ScoreDisplay)
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(btn_End)
                .addGap(14, 14, 14))
        );

        playerNameField.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EndActionPerformed
        /* 
        //Keeping this in case the person who made the Player class ever comes 
        // fix it or properly implement their function here
        
        Player newPlayer = new Player("Random", retrieveLatestScore());
        HighscoresController hsCtrl = new HighscoresController(new File(".\\src\\hangman\\highscores.txt"));
        hsCtrl.addPlayer(newPlayer);
        */
        try
        { 
            FileWriter file = new FileWriter(".\\src\\hangman\\highscores.txt", true);
            file.append("\n" + playerNameField.getText() + " " + String.valueOf(retrieveLatestScore()));
            file.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        MainMenu mainScreen = new MainMenu();
        mainScreen.show();
        this.dispose();
    }//GEN-LAST:event_btn_EndActionPerformed

    private void playerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerNameFieldActionPerformed
        // No action will be performed yet
    }//GEN-LAST:event_playerNameFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EndScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EndScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EndScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EndScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EndScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_End;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_ScoreDisplay;
    private javax.swing.JLabel label_YourScore;
    private javax.swing.JTextField playerNameField;
    // End of variables declaration//GEN-END:variables
}
