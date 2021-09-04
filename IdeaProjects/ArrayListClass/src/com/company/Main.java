package com.company;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        //Dictionary d = new Dictionary();
        dictionaire();
    }

    public static void fillDictionary(Dictionary d, String[] words, String[] defs){
        //set a for loop that will add the words to the word list in d
        for(int i = 0; i<words.length; i++){
            d.add(words[i], defs[i]);
        }
        //now the dictionary added all the words and defs in the parameters
    }

    public static void dictionaire(){
        Dictionary d = new Dictionary();
        //Le taureau	The bull
        d.add("La taureau", "The bull");
        //La vache		The cow
        d.add("La vache", "The cow");
        //La tortue		The turtle
        d.add("La torture", "The turtle");
        //Le canard		The duck
        d.add("Le canard", "The duck");
        //Le cochon		The pig
        d.add("Le cochon", "The pig");
        //La chèvre		The goat
        d.add("La chèvre", "The goat");
        //Le poulet		The chicken
        d.add("Le poulet","The chicken");
        //Une poule		A hen
        d.add("Une poule", "A hen");
        //Le lapin		The rabbit
        d.add("Le lapin", "The rabbit");
        //Le mouton		The sheep
        d.add("Le mouton", "The sheep");
        //La brebis		The ewe
        d.add("La brebis", "The ewe");
        //print out all the words (not in instructions, but to make sure all words are there)
        System.out.println("Sample Animals dictionaire");
        System.out.println("___________________________");
        for(int i = 0; i<d.words.size(); i++){
            String word = (String) d.words.get(i);
            String def = (String) d.defs.get(i);
            System.out.println(word + "\t-\t" + def);
        }
    }
}





