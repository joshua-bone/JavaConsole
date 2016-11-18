package warvisualization;

public class Card {
	//fields
	public final static String[] CARDS = {"2", "3", "4", "5", "6", "7", "8",
									  "9", "10", "J", "Q", "K", "A"};
	public final static String[] CARDNAMES = { "Two", "Three", "Four", "Five",
										 "Six", "Seven", "Eight", "Nine",
										 "Ten", "Jack", "Queen", "King", "Ace"};
	public final static char[] SUITS = {0x2662, 0x2667, 0x2661, 0x2664};
	public final static String[] SUITNAMES = {"Diamonds", "Clubs", "Hearts", "Spades"};
	
	private byte rank; // 0 - 12;
	private byte suit; //0 - 3;
	
	//constructor
	public Card(int rank, int suit){
		this.rank = (byte) Math.abs(rank % 13);
		this.suit = (byte) Math.abs(suit % 4);
	}

	//setters and getters
	public byte getRank(){
		return this.rank;
	}
	
	public byte getSuit(){
		return this.suit;
	}
	
	public String toString(){
		return "Card: " + CARDNAMES[rank] + " of " + SUITNAMES[suit];
	}
	
	public String toSymbol(){
		return CARDS[rank] + SUITS[suit];
	}
	
	//methods
	
	//returns an integer sort value based on whether we are sorting
	//by rank or by suit
	public int sortValue(String type){
		if (type.equals("suit")){
			return this.getSuit()*13 + this.getRank();}
		else if (type.equals("rank")) {
			return this.getRank()*4 + this.getSuit();			
		} else {return -1;}
	}
}
