package projecteuler.pe11_20;

import java.math.BigInteger;

public class PE016 {
//	2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
//
//			What is the sum of the digits of the number 2^1000?
	public static void main(String[] args) {
		System.out.println("Sum of digits of 2^15: " + sumDigits(15));
		System.out.println("Sum of digits of 2^1000: " + sumDigits(1000));
		System.out.println("Verified answer from Project Euler: 1366");
	}
	
	public static int sumDigits(int power){
		BigInteger bi = BigInteger.valueOf(1);
		bi = bi.shiftLeft(power);
		int sum = 0;
		String biString = bi.toString();
		for (int i = 0; i < biString.length(); i++){
			sum += Character.getNumericValue(biString.charAt(i));
		}
		return sum;
	}
}
