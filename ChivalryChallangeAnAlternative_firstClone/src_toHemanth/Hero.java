import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Hero {
    private int xCoordinate = 2;
    private int yCoordinate = 2;
    private ArrayList<Items> inventory;
    private Area currentArea;
    private int itemsCount;
    private int healthPoints;
    private int staminaPoints;


    public Hero(int itemsCount, int healthPoints, int staminaPoints, Area currentArea) {

        this.inventory = new ArrayList<Items>();
        this.currentArea = currentArea;
        this.itemsCount = itemsCount;
        this.healthPoints = healthPoints;
        this.staminaPoints = staminaPoints;
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




    public void attack(Villain villain, Sword sword) {

        if (getCurrentCoordinate() == villain.getCurrentCoordinatesVillain()){
            System.out.println("You draw your weapon, now you are ready to attack!");
            while (villain.getHealthPoints() > 0 || getHealthPoints() > 0){
                Scanner scanner = new Scanner(System.in);
                String userAttack = scanner.nextLine();
                switch (userAttack){
                    case "slice":
                        sword.

                }

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

    public ArrayList<Items> getInventory() {
        return inventory;
    }

    public void displayInventory(){
        StringBuilder inventoryString = new StringBuilder("Inventory: [");

        for (int i = 0; i < getItemsCount(); i++) {

            if (i != getItemsCount() - 1) {
                inventoryString.append(inventory.get(i).toString()).append(", ");
            }else{
                inventoryString.append(inventory.get(i).toString());

            }


        }
        inventoryString.append("]");
        System.out.println(inventoryString.toString());
    }

    public void removeItems() {
        int inventorySize = inventory.size();

        for (int i = 0; i < inventorySize; i++) {

            inventory.remove(i);

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

    public void look(){
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
        } else if ((int) currentCoordiante.get(0) == 2 && (int) currentCoordiante.get(1) == 3) {
            System.out.println("While you are looking around, inside this snowy biome, you see a " );//+ getVillainDescription()
        } else if ((int) currentCoordiante.get(0) == 3 && (int) currentCoordiante.get(1) == 2){
            System.out.println("Inside this humid and damp rainforest, while you are looking around you encounter a " );//+ getVillainDescription()
        } else if ((int) currentCoordiante.get(0) == 2 && (int) currentCoordiante.get(1) == 1){
            System.out.println("The sand gets into your eye. It is hard to see in this excruciatingly hot desert like environment However all of a sudden you encounter a " );//+ getVillainDescription()
        } else if ((int) currentCoordiante.get(0) == 1 && (int) currentCoordiante.get(1) == 2) {
            System.out.println("It is almost impossible to open your eyes. The winds are so strong let alone seeing, standing is a hard task. Over there in the distance you see a");//+ getVillainDescription()
        }
    }

}
