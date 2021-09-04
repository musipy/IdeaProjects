package com.company;

public class Main {

    public static void main(String[] args) {

        //interestAfterThree();
        //nameInBox("harika");
        int [] a = {1,50};
        String[] names = {"Pat", "Joe", "Ann", "Cal", "Amy"};
        printVals(names, names.length - 1);
    }

    //interest decrease
    /*
    int year count
    int balance - 9500 dollars as initial value
    while the balance != 0
        balance = balance + balance * interest rate --> which is given as 6% a year
        balance -= 500, 500 for college funds per year
    at end you have balance increasing by interest each year, but depleting by 500 every year
     */

    //TACO NIGHT
    /*
    1. count how many people are attending / how many people plan to eat a taco
    2. prepare the ingredients proportional to how many people are attending
    3. Cook the ingredients that are required to be cooked ( rice, tortilla, beans)
    4. Set out the toppings in order on the counter top
    5. Set out the condiments on the counter top
    6. Have people put what they desire on the taco
    7. Repeat until the tortillas are out

    int number of people coming
    int number of toppings
    int number of toppings that must be cooked
    amount of each topping = proportional to the number of people coming
    cook ingredients that must be cooked
    while tortillas <= the number of people eating tacos && != 0
        have person put topping on each taco
        subtract one from tortilla number
     */

    public static void interestAfterThree () {
        double rv = 1000;
        for (int i = 0; i<3; i++){
            rv += rv*0.05;
            System.out.println(i+1 + "\t" + "$" + rv);
        }
    }



    public static void nameInBox (String name) {
        int nameCount = name.length() +2;
        while (nameCount > 0){
            System.out.print("-");
            nameCount -= 1;
        }
        System.out.println("\n" + "|" + name + "|");
        nameCount = name.length() +2;
        while (nameCount > 0){
            System.out.print("-");
            nameCount -= 1;
        }
    }

    public static void friendNames () {
        System.out.println("  Friends in Ap Classrooms  ");
        System.out.println("----------------------------");
        System.out.println("AP PHYSICS:            Priya");
        System.out.println("AP Calculus:          Anjali");
    }

    public static int[] multiplyMoney(int [] m, int multiplier) {
        int totalCents = ((m[0])*100) + m[1];
        int multipliedVal = totalCents * multiplier;
        int [] newMoney = new int [2];
        newMoney[0] = multipliedVal / 100;
        newMoney[1] = multipliedVal % 100;
        System.out.println(newMoney[0] + "." + newMoney[1]);
        return newMoney;
    }

    public static int append(int a, int b){
        int rv = 0;
        int exponent = 10;
        for (int i = 0; i < b-1; i++){
            exponent *= 10;
        }
        rv = a * (exponent) ;
        return rv;
    }

    public static void printVals(String[] items, int k)

    {

        if(k > 1)

        {

            printVals(items, k - 1);

            System.out.print(items[k] + " ");

            printVals(items, k - 2);

        }

    }






}
