package projecteuler.pe1_10;

import java.util.ArrayList;

import helpers.PrimeSieveInt;

public class PE007 {
	// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
	// we can see that the 6th prime is 13.
	// What is the 10,001st prime number?

	public static void main(String[] args) {
		
		System.out.println("The 6th prime is: " + findNthPrime(6));
		System.out.println("The 10001st prime is: " + findNthPrime(10001));
		System.out.println("Verified answer from Project Euler: 104743");
		

		
	}
	
	public static int findNthPrime(int n){
		PrimeSieveInt ps;
		int found = 0;
		int upperLimit = 10*n; //probably a reasonable starting point 
		while(found == 0){
			upperLimit += n; //since we don't know the real upperlimit, keep incrementing
			ps = new PrimeSieveInt(upperLimit);
			ArrayList<Integer> primes = ps.getPrimes();
			if (primes.size() >= n){
				found = primes.get(n - 1);
			}
		}
		return found;
	}
}
