/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangman;

/**
 *
 * @author mrnoo
 */
public class Player {
    private String name;
    private int score;
    
    /*
    * default constructor for setting a player object
    * initializes name to "null" and score to 0
    */
    public Player(){
        name = "null";
        score = 0;
    }

    /*
    * seconday constructor for setting player object
    * initializes name to whatever name given and likewise with the score
    */
    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }
    
    /*
    * getter for the name field
    */
    public String getName(){
        return this.name;
    }
    
    /*
    * setter for the name field
    */
    public void setName(String name){
        this.name = name;
    }
    
    /*
    * getter for the score field
    */
    public int getScore(){
        return this.score;
    }
    
    /*
    * setter for the score field
    */
    public void setScore(int score){
        this.score = score;
    }
}
