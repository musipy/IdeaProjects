package com.company;

public class Main {

    public static void main(String[] args) {
	    Date d1 = new Date(12,31,2019);
	    Date d2 = new Date(1,1,2020 );
	    System.out.println(daysBetween(d1, d2));

    }
    public static void partnerBday (){
    	//partner's bday is August 24, 2004
		Date d = new Date(4, 24, 2004);
		System.out.print("Eshal's birthday is on ");//name of partner
		System.out.println(Date.dateToString(d));
	}

	//initialize boolean variable
	//check if divisible by 4
	//check if divisible by 100
	//check if divisible by 400
	//cannot be divisble by 100 or else isn't leap year
	public static boolean isLeapYear(Date d){
    	boolean leapYear = false;
    	//check
    	if (d.year %4 == 0 && d.year%100 != 0){
    		leapYear = true;
		} else if (d.year%400 == 0){
    		leapYear = true;
		}
    	return leapYear;
	}

	public static int daysBetween(Date d1, Date d2){
    	//create an array with the numbers of the days in the month --> this is the number of days it is far from the beginning of the month
		//the number of the last day of the month in the year
    	int[] monthDay = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    	//gets us where it is in the month
    	int dayNum1 = d1.day + monthDay[d1.month-1];
    	int dayNum2 = d2.day + monthDay[d2.month-1];

    	//check difference in years
		int rv = 0;
		int yearDiff = 0;
		if(d1.year<d2.year){
			dayNum2 += (d2.year - d1.year)*365;
			rv = dayNum2 - dayNum1;
			yearDiff = d2.year - d1.year;
		} else if (d2.year<d1.year){
			dayNum1 += (d2.year - d1.year)*365;
			rv = dayNum1 - dayNum2;
			yearDiff = d1.year- d2.year;
		}
		//check if there is a leap year in between the range of the year
		System.out.println(yearDiff);
		if((yearDiff)%4 == 0){
			rv++;
		}  else if(yearDiff == 2){
			if(d1.year<d2.year){
				if(isLeapYear(new Date(d1.month, d1.day, d1.year+1)) == true){
					rv++;
				}
			}
			if(d2.year<d1.year){
				if(isLeapYear(new Date(d2.month, d2.day, d2.year+1)) == true){
					rv++;
				}
			}
		}else if (yearDiff == 3){
			if(d1.year<d2.year){
				if(isLeapYear(new Date(d1.month, d1.day, d1.year+1)) == true || isLeapYear(new Date(d1.month, d1.day, d1.year+2)) == true){
					rv++;
				}
			} else if (d2.year<d1.year){
				if(isLeapYear(new Date(d2.month, d2.day, d2.year+1)) == true || isLeapYear(new Date(d2.month, d2.day, d2.year+2)) == true){
					rv++;
				}
			}
		}

    	//check for leap year
		if(isLeapYear(d1) == true || isLeapYear(d2) == true){
			//check if february is in between the two given dates
			if(d1.month <= 2 && d2.month > 2){
				rv++;
			} else if(d1.month == 2 && d2.month == 2){ //check if both are in the same month
				if(d2.day == 29){//only if the second date is on the leap year date add one
					rv++;
				}
			}
		}
		return rv;
	}

	public static void task5(){
		//a. The second month comes before the first month.
		Date d1 = new Date(1,1,2020);
		Date d2 = new Date(11,1,2019);
		System.out.println(daysBetween(d1,d2));
		//b. Two dates within the same year that happens to be a leap year.
		Date d3 = new Date(3,1,2020);
		System.out.println(daysBetween(d1,d3));
		//c. 2 dates at least 5 years apart.
		Date d4 = new Date(1,1,2015);
		System.out.println(daysBetween(d1,d4));
	}

	public static int bdayMin(){
    	int rv = 0;
		Date d = new Date(4, 24, 2004);//partner's birthday
		Date t = new Date(12,4,2020);//today's date
		rv = daysBetween(d,t);//total difference in minutes
		return rv;
	}

}
