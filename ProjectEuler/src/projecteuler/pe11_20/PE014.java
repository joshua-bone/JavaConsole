package projecteuler.pe11_20;

public class PE014 {
//	The following iterative sequence is defined for the set of positive integers:
//
//	n → n/2 (n is even)
//	n → 3n + 1 (n is odd)
//
//	Using the rule above and starting with 13, we generate the following sequence:
//
//	13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
//	It can be seen that this sequence (starting at 13 and finishing at 1) 
//  contains 10 terms. Although it has not been proved yet (Collatz Problem), 
//  it is thought that all starting numbers finish at 1.
//
//	Which starting number, under one million, produces the longest chain?
//
//	NOTE: Once the chain starts the terms are allowed to go above one million.
	
	public static void main(String[] args) {
		int startingNumber = 0;
		int longest = 0;
		for (int i = 999_999; i > 0; i-=2){
			int cL = collatzLength(i);
			if (cL > longest){
				System.out.printf("Found new longest chain starting at %d and containing %d terms\n", i, cL);
				longest = cL;
				startingNumber = i;
			}
		}
		System.out.println("Longest chain found starts at " + startingNumber);
		System.out.println("Verified answer from Project Euler: 837799");
	}
	
	public static int collatzLength(int x){
		int count = 1;
		long n = x;
		while (n != 1){
			if (n < 0) {System.out.println(n); break;}
			if (n % 2 == 0){
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
			count++;
		}
		return count;
	}
}
