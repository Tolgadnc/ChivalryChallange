import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Hero {
    private int xCoordinate;
    private int yCoordinate;
    private ArrayList<Items> inventory;
    private Area currentArea;
    private int itemsCount;
    private int healthPoints;


    public Hero(ArrayList<Items> inventory, Area currentArea, int itemsCount, int healthPoints){

        this.inventory = inventory;
        this.currentArea = currentArea;
        this.itemsCount = itemsCount;
        this.healthPoints = healthPoints;
    }
    public int getItemsCount(){
        return itemsCount;
    }

    public void showItemsInArea(){
        System.out.println(currentArea.getItemsInArea());
    }
    public void getItem(Items item){
        inventory.add(item);
        itemsCount++;
        if (itemsCount > 5){
            System.out.println("You can't carry anymore items.");
        }
    }
    public void useItem(Items item){

    }


    public void attack(Sword sword){
        //will be implemented when sword class is available.
    }
    public Vector<Integer> move(Directions direction){
        switch (direction){
            case NORTH:
                yCoordinate++;
                if (yCoordinate > 3){
                    yCoordinate = 3;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            case SOUTH:
                yCoordinate--;
                if (yCoordinate < 1){
                    yCoordinate = 1;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            case EAST:
                xCoordinate++;
                if (xCoordinate > 3){
                    xCoordinate = 3;
                    System.out.println("You have reached a wall, try going another way.");
                }

            case WEST:
                xCoordinate--;
                if (xCoordinate < 1){
                    xCoordinate = 1;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            case UP:
                yCoordinate++;
                if (yCoordinate > 3){
                    yCoordinate = 3;
                    System.out.println("You have reached a wall, try going another way.");
                }
                break;
            case DOWN:
                yCoordinate--;
                if (yCoordinate < 1){
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
    public void setCurrentArea(Area area){
        this.currentArea = area;
    }
    public Area getCurrentArea(){
        return currentArea;
    }

}
