package com.company;

public class MathClass {
    // Constants (Final Static Variables)
    public static final double E = 2.71828;
    public static final double PI = 3.14159;

    //Static/Class Variables
    //increment this by adding one each time a MathClass function is called.
    private static int count = 0;

    // Nonstatic/Instance Variables
    // Constructors
    public MathClass (){
        count = 0;
    }

    // Getters/Setters
    public static int getCount(){
        return count;
    }

    // Static Methods
    public static double abs(double value){
        count ++;
        if (value < 0){//if it is a negative number
            return value*-1;//return value times -1
        }
        return value;//else return value as it is
    }

    public static String abs(int value){
        count ++;
        String rv = "|" + value + "|";//value between to absolute value brackets
        return rv;
    }

    // Nonstatic Methods
    public double absNS(double value){
        count ++;
        if (value < 0){//if it is a negative number
            return value*-1;//return value times -1
        }
        return value;//else return value as it is
    }

    public String absNS(int value){
        count ++;
        String rv = "|" + value + "|";//value between to absolute value brackets
        return rv;
    }

    public int sqrtNS(int value){
        count ++;
        //check if value is equal to zero
        int rv = 0;
        if(value == 0){
            return rv;
        }
        //take absolute value of value cast to double within te abs function it takes in a double parameter
        // then convert back to an int to keep up the int value in the for loop.
        double absVal = (int)abs((double)value);
        //keep a max on the inputted value to help our for loop
        if (value > 10000){
            System.out.println("Your value is too big.");
            return 0;
        }
        //loop for a certain amount of square root numbers
        //lets go only up to 100 --> (100*100 = 10000)
        for (int i = 1; i<101; i++){
            if (i*i == absVal){
                return i;
            } else if (i*i > absVal && ((i-1)*(i-1) < absVal)){
                return i-1;
            }
        }
        return rv;
    }

}
