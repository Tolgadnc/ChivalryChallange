
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Villain {
	//Intialize
	private String dyingSpeech;
	private Random villainDice;
	private int xCoordinate;
	private int yCoordinate;
	private int healthPoints;
	private ArrayList<Items> villainItems;
	private int parryDenyCapacity;
	private int damageCapacity;
	private int blockCapacity;
	private String description;
	private String name;
	
	//constructor
	public Villain (String name, String description, int xCoordinate, int yCoordinate, int healthPoints, int parryDenyCapacity, int damageCapacity, int blockCapacity) {
		this.dyingSpeech = new String();
		this.name = name;
		this.description = description;
		this.xCoordinate = xCoordinate;
		this.yCoordinate =yCoordinate;
		this.healthPoints = healthPoints;
		this.villainItems = new ArrayList<Items>();
		this.parryDenyCapacity = parryDenyCapacity;
		this.damageCapacity = damageCapacity;
		this.blockCapacity = blockCapacity;
		this.villainDice = new Random();
	}
		//get & set methods for coordinates x and y

	public int villainRollDice(){
		int roll = villainDice.nextInt(6) + 1;
		System.out.println("Your opponent rolled: " + roll);
		return roll;
	}
	public String getDescription(){
		return description;
	}

	public String getVillainName(){
		return name;
	}
	public int getXCoordinate() {
		return xCoordinate;
	}
	
	public void setXCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	
	public int getYCoordinate() {
		return yCoordinate;
	}
	
	public void setYCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	//getter and setter methods for health points 
	
	public int getHealthPoints() {
		return healthPoints;
	}
	
	public void setHealthPoints(int hp) {
		this.healthPoints = hp;
	}
	
	//getter and setter for villainItems
	
	public List <Items> getVillainItems () {
		return villainItems;
	}
	
	public void setVillainItems(ArrayList<Items> villainItems) {
		this.villainItems = villainItems;
	}
	
	//getter and setter for parryDefense 
	
	public int getParryDenyCapacity() {
		return parryDenyCapacity;
	}
	
	public void setParryDenyCapacity(int parryDenyCapacity) {
		this.parryDenyCapacity = parryDenyCapacity;
	}
	
	//getter and setter for damage capacity
	
	public int getDamagecapacity() {
		return damageCapacity;
	}
	
	public void setDamageCapacity(int damageCapacity) {
		this.damageCapacity = damageCapacity;
	}
	
	//getter and setter methods for 

	public int getBlockCapacity() {
		return blockCapacity;
		}
	
	public void setBlockCapacity(int blockCapacity) {
		this.blockCapacity = blockCapacity;
		}
//Doubts
	public void villainAttack() {
		}
	
	public void villainBlock(Sword sword, Hero hero) {
		}
	
	public void villainParry() {
		
	}
	
	public void dealDamage() {
		
	}
		

	//Method to get the current coordinates for the vilain
	public Vector<Integer> getCurrentCoordinatesVillain(){
		Vector<Integer> currentCoordinate = new Vector<Integer>(2);
		int x = xCoordinate;
		int y = yCoordinate;
		currentCoordinate.add(x);
		currentCoordinate.add(y);
		return currentCoordinate;

	}


	//Method to display villain stats
	public void displayVillainStats(){ 
		//can we change these lines to differntiate better
		System.out.println("-----------------------------");
		System.out.println("Your opponents health: " + healthPoints + "\n" + "Block power: " + blockCapacity + "\n" + "Parry power: " + parryDenyCapacity + "\n" + "Attack: " + damageCapacity);
		System.out.println("-----------------------------");
	}
		//get and set methods for dyingSpeech
	public void setDyingSpeech(){
		this.dyingSpeech = "*write dying speech*";
	}

	public String getDyingSpeech(){
		return dyingSpeech;
	}
	public void restoreHealth(){
		healthPoints = 10;
	}
	
}

	


