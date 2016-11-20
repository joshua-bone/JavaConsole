package projecteuler.pe1_10;

import java.util.TreeMap;

import helpers.PrimeSieveInt;

public class PE005 {
	// 2520 is the smallest number that can be divided by each
	// of the numbers from 1 to 10 without any remainder.
	// What is the smallest positive number that is evenly divisible
	// by all of the numbers from 1 to 20?
	public static void main(String[] args) {
		System.out.println("Test case (1-10):");
		System.out.println("Calculated answer: " + findSmallestPositiveNum(10) + "\n");
		System.out.println("Assigned case (1-20):");
		System.out.println("Calculated answer: " + findSmallestPositiveNum(20) + "\n");
		System.out.println("Verified answer from Project Euler: 232792560");

	}
	
	public static int findSmallestPositiveNum(int limit){
		TreeMap<Integer, Integer> factors = new TreeMap<>();

		for (int i = 2; i <= limit; i++) {
			TreeMap<Integer, Integer> iFactors = getFactors(i);
			for (int key : iFactors.keySet()) {
				if (!factors.containsKey(key)) {
					factors.put(key, iFactors.get(key));
				} else {
					factors.put(key, Math.max(iFactors.get(key), factors.get(key)));
				}
			}
		}
		System.out.println("Factors: " + factors);
		int total = 1;
		for (int key : factors.keySet()) {
			total *= Math.pow(key, factors.get(key));
		}
		return total;
	}

	public static TreeMap<Integer, Integer> getFactors(int n) {
		PrimeSieveInt ps = new PrimeSieveInt(n + 1);
		TreeMap<Integer, Integer> factors = new TreeMap<>();

		for (int p : ps.getPrimes()) {
			while (n % p == 0) {
				if (factors.containsKey(p)) {
					factors.put(p, factors.get(p) + 1);
				} else {
					factors.put(p, 1);
				}
				n /= p;
			}
		}
		return factors;
	}
}

/*
 * 20 2 2 5 19 18 2 9 17 16 2 2 2 2 15 3 5
 */
