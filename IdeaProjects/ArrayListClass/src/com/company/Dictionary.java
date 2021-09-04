package com.company;
import java.util.*;

public class Dictionary extends ArrayList {

    //instance variables
    ArrayList words;
    ArrayList defs;

    //constructors
    public Dictionary(){
        words = new ArrayList();
        defs = new ArrayList();
    }

    //methods
    public void add(String word, String def) {
        //can just use the add() from the ArrayList class
        this.words.add(word);
        this.defs.add(def);
    }

    public int size(){
        //words and defs array should equal the same
        //check in case
        if(words.size() != defs.size()) {
            System.out.println("Please check the number of words and definitions inputed.");
            System.out.println("# of words: " + words.size());
            System.out.println("# of definitions: " + defs.size());
        }
        //at the end return the number of words
        return words.size();
    }

    public void randomFlashCard(){
        //get a random word from the list
        int randWord = (int) (Math.random()*words.size());
        //one has to be the same index as the randWord, one has to be the correct definition
        int[] defAns = {randWord, (int) (Math.random()*defs.size()), (int) (Math.random()*defs.size()), (int) (Math.random()*defs.size())};
        for(int i = 0; i<4; i++){
            int current = defAns[i];
            for(int j = 1; j<3; j++){
                if(i == j){
                    j++;
                } else {
                    while(current == defAns[j]){
                        defAns[j] = (int)(Math.random()*defs.size());
                    }
                }
            }
        }
        shuffle(defAns);
        Scanner choice = new Scanner(System.in);
        System.out.println("What does " + words.get(randWord) + " mean?");
        System.out.println("A) " + defs.get(defAns[0]) +"\nB) " + defs.get(defAns[1]) + "\n" +"C) " + defs.get(defAns[2]) + "\nD) " + defs.get(defAns[3]));
        String ans = choice.nextLine();
        if((ans.equals("a") ||ans.equals("A")) && defAns[0] == randWord){
            System.out.println("You are correct!");
        } else if((ans.equals("b") ||ans.equals("B")) && defAns[1] == randWord){
            System.out.println("You are correct!");
        } else if((ans.equals("c") ||ans.equals("C")) && defAns[2] == randWord){
            System.out.println("You are correct!");
        } else if((ans.equals("d") ||ans.equals("D")) && defAns[3] == randWord){
            System.out.println("You are correct!");
        } else {
            System.out.println("You are incorrect!");
        }
        /*if(defAns[ans-1] == randWord){//this will get the index of the word
            System.out.println("You are correct!");
        } else {
            System.out.println("Incorrect!");
        }*/
    }

    //helper function that shuffles the deck
    public void shuffle(int[] arr){
        int randomInt = 0;
        int storage = 0;
        for (int i = 0; i<arr.length; i++){
            randomInt = (int)(Math.random()*defs.size());//random number generator
            storage = arr[i];//set storage equal to the current arr index
            arr[i] = arr[randomInt];//now the deck index is equal to another random index
            arr[randomInt] = storage;//set the random index  to the storage space, now storage is a random element in the arr
        }
    }



}


