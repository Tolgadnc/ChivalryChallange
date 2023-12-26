

public class Sword extends Items{
	private int sliceDamage;
	private int stabDamage;
	private int blockPower;
	
	//constructor
	public Sword(String name, String description, int blockPower, int sliceDamage, int stabDamage) {
		super (name, description);
		this.sliceDamage = sliceDamage;
		this.stabDamage = stabDamage;
		this.blockPower = blockPower;
	}

	public void slice(Villain villain){

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
