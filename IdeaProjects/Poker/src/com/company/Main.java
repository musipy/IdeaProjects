package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int [] a = {2,5,20,6,21};
	    //System.out.println(nextCard(a));
        //System.out.println(prettyPrintDeck(a));
        //System.out.println(bestPokerHand(a));
        //System.out.println(pokerHand(5));
        play();
    }

    public static String prettyPrintDeck(int[] deck){
        String rv = "[";//beginning of string
        for(int i = 0; i<deck.length; i++){//null check & if deck is all zero (you've used all the cards)
            if(i == deck.length-1){
                rv += deck[i] + "]";//if last element, finish with bracket
            } else {
                rv += deck[i] + ",";//add element as you go through array
            }
        }
        return rv;
    }

    //Create a function that takes an int card (1-52), and returns its face. You should return an int from 1-13 where:
    // 1 = A, 2 = 2, 3 = 3, ... , 10 = 10, 11 = J, 12 = Q, 13 = K.
    public static  int face(int card) {
        return (card-1) % 13 +1;
    }

    //Create a function that takes an int card (1-52), and returns its suit. You should return an int from 1-4 where:
    //1 = Spade, 2 = Heart, 3 = Clover, 4 = Diamond
    public static int suit(int card){
        return (card-1)/13 +1;
    }

    public static String cardToString(int card) {
        String rv = "";
        // using suit funciton contents to see which suite it is 1=spade,2=hearts,3=clubs,4=diamonds
        if ((card-1)/13 +1 == 1){
            rv = "S";
        } else if ((card-1)/13 +1 == 2){
            rv = "H";
        } else if ((card-1)/13 +1 == 3){
            rv = "C";
        } else if ((card-1)/13 +1 == 4){
            rv = "D";
        }
        //using contents of face function to see which type it is 11=J,12=Q,13=K,1=A,10=X and rest is adding number to end of string.
        if ((card-1) % 13 +1 == 11){
            rv += "J";
        } else if ((card-1) % 13 +1 == 12){
            rv += "Q";
        } else if ((card-1) % 13 +1 == 13){
            rv += "K";
        } else if ((card-1) % 13 +1 == 10){
            rv += "X";
        } else if ((card-1) % 13 +1 == 1){
            rv += "A";
        } else {
            rv += (card-1) % 13 +1;
        }
        return rv;
    }

    public static String cardsToString(int[] cards){
        String rv = "[";
        if (cards == null){ // null check
            return rv += "]";
        } else {
            //uses cardToString method to simplify process and find the card (already returns a string)
            for (int i = 0; i<cards.length; i++){//for entire array of cards
                if (i == cards.length-1){
                    rv += cardToString(cards[i]) + "]";//if its the last card, end with close brace not comma
                } else {
                    rv += cardToString(cards[i]) + ",";//else end with comma to add onto next term
                }
            }
        }
        return rv;
    }

    public static void shuffle(int[] deck){
        int randomInt = 0;
        int storage = 0;
        for (int i = 0; i<deck.length; i++){
            randomInt = (int)Math.random()*52;//random number generator
            storage = deck[i];//set storage equal to the current deck index
            deck[i] = deck[randomInt];//now the deck index is equal to another random index
            deck[randomInt] = storage;//set the random index card to the storage space, now storage is a random card in the deck.
        }
    }

    public static int[] createShuffledDeck() {
        int [] rv = new int [52];//has 52 indexes
        if (rv == null){//null check (not needed because we created the deck, but good practice)
            return rv;//returns empty array
        }
        for (int i = 0; i<rv.length; i++){//set each index equal from 1-52
            rv[i]=i+1;
        }
        shuffle(rv);//shuffle deck
        return rv;
    }

    public static int nextCard(int[] deck){
        int rv = 0;
        int i = 0;//index number
        if(deck == null || deck[deck.length-1] == 0){
            return 0;
        }
        while (deck[i] == 0){
            i++;
        }//increase the index number if the current index is equal to 0
        rv = deck[i];
        deck[i] = 0;
        return rv;
    }

    /*
    best value
    1) if else statements starting from royal flush till else for high card
    2) must compare suit seperate and number seperate when comparing straight flush and royal flush
    3) after, just compare to see if order for straight or if all the same suit for flush
    4) last, high card if all options are done (else statement)
    5) makes sure for number of pairs, have a count system to see how many of the wame number is in the deck
    6) full house, compare three of a kind first, then see the rest if they are a pair too
     */
    public static void task8() {
        int [] deck = createShuffledDeck();//created shuffled deck of 52 cards
        System.out.println(cardsToString(deck));//print shuffled deck (all 52 cards)
        for (int i = 0; i<5; i++){//print first five cards
            System.out.println(deck[i]);
        }//prints out each card on seperate line
        //when run (HA,HK,HQ,HJ,HX) --> highest value is Royal Flush, would return 1
    }

    public static int bestPokerHand(int[] hand){
        if (hand == null){//null check
            return 0;
        }
        int [] faceHand = {face(hand[0]), face(hand[1]), face(hand[2]), face(hand[3]), face(hand[4])};
        int rv = 0;
        int swap = 0;
        int smallestIndex = 0;
        //~~~~~~~~~SORT THE CARDS IN ORDER TO SIMPLIFY PROCESS IN CASE CARDS WERE NOT GIVEN IN ASCENDING ORDER~~~~~~~~
        for (int i = 0; i < faceHand.length-1; i++) {
            smallestIndex = i;//find smallest value in array
            for (int j = i+1; j < faceHand.length; j++) {
                if (faceHand[j] < faceHand[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            swap = faceHand[smallestIndex];//equals the smallest value
            faceHand[smallestIndex] = faceHand[i];//now place where the smallest value was now has the larger value
            faceHand[i] = swap;//set first element or index i to equal smaller number.
        }
        //finding how many times a card occurs and which it is (mode function)
        int counter = 1;
        int pairs = 0;
        for(int i = 0; i<faceHand.length-1; i++){
            if(faceHand[i] == faceHand[i+1]){//adds how many times it occurs
                counter ++;
            }
            if(counter == 2 && pairs == 0){//first time a pair comes up, or the current matches the next index calue
                pairs ++;//add one to the pairs value
            } else if (counter == 2 && pairs == 1){//now if the number occurs once and the pairs are now equal to 1
                if (faceHand[i] != faceHand[i+1]){//checks if the current matches the next(seperates full hand from two pairs)
                    counter = 1;//resets counter
                    pairs ++;//adds one to pairs
                }
            }
            if (counter == 3 && pairs == 2){//if there are three of the same number occurring
                if(faceHand[i] == faceHand[i+1]){//check if the next index value matches the current index value
                    counter ++;//if it does, add one to counter (differentiates full house from four of a kind
                    pairs++;//add one to pair
                }
            }
            if (counter == 1){//now if there is only one pair
                if (faceHand[i] != faceHand[i+1]) {//check to see if then next index matches
                    counter = 0;//set the counter to zero (differentiate between high card and one pair)
                }
            }

        }
        System.out.println(counter);
        System.out.println(pairs);
        System.out.println("[" + faceHand[0] + "," + faceHand[1] + "," + faceHand[2] + "," + faceHand[3] + "," + faceHand[4] + "]");
        //all flush
        if(suit(hand[0])==suit(hand[1]) && suit(hand[0])==suit(hand[2]) && suit(hand[0])==suit(hand[3]) && suit(hand[0])==suit(hand[4])){
            //ROYAL FLUSH
            if (faceHand[0] == 1 && faceHand[4] == 13 && faceHand[3] == 12 && faceHand[2] == 11 && faceHand[1] == 10){
                rv = 1;
            }  else if (faceHand[0] == faceHand[1]-1 && faceHand[1] == faceHand[2]-1 && faceHand[2] == faceHand[3]-1 && faceHand[3] == faceHand[4]-1){
                //STRAIGHT FLUSH
                rv = 2;
            } else {//FLUSH
                rv = 5;
            }
        //STRAIGHT
        } else if (faceHand[0] == faceHand[1]-1 && faceHand[1] == faceHand[2]-1 && faceHand[2] == face(hand[3])-1 && faceHand[3] == faceHand[4]-1){
            rv = 6;
        } else if (counter == 4 && pairs == 2){
            rv = 3;
        } else if (counter == 3){
            if(pairs == 2){//Full House
                rv = 4;
            } else {
                rv = 7;//Three of a Kind
            }
        } else if (counter == 2){
                rv = 8;//Two Pair
        } else if (counter == 1){
            rv = 9;//One Pair
        } else {
            rv = 10;//High Card
        }
        return rv;
    }

    public static String pokerHand(int hand){
        //string array with names of poker hands
        String [] names = {"Royal Flush", "Straight Flush", "Four of a Kind", "Full House", "Flush", "Straight", "Three of a Kind", "Two Pair", "One Pair", "High Card"};
        return names[hand-1];//returns name based on index in the String array (must subtract one since first index is 0)
    }


    public static void play(){
        int [] deck = createShuffledDeck();
        int [] handA = new int [5];
        int [] handB = new int [5];
        int [] replaceCard = new int [5];
        int j = 0;
        for (int i = 0; i<10; i+=2){//dealt the cards to each player
            handA[j] = deck[i];
            handB[j] = deck[i+1];
            j++;//seperate variable for the index of hand arrays
        }//start for player1's turn
        System.out.println("Player 1's turn");
        System.out.println("[" + handA[0] + "," + handA[1] + "," + handA[2] + "," + handA[3] + "," + handA[4] + "]");
        Scanner replace = new Scanner(System.in);
        System.out.println("Which card would you like to replace (1-5)");
        int cardNumber = replace.nextInt();//saving as an integer
        while (cardNumber != 0){//while they don't put the value 0
            if (cardNumber > 5){
                System.out.println("You only have 5 cards to replace, please choose (1-5)");
                cardNumber = 0; //exit if enters value greater than 5
            } else if(replaceCard[4] != 0){
                System.out.println("you have run out of replacements");//exit if enters more than five values
                cardNumber = 0;
            }
            replaceCard[cardNumber -1] = 1;
            System.out.println("Which card would you like to replace (1-5)");//replace the int by asking once more
            cardNumber = replace.nextInt();
        }
        for(int i = 0; i<5; i++){
            int originalNum = handA[i];
            if(replaceCard[i] == 1){
                handA[i] = deck[10+(i+1)];//replace the cards by adding the next element in the shuffled deck (to avoid repeats in preivious cards or Player 2's cards
            }
            replaceCard[i] = 0;
        }
        //repeat it all for second player
        System.out.println("Player 2's turn");
        System.out.println("[" + handB[0] + "," + handB[1] + "," + handB[2] + "," + handB[3] + "," + handB[4] + "]");
        Scanner replace2 = new Scanner(System.in);
        System.out.println("Which card would you like to replace (1-5)");
        int cardNumber2 = replace.nextInt();//saving as an integer
        while (cardNumber2 != 0){
            if (cardNumber2 > 5){
                System.out.println("You only have 5 cards to replace, please choose (1-5)");
                cardNumber2 = 0;
            } else if(replaceCard[4] != 0){
                System.out.println("you have run out of replacements");
                cardNumber2 = 0;
            }
            replaceCard[cardNumber2 -1] = 1;
            System.out.println("Which card would you like to replace (1-5)");
            cardNumber2 = replace.nextInt();
        }
        for(int i = 0; i<5; i++){
            int originalNum = handA[i];
            if(replaceCard[i] == 1){
                handB[i] = deck[15+(i+1)];
            }
        }
        //now compare if both are equal or not
        int pokerHandA = bestPokerHand(handA);
        int pokerHandB = bestPokerHand(handB);
        if (pokerHandA < pokerHandB){ //lower number wins the poker game
            System.out.println("Player 1 wins!");
        } else if (pokerHandB < pokerHandA) {//same except for player two wins
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");//if both are same, here we assume it can result in a tie.
        }
    }

}
