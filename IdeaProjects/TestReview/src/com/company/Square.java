package com.company;

public class Square {
    public static double base;
    private int height;
    //public String name;

    public void setBase(double b){
        base = b;
    }
    public void setHeight(int h){
        height = h;
    }

    public double area(){
        return height*base;
    }
    public int getRadius() {
        return height;
    }
   /* private static int accountsCreated = 0;
    private String name;
    private double balance;
    private int accountNumber;
    public Square(String n, double b) {
        accountNumber = 1000 + accountsCreated;
        accountsCreated++;
        balance = b;
        name = n;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    private int a;
    public Square(int b){
        a = b;
    }
    public static int foo(int a){
        return a;
    }*/

}
