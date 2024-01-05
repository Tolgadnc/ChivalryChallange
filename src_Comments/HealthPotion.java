

public class HealthPotion extends Potion{
	//class extends mainclass (Potion)



//const
	public HealthPotion(String name, String description) {
		super(name, description);

	}
	


	public String toString(){
			return getName();
		}

	//Method to Consume potion
	public void consume(Hero hero){
		System.out.println("Your health is full now!");
		hero.setHealthPoints(20);

	}
}