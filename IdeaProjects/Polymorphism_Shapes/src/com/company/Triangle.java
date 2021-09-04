package com.company;

public class Triangle extends Shape {

    //instance variables
    private double sideA;
    private double sideB;
    private double sideC;
    private double base;
    private double height;

    //constructors
    public Triangle(){
        super(3); // use constructor from Shape (num of sides)
    }
    public Triangle(double a, double b, double c, double baseNum, double h){
        super(3);//use constructor from shape (# sides)
        sideA = a;
        sideB = b;
        sideC = c;
        base = baseNum;
        height = h;
    }

    //getters
    public double getSideA(){ return sideA; }
    public double getSideB(){ return sideB; }
    public double getSideC(){ return sideC; }
    public double getBase(){ return base; }
    public double getHeight(){ return height; }
    //setters
    public void setSideA(double a){ sideA = a; }
    public void setSideB(double b){ sideB = b; }
    public void setSideC(double c){ sideC = c; }
    public void setBase(double baseNum){ base = baseNum; }
    public void setHeight(double h){ height = h; }

    //methods
    public String toStr(){
        return "Triangle with 3 sides, side lengths = "+sideA+","+sideB+","+sideC+", base = "+base+", height = "+height;
    }
    //overridden methods
    public double area(){
        return base * height * 0.5;
    }
    public double perimeter(){
        return sideA + sideB + sideC;
    }
}
