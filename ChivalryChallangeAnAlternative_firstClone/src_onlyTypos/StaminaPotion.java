

public class StaminaPotion extends Potion{


//const
	 public StaminaPotion (String name, String description) {
		 super(name, description);

	 }
	 



	public String toString(){
		return getName();
	}

	public void consume(Hero hero){
		System.out.println("Your stamina is full now!");
		 hero.setStaminaPoints(20);

	 }
}