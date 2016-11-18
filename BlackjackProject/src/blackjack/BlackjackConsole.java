package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackConsole {
	public static Scanner keyboard;
	public static String playerName;
	public static Deck deck;
	public static int money;
	public static final int BET = 2; // bet $2 each round
	public static final int PAUSELENGTH = 500; //milliseconds to pause on each line
	public static Hand dealer;
	public static Hand player;

	public static void main(String[] args) {
		init();
		start();
	}

	//do at the start of the game
	public static void init() {
		keyboard = new Scanner(System.in);
		System.out.print("Enter your name: ");
		playerName = keyboard.nextLine();
		deck = new Deck();
		resetCardValues(); // assign proper Blackjack values
		money = 100; // start with $100
		dealer = new Hand();
		player = new Hand();
	}
	
	//do at the start of each round
	public static void reinit(){
		while (player.size() > 0){
			deck.add(player.remove(0));
		}
		while (dealer.size() > 0){
			deck.add(dealer.remove(0));
		}
		deck.shuffle();
		for (int i = 0; i < 2; i++) {
			dealer.add(deck.deal());
			player.add(deck.deal());
		}
	}

	public static void start() {
		reinit();
		String status; // capture the status of the game in a readable way
		money -= BET; // subtract the bet
		System.out.println("***You are playing Blackjack!***");
		pause(PAUSELENGTH);
		System.out.printf("You have $%d\n\n", money);
		pause(PAUSELENGTH);
		System.out.printf("%s: %s\n", playerName, player);
		pause(PAUSELENGTH);
		System.out.printf("Dealer: %s\n\n", dealer.dealerView());
		pause(PAUSELENGTH);
		status = checkForBlackjack(); // both player & dealer
		switch (status) {
		case "player":
			System.out.printf("%s has a natural blackjack!\n", playerName);
			money += (BET + (BET / 2)); // natural pays 1.5 x bet
			break;
		case "dealer":
			System.out.println("Dealer: " + dealer);
			System.out.println("Dealer has a natural blackjack!");
			break;
		case "both":
			System.out.println("Dealer: " + dealer);
			System.out.printf("%s and dealer both have natural blackjacks!\n", playerName);
			money += BET; // get bet back
			break;
		case "neither":
			int dTotal;
			int pTotal = playerLoop();
			if (pTotal < 0){return;} //quits game
			if (pTotal > 21) {
				System.out.println(playerName + " busts.");
			} else {
				dTotal = dealerLoop();
				if (dTotal > 21) {
					System.out.println("Dealer busts.");
					money += BET * 2;
				} else {
					if (dTotal > pTotal) {
						System.out.println("Dealer wins.");
					} else if (dTotal < pTotal) {
						System.out.println(playerName + " wins.");
						money += BET * 2;
					} else {
						System.out.println("Standoff.");
						money += BET;
					}
				}

			}
			break;
		}
		System.out.println("Press Enter to Continue");
		keyboard.nextLine();
		if (money > 0){
			start(); //loop infinitely unless quit selected or out of money
		} else {
			System.out.println("You ran out of money! Better luck next time.");
		}
	}

	public static int playerLoop() {
		int total = sumCards(player);
		boolean loop = true;
		while (total <= 21 && loop) {
			System.out.printf("%s: %s %d\n", playerName, player, total);
			pause(PAUSELENGTH);
			System.out.println("(H)it, (S)tand, or (Q)uit?");
			switch (keyboard.nextLine().charAt(0)) {
			case 'h':
			case 'H':
				player.add(deck.deal());
				break;
			case 's':
			case 'S':
				loop = false;
				break;
			case 'q':
			case 'Q':
				System.out.println("I'm not surprised.");
				return -1; //signal to quit
			default:
				System.out.println("Invalid input.");
				pause(PAUSELENGTH);
			}
			total = sumCards(player);
		}
		System.out.printf("%s: %s %d\n", playerName, player, total);
		pause(PAUSELENGTH);
		return total;
	}

	public static int dealerLoop() {
		int total = sumCards(dealer);
		while (total < 17) {
			System.out.println("Dealer: " + dealer + " " + total);
			dealer.add(deck.deal());
			total = sumCards(dealer);
			pause(PAUSELENGTH);
		}
		System.out.println("Dealer (FINAL): " + dealer + " " + total);
		pause(PAUSELENGTH);
		return total;
	}

	public static int sumCards(Hand hand) {
		int total = 0;
		int aces = 0;
		for (Card c : hand) {
			total += c.getValue();
			if (c.getRank() == 12) {
				aces++;
			}
		}
		while (total > 21 && aces > 0) {
			total -= 10;
			aces--;
		}
		return total;
	}
	
	public static String checkForBlackjack(){
		int dTotal = sumCards(dealer);
		int pTotal = sumCards(player);
		if (dTotal == 21){
			if (pTotal == 21){
				return "both";
			} else {
				return "dealer";
			}
		} else {
			if (pTotal == 21){
				return "player";
			} else {
				return "neither";
			}
		}
	} 

	// set/reset all card values to their Blackjack defaults
	public static void resetCardValues() {
		for (Card c : deck) {
			if (c.getRank() > 8) { // since a 10 is rank 8
				// value == 11 for Aces (rank 12), 10 for face cards
				c.setValue(c.getRank() == (12) ? 11 : 10);
			}
		}
	}
	
	public static void pause(int n){
		try {
			Thread.sleep(n);
		} catch (Exception e){
			System.out.println(e);
		}
	}

}
