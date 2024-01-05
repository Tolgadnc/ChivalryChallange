

public class CompoundPotion extends Potion {
	//class extends the main class


//const
	  public CompoundPotion(String name, String description) {
		  super(name, description);

	  }



	public String toString(){
		return getName();
	}
//Method to Consume potion
	public void consume(Hero hero){
		System.out.println("Both our health and stamina are full now!");
		  hero.setHealthPoints(10);
		  hero.setStaminaPoints(10);
	}
}
