package basiccombat;

import java.util.ArrayList;
import java.util.Scanner;

public class GameTester {
	public static void main(String[] args) {
		mainGame();
	}
	
	public static void testGame(int orcs) {
		Hero p = new Hero("Aragorn", 500);
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		initializeGame("Aragorn", orcs, enemies);

	}
	
	public static void mainGame() {
		//get player input
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your name, brave hero (or otherwise): ");
		String heroName = keyboard.nextLine();
		System.out.printf("And how many Orcs do you think you can handle, %s?\n", heroName);
		while(!keyboard.hasNextInt()){keyboard.next();}
		int orcs = keyboard.nextInt();
		
		//trash talk about player input
		switch(orcs){
		case 0: 
			System.out.println("Not much of a fighter, eh?");
			break;
		case 1: 
			System.out.println("Just one, huh? I'm guessing you're more of the 'stay-at-home' type.");
			break;
		case 2: case 3:
			System.out.println("Wouldn't want to soil your armor or anything!");
			break;
		case 4: case 5:
			System.out.println("Should be an enjoyable spectacle!");
			break;
		default:
			System.out.println("Time will tell whether you are brave or foolish!");
		}
		System.out.println();
		
		//initialize the game
		Hero p = new Hero(heroName, 500);
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		initializeGame("Aragorn", orcs, enemies);
		
		
		boolean enemiesStillAlive = true;
		while (enemiesStillAlive && p.isAlive()) {
			
			System.out.printf("Make your move, %s\n", p.getName());
			int i = 0;
			for (i = 0; i < enemies.size(); i++) {
				Enemy e = enemies.get(i);
				if (e.isAlive()) {
					System.out.printf("%d. Attack %s\n", i + 1, e.getName());
				}
			}
			
			System.out.printf("%d. Look for Weapon\n", i+1);
			System.out.printf("%d. Look for Armor\n", i+2);

			int selection = 0;
			while(selection < 1 || selection > i+2){
				while(!keyboard.hasNextInt()){keyboard.next();} //ensure 
				selection = keyboard.nextInt();
			}

			if (selection == i+1){
				p.lookForItem("weapon");
			} else if (selection == i+2){
				p.lookForItem("armor");
			} else {
				Enemy e = enemies.get(selection - 1);
				if (e.isAlive()) {
					p.attack(e);
				} else{
					System.out.printf("%s is already dead. You wasted a move.\n", e.getName());
				}
			}// end of switch	
			enemiesStillAlive = doEnemyMoves(enemies, p);
		} // end while
		
		System.out.println("\n\n\n\n\n\n\n\n\n");
		System.out.println("**************************************************************");
		System.out.println("**************************************************************");
		System.out.println();
		if (!p.isAlive()){
			System.out.printf("%s died in battle, and not very heroically at that.\n", p.getName());
		} else {
			System.out.printf("%s won the battle and rescued the princess!\n", p.getName());
		}
		System.out.println();
		System.out.println("**************************************************************");
		System.out.println("**************************************************************");

	}
	
	public static boolean doEnemyMoves(ArrayList<Enemy> enemies, Hero p){
		boolean enemiesStillAlive = false;
		for (Enemy e : enemies) {
			if (e.isAlive()){
				enemiesStillAlive = true;
				if (p.isAlive()){
						e.makeMove(p);
				}
			}
		}
		return enemiesStillAlive;
	}
	
	public static void initializeGame(String name, int orcs, ArrayList<Enemy> enemies){
		//p = new Hero(name, 500);
		for (int i = 0; i < orcs; i++) {
			int health = 50 + (int) (Math.random() * 100);
			enemies.add(new Enemy("Orc " + (i+1), health));
		}
	}

}
