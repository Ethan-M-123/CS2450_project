/** *************************************************************
 *  file: Sudoku.java
 *
 * @author Shane, Simon, Dixon 
 * class: CS 2450.01
 *
 * assignment: Project V1.3 
 * date last modified: 10/17/2022
 *
 * purpose: 
 * Creates a Sudoku puzzle for the player to solve, decrementing
 * points for squares guessed wrong. No square that was guessed 
 * wrong can decrement again.
***************************************************************
 */
package hangman;

import java.awt.Color;
import java.util.Calendar;
import java.util.HashSet;
import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author Shane
 */
public class Sudoku extends javax.swing.JFrame {

    static Player p = new Player("test", 0);
    static HighscoresController hsc;
    private HighscoresController temp;
    private int lowestHS;
    
    private static String[][] sudokuKey
        = {{"8", "3", "5", "4", "1", "6", "9", "2", "7"},
        {"2", "9", "6", "8", "5", "7", "4", "3", "1"},
        {"4", "1", "7", "2", "9", "3", "6", "5", "8"},
        {"5", "6", "9", "1", "3", "4", "7", "8", "2"},
        {"1", "2", "3", "6", "7", "8", "5", "4", "9"},
        {"7", "4", "8", "5", "2", "9", "1", "6", "3"},
        {"6", "5", "2", "7", "8", "1", "3", "9", "4"},
        {"9", "8", "1", "3", "4", "5", "2", "7", "6"},
        {"3", "7", "4", "9", "6", "2", "8", "1", "5"}
        };
    private static boolean[][] hasSquareBeenGuessed = new boolean[9][9];
    private JTextField[][] gameBoard;
    private static int sudokuScore = 540;
    private static boolean isFirstRun = true;

    JTextArea timeStamp;
    JLabel title;

    /**
     * Creates new form Sudoku
     */
    public Sudoku(Player p, HighscoresController hsc) {
        this.p = p;
        this.hsc = hsc;
        temp = hsc;
        
        temp.sortList();
        lowestHS = temp.getList()[4].getScore();

        timeStamp = new JTextArea();
        title = new JLabel("Sudoku");

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    timeStamp.setText(Calendar.getInstance().getTime().toString());
                }
            }
        }.start();

        //Paint the timeStamp
        timeStamp.setBounds(15, 70, 75, 50);
        timeStamp.setEditable(false);
        timeStamp.setBackground(Color.LIGHT_GRAY);
        timeStamp.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 12));
        timeStamp.setOpaque(true);
        timeStamp.setLineWrap(true);
        timeStamp.setWrapStyleWord(true);
        add(timeStamp);

        title.setFont(new java.awt.Font("Chiller", 0, 30));
        title.setBounds(20, 20, 120, 25);
        add(title);

        initComponents();

        JTextField[] a = {square0_0, square0_1, square0_2, square0_3, square0_4, square0_5, square0_6, square0_7, square0_8};
        JTextField[] b = {square1_0, square1_1, square1_2, square1_3, square1_4, square1_5, square1_6, square1_7, square1_8};
        JTextField[] c = {square2_0, square2_1, square2_2, square2_3, square2_4, square2_5, square2_6, square2_7, square2_8};
        JTextField[] d = {square3_0, square3_1, square3_2, square3_3, square3_4, square3_5, square3_6, square3_7, square3_8};
        JTextField[] e = {square4_0, square4_1, square4_2, square4_3, square4_4, square4_5, square4_6, square4_7, square4_8};
        JTextField[] f = {square5_0, square5_1, square5_2, square5_3, square5_4, square5_5, square5_6, square5_7, square5_8};
        JTextField[] g = {square6_0, square6_1, square6_2, square6_3, square6_4, square6_5, square6_6, square6_7, square6_8};
        JTextField[] h = {square7_0, square7_1, square7_2, square7_3, square7_4, square7_5, square7_6, square7_7, square7_8};
        JTextField[] i = {square8_0, square8_1, square8_2, square8_3, square8_4, square8_5, square8_6, square8_7, square8_8};
        gameBoard = new JTextField[9][9];
        gameBoard[0] = a;
        gameBoard[1] = b;
        gameBoard[2] = c;
        gameBoard[3] = d;
        gameBoard[4] = e;
        gameBoard[5] = f;
        gameBoard[6] = g;
        gameBoard[7] = h;
        gameBoard[8] = i;

        // Escape Key Exit
        square0_0.getInputMap(WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("ESCAPE"), "leaveGame");
        square0_0.getActionMap().put("leaveGame", new LeaveGame());

        //F1 key display
        square0_0.getInputMap(WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("F1"), "displayInfo");
        square0_0.getActionMap().put("displayInfo", new DisplayInfo());

        submitButton.setToolTipText("Submit Sudoku Answer");
        quitButton.setToolTipText("Quit Sudoku Game");

        setResizable(false);
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        square6_2 = new javax.swing.JTextField();
        square0_7 = new javax.swing.JTextField();
        square3_8 = new javax.swing.JTextField();
        square0_2 = new javax.swing.JTextField();
        square5_8 = new javax.swing.JTextField();
        square3_4 = new javax.swing.JTextField();
        square0_4 = new javax.swing.JTextField();
        square0_6 = new javax.swing.JTextField();
        square0_5 = new javax.swing.JTextField();
        square0_1 = new javax.swing.JTextField();
        square8_2 = new javax.swing.JTextField();
        square1_1 = new javax.swing.JTextField();
        square2_5 = new javax.swing.JTextField();
        square1_3 = new javax.swing.JTextField();
        square1_4 = new javax.swing.JTextField();
        square5_1 = new javax.swing.JTextField();
        square1_5 = new javax.swing.JTextField();
        square1_7 = new javax.swing.JTextField();
        square1_0 = new javax.swing.JTextField();
        square3_7 = new javax.swing.JTextField();
        square1_2 = new javax.swing.JTextField();
        square2_2 = new javax.swing.JTextField();
        square2_3 = new javax.swing.JTextField();
        square2_4 = new javax.swing.JTextField();
        square1_6 = new javax.swing.JTextField();
        square2_6 = new javax.swing.JTextField();
        square1_8 = new javax.swing.JTextField();
        square6_1 = new javax.swing.JTextField();
        square2_0 = new javax.swing.JTextField();
        square3_1 = new javax.swing.JTextField();
        square5_0 = new javax.swing.JTextField();
        square6_0 = new javax.swing.JTextField();
        square7_2 = new javax.swing.JTextField();
        square3_5 = new javax.swing.JTextField();
        square3_0 = new javax.swing.JTextField();
        square4_8 = new javax.swing.JTextField();
        square8_3 = new javax.swing.JTextField();
        square3_3 = new javax.swing.JTextField();
        square0_8 = new javax.swing.JTextField();
        square5_2 = new javax.swing.JTextField();
        square2_8 = new javax.swing.JTextField();
        square4_0 = new javax.swing.JTextField();
        square4_1 = new javax.swing.JTextField();
        square4_2 = new javax.swing.JTextField();
        square3_6 = new javax.swing.JTextField();
        square5_5 = new javax.swing.JTextField();
        square4_5 = new javax.swing.JTextField();
        square4_6 = new javax.swing.JTextField();
        square5_7 = new javax.swing.JTextField();
        square0_3 = new javax.swing.JTextField();
        square0_0 = new javax.swing.JTextField();
        square4_3 = new javax.swing.JTextField();
        square4_4 = new javax.swing.JTextField();
        square6_8 = new javax.swing.JTextField();
        square2_1 = new javax.swing.JTextField();
        square8_0 = new javax.swing.JTextField();
        square4_7 = new javax.swing.JTextField();
        square8_8 = new javax.swing.JTextField();
        square8_5 = new javax.swing.JTextField();
        square5_3 = new javax.swing.JTextField();
        square7_3 = new javax.swing.JTextField();
        square8_4 = new javax.swing.JTextField();
        square7_5 = new javax.swing.JTextField();
        square3_2 = new javax.swing.JTextField();
        square7_8 = new javax.swing.JTextField();
        square7_0 = new javax.swing.JTextField();
        square5_6 = new javax.swing.JTextField();
        square6_3 = new javax.swing.JTextField();
        square6_4 = new javax.swing.JTextField();
        square6_5 = new javax.swing.JTextField();
        square6_6 = new javax.swing.JTextField();
        square8_6 = new javax.swing.JTextField();
        square8_7 = new javax.swing.JTextField();
        square7_1 = new javax.swing.JTextField();
        square8_1 = new javax.swing.JTextField();
        square6_7 = new javax.swing.JTextField();
        square7_4 = new javax.swing.JTextField();
        square5_4 = new javax.swing.JTextField();
        square7_6 = new javax.swing.JTextField();
        square7_7 = new javax.swing.JTextField();
        square2_7 = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        square6_2.setEditable(false);
        square6_2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square6_2.setForeground(new java.awt.Color(0, 51, 153));
        square6_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square6_2.setText("2");
        square6_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square6_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square6_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square6_2ActionPerformed(evt);
            }
        });
        jPanel1.add(square6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 40, 40));

        square0_7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square0_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square0_7.setToolTipText("Enter number 1-9");
        square0_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square0_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0_7ActionPerformed(evt);
            }
        });
        jPanel1.add(square0_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 40, 40));

        square3_8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square3_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square3_8.setToolTipText("Enter number 1-9");
        square3_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square3_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square3_8ActionPerformed(evt);
            }
        });
        jPanel1.add(square3_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 40, 40));

        square0_2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square0_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square0_2.setToolTipText("Enter number 1-9");
        square0_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square0_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0_2ActionPerformed(evt);
            }
        });
        jPanel1.add(square0_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 40, 40));

        square5_8.setEditable(false);
        square5_8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square5_8.setForeground(new java.awt.Color(0, 51, 153));
        square5_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square5_8.setText("3");
        square5_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square5_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square5_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square5_8ActionPerformed(evt);
            }
        });
        jPanel1.add(square5_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 40, 40));

        square3_4.setEditable(false);
        square3_4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square3_4.setForeground(new java.awt.Color(0, 51, 153));
        square3_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square3_4.setText("3");
        square3_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square3_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square3_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square3_4ActionPerformed(evt);
            }
        });
        jPanel1.add(square3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 40, 40));

        square0_4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square0_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square0_4.setToolTipText("Enter number 1-9");
        square0_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square0_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0_4ActionPerformed(evt);
            }
        });
        jPanel1.add(square0_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 40, 40));

        square0_6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square0_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square0_6.setToolTipText("Enter number 1-9");
        square0_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square0_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0_6ActionPerformed(evt);
            }
        });
        jPanel1.add(square0_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 40, 40));

        square0_5.setEditable(false);
        square0_5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square0_5.setForeground(new java.awt.Color(0, 51, 153));
        square0_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square0_5.setText("6");
        square0_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square0_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square0_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0_5ActionPerformed(evt);
            }
        });
        jPanel1.add(square0_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 40, 40));

        square0_1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square0_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square0_1.setToolTipText("Enter number 1-9");
        square0_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square0_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0_1ActionPerformed(evt);
            }
        });
        jPanel1.add(square0_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 40, 40));

        square8_2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square8_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square8_2.setToolTipText("Enter number 1-9");
        square8_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square8_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square8_2ActionPerformed(evt);
            }
        });
        jPanel1.add(square8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 40, 40));

        square1_1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square1_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square1_1.setToolTipText("Enter number 1-9");
        square1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square1_1ActionPerformed(evt);
            }
        });
        jPanel1.add(square1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 40, 40));

        square2_5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square2_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square2_5.setToolTipText("Enter number 1-9");
        square2_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square2_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square2_5ActionPerformed(evt);
            }
        });
        jPanel1.add(square2_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 40, 40));

        square1_3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square1_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square1_3.setToolTipText("Enter number 1-9");
        square1_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square1_3ActionPerformed(evt);
            }
        });
        jPanel1.add(square1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 40, 40));

        square1_4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square1_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square1_4.setToolTipText("Enter number 1-9");
        square1_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square1_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square1_4ActionPerformed(evt);
            }
        });
        jPanel1.add(square1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 40, 40));

        square5_1.setEditable(false);
        square5_1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square5_1.setForeground(new java.awt.Color(0, 51, 153));
        square5_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square5_1.setText("4");
        square5_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square5_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square5_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square5_1ActionPerformed(evt);
            }
        });
        jPanel1.add(square5_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 40, 40));

        square1_5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square1_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square1_5.setToolTipText("Enter number 1-9");
        square1_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square1_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square1_5ActionPerformed(evt);
            }
        });
        jPanel1.add(square1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 40, 40));

        square1_7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square1_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square1_7.setToolTipText("Enter number 1-9");
        square1_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square1_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square1_7ActionPerformed(evt);
            }
        });
        jPanel1.add(square1_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 40, 40));

        square1_0.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square1_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square1_0.setToolTipText("Enter number 1-9");
        square1_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square1_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square1_0ActionPerformed(evt);
            }
        });
        jPanel1.add(square1_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 40, 40));

        square3_7.setEditable(false);
        square3_7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square3_7.setForeground(new java.awt.Color(0, 51, 153));
        square3_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square3_7.setText("8");
        square3_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square3_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square3_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square3_7ActionPerformed(evt);
            }
        });
        jPanel1.add(square3_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 40, 40));

        square1_2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square1_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square1_2.setToolTipText("Enter number 1-9");
        square1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square1_2ActionPerformed(evt);
            }
        });
        jPanel1.add(square1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 40, 40));

        square2_2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square2_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square2_2.setToolTipText("Enter number 1-9");
        square2_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square2_2ActionPerformed(evt);
            }
        });
        jPanel1.add(square2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 40, 40));

        square2_3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square2_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square2_3.setToolTipText("Enter number 1-9");
        square2_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square2_3ActionPerformed(evt);
            }
        });
        jPanel1.add(square2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 40, 40));

        square2_4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square2_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square2_4.setToolTipText("Enter number 1-9");
        square2_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square2_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square2_4ActionPerformed(evt);
            }
        });
        jPanel1.add(square2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 40, 40));

        square1_6.setEditable(false);
        square1_6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square1_6.setForeground(new java.awt.Color(0, 51, 153));
        square1_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square1_6.setText("4");
        square1_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square1_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square1_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square1_6ActionPerformed(evt);
            }
        });
        jPanel1.add(square1_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 40, 40));

        square2_6.setEditable(false);
        square2_6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square2_6.setForeground(new java.awt.Color(0, 51, 153));
        square2_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square2_6.setText("6");
        square2_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square2_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square2_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square2_6ActionPerformed(evt);
            }
        });
        jPanel1.add(square2_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 40, 40));

        square1_8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square1_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square1_8.setToolTipText("Enter number 1-9");
        square1_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square1_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square1_8ActionPerformed(evt);
            }
        });
        jPanel1.add(square1_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 40, 40));

        square6_1.setEditable(false);
        square6_1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square6_1.setForeground(new java.awt.Color(0, 51, 153));
        square6_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square6_1.setText("5");
        square6_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square6_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square6_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square6_1ActionPerformed(evt);
            }
        });
        jPanel1.add(square6_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 40, 40));

        square2_0.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square2_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square2_0.setToolTipText("Enter number 1-9");
        square2_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square2_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square2_0ActionPerformed(evt);
            }
        });
        jPanel1.add(square2_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 40, 40));

        square3_1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square3_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square3_1.setToolTipText("Enter number 1-9");
        square3_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square3_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square3_1ActionPerformed(evt);
            }
        });
        jPanel1.add(square3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 40, 40));

        square5_0.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square5_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square5_0.setToolTipText("Enter number 1-9");
        square5_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square5_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square5_0ActionPerformed(evt);
            }
        });
        jPanel1.add(square5_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 40, 40));

        square6_0.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square6_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square6_0.setToolTipText("Enter number 1-9");
        square6_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square6_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square6_0ActionPerformed(evt);
            }
        });
        jPanel1.add(square6_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 40, 40));

        square7_2.setEditable(false);
        square7_2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square7_2.setForeground(new java.awt.Color(0, 51, 153));
        square7_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square7_2.setText("1");
        square7_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square7_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square7_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square7_2ActionPerformed(evt);
            }
        });
        jPanel1.add(square7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 40, 40));

        square3_5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square3_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square3_5.setToolTipText("Enter number 1-9");
        square3_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square3_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square3_5ActionPerformed(evt);
            }
        });
        jPanel1.add(square3_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 40, 40));

        square3_0.setEditable(false);
        square3_0.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square3_0.setForeground(new java.awt.Color(0, 51, 153));
        square3_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square3_0.setText("5");
        square3_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square3_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square3_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square3_0ActionPerformed(evt);
            }
        });
        jPanel1.add(square3_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 40, 40));

        square4_8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square4_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square4_8.setToolTipText("Enter number 1-9");
        square4_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square4_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square4_8ActionPerformed(evt);
            }
        });
        jPanel1.add(square4_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 40, 40));

        square8_3.setEditable(false);
        square8_3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square8_3.setForeground(new java.awt.Color(0, 51, 153));
        square8_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square8_3.setText("9");
        square8_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square8_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square8_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square8_3ActionPerformed(evt);
            }
        });
        jPanel1.add(square8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 40, 40));

        square3_3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square3_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square3_3.setToolTipText("Enter number 1-9");
        square3_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square3_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square3_3ActionPerformed(evt);
            }
        });
        jPanel1.add(square3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 40, 40));

        square0_8.setEditable(false);
        square0_8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square0_8.setForeground(new java.awt.Color(0, 51, 153));
        square0_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square0_8.setText("7");
        square0_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square0_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square0_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0_8ActionPerformed(evt);
            }
        });
        jPanel1.add(square0_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 40, 40));

        square5_2.setEditable(false);
        square5_2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square5_2.setForeground(new java.awt.Color(0, 51, 153));
        square5_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square5_2.setText("8");
        square5_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square5_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square5_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square5_2ActionPerformed(evt);
            }
        });
        jPanel1.add(square5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 40, 40));

        square2_8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square2_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square2_8.setToolTipText("Enter number 1-9");
        square2_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square2_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square2_8ActionPerformed(evt);
            }
        });
        jPanel1.add(square2_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 40, 40));

        square4_0.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square4_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square4_0.setToolTipText("Enter number 1-9");
        square4_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square4_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square4_0ActionPerformed(evt);
            }
        });
        jPanel1.add(square4_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 40, 40));

        square4_1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square4_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square4_1.setToolTipText("Enter number 1-9");
        square4_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square4_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square4_1ActionPerformed(evt);
            }
        });
        jPanel1.add(square4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 40, 40));

        square4_2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square4_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square4_2.setToolTipText("Enter number 1-9");
        square4_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square4_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square4_2ActionPerformed(evt);
            }
        });
        jPanel1.add(square4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 40, 40));

        square3_6.setEditable(false);
        square3_6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square3_6.setForeground(new java.awt.Color(0, 51, 153));
        square3_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square3_6.setText("7");
        square3_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square3_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square3_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square3_6ActionPerformed(evt);
            }
        });
        jPanel1.add(square3_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 40, 40));

        square5_5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square5_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square5_5.setToolTipText("Enter number 1-9");
        square5_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square5_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square5_5ActionPerformed(evt);
            }
        });
        jPanel1.add(square5_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 40, 40));

        square4_5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square4_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square4_5.setToolTipText("Enter number 1-9");
        square4_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square4_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square4_5ActionPerformed(evt);
            }
        });
        jPanel1.add(square4_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 40, 40));

        square4_6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square4_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square4_6.setToolTipText("Enter number 1-9");
        square4_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square4_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square4_6ActionPerformed(evt);
            }
        });
        jPanel1.add(square4_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 40, 40));

        square5_7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square5_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square5_7.setToolTipText("Enter number 1-9");
        square5_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square5_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square5_7ActionPerformed(evt);
            }
        });
        jPanel1.add(square5_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 40, 40));

        square0_3.setEditable(false);
        square0_3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square0_3.setForeground(new java.awt.Color(0, 51, 153));
        square0_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square0_3.setText("4");
        square0_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square0_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square0_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0_3ActionPerformed(evt);
            }
        });
        jPanel1.add(square0_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 40, 40));

        square0_0.setEditable(false);
        square0_0.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square0_0.setForeground(new java.awt.Color(0, 51, 153));
        square0_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square0_0.setText("8");
        square0_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square0_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square0_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square0_0ActionPerformed(evt);
            }
        });
        jPanel1.add(square0_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        square4_3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square4_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square4_3.setToolTipText("Enter number 1-9");
        square4_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square4_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square4_3ActionPerformed(evt);
            }
        });
        jPanel1.add(square4_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 40, 40));

        square4_4.setEditable(false);
        square4_4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square4_4.setForeground(new java.awt.Color(0, 51, 153));
        square4_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square4_4.setText("7");
        square4_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square4_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square4_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square4_4ActionPerformed(evt);
            }
        });
        jPanel1.add(square4_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 40, 40));

        square6_8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square6_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square6_8.setToolTipText("Enter number 1-9");
        square6_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square6_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square6_8ActionPerformed(evt);
            }
        });
        jPanel1.add(square6_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 40, 40));

        square2_1.setEditable(false);
        square2_1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square2_1.setForeground(new java.awt.Color(0, 51, 153));
        square2_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square2_1.setText("1");
        square2_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square2_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square2_1ActionPerformed(evt);
            }
        });
        jPanel1.add(square2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 40, 40));

        square8_0.setEditable(false);
        square8_0.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square8_0.setForeground(new java.awt.Color(0, 51, 153));
        square8_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square8_0.setText("3");
        square8_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square8_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square8_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square8_0ActionPerformed(evt);
            }
        });
        jPanel1.add(square8_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 40, 40));

        square4_7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square4_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square4_7.setToolTipText("Enter number 1-9");
        square4_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square4_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square4_7ActionPerformed(evt);
            }
        });
        jPanel1.add(square4_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 40, 40));

        square8_8.setEditable(false);
        square8_8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square8_8.setForeground(new java.awt.Color(0, 51, 153));
        square8_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square8_8.setText("5");
        square8_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square8_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square8_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square8_8ActionPerformed(evt);
            }
        });
        jPanel1.add(square8_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 40, 40));

        square8_5.setEditable(false);
        square8_5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square8_5.setForeground(new java.awt.Color(0, 51, 153));
        square8_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square8_5.setText("2");
        square8_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square8_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square8_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square8_5ActionPerformed(evt);
            }
        });
        jPanel1.add(square8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 40, 40));

        square5_3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square5_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square5_3.setToolTipText("Enter number 1-9");
        square5_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square5_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square5_3ActionPerformed(evt);
            }
        });
        jPanel1.add(square5_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 40, 40));

        square7_3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square7_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square7_3.setToolTipText("Enter number 1-9");
        square7_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square7_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square7_3ActionPerformed(evt);
            }
        });
        jPanel1.add(square7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 40, 40));

        square8_4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square8_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square8_4.setToolTipText("Enter number 1-9");
        square8_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square8_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square8_4ActionPerformed(evt);
            }
        });
        jPanel1.add(square8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 40, 40));

        square7_5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square7_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square7_5.setToolTipText("Enter number 1-9");
        square7_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square7_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square7_5ActionPerformed(evt);
            }
        });
        jPanel1.add(square7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 40, 40));

        square3_2.setEditable(false);
        square3_2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square3_2.setForeground(new java.awt.Color(0, 51, 153));
        square3_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square3_2.setText("9");
        square3_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square3_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square3_2ActionPerformed(evt);
            }
        });
        jPanel1.add(square3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 40, 40));

        square7_8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square7_8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square7_8.setToolTipText("Enter number 1-9");
        square7_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square7_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square7_8ActionPerformed(evt);
            }
        });
        jPanel1.add(square7_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 40, 40));

        square7_0.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square7_0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square7_0.setToolTipText("Enter number 1-9");
        square7_0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square7_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square7_0ActionPerformed(evt);
            }
        });
        jPanel1.add(square7_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 40, 40));

        square5_6.setEditable(false);
        square5_6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square5_6.setForeground(new java.awt.Color(0, 51, 153));
        square5_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square5_6.setText("1");
        square5_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square5_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square5_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square5_6ActionPerformed(evt);
            }
        });
        jPanel1.add(square5_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 40, 40));

        square6_3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square6_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square6_3.setToolTipText("Enter number 1-9");
        square6_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square6_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square6_3ActionPerformed(evt);
            }
        });
        jPanel1.add(square6_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 40, 40));

        square6_4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square6_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square6_4.setToolTipText("Enter number 1-9");
        square6_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square6_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square6_4ActionPerformed(evt);
            }
        });
        jPanel1.add(square6_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 40, 40));

        square6_5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square6_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square6_5.setToolTipText("Enter number 1-9");
        square6_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square6_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square6_5ActionPerformed(evt);
            }
        });
        jPanel1.add(square6_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 40, 40));

        square6_6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square6_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square6_6.setToolTipText("Enter number 1-9");
        square6_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square6_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square6_6ActionPerformed(evt);
            }
        });
        jPanel1.add(square6_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 40, 40));

        square8_6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square8_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square8_6.setToolTipText("Enter number 1-9");
        square8_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square8_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square8_6ActionPerformed(evt);
            }
        });
        jPanel1.add(square8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 40, 40));

        square8_7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square8_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square8_7.setToolTipText("Enter number 1-9");
        square8_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square8_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square8_7ActionPerformed(evt);
            }
        });
        jPanel1.add(square8_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 40, 40));

        square7_1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square7_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square7_1.setToolTipText("Enter number 1-9");
        square7_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square7_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square7_1ActionPerformed(evt);
            }
        });
        jPanel1.add(square7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 40, 40));

        square8_1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square8_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square8_1.setToolTipText("Enter number 1-9");
        square8_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square8_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square8_1ActionPerformed(evt);
            }
        });
        jPanel1.add(square8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 40, 40));

        square6_7.setEditable(false);
        square6_7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square6_7.setForeground(new java.awt.Color(0, 51, 153));
        square6_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square6_7.setText("9");
        square6_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square6_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square6_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square6_7ActionPerformed(evt);
            }
        });
        jPanel1.add(square6_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 40, 40));

        square7_4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square7_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square7_4.setToolTipText("Enter number 1-9");
        square7_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square7_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square7_4ActionPerformed(evt);
            }
        });
        jPanel1.add(square7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 40, 40));

        square5_4.setEditable(false);
        square5_4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square5_4.setForeground(new java.awt.Color(0, 51, 153));
        square5_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square5_4.setText("2");
        square5_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square5_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square5_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square5_4ActionPerformed(evt);
            }
        });
        jPanel1.add(square5_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 40, 40));

        square7_6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square7_6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square7_6.setToolTipText("Enter number 1-9");
        square7_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square7_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square7_6ActionPerformed(evt);
            }
        });
        jPanel1.add(square7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 40, 40));

        square7_7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square7_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square7_7.setToolTipText("Enter number 1-9");
        square7_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square7_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square7_7ActionPerformed(evt);
            }
        });
        jPanel1.add(square7_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 40, 40));

        square2_7.setEditable(false);
        square2_7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        square2_7.setForeground(new java.awt.Color(0, 51, 153));
        square2_7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        square2_7.setText("5");
        square2_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        square2_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        square2_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                square2_7ActionPerformed(evt);
            }
        });
        jPanel1.add(square2_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 40, 40));

        submitButton.setText("Submit");
        submitButton.setToolTipText("Submit your solution");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
        quitButton.setToolTipText("Quit Sudoku game");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(quitButton)
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(submitButton)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(quitButton)
                        .addGap(57, 57, 57))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    /** Each ActionPerformed checks that the given
     * input for the Box is correct for the Sudoku puzzle
     * 
     * displays a dialog box if the 
     * input is not right
     * 
     * @param evt The action that caused the method
     */
    private void square6_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square6_2ActionPerformed
        if (!isGuessAcceptable(square6_2.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square6_2.setText("");
        }
    }//GEN-LAST:event_square6_2ActionPerformed

    private void square0_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square0_7ActionPerformed
        if (!isGuessAcceptable(square0_7.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square0_7.setText("");
        }
    }//GEN-LAST:event_square0_7ActionPerformed

    private void square3_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square3_8ActionPerformed
        if (!isGuessAcceptable(square3_8.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square3_8.setText("");
        }
    }//GEN-LAST:event_square3_8ActionPerformed

    private void square0_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square0_2ActionPerformed
        if (!isGuessAcceptable(square0_2.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square0_2.setText("");
        }
    }//GEN-LAST:event_square0_2ActionPerformed

    private void square5_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square5_8ActionPerformed
        if (!isGuessAcceptable(square5_8.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square5_8.setText("");
        }
    }//GEN-LAST:event_square5_8ActionPerformed

    private void square3_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square3_4ActionPerformed
        if (!isGuessAcceptable(square3_4.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square3_4.setText("");
        }
    }//GEN-LAST:event_square3_4ActionPerformed

    private void square0_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square0_4ActionPerformed
        if (!isGuessAcceptable(square0_4.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square0_4.setText("");
        }
    }//GEN-LAST:event_square0_4ActionPerformed

    private void square0_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square0_6ActionPerformed
        if (!isGuessAcceptable(square0_6.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square0_6.setText("");
        }
    }//GEN-LAST:event_square0_6ActionPerformed

    private void square0_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square0_5ActionPerformed
        if (!isGuessAcceptable(square0_5.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square0_5.setText("");
        }
    }//GEN-LAST:event_square0_5ActionPerformed

    private void square0_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square0_1ActionPerformed
        if (!isGuessAcceptable(square0_1.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square0_1.setText("");
        }
    }//GEN-LAST:event_square0_1ActionPerformed

    private void square8_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square8_2ActionPerformed
        if (!isGuessAcceptable(square8_2.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square8_2.setText("");
        }
    }//GEN-LAST:event_square8_2ActionPerformed

    private void square1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square1_1ActionPerformed
        if (!isGuessAcceptable(square1_1.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square1_1.setText("");
        }
    }//GEN-LAST:event_square1_1ActionPerformed

    private void square2_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square2_5ActionPerformed
        if (!isGuessAcceptable(square2_5.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square2_5.setText("");
        }
    }//GEN-LAST:event_square2_5ActionPerformed

    private void square1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square1_3ActionPerformed
        if (!isGuessAcceptable(square1_3.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square1_3.setText("");
        }
    }//GEN-LAST:event_square1_3ActionPerformed

    private void square1_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square1_4ActionPerformed
        if (!isGuessAcceptable(square1_4.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square1_4.setText("");
        }
    }//GEN-LAST:event_square1_4ActionPerformed

    private void square5_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square5_1ActionPerformed
        if (!isGuessAcceptable(square5_1.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square5_1.setText("");
        }
    }//GEN-LAST:event_square5_1ActionPerformed

    private void square1_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square1_5ActionPerformed
        if (!isGuessAcceptable(square1_5.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square1_5.setText("");
        }
    }//GEN-LAST:event_square1_5ActionPerformed

    private void square1_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square1_7ActionPerformed
        if (!isGuessAcceptable(square1_7.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square1_7.setText("");
        }
    }//GEN-LAST:event_square1_7ActionPerformed

    private void square1_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square1_0ActionPerformed
        if (!isGuessAcceptable(square1_0.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square1_0.setText("");
        }
    }//GEN-LAST:event_square1_0ActionPerformed

    private void square3_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square3_7ActionPerformed
        if (!isGuessAcceptable(square3_7.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square3_7.setText("");
        }
    }//GEN-LAST:event_square3_7ActionPerformed

    private void square1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square1_2ActionPerformed
        if (!isGuessAcceptable(square1_2.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square1_2.setText("");
        }
    }//GEN-LAST:event_square1_2ActionPerformed

    private void square2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square2_2ActionPerformed
        if (!isGuessAcceptable(square2_2.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square2_2.setText("");
        }
    }//GEN-LAST:event_square2_2ActionPerformed

    private void square2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square2_3ActionPerformed
        if (!isGuessAcceptable(square2_3.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square2_3.setText("");
        }
    }//GEN-LAST:event_square2_3ActionPerformed

    private void square2_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square2_4ActionPerformed
        if (!isGuessAcceptable(square2_4.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square2_4.setText("");
        }
    }//GEN-LAST:event_square2_4ActionPerformed

    private void square1_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square1_6ActionPerformed
        if (!isGuessAcceptable(square1_6.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square1_6.setText("");
        }
    }//GEN-LAST:event_square1_6ActionPerformed

    private void square2_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square2_6ActionPerformed
        if (!isGuessAcceptable(square2_6.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square2_6.setText("");
        }
    }//GEN-LAST:event_square2_6ActionPerformed

    private void square1_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square1_8ActionPerformed
        if (!isGuessAcceptable(square1_8.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square1_8.setText("");
        }
    }//GEN-LAST:event_square1_8ActionPerformed

    private void square6_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square6_1ActionPerformed
        if (!isGuessAcceptable(square6_1.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square6_1.setText("");
        }
    }//GEN-LAST:event_square6_1ActionPerformed

    private void square2_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square2_0ActionPerformed
        if (!isGuessAcceptable(square2_0.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square2_0.setText("");
        }
    }//GEN-LAST:event_square2_0ActionPerformed

    private void square3_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square3_1ActionPerformed
        if (!isGuessAcceptable(square3_1.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square3_1.setText("");
        }
    }//GEN-LAST:event_square3_1ActionPerformed

    private void square5_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square5_0ActionPerformed
        if (!isGuessAcceptable(square5_0.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square5_0.setText("");
        }
    }//GEN-LAST:event_square5_0ActionPerformed

    private void square6_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square6_0ActionPerformed
        if (!isGuessAcceptable(square6_0.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square6_0.setText("");
        }
    }//GEN-LAST:event_square6_0ActionPerformed

    private void square7_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square7_2ActionPerformed
        if (!isGuessAcceptable(square7_2.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square7_2.setText("");
        }
    }//GEN-LAST:event_square7_2ActionPerformed

    private void square3_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square3_5ActionPerformed
        if (!isGuessAcceptable(square3_5.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square3_5.setText("");
        }
    }//GEN-LAST:event_square3_5ActionPerformed

    private void square3_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square3_0ActionPerformed
        if (!isGuessAcceptable(square3_0.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square3_0.setText("");
        }
    }//GEN-LAST:event_square3_0ActionPerformed

    private void square4_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square4_8ActionPerformed
        if (!isGuessAcceptable(square4_8.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square4_8.setText("");
        }
    }//GEN-LAST:event_square4_8ActionPerformed

    private void square8_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square8_3ActionPerformed
        if (!isGuessAcceptable(square8_3.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square8_3.setText("");
        }
    }//GEN-LAST:event_square8_3ActionPerformed

    private void square3_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square3_3ActionPerformed
        if (!isGuessAcceptable(square3_3.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square3_3.setText("");
        }
    }//GEN-LAST:event_square3_3ActionPerformed

    private void square0_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square0_8ActionPerformed
        if (!isGuessAcceptable(square0_8.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square0_8.setText("");
        }
    }//GEN-LAST:event_square0_8ActionPerformed

    private void square5_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square5_2ActionPerformed
        if (!isGuessAcceptable(square5_2.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square5_2.setText("");
        }
    }//GEN-LAST:event_square5_2ActionPerformed

    private void square2_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square2_8ActionPerformed
        if (!isGuessAcceptable(square2_8.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square2_8.setText("");
        }
    }//GEN-LAST:event_square2_8ActionPerformed

    private void square4_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square4_0ActionPerformed
        if (!isGuessAcceptable(square4_0.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square4_0.setText("");
        }
    }//GEN-LAST:event_square4_0ActionPerformed

    private void square4_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square4_1ActionPerformed
        if (!isGuessAcceptable(square4_1.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square4_1.setText("");
        }
    }//GEN-LAST:event_square4_1ActionPerformed

    private void square4_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square4_2ActionPerformed
        if (!isGuessAcceptable(square4_2.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square4_2.setText("");
        }
    }//GEN-LAST:event_square4_2ActionPerformed

    private void square3_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square3_6ActionPerformed
        if (!isGuessAcceptable(square3_6.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square3_6.setText("");
        }
    }//GEN-LAST:event_square3_6ActionPerformed

    private void square5_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square5_5ActionPerformed
        if (!isGuessAcceptable(square5_5.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square5_5.setText("");
        }
    }//GEN-LAST:event_square5_5ActionPerformed

    private void square4_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square4_5ActionPerformed
        if (!isGuessAcceptable(square4_5.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square4_5.setText("");
        }
    }//GEN-LAST:event_square4_5ActionPerformed

    private void square4_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square4_6ActionPerformed
        if (!isGuessAcceptable(square4_6.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square4_6.setText("");
        }
    }//GEN-LAST:event_square4_6ActionPerformed

    private void square5_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square5_7ActionPerformed
        if (!isGuessAcceptable(square5_7.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square5_7.setText("");
        }
    }//GEN-LAST:event_square5_7ActionPerformed

    private void square0_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square0_3ActionPerformed
        if (!isGuessAcceptable(square0_3.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square0_3.setText("");
        }
    }//GEN-LAST:event_square0_3ActionPerformed

    private void square0_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square0_0ActionPerformed
        if (!isGuessAcceptable(square0_0.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square0_0.setText("");
        }
    }//GEN-LAST:event_square0_0ActionPerformed

    private void square4_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square4_3ActionPerformed
        if (!isGuessAcceptable(square4_3.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square4_3.setText("");
        }
    }//GEN-LAST:event_square4_3ActionPerformed

    private void square4_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square4_4ActionPerformed
        if (!isGuessAcceptable(square4_4.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square4_4.setText("");
        }
    }//GEN-LAST:event_square4_4ActionPerformed

    private void square6_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square6_8ActionPerformed
        if (!isGuessAcceptable(square6_8.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square6_8.setText("");
        }
    }//GEN-LAST:event_square6_8ActionPerformed

    private void square2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square2_1ActionPerformed
        if (!isGuessAcceptable(square2_1.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square2_1.setText("");
        }
    }//GEN-LAST:event_square2_1ActionPerformed

    private void square8_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square8_0ActionPerformed
        if (!isGuessAcceptable(square8_0.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square8_0.setText("");
        }
    }//GEN-LAST:event_square8_0ActionPerformed

    private void square4_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square4_7ActionPerformed
        if (!isGuessAcceptable(square4_7.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square4_7.setText("");
        }
    }//GEN-LAST:event_square4_7ActionPerformed

    private void square8_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square8_8ActionPerformed
        if (!isGuessAcceptable(square8_8.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square8_8.setText("");
        }
    }//GEN-LAST:event_square8_8ActionPerformed

    private void square8_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square8_5ActionPerformed
        if (!isGuessAcceptable(square8_5.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square8_5.setText("");
        }
    }//GEN-LAST:event_square8_5ActionPerformed

    private void square5_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square5_3ActionPerformed
        if (!isGuessAcceptable(square5_3.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square5_3.setText("");
        }
    }//GEN-LAST:event_square5_3ActionPerformed

    private void square7_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square7_3ActionPerformed
        if (!isGuessAcceptable(square7_3.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square7_3.setText("");
        }
    }//GEN-LAST:event_square7_3ActionPerformed

    private void square8_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square8_4ActionPerformed
        if (!isGuessAcceptable(square8_4.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square8_4.setText("");
        }
    }//GEN-LAST:event_square8_4ActionPerformed

    private void square7_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square7_5ActionPerformed
        if (!isGuessAcceptable(square7_5.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square7_5.setText("");
        }
    }//GEN-LAST:event_square7_5ActionPerformed

    private void square3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square3_2ActionPerformed
        if (!isGuessAcceptable(square3_2.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square3_2.setText("");
        }
    }//GEN-LAST:event_square3_2ActionPerformed

    private void square7_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square7_8ActionPerformed
        if (!isGuessAcceptable(square7_8.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square7_8.setText("");
        }
    }//GEN-LAST:event_square7_8ActionPerformed

    private void square7_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square7_0ActionPerformed
        if (!isGuessAcceptable(square7_0.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square7_0.setText("");
        }
    }//GEN-LAST:event_square7_0ActionPerformed

    private void square5_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square5_6ActionPerformed
        if (!isGuessAcceptable(square5_6.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square5_6.setText("");
        }
    }//GEN-LAST:event_square5_6ActionPerformed

    private void square6_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square6_3ActionPerformed
        if (!isGuessAcceptable(square6_3.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square6_3.setText("");
        }
    }//GEN-LAST:event_square6_3ActionPerformed

    private void square6_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square6_4ActionPerformed
        if (!isGuessAcceptable(square6_4.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square6_4.setText("");
        }
    }//GEN-LAST:event_square6_4ActionPerformed

    private void square6_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square6_5ActionPerformed
        if (!isGuessAcceptable(square6_5.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square6_5.setText("");
        }
    }//GEN-LAST:event_square6_5ActionPerformed

    private void square6_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square6_6ActionPerformed
        if (!isGuessAcceptable(square6_6.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square6_6.setText("");
        }
    }//GEN-LAST:event_square6_6ActionPerformed

    private void square8_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square8_6ActionPerformed
        if (!isGuessAcceptable(square8_6.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square8_6.setText("");
        }
    }//GEN-LAST:event_square8_6ActionPerformed

    private void square8_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square8_7ActionPerformed
        if (!isGuessAcceptable(square8_7.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square8_7.setText("");
        }
    }//GEN-LAST:event_square8_7ActionPerformed

    private void square7_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square7_1ActionPerformed
        if (!isGuessAcceptable(square7_1.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square7_1.setText("");
        }
    }//GEN-LAST:event_square7_1ActionPerformed

    private void square8_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square8_1ActionPerformed
        if (!isGuessAcceptable(square8_1.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square8_1.setText("");
        }
    }//GEN-LAST:event_square8_1ActionPerformed

    private void square6_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square6_7ActionPerformed
        if (!isGuessAcceptable(square6_7.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square6_7.setText("");
        }
    }//GEN-LAST:event_square6_7ActionPerformed

    private void square7_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square7_4ActionPerformed
        if (!isGuessAcceptable(square7_4.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square7_4.setText("");
        }
    }//GEN-LAST:event_square7_4ActionPerformed

    private void square5_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square5_4ActionPerformed
        if (!isGuessAcceptable(square5_4.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square5_4.setText("");
        }
    }//GEN-LAST:event_square5_4ActionPerformed

    private void square7_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square7_6ActionPerformed
        if (!isGuessAcceptable(square7_6.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square7_6.setText("");
        }
    }//GEN-LAST:event_square7_6ActionPerformed

    private void square7_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square7_7ActionPerformed
        if (!isGuessAcceptable(square7_7.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square7_7.setText("");
        }
    }//GEN-LAST:event_square7_7ActionPerformed

    private void square2_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_square2_7ActionPerformed
        if (!isGuessAcceptable(square2_7.getText())) {
            JOptionPane.showMessageDialog(null, "You must input a number from 1 to 9", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
            square2_7.setText("");
        }
    }//GEN-LAST:event_square2_7ActionPerformed

    /** The actions of after the submit button is pressed:
     * checks that the board is correct, and if not, 
     * recreates the puzzle board. 
     * Also checks that the runs is first or not, and if the 
     * high score is high enough to be added
     * 
     * @param evt the action event that causes the method
     */
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        isFirstRun = false; 
        boolean b = checkGameBoard();
        if (b == true) { // if game is won, give an option to enter high score

            JOptionPane.showMessageDialog(null, "Correct solution!!!",
                    "Correct", JOptionPane.INFORMATION_MESSAGE);

            p.setScore(p.getScore() + sudokuScore);
            p.recordPlayerScore();

            EndScreen end = new EndScreen((p.getScore() > lowestHS));
            end.show();
            this.dispose();

        } else { // solution is wrong
            // alert user submitted solution is wrong
            JOptionPane.showMessageDialog(null, "Incorrect solution, please try again.",
                    "Incorrect!", JOptionPane.ERROR_MESSAGE);

            //show a new Sudoku game
            Sudoku s = new Sudoku(p, hsc);
            s.show();
            this.dispose();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    /**Method called when quit button is pressed. 
     * sets sudoku game score to 0 if first run, 
     * but gives remaining points in next rounds
     * 
     * @param evt action that causes method to be called
     */
    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed

        if (isFirstRun) { // if they first run, no points given if they quit
            sudokuScore = 0;
        }
        p.setScore(p.getScore() + sudokuScore);
        sudokuScore = 540;
        p.recordPlayerScore();

        EndScreen end = new EndScreen((p.getScore() > lowestHS));
        end.show();
        this.dispose();

    }//GEN-LAST:event_quitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sudoku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sudoku(p, hsc).setVisible(true);

            }
        });
    }

    /** Checks that the guess given into a text area 
     * is correct
     * @param guess A string that contains the input guess
     * @return True if the string is acceptable, false if not
     */
    private boolean isGuessAcceptable(String guess) {
        HashSet<String> acceptableInputs = new HashSet<String>(9);
        acceptableInputs.add("1");
        acceptableInputs.add("2");
        acceptableInputs.add("3");
        acceptableInputs.add("4");
        acceptableInputs.add("5");
        acceptableInputs.add("6");
        acceptableInputs.add("7");
        acceptableInputs.add("8");
        acceptableInputs.add("9");

        return acceptableInputs.contains(guess);

    }

    /** Checks the inputs that the user made
     * in the sudoku game if it is correct!
     * keeps track of the boxes that are already guessed
     * 
     * @return false if the board is not correct, true if it is
     */
    private boolean checkGameBoard() {
        int numCorrectSquares = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (gameBoard[i][j].getText().equals(sudokuKey[i][j])) {
                    System.out.println("correct");
                    numCorrectSquares++;
                } else {
                    if (!hasSquareBeenGuessed[i][j]) {
                        sudokuScore = sudokuScore - 10;
                        hasSquareBeenGuessed[i][j] = true;
                    }
                }
            }
        }

        return numCorrectSquares == 81;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton quitButton;
    private javax.swing.JTextField square0_0;
    private javax.swing.JTextField square0_1;
    private javax.swing.JTextField square0_2;
    private javax.swing.JTextField square0_3;
    private javax.swing.JTextField square0_4;
    private javax.swing.JTextField square0_5;
    private javax.swing.JTextField square0_6;
    private javax.swing.JTextField square0_7;
    private javax.swing.JTextField square0_8;
    private javax.swing.JTextField square1_0;
    private javax.swing.JTextField square1_1;
    private javax.swing.JTextField square1_2;
    private javax.swing.JTextField square1_3;
    private javax.swing.JTextField square1_4;
    private javax.swing.JTextField square1_5;
    private javax.swing.JTextField square1_6;
    private javax.swing.JTextField square1_7;
    private javax.swing.JTextField square1_8;
    private javax.swing.JTextField square2_0;
    private javax.swing.JTextField square2_1;
    private javax.swing.JTextField square2_2;
    private javax.swing.JTextField square2_3;
    private javax.swing.JTextField square2_4;
    private javax.swing.JTextField square2_5;
    private javax.swing.JTextField square2_6;
    private javax.swing.JTextField square2_7;
    private javax.swing.JTextField square2_8;
    private javax.swing.JTextField square3_0;
    private javax.swing.JTextField square3_1;
    private javax.swing.JTextField square3_2;
    private javax.swing.JTextField square3_3;
    private javax.swing.JTextField square3_4;
    private javax.swing.JTextField square3_5;
    private javax.swing.JTextField square3_6;
    private javax.swing.JTextField square3_7;
    private javax.swing.JTextField square3_8;
    private javax.swing.JTextField square4_0;
    private javax.swing.JTextField square4_1;
    private javax.swing.JTextField square4_2;
    private javax.swing.JTextField square4_3;
    private javax.swing.JTextField square4_4;
    private javax.swing.JTextField square4_5;
    private javax.swing.JTextField square4_6;
    private javax.swing.JTextField square4_7;
    private javax.swing.JTextField square4_8;
    private javax.swing.JTextField square5_0;
    private javax.swing.JTextField square5_1;
    private javax.swing.JTextField square5_2;
    private javax.swing.JTextField square5_3;
    private javax.swing.JTextField square5_4;
    private javax.swing.JTextField square5_5;
    private javax.swing.JTextField square5_6;
    private javax.swing.JTextField square5_7;
    private javax.swing.JTextField square5_8;
    private javax.swing.JTextField square6_0;
    private javax.swing.JTextField square6_1;
    private javax.swing.JTextField square6_2;
    private javax.swing.JTextField square6_3;
    private javax.swing.JTextField square6_4;
    private javax.swing.JTextField square6_5;
    private javax.swing.JTextField square6_6;
    private javax.swing.JTextField square6_7;
    private javax.swing.JTextField square6_8;
    private javax.swing.JTextField square7_0;
    private javax.swing.JTextField square7_1;
    private javax.swing.JTextField square7_2;
    private javax.swing.JTextField square7_3;
    private javax.swing.JTextField square7_4;
    private javax.swing.JTextField square7_5;
    private javax.swing.JTextField square7_6;
    private javax.swing.JTextField square7_7;
    private javax.swing.JTextField square7_8;
    private javax.swing.JTextField square8_0;
    private javax.swing.JTextField square8_1;
    private javax.swing.JTextField square8_2;
    private javax.swing.JTextField square8_3;
    private javax.swing.JTextField square8_4;
    private javax.swing.JTextField square8_5;
    private javax.swing.JTextField square8_6;
    private javax.swing.JTextField square8_7;
    private javax.swing.JTextField square8_8;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
