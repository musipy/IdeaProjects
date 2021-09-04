package com.company;

public class Shape {

    //instance variables
    private final int NUMBER_OF_SIDES;

    //constructors
    public Shape(){//empty
        NUMBER_OF_SIDES = 0;
    }
    public Shape(int num){
        NUMBER_OF_SIDES = num;
    }

    //getter
    public int getNUMBER_OF_SIDES() {
        return NUMBER_OF_SIDES;
    }

    //methods
    public double area(){//must be overridden in each class
        return 0;
    }
    public double perimeter(){//must be overridden in each class
        return 0;
    }

    public String toStr(){
        return "";
    }
}
