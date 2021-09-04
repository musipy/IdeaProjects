package com.company;
import java.util.ArrayList;

public class Stack {

    //instance variables
    private ArrayList<String> data;

    //constructor
    public Stack(){
        data = new ArrayList<String>();
    }

    //methods
    public void push(String s){
        data.add(s);
    }
    public String pop(){
        return data.remove(data.size()-1);
    }
    public String toString(){
        return data.toString();
    }
    public int size(){
        return data.size();
    }

}
