package com.company;
import java.util.ArrayList;

public class Queue {

    //instance variables
    private ArrayList<Object> data;

    //constructor
    public Queue(){
        data = new ArrayList<Object>();
    }

    //methods
    public void enqueue(Object o){
        data.add(o);
    }
    public Object dequeue(){
        return data.remove(data.get(0));
    }
    public String toString(){
        return data.toString();
    }
    public int size(){
        return data.size();
    }
    public void bubbleSort(){
        for(int i = 0; i<data.size()-1; i++){
            for(int j = 0; j<data.size()-1; j++) {//have a double for loop so that it could transverse through the array more than once
                if ((data.get(j).toString()).toLowerCase().compareTo((data.get(j + 1).toString()).toLowerCase()) > 0) { // compare i and i+1
                    data.add(j + 1, data.remove(j));//we removed the greater value and added it after the i+1
                }
            }
        }
    }
}
