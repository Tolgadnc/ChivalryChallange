

public class CompoundPotion extends Potion {


//const
	  public CompoundPotion(String name, String description) {
		  super(name, description);

	  }



	public String toString(){
		return getName();
	}

	public void consume(Hero hero){
		System.out.println("Both our health and stamina are full now!");
		  hero.setHealthPoints(10);
		  hero.setStaminaPoints(10);
	}
}
