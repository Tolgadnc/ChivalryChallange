import java.util.ArrayList;
import java.util.HashMap;
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




    public void attack(Sword sword) {
        //will be implemented when sword class is available.
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

}
