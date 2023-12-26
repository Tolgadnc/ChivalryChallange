
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Villain {
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
		this.name = name;
		this.description = description;
		this.xCoordinate = xCoordinate;
		this.yCoordinate =yCoordinate;
		this.healthPoints = healthPoints;
		this.villainItems = new ArrayList<Items>();
		this.parryDenyCapacity = parryDenyCapacity;
		this.damageCapacity = damageCapacity;
		this.blockCapacity = blockCapacity;
	}
		//get & set methods for coordinates x and y
	
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
	
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
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
	// after creaating the classes this methods will be edited.
	public void villainAttack() {
		
		
	}
	
	public void villainBlock() {
		
	}
	
	public void villainParry() {
		
	}
	
	public void dealDamage() {
		
	}
		
	public void blockHeroAttack() {
		
	}

	public Vector<Integer> getCurrentCoordinatesVillain(){
		Vector<Integer> currentCoordinate = new Vector<>(2);
		int x = xCoordinate;
		int y = yCoordinate;
		currentCoordinate.add(x);
		currentCoordinate.add(y);
		return currentCoordinate;

	}
	
}

	


