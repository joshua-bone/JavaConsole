package cipher;

import java.util.Scanner;

public class CipherTest {
	public static void main(String[] args) {
		Cipher c = new Cipher();
		String msg;
		Scanner kb = new Scanner(System.in);
		char choice = '?';
		int key;
		
		System.out.print("Are you (e)ncrypting or (d)ecrypting? ");
		choice = kb.next().toLowerCase().charAt(0);
		System.out.print("What is the message? ");
		msg = kb.nextLine();
		msg = kb.nextLine();
		System.out.print("What is the super secret key? ");
		key = kb.nextInt();
		
		if (choice == 'e'){
			System.out.println("Encrypted message: " + c.encrypt(msg, key));
		}
		else{
			System.out.println("Decrypted message: " + c.decrypt(msg, key));
		}
		
		
		
		/*
		for (int i = -26; i <= 52; i++) {
			System.out.println(i + ": " + c.cipherString("ABcdEFghIJklMNopQRstUVwxYZ", i));
		} */
	}
}
