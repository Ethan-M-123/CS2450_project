/***************************************************************  
*  file: ColorPickerPanel.java
*  author: Shane, Simon, Dixon, Ethan, Marvin
*  class: CS 2450.01  
*  
*  assignment: Project V1.3
*  date last modified: 09/24/2022
*  
*  purpose: 
*   Game panel for the color picker game that creates the 
*   color picker buttons, randomizes the buttons' positions, colors,
*   and placement, as well keeps track of the player's score
*   Adds the specified GUI components, like the time stamp.
****************************************************************/



package hangman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class ColorPickerPanel extends JPanel implements MouseListener, MouseMotionListener {

    ArrayList<Color> cl;
    ArrayList<Ellipse2D.Double> ql;
    Color[] qc;
    Color purple;
    Color background = new Color(240,185,0);
    Color correct;
    static int NUM_OF_ROUNDS = 5;
    int roundNum = 0;
    Player p;

    JLabel timeStamp;
    JLabel roundNumber;
        
    Ellipse2D.Double q1;
    Ellipse2D.Double q2;
    Ellipse2D.Double q3;
    Ellipse2D.Double q4;
    Ellipse2D.Double q5;

    // Default constructor
    public ColorPickerPanel() {
        
        this(new Player());
        
        // Could delete stuff under since it does the same thing?
        /*
        super();
        setPreferredSize(new Dimension(600, 400));
        cl = new ArrayList<Color>();
        ql = new ArrayList<Ellipse2D.Double>();
        qc = new Color[5];
        p = new Player();
        purple = new Color(102, 0, 153);

        timeStamp = new JLabel("Month Day, Year");
        roundNumber = new JLabel("Round " + (roundNum + 1) + "/" + NUM_OF_ROUNDS);

        //Make it easier for the label placement
        setLayout(null);

        //Updates the label for the seconds
        new Thread() {
            public void run() {
                while (true) {
                    timeStamp.setText(Calendar.getInstance().getTime().toString());
                    roundNumber.setText("Round " + (roundNum + 1) +"/" + NUM_OF_ROUNDS);

                }
            }
        }.start();

        //Add the timestamp
        add(timeStamp);

        add(roundNumber);

        cl.add(Color.red);
        cl.add(Color.green);
        cl.add(Color.blue);
        cl.add(purple);
        cl.add(Color.yellow);

        addMouseListener(this);
        addMouseMotionListener(this);
        */
    }

    
    /** Overloaded constructor
     *  Sets up components for the color picker game
     * 
     * @param p Player object that stores the player's
     *          name and score.
     */
    public ColorPickerPanel(Player p) {
        super();
        setPreferredSize(new Dimension(600, 400));
        cl = new ArrayList<Color>();
        ql = new ArrayList<Ellipse2D.Double>();
        qc = new Color[5];
        this.p = p;
        purple = new Color(102, 0, 153);

        timeStamp = new JLabel("Month Day, Year");
        roundNumber = new JLabel("Round " + (roundNum + 1) + "/" + NUM_OF_ROUNDS);

        //Code to exit from the game
        timeStamp.getInputMap(WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("ESCAPE"), "escapeGame");
        timeStamp.getActionMap().put("escapeGame", new LeaveGame());
        
        //F1 key display
        timeStamp.getInputMap(WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("F1"), "displayInfo");
        timeStamp.getActionMap().put("displayInfo", new DisplayInfo());
        

        //Make it easier for the label placement
        setLayout(null);

        //Updates the label for the seconds
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    timeStamp.setText(Calendar.getInstance().getTime().toString());
                    roundNumber.setText("Round " + (roundNum + 1) + "/" + NUM_OF_ROUNDS);
                }
            }
        }.start();

        //Add the timestamp
        add(timeStamp);

        add(roundNumber);

        cl.add(Color.red);
        cl.add(Color.green);
        cl.add(Color.blue);
        cl.add(purple);
        cl.add(Color.yellow);

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    
    /** method: getRoundNum
     * 
     * Purpose: returns the round number of the 
     *  color picker game
     */
    public int getRoundNum() {
        return roundNum;
    }

    
    /** method: resetRoundNum
     * 
     * resets the round number to 0
     * 
     */
    public void resetRoundNum() {
        roundNum = 0;
    }

    /** method: getMaxRoundNum 
     * purpose: returns the maximum number of 
     * rounds for the color picker game
     */
    public int getMaxRoundNum() {
        return NUM_OF_ROUNDS;
    }

    
    /** method: setMaxRoundNum
     * purpose: sets the maximum number of
     *  rounds to an integer specified
     * @param i the maximum number of rounds
     *          specified
     */
    public void setMaxRoundNum(int i) {
        NUM_OF_ROUNDS = i;
    }

    private void resetColorList() {
        cl = new ArrayList<Color>();
        cl.add(Color.red);
        cl.add(Color.green);
        cl.add(Color.blue);
        cl.add(purple);
        cl.add(Color.yellow);
    }

    private void resetQuadrantList() {
        ql = new ArrayList<Ellipse2D.Double>();
    }

    private boolean testQuadrant(int x, int y) {
        for (int i = 0; i < ql.size(); ++i) {
            if (ql.get(i).contains(x, y)) {
                if (qc[i].getRGB() == correct.getRGB()) {
                    p.setScore(p.getScore() + 100);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong! Pick the color of the text.", "Wrong!", JOptionPane.ERROR_MESSAGE);
                    return true;
                }
            }
        }
        return false;
    }

    private void highlightQuadrant(int i) {
        Graphics2D g2d = (Graphics2D) getGraphics();
        int highlight = 200;

        int red = qc[i].getRed() + highlight;
        int green = qc[i].getGreen() + highlight;
        int blue = qc[i].getBlue() + highlight;

        if (red > 255) {
            red = 255;
        }
        if (green > 255) {
            green = 255;
        }
        if (blue > 255) {
            blue = 255;
        }

        Color temp = new Color(red, green, blue);
        g2d.setColor(temp);
        g2d.fill(ql.get(i));

    }

    private void repaintQuadrants() {
        Graphics2D g2d = (Graphics2D) getGraphics();

        for (int i = 0; i < ql.size(); ++i) {
            g2d.setColor(qc[i]);
            g2d.fill(ql.get(i));
        }
    }

    private Color pickRandomColor() {
        int i = (int) (Math.random() * cl.size());
        Color temp = cl.get(i);
        cl.remove(i);
        return temp;
    }

    private void resetPanel() {
        repaint();
        resetQuadrantList();
        qc = new Color[5];
        ++roundNum;
        if (roundNum >= NUM_OF_ROUNDS) {
            setVisible(false);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Color[] colors = {Color.red, Color.green, Color.blue, purple, Color.yellow};
        String[] strings = {"Red", "Green", "Blue", "Purple", "Yellow"};
        
        g2d.setColor(background);
        g2d.fillRect(0, 0, 600, 400);

        correct = colors[(int) (Math.random() * colors.length)];
        g2d.setColor(correct);
        Font f = new Font("Comic Sans MS", Font.BOLD, 45);
        g2d.setFont(f);
        g2d.drawString(strings[(int) (Math.random() * strings.length)], 225, 120);

        g2d.setColor(pickRandomColor()); //q1
        qc[0] = g2d.getColor();
        int x = (int) Math.round(Math.random() * 50);
        int y = (int) Math.round(Math.random() * 50);
        int w = 150;
        int h = 150;
        // Prevents button from overlapping label
        if (y <= 22) {
            y += (32 - y); // Adds 10 or more pixels of buffer if overlap
        }
        q1 = new Ellipse2D.Double(x, y, w, h);
        g2d.fill(q1);
        ql.add(q1);

        g2d.setColor(pickRandomColor()); //q2
        qc[1] = g2d.getColor();
        x = (int) Math.round(Math.random() * 50);
        y = (int) Math.round(Math.random() * 50);
        w = 150;
        h = 150;
        y += 200;
        q2 = new Ellipse2D.Double(x, y, w, h);
        g2d.fill(q2);
        ql.add(q2);

        g2d.setColor(pickRandomColor()); //q3
        qc[2] = g2d.getColor();
        x = (int) Math.round(Math.random() * 50);
        y = (int) Math.round(Math.random() * 50);
        w = 150;
        h = 150;
        x += 200;
        y += 200;
        q3 = new Ellipse2D.Double(x, y, w, h);
        g2d.fill(q3);
        ql.add(q3);

        g2d.setColor(pickRandomColor()); //q4
        qc[3] = g2d.getColor();
        x = (int) Math.round(Math.random() * 50);
        y = (int) Math.round(Math.random() * 50);
        w = 150;
        h = 150;
        x += 400;
        y += 200;
        q4 = new Ellipse2D.Double(x, y, w, h);
        g2d.fill(q4);
        ql.add(q4);

        g2d.setColor(pickRandomColor()); //q5
        qc[4] = g2d.getColor();
        x = (int) Math.round(Math.random() * 50);
        y = (int) Math.round(Math.random() * 50);
        w = 150;
        h = 150;
        x += 400;
        // Prevents button from overlapping label
        if (y <= 22) {
            y += (32 - y); // Adds 10 or more pixels of buffer if overlap
        }
        q5 = new Ellipse2D.Double(x, y, w, h);
        g2d.fill(q5);
        ql.add(q5);

        //Paint Label
        timeStamp.setBounds(340, 5, 250, 17);
        timeStamp.setBackground(Color.LIGHT_GRAY);
        timeStamp.setOpaque(true);
        timeStamp.setFont(new java.awt.Font("Tahoma", 0, 14));
        timeStamp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        roundNumber.setBounds(20, 5, 150, 17);
        roundNumber.setBackground(Color.LIGHT_GRAY);
        roundNumber.setOpaque(true);
        roundNumber.setFont(new java.awt.Font("Tahoma", 0, 14));
        roundNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        
        resetColorList();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getPoint().x;
        int y = e.getPoint().y;
        if (testQuadrant(x, y)) {
            resetPanel();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        repaintQuadrants();
        for (int i = 0; i < ql.size(); ++i) {
            if (ql.get(i).contains(x, y)) {
                highlightQuadrant(i);
            }
        }
    }

}
