

public class DoubleHandedSword extends Sword {

	
	//constructor
	
	public DoubleHandedSword (String name, String description, int blockPower, int sliceDamage, int stabDamage) {
		super(name,description,sliceDamage, stabDamage,blockPower);
		

	}
	


	public String toString(){
		return getName();
	}



}
