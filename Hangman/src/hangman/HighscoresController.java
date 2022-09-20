/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    public HighscoresController(){
        playerList = new ArrayList<>();
        scoreFile = null;
    }
    
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
    
    public void sortList(){
        Comparator c = new Comparator<Player>(){
            public int compare(Player o1, Player o2){
                return o2.getScore() - o1.getScore();
            }
        };
        playerList.sort(c);
    }
    
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
    
    public Player[] getList(){
        Player[] temp = new Player[playerList.size()];
        playerList.toArray(temp);
        return temp;
    }
    
    public void addPlayer(Player p){
        playerList.add(p);
        sortList();
    }
    
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
    
    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < playerList.size(); ++i){
            s += playerList.get(i).getName() + " " + playerList.get(i).getScore() + "\n";
        }
        return s;
    }
}
