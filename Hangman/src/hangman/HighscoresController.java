/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/***************************************************************  
*  file: HighscoresController.java
*  author: ...
*  class: CS 2450.01  
*  
*  assignment: Project V1.0 
*  date last modified: 9/21/2022
*  
*  purpose: Provides the methods and calls necessary to organize the list,
*  update the list, and open or close the screen
*  
****************************************************************/  

package hangman;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Comparator;
import java.io.FileWriter;


/**
 *
 * @author mrnoo
 */
public class HighscoresController {
    ArrayList<Player> playerList;
    File scoreFile;
    
    /*
    * default constructor
    * initializes playerList(meant to hold player objects & the score file to store the player info (set to null)
    */
    public HighscoresController(){
        playerList = new ArrayList<>();
        scoreFile = null;
    }
    
    /*
    * extra constructor
    * initializes playerList(meant to hold player objects & the score file to store the player info (set to input file)
    * input file is in Playername Score/n format
    */
    public HighscoresController(File input){
        playerList = new ArrayList<>();
        scoreFile = input;
        try{
            Scanner s = new Scanner(scoreFile);
            while(s.hasNext()){
                String[] tokens = s.nextLine().split(" ");
                playerList.add(new Player(tokens[0], Integer.parseInt(tokens[1])));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /*
    * sorts the playter list from least to greatest
    * this is done so printing to the file is in the correct order.
    */
    public void sortList(){
        Comparator c = new Comparator<Player>(){
            public int compare(Player o1, Player o2){
                return o2.getScore() - o1.getScore();
            }
        };
        playerList.sort(c);
    }
    
    /*
    * fills the player list with a given input file with the Playername Score/n format.
    */
    public void setList(File input){
        playerList = new ArrayList<>();
        scoreFile = input;
        try{
            Scanner s = new Scanner(scoreFile);
            while(s.hasNext()){
                String[] tokens = s.nextLine().split(" ");
                playerList.add(new Player(tokens[0], Integer.parseInt(tokens[1])));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /*
    * getter method for player list returns object array for easier use
    */
    public Player[] getList(){
        Player[] temp = new Player[playerList.size()];
        playerList.toArray(temp);
        return temp;
    }
    
    /*
    * adds a player object to the list then sorts the list. 
    */
    public void addPlayer(Player p){
        playerList.add(p);
        sortList();
    }
    
    /*
    * dumps the player list info into the given score file
    */
    public void outputList(){
        try {
            FileWriter fw = new FileWriter(scoreFile);
            for(Player p : playerList){
                fw.write(p.getName() + " " + p.getScore());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    public int[] giveTopXScores(int x){
        int[] temp = new int[x];
        
        for(int i = 0; i < x; ++i){
            temp[i] = playerList.get(i).getScore();
        }
        return temp;
    }
    
    /*
    * overrided toString so you can simply print the list to the command line
    */
    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < playerList.size(); ++i){
            s += playerList.get(i).getName() + " " + playerList.get(i).getScore() + "\n";
        }
        return s;
    }
}
