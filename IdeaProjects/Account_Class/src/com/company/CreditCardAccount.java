package com.company;

public class CreditCardAccount extends Account {

    public double interestRate = 2.01;
    public String description;

    //constructors somewhere here
    public CreditCardAccount(){}

    public CreditCardAccount (String n, double b, double ir){
        super(n,b);//calls the Account class constructor
        interestRate = ir;
    }

    public double chargeInterest(){
        balance -= interestRate/12;
        if(transactions == null){ // if null then add one index to add the deposit
            transactions = new String[1];
            transactions[0] = "Charged interest " + interestRate/12;
        } else { // if it isn't null, add one more element to the transactions and add the deposit
            String[] copy = new String[transactions.length]; // make a copy so it is easier
            for(int i = 0; i<copy.length; i++){
                copy[i] = transactions[i];
            }
            transactions = new String[copy.length + 1]; //adds on one more index
            for(int i = 0; i<copy.length; i++){
                transactions[i] = copy[i]; //now assigns all the values ot its original place
            }
            transactions[transactions.length - 1] = "Charged interest " + interestRate/12;//adds on the recent deposit to the end
        }
        return balance;
    }

    //still not sure about charge and pay
    public double charge(double amt){
        balance -= amt;
        if(transactions == null){ // if null then add one index to add the deposit
            transactions = new String[1];
            transactions[0] = "charge " + amt;
        } else { // if it isn't null, add one more element to the transactions and add the deposit
            String[] copy = new String[transactions.length]; // make a copy so it is easier
            for(int i = 0; i<copy.length; i++){
                copy[i] = transactions[i];
            }
            transactions = new String[copy.length + 1]; //adds on one more index
            for(int i = 0; i<copy.length; i++){
                transactions[i] = copy[i]; //now assigns all the values ot its original place
            }
            transactions[transactions.length - 1] = "charge " + amt;//adds on the recent deposit to the end
        }
        return balance;
    }

    public double pay(double amt){
        balance += amt;
        if(transactions == null){ // if null then add one index to add the deposit
            transactions = new String[1];
            transactions[0] = "pay " + amt;
        } else { // if it isn't null, add one more element to the transactions and add the deposit
            String[] copy = new String[transactions.length]; // make a copy so it is easier
            for(int i = 0; i<copy.length; i++){
                copy[i] = transactions[i];
            }
            transactions = new String[copy.length + 1]; //adds on one more index
            for(int i = 0; i<copy.length; i++){
                transactions[i] = copy[i]; //now assigns all the values ot its original place
            }
            transactions[transactions.length - 1] = "pay " + amt;//adds on the recent deposit to the end
        }
        return balance;
    }

    public String toString(){
        return "Name: " + name + ", Acct: " + personAccNum + ", Balance: $" + balance + ", Interest: " + interestRate + "%";
    }
}
