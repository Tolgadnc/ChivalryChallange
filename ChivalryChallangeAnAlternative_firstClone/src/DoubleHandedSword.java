

public class DoubleHandedSword extends Sword {
	private int sliceDamage;
	private int stabDamage;
	
	//constructor
	
	public DoubleHandedSword (String name, String description, int damage, int blockPower, int sliceDamage, int stabDamage) {
		super(name,description,damage,blockPower);
		
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



}
