package projecteuler.pe11_20;

public class PE019 {
//	You are given the following information, but you may prefer 
//	to do some research for yourself.
//
//	1 Jan 1900 was a Monday.
//
//	Thirty days has September,
//	April, June and November.
//	All the rest have thirty-one,
//	Saving February alone,
//	Which has twenty-eight, rain or shine.
//	And on leap years, twenty-nine.
//
//	A leap year occurs on any year evenly divisible by 4, 
//	but not on a century unless it is divisible by 400.
//
//	How many Sundays fell on the first of the month during 
//	the twentieth century (1 Jan 1901 to 31 Dec 2000)?
	
	public static void main(String[] args) {
		int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int sundays = 0;
		int dayOfWeek = 1; //start on Monday, Jan 1, 1900
		int year = 1900;
		dayOfWeek = (dayOfWeek + 365 + isLeapYear(year)) % 7; //fast forward to Jan 1, 1901
		for (year = 1901; year <= 2000; year++){
			for (int month = 0; month < 12; month++){
				if (dayOfWeek == 0){
					sundays++;
				}
				int leapDay = 0;
				if (month == 1) leapDay = isLeapYear(year);
				dayOfWeek = (dayOfWeek + monthDays[month] + leapDay) % 7;
			}
		}
		System.out.println("Number of Sundays that fell on the first of the month: " + sundays);
		System.out.println("Verified answer from Project Euler: 171");
		
		
		
	}
	
	//returns 1 if leap year, 0 otherwise
	public static int isLeapYear(int year){
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
			return 1;
		}
		return 0;
	}
	
	
}
