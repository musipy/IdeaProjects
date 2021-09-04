package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        task5and6();
    }


    //HELPER FUNCTIONS
    //MAKES EASIER IN THE OVERALL task5and6() METHOD UNDERNEATH
    //JUST CLEANER

    //CIRCLE
    public static Circle circleAsk(){
        Scanner s1rad = new Scanner(System.in);
        //store radius
        System.out.println("Please enter the radius of your circle. (cannot be 0)");//ask radius
        double rad = s1rad.nextDouble();
        while (rad == 0){ //make sure the user does not input zero --> keep going until they don't input zero
            Scanner newVal = new Scanner(System.in);
            System.out.println("do not enter zero");
            rad = newVal.nextDouble();
        }
        //store x coordinate
        Scanner s1x = new Scanner(System.in);
        System.out.println("Please enter the x coordinate of the center of your circle. (cannot be 0)");//ask for center x
        double xCoord = s1x.nextDouble();
        //store y coordinate
        Scanner s1y = new Scanner(System.in);
        System.out.println("Please enter the y coordinate of the center of your circle. (cannot be 0)");//ask for center y
        double yCoord = s1y.nextDouble();
        return new Circle(rad, xCoord, yCoord);
    }

    //TRIANGLE
    public static Triangle triangleAsk(){
        //store sideA
        Scanner s1a = new Scanner(System.in);
        System.out.println("Please enter the length of one side of your triangle. (cannot be 0)");//ask for a
        double a = s1a.nextDouble();
        while (a == 0){//make sure the user does not input zero --> keep going until they don't input zero
            Scanner newVal = new Scanner(System.in);
            System.out.println("do not enter zero");
            a = newVal.nextDouble();
        }
        //store sideB
        Scanner s1b = new Scanner(System.in);
        System.out.println("Please enter the length of another side of your triangle. (cannot be 0 and equal to the previous entered value)");//ask for b
        double b = s1b.nextDouble();
        while (b == 0){//make sure the user does not input zero --> keep going until they don't input zero
            Scanner newVal = new Scanner(System.in);
            System.out.println("do not enter zero");
            b = newVal.nextDouble();
        }
        //store sideC
        Scanner s1c = new Scanner(System.in);
        System.out.println("Please enter the length of another side of your triangle.(cannot be 0)");//ask for c
        double c = s1c.nextDouble();
        while (c == 0){//make sure the user does not input zero --> keep going until they don't input zero
            Scanner newVal = new Scanner(System.in);
            System.out.println("do not enter zero");
            c = newVal.nextDouble();
        }
        //store base
        Scanner s1base = new Scanner(System.in);
        System.out.println("Please enter the length of the base of your triangle. (cannot be 0)");//ask for base
        double base = s1base.nextDouble();
        while (base == 0){//make sure the user does not input zero --> keep going until they don't input zero
            Scanner newVal = new Scanner(System.in);
            System.out.println("do not enter zero");
            base = newVal.nextDouble();
        }
        //store height
        Scanner s1height = new Scanner(System.in);
        System.out.println("Please enter the length of the height of your triangle. (cannot be 0)");//ask for height
        double height = s1height.nextDouble();
        while (height == 0){//make sure the user does not input zero --> keep going until they don't input zero
            Scanner newVal = new Scanner(System.in);
            System.out.println("do not enter zero");
            height = newVal.nextDouble();
        }
        return new Triangle(a, b, c, base, height);
    }

    //RECTANGLE
    public static Rectangle rectangleAsk(){
        //store length
        Scanner s1l = new Scanner(System.in);
        System.out.println("Please enter the length of your rectangle. (cannot be 0)");//ask for length
        double l = s1l.nextDouble();
        while (l == 0){//make sure the user does not input zero --> keep going until they don't input zero
            Scanner newL = new Scanner(System.in);
            System.out.println("do not enter zero");
            l = newL.nextDouble();
        }
        //store width
        Scanner s1w = new Scanner(System.in);
        System.out.println("Please enter the width of your rectangle. (cannot be 0)");//ask for width
        double w = s1w.nextDouble();
        while (w == 0){//make sure the user does not input zero --> keep going until they don't input zero
            Scanner newW = new Scanner(System.in);
            System.out.println("do not enter zero");
            w = newW.nextDouble();
        }
        return new Rectangle(l, w);
    }

    //COMPLETE AND FULL METHOD task5and6()
    public static void task5and6(){
        Shape[] shapes = new Shape[3];
        for (int i = 0; i<3; i++) {
            Scanner s1 = new Scanner(System.in);
            int shape1sides;
            if (i == 0){
                System.out.println("How many sides does your first shape have?(You must enter 0, 3, or 4)");// first time in loop
            } else if (i == 1){
                System.out.println("How many sides does your second shape have?(You must enter 0, 3, or 4)");// second time in loop
            } else {
                System.out.println("How many sides does your third shape have?(You must enter 0, 3, or 4)");// third time in the loop
            }
            shape1sides = s1.nextInt();
            if (shape1sides == 0) {//check if it is a circle
                shapes[i] = circleAsk();
            } else if (shape1sides == 3) {//check if it is a triangle
                shapes[i] = triangleAsk();
            } else if (shape1sides == 4) {//check if it is a rectangle
                shapes[i] = rectangleAsk();
            } else {
                System.out.println("error");
                i = 2;//will break out of the for loop
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////

        //for loop now to print out values
        for(int i = 0; i<3; i++){
            if(shapes[i] == null){
                i = 2; // breaks if there is no object stored
            } else {
                String str = shapes[i].toStr();
                str += ", perimeter = " + shapes[i].perimeter() + ", area = " + shapes[i].area();
                System.out.println(str);
            }
        }
    }


}
