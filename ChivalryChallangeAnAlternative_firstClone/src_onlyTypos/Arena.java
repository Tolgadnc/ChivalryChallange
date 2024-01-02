import java.util.ArrayList;

public class Arena extends Area {
    public Arena(String title, String description, int villainCount) {
        super(title, description, villainCount);
    }


    public void initiateBossFight(VillainBoss boss, Hero hero){
        boss.teleportToHero(hero);
        System.out.println(boss.getDescription());



    }
}
