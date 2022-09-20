/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hangman;

import java.io.File;

/**
 *
 * @author Shane
 */
public class Highscores extends javax.swing.JFrame {

    /**
     * Creates new form Highscores
     */
    
    public static int[] highscores = new int[5];
    public static String[] highscoreNames = {"ABC", "ABC", "ABC", "ABC", "ABC"}; 
    public Highscores() {
        initComponents();
        setSize(600,400);
        HighscoresController hsc = new HighscoresController(new File(".\\src\\hangman\\highscores.txt"));
        hsc.sortList();
        Player[] temp = hsc.getList();
        for(int i = 0; i < highscoreNames.length; ++i){
            highscoreNames[i] = temp[i].getName();
            highscores[i] = temp[i].getScore();
        }
        scoreOne.setText(highscoreNames[0] + "....." + highscores[0]);
        scoreTwo.setText(highscoreNames[1] + "....." + highscores[1]);
        scoreThree.setText(highscoreNames[2] + "....." + highscores[2]);
        scoreFour.setText(highscoreNames[3] + "....." + highscores[3]);
        scoreFive.setText(highscoreNames[4] + "....." + highscores[4]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        highscoresTitle = new javax.swing.JLabel();
        scoreOne = new javax.swing.JLabel();
        scoreTwo = new javax.swing.JLabel();
        scoreThree = new javax.swing.JLabel();
        scoreFour = new javax.swing.JLabel();
        scoreFive = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));

        highscoresTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        highscoresTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highscoresTitle.setText("Highscores");

        scoreOne.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        scoreOne.setText("jLabel3");

        scoreTwo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        scoreTwo.setText("jLabel2");

        scoreThree.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        scoreThree.setText("jLabel4");

        scoreFour.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        scoreFour.setText("jLabel1");

        scoreFive.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        scoreFive.setText("jLabel5");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(104, 104, 104)
                .addComponent(highscoresTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scoreFive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoreOne, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoreTwo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoreFour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoreThree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(highscoresTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(scoreOne)
                .addGap(18, 18, 18)
                .addComponent(scoreTwo)
                .addGap(18, 18, 18)
                .addComponent(scoreThree)
                .addGap(18, 18, 18)
                .addComponent(scoreFour)
                .addGap(18, 18, 18)
                .addComponent(scoreFive)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainMenu temp = new MainMenu();
        temp.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Highscores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Highscores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Highscores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Highscores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Highscores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel highscoresTitle;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel scoreFive;
    private javax.swing.JLabel scoreFour;
    private javax.swing.JLabel scoreOne;
    private javax.swing.JLabel scoreThree;
    private javax.swing.JLabel scoreTwo;
    // End of variables declaration//GEN-END:variables
}
