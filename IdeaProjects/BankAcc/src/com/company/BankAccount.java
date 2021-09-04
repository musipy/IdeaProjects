package com.company;

public class BankAccount {
    //instance variables
    private double balance;
    private String name;
    private int accountNumber;
    //class variable
    private static int numberOfAccountsCreated = 0;

    //Question 1: when can you access private instance variables?
    //when you are writing code in the same class that the variable is in.

    //Part 2: getters and setters
    //getters and setters are non-static, they have access to the instance variables of an object.
    // Return a double because getBalance() should return the balance, which is a double.
    //we don't need an argument because we're asking what the value is, no extra info necessary.
    //Getters
    public double getBalance(){
        return balance;
    }
    public String getName(){
        return name;
    }
    //Setters: return type is void because we are not returning anything.
    //setBalance() is just changing a value, not asking what the value is.
    //Because we're changing the value of balance, we need to know what the value will be, so we need an argument.
    //Setters:
    public void setBalance(double newBalance){
        balance = newBalance;
    }
    public void setName(String newName){
        name = newName;
    }

    //Question 2: A programmer decides that the account’s name should not be changeable. How would you accomplish this?
    //you can accomplish it by removing the setter. OR
    //you can make it private (the setter function)

    //Part 4
    //getters instance/class variables
    public int getAccountNumber(){
        return accountNumber;//instance variable
    }
    public static int getNumberOfAccountsCrated(){//class variable
        return numberOfAccountsCreated;
    }

    public BankAccount(){
        name = "";
        balance = 0;
        numberOfAccountsCreated++;
        accountNumber = numberOfAccountsCreated + 10000000;
        if (numberOfAccountsCreated%100 == 0){//start off with hundred dollars when creating a new object with zero balance.
            balance += 100;
        }
    }

    public BankAccount(String n, double b){
        numberOfAccountsCreated++;
        accountNumber = numberOfAccountsCreated + 10000000;
        balance = b;
        name = n;
        if (numberOfAccountsCreated%100 == 0){//add hundred to balance no matter initial balance.
            balance += 100;
        }
    }

    public String toString(){
        return name + "'s account " + accountNumber + " has a balance of $ " + balance + ".";
    }

    public double deposit(BankAccount a, double amt){
        double origBalance = a.getBalance();//create another variable with the original balance
        a.setBalance(origBalance + amt);//set the new balance by adding deposit amt
        return amt;//return the amt
    }

    public double withdraw(BankAccount a, double amt){
        double origBalance = a.getBalance();//create another variable with the original balance
        a.setBalance(origBalance-amt);//set the new balanace by subtracting deposit amt
        return amt;//return amt
    }
    
}

