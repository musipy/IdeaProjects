package com.company;

public class Airplane extends Vehicle {
    //instance variables
    public String flightNum;

    //constructors
    public Airplane(){
        flightNum = "";
    }
    public Airplane(String fNum){
        flightNum = fNum;
    }

    //methods
    //override functions
    public void communicate() {
        System.out.println("Tower, this is flight" + flightNum + " . Requesting permission to land.");
    }
    public String toString(){
        return  "This is an airplane, flight number" + flightNum + ".";
    }
}
