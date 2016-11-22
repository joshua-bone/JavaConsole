package projecteuler.pe11_20;

import java.math.BigInteger;

public class PE020 {
//	n! means n × (n − 1) × ... × 3 × 2 × 1
//
//	For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
//	and the sum of the digits in the number 10! is 3 + 6 + 
//	2 + 8 + 8 + 0 + 0 = 27.
//
//	Find the sum of the digits in the number 100!
	
	public static void main(String[] args) {
		BigInteger bi = new BigInteger("1");
		for (int i = 100; i > 1; i--){
			bi = bi.multiply(BigInteger.valueOf(i));
		}
		int sum = 0;
		String result = bi.toString();
		for (int i = 0; i < result.length(); i++){
			sum += Character.getNumericValue(result.charAt(i));
		}
		System.out.println("Sum of digits of 100!: " + sum);
		System.out.println("Verified answer from Project Euler: 648");
	}
}
