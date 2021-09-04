package com.company;

public class Main {

    public static void main(String[] args) {
        /*//Math.PI is a constant value. Cannot reassign it
        //have circle of radius 2 --> print out value
        System.out.println(java.lang.Math.PI*2*2);

        //Find a random number between 5-20
        //inclusive --> 16 terms in between the two
        //must cast to int
        //add five to make it from 5-20
        int rand = (int)(java.lang.Math.random()*16) + 5;//5-20
        //random number between 27 and 51
        int rand1 = (int)(java.lang.Math.random() * 25) + 27;

        //Math.min() gives the smaller of 2 values
        System.out.println(java.lang.Math.min(4,7));*/

        System.out.println("Math.E = " + Math.E);
        System.out.println("MathClass.E = " + MathClass.E);
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("MathClass.PI = " + MathClass.PI);
        MathClass m = new MathClass();
        // You can access static variables through objects and class.
        // But you cannot access nonstatic variables through the class.
        System.out.println("m.E = " + m.E);
        System.out.println("m.PI = " + m.PI);

    }

    //Create a function minOf3(double a, double b, double c) That returns the smallest of 3 numbers
    public static double minOf3(double a, double b, double c){
        return java.lang.Math.min(java.lang.Math.min(a, b), c);
    }

}
