package projecteuler.pe1_10;

import helpers.PrimeSieveInt;

public class PE010 {
//	The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//
//	Find the sum of all the primes below two million.
	
	public static void main(String[] args) {
		PrimeSieveInt ps = new PrimeSieveInt(2000000);
		long total = 0;
		for (int p : ps.getPrimes()){
			total += p;
		}
		System.out.println("Answer: " + total);
		System.out.println("Verified answer from Project Euler: 142913828922");
	}
}
