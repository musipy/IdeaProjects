package com.company;

import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        /*int[] myStack = createStack();
        for(int i=10; i>0; i--)
            push(myQueue,i);
        System.out.println("You should print [10,9,8,7,6,5,4,3,2,1]");
        System.out.println(prettyPrintStack(myStack));
        System.out.println(dumpStack(myStack));
        task2();
        int[] sharesStack = createStack();
        int[] priceStack = createStack();
        push(sharesStack,100);
        push(priceStack,20000);
        push(sharesStack,50);
        push(priceStack,21000);
        System.out.println("This should print: \nShares\tPrice\n100\t\t$200.00\n50\t\t$210.00");
        printReportFILO(sharesStack, priceStack);
        System.out.println(runReportFILO(sharesStack, priceStack));
        buyFILO(sharesStack, priceStack, 20, 30050);
        System.out.println("This should print -61000.");
        System.out.println(sellFILO(sharesStack, priceStack, 30, 25000));
        push(sharesStack,10);
        push(priceStack,19999);
        System.out.println(runReportFILO(sharesStack, priceStack));
        System.out.println("This should print 20267.");
        System.out.println(averageFILO(sharesStack, priceStack));
         */
        int[] myQueue = createQueue();
        /*for(int i=10; i>0; i--)
            enqueue(myQueue,i);
        System.out.println("You should print [10,9,8,7,6,5,4,3,2,1]");
        System.out.println(prettyPrintQueue(myQueue));
        System.out.println("This should print \n10\n9\n8\n7\n6\n5\n4\n3\n2\n1");
        for(int i=10; i>0; i--)
            System.out.println(dequeue(myQueue));*/
        //task5();
        int[] a = createQueue();
        int[] b = createQueue();
        for(int i=1; i<=5; i+=2)
            enqueue(a, i);
        for(int i=2; i<=6; i+=2)
            enqueue(b, i);
        enqueue(a, 40000);
        enqueue(a, 45000);
        enqueue(b, 30000);
        System.out.println(dumpQueue(merge(a, b)));
    }


    public static int[] createStack() {
        int [] rv = new int[20];//creates int array with 101 spaces
        return rv;
    }

    public static int pop(int[] stack) {
        if(stack[0] == 0){
            System.out.println("Error, there are no elements to pop in your stack.");//ends function
            return 0;
        }
        int rv = stack[stack[0]];
        stack[0]--;
        return rv;
    }

    public static void push(int[] stack, int data){
        stack[0] = stack[0]+1;
        stack[stack[0]] = data;
        if(stack[0] > 50){
            System.out.println("There are too many elements in your stack.");
        }
    }

    public static String prettyPrintStack(int[] stack){
        String rv = "[";//beginning of string
        for(int i = 1; i<=stack[0]; i++){
            if(i == stack[0]){
                rv += stack[i] + "]";//if last element, finish with bracket
            } else {
                rv += stack[i] + ",";//add element as you go through array
            }
        }
        return rv;
    }

    public static String dumpStack(int[] stack){
        String rv = "{";
        for (int i = 0; i<stack.length; i++){//go through entire stack prints including the first element
            if(i == stack.length-1){
                rv += stack[i] + "}";//if last element end with end brace
            } else {
                rv += stack[i] + ",";//seperate with comma
            }
        }
        return rv;
    }

    public static void task2(){
        int[] stack = createStack();
        for (int i = 9; i>= 3; i--){
            push(stack, i);
        }//made stack with [9,8,7,6,5,4,3]
        pop(stack);//first pop
        pop(stack);//second pop
        System.out.println(pop(stack));//third pop print -> '5'
        for (int i = 1; i<=4; i++){
            push(stack,i);
        }//pushed 1,2,3,4 in order
        for (int i = 1; i<5; i++){
            pop(stack);
        }//pops four times
        System.out.println(pop(stack));// pop the fifth time -> 6
        System.out.println(prettyPrintStack(stack));//prints the remaining stack
    }

    public static void printReportFILO(int[] shares, int[] price){
        System.out.print("Shares");
        System.out.println("\t Price");//set the title
        for (int i = 1; i<=shares[0]; i++){
            if(price[i]%100 == 0){
                System.out.println(shares[i] +"\t \t $"+ (price[i])/100 + ".00");
            } else {
                System.out.println(shares[i] + "\t \t $" + (price[i]) / 100 + "." + (price[i]) % 100);
            }
        }//prints the amount of share with it's corresponding
    }

    public static String runReportFILO(int[] shares, int[] price){
        String rv = "";
        System.out.print("Shares\t Price");
        for (int i = 1; i<=shares[0]; i++){
            if(price[i]%100 == 0){
                rv += "\n" + shares[i] +"\t \t $"+ (price[i])/100 + ".00";//concats to string
            } else {
                rv += "\n" + shares[i] + "\t \t $" + (price[i]) / 100 + "." + (price[i]) % 100;//concats to string
            }// starts new line each share concatinated
        }//prints the amount of share with it's corresponding
        return rv;
    }

    public static void buyFILO(int[] shares, int[] price, int numShares, int pricePerShare){
        push(shares, numShares);//pushes numShare into shares
        push(price, pricePerShare);//pushes pricePerShare into price
    }

    /*
    1. get total amount of moneny being deducted
    2. pop last share amount and price out of stack
    3. get total money amount of popped price and share
    4. subtract price amount one share at a time from the sold share
    5. if done with the popped share amount move on to the next share and pop it out
     */
    public static int sellFILO(int[] shares, int[] price, int numShares, int pricePerShare){
        int rv = numShares*pricePerShare;//sets it equal to total amount sold
        for (int i = 0; i<=numShares; i++){
            if(shares[shares[0]] == 0){//if last share equal to 0
                pop(shares);
                pop(price);
            } else {
                rv -= price[price[0]];//subtracts one by one from original total
                shares[shares[0]]--;//subtract share
            }
        }
        return rv;
    }

    /*
    1. get total cents values
    2. get total share values
    3. get the first decimal value (multiply by ten and get extra decimal value)
    4. if greater than equal to 5 round up
    5. else round down
     */
    public static int averageFILO(int[] shares, int[] price){
        int totalPrice = 0;
        int totalShares = 0;
        int rv = 0;
        for(int i = 1; i<shares[shares[0]]; i++){
            totalPrice += (shares[i]*price[i]);//total cents
            totalShares += shares[i];//total number of share
        }
        rv = (totalPrice*10)/totalShares;//total cents now has first decimal at end (multiplied by ten, ones place is first decimal number)
        if(rv%10 >= 5){
            rv = (rv/10) +1;//if greater than or equal, add one after ridding the ones place
        } else {
            rv /= 10;//else divide simply without adding 1
        }
        return rv;
    }

    public static int[] createQueue(){
        int [] rv = new int[101];//creates int array with 101 spaces -> queue
        return rv;
    }

    public static void enqueue(int[] queue, int data){
        queue[0] = queue[0]+1;//increments length by one
        queue[queue[0]] = data;//adds to last index
        if(queue[0] > 50){
            System.out.println("There are too many elements in your stack.");
        }
    }

    public static int dequeue(int[] queue){
        if(queue[0] == 0){
            System.out.println("Error, there are no elements to dequeue in your queue.");//ends function
            return 0;
        }
        int rv = queue[1];
        for (int i = 1; i<100; i++){
            queue[i] = queue[i+1];//moves all elements one index lower
        }
        queue[100] = 0;//sets last index = 0 -> slowly resets queue
        queue[0]--;//decrease amount of elements in queue
        return rv;
    }

    public static String prettyPrintQueue(int[]queue){
        String rv = "[";
        for (int i = 1; i<=queue[0]; i++){
            if(i == queue[0]){
                rv += queue[i] + "]";//if last element, finish with bracket
            } else {
                rv += queue[i] + ",";//add element as you go through queue
            }
        }
        return rv;
    }

    public static String dumpQueue(int[] queue){
        String rv = "{";
        for (int i = 0; i<queue.length; i++){//go through entire stack prints including the first element
            if(i == queue.length-1){
                rv += queue[i] + "}";//if last element end with end brace
            } else {
                rv += queue[i] + ",";//seperate with comma
            }
        }
        return rv;
    }

    public static void task5(){
        int [] queue = createQueue();
        for (int i = 9; i>= 3; i--){
            enqueue(queue, i);//add 9,8,7,6,5,4,3 to queue
        }
        dequeue(queue);//first dequeue
        dequeue(queue);//second dequeue
        System.out.println(dequeue(queue));//third dequeue-> 7
        for (int i = 1; i<= 4; i++){
            enqueue(queue, i);//add 1,2,3,4 to queue
        }
        for(int i = 1; i< 5; i++){
            dequeue(queue);//dequeue four times
        }
        System.out.println(dequeue(queue));//fifth dequeue -> 1
        System.out.println(prettyPrintQueue(queue));//print rest of queue -> [2,3,4]
    }


    public static int[] merge(int[] a, int[] b) {
        int[] rv = new int [a[0]+b[0]];
        int nextA = a[1];//set it to first element in queue
        int nextB = b[1];//set it to first element in queue
        for (int i = 0; i<rv.length; i+=2){//for length of rv -> add by two because adding value to two indexes at a time
            if(nextA<nextB && a[0] != 0){//if first element of a is less than first element of b AND IF QUEUE A DOESN'T HAVE ANY VALUES
                rv[i] = nextA;//set the rv[i] -> current index -> equal to first element of a
                rv[i+1] = nextB;//set following index to equal first element of b
            } else if (nextB<nextA && b[0] != 0){
                rv[i] = nextB;
                rv[i+1] = nextA;
            }

            if (a[0] == 0){//if queue a is empty/null -----> WILL PRINT THE ERROR MESSAGE BECAUSE YOU RAN OUT OF ELEMENTS TO DEQUEUE
                rv[i] = nextB;//current index isn't 0 (a[1]) but the next value in the queue b
            } else if (b[0] == 0){//if b is null/empty -----> WILL PRINT THE ERROR BECAUSE YOU RAN OUT OF ELEMENTS TO DEQUEUE
                rv[i] = nextA;//set current index to value in b[1] and not to value in a[1] which will equal 0
            }
            dequeue(a);//decrease indexes of elements in queue --> new a[1]
            dequeue(b);//decrease indexes of lemenets in queue --> new b[1]
            nextA = a[1];//assign to nextA
            nextB = b[1];//assign to nextB
        }
        return rv;
    }




}
