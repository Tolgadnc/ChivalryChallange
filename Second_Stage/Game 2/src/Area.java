import java.util.ArrayList;

public class Area {
    private int villainCount;
    private ArrayList<Coordinates> coordinates;
    private ArrayList<Items> itemsInArea;
    private ArrayList<Villain> villains;
    private String title;
    private String description;
    private ArrayList<Exits> exits;

    public Area(String title, String description, int villainCount, ArrayList<Items> itemsInArea, ArrayList<Exits> exits, ArrayList<Coordinates> coordinates, ArrayList<Villain> villains){
        this.title = title;
        this.description = description;
        this.villainCount = villainCount;
        this.itemsInArea = itemsInArea;
        this.exits = exits;
        this.coordinates = coordinates;
        this.villains = villains;

    }
    public void addItems(Items item){
        itemsInArea.add(item);
    }
    public void removeItems(Items item){
        itemsInArea.remove(item);
    }
    public void addVillain(Villain villain){
        villains.add(villain);
        villainCount++;
    }
    public void removeVillain(Villain villain){
        villains.remove(villain);
        villainCount--;
    }
    public void addExits(Exits exit){
        exits.add(exit);

    }
    public void useExit(Exits exit, Directions direction, Hero hero) {
        if (exit.getAllowedDirections().contains(direction)) {
            System.out.println("You are exiting the " + title );

            // Update the hero's current area

            hero.setCurrentArea(exit.getGoesTo());

            System.out.println("You have entered " + hero.getCurrentArea().getTitle() + ".");
            System.out.println(hero.getCurrentArea().promptDescription());
        } else {
            System.out.println("There is no exit in that direction.");
        }
    }

    public int getVillainCount(){
        return villainCount;
    }
    public String promptDescription(){
        String titleOfArea = "You are in " + title + "\n";
        String descOfArea = description;
        String wholePrompt = titleOfArea + descOfArea;
        return wholePrompt;

    }
    public ArrayList<Items> getItemsInArea(){
        return itemsInArea;
    }
    public ArrayList<Exits> getExits(){
        return exits;
}
    public String getTitle(){
        return title;
    }
}