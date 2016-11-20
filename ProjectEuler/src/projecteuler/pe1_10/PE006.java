package projecteuler.pe1_10;

public class PE006 {
	// The sum of the squares of the first ten natural numbers is,
	// 1^2 + 2^2 + ... + 10^2 = 385
	//
	// The square of the sum of the first ten natural numbers is,
	// (1 + 2 + ... + 10)^2 = 55^2 = 3025
	// Hence the difference between the sum of the squares of the first
	// ten natural numbers and the square of the sum is 3025 − 385 = 2640.
	//
	// Find the difference between the sum of the squares of the first one
	// hundred natural numbers and the square of the sum.

	public static void main(String[] args){
		System.out.println("First ten natural numbers: " + diffSquares(10));
		System.out.println("First 100 natural numbers: " + diffSquares(100));
		System.out.println("Verified answer from Project Euler: 25164150");
	}
	
	public static int diffSquares(int upperLimit) {
		int sum_of_squares = 0;
		int sum = 0;
		for (int i = 1; i <= upperLimit; i++){
			sum_of_squares += i * i;
			sum += i;
		}
		return (sum * sum) - sum_of_squares;
	}
}
