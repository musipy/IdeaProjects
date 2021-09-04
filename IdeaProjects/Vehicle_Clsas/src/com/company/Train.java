package com.company;

public class Train extends Vehicle {
    //instance variables
    public int boxCar;

    //constructors
    public Train(){
        boxCar = 0;
    }
    public Train(int bx){
        boxCar = bx;
    }

    //methods
    //override
    public void communicate(){
        System.out.println("I think I can, I think I can!");
    }
    public String toString(){
        return "This is a train, all aboard!";
    }
}
