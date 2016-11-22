package projecteuler.pe21_30;

import java.util.ArrayList;
import java.util.BitSet;

public class PE023 {
//	A perfect number is a number for which the sum of its proper divisors 
//	is exactly equal to the number. For example, the sum of the proper 
//	divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 
//	is a perfect number.
//
//	A number n is called deficient if the sum of its proper divisors is 
//	less than n and it is called abundant if this sum exceeds n.
//
//	As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, 
//	the smallest number that can be written as the sum of two abundant 
//	numbers is 24. By mathematical analysis, it can be shown that all 
//	integers greater than 28123 can be written as the sum of two abundant numbers. 
//	However, this upper limit cannot be reduced any further by analysis even 
//	though it is known that the greatest number that cannot be expressed 
//	as the sum of two abundant numbers is less than this limit.
//
//	Find the sum of all the positive integers which cannot be written as 
//	the sum of two abundant numbers.
	
	public static void main(String[] args){
		
		ArrayList<Integer> abundants = new ArrayList<>();
		for (int i = 12; i <=28123; i++){
			if (i < getSumOfProperDivisors(i)){
				abundants.add(i);
			}
		}
		
		BitSet bitset = new BitSet(28123);
		for (int i = 0; i < abundants.size(); i++){
			for (int j = i; j < abundants.size(); j++){
				int index = abundants.get(i) + abundants.get(j) - 1;
				bitset.set(index);
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= 28123; i++){
			if (!bitset.get(i - 1)){
				sum += i;
			}
		}
		System.out.println("Sum of integers that are not sum of abundant numbers: " + sum);
		System.out.println("Verified answer from Project Euler: 4179871");
	}
	
	public static int getSumOfProperDivisors(int n){
		int sum = 1; //1 is always part of the sum
		for (int i = 2; i * i <= n; i++){
			if (n % i == 0){
				sum += i;
				if (i != n / i) sum += n / i;
			}
		}
		return sum;
	}
	
}
