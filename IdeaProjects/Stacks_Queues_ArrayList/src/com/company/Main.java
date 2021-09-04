package com.company;
import java.util.Scanner;
//import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    //task2();
	    //task4();
        //bubbleTest();
        //System.out.println("HIHIHIHIHI".toLowerCase());
    }

    /*public static void task2(){
        Stack names = new Stack();
        //add five names
        names.push("Al");
        names.push("Bob");
        names.push("Carl");
        names.push("David");
        names.push("Ethan");
        //print out queue
        for(int i = 0; i<5; i++){
            System.out.println(names.toString());
            names.pop();
        }
    }

    public static void task4(){
        Queue people = new Queue();
        //ask which choice
        Scanner ask = new Scanner(System.in);
        System.out.println("Please choose one of the following options (1,2,3,9)\n1. Add person to queue\n2. Remove person from queue\n3. Print queue\n4. Bubble sort\n9. Exit");
        int choice = ask.nextInt();
        //while it is not equal to 9 keep going
        while(choice != 9) {
            //1. Add person to queue
            if(choice == 1){
                Scanner askName = new Scanner(System.in);
                System.out.println("Please enter a name you would like to input into the queue");
                String name = askName.nextLine();
                people.enqueue(name);//add
            } else if (choice == 2){//2. Remove person from queue
                //null check
                if(people.size() == 0){
                    System.out.println("There are no more names in your Queue");
                } else {
                    System.out.println("The first name in the queue will now be removed from the queue");
                    people.dequeue();//remove
                }
            } else if (choice == 3){//3. Print queue
                System.out.println(people.toString());
            } else if (choice == 4) {//4. bubble sort
                System.out.println("This is your original order: \n" + people.toString());
                people.bubbleSort();
                System.out.println("Your queue is now sorted. This is your sorted list: \n" + people.toString());
            }
            else {
                System.out.println("That is not an option. Please choose once more.");
            }
            //keep on repeating until it equals 9
            Scanner askAgain = new Scanner(System.in);
            System.out.println("Please choose one of the following options (1,2,3,9)\n1. Add person to queue\n2. Remove person from queue\n3. Print queue\n4. Bubble sort\n9. Exit");
            choice = askAgain.nextInt();
            //9. Exit
        }
    }

    public static void bubbleTest(){
        Queue test = new Queue();
        test.enqueue(1);
        test.enqueue(7);
        test.enqueue(6);
        test.enqueue(4);
        test.enqueue(8);
        test.enqueue(5);
        System.out.println(test.toString());
        test.bubbleSort();
        System.out.println(test.toString());
    }*/
}
