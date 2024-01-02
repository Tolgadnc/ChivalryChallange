
import java.util.List;
import java.util.Vector;

public class VillainBoss extends Villain {
	public VillainBoss (String name, String description, int xCoordinate, int yCoordinate, int healthPoints, int parryDenyCapacity, int damageCapacity, int blockCapacity) {
		
		super(name, description, xCoordinate, yCoordinate, healthPoints, parryDenyCapacity, damageCapacity, blockCapacity);

	}
	public void teleportToHero(Hero hero){
			Vector heroesCoordinate = hero.getCurrentCoordinate();
			setXCoordinate((int) heroesCoordinate.get(0));
			setYCoordinate((int) heroesCoordinate.get(1));
	}
	public void restoreHealth(){
		setHealthPoints(15);
	}

}