package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        part5();
    }

    //1. Create new account
    //2. Deposit/Pay
    //3. Withdraw/Charge
    //4. Print report of all accounts
    //5. Print all transactions
    //6. Exit
    public static void part5(){
        //create a new array to store the report of all accounts
        Account[] accs = new Account[100];
        Scanner choice = new Scanner(System.in);
        System.out.println("Choose one of the following\n1. Create new account\n2. Deposit/Pay\n3. Withdraw/Charge\n4. Print report of all accounts\n5. Print all transactions\n6. Passed time\n7. Free Deposit\n8. Exit");
        int action = choice.nextInt();
        int i = 0;
        while(action != 8){
            if(action == 1){ // create an acc
                Scanner whichAcc = new Scanner(System.in);
                System.out.println("What type of account would you like to create?\n1. Savings Account\n2. Credit Card Account\n3. Checking Account");
                int accType = whichAcc.nextInt();
                if(accType == 1){
                    accs[i] = askSA(); // assign the value of the accounts to the corresponding index in the accs array
                    accs[i].nameType = "SavingsAccount"; // these help when trying to identify what type of account it is in the index (mainly helpful for the pay and charge methods)
                } else if(accType == 2){
                    accs[i] = askCCA(); // create a credit card account
                    accs[i].nameType = "CreditCardAccount";
                } else if(accType == 3){ // checking account
                    accs[i] = askCA();
                    accs[i].nameType = "CheckingAccount";
                } else {
                    System.out.println("Not an option. Please try again.");
                }
                i++;
            } else if (action == 2){ // deposit/pay
                int num = accNum();
                for(int j = 0; j<accs.length; j++){
                    //System.out.println(accs[j].personAccNum);
                    if(accs[j] == null){//null check
                        j = accs.length;
                    } else if(accs[j].personAccNum == num){
                        //first check if it is a credit card account (if it is only pay and if it isn't only deposit)
                        if(accs[j].nameType.equals("CreditCardAccount")){
                            Scanner p = new Scanner(System.in);
                            System.out.println("How much would you like to pay?");
                            double amt = p.nextDouble();
                            accs[j].pay(amt);//takes care of the transactions as well
                        } else {
                            Scanner d = new Scanner(System.in);
                            System.out.println("How much would you like to deposit?");
                            double amt = d.nextDouble();
                            accs[j].deposit(amt);//takes care of the trasnactions as well
                        }
                    }
                }
            } else if (action == 3) { //charge/withdraw (same as the action 2
                int num = accNum();
                for(int j = 0; j<accs.length; j++){
                    if(accs[j] == null){//null check
                        j = accs.length;
                    } else if(accs[j].personAccNum == num){
                        //first check if it is a credit card account (if it is only pay and if it isn't only deposit)
                        if(accs[j].nameType.equals("CreditCardAccount")){
                            Scanner p = new Scanner(System.in);
                            System.out.println("How much would you like to charge?");
                            double amt = p.nextDouble();
                            accs[j].charge(amt);//takes care of the transactions as well
                        } else {
                            Scanner d = new Scanner(System.in);
                            System.out.println("How much would you like to withdraw?");
                            double amt = d.nextDouble();
                            accs[j].withdraw(amt);//takes care of the trasnactions as well
                        }
                    }
                }
            } else if(action == 4){ //print report of all actions
                for(int j = 0; j<accs.length; j++){
                    if(accs[j] == null){//null check
                        j = accs.length;//exits the for loop immediately
                    } else {
                        System.out.println(accs[j].toString());//prints out all the toStrings
                    }
                }
            } else if(action == 5){//print all transactions
                for(int j = 0; j<accs.length; j++){
                    if(accs[j] == null){
                        j = accs.length; //exits for loop immediately
                    } else {
                        System.out.println("Account " + accs[j].personAccNum);
                        if(accs[j].transactions != null) {
                            for (int r = 0; r < accs[j].transactions.length; r++) {//prints out all the transactions of the object in the corresponding index
                                if(accs[j].transactions[r] == null){
                                r = accs[j].transactions.length;
                                }
                                System.out.println(accs[j].transactions[r]);
                            }
                        }
                    }
                }
            } else if(action == 6){
                int num = accNum();
                int months = part6();
                for(int j = 0; j<accs.length; j++){
                    if(accs[j] == null){//null check
                        j = accs.length;
                    } else if(accs[j].personAccNum == num){
                        //first check if it is a credit card account (if it is only pay and if it isn't only deposit)
                        if(accs[j].nameType.equals("CreditCardAccount")){
                            double origAmt = accs[j].chargeInterest();
                            origAmt *= months;
                            accs[j].balance -= origAmt; // charge interests subtracts from balance
                        } else if(accs[j].nameType.equals("SavingsAccount")){
                            double origAmt = accs[j].chargeInterest();
                            origAmt *= months;
                            accs[j].balance += origAmt; // apply interests adds to balance
                        }
                    }
                }
            } else if(action == 7){
                int num = accNum();
                for(int j = 0; j<accs.length; j++){
                    if(accs[j] == null){//null check
                        j = accs.length;
                    } else if(accs[j].personAccNum == num){
                        accs[j].deposit(accs[j].freeDep);
                        System.out.println(accs[j].freeDep + " has been deposited into Account " + num);
                        if(accs[j].freeDep <= 19){ // only allow up to 20 deposits
                            accs[j].freeDep++;
                        } else {
                            System.out.println("You have run out of your 20 free deposits");
                            accs[j].freeDep += 0;
                        }
                    }
                }
            } else {
                System.out.println("This is not an option");
            }
            //repeat the whole process again
            Scanner c = new Scanner(System.in);
            System.out.println("\nChoose one of the following\n1. Create new account\n2. Deposit/Pay\n3. Withdraw/Charge\n4. Print report of all accounts\n5. Print all transactions\n6. Passed time\n7. Free Deposit\n8. Exit");
            action = c.nextInt();
        }
    }




    //create a helper function which enters a SavingsAccount account
    public static Account askSA(){
        Scanner n = new Scanner(System.in);
        System.out.println("Please enter your name.");
        String name = n.nextLine();
        Scanner b = new Scanner(System.in);
        System.out.println("Please enter your starting balance");
        double balance = b.nextDouble();
        Scanner ir = new Scanner(System.in);
        System.out.println("Please enter the preferred interest rate.");
        double interestRate = ir.nextDouble();
        Account acc = new SavingsAccount(name, balance, interestRate);
        return acc;
    }

    //same as savings acc helper function, except for CredCardAccount
    public static Account askCCA(){
        Scanner n = new Scanner(System.in);
        System.out.println("Please enter your name.");
        String name = n.nextLine();
        Scanner b = new Scanner(System.in);
        System.out.println("Please enter your starting balance");
        double balance = b.nextDouble();
        Scanner ir = new Scanner(System.in);
        System.out.println("Please enter the preferred interest rate.");
        double interestRate = ir.nextDouble();
        Account acc = new CreditCardAccount(name, balance, interestRate);
        return acc;
    }

    //same as savings acc and cca helper functions
    public static Account askCA(){
        Scanner n = new Scanner(System.in);
        System.out.println("Please enter your name.");
        String name = n.nextLine();
        Scanner b = new Scanner(System.in);
        System.out.println("Please enter your starting balance");
        double balance = b.nextDouble();
        Account acc = new CheckingAccount(name, balance);
        return acc;
    }

    //asks for account number
    public static int accNum(){
        Scanner a = new Scanner(System.in);
        System.out.println("Please enter your Account Number");
        return a.nextInt(); // returns account number
        //now we can use it to access the account and deposit/pay/charge/withdraw specific amt from the specific acc
    }

    public static int part6(){ // asks for how many months have passed
        //we can add this on to our part5() method at the very end
        Scanner time = new Scanner(System.in);
        System.out.println("How many months have passed?");
        return time.nextInt();
    }
}
