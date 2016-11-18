package basiccombat;

public class Armor {

	private String name;
	private int protection;

	public Armor(String n, int p) {
		name = n;
		protection = p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProtection() {
		return protection;
	}

	public void setProtection(int protection) {
		this.protection = protection;
	}

	public static Armor[] getArmorTypes() {
		return new Armor[] { new Armor("T-Shirt", 1), new Armor("Leather Jacket", 3), new Armor("Iron Armor", 6),
				new Armor("Diamond Armor", 10)}; 

	}
}
