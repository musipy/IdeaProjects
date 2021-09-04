package com.company;

public class Car extends Vehicle{
    //instance variables
    public int doorNum;
    public String engine;

    //constructors
    public Car(){
        doorNum = 1; // can't have a car with 0 doors, so at least a minimum of 1 door
        engine = "";
    }
    public Car(int d, String motor){
        doorNum = d;
        engine = motor;
    }

    //methods
    //override
    public void communicate(){
        System.out.println("Honk honk!");
    }
    public String toString(){
        if(doorNum == 1){
            return "This is a" + engine + "car with" + doorNum + "door.";
        }
        return "This is a" + engine + "car with" + doorNum + "doors.";
    }
}
