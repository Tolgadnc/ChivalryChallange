

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
}