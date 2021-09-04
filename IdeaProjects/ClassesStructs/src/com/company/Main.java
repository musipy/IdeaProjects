package com.company;

public class Main {

    public static void main(String[] args) {
	    /*Money m1 = new Money();
	    m1.dollars = 10;
	    m1.cents = 10;
	    Money m2 = new Money();
	    m2.dollars = 20;
	    m2.cents = 20;
	    System.out.println(moneyToString(applyInterest(m1, 5)));*/
        Point p1 = new Point();
        p1.x = 2.0;
        p1.y = 3.0;
        Point p2 = new Point();
        p2.x = 3;
        p2.y = 4;
        //verticalShift(p1,-2.6);
        System.out.println(moneyToString(testCodeMoneyc()));
    }

    public static String moneyToString(Money m){
        //if the cents value is greater than 99, then you must add respective amount of dollars to the dollars value and chnage the cents value
        if (m.cents >99){
            m.dollars += m.cents/100;
            m.cents = m.cents%100;
        }
        //check if less than 10 --> if less than 10 must return a zero before the cents value (ex: .09 || .00)
        if (m.cents<10) {
            return "$" + m.dollars + ".0" + m.cents;
        }
        // if not then just return value in dollar and cents form without the extra value
        return "$" + m.dollars + "." + m.cents;
    }

    public static Money add(Money m1, Money m2){
        //intitialize two total int values for dollars and cents
        int totalD = m1.dollars + m2.dollars;
        int totalC = m1.cents + m2.cents;
        //create new object to store the two values
        Money total = new Money();
        //assign total dollars to the dollars value and total cents to the cents value
        total.dollars = totalD;
        total.cents = totalC;
        return total;
    }

    public static Money payWith20(Money m){
        //initialize new object from Money
        Money change = new Money();
        //convert given money value to cents (9.02 --> 902)
        int totalC = (m.dollars*100) + m.cents;
        //subtract to get change in cents value
        int totalChange = 2000 - totalC;
        //set dollars and cents of new money object to the change divided by 100 and remainder of 100
        change.dollars = totalChange/100;
        change.cents = totalChange%100;
        return change;//return
    }

    public static Money testCodeMoneya(){
        //intialize new object to change and assign values to each index of the 100 element array
        Money amt = new Money();
        Money[] moneyVal = new Money[100];
        Money total = new Money();
        //assigning each spot as an object with increasing values
        for(int i = 0; i<100; i+=2){
            moneyVal[i] = amt;
            moneyVal[i+1] = amt;
            //check if it is last two indexes --> 99 has to be one dollar
            if(i == 98){
                moneyVal[98].dollars = 0;
                moneyVal[98].cents = 99;
                moneyVal[99].dollars = 1;
                moneyVal[99].cents = 0;
                //add the two indexes and increase total amount
                total.dollars += add(moneyVal[i], moneyVal[i+1]).dollars;
                total.cents += add(moneyVal[i], moneyVal[i+1]).cents;
            } else {
                //assign every two indexes by increasing cents value of each but keep dollars value zero
                moneyVal[i].dollars = 0;
                moneyVal[i].cents = i+1;
                moneyVal[i+1].dollars = 0;
                moneyVal[i+1].cents = i+2;
                //add the two up and increase the total
                total.dollars += add(moneyVal[i], moneyVal[i+1]).dollars;
                total.cents += add(moneyVal[i], moneyVal[i+1]).cents;
            }
        }
        return total;//return total object
    }

    public static String pointToString(Point p){
        //return with parenthesis x and y
        return "(" + p.x + "," + p.y + ")";
    }

    public static Point midpoint(Point p1, Point p2){
        //make a new point object
        Point mid = new Point();
        //make x and y the avg of both points
        mid.x = (p1.x + p2.x)/2;
        mid.y = (p1.y + p2.y)/2;
        return mid;//return
    }

    public static boolean isEqual(Point p1, Point p2){
        //compare both values if equal return true
        if (p1.x == p2.x && p1.y == p2.y){
            return true;
        }
        //return false if not equal
        return false;
    }

    public static int quadrant(Point p){
        //return variable integer vlaue with quadrant number
        /*
            2   |    1
        _________________
            3   |    4
         */
        int rv = 0;
        if(p.x > 0 && p.y > 0){
            rv = 1;
        } else if (p.x < 0 && p.y > 0){
            rv = 2;
        } else if (p.x < 0 && p.y < 0){
            rv = 3;
        } else if (p.x > 0 && p.y < 0){
            rv = 4;
        }
        return rv;
    }

    public static void verticalStretch(Point p, double a){
        //change the y value of p to a new value --> multiply the a given
        p.y = p.y * a;
        //print point using pointToString function
        System.out.println(pointToString(p));
    }

    public static void horizontalStretch(Point p, double a){
        //change the x value of p to a new value --> multiply the a given
        p.x = p.x * a;
        //print point using pointToString function
        System.out.println(pointToString(p));
    }

    public static void verticalShift(Point p, double a){
        //change the y value of p to a new value --> add the a given
        p.y = p.y + a;
        //print point using pointToString function
        System.out.println(pointToString(p));
    }

    public static void horizontalShift(Point p, double a){
        //change the x value of p to a new value --> add the a given
        p.x = p.x + a;
        //print point using pointToString function
        System.out.println(pointToString(p));
    }

    public static Money applyInterest(Money m, double interestRate){
        Money newTotal = new Money();
        //make the cents value the entire money value in cents
        newTotal.cents = m.cents + (m.dollars * 100);
        //assuming its in percentage form (the interest rate)
        double newC = newTotal.cents*(interestRate/100);
        //now must round because the cents and dollars value are in integer form
        if((newC*10)%10 >= 5){
            newC = (int)(newC + 1);
        } else {
            newC = (int)(newC);
        }
        //add the interest money to the total cents
        newTotal.cents += newC;
        //divide by 100 for the dollars and remainder of 100 is cents
        newTotal.dollars = newTotal.cents/100;
        newTotal.cents = newTotal.cents%100;
        return newTotal;
    }

    public static Point[] testCodePointa(){
        //create an array with each element as pointer to Point
        Point[] points = new Point[5];
        for(int i = 0; i<5; i++){
            //each element is an object
            points[i] = new Point();
            //creating even numbers
            points[i].x = (int)((i+1)*2);
            //plugging into function 2x+3 to get y value
            points[i].y = (int)((2*points[i].x) + 3);
            //System.out.println(pointToString(points[i]));
        }
        return points;
    }

    public static void testCodePointb(){
        //traverse through array
        for(int i = 0; i<5; i++){
            //use vertical stretch method and array from test Code Point a and three as parameters
            verticalStretch(testCodePointa()[i], 3);
        }
    }

    public static void testCodePointc(){
        //traverse through array
        for(int i = 0; i<5; i++){
            //use horizontal shift method and array from test Code Point a and three as parameters
            horizontalStretch(testCodePointa()[i], 2);
        }
    }

    public static void testCodePointd(){
        //traverse through array
        for(int i = 0; i<5; i++){
            //use vertical shift method and array from test Code Point a and three as parameters
            verticalShift(testCodePointa()[i], -1);
        }
    }

    public static void testCodePointe(){
        //traverse through array
        for(int i = 0; i<5; i++){
            //use horizontal shift method and array from test Code Point a and three as parameters
            horizontalShift(testCodePointa()[i], 2);
        }
    }

    public static void testCodePointg(){
        for(int i = 0; i<5; i++){
            Point newPoint = new Point();//set a new object equal to the current element so you can alter y value.
            newPoint = testCodePointa()[i];
            //hard code the vertical shift and stretch function to avoid printing
            newPoint.y += 2; //vertical shift by 2
            verticalStretch(newPoint, 2);//print and vertical shift by 2
        }
    }

    public static void testCodePointh(){
        for(int i = 0; i<5; i++){
            Point newPoint = new Point();//set a new object equal to the current element so you can alter y value.
            newPoint = testCodePointa()[i];
            //hard code the vertical shift and stretch function to avoid printing
            newPoint.y *= 2; //vertical stretch by 2
            verticalShift(newPoint, 2);//print and vertical shift by 2
        }
    }

    public static Point[] testCodePointf(){
        //initialize object array
        Point[] sines = new Point[5];
        //create a for loop to transverse through array
        for(int i = 0; i<5; i++){
            //each new element is a new object
            sines[i] = new Point();
            //to get x values
            sines[i].x = (i*3.14)/2;
            //to get y values
            if(sines[i].x == 0 || sines[i].x == 3.14){
                sines[i].y = 0;
            } else if(sines[i].x == 1.57){
                sines[i].y = 1;
            } else if(sines[i].x == 4.71){
                sines[i].y = -1;
            }
        }
        return sines;
    }

    public static Money testCodeMoneyb(){
        //initialize object to count total amount of money
        Money totalMoney = new Money();
        //initialize total cents variable --> for rounding step --> must be double so can multiply by a decimal
        double totalCents = 0;
        //put on a loop for 365 days
        for(int i = 1; i<367; i++) {
            //add ten dollars to dollars part of object
            totalMoney.dollars += 10;
            //see if it matches the respective day at the end of each month i
            if(i == 31 || i == 59 || i == 90 || i == 120 || i == 151 || i == 181 || i == 212 || i == 243 || i == 273 || i == 304 || i == 334 || i == 365){
                //apply interest --> can't use applyInterest function --> must round down, applyInterest rounds up and down
                //convert to cents
                totalCents = (totalMoney.dollars*100) + totalMoney.cents;
                //add interest value
                totalCents = totalCents + (totalCents * 0.001);
                //convert to integers and assign values to dollars and cents to totalMoney
                totalMoney.dollars = (int)(totalCents/100);
                totalMoney.cents = (int)(totalCents%100);
            }
        }
        //return totalMoney
        return totalMoney;
    }

    public static Money testCodeMoneyc(){
        //initialize new object
        Money change = new Money();
        //initialize an object for the total amount of money
        Money total = new Money();
        //initialize one more object to store value after applying interest
        Money interest = new Money();
        //Thomas Bagels Plain pre Sliced 6 count --> 4.99
        //Breyers Ice Cream OREO Cookies & Cream --> 3.00
        //Breyers Ice Cream Original French Vanilla --> 3.00
        //Pillsbury Moist Supreme Cake Mix Premium Devils Food --> 1.25
        //Dweightwatchers Smart Ones Main Street Bistro Chicken Fettuccini Frozen Food --> 2.50
        //total w/o tax = 14.74
        total.dollars = 14;
        total.cents = 74;
        //city tax rate = 8.25%
        //total w/ tax = 15.96
        interest = applyInterest(total, 8.25);
        //change w/20 = 4.04
        //use payWith20 for change
        change = payWith20(interest);
        return change;
    }

}
