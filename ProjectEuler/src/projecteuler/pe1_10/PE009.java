package projecteuler.pe1_10;

public class PE009 {
//	A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//
//	a^2 + b^2 = c^2
//	For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//
//	There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//	Find the product abc.
	public static void main(String[] args) {
		for (int b = 0; b < 500; b++){
			if ( (500000 - 1000 * b) % (1000 - b) == 0){
				int a = (500000 - 1000 * b) / (1000 - b);
				int c = 1000 - a - b;
				if (a < b){
					System.out.println("Answer: a = " + a + ", b = " + b + ", c = " + (int) Math.sqrt(((a * a) + (b * b))));
					System.out.println("a^2 + b^2 = " + (a*a + b*b) + ", c^2 = " + c*c);
					System.out.println("a x b x c = " + a * b * c);
					System.out.println("Verified answer from Project Euler:  31875000");
				}
			}
		}
	}
	
	/*
	 * 
	 * c^2 = a^2 + b^2
	 * a + b + c = 1000
	 * -> c = 1000 - a - b
	 * -> (1000 - a - b)^2 = a^2 + b^2
	 * -> 1000^2 - 1000a - 1000b 
	 * 	   + a^2 - 1000a + ab
	 *     + b^2 - 1000b + ab     = a^2 + b^2
	 * -> 1000^2 - 2000a - 2000b + 2ab = 0
	 * -> 1000a + 1000b - ab = 500000
	 * -> a ( 1000 - b ) = 500000 - 1000b
	 * -> a = (500000 - 1000b) / (1000 - b)
	 */
}
