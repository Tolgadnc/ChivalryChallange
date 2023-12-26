

public class Sword extends Items{
	public int sliceDamage;
	public int stabDamage;
	public int blockPower;
	
	//constructor
	public Sword(String name, String description, int blockPower, int sliceDamage, int stabDamage) {
		super (name, description);
		this.sliceDamage = sliceDamage;
		this.stabDamage = stabDamage;
		this.blockPower = blockPower;
	}
	
	// getter methods
	
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
