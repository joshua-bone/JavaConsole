package blackjack;

public class Blackjack {
	int money;
	int bet = 2;
	Deck deck;
	Hand player;
	Hand dealer;
	
	public Blackjack(){
		money = 100;
		deck = new Deck();
		player = new Hand();
		dealer = new Hand();
		resetCardValues();
		deck.shuffle();
		bet();
		deal();
	}
		
	public void deal(){
		for (int i = 0; i < 2; i++){
			player.add(deck.deal());
			dealer.add(deck.deal());
		}
	}
	
	public void redeal(){
		reset();
		redeal();
	}
	
	public void reset(){
		while(dealer.size() > 0){
			deck.add(dealer.remove(0));
		}
		while(player.size() > 0){
			deck.add(player.remove(0));
		}
		deck.shuffle();
	}
	
	public void bet(){
		money -= bet;
	}
	
	public int sumCards(Hand hand) {
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
	
	// set/reset all card values to their Blackjack defaults
	public void resetCardValues() {
		for (Card c : deck) {
			if (c.getRank() > 8) { // since a 10 is rank 8
				// value == 11 for Aces (rank 12), 10 for face cards
				c.setValue(c.getRank() == (12) ? 11 : 10);
			}
		}
	}
}
