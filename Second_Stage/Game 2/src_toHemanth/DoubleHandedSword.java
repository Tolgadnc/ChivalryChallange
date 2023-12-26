

public class DoubleHandedSword extends Sword {

	
	//constructor
	
	public DoubleHandedSword (String name, String description, int blockPower, int sliceDamage, int stabDamage) {
		super(name,description,sliceDamage, stabDamage,blockPower);
		
		 this.stabDamage = stabDamage;
		 this.sliceDamage = sliceDamage;
	}
	
	public int getSliceDamage() {
		return sliceDamage;
	}
	
	public int getStabDamage() {
		return stabDamage;
	}
	
	public int getBlockPower() {
		return blockPower;
	}

	public String toString(){
		return getName();
	}



}
