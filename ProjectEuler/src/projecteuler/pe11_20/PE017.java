package projecteuler.pe11_20;

public class PE017 {
//	If the numbers 1 to 5 are written out in words: 
//	one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 
//	letters used in total.
//
//	If all the numbers from 1 to 1000 (one thousand) inclusive were
//	written out in words, how many letters would be used?
//
//
//	NOTE: Do not count spaces or hyphens. For example, 342 
//	(three hundred and forty-two) contains 23 letters and 115 
//	(one hundred and fifteen) contains 20 letters. 
//	The use of "and" when writing out numbers is in compliance 
//	with British usage.
	public static String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	public static String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	public static String[] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 5; i++){
			sum += countLetters(i);
		}
		System.out.println("Sum of letters in first 5 numbers = " + sum);
		sum = 0;
		for (int i = 1; i <= 1000; i++){
			sum += countLetters(i);
		}
		System.out.println("Sum of letters in first 1000 numbers = " + sum);
		System.out.println("Verified answer from Project Euler: 21124");
	}
	
	
	
	public static int countLetters(int n){
		StringBuilder s = new StringBuilder();
		if (n > 1000 || n <= 0){
			return -1; //operation not supported
		}else if (n == 1000) {
			s.append("one thousand");
		} else {
			if (n / 100 > 0){
				s.append(ones[n/100] + " hundred");
				n %= 100;
				if (n > 0) s.append(" and ");
			}
			if (n / 20 > 0){
				s.append(tens[n/10 - 1] + " ");
				n %= 10;
			} else if (n / 10 > 0){
				s.append(teens[n - 10] + " ");
				n = 0;
			}
			if (n > 0){
				s.append(ones[n]);
			}
			
		}
		return s.toString().replace(" ", "").length();
	}
}
