package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(pigLatin("hello world"));
        //linear(0,2,3);
        //quadratic(0,2,1,1);
        //System.out.println((2*10*10) + 10+1);
        //fib(0);
    }

    public static int linear(int x, int m, int b){
        if(x == 10){
            System.out.println(x + "\t" + (b));//***for the table***
            return b;
        } else { // recursive case
            System.out.println(x + "\t" + b);//print out the x value then the y value *** for the table***
            return linear(x+1, m, b+m);//call the function again except with a value x + 1
        }
    }

    public static int quadratic(int x, int a, int b, int c){//very similar to linear() function
        //base case (when x = 10 since it is the last one)
        if(x == 10){
            System.out.println(x + "\t" + ((a*x*x) + c));
            return (a*x*x + c);
        } else { // recursive case
            System.out.println(x + "\t" + ((a*x*x) + c));//print out the x value then the y value
            return quadratic(x+1, a, b, c+b);//call the function again except with a value x + 1
        }
    }

    public static int quadraticLin(int x, int a, int b, int c){
        if (x == 0){
            return c;
        }
        if(x == 1){
            return a + b + c;
        } else {
            int secDiff = 2*a;
            int rv = quadratic(1,a,b,c) - quadratic(0,a,b,c) - secDiff;
            return quadratic(x-1,a,b,c) + linear(x,secDiff,rv);
        }
    }

    public static String capVowel(String s){
        if (s.isEmpty()) {
            return s;
        } else if(s.substring(0,1).equals("a") || s.substring(0,1).equals("e") || s.substring(0,1).equals("i") || s.substring(0,1).equals("o") || s.substring(0,1).equals("u")){
            String a = s.substring(0,1);
            a = a.toUpperCase();
            s = a + s.substring(1);
        }
        //call recursively
        return s.substring(0,1) + capVowel(s.substring(1));
    }

    public static String reverse(String s){
        //base case
        if (s.isEmpty()) {
            return s;
        }
        //Calling Function Recursively
        return reverse(s.substring(1)) + s.substring(0,1);
    }

    public static boolean isVowel(String s){
        s = s.toLowerCase();
        if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")){
            return true;
        }
        return false;
    }
    public static String beforeVowel(String s){
        //base case --> string is empty
        //does return nothing if the first letter is a vowel
        if(isVowel(s.substring(0,1))){
            return "";
        } else if (!isVowel(s.substring(0, 1))){//recursive case
            return s.substring(0,1) + beforeVowel(s.substring(1));
        }
        return s;
    }

    public static String afterVowel(String s){
        //just return if the first index is a vowel / if the string is empty
        if(s.isEmpty()){
            return s;
        }else if(isVowel(s.substring(0,1))){//recursive case
            return s.substring(1);
        }
        return afterVowel(s.substring(1));
    }

    public static String noLeadingWhiteSpace(String s){
        //base case
        if(s.isEmpty()){
            return "";
        } else if (s.substring(0,1).equals(" ")){//recursive case
            return noLeadingWhiteSpace(s.substring(1)) + s.substring(0,1);
        }
        return s;
    }

    public static String beforeSpace(String s){
        //base case if string is empty or if it equals a space
        if(s.substring(0,1).equals(" ")){
            return "";
        } else if (s.substring(0,1).compareTo(" ") > 0){//recursive case
            return s.substring(0,1) + beforeSpace(s.substring(1));
        }
        return s;
    }

    public static String afterSpace(String s){
        //base case if the string is empty
        if(s.isEmpty()){
            return s;
        } else if (s.substring(0,1).equals(" ")){
            return noLeadingWhiteSpace(s.substring(1));
        }
        return afterSpace(s.substring(1));//recursive case
    }

    public static String doubleLetters(String s){
        //base case
        if(s.isEmpty()){
            return s;
        }
        return s.substring(0,1) + s.substring(0,1) + doubleLetters(s.substring(1));//recursive case
    }

    public static int fib(int n){
        if(n == 0 || n == 1){//base case
            return 1;
        }
        return fib(n-1)+fib(n-2);//recursive case
    }

    public static int pascals(int r, int c){
        //base case
        if(c == 1 || r == c) {
            return 1;
        }//recursive case
        return pascals(r-1,c-1) + pascals(r-1, c);
    }

    public static boolean isPalindrome(String s){
        String reversed = reverse(s);
        if(reversed.equals(s)){
            return true;
        }
        return false;//base case
    }

    public static void isPalindromePrint(int i){
        //base case
        if(i == 9999){
            System.out.println(i);
        }
         else if(isPalindrome("" + i + "")){
            System.out.println(i);
        }
        isPalindromePrint(i++);
    }

    public static String pigTranslator (String s){
        char[] vowelList = {'a', 'e', 'i', 'o', 'u'};
        s = s.toLowerCase();
        for(int i = 0; i<vowelList.length; i++){
            if(s.charAt(0) == i){
                return s + "way";
            }
        }
        for(int i = 0; i<vowelList.length; i++){
            if(s.charAt(1) == i){
                return s.substring(1) + s.substring(0,1) + "ay";
            }
        }
        return s.substring(2) + s.substring(0,2) + "ay";
    }

    public static String pigLatin(String s){
        if (s == null || s.length() == 0){
            return "";
        }
        int i = s.indexOf(" ");
        if(i == -1){
            return pigTranslator(s);
        }
        return pigTranslator(s.substring(0,s.indexOf(" "))) + " " + pigLatin(s.substring(s.indexOf(" ") + 1));
    }

}
