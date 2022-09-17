package hangman;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marvin Sevilla
 */

import java.math.* ;
public class GetGuessWord {
    private String[] words;
    private String currentWord;
    
    public GetGuessWord()
    {   
       this.words = new String[] {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
       getNewWord();
    }
    
    public String getNewWord()
    {
        int rand = (int)(Math.random()*5);
        currentWord = this.words[rand];
        return currentWord;
    }
    
    public String getCurrentWord()
    {
        return currentWord;
    }
    
    public String getCurrWordHidden()
    {
        String holder = "";
        for(int i=0; i<currentWord.length();i++)
        {
            holder+="_ ";
        }
        
        System.out.println(currentWord);
        return holder;
    }
}
