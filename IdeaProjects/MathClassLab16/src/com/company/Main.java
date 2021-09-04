package com.company;

public class Main {

    public static void main(String[] args) {
        //Math.PI is a constant value. Cannot reassign it
        //have circle of radius 2 --> print out value
        System.out.println(Math.PI*2*2);

        //Find a random number between 5-20
        //inclusive --> 16 terms in between the two
        //must cast to int
        //add five to make it from 5-20
        int rand = (int)(Math.random()*16) + 5;//5-20
        //random number between 27 and 51
        int rand1 = (int)(Math.random() * 25) + 27;

        //Math.min() gives the smaller of 2 values
        System.out.println(Math.min(4,7));

        System.out.println("Math.E = " + Math.E);
        System.out.println("MathClass.E = " + MathClass.E);
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("MathClass.PI = " + MathClass.PI);
        //MathClass m = new MathClass();
        // You can access static variables through objects and class.
        // But you cannot access nonstatic variables through the class.
        MathClass m = new MathClass();
        System.out.println("m.E = " + m.E);
        System.out.println("m.PI = " + m.PI);

        System.out.println("Math.abs(4.0) = " + Math.abs(4.0));
        System.out.println("MathClass.abs(4.0) = " + MathClass.abs(4.0));
        System.out.println("Math.abs(4) = " + Math.abs(4));
        System.out.println("MathClass.abs(4) = " + MathClass.abs(4));

        MathClass m2 = new MathClass();
        System.out.println("m2.absNS(4.0) = " + m2.absNS(4.0));
        System.out.println("m2.abs(4.0) = " + m2.abs(4.0));
        System.out.println("m2.absNS(4) = " + m2.absNS(4));
        System.out.println("m2.abs(4) = " + m2.abs(4));

        MathClass a = new MathClass();
        System.out.println(Math.sqrt(121));
        System.out.println(a.sqrtNS(121));
        System.out.println(Math.sqrt(9));
        System.out.println(a.sqrtNS(9));
        System.out.println(Math.sqrt(10201));
        System.out.println(a.sqrtNS(10201));
        //can't call the function as MathClass.sqrtNS(value) --> not a static method
        //must use dot operator and object --> sqrtNS is part of the MathClass class and not in Main

        MathClass m3 = new MathClass();
        for(int i=0; i<10; i++)
            System.out.println("m3.sqrtNS(" + i + ") = " + m3.sqrtNS(i));
        // Guess what this will print out before running:
        System.out.println("MathClass.getCount() = " + MathClass.getCount());//the getter must be static in order for this to run without an error
        System.out.println("m3.getCount() = " + m3.getCount());

    }

    //Create a function minOf3(double a, double b, double c) That returns the smallest of 3 numbers
    public static double minOf3(double a, double b, double c){
        return java.lang.Math.min(java.lang.Math.min(a, b), c);
    }

}
