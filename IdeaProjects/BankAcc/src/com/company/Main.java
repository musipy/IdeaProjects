package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*create objects for each person
        BankAccount al = new BankAccount();
        BankAccount bob = new BankAccount();
        BankAccount carl = new BankAccount();
        //use setters to define each object/set values for balance and name
        al.setName("Al"); al.setBalance(50);
        bob.setName("Bob"); bob.setBalance(25);
        carl.setName("Carl"); carl.setBalance(44);*/

        /*BankAccount a = new BankAccount();
        BankAccount b = new BankAccount();
        BankAccount.numberOfAccountsCrated = 1;
        a.accountNumber = 1000; b.numberOfAccountsCrated = 10;
        System.out.println(a.accountNumber + "," + a.numberOfAccountsCrated);
        b.accountNumber = 2000; b.numberOfAccountsCrated = 20;
        System.out.println(b.accountNumber + "," + b.numberOfAccountsCrated);*/
        //accArray();
        askUser();
    }

    public static void accArray(){
        BankAccount[] acc = new BankAccount[500];//create an Array of objects --> 500 elements
        for(int i = 0; i<acc.length; i++){
            String accName = "Acct"+(i+1);//used this string for account number name
            acc[i] = new BankAccount(accName, i+1);//create new object for each element with accName and balance
            System.out.println(acc[i].getName() + "\t" + "$" + acc[i].getBalance() + "0");//print Acct1  $1.00
        }
    }

    public static BankAccount[] askUser(){
        BankAccount[] acc = new BankAccount[100];
        int i = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("1. Create new account \n2. View all accounts \n3. Quit");
        int choice = s.nextInt();
        while (choice != 3) {
            if (choice == 1) {//create a new bank account
                Scanner n = new Scanner(System.in);//name of account
                System.out.println("Enter Account Name");
                String accName = n.nextLine();
                Scanner b = new Scanner(System.in);//balance of account
                System.out.println("Enter Account Balance");
                double accBalance = b.nextDouble();
                acc[i] = new BankAccount(accName, accBalance);//add on to the array of bank accounts the person has
                i++;
                Scanner a = new Scanner(System.in);//ask the question again so the loop does not go on forever.
                System.out.println("1. Create new account \n2. View all accounts \n3. Quit \nEnter your selection:");
                choice = a.nextInt();
            }
            if (choice == 2) {//view all accounts --> print all accounts created so far
                for (int j = 0; j < acc.length; j++) {
                    if (acc[j] != null) {
                        System.out.println(acc[j].getName() + "\t $" + acc[j].getBalance() + "0");
                    }
                }
                Scanner a = new Scanner(System.in);//ask the question again so the loop does not go on forever.
                System.out.println("1. Create new account \n2. View all accounts \n3. Quit \nEnter your selection:");
                choice = a.nextInt();
            }
        }
        if (choice == 3){//break
            return acc;//return whatever you have so far
        }
        return acc;
    }
}
