# Basic Combat (Skill Distillery Project, Week 2)
#### By Joshua Bone, 10/17/2016



### Overview
This is a simple text-based game that I created during my second week of coding bootcamp at Skill Distillery. It uses Object Oriented Programming concepts to implement a turn-based combat system with random elements as well as weapon and armor modifiers.

### User Story #1:
The player is prompted to enter their hero's name, and select how many Orcs they think they can fight.

### User Story #2:
The player is presented with a simple text-based menu that describes their options for the given turn.

### User Story #3:
The player may choose an Orc to attack. The damage dealt is selected from a random range of integers based on the weapon the player is holding, but is reduced by a second random integer from a range defined by the armor that the Orc is wearing.

### User Story #4: 
The player may choose to look for armor or weapons instead of attacking, with success based on a random integer such that better armor or weapons are less likely to be found.

### User Story #5:
After the player's turn is complete, each of the Orcs (if still alive) takes a turn, choosing to either attack the player or else look for weapons or armor. 

### User Story #6:
The game ends when either the player dies or else all the Orcs are dead.

##### Notes
Begin the game by running the GameTester class.

##### Sample Output
```
Enter your name, brave hero (or otherwise): 
Aragorn
And how many Orcs do you think you can handle, Aragorn?
1
Just one, huh? I'm guessing you're more of the 'stay-at-home' type.

Make your move, Aragorn
1. Attack Orc 1
2. Look for Weapon
3. Look for Armor
2
Aragorn went looking for weapons, but didn't find much of anything.
Orc 1 found a Iron Armor. 
Make your move, Aragorn
1. Attack Orc 1
2. Look for Weapon
3. Look for Armor
2
		Aragorn found a Sword. 
Orc 1 attacks Aragorn with a Fists for 2 damage. Aragorn has T-Shirt and takes 1 damage. Health = 497.
Make your move, Aragorn
1. Attack Orc 1
2. Look for Weapon
3. Look for Armor
1
Aragorn attacks Orc 1 with a Sword for 7 damage. Orc 1 has Iron Armor and takes 2 damage. Health = 109.
Orc 1 went looking for armor, but didn't find much of anything.
Make your move, Aragorn
1. Attack Orc 1
2. Look for Weapon
3. Look for Armor
```
