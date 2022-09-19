/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hangman;
import java.io.*;
import java.util.*;

/**
 *
 * @author Raini
 */
public class EndScreen extends javax.swing.JFrame {

    /**
     * Creates new form EndScreen
     */
    public EndScreen() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        label_YourScore.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        label_YourScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_YourScore.setText("YOUR SCORE");
        label_YourScore.setAlignmentY(0.0F);

        label_ScoreDisplay.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        label_ScoreDisplay.setForeground(new java.awt.Color(255, 0, 0));
        label_ScoreDisplay.setText("0");
        label_ScoreDisplay.setAlignmentY(0.0F);

        btn_End.setFont(new java.awt.Font("SWIsot3", 0, 18)); // NOI18N
        btn_End.setText("END");
        btn_End.setAlignmentY(0.0F);
        btn_End.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label_YourScore, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label_ScoreDisplay)
                        .addGap(285, 285, 285))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_End)
                        .addGap(258, 258, 258))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(label_YourScore, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_ScoreDisplay)
                .addGap(18, 18, 18)
                .addComponent(btn_End)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            file.append("\nRandom " + String.valueOf(retrieveLatestScore()));
            file.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        MainMenu mainScreen = new MainMenu();
        mainScreen.show();
        this.dispose();
    }//GEN-LAST:event_btn_EndActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_ScoreDisplay;
    private javax.swing.JLabel label_YourScore;
    // End of variables declaration//GEN-END:variables
}
