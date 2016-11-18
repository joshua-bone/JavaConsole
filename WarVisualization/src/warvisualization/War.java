package warvisualization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class War {
	static boolean VISUALIZE = true;
	static ArrayList<ArrayList<Card>> players;
	static ArrayList<Card> player1;
	static ArrayList<Card> player2;
	static ArrayList<Card> cardPile;
 	static ArrayList<Card> deck;
	static Scanner keyboard;
	static int turn;
	
	public static void main(String[] args) {
		start();
	}

	public static void start() {
		keyboard = new Scanner(System.in);
		
		//set up the deck and players
		turn = 0;
		deck = new ArrayList<>();
		
		//add the cards
		for (int i = 0; i < Card.SUITS.length; i++) {
			for (int j = 0; j < Card.CARDS.length; j++) {
				deck.add(new Card(j, i));
			}
		}

		//shuffle the cards
		Collections.shuffle(deck);
		
		players = new ArrayList<ArrayList<Card>>();
		player1 = new ArrayList<Card>();
		player2 = new ArrayList<Card>();
		players.add(player1); 
		players.add(player2); 
		cardPile = new ArrayList<Card>();
		
		//deal 26 cards to each player
		while(deck.size()>0){
			player1.add(deck.remove(0));
			player2.add(deck.remove(0));
		}
		
		System.out.println("Welcome to War!");
		int won = 0;
		while (won==0){
			won = gameLoop(won);
		}
		
		int l = cardPile.size();
		if (l>1) visualize(cardPile.get(l-2), cardPile.get(l-1));
		if (won < 0){
			System.out.println("Draw!");
		} else{
			System.out.printf("Player %d wins!", won);			
		}
		
	}
	
	public static int gameLoop(int won){
		if(!VISUALIZE) System.out.println("Press Enter to Continue: ");
		if(!VISUALIZE) keyboard.nextLine();
		int c = compareCards(); //returns 0 if tied, 1 for p1, 2 for p2
		if (c != 0){
			giveAllCardsToPlayer(c);
		} else {
			doWar();
		}
		
		if (player1.size()==0){
			won = 2;
		} else if (player2.size()==0){
			won = 1;
		}
		if(turn++ % 52 == 0){
			//prevent a deadlock condition by reshuffling both hands
			Collections.shuffle(player1);
			Collections.shuffle(player2);
		};
		
		return won;
	}
	
	public static int compareCards(){
		if(!VISUALIZE) System.out.println(" P1    P2");
		if(!VISUALIZE) System.out.printf("(%2d)  (%2d)\n", player1.size(), player2.size());

		Card c1 = player1.remove(0);
		Card c2 = player2.remove(0);
		cardPile.add(c1);
		cardPile.add(c2);
		visualize(c1, c2);
		int status = 0;

		if(!VISUALIZE) System.out.printf("%3s  %3s\n", c1.toSymbol(), c2.toSymbol());
		
		if (c1.getRank() > c2.getRank()){
			status = 1; //player 1 has highest
		} else if (c1.getRank() < c2.getRank()){
			status = 2; //player 2 has highest
		} else {
			status = 0; //cards are tied. WAR!
		}
		return status;
	}
	
	public static void giveAllCardsToPlayer(int c){
		if(!VISUALIZE) System.out.printf("Player %d wins %d cards.\n", c, cardPile.size());

		while (cardPile.size() > 0){
			players.get(c-1).add(cardPile.remove(0));
		}
	}
	
	public static void doWar(){
		if(!VISUALIZE) System.out.println("----WAR!!!----");
		for (int i = 0; i < 3; i++){
			if (player1.size() > 0 && player2.size() > 0){
				if(!VISUALIZE) System.out.println("[=] | [=]");
				cardPile.add(player1.remove(0));
				cardPile.add(player2.remove(0));
			}
		}
	}
	
	public static void pause(int n){
		try{
			Thread.sleep(n);
		}
		catch (Exception e){
			
		}
	}
	
	public static void visualize(Card c1, Card c2)
	{
		if (VISUALIZE){
			System.out.printf("%6d|", turn);
			for(int i = 0; i < player1.size(); i++){
				System.out.print(" ");
			}
			for(int i = 0; i < cardPile.size(); i++){
				pause(30);
				if (c1.getRank() > c2.getRank()){
					System.out.print("\\");
				}
				else if (c1.getRank() < c2.getRank()){
					System.out.print("/");
				}
				else{
					System.out.print("|");
				}
			}
			for(int i = 0; i < player2.size(); i++){
				System.out.print(" ");
			}
			System.out.print("|");
			if ((cardPile.size()-2) % 8 == 0){
				System.out.printf("%3s %3s\n", c1.toSymbol(), c2.toSymbol());
			}
		}
	}

}
