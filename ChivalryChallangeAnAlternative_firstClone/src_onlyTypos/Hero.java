import java.util.*;

public class Hero {
    private Random heroDice;
    private int xCoordinate = 2;
    private int yCoordinate = 2;
    private Vector<Items> inventory;
    private Area currentArea;
    private int itemsCount;
    private int healthPoints;
    private int staminaPoints;
    private Villain currentVillain;


    public Hero(int itemsCount, int healthPoints, int staminaPoints, Area currentArea) {

        this.inventory = new Vector<Items>();
        this.currentArea = currentArea;
        this.itemsCount = itemsCount;
        this.healthPoints = healthPoints;
        this.staminaPoints = staminaPoints;
        this.heroDice = new Random();
        this.currentVillain = new Villain("*","*",0,0,0,0,0,0);
    }

    public void setCurrentVillain(Villain villain) {
        this.currentVillain = villain;
    }

    public Villain getCurrentVillain() {
        return currentVillain;
    }

    public int heroRollDice() {
        int roll = heroDice.nextInt(6) + 1;
        System.out.println("You rolled:" + roll);
        return roll;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void showItemsInArea() {
        System.out.println(currentArea.getItemsInArea());
    }

    public void getItem(Items item) {
        inventory.add(item);
        itemsCount++;
    }

    public void useItem(Items item) {

    }

    public void initiateCombat(Villain villain, Sword sword, Shield shield, Hero hero, Area area) {
        setCurrentVillain(villain);

        boolean combatInProgress = true;
        boolean successfulParry = false;
        boolean defendInProgress = false;

        while (combatInProgress && currentVillain.getHealthPoints() > 0 && healthPoints > 0) {




            System.out.println("Choose your attack type: Enter \"slice\" or \"stab\" ");
            Scanner scanner = new Scanner(System.in);
            String userAttack = scanner.nextLine();




            switch (userAttack.toLowerCase(Locale.ROOT)) {
                case "slice":

                    if (staminaPoints > 0 && hero.currentVillain.getHealthPoints() > 0){
                        sword.slice(villain, hero);

                        if (currentVillain.getHealthPoints() <= 0) {
                            System.out.println("You defeated " + villain.getVillainName() + villain.getDyingSpeech());
                            area.heroKillEnemy();
                        }else {

                            villain.villainAttack();
                            villain.displayVillainStats();
                            System.out.println("You are under attack! You must respond. Enter \"block\" or \"parry\"");
                            defendInProgress = true;
                        }










                        if (successfulParry == true) {
                            sword.damageTurnBackToNormal();
                            System.out.println("Slice damage: " + sword.getSliceDamage());
                            System.out.println("Stab damage: " + sword.getStabDamage());
                            successfulParry = false;  // Reset the flag

                        }


                    } else if (staminaPoints < 0) {
                        staminaPoints = 0;

                    } else if (currentVillain.getHealthPoints() <= 0){
                        combatInProgress = false;
                    } else {
                        System.out.println("You are too tired to attack. You back away from your opponent a bit and catch your breath (SP +1)");
                        staminaPoints++;
                    }


                    while (defendInProgress) {
                        String userDefend = scanner.nextLine();

                        switch (userDefend.toLowerCase(Locale.ROOT)) {
                            case "block":
                                if (staminaPoints > 0){
                                    block(sword, shield, villain);
                                    displayStats();
                                } else if (staminaPoints < 0) {
                                    staminaPoints = 0;

                                } else if (hero.currentVillain.getHealthPoints() <= 0) {
                                    combatInProgress = false;

                                } else{
                                    System.out.println("Because of your lack of stamina, the opponent breaches your defenses and lands a perfect blow!");
                                    healthPoints -= villain.getDamagecapacity();
                                }

                                defendInProgress = false;  // Exit defend loop
                                break;
                            case "parry":
                                successfulParry = parry(shield, villain, sword);
                                displayStats();
                                defendInProgress = false;  // Exit defend loop
                                break;
                        }
                    }

                    // Check if successful parry flag is set and reset sword stats

                    break;

                case "stab":
                    if (staminaPoints > 0 && hero.currentVillain.getHealthPoints() > 0){
                        sword.stab(villain, hero);

                        if (currentVillain.getHealthPoints() <= 0) {
                            System.out.println("You defeated " + villain.getVillainName() + villain.getDyingSpeech());
                            area.heroKillEnemy();
                        }else {

                            villain.villainAttack();
                            villain.displayVillainStats();
                            System.out.println("You are under attack! You must respond. Enter \"block\" or \"parry\"");
                            defendInProgress = true;
                        }
                        if (successfulParry == true) {
                            sword.damageTurnBackToNormal();
                            System.out.println("Slice damage: " + sword.getSliceDamage());
                            System.out.println("Stab damage: " + sword.getStabDamage());
                            successfulParry = false;  // Reset the flag

                        }

                    } else if (staminaPoints < 0) {
                        staminaPoints = 0;

                    } else if (hero.currentVillain.getHealthPoints() <= 0) {
                        combatInProgress = false;

                    } else {
                        System.out.println("You are too tired to attack. You back away from your opponent a bit and catch your breath (SP +1)");
                        staminaPoints++;
                    }



                    while (defendInProgress) {
                        String userDefend = scanner.nextLine();

                        switch (userDefend.toLowerCase(Locale.ROOT)) {
                            case "block":
                                if (staminaPoints > 0){
                                    block(sword, shield, villain);
                                    displayStats();

                                }else if (staminaPoints < 0){
                                    staminaPoints = 0;
                                } else {
                                    System.out.println("Because of your lack of stamina, the opponent breaches your defenses and lands a perfect blow!");
                                    healthPoints -= villain.getDamagecapacity();
                                }

                                defendInProgress = false;  // Exit defend loop
                                break;
                            case "parry":
                                successfulParry = parry(shield, villain, sword);
                                displayStats();
                                defendInProgress = false;  // Exit defend loop
                                break;
                        }
                    }


                    break;
                case "quit":
                    System.out.println("Do you want to quit? All progress for this particular fight will be lost. Enter yes or no");
                    while (true){
                        String quitDecision = scanner.nextLine();
                        switch (quitDecision.toLowerCase(Locale.ROOT)){
                            case "yes":
                                currentVillain.restoreHealth();
                                combatInProgress = false;
                                break;
                            case "no":

                                break;
                            default:
                                System.out.println("Please enter a valid command (yes or no)");

                        }
                        if (quitDecision.equalsIgnoreCase("yes") || quitDecision.equalsIgnoreCase("no")) {//For this line we had help from chatGPT. We were unable to find the reason for unreachable statement.
                            break;
                        }
                    }


                    break;




                default:
                    System.out.println("Other commands are not available during combat");
            }



            if (healthPoints <= 0) {
                System.out.println("Game over");
                System.exit(0);

            }


        }

    }










    public Vector<Integer> move(Directions direction) {
        switch (direction) {
            case NORTH:
                yCoordinate++;
                if (yCoordinate > 3) {
                    yCoordinate = 3;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            case SOUTH:
                yCoordinate--;
                if (yCoordinate < 1) {
                    yCoordinate = 1;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            case EAST:
                xCoordinate++;
                if (xCoordinate > 3) {
                    xCoordinate = 3;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;

            case WEST:
                xCoordinate--;
                if (xCoordinate < 1) {
                    xCoordinate = 1;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            case UP:
                yCoordinate++;
                if (yCoordinate > 3) {
                    yCoordinate = 3;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            case DOWN:
                yCoordinate--;
                if (yCoordinate < 1) {
                    yCoordinate = 1;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            default:
                System.out.println("You can only go north, south, east or west.");
                break;
        }

        return getCurrentCoordinate();

    }

    public Vector<Integer> getCurrentCoordinate(){
        Vector<Integer> currentCoordinate = new Vector<>(2);
        int x = xCoordinate;
        int y = yCoordinate;

        currentCoordinate.add(x);
        currentCoordinate.add(y);
        return currentCoordinate;

    }

    public void setCurrentArea(Area area) {
        this.currentArea = area;
    }

    public Area getCurrentArea() {
        return currentArea;
    }

    public Vector<Items> getInventory() {
        return inventory;
    }

    public void displayInventory(){
        StringBuilder inventoryString = new StringBuilder("Inventory: [");

        for (int i = 0; i < getItemsCount(); i++) {

            if (i < getItemsCount() - 1) {
                inventoryString.append(inventory.get(i).toString()).append(", ");
            }else{
                inventoryString.append(inventory.get(i).toString());

            }


        }
        inventoryString.append("]");
        System.out.println(inventoryString.toString());
    }

    public void removeItems() {
        while (!inventory.isEmpty()) {
            inventory.remove(inventory.size() - 1);
            itemsCount--;
        }
    }


    public int getHealthPoints(){
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;

    }

    public void displayHealth(){
        System.out.println(healthPoints);
    }

    public int getStaminaPoints(){
        return staminaPoints;
    }
    public void setStaminaPoints(int staminaPoints){
        this.staminaPoints = staminaPoints;
    }

    public void displayStamina(){
        System.out.println(staminaPoints);
    }

    public void displayStats(){
        System.out.println("-----------------------------");
        System.out.println("Your HP: " + healthPoints + "\n" + "Your SP: " + staminaPoints);
        System.out.println("-----------------------------");
    }

    public void normalLook(){
        Vector currentCoordiante = getCurrentCoordinate();

        if((int) currentCoordiante.get(0) == 1 && (int) currentCoordiante.get(1) == 1) {
            System.out.println("When you look around, towards north you see an open field and it seems very windy. When you look at east you see sunny and bright place all covered in sand, almost like a desert.");


        } else if ((int) currentCoordiante.get(0) == 1 && (int) currentCoordiante.get(1) == 3) {
            System.out.println("When you look around, towards south you see an open field and it seems very windy. When you look at east you see snowy trees all around, seems chilling.");
        } else if ((int) currentCoordiante.get(0) == 3 && (int) currentCoordiante.get(1) == 3) {
            System.out.println("When you look around, towards west you see snowy trees all around, seems chilling. When you look at south you see large trees all around, it seems like there is a heavy rain over there.");
        } else if ((int) currentCoordiante.get(0) == 3 && (int) currentCoordiante.get(1) == 1) {
            System.out.println("When you look around, towards north you see large trees all around, it seems like there is a heavy rain over there. When you look at west you see sunny and bright place all covered in sand, almost like a desert.");
        } else if ((int) currentCoordiante.get(0) == 2 && (int) currentCoordiante.get(1) == 2) {
            System.out.println("When you look around, towards north you see snowy trees all around, seems chilling.\n When you look at south you see sunny and bright place all covered in sand, almost like a desert.\n When you turn towards east, you see large trees all around, it seems like there is a heavy rain over there.\n And on your west you see an open field and it seems very windy.");

        }
    }
    public void villainLook(Villain villain){
        Vector currentCoordiante = getCurrentCoordinate();
        if ((int) currentCoordiante.get(0) == 2 && (int) currentCoordiante.get(1) == 3) {
            if (villain.getHealthPoints() > 0){
                System.out.println("While you are looking around, inside this snowy biome, you see a " + villain.getDescription() );//+ getVillainDescription()
            }else{
                System.out.println("On the snow, the lifeless form of your enemy lay defeated.");

            }


        } else if ((int) currentCoordiante.get(0) == 3 && (int) currentCoordiante.get(1) == 2){
            if (villain.getHealthPoints() > 0){
                System.out.println("Inside this humid and damp rainforest, while you are looking around you encounter a " + villain.getDescription() );//+ getVillainDescription()
            }else{
                System.out.println("On the muddy soil, the lifeless form of your enemy lay defeated.");
            }
        } else if ((int) currentCoordiante.get(0) == 2 && (int) currentCoordiante.get(1) == 1){
            if (villain.getHealthPoints() > 0){
                System.out.println("The sand gets into your eye. It is hard to see in this excruciatingly hot desert like environment. However, all of a sudden you encounter a " + villain.getDescription() );//+ getVillainDescription()
            }else{
                System.out.println("On the sand, the lifeless form of your enemy lay defeated.");
            }

        } else if ((int) currentCoordiante.get(0) == 1 && (int) currentCoordiante.get(1) == 2) {
            if (villain.getHealthPoints() > 0){
                System.out.println("It is almost impossible to open your eyes. The winds are so strong let alone seeing, standing is a hard task. Over there in the distance you see a " + villain.getDescription());//+ getVillainDescription()
            }else{
                System.out.println("On the plain field, the lifeless form of your enemy lay defeated.");
            }

        }
    }



    public void block(Sword sword, Shield shield, Villain villain){
        if (inventory.contains(shield) && shield.getBlockPower() < villain.getDamagecapacity()){
            if(villain.villainRollDice() > heroRollDice()){
                System.out.println("Unfortunately, you were not successful with your block.");
                healthPoints -= villain.getDamagecapacity();
                staminaPoints -= 1;
            }else{
                System.out.println("You blocked your opponents attack partially using your shield");
                healthPoints -= (villain.getDamagecapacity() - shield.getBlockPower());


            }
        }else if (inventory.contains(shield) && shield.getBlockPower() >= villain.getDamagecapacity()){
            if(villain.villainRollDice() > heroRollDice()){
                System.out.println("Unlucky! Your defense was sloppy.");
                healthPoints--;



                staminaPoints -= 1;
            }else{
                System.out.println("You blocked your opponents attack completely using your shield!");

            }

        } else if ((!inventory.contains(shield)) && sword.getBlockPower() < villain.getDamagecapacity()) {
            if(villain.villainRollDice() > heroRollDice()){
                System.out.println("Unfortunately, you were not successful with your block.");
                healthPoints -= villain.getDamagecapacity();
                staminaPoints -= 1;
            }else{
                System.out.println("You blocked your opponents attack partially using your sword");
                healthPoints -= (villain.getDamagecapacity() - sword.getBlockPower());

            }

        } else if ((!inventory.contains(shield)) && sword.getBlockPower() >= villain.getDamagecapacity()){
            if(villain.villainRollDice() > heroRollDice()){
                System.out.println("Unfortunately, you were not successful with your block.");
                healthPoints -= villain.getDamagecapacity();
                staminaPoints -= 1;
            }else{
                System.out.println("You blocked your opponents attack completely using your sword!");
            }
        }
    }

    public boolean parry(Shield shield, Villain villain, Sword sword){
        if (inventory.contains(shield) && shield.getParryPower() < villain.getParryDenyCapacity()){
            if(heroRollDice() == 6 && villain.villainRollDice() != 6){
                System.out.println("You got lucky! You parried your opponents attack successfully. Now your opponent is vulnerable, time to strike!");
                sword.tempDamageIncreaseWithParry();
                System.out.println("Slice damage: " + sword.getSliceDamage());
                System.out.println("Stab damage: " + sword.getStabDamage());
                return true;
            }else{
                System.out.println("You were unable to parry your opponents attack");
                healthPoints -= villain.getDamagecapacity();

            }
        } else if (inventory.contains(shield) && shield.getParryPower() >= villain.getParryDenyCapacity()) {
            if(heroRollDice() < villain.villainRollDice()){
                System.out.println("You were not able to parry your opponent");
                healthPoints -= villain.getDamagecapacity();

            }else{
                System.out.println("You successfully parried your opponents attack! Now your opponent is vulnerable, time to strike!");
                sword.tempDamageIncreaseWithParry();
                System.out.println("Slice damage: " + sword.getSliceDamage());
                System.out.println("Stab damage: " + sword.getStabDamage());
                return true;
            }

        }else {
            System.out.println("You need a shield in order to parry your opponents attack. You will learn the hard way. Opponent was successful with their attack.");
            healthPoints -= villain.getDamagecapacity();
        }
        return false;
    }
    public void staminaUseUp(int usedStamina){
        staminaPoints -= usedStamina;

    }

    public void consumePotion(Potion potion, Hero hero){

        if(inventory.contains(potion)){
            potion.consume(hero);

        }else{
            System.out.println("You do not posses " + potion.getName());
        }
    }
    public void remove(Items item){
        if (inventory.contains(item)){
            inventory.remove(item);
        }

    }



}
