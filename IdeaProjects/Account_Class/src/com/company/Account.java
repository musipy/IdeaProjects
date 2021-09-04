package com.company;

public class Account {

    //instance variables
    public String name;
    public static int accNum;
    public int personAccNum;
    public double balance;
    public String[] transactions;
    public String nameType;
    public double freeDep = 1;

    //constructors
    public Account(){
        name = "";
        accNum ++;
        personAccNum = 10000000 + accNum;
        balance = 0;
        transactions = null;
    }

    public Account (String n, double b){
        name = n;
        accNum ++;
        personAccNum = 10000000 + accNum;
        balance = b;

    }

    //methods
    public String toString(){
        return "Name: " + name + ", Acct: " + personAccNum + ", Balance: $" + balance;
    }

    public void deposit(double amt){
        balance += amt;
        //check if transactions is null
        if(transactions == null){ // if null then add one index to add the deposit
            transactions = new String[1];
            transactions[0] = "deposit " + amt;
        } else { // if it isn't null, add one more element to the transactions and add the deposit
            String[] copy = new String[transactions.length]; // make a copy so it is easier
            for(int i = 0; i<copy.length; i++){
                copy[i] = transactions[i];
            }
            transactions = new String[copy.length + 1]; //adds on one more index
            for(int i = 0; i<copy.length; i++){
                transactions[i] = copy[i]; //now assigns all the values ot its original place
            }
            transactions[transactions.length - 1] = "deposit " + amt;//adds on the recent deposit to the end
        }
    }

    public double withdraw(double amt){
        balance -= amt;
        //check if transactions is null
        if(transactions == null){ // if null then add one index to add the deposit
            transactions = new String[1];
            transactions[0] = "withdraw " + amt;
        } else { // if it isn't null, add one more element to the transactions and add the deposit
            String[] copy = new String[transactions.length]; // make a copy so it is easier
            for(int i = 0; i<copy.length; i++){
                copy[i] = transactions[i];
            }
            transactions = new String[copy.length + 1]; //adds on one more index
            for(int i = 0; i<copy.length; i++){
                transactions[i] = copy[i]; //now assigns all the values ot its original place
            }
            transactions[transactions.length - 1] = "withdraw " + amt;//adds on the recent deposit to the end
        }
        return balance;
    }

    public double pay(double amt){ return amt; }

    public double charge(double amt){ return amt; }

    public double applyInterest(){ return 0; }

    public double chargeInterest(){ return 0; }
}
