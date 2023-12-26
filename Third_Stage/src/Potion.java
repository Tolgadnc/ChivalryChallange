

public class Potion extends Items {
	private int staminaIndex;
    private int healingPower;
  
  
  //constructor
  
  public Potion (String name, String description, int staminaIndex, int healingPower) {
	  super (name, description);
	  this.staminaIndex = staminaIndex;
      this.healingPower = healingPower;
  }
  
  //getter method
  public int getStaminaIndex() {
	  return staminaIndex;
  }

  public int getHealingPower(){
    return healingPower;
  }
}