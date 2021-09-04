
class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        //System.out.println(moneyToString(10,10));
        //System.out.println(biggestMoney(9,24,30,90,100,23));
        printChangeFrom20(10,200);
    }

    public static String moneyToString(int d, int c) {
        //Convert the dollar and cent value to a string with a decimal and a dollar sign
        if(c<10){
            //if the cents is less than ten, only has one digit so have to be, for ex. .05 instead of .5
            return "$" + d + ".0" + c;
        }
        return "$" + d + "." + c;
    }

    public static void printSum(int d1, int c1, int d2, int c2){
        //add the dollars
        int d = 0;
        d = d1+d2;
        //add the cents
        int c = 0;
        c = c1+c2;
        // add the total dollars to the total cents, account for over 100
        if(c>=100){
            c = c-100;
            d +=1;
        }
        System.out.println(moneyToString(c,d));
    }

    public static int biggestMoney(int d1, int c1, int d2, int c2, int d3, int c3){
        //return value which changes for whichever is greatest
        int returnValue = 0;
        int total1 = (d1 * 100) + c1, total2 = (d2 * 100) + c2, total3 = (d3 * 100) + c3;
        //the total cents value for each money value
        //comparing each to see which is greatest among all the values
        if(total1>total2 && total1>=total3){
            returnValue = 1;
        } else if(total2>total3 && total2>total1){
            return returnValue;
        } else {
            returnValue = 3;
        }
        return returnValue;
    }

    public static void printChangeFrom20(int d, int c){
        //multiply 20 by 100 to get cent value of $20
        //do the same for the money value given above
        int amt = 2000, givenAmt = (d*100) + c;
        while(2000 == amt) {
            //subtract the cent value of the money given by the total cent value, 2000
            amt -= givenAmt;
            //cents is the remainder when dividing the new change by 100
            //dolar is the whole number when dividing the new change by 100
            int c1 = amt % 100, d1 = amt / 100;
            System.out.println(moneyToString(d1,c1));
        }
    }
}
