package basiccombat;

import java.util.Scanner;

public class Karina {
	public static void main(String[] args) {
		System.out.println("Hello Karina");
		System.out.println("How many times should I write your name?");
		Scanner keyboard = new Scanner(System.in);
		int i = keyboard.nextInt();
		for (int j = 0; j < i; j++){
			System.out.print("Karina");
			if (j%10==0){System.out.println();}
		}
		
	}
}
