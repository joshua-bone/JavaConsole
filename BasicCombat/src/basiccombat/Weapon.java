package basiccombat;

public class Weapon {

	private String name;
	private int damage;
	private int range; 

	public Weapon(String n, int d, int r) {
		name = n;
		damage= d;
		range =r; 
	}

	public static Weapon[] getWeaponTypes() {
		return new Weapon[] { new Weapon("Fists", 1, 3), new Weapon("Knife", 3, 4), new Weapon("Sword", 7, 5),
				new Weapon("Battle Axe", 13, 6), };

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}
}
