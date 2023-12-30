

public class HealthPotion extends Potion{



//const
	public HealthPotion(String name, String description) {
		super(name, description);

	}
	


	public String toString(){
			return getName();
		}

	public void consume(Hero hero){
		System.out.println("Your health is full now!");
		hero.setHealthPoints(20);

	}
}