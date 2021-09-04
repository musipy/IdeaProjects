package com.company;

public class Vehicle {
    //instance variables
    public int seats;
    public int passenger;
    public double currentPositionX;
    public double currentPositionY;
    public double destinationX;
    public double destinationY;
    public int topSpeed;

    //constructors
    public Vehicle(){//empty
        seats = 0;
        passenger = 0;
        currentPositionX = 0;
        currentPositionY = 0;
        destinationX = 0;
        destinationY = 0;
        topSpeed = 0;
    }
    public Vehicle(int s, int p, double cpX, double cpY, double dX, double dY, int ts){
        seats = s;
        passenger = p;
        currentPositionX = cpX;
        currentPositionY = cpY;
        destinationX = dX;
        destinationY = dY;
        topSpeed = ts;
    }

    //methods
    public void communicate(){
        System.out.println("Hey You!");
    }

    public String toString(){
        return "This is a vehicle";
    }

    //overload
    public int speedCompareTo(Vehicle v){//original from superclass
        return this.topSpeed - v.topSpeed;//return the object called from minus the object in the parameter
    }
    public int speedCompareTo(Airplane a){
        return this.topSpeed - a.topSpeed;//return the object called from minus the object in the parameter
    }
    public int speedCompareTo(Car c){
        return this.topSpeed - c.topSpeed;//return the object called from minus the object in the parameter
    }
    public int speedCompareTo(Train t){
        return this.topSpeed - t.topSpeed;//return the object called from minus the object in the parameter
    }

    public double distanceTo(Vehicle v){
        //must use the distance formula: sqrt((x2-x1)^2 + (y2-y1)^2)
        //x2 and y2 is destinationX and destinationY
        //x1 and y1 is currentPositionX and currentPositionY
        //find square of each part of the sum under the readical
        double xSquared = (destinationX - currentPositionX) * (destinationX - currentPositionX);
        double ySquared = (destinationY - currentPositionY) * (destinationY - currentPositionY);
        //now add both sides
        double sum = xSquared + ySquared;
        //return the square root
        return Math.sqrt(sum);
    }
}
