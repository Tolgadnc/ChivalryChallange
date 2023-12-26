

public class StaminaPotion extends Potion{
	private int staminaIndex;
	private int healingPower;

//const
	 public StaminaPotion (String name, String description,int staminaIndex, int healingPower) {
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
}