package basiccombat;

public abstract class Character {

			protected int health;
			protected  boolean isAlive;
			protected  String name; 
			protected Armor armor;
			protected Weapon weapon; 
			public Character(){
				this("UnNamed", 100); 
			}

			public Character(String name, int health ) {
				
				this.health = health;
				this.name = name;
				this.setAlive(true); 
				Armor[] types=Armor.getArmorTypes();
				this.setArmor(types[0]); //T-Shirt
				Weapon[] wTypes=Weapon.getWeaponTypes();
				this.setWeapon(wTypes[0]);//fists
				
			}
			
			public void attack (Character h){
			//	int damage =2+(int)(Math.random()*4);  //calculate a random amount of damage between 2 and 5
				int base=this.getWeapon().getDamage(); 
				int range=this.getWeapon().getRange(); 
				int damage=base+(int)(Math.random()*range); 
				System.out.printf("%s attacks %s with a %s for %d damage. ", this.getName(), h.getName(), this.getWeapon().getName(), damage); //print an attack message
				h.takeDamage(damage); //cause Hero h to take between 2 and 5 units of damage
				
			}
			
			public void takeDamage(int damage){ 
				int newDamage = Math.max(0, damage-(int)(this.getArmor().getProtection()*(0.5+Math.random()))); //subtract armor from damage, but don't go below zero
				int newHealth = this.getHealth()-newDamage; //calculate new health based on damage taken, may be negative
				this.setHealth( Math.max(0, newHealth)); //if new health is < 0, then don't go below 0
				System.out.printf("%s has %s and takes %d damage. Health = %d.\n", this.getName(), this.getArmor().getName(), newDamage, this.getHealth()); //tell user what is happening
				
				if(this.getHealth()==0){         //if health got to 0 then this combatant is dead
					this.setAlive(false);           //mark as not alive
					System.out.printf("%s was killed \n", this.getName()); //tell user what is happening
				}
			}
			
			public void lookForItem(String item){
				int f; 
				int d=1+(int)(Math.random()*100);
				if(d<50){
					f=0;
				
				}else if(d<80){
					f=1;
				}else if(d<95){
					f=2; 
				}else {
					f=3; 
				}
				switch(item){
				case "armor":
					Armor[] atypes = Armor.getArmorTypes();
					if (atypes[f].getProtection() > this.getArmor().getProtection()){
						System.out.printf("%s found a %s. \n", this.getName(), atypes[f].getName());
						this.setArmor(atypes[f]);
					} else {
						System.out.printf("%s went looking for armor, but didn't find much of anything.\n", this.getName());
					}
					break;
				case "weapon":
					Weapon[] wtypes = Weapon.getWeaponTypes();
					if (wtypes[f].getDamage() > this.getWeapon().getDamage()){
						System.out.printf("\t\t%s found a %s. \n", this.getName(), wtypes[f].getName());
						this.setWeapon(wtypes[f]);
					} else {
						System.out.printf("%s went looking for weapons, but didn't find much of anything.\n", this.getName());
					}
					break;
				}
			}
		
			

			public int getHealth() {
				return health;
			}

			public void setHealth(int health) {
				this.health = health;
			}

			public boolean isAlive() {
				return isAlive;
			}

			public void setAlive(boolean isAlive) {
				this.isAlive = isAlive;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
			
			
			public Armor getArmor() {
				return armor;
			}
			
			public void setArmor(Armor armor) {
				this.armor = armor;
			}
			
			public Weapon getWeapon() {
				return weapon;
			}
			
			public void setWeapon(Weapon weapon) {
				this.weapon = weapon;
			}
			
			



	}



