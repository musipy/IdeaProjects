package com.company;

public class CheckingAccount extends Account {

    //constructor --> totally empty because there is no input for this class
    public CheckingAccount(){}
    public CheckingAccount(String n, double b){
        super(n,b);
    }

    //methods
    //just a toString method
    public String toString(){
        return "Name: " + name + ", Acct: " + personAccNum + ", Balance: $" + balance;
    }

}
