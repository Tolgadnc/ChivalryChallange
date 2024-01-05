public class Arena extends Area {
	//class extends main
    public Arena(String title, String description, int villainCount) {
        super(title, description, villainCount);
    }

    //Method to initiate boss fight
    public void initiateBossFight(VillainBoss boss, Hero hero){
        boss.teleportToHero(hero);
        System.out.println(boss.getDescription());



    }
}
