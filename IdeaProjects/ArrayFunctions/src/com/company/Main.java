package com.company;

public class Main {

    public static void main(String[] args) {
        int[] b = {1,2,3,4,0,6,0,0,-9,10};//33
        printArray(splitDigits(123456789));
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~PART ONE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static int sum(int[] a) {
        int rV = 0;
        for(int i = 0; i<a.length; i++){
            rV += a[i];//adding the sum of each digit
        }
        return rV;
    }//End sum()

    public static int countZero(int[] a){
        int rV = 0;
        for(int i = 0; i<a.length; i++){
            if(a[i] == 0){
                rV +=1;//adding to rV if 0
            }
        }
        return rV;
    }//End of countZero

    public static int countPositive(int[] a){
        int rV = 0;
        for(int i = 0; i<a.length; i++){
            if(a[i]>0){
                rV += 1;//adding to rV if positive (greater than 0)
            }
        }
        return rV;
    }

    public static int countNegative(int[] a){
        int rV = 0;
        for(int i = 0; i<a.length; i++){
            if(a[i]<0){
                rV += 1;//adding to rV if negative (less than 0)
            }
        }
        return rV;
    }

    public static void printArray(int[] a){
        String rV = "";
        for(int i = 0; i<a.length; i++){
            if(i == a.length - 1){
                rV += a[i];//if the last term don't include comma
            } else {
                rV += a[i] + ",";//add terms followed by a comma
            }
        }
        System.out.println("{" + rV + "}");
    }

    public static String arrayToString(int[] a){
        String rV = "";
        for(int i = 0; i<a.length; i++){
            if(i == a.length - 1){
                rV += a[i];//if the last term don't include comma
            } else {
                rV += a[i] + ",";//add terms followed by a comma
            }
        }
        return "{" + rV + "}";
    }

    public static int[] copy(int[] a){
        int [] rV = new int [a.length];//new array is length of inputed array
        for(int i = 0; i<a.length; i++){
            rV[i] = a[i];//each term in array will be same as array in given list
        }
        return rV;
    }

    public static int[] bigger(int[] a){
        int [] rV = new int [a.length +1];//setting array length with one extra spot than given array
        for(int i = 0; i<a.length + 1; i++){
            if(i == a.length){
                rV[a.length] = 0;//if last spot then make it zero, else copy rest of array
            }else{
                rV[i] = a[i];
            }
        }
        return rV;
    }

    public static int[] smaller(int[] a){
        int [] rV = new int [a.length -1];//setting array length with one extra spot than given array
        for(int i = 0; i<a.length - 1; i++){
                rV[i] = a[i];
        }
        return rV;
    }

    /*
        1.find number of digits = 10 digits
            - create a int array with number of digits
        2.isolate each digits (loop with 10)
            - first do mod
            - gets the last digit
            - add to array
            - increase divider by multiplying with 10
        3.returns array
     */
    public static int[] splitDigits(int a){
        int numberCount = 0;
        int orig = a;
        while(a > 0){
            numberCount++;
            a = a/10;
        }//was from Digits lab to count the length of the number

        int constantNumber = orig, exponent = 1;
        int [] rV = new int [numberCount];

        while(constantNumber/exponent != 0){
            exponent *= 10;//increases exponent by ten
            orig %= 10;//gets the last digit of number
            rV[numberCount - 1] = orig;//sets last index of array to last number
            numberCount -= 1;//decreases number count so array index decreases
            orig = constantNumber/(exponent);//reset orig without last digit
        }
        return rV;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~PART TWO~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}
