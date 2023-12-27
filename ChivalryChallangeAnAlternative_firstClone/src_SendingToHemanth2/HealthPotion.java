

	public class HealthPotion extends Potion{
		private int staminaIndex;
		private int healingPower;


//const
public HealthPotion(String name, String description, int staminaIndex, int healingPower) {
	super(name, description, staminaIndex, healingPower);

}
	
	public int getHealingPower() {
		return healingPower;
	}

	
	public int getStaminaIndex() {
	  return staminaIndex;
	}

	public String toString(){
			return getName();
		}

	public void consume(Hero hero){
		System.out.println("Your health is full now!");
		hero.setHealthPoints(10);

	}
}