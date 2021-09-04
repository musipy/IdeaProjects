package com.company;

public class SavingsAccount extends Account {

    public double interestRate;

    //constructors somewhere here
    public SavingsAccount (String n, double b, double ir){
        /*name = n;
        accNum ++;
        personAccNum = 10000000 + accNum;
        balance = b;*/
        super(n,b); // calls the account class constructor
        interestRate = ir;
    }

    public double applyInterest(){
        balance += interestRate/12;
        if(transactions == null){ // if null then add one index to add the deposit
            transactions = new String[1];
            transactions[0] = "Applied interest " + interestRate/12;
        } else { // if it isn't null, add one more element to the transactions and add the deposit
            String[] copy = new String[transactions.length]; // make a copy so it is easier
            for(int i = 0; i<copy.length; i++){
                copy[i] = transactions[i];
            }
            transactions = new String[copy.length + 1]; //adds on one more index
            for(int i = 0; i<copy.length; i++){
                transactions[i] = copy[i]; //now assigns all the values ot its original place
            }
            transactions[transactions.length - 1] = "Applied interest " + interestRate/12;//adds on the recent deposit to the end
        }
        return balance;
    }

    public String toString(){
        return "Name: " + name + ", Acct: " + personAccNum + ", Balance: $" + balance + ", Interest: " + interestRate + "%";
    }
}
