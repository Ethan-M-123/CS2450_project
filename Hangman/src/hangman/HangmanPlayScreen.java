/***************************************************************  
*  file: HangmanPlayScreen.java
*  author: M. Sevilla; Shane; Simon
*  class: CS 2450.01  
*  
*  assignment: Project V1.3 
*  date last modified: 10/10/2022
*  
*  purpose: Displays the controls for the user to play the game as well as the
*  functions and calls necessary to pass on the player's score onto the 
*  color picker game.
*  
****************************************************************/  


package hangman;


import java.util.Date;
import java.util.Calendar;
import java.awt.event.*;
import java.util.Arrays;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.*;
import java.util.*;
import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class HangmanPlayScreen extends javax.swing.JFrame{

    
    /**
     * Creates new form NewJFrame
     */
    
    GetGuessWord guessWord = new GetGuessWord();
    String currWord;
    String displayedWord;
    int score;
    int numWrongAnswers;
    int numRightAnswers;
    ImageIcon[] hangManParts;
    static HighscoresController hsc;
    
    
    //Constructor
    //purpose: Initiates the components of the game panel, 
    //      and the panel's size
    public HangmanPlayScreen(HighscoresController hsc) {
        initComponents();
        this.setSize(600, 400);
        this.hsc = hsc;
        
        // Refreshes the displayed time and date on the top right of the screen
        new Thread(){
            public void run(){
                while(true){
                   label_currTimeandDate.setText(Calendar.getInstance().getTime().toString());
                }
            }
        }.start();
        
        currWord = guessWord.getCurrentWord();          //the word to be guessed
        displayedWord = guessWord.getCurrWordHidden();  //the dashes that indicate the number of letters in the word
        label_GuessWord.setText(displayedWord);
        score = 100;
        scoreLabel.setText("Score: " + score);
        

        // Add code to exit game
        label_HANGMAN.getInputMap(WHEN_IN_FOCUSED_WINDOW)
               .put(KeyStroke.getKeyStroke("ESCAPE"), "escapeGame");
        label_HANGMAN.getActionMap().put("escapeGame", new LeaveGame());
        
        //F1 key display
        label_HANGMAN.getInputMap(WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("F1"), "displayInfo");
        label_HANGMAN.getActionMap().put("displayInfo", new DisplayInfo());

        
        
        ImageIcon empty = new ImageIcon("src/HangmanPictures/hangEmpty.png");
        ImageIcon oneLimb = new ImageIcon("src/HangmanPictures/hang1.png");
        ImageIcon twoLimbs = new ImageIcon("src/HangmanPictures/hang2.png");
        ImageIcon threeLimbs = new ImageIcon("src/HangmanPictures/hang3.png");
        ImageIcon fourLimbs = new ImageIcon("src/HangmanPictures/hang4.png");
        ImageIcon fiveLimbs = new ImageIcon("src/HangmanPictures/hang5.png");
        ImageIcon sixLimbs = new ImageIcon("src/HangmanPictures/hang6.png");
        
        jLabel1.setIcon(empty);
        
        hangManParts = new ImageIcon[]{oneLimb, twoLimbs, threeLimbs, fourLimbs, fiveLimbs, sixLimbs};
        
        /* Set the tool tip text for all relevant interactive elements */ 
        btn_GetNewWord.setToolTipText("Change the current word you're guessing without penalty");
        btn_Skip.setToolTipText("Skip to the color guessing game with 0 points awarded");
        buttonA.setToolTipText("Guess there's a letter \"A\" in the current word");
        buttonB.setToolTipText("Guess there's a letter \"B\" in the current word");
        buttonC.setToolTipText("Guess there's a letter \"C\" in the current word");
        buttonD.setToolTipText("Guess there's a letter \"D\" in the current word");
        buttonE.setToolTipText("Guess there's a letter \"E\" in the current word");
        buttonF.setToolTipText("Guess there's a letter \"F\" in the current word");
        buttonG.setToolTipText("Guess there's a letter \"G\" in the current word");
        buttonH.setToolTipText("Guess there's a letter \"H\" in the current word");
        buttonI.setToolTipText("Guess there's a letter \"I\" in the current word");
        buttonJ.setToolTipText("Guess there's a letter \"J\" in the current word");
        buttonK.setToolTipText("Guess there's a letter \"K\" in the current word");
        buttonL.setToolTipText("Guess there's a letter \"L\" in the current word");
        buttonM.setToolTipText("Guess there's a letter \"M\" in the current word");
        buttonN.setToolTipText("Guess there's a letter \"N\" in the current word");
        buttonO.setToolTipText("Guess there's a letter \"O\" in the current word");
        buttonP.setToolTipText("Guess there's a letter \"P\" in the current word");
        buttonQ.setToolTipText("Guess there's a letter \"Q\" in the current word");
        buttonR.setToolTipText("Guess there's a letter \"R\" in the current word");
        buttonS.setToolTipText("Guess there's a letter \"S\" in the current word");
        buttonT.setToolTipText("Guess there's a letter \"T\" in the current word");
        buttonU.setToolTipText("Guess there's a letter \"U\" in the current word");
        buttonV.setToolTipText("Guess there's a letter \"V\" in the current word");
        buttonW.setToolTipText("Guess there's a letter \"W\" in the current word");
        buttonX.setToolTipText("Guess there's a letter \"X\" in the current word");
        buttonY.setToolTipText("Guess there's a letter \"Y\" in the current word");
        buttonZ.setToolTipText("Guess there's a letter \"Z\" in the current word");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_HANGMAN = new javax.swing.JLabel();
        label_currTimeandDate = new javax.swing.JLabel();
        label_GuessWord = new javax.swing.JLabel();
        btn_GetNewWord = new javax.swing.JButton();
        buttonA = new javax.swing.JButton();
        buttonB = new javax.swing.JButton();
        buttonC = new javax.swing.JButton();
        buttonD = new javax.swing.JButton();
        buttonE = new javax.swing.JButton();
        buttonF = new javax.swing.JButton();
        buttonG = new javax.swing.JButton();
        buttonH = new javax.swing.JButton();
        buttonI = new javax.swing.JButton();
        buttonJ = new javax.swing.JButton();
        buttonK = new javax.swing.JButton();
        buttonL = new javax.swing.JButton();
        buttonM = new javax.swing.JButton();
        buttonN = new javax.swing.JButton();
        buttonO = new javax.swing.JButton();
        buttonP = new javax.swing.JButton();
        buttonQ = new javax.swing.JButton();
        buttonR = new javax.swing.JButton();
        buttonS = new javax.swing.JButton();
        buttonT = new javax.swing.JButton();
        buttonU = new javax.swing.JButton();
        buttonV = new javax.swing.JButton();
        buttonW = new javax.swing.JButton();
        buttonX = new javax.swing.JButton();
        buttonY = new javax.swing.JButton();
        buttonZ = new javax.swing.JButton();
        scoreLabel = new javax.swing.JLabel();
        btn_Skip = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HangmanPictures/hangEmpty.png"))); // NOI18N

        label_HANGMAN.setFont(new java.awt.Font("SWIsop3", 2, 24)); // NOI18N
        label_HANGMAN.setText("HANGMAN  ");

        label_currTimeandDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_currTimeandDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_currTimeandDate.setText("Month Day, Year");

        label_GuessWord.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        label_GuessWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_GuessWord.setText("_ _ _ _ _");

        btn_GetNewWord.setText("Get New Word");
        btn_GetNewWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GetNewWordActionPerformed(evt);
            }
        });

        buttonA.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonA.setText("A");
        buttonA.setAlignmentY(0.0F);
        buttonA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonA.setIconTextGap(0);
        buttonA.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonA.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonA.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonA.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAActionPerformed(evt);
            }
        });

        buttonB.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonB.setText("B");
        buttonB.setAlignmentY(0.0F);
        buttonB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonB.setIconTextGap(0);
        buttonB.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonB.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonB.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonB.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBActionPerformed(evt);
            }
        });

        buttonC.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonC.setText("C");
        buttonC.setAlignmentY(0.0F);
        buttonC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonC.setIconTextGap(0);
        buttonC.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonC.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonC.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonC.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCActionPerformed(evt);
            }
        });

        buttonD.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonD.setText("D");
        buttonD.setAlignmentY(0.0F);
        buttonD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonD.setIconTextGap(0);
        buttonD.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonD.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonD.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonD.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDActionPerformed(evt);
            }
        });

        buttonE.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonE.setText("E");
        buttonE.setAlignmentY(0.0F);
        buttonE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonE.setIconTextGap(0);
        buttonE.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonE.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonE.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonE.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEActionPerformed(evt);
            }
        });

        buttonF.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonF.setText("F");
        buttonF.setAlignmentY(0.0F);
        buttonF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonF.setIconTextGap(0);
        buttonF.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonF.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonF.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonF.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFActionPerformed(evt);
            }
        });

        buttonG.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonG.setText("G");
        buttonG.setAlignmentY(0.0F);
        buttonG.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonG.setIconTextGap(0);
        buttonG.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonG.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonG.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonG.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGActionPerformed(evt);
            }
        });

        buttonH.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonH.setText("H");
        buttonH.setAlignmentY(0.0F);
        buttonH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonH.setIconTextGap(0);
        buttonH.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonH.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonH.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonH.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHActionPerformed(evt);
            }
        });

        buttonI.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonI.setText("I");
        buttonI.setAlignmentY(0.0F);
        buttonI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonI.setIconTextGap(0);
        buttonI.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonI.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonI.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonI.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIActionPerformed(evt);
            }
        });

        buttonJ.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonJ.setText("J");
        buttonJ.setAlignmentY(0.0F);
        buttonJ.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonJ.setIconTextGap(0);
        buttonJ.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonJ.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonJ.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonJ.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJActionPerformed(evt);
            }
        });

        buttonK.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonK.setText("K");
        buttonK.setAlignmentY(0.0F);
        buttonK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonK.setIconTextGap(0);
        buttonK.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonK.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonK.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonK.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKActionPerformed(evt);
            }
        });

        buttonL.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonL.setText("L");
        buttonL.setAlignmentY(0.0F);
        buttonL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonL.setIconTextGap(0);
        buttonL.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonL.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonL.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonL.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLActionPerformed(evt);
            }
        });

        buttonM.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonM.setText("M");
        buttonM.setAlignmentY(0.0F);
        buttonM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonM.setIconTextGap(0);
        buttonM.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonM.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonM.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonM.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMActionPerformed(evt);
            }
        });

        buttonN.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonN.setText("N");
        buttonN.setAlignmentY(0.0F);
        buttonN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonN.setIconTextGap(0);
        buttonN.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonN.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonN.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonN.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNActionPerformed(evt);
            }
        });

        buttonO.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonO.setText("O");
        buttonO.setAlignmentY(0.0F);
        buttonO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonO.setIconTextGap(0);
        buttonO.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonO.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonO.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonO.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOActionPerformed(evt);
            }
        });

        buttonP.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonP.setText("P");
        buttonP.setAlignmentY(0.0F);
        buttonP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonP.setIconTextGap(0);
        buttonP.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonP.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonP.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonP.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPActionPerformed(evt);
            }
        });

        buttonQ.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonQ.setText("Q");
        buttonQ.setAlignmentY(0.0F);
        buttonQ.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonQ.setIconTextGap(0);
        buttonQ.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonQ.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonQ.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonQ.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQActionPerformed(evt);
            }
        });

        buttonR.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonR.setText("R");
        buttonR.setAlignmentY(0.0F);
        buttonR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonR.setIconTextGap(0);
        buttonR.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonR.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonR.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonR.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRActionPerformed(evt);
            }
        });

        buttonS.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonS.setText("S");
        buttonS.setAlignmentY(0.0F);
        buttonS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonS.setIconTextGap(0);
        buttonS.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonS.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonS.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonS.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSActionPerformed(evt);
            }
        });

        buttonT.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonT.setText("T");
        buttonT.setAlignmentY(0.0F);
        buttonT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonT.setIconTextGap(0);
        buttonT.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonT.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonT.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonT.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTActionPerformed(evt);
            }
        });

        buttonU.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonU.setText("U");
        buttonU.setAlignmentY(0.0F);
        buttonU.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonU.setIconTextGap(0);
        buttonU.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonU.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonU.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonU.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUActionPerformed(evt);
            }
        });

        buttonV.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonV.setText("V");
        buttonV.setAlignmentY(0.0F);
        buttonV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonV.setIconTextGap(0);
        buttonV.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonV.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonV.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonV.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVActionPerformed(evt);
            }
        });

        buttonW.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonW.setText("W");
        buttonW.setAlignmentY(0.0F);
        buttonW.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonW.setIconTextGap(0);
        buttonW.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonW.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonW.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonW.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWActionPerformed(evt);
            }
        });

        buttonX.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonX.setText("X");
        buttonX.setAlignmentY(0.0F);
        buttonX.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonX.setIconTextGap(0);
        buttonX.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonX.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonX.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonX.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXActionPerformed(evt);
            }
        });

        buttonY.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonY.setText("Y");
        buttonY.setAlignmentY(0.0F);
        buttonY.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonY.setIconTextGap(0);
        buttonY.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonY.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonY.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonY.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYActionPerformed(evt);
            }
        });

        buttonZ.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        buttonZ.setText("Z");
        buttonZ.setAlignmentY(0.0F);
        buttonZ.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonZ.setIconTextGap(0);
        buttonZ.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buttonZ.setMaximumSize(new java.awt.Dimension(50, 50));
        buttonZ.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonZ.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonZActionPerformed(evt);
            }
        });

        scoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        scoreLabel.setText("Score: 100");

        btn_Skip.setText("Skip!");
        btn_Skip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SkipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(label_HANGMAN, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_currTimeandDate, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_GuessWord, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(buttonA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_GetNewWord, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Skip, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG, buttonH, buttonI, buttonJ, buttonK, buttonL, buttonN, buttonO, buttonP, buttonQ, buttonR, buttonS, buttonT, buttonU, buttonV, buttonW, buttonX, buttonY, buttonZ});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_HANGMAN)
                            .addComponent(label_currTimeandDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_GetNewWord, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Skip, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_GuessWord, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG, buttonH, buttonI, buttonJ, buttonK, buttonL, buttonM, buttonN, buttonO, buttonP, buttonQ, buttonR, buttonS, buttonT, buttonU, buttonV, buttonW, buttonX, buttonY, buttonZ});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // method: btn_SkipActionPerformed()
    // purpose: If the player presses the "Skip!" button, their score is set to 
    // 0 and the "end" screen is displayed while the play screen is closed
    private void btn_SkipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SkipActionPerformed
        score = 0;
        Player p = new Player("ABC", score);
        
        ColorPickerGame colorGame = new ColorPickerGame(p,hsc);
        this.dispose();
    }//GEN-LAST:event_btn_SkipActionPerformed

    

    //purpose: when a letter button is pressed it runs the checkGuess() method with the 
    //corresponding letter as a paramater, disables the selected button, and 
    //changes the color of the button to indicate it is disabled
    private void buttonZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonZActionPerformed
        checkGuess('z');
        buttonZ.setEnabled(false);
        buttonZ.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonZActionPerformed

    private void buttonYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYActionPerformed
        checkGuess('y');
        buttonY.setEnabled(false);
        buttonY.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonYActionPerformed

    private void buttonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXActionPerformed
        checkGuess('x');
        buttonX.setEnabled(false);
        buttonX.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonXActionPerformed

    private void buttonWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWActionPerformed
        checkGuess('w');
        buttonW.setEnabled(false);
        buttonW.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonWActionPerformed

    private void buttonVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVActionPerformed
        checkGuess('v');
        buttonV.setEnabled(false);
        buttonV.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonVActionPerformed

    private void buttonUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUActionPerformed
        checkGuess('u');
        buttonU.setEnabled(false);
        buttonU.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonUActionPerformed

    private void buttonTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTActionPerformed
        checkGuess('t');
        buttonT.setEnabled(false);
        buttonT.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonTActionPerformed

    private void buttonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSActionPerformed
        checkGuess('s');
        buttonS.setEnabled(false);
        buttonS.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonSActionPerformed

    private void buttonRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRActionPerformed
        checkGuess('r');
        buttonR.setEnabled(false);
        buttonR.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonRActionPerformed

    private void buttonQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQActionPerformed
        checkGuess('q');
        buttonQ.setEnabled(false);
        buttonQ.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonQActionPerformed

    private void buttonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPActionPerformed
        checkGuess('p');
        buttonP.setEnabled(false);
        buttonP.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonPActionPerformed

    private void buttonOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOActionPerformed
        checkGuess('o');
        buttonO.setEnabled(false);
        buttonO.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonOActionPerformed

    private void buttonNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNActionPerformed
        checkGuess('n');
        buttonN.setEnabled(false);
        buttonN.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonNActionPerformed

    private void buttonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMActionPerformed
        checkGuess('m');
        buttonM.setEnabled(false);
        buttonM.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonMActionPerformed

    private void buttonLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLActionPerformed
        checkGuess('l');
        buttonL.setEnabled(false);
        buttonL.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonLActionPerformed

    private void buttonKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKActionPerformed
        checkGuess('k');
        buttonK.setEnabled(false);
        buttonK.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonKActionPerformed

    private void buttonJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJActionPerformed
        checkGuess('j');
        buttonJ.setEnabled(false);
        buttonJ.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonJActionPerformed

    private void buttonIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIActionPerformed
        checkGuess('i');
        buttonI.setEnabled(false);
        buttonI.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonIActionPerformed

    private void buttonHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHActionPerformed
        checkGuess('h');
        buttonH.setEnabled(false);
        buttonH.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonHActionPerformed

    private void buttonGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGActionPerformed
        checkGuess('g');
        buttonG.setEnabled(false);
        buttonG.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonGActionPerformed

    private void buttonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFActionPerformed
        checkGuess('f');
        buttonF.setEnabled(false);
        buttonF.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonFActionPerformed

    private void buttonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEActionPerformed
        checkGuess('e');
        buttonE.setEnabled(false);
        buttonE.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonEActionPerformed

    private void buttonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDActionPerformed
        checkGuess('d');
        buttonD.setEnabled(false);
        buttonD.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonDActionPerformed

    private void buttonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCActionPerformed
        checkGuess('c');
        buttonC.setEnabled(false);
        buttonC.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonCActionPerformed

    private void buttonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBActionPerformed
        checkGuess('b');
        buttonB.setEnabled(false);
        buttonB.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonBActionPerformed

    private void buttonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAActionPerformed
        checkGuess('a');
        buttonA.setEnabled(false);
        buttonA.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_buttonAActionPerformed

    
    //method: btn_GetNewWordActionPerformed
    //purpose: When the get new word button is pressed the word to be guessed is randomly
    //chosen again, the displayed letter and hangman are reset, and all letter
    //buttons are re-enabled and colored white again
    private void btn_GetNewWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GetNewWordActionPerformed
        guessWord.getNewWord();
        this.currWord = guessWord.getCurrentWord();
        this.displayedWord = guessWord.getCurrWordHidden();
        label_GuessWord.setText(displayedWord);
        numRightAnswers = 0;
        numWrongAnswers = 0;

        buttonA.setEnabled(true);
        buttonA.setBackground(java.awt.Color.WHITE);
        buttonB.setEnabled(true);
        buttonB.setBackground(java.awt.Color.WHITE);
        buttonC.setEnabled(true);
        buttonC.setBackground(java.awt.Color.WHITE);
        buttonD.setEnabled(true);
        buttonD.setBackground(java.awt.Color.WHITE);
        buttonE.setEnabled(true);
        buttonE.setBackground(java.awt.Color.WHITE);
        buttonF.setEnabled(true);
        buttonF.setBackground(java.awt.Color.WHITE);
        buttonG.setEnabled(true);
        buttonG.setBackground(java.awt.Color.WHITE);
        buttonH.setEnabled(true);
        buttonH.setBackground(java.awt.Color.WHITE);
        buttonI.setEnabled(true);
        buttonI.setBackground(java.awt.Color.WHITE);
        buttonJ.setEnabled(true);
        buttonJ.setBackground(java.awt.Color.WHITE);
        buttonK.setEnabled(true);
        buttonK.setBackground(java.awt.Color.WHITE);
        buttonL.setEnabled(true);
        buttonL.setBackground(java.awt.Color.WHITE);
        buttonM.setEnabled(true);
        buttonM.setBackground(java.awt.Color.WHITE);
        buttonN.setEnabled(true);
        buttonN.setBackground(java.awt.Color.WHITE);
        buttonO.setEnabled(true);
        buttonO.setBackground(java.awt.Color.WHITE);
        buttonP.setEnabled(true);
        buttonP.setBackground(java.awt.Color.WHITE);
        buttonQ.setEnabled(true);
        buttonQ.setBackground(java.awt.Color.WHITE);
        buttonR.setEnabled(true);
        buttonR.setBackground(java.awt.Color.WHITE);
        buttonS.setEnabled(true);
        buttonS.setBackground(java.awt.Color.WHITE);
        buttonT.setEnabled(true);
        buttonT.setBackground(java.awt.Color.WHITE);
        buttonU.setEnabled(true);
        buttonU.setBackground(java.awt.Color.WHITE);
        buttonV.setEnabled(true);
        buttonV.setBackground(java.awt.Color.WHITE);
        buttonW.setEnabled(true);
        buttonW.setBackground(java.awt.Color.WHITE);
        buttonX.setEnabled(true);
        buttonX.setBackground(java.awt.Color.WHITE);
        buttonY.setEnabled(true);
        buttonY.setBackground(java.awt.Color.WHITE);
        buttonZ.setEnabled(true);
        buttonZ.setBackground(java.awt.Color.WHITE);
    }//GEN-LAST:event_btn_GetNewWordActionPerformed

    // method: recordPlayerScore()
    // purpose: records the player's last score in the format of "lastScore <score>"
    // to LastScore.txt which is later used by the Highscores screen
//     private void recordPlayerScore()
//    {
//        try
//        {
//            FileWriter write = new FileWriter(".\\src\\hangman\\LastScore.txt");
//
//            write.write("lastScore " + score);
//            write.close();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    } 
    
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
            java.util.logging.Logger.getLogger(HangmanPlayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HangmanPlayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HangmanPlayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HangmanPlayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                HangmanPlayScreen s = new HangmanPlayScreen(hsc);
                s.setVisible(true);
                
                

                //s.label_currTimeandDate.setText(Calendar.getInstance().getTime().toString());
            }
        });
    }
    
    
    
    //method: checkGuess
    //purpose: Checks if the guessed letter is in the current word to be guessed, if the
    //guess is correct the letter is displayed and replaces each dash that was 
    //hiding it and the number of right answers is increased. If the player has
    //finished the word then the end screen is displayed. If the guess is incorrect
    //the player is notified that they made an incorrect guess and their score is
    //decreased by 10.
    private void checkGuess(char guessedLetter){
        char[] correctChars = this.currWord.toCharArray();
        int[] correctGuessIndexes = new int[correctChars.length * 2];
        boolean isGuessCorrect = false;
        
        for(int i=0; i<correctChars.length; i++){
            if(guessedLetter == correctChars[i]){
                correctGuessIndexes[i*2] =1;    
                isGuessCorrect = true;
            }
        }
        
        if(isGuessCorrect)
        {
            char[] newDisplay = label_GuessWord.getText().toCharArray();
            
            for(int i=0; i<newDisplay.length; i++)
            {
                if(correctGuessIndexes[i] == 1)
                {
                    newDisplay[i] = currWord.toCharArray()[i/2];
                    numRightAnswers++;
                }
                
                label_GuessWord.setText(new String(newDisplay));
            }
            
            if (numRightAnswers == currWord.length())
            {
                //recordPlayerScore();
                //EndScreen endPage = new EndScreen();
                //endPage.show();
                Player p = new Player("ABC", score);
                ColorPickerGame colorGame = new ColorPickerGame(p,hsc);
                this.dispose();
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Wrong Guess! -10 points", "Wrong!", JOptionPane.ERROR_MESSAGE);
            score = score - 10;
            scoreLabel.setText("Score: " + score);
            jLabel1.setIcon(this.hangManParts[numWrongAnswers]);
            numWrongAnswers++;
            
            if((score<0) || (numWrongAnswers==6))
            {
                //recordPlayerScore();
                //EndScreen endPage = new EndScreen();
                //endPage.show();
                Player p = new Player("ABC", score);
                ColorPickerGame colorGame = new ColorPickerGame(p,hsc);
                this.dispose();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_GetNewWord;
    private javax.swing.JButton btn_Skip;
    private javax.swing.JButton buttonA;
    private javax.swing.JButton buttonB;
    private javax.swing.JButton buttonC;
    private javax.swing.JButton buttonD;
    private javax.swing.JButton buttonE;
    private javax.swing.JButton buttonF;
    private javax.swing.JButton buttonG;
    private javax.swing.JButton buttonH;
    private javax.swing.JButton buttonI;
    private javax.swing.JButton buttonJ;
    private javax.swing.JButton buttonK;
    private javax.swing.JButton buttonL;
    private javax.swing.JButton buttonM;
    private javax.swing.JButton buttonN;
    private javax.swing.JButton buttonO;
    private javax.swing.JButton buttonP;
    private javax.swing.JButton buttonQ;
    private javax.swing.JButton buttonR;
    private javax.swing.JButton buttonS;
    private javax.swing.JButton buttonT;
    private javax.swing.JButton buttonU;
    private javax.swing.JButton buttonV;
    private javax.swing.JButton buttonW;
    private javax.swing.JButton buttonX;
    private javax.swing.JButton buttonY;
    private javax.swing.JButton buttonZ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_GuessWord;
    private javax.swing.JLabel label_HANGMAN;
    private javax.swing.JLabel label_currTimeandDate;
    private javax.swing.JLabel scoreLabel;
    // End of variables declaration//GEN-END:variables
}
