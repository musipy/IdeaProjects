package com.company;

public class ArrayList {

    //instance variables
    private Object[] objectList = new Object[1];

    //constructors
    public ArrayList(){
      objectList = null;
    }

    //methods
    public int size(){
        if(this.objectList == null){
            return 0;
        }
        return this.objectList.length;
    }

    public boolean add(Object obj){
        //first check if it is null, and if it is then make it an array of length one.
        if (this.objectList == null){
            this.objectList = new Object[1];
            this.objectList[0] = obj;
        } else {
            int origNum = this.objectList.length;
            //copy the array
            Object[] copy = new Object[origNum];
            for(int i = 0; i<this.objectList.length; i++){
                copy[i] = this.objectList[i];
            }
            //now add on an index to the original array.
            this.objectList = new Object[origNum + 1];
            //copy it back into the new array
            for(int i = 0; i<copy.length; i++){
                this.objectList[i] = copy[i];
            }
            //now add on the last index
            this.objectList[origNum] = obj;
        }
        return true;
    }

    public void add(int index, Object obj){
        assert (index==0) && (objectList==null) || objectList != null && index<=objectList.length && index>=0: "Error: add()";
        //same process as add() with one parameter (copying the original array)
        if (this.objectList == null){
            if(index != 0){
                System.out.println("Your array is currently empty, so your object will be the first value of the list.");
            }
            this.objectList = new Object[1];
            this.objectList[0] = obj;
        } else {
            int origNum = this.objectList.length;
            //copy the array
            Object[] copy = new Object[origNum];
            for(int i = 0; i<this.objectList.length; i++){
                copy[i] = this.objectList[i];
            }
            //now add on an index to the original array.
            this.objectList = new Object[origNum + 1];
            //now we have to assign the values of the copy to the original, except everything from the index up is moved up one index
            for (int i = 0; i<copy.length; i++){
                if (i >= index){
                    this.objectList[i+1] = copy[i];
                } else {
                    this.objectList[i] = copy[i];
                }
            }
            //add the obj to the index
            this.objectList[index] = obj;
        }
    }

    public Object get(int index){
        return this.objectList[index];
    }

    public Object remove(int index){
        int origNum = this.objectList.length;
        //assign the value to a variable before setting the index equal to null.
        Object orig = this.objectList[index];
        //create a copy of the array
        Object[] copy = new Object[origNum];
        for(int i = 0; i<origNum; i++){
            copy[i] = this.objectList[i];
        }
        this.objectList = new Object[origNum -1];
        //now copy everything over
        for(int i = 0; i< origNum - 1; i++){
            if(i >= index){
                this.objectList[i] = copy[i+1];
            } else {
                this.objectList[i] = copy[i];
            }
        }
        return orig;
    }

    public String toString(){
        String rv = "[";
        for(int i = 0; i<this.objectList.length; i++){
            if(i == this.objectList.length-1){ // if it's the last one then add only the ending bracket
                rv += this.objectList[i] + "]";
            } else {
                rv += this.objectList[i] + ", "; // else add the comma after the object
            }
        }
        return rv;
    }
}
