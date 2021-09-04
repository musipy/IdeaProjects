package com.company;

public class Circle extends Shape {

    //instance variables
    private double radius;
    private double centerX;
    private double centerY;

    //constructors
    public Circle(){//empty
        super(1);//use constructor rom the super class
    }
    public Circle(double r, double x, double y){
        super(1);//use the constructor from the super class
        radius = r;
        centerX = x;
        centerY = y;
    }

    //getters
    public double getRadius(){ return radius; }
    public double getCenterX(){ return centerX; }
    public double getCenterY(){ return centerY; }
    //setters
    public void setRadius(double r){ radius = r; }
    public void setCenterX(double x){ centerX = x; }
    public void setCenterY(double y){ centerY = y; };

    //methods
    public String toStr(){
        return "Circle with 1 side, radius = " + radius + " and center = (" + centerX + "," + centerY + ")";
    }
    //overridden methods
    public double area(){
        return radius * radius * Math.PI;
    }
    public double perimeter(){
        return 2 * radius * Math.PI;
    }
}
