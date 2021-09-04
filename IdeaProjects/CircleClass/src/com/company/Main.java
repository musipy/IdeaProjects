package com.company;

public class Main {

    public static void main(String[] args) {
        Circle a = new Circle();
        a.radius = 2;
        a.x = 2;
        a.y = 2;
        Circle b = new Circle();
        b.radius = 1;
        b.x = 5;
        b.y = 2;
        Circle c = new Circle();
        c.radius = 1;
        c.x = 4;
        c.y = 2;
        //circleArea test code
        System.out.println(circleArea(a));//12.56
        //circumference test code
        System.out.println(circumference(a));//12.56
        //areaPrint
        areaPrint();//prints a nice table of area and circumference
        //is tangent test code
        System.out.println(isTangent(a,b));//true
        System.out.println(isOverlap(a,b));//false
        //is overlap test code
        System.out.println(isOverlap(a,c));//true
        System.out.println(isTangent(a,c));//false
    }

    public static double circleArea(Circle c){
        //initialize variable
        double area = 0;
        //area of circle = pir^2
        area = (c.radius*c.radius)*3.14;
        //return
        return area;
    }

    public static double circumference(Circle c){
        //initialize variable
        double circum = 0;
        //circumference is 2dpi
        //diameter is two times the radius
        circum = (c.radius * 2) * 3.14;
        //return
        return circum;
    }

    public static void areaPrint(){
        //initialize object of class Circle
        Circle c = new Circle();
        //for radius 3 - 19
        for(int i = 3; i<20; i+= 2){
            //set the value of radius equal to i
            c.radius = i;
            //print out area and circumference
            System.out.println(circleArea(c) + "\t" + circumference(c));
        }
    }

    public static boolean isTangent(Circle a, Circle b){
        //don't need to initialize true or false variable
        //intialize distance variable and define it (between centers of circles)
        //distance formula = sqrt ((x1-x2)^2+(y1-y2)^2)
        double distance = Math.sqrt(((a.x-b.x)*(a.x-b.x)) + ((a.y - b.y)*(a.y-b.y)));
        //see if distance from origins is equal to added radii
        if(distance == a.radius+b.radius){
            //means touches in one spot
            return true;
        }
        //if not then return false
        return false;
    }

    public static boolean isOverlap(Circle a, Circle b){
        //don't need to initialize true or false variable
        //intialize distance variable and define it (between centers of circles)
        //distance formula = sqrt ((x1-x2)^2+(y1-y2)^2)
        double distance = Math.sqrt(((a.x-b.x)*(a.x-b.x)) + ((a.y - b.y)*(a.y-b.y)));
        //if distance < sum of radii then more than one point, if more than no point and if distance = difference of both radii then circle is isnide circle
        //we are only checking if it overlaps so if distance is less than sum of radii
        if(distance < a.radius + b.radius){
            return true;
        }
        //if not then return false
        return false;
    }


}
