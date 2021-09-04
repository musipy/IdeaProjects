package com.company;

public class Main {

    public static void main(String[] args) {
	Time t = new Time();
	t.h = 12;
	t.m = 0;
	t.s = 0;
	t.noonChange = true;
	//System.out.println(timeToSeconds(t));
        task4();
    }

    public static String timeToString(Time t){
        //AM is false
        String rv = "";
        //set a variable for time and second if less than ten
        String mLess = "";
        String sLess = "";
        if(t.m < 10){
            mLess = "0";
        }
        if(t.s < 10){
            sLess = "0";
        }
        //if false then set it equal to am
        if(t.noonChange == false){
            rv = t.h + ":" + mLess + t.m  + ":" + sLess + t.s + " AM";
        } else {//if true set to pm
            rv = t.h + ":" + mLess + t.m + ":" + sLess + t.s + " PM";
        }
        //return
        return rv;
    }

    public static int timeToSeconds(Time t){
        int rv = 0;
        //first have an if statement for am and pm
        //assume 12 = 0 when AM...yes
        //then if pm, assume 12 as 12 and everything else as military time
        if(t.noonChange == false){
            if(t.h == 12){
                t.h = 0;//only in the case of AM
            }
            rv = (t.h * 60 * 60) + (t.m * 60) + t.s;
        } else { // if pm
            if(t.h > 12){
                rv = ((t.h+12) * 60 * 60) + (t.m * 60) + t.s;
            } else {
                rv = (t.h * 60 * 60) + (t.m * 60) + t.s;
            }
        }
        return rv;
    }

    public static void task4(){
        //test code for all other tasks
        Time t = new Time();
        t.h = 12;
        t.m = 1;
        t.s = 23;
        t.noonChange = false;
        System.out.println(timeToString(t)); // 12:01:23 AM
        System.out.println(timeToSeconds(t)); // 83
        //school time in a day in seconds
        //3:06
        Time e = new Time();
        e.h = 3;
        e.m = 6;
        e.s = 0;
        e.noonChange = true;
        //8:30
        Time s = new Time();
        s.h = 8;
        s.m = 30;
        s.s = 0;
        s.noonChange = false;
        //time from beginning of day for both
        int ending = timeToSeconds(e);
        int starting = timeToSeconds(s);
        System.out.println(ending);
        System.out.println(starting);
        System.out.println(ending-starting);

    }
}
