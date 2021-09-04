package com.company;

public class Main {

    public static void main(String[] args) {
        // --------------------createMoney()
        int[] a = createMoney(4,115);
        //System.out.println("5 15: " + a[0] + " " + a[1]);
        // -------------------copyMoney()
        int[] b = copyMoney(a);
        a[1] = 50;
        //System.out.println("5 50: " + a[0] + " " + a[1]);
        //System.out.println("5 15: " + b[0] + " " + b[1]);
        // -----------------------dollars()
        //System.out.println("Dollars: 5: " + dollars(a));
        // -------------------------cents()
        //System.out.println("Cents: 50: " + cents(a));
        // ---------------------moneyToString()
        //System.out.println("$5.50: " + moneyToString(a));
        int[] c = createMoney(1,2);
        //System.out.println("$1.02: " + moneyToString(c));
        // ------------------------moneyToText()
        //System.out.println("five dollars and fifty cents: " + moneyToText(a));
        // -----------------------isGreater()
        //System.out.println("isGreater: true: " + isGreaterThan(a,b));
        // ----------------------------isEqual()
        //System.out.println("isEqual: false: " + isEqual(a,b));
        // ----------------------------------adder()
        a = createMoney(3,25);
        b = createMoney(2,20);
        //adder(a,b);
        //System.out.println("$3.30: " + moneyToString(a));
        //System.out.println("$2.20: " + moneyToString(b));
        // ----------------------------------add()
        //b = add(a,b);
        //System.out.println("$3.30: " + moneyToString(a));
        //System.out.println("$5.50: " + moneyToString(b));
        //subber(a,b);
        //----------------------------------sub()
        //System.out.println(moneyToString(sub(a,b)));
        //--------------------------------------payWith20()
        //System.out.println(moneyToString(payWith20(a)));
        //---------------------------------------applyInterest()
        //System.out.println(moneyToString(applyInterest(a, 5)));

    }
    /*
    1. store the dollars amount in first index
    2. store cents amount in second index
    3. if cents value is greater than 100, then increase the dollar value by one and decrease cents by 100
     */
    public static int[] createMoney(int dollars, int cents){
        int [] rv = new int [2];
        rv[0] = dollars;//assigns first index and second index to dollars and cents
        rv[1] = cents;
        while (rv[1] > 99){//keeps going (ex: cents = 200)
            rv[0] += 1;//adds one
            rv[1] -= 100;//subtracts dollar(100)
            System.out.println(rv[0] + " " +rv[1]);
        }
        return rv;
    }

    /*
    1. empty integer array
    2. for each index in array, assign the number in the index of original to rv
     */
    public static  int[] copyMoney(int[] money){
        int [] rv = new int [money.length];
        for (int i = 0; i<money.length; i++){
            rv[i] = money[i];//goes element by element and sets equal to corresponding element in new array
        }
        return rv;
    }

    /*
    1. first index of input array is dollars, return first index
     */
    public static int dollars (int[] money){
        return money[0];//returns first value in array : dollars amount
    }

    /*
    1. second index of array is cents, so return the second value of index
     */
    public static int cents ( int[] money){
        return money[1];//returns second value in array: cents amount
    }

    /*
    1. concat dollar and cents value and return
    2. if cents value is less than zero, the cents string has to be .0
     */
    public static String moneyToString(int[]money){
        if(money[1]<10){
            return "$" + money[0] + ".0" + money[1];//if less than 10, have a zero before cents value
        }
        return "$" + money[0] + "." + money[1];//return concatinated array
    }

    //DO NUMBER SIX HERE
    public static String moneyToText(int[] money){
        String dollar = "", cent = "";
        if (money[0] == 1){
            dollar = oneDigitNumberToText(1)+" dollar ";//if single dollar, then not plural, just dollar
        } else{
            dollar = threeDigitNumber(money[0])+" dollars ";//else then dollars
        }
        if(money[1] == 1){
            cent = oneDigitNumberToText(1) + " cent";//same as last, one cent is singular
        } else {
            cent = threeDigitNumber(money[1]) + " cents";
        }

        if(money[0] != 0 && money[1] == 0){
            return dollar;
        } else if(money[0] != 0 && money[1] == 1){
            return dollar;
        }
        return dollar + cent;
    }

    public static String oneDigitNumberToText(int d){
        String[] s = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        return s[d];//gets ones digit place
    }

    public static String twoDigitNumberToText(int d) {
        String[] tens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        if(d<10){
            return oneDigitNumberToText(d);
        }
        if (d<20){
            return tens[d-10];
        }
        String[] twentyToNinety = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        int onesDigit = d%10, tensDigit = d/10;
        if(onesDigit == 0){
            return twentyToNinety[tensDigit-2];//if it is just 20, return twenty
        }
        return twentyToNinety[tensDigit-2] + " " + oneDigitNumberToText(onesDigit);//if 22, return twenty two
    }

    public static String threeDigitNumber(int d){
        int hundredsDigit = d/100, tensOnesDigit = d%100;//hundreds place number
        if(hundredsDigit>0 && tensOnesDigit == 0){
            return oneDigitNumberToText(hundredsDigit)+"hundred";//if 200 then just two hundred
        }else if(hundredsDigit > 0 && tensOnesDigit!= 0){
           return oneDigitNumberToText(hundredsDigit) + "hundred and " + twoDigitNumberToText(tensOnesDigit);//add digits after
        }
        return twoDigitNumberToText(tensOnesDigit);
    }

    /*
    1. check if cents value isn't above 100, if it is decrease 100 from cents and add one to dollar
    2. compare the dollar index of both inputs
    3. if dollar inputs are the same, then compare the cents inputs
    4. if m1 isn't greater than m2, return false
     */
    public static boolean isGreaterThan(int[] m1, int[] m2){
        while (m1[1] > 99){//keeps going (ex: cents = 200)
            m1[0] += 1;//adds one
            m1[1] -= 100;//subtracts dollar(100)
        }
        while (m2[1] > 99){//keeps going (ex: cents = 200)
            m2[0] += 1;//adds one
            m2[1] -= 100;//subtracts dollar(100)
        }
        if(m1[0]>m2[0]){//compare dollars amount, if equal compare cents amount
            return true;
        } else if(m1[1]>m2[1]) {
            return true;
        } else {
            return false;
        }
    }

    /*
    1. check if both money amounts are true
    2. compare dollars amount if equal
    3. compare cents amount if equal
     */
    public static boolean isEqual(int[] m1, int[] m2){
        if((m1[0] == m2[0]) && (m1[1] == m2[1])){//check if dollars and cents equals each other
            return true;
        } else {
            return false;
        }
    }

    /*
    1. add dollar amounts of each money
    2. add cents amounts of each money
    3. if cents > 99, then subtract 100 cents and add a dollar
    4. if the cents < 10, then add .0 before cent value
    5. return value is void, so have to print within the function
     */
    public static void adder(int[] m1, int[] m2){
        m1[0] += m2[0];//add dollar
        m1[1] += m2[1];//add cents
        while (m1[1]>99){//increase dollar by one if cents >=100
            m1[0] += 1;
            m1[1] -= 100;
        }
        if(m1[1]<10){
            System.out.println("$" + m1[0] + ".0" + m1[1]);//if less than 10, have a zero before cents value
        }
        System.out.println( "$" + m1[0] + "." + m1[1]);//return concatinated array
    }

    /*
    1. same as the previous function
    2. return value is integer array, no print statement
     */
    public static int[] add(int[] m1, int[] m2){
        int [] rv = new int[2];
        rv[0] = m1[0] + m2[0];//add dollars
        rv[1] = m1[1] + m2[1];//add cents
        while (rv[1] > 99){
            rv[1] -= 100;//subtract 100
            rv[0] += 1;//add dollar to rv
        }
        return rv;
    }

    /*
    1. convert both money values to cents, no decimal place
    2. subtract both values
    3. divide by ten
         -> whole number is the dollar value
         -> remainder is the cents value
    4. return value is void, must have print statement
    5. if cents value is less than ten, print with .0
     */
    public static void subber(int[] m1, int[] m2){
        int cents1 = (100*m1[0]) + m1[1];//cents value of m1 is now total cents of money
        int cents2 = (100*m2[0]) + m2[1];//cents value of m2 is now total cents of money
        m1[0] = (cents1 - cents2)/100;//now divided by hundred is the dollar amount in the dollar index m1[0]
        m1[1] = (cents1 - cents2)%100;//now remainder is in cents index m1[1]
        if(m1[1]<10){
            System.out.println("$" + m1[0] + ".0" + m1[1]);//if less than 10, have a zero before cents value
        }
        System.out.println( "$" + m1[0] + "." + m1[1]);
    }

    /*
    1. same as last function
    2. return value is integer array, so assign to empty integer array
     */
    public static int[] sub(int[] m1, int[] m2){
        int [] rv = new int[2];
        int cents1 = (100*m1[0]) + m1[1];
        int cents2 = (100*m2[0]) + m2[1];
        rv[0] = (cents1 - cents2)/100;//subtract dollars
        rv[1] = (cents1 - cents2)%100;//subtract cents
        return rv;
    }

    /*
    1. convert both values to cents (no decimal place)
    2. subtract value from 2000
    3. divide by hundred, whole number is dollar, remainder is cents
     */
    public static  int[] payWith20(int[] owe){
        int [] rv = new int [2];
        int twentyDollar = 2000, givenMoney = (owe[0]*100) + owe[1];//get money in cent value
        rv[0] = (twentyDollar - givenMoney)/100;
        rv[1] = (twentyDollar - givenMoney)%100;
        return rv;
    }

    /*
    1. NO -> original value times the interst value given, then divide by 100 will give the interest value
    2. convert the amount to whole number -> to cents
    3. multiply by decimal interest
    4. take that number and add to original number
    5. take the whole number and divide by 100
          -> integer only returns the whole number of the value
    6. whole number from division is dollars
    7. whole number from remainder is cents
     */
    public static int[] applyInterest(int[] balance, int interest){
        int [] rv = new int [2];
        int orig = (100*balance[0]) + balance[1];//cents value
        orig += ((orig*interest)/100);//adding interest value
        rv[0] = orig/100;//because not double, only whole number remains
        rv[1] = orig%100;//cents value
        return rv;
    }

}
