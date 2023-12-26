
public class SingleHandedSword extends Sword {

	
	//constructor
	public SingleHandedSword (String name, String description, int blockPower, int sliceDamage, int stabDamage) {
		super (name, description ,sliceDamage, stabDamage, blockPower);
		}

	public String toString(){
		return getName();
	}
	



}