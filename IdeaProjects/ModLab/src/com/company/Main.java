package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] b = {1,2,3,4,5,6,7,8,9};
        System.out.println(replaceDigit(123456789,6,7));
    }

    public static int onesDigit (int a) {
        int remainder = 0;
        remainder = a%10;
        return remainder;
    }


    public static int tensOnesDigit (int a) {
        int remainder = 0;
        remainder = a%100;
        return remainder;
    }

    public static int tensDigit(int a){
        int tensones = a % 100;
        int tens = tensones / 10;
        return tens;
    }

    public static int hundredsDigit(int a){
        //if a = 1234
        int hundredTensOnes = a / 100;//12.34
        //hundredTensOnes = 12
        int hundreds = hundredTensOnes % 10; // 1.2
        //hundreds = 2
        return hundreds;
    }

    public static int thousandsDigit(int a){
        //if a = 1234
        int thousandNumber = a / 1000;//1.234
        //thousandNumber = 1
        int thousands = thousandNumber % 10;//0.1
        //thousands = 1
        return thousands;
    }

    public static int countDigits(int a){
        //if a = 1234
        int numberCount = 0;
        while(a != 0){ // while a is not equal to 0
            numberCount +=1;
            a = a/10;
            //first time, a will now equal 123, next loop a = 12, and so on
        }
        return numberCount;
    }

    public static int countEvenDigits(int a){
        //if a = 1234
        int evenNumberCount = 0;
        while(a != 0){
            if(a%2 == 0){
                evenNumberCount += 1;
                //even number / 2 has no remainder
            }
            a = a/10;//a = 123
        }
        return evenNumberCount;
    }

    public static int getDigits(int a, int biggestDigit, int smallestDigit){
        //should give a number within the range of the smallest and biggest digit
        // no exponents, but code program such that it would work like exponents
        int exponent = 1;
        for(int i = 0; i <biggestDigit - smallestDigit + 1; i++){
            exponent = exponent * 10;
        }
        for(int i = 0; i < smallestDigit; i++){
            a /= 10;
        }
        return a%exponent;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~DIGITS PT 2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static int combineDigits(int[] a){
        int rV = 0;
        int exponent = 1;
        for(int i = 0; i<a.length; i++){
            rV += ((a[a.length-(i+1)])*exponent);// taking last number in array and assigning it spot like ones, tens hundreds place.
            exponent *= 10;
        }
        return rV;
    }

    public static int replaceDigit(int number, int newDigitValue, int digitLocation){
        /*
        1. count number of digits
        2. split number into array
        3. replace the old number with new number in designated spot
        4. combine back into intenger with replace number
         */
        int rV = 0;
        int copyOfNumb = number;
        int numberCount = 0;
        //count digits function, could use original function in program
        while(number != 0){
            numberCount +=1;
            number = number/10;
        }
        int a[] = new int[numberCount];
        int remainder = 0;
        int exponent = 1;
        for (int i = 0; i<numberCount; i++){
            remainder = copyOfNumb%10;
            a[numberCount - (i+1)] = remainder;
            copyOfNumb /= 10;
        }
        a[numberCount-1-digitLocation] = newDigitValue;
        //function from above -> combineDigits, included the code inside
        for(int i = 0; i<a.length; i++){
            rV += ((a[a.length-(i+1)])*exponent);
            exponent *= 10;
        }
        return rV;
    }

}
