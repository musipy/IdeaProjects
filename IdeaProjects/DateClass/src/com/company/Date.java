package com.company;

public class Date {

    int month, day, year;

    public Date(){
        month = 0;
        day = 0;
        year = 0;
    }

    public Date(int m, int d, int y){
        month = m;
        day = d;
        year = y;
    }

    public static String monthName(Date d){
        //have an array of all the months so I don't have many conditional statements
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        //get String value from array by minus one because starting index is 0
        String month = months[d.month-1];
        return month;
    }

    public static String dateToString(Date d){
        //use monthName function for the name of the month, then add on the rest
        String date = Date.monthName(d) + " " + d.day + ", " + d.year;
        return date;
    }

}
