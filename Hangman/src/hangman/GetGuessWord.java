package hangman;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/***************************************************************  
*  file: GetGuessWord.java  
*  author: M. Sevilla 
*  class: CS 2450.01  
*  
*  assignment: Project V1.0 
*  date last modified: 9/21/2022
*  
*  purpose: This program provides the callee with a random word and methods to 
*  get a new  random word, get said word's hidden form, and get the current word
*  that the created GetGuessWord object is on 
*  
****************************************************************/  

import java.math.* ;
public class GetGuessWord {
    private String[] words;
    private String currentWord;
    
    //Constructor: creates a new array of words specified by the project 
    //instructions and gets a new word to randomize the first word all the time
    public GetGuessWord()
    {   
       this.words = new String[] {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
       getNewWord();
    }
    
    // method: getNewWord()
    // purpose: returns a String that is a random word chosen from this.words
    public String getNewWord()
    {
        int rand = (int)(Math.random()*5);
        currentWord = this.words[rand];
        return currentWord;
    }

    // method: getCurrentWord() 
    // purpose: returns a String, which is the word that was returned the last 
    // time getNewWord() was called 
    public String getCurrentWord()
    {
        return currentWord;
    }
    
    // method: getCurrWordHidden() 
    // purpose: retruns a string that only contains "_" and space characters,
    // and is the same length as the value of currentWord*2
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
