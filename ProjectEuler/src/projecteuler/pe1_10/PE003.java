package projecteuler.pe1_10;

import java.util.ArrayList;

import helpers.PrimeSieveInt;

public class PE003 {
////	The prime factors of 13195 are 5, 7, 13 and 29.
////	What is the largest prime factor of the number 600851475143 ?
//
	public static void main(String[] args) {
		long n1 = 13195L;
		long n2 = 600851475143L;

		System.out.println("Prime factors of 13195: " + getPrimeFactors(n1));
		System.out.println("Prime factors of 600851475143: " + getPrimeFactors(n2));
		System.out.println("Confirmed answer from Project Euler: 6857");
	}
	
	public static ArrayList<Integer> getPrimeFactors(long n){
		ArrayList<Integer> factors = new ArrayList<>();
		PrimeSieveInt ps = new PrimeSieveInt((int) Math.sqrt(n) + 1);
		for (int p : ps.getPrimes()){
			while (n % p == 0){
				n /= p;
				factors.add(p);
			}
		}
		return factors;
	}
}