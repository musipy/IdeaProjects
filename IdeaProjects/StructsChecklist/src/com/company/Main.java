package com.company;

public class Main {

    public static void main(String[] args) {
	    Money m = new Money();
	    m.dollars = 3;
	    m.cents = 90;
	    objectInObject();
    }

    public static void assignment(){
        //initialize object
        Money m = new Money();
        //assign dollars value with dot operator
        //must be an int because that is data type assigned in class for dollars variable
        m.dollars = 3;
        //similarly assign cents value with dot operator (must be in int as well)
        m.cents = 30;
    }

    public static void getValues(){
        //first initialize object and assign values to object with dot operator
        Money m = new Money();
        m.dollars = 3;
        m.cents = 30;
        //now to read values of Money object, use dot operator to access them from the object
        //to access dollars for example
        System.out.println(m.dollars);//should print dollars value 3
        //same with the cents value
        System.out.println(m.cents);//should print cents value 30
    }

    public static boolean objectArgument(Money m){
        //when calling function, m is an object that is passed as an argument
        //can use this within functions
        //this function will check values of dollars and cents value in m
        //if cents value is greater than 50 or dollar value is greater than 5 return true
        //else return false
        if(m.dollars > 5 && m.cents > 50){
            return true;
        }
        return false;
    }

    public static Money returnNew(Money m){
        //already passing an object from Money as an argument
        //have to return new object in the function
        //initialize a new object
        Money m2 = new Money();
        //let us assign the new object the dollars and cents value of the argument
        m2.dollars = m.dollars;
        m2.cents = m.cents;
        //return the new object m2
        return m2;
    }

    public static Money changeArg(Money m){
        //to show difference in changing original argument and returning new object
        // we are returning the new object in this function
        // but printing the results of the change of the original argument passed
        //intialize new object
        Money m2 = new Money();
        //print the original passed argument for comparison later
        System.out.println("dollars: " + m.dollars + "& cents: " + m.cents);
        //now change the dollars value and cents value of original argument passed to 5 and 50
        m.dollars = 5;
        m.cents = 50;
        //print the change
        System.out.println("dollars: " + m.dollars + "& cents: " + m.cents);//this should print dollars: 5 & cents: 50
        //now assign values to the new m2 to return the variable --> this is seperate from the argument passed
        m2.dollars = 10;
        m2.dollars = 60;
        return m2;//we are returning this new object, but reassigning values to the argument there is a difference
    }

    public static void objectLoop(){
        //initialize an array of object we traverse through --> each element is an object
        Money[] m = new Money[5];//object array with 5 elements
        //traverse through array with a for loop
        for(int i = 0; i<m.length; i++){
            //each element must be a new object, so initialize another object in beginning of for loop
            m[i] = new Money();
            //assign dollars and cents value to m[i] now, have it incrementing 1.10 to 5.50
            m[i].dollars = i+1;
            m[i].cents = (i+1)*10;
            //print out results
            System.out.println("$" + m[i].dollars + "." + m[i].cents);
        }
    }

    public static void convertType (){
        //initialize a double
        double a = 1.55;
        //initialize an int through a casting method --> using (int)
        int b = (int)a;
        //print both to see difference through casting
        System.out.println(a);
        System.out.println(b);
    }

    public static void rounding (Money m){
        //intialize a new object
        Money rv = new Money();
        //now see the value of the cents of object if greater than 50 or less than 50
        //if greater than or equal to 50 round up, else round down
        if(m.cents >= 50){
            rv.dollars = m.dollars + 1;
            rv.cents = 0;
        } else if(m.cents < 50){
            rv.dollars = m.dollars;
            rv.cents = 0;
        }
        //print results
        System.out.println("$" + rv.dollars + ".0" + rv.cents);
    }

    public static void objectInObject (){
        //let us make a function which adds $1.05 to each previous money value
        //objects in an array --> object array
        System.out.println("D\tC");
        //initalize an object
        Money original = new Money();
        original.dollars = 0;
        original.cents = 0;
        //initialize array of objects
        Money[] monies = new Money[5];
        //there are going to be multiple objects within an object loop
        for(int i = 0; i<monies.length; i++){
            //each new lemenet must be an object
            monies[i] = new Money();
            monies[i].dollars = original.dollars+1;
            monies[i].cents = original.cents+5;
            //setting equal so you can add on to previous
            //here we use the objects within an object array and use two objects to set equal to each other within this array
            original = monies[i];
            System.out.println(monies[i].dollars +"\t"+ monies[i].cents);
        }
    }

    public static void objectPointer(Money d){
        //initialize a new object array to demonstrate pointers
        Money[] monies = new Money[5];
        //traverse through array
        for(int i = 0; i<monies.length; i++){
            //each new element is an object
            monies[i] = new Money();//this is an object
            monies[i].dollars = d.dollars ++;//this is a pointer
            System.out.println(monies[i].dollars);
        }
    }
}

