
public class SingleHandedSword extends Sword {
	private int sliceDamage;
	private int stabDamage;
	
	//constructor
	public SingleHandedSword (String name, String description, int damage, int blockPower, int sliceDamage) {
		super (name, description ,damage, blockPower);
		this.sliceDamage = sliceDamage;
		}
	
	public int getSliceDamage() {
		return sliceDamage;
	}
	public int getStabDamage(){
		return stabDamage;
	}
	public int getBlockPower() {
		return blockPower;
	}

	
}