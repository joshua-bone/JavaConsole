package blackjack;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {
	public String dealerView(){
		return this.toString().substring(0,4) + "??]";
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder(this.size() * 4);
		s.append("[");
		for (Card c : this) {
			s.append(c.toSymbol() + "|");
		}
		if (this.size() > 0) {
			s.deleteCharAt(s.length() - 1);
		} // remove the last "|"
		s.append("]");
		return s.toString();
	}
}
