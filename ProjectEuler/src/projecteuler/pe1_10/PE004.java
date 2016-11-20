package projecteuler.pe1_10;

public class PE004 {
//	A palindromic number reads the same both ways. The largest palindrome made 
//	from the product of two 2-digit numbers is 9009 = 91 × 99.
//	Find the largest palindrome made from the product of two 3-digit numbers.
	public static void main(String[] args) {
		int largest = 0;
		for (int i = 999; i > 99; i--){
			for (int j = i; j > 99; j--){
				if (isPalindrome(i*j)){
					if ((i*j) > largest){
						System.out.println("found: " + i*j + " (" + i + "x" + j + ")");
						largest = i*j;
					}
				}
			}
		}
		System.out.println("Largest palindrome found: " + largest);
		System.out.println("Verified answer from Project Euler: 906609");
	}
	
	public static boolean isPalindrome(int n){
		int forward = n;
		int reverse = 0;
		while (forward > 0){
			reverse = reverse * 10 + forward % 10;
			forward /= 10;
		}
		return (reverse == n);
	}
}
