package com.company;

public class Rectangle extends Shape {

    //instance variables
    private double length;
    private double width;

    //constructors
    public Rectangle(){//empty
        super(4);//use constructor from Shape
    }
    public Rectangle(double l, double w){
        super(4);//use constructor from Shape (defines number of sides)
        length = l;
        width = w;
    }

    //getters
    public double getLength(){ return length; }
    public double getWidth(){ return width; }
    //setters
    public void setLength(double l){ length = l; }
    public void setWidth(double w){ width = w; }

    //methods
    public String toStr(){
        return "Rectangle with 4 sides, length = " + length + " and width = " + width;
    }
    //overridden methods
    public double area(){
        return length * width;
    }
    public double perimeter(){
        return (2 * length) + (2 * width);
    }
}
