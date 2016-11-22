package projecteuler.pe21_30;

import java.util.HashSet;

public class PE021 {
//	Let d(n) be defined as the sum of proper divisors 
//	of n (numbers less than n which divide evenly into n).
//	If d(a) = b and d(b) = a, where a ≠ b, then a and b 
//	are an amicable pair and each of a and b are called amicable numbers.
//
//	For example, the proper divisors of 220 are 1, 2, 
//	4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore 
//	d(220) = 284. The proper divisors of 284 are 1, 2, 4, 
//	71 and 142; so d(284) = 220.
//
//	Evaluate the sum of all the amicable numbers under 10000.
	public static void main(String[] args) {
		HashSet<Integer> amicables = new HashSet<>();
		HashSet<Integer> unfriendlies = new HashSet<>();
		for (int i = 1; i < 10000; i++){
			if (!amicables.contains(i) && !unfriendlies.contains(i)){
				int sum = getSumOfProperDivisors(i);
				if (i != sum && i == getSumOfProperDivisors(sum)){
					amicables.add(i);
					amicables.add(sum);
					System.out.println("Found amicable pair (" + i + ", " + sum + ")");
				} else {
					unfriendlies.add(i);
					unfriendlies.add(sum	);
				}
			}
		}
		int sum = 0;	
		for (int a : amicables){
			sum += a;
		}
		System.out.println("\nThe sum of amicable numbers < 10000: " + sum);
		System.out.println("Verified answer from Project Euler: 31626");
	}
	
	public static int getSumOfProperDivisors(int n){
		int sum = 1; //1 is always part of the sum
		for (int i = 2; i * i <= n; i++){
			if (n % i == 0){
				sum += i + n / i;
			}
		}
		return sum;
	}
}
