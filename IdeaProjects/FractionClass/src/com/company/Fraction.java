package com.company;

public class Fraction {
    // Constants (Final Static Variables)

    // Static/Class Variables
    private static int objectCount = 0; // Number of Fractions created
    private static int methodCount = 0; // Number of times methods have been called.

    // Nonstatic/Instance Variables
    private int numerator;
    private int denominator;

    // Constructors
    public Fraction(){//empty constructor
        numerator = 0;
        denominator = 0;
        objectCount++;
    }
    public Fraction(int n, int d){//value assign constructor
        numerator = n;
        denominator = d;
        objectCount++;
    }
    public Fraction(Fraction f){//copy contructor
        numerator = f.numerator;
        denominator = f.denominator;
        objectCount++;
    }

    // Getters/Setters
    public int getNumerator() {//numerator getter
        return numerator;
    }
    public int getDenominator() {//denominator getter
        return denominator;
    }
    public static int getObjectCount() {//objectCount getter
        return objectCount;
    }
    public static int getMethodCount() {//methodCount getter
        return methodCount;
    }
    public void setNumerator(int n) {//numerator setter
        numerator = n;
    }
    public void setDenominator(int d) {//denominator setter
        denominator = d;
    }

    // Static Methods
    public static int integerPart(Fraction f){
        methodCount++;
        return f.numerator/f.denominator;//must use dot operator
    }

    public static int abs(int a){
        methodCount++;
        if(a>0){//if its already positive don't return it with a negative sign, just return original value
            return a;
        }
        return a*-1;//if negative multiply by negative one to get it to be positive
    }

    public static Fraction min(Fraction a, Fraction b){
        methodCount++;
        //again if change the values to doubles, then can get exact value and life will be easier
        if((double)a.numerator / a.denominator < (double)b.numerator / b.denominator){
            return a;
        }
        return b;
    }

    public static Fraction max(Fraction a, Fraction b){
        methodCount++;
        //again if change the values to doubles, then can get exact value and life will be easier
        if((double)a.numerator / a.denominator > (double)b.numerator / b.denominator){
            return a;
        }
        return b;
    }

    public static Fraction[] quadraticFormula(Fraction a, Fraction b, Fraction c){
        if(a.numerator == 0){
            return null;
        }
        //get the radical value first
        Fraction product1 = a.product(c);
        product1.numerator *= 4;
        b.numerator *= b.numerator;
        b.denominator *= b.denominator;
        Fraction radical = (product1.difference(b)).sqrt();
        //create an array
        Fraction[] fractions = new Fraction[2];
        //check if the inside of the radical is positive
        if(min(b,product1) == b){
            return null;//if it isn't return null
        } else {
            Fraction result1 = (radical.difference(b));
            fractions[0] = result1.simplified();//this is the simple subtract one --> radical - b
        }
        if(b.isPositive() == true){//then comes the negative, have to check if b is negative or not, so we can use distributive property and multiply it all by negative.
            Fraction result2 = (b.sum(radical)).quotient(a);
            result2.numerator *= -1;
            result2.denominator *= 2;
            fractions[1] = result2;
        } else if (b.isPositive() == false){
            b.numerator = abs(b.numerator);
            b.denominator = abs(b.denominator);
            Fraction result2 = (b.sum(radical)).quotient(a);
            result2.numerator *= -1;
            result2.denominator *= 2;
            fractions[1] = result2;
        }
        return fractions;//return the array
    }

    // Non static Methods
    public String toString(){
        methodCount++;
        return numerator + "/" + denominator;//concat numerator and denominator
    }

    public String toMixedNumber(){
        methodCount++;
        if(numerator<denominator){//check and see if it is an improper fraction in the first place
            return numerator + "/" + denominator;
        }
        int wholeNum = numerator / denominator;//whole number of the improper fraction
        int rem = numerator % denominator;//remainder will be the new denominator
        if (rem == 0){//check if it is a whole number after simplifying the improper fraction
            return ""+wholeNum;
        }
        return wholeNum + " " + numerator + "/" + denominator;
    }

    public int remainder(){
        methodCount++;
        return numerator % denominator; // don't have to use getters because function is non-static
    }

    public boolean isError(){
        methodCount++;
        if(denominator == 0){//don't have to use getter because method is non-static
            return true;
        }
        return false;//if not divide by zero automatically return false
    }

    public boolean isPositive(){
        methodCount++;
        if(numerator > 0 && denominator > 0){//numerator and denominator are positive, then fraction is positive
            return true;
        } else if (numerator < 0 && denominator < 0){//if both are negative, the fraction is still positive
            return true;
        }
        return false;
    }

    public boolean equals(Fraction f){
        methodCount++;
        //convert all numbers to doubles (makes it easier to compare)
        double dubNum = (double)numerator;
        double dubDen = (double)denominator;
        double fNum = (double)(f.numerator);
        double fDen = (double)(f.denominator);
        double origNum = dubNum/dubDen;
        double paramNum = fNum/fDen;
        if(origNum == paramNum){//double will give exact comparison value
            return true;
        }
        return false;
    }

    public boolean isSimplified(){
        methodCount++;
        for(int i = 2; (i<=abs(numerator) || i <= abs(denominator)); i++){//skipped 1 because all numbers are technically divisible by 1 so it wouldn't count. Also skipped 0 since can't divide by zero
            if (abs(numerator)%i == 0 && abs(denominator)%i == 0){//take absolute value since we are increasing i with positive numbers
                return false;
            }
        }
        if(numerator < 0 && denominator < 0){
            return false;
        }
        return true;
    }

    public void simplify(){
        methodCount++;
        //make everything the right sign first
        if((numerator < 0 && denominator > 0) || ((numerator > 0) && denominator < 0)){
            if (numerator > 0 && denominator < 0){
                numerator *= -1;
                denominator = abs(denominator);
            }
        } else if (numerator < 0 && denominator < 0){
            numerator = abs(numerator);
            denominator = abs(denominator);
        }
        while(isSimplified() == false){
            for(int i = 2; i<= abs(numerator); i++){
                if(numerator%i == 0 && denominator%i == 0){
                    numerator /= i;
                    denominator /= i;
                }
            }
        }
    }

    public Fraction simplified(){
        methodCount++;
        int origNum = numerator;
        int origDen = denominator;
        Fraction a = new Fraction(new Fraction(numerator, denominator));
        //make everything the right sign first
        if((a.numerator < 0 && a.denominator > 0) || ((a.numerator > 0) && a.denominator < 0)){
            if (a.numerator > 0 && a.denominator < 0){
                a.numerator *= -1;
                a.denominator = abs(a.denominator);
            }
        } else if (a.numerator < 0 && a.denominator < 0){
            a.numerator = abs(a.numerator);
            a.denominator = abs(a.denominator);
        }
        while(a.isSimplified() == false){
            for(int i = 2; i<= a.abs(numerator); i++){
                if(a.numerator%i == 0 && a.denominator%i == 0){
                    a.numerator /= i;
                    a.denominator /= i;
                }
            }
        }
        return a;
    }

    public Fraction sum(Fraction a){
        methodCount++;
        int sumDen = denominator * a.denominator;//find new denominator
        int newNumOrig = numerator * a.denominator;//get new numerators for both fractions
        int newNuma = a.numerator * denominator;
        int sumNum = newNumOrig + newNuma;
        Fraction s = new Fraction(sumNum, sumDen);//create a new object
        return s.simplified();//return it simplified
    }

    public static Fraction sum(Fraction[] a){
        methodCount++;
        Fraction totalSum = new Fraction();
        for(int i = 0; i<a.length-1; i+=2){//add two each time so we don't repeat
            totalSum.numerator += a[i].sum(a[i+1]).numerator;//add the sum to the numerator portion
            totalSum.denominator += a[i].sum(a[i+1]).denominator;//add the sum to the denominator portion
        }
        return totalSum;
    }

    public Fraction difference(Fraction a){
        methodCount++;
        int sumDen = denominator * a.denominator;//find new denominator
        int newNumOrig = numerator * a.denominator;//get new numerators for both fractions
        int newNuma = a.numerator * denominator;
        int difNum = newNumOrig - newNuma;
        Fraction s = new Fraction(difNum, sumDen);//create a new object
        return s.simplified();
    }

    public Fraction product(Fraction a){
        methodCount++;
        int newDen = denominator * a.denominator;//multiply denominator
        int newNum = numerator * a.numerator;//multiply numerator
        Fraction p = new Fraction(newNum, newDen);//create new object
        return p.simplified();//return it simplified
    }

    public Fraction quotient(Fraction a){
        methodCount++;
        int newDen = denominator * a.numerator;//multiply denominator by numerator
        int newNum = numerator * a.denominator;//multiply numerator by denominator
        Fraction p = new Fraction(newNum, newDen);//create new object
        return p.simplified();//return it simplified
    }

    public Fraction sqrt(){
        int newNum = MathClass.sqrtNS(numerator);//I made the sqrtNS static
        int newDen = MathClass.sqrtNS(denominator);//I made the sqrtNS static
        Fraction s = new Fraction(newNum, newDen);
        return s;
    }

    public Fraction[] partialPartialFractionDecomposition(){
        //make a copy of this fraction to use later
        Fraction copy = new Fraction (numerator, denominator);
        //store factors
        //create an rv array --> needs to be a length of factors
        //initialize each element in rv with numerator of 0 and denominator of corresponding factor array value
        //traverse through array to find what to make numerators
        //INSIDE A LOOP
            //save the factor to an array
            //get a remainder to keep subtracting
        //when there is still a remainder add it to the array with the last factor in the array
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Find out what the factors are --> can use quotiant rule method to do so
        //then find the common denominator / gcd
        //multiply both sides (essentially kind of like how we did the si
        // simplify function
        //add corresponding sides to get a total fraction on both sides
        return null;
    }




}
