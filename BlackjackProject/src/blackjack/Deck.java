package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card> {
	// default constructor adds 52 cards
	public Deck() {
		for (int i = 0; i < Card.SUITS.length; i++) {
			for (int j = 0; j < Card.CARDS.length; j++) {
				this.add(new Card(j, i));
			}
		}
	}

	// for convenience don't have to call Collections
	public void shuffle() {
		Collections.shuffle(this);
	}

	// convention is that position 0 is the TOP of the deck
	public Card deal() {
		if (this.size() > 0) {
			return this.remove(0);
		} else {
			return null;
		}
	}

	public String toString() {
		StringBuilder s = new StringBuilder(this.size() * 4);
		s.append("Deck [");
		for (Card c : this) {
			s.append(c.toSymbol() + "|");
		}
		if (this.size() > 0) {
			s.deleteCharAt(s.length() - 1);
		} // remove the last "|"

		s.append("]");
		return s.toString();
	}
	
	//each deck can sort itself by suit or rank
	public void sort(String type){
		Deck.sort(type, this);
	}

	// static methods
	// type.equals("suit") or type.equals("rank")
	// class knows how to sort other lists of Cards
	public static void sort(String type, ArrayList<Card> list) {
		boolean flag = true;
		while (flag) { // bubble sort the cards, grouping by type arg
			flag = false;
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i).sortValue(type) > list.get(i + 1).sortValue(type)) {
					Card lower = list.remove(i + 1);
					Card higher = list.remove(i);
					list.add(i, lower);
					list.add(i + 1, higher);
					flag = true;
				}
			}
		}
	}

}
