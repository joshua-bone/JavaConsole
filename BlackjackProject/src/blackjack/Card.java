package blackjack;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {
	public final static String[] CARDS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	public final static String[] CARDNAMES = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Jack", "Queen", "King", "Ace" };
	public final static char[] SUITS = { 0x2662, 0x2667, 0x2661, 0x2664 };
	public final static String[] SUITNAMES = { "Diamonds", "Clubs", "Hearts", "Spades" };
	public final static int WIDTH = 150;
	public final static int HEIGHT = WIDTH * 726 / 500;
	private final byte rank; // 0 - 12;
	private final byte suit; // 0 - 3;
	private int value; // can be set by the game controller as needed
	private Image front;
	private Image back;
//	private boolean isFaceDown; //track if card is visible or not

	public JLabel front(){
		return new JLabel(new ImageIcon(this.getFront()));
	}
	
	public JLabel back(){
		return new JLabel(new ImageIcon(this.getBack()));
	}

	public Image getFront() {
		return front;
	}
	

	public void setFront(Image front) {
		this.front = front;
	}

	public Image getBack() {
		return back;
	}

	public void setBack(Image back) {
		this.back = back;
	}

	// constructor
	public Card(int rank, int suit) {
		this.rank = (byte) Math.abs(rank % 13); // shouldn't pass 13 or higher
												// (or negatives), but it will
												// wrap around
		this.suit = (byte) Math.abs(suit % 4); // shouldn't pass 4 or higher (or
												// negatives), but it will wrap
												// around
		this.value = rank + 2; // default value is standard face value
		try {
			String fileName;
			if (this.rank <= 8){ //10 or lower
				fileName = (this.rank + 2) + "_of_" + Card.SUITNAMES[this.suit].toLowerCase() + ".png";
			} else if (this.rank == 12){ //ace
				fileName = Card.CARDNAMES[this.rank].toLowerCase() + "_of_" + Card.SUITNAMES[this.suit].toLowerCase() + ".png";
			} else {
				fileName = Card.CARDNAMES[this.rank].toLowerCase() + "_of_" + Card.SUITNAMES[this.suit].toLowerCase() + "2.png";				
			}
			this.setFront(ImageIO.read(new File("PNG-cards-1.3/" + fileName)).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH));
			this.setBack(ImageIO.read(new File("PNG-cards-1.3/back.jpg")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH));
			
		} catch (Exception e) {
			System.err.println(e);
		}
//		this.isFaceDown = true; //all cards start face down
	}

//	// setters and getters
//	public void flip(){ //flip a card over
//		this.isFaceDown = !this.isFaceDown;
//	}
//	
//	public boolean isFaceDown(){
//		return this.isFaceDown;
//	}
	
	public byte getRank() {
		return this.rank;
	}

	public byte getSuit() {
		return this.suit;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int v){
		this.value = v;
	}

	public String toString() {
		return "Card: " + CARDNAMES[rank] + " of " + SUITNAMES[suit];
	}

	public String toSymbol() { //returns 2-char symbol
//		if (this.isFaceDown){
//			return "??";
//		} else {
			return CARDS[rank] + SUITS[suit];
//		}
	}

	// methods

	// returns an integer sort value based on whether we are sorting
	// by rank or by suit
	public int sortValue(String type) {
		if (type.equals("suit")) {
			return this.getSuit() * 13 + this.getRank();
		} else if (type.equals("rank")) {
			return this.getRank() * 4 + this.getSuit();
		} else {
			return -1;
		}
	}
}
