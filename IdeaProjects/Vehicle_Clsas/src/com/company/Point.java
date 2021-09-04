package com.company;

public class Point {
    //instance variables
    public double x;
    public double y;

    //constructors
    public Point(){//empty
        x = 0;
        y = 0;
    }
    public Point (double pointX, double pointY){
        x = pointX;
        y = pointY;
    }

    //methods
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
