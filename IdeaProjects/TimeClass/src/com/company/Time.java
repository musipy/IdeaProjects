package com.company;

public class Time {

    public int h, m, s;
    public boolean noonChange;

    public Time(){
        h = 0;
        m = 0;
        s = 0;
        noonChange = false;
    }

    public Time(int hour,int min, int sec, boolean day){
        h = hour;
        m = min;
        s = sec;
        noonChange = day;
    }
}
