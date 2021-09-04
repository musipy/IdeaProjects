package com.company;

public class Stack {

    //instance variables
    private int[] storage;
    private int numberOfElements;

    //constructor
    public Stack(){
        storage = new int [100];
        numberOfElements = 0;
    }

    //getters
    public int[] getStorage() {
        return copyArray(storage);
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public static int[] copyArray(int[] a){
        //null check
        if (a == null){
            return null;
        }
        //create a new array
        int[] copy = new int[a.length];
        //assign each element of previous array to corresponding element in the new aray
        for (int i = 0; i< copy.length; i++){
            copy[i] = a[i];
        }
        return copy;
    }

    public static int[] append(int[] a, int[] b){
        //null check (if one array isn't null, then return just that array)
        if (a == null && b != null){
            return b;
        }
        if(a != null && b == null){
            return a;
        }
        if (a == null && b == null){
            return null;
        }
        //create a new array
        int[] newArray = new int[a.length + b.length];
        for (int i = 0; i < newArray.length; i++){
            if(i < a.length){//because array a comes first, in the beginning elements add a elements
                newArray[i] = a[i];
            } else {
                newArray[i] = b[i - a.length]; //add b elements in the rest of the array
            }
        }
        return newArray;
    }

    public void push(int num){
        //check to see if the storage has all the elements assigned a value
        if (numberOfElements == storage.length){
            storage = append(storage, new int[100]);
        }
        //increment numberOfElements because we are adding an element to the stack
        numberOfElements++;
        //set the numberOfElements -1 index in storage to the value in the argument.
        storage[numberOfElements - 1] = num;
    }

    public int pop(){
        //null check
        if (storage == null){
            return 0;
        }
        //assign the last value in the array value to a return value
        int popVal = storage[numberOfElements - 1];
        //set the recently popped value to zero
        //storage[numberOfElements - 1] = 0;
        //decrease numberOfElements size.
        numberOfElements--;
        //return
        return popVal;
    }

    public String toString(){
        String rv = "[";
        for (int i = 0; i < numberOfElements; i++){
            rv += storage[i];
            if (i < numberOfElements -1){
                rv += ", ";
            }
        }
        rv += "]";
        return rv;
    }
}
