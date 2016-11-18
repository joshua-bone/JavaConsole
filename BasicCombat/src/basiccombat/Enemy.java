package basiccombat;

public class Enemy extends Character {

	public Enemy() {
		super("Orc", 100);
	}

	public Enemy(String name, int health) {
		super(name, health);

	}

	public void makeMove(Character c) {

		int d = 1 + (int) (Math.random() * 100);
		if (d < 75) {
			this.attack(c);
		} else if (d < 88) {
			this.lookForItem("armor");
		} else {
			this.lookForItem("weapon");
		}

	}

}
