package projecteuler.pe1_10;

public class PE001 {
//		If we list all the natural numbers below 10 that are multiples 
//		of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
//
//		Find the sum of all the multiples of 3 or 5 below 1000.

	public static void main(String[] args) {
		System.out.println("Sum of multiples of 3 or 5 that are less than 10: " + sumMultiples(3, 5, 10));
		System.out.println("Sum of multiples of 3 or 5 that are less than 1000: " + sumMultiples(3, 5, 1000));
		System.out.println("Verified answer from Project Euler: 233168");
	}
	
	public static int sumMultiples(int n1, int n2, int upperLimit){
		int sum = 0;
		for (int i = n1; i < upperLimit; i += n1){
			sum += i;
		}
		for (int j = n2; j < upperLimit; j += n2){
			if (j % n1 != 0) sum += j;
		}
		return sum;
	}

}
