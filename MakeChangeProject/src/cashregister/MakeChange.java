package cashregister;

import java.util.Scanner;

public class MakeChange {
	// array of test cases to be run if args[0]=="test"
	public static double testArray[][] = { { 0.67, 0.50 }, { 44.27, 44.27 }, { 0.67, 1.00 }, { 0.59, 1.00 },
			{ 3.96, 20.00 }, {5.01, 100.00}};

	//the number in pennies of each denomination (coins penny to quarter, bills $1.00 to $100.00)
	public static int currencyDenoms[] = { 1, 5, 10, 25, 100, 500, 1000, 2000, 5000, 10000 };

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		// run all test cases if argument "test" was passed
		if (args.length != 0 && args[0].equals("test")) {
			for (int i = 0; i < testArray.length; i++) {
				int p = doubleDollarsToIntPennies(testArray[i][0]); //convert double $ to int cents
				int t = doubleDollarsToIntPennies(testArray[i][1]); //convert double $ to int cents
				tryToBuy(p, t);
			}
			
		// otherwise get single case input from user
		} else {
			System.out.print("What is the item price? $");
			int p = doubleDollarsToIntPennies(keyboard.nextDouble()); //convert double $ to int cents
			System.out.print("How much money was tendered? $");
			int t = doubleDollarsToIntPennies(keyboard.nextDouble()); //convert double $ to int cents
			tryToBuy(p, t);
		}
	}

	//customer tries to buy item at $price by supplying $tender
	public static void tryToBuy(int price, int tender) {
		System.out.println("------------------------------------------------");
		System.out.println("Price: " + formatPennies(price) + ", Amount tendered: " + formatPennies(tender));
		
		if (tender < price) { //customer did not tender enough cash to purchase
			System.out.println(
					formatPennies(tender) + " is not enough money for a " + formatPennies(price) + " purchase.");
			
		} else if (tender == price) { //customer provided exact change
			System.out.println("Exact change of " + formatPennies(tender) + " was tendered!");
			System.out.println("No change is due.");
			
		} else { //customer provided excess cash and is due change
			System.out.println("Total change due is " + formatPennies(tender - price));
			printChange(calculateChange(price, tender));
		}
	}

	// turns 2000 pennies into "$20.00", for example
	public static String formatPennies(int c) {
		int dollars = c / 100;
		int cents = c % 100;
		return "$" + dollars + "." + cents / 10 + cents % 10;
	}

	// rounds a double $ amount to nearest # of pennies
	public static int doubleDollarsToIntPennies(double d) {
		return (int) ((d * 100) + 0.5);
	}

	public static int[] calculateChange(int price, int tendered) {
		
		int changeDue = tendered - price;
		
		// 1c, 5c, 10c, 25c, $1, $5, $10, $20, $50, $100
		int[] currencyDue = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		
		//loop through the currency denominations from highest [$100$] to lowest (1c)
		for (int i = currencyDue.length - 1; i >= 0; i--) {
			
			//while the remaining change due is more than the face value of this currency unit
			while (changeDue >= currencyDenoms[i]) {
				currencyDue[i]++; // add one unit of this currency type to the currencyDue list
				changeDue -= currencyDenoms[i]; // subtract the face value of this currency denomination
												// from the remaining change due
			}
			
		}
		return currencyDue;
	}

	//takes a list showing how many units of each currency type is due,
	//and prints pictorially one row for each type
	public static void printChange(int[] currency) {
		for (int i = currency.length - 1; i >= 0; i--) {
			if (currency[i] > 0) {
				for (int j = 0; j < currency[i]; j++){
					System.out.print(getStringCurrencyDenom(currencyDenoms[i]) + " ");
				}
				System.out.println();
			} // no else -- print nothing if none of this denomination is due
		}
		System.out.println();
	}

	//takes int for denomination in CENTS of currency unit (e.g. 25 = 1 quarter,
	//100 = 1 dollar, 10000 = 100 dollars). Prints out simple ASCII art 
	//representing each monetary unit (e.g. quarter = (25¢), $5 bill = [$5$], etc)
	public static String getStringCurrencyDenom(int denom) {
		if (denom < 100) { // coin
			return "(" + denom + (char) 0x00a2 + ")";
		} else { // bill
			return "[$" + denom / 100 + "$]";
		}
	}
}
