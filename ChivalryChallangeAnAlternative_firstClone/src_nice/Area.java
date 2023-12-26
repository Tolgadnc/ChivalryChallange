import java.util.ArrayList;

public class Area {
    private int villainCount;

    private ArrayList<Items> itemsInArea;
    private ArrayList<Villain> villains;
    private String title;
    private String description;


    public Area(String title, String description, int villainCount){
        this.title = title;
        this.description = description;
        this.villainCount = villainCount;
        this.itemsInArea = new ArrayList<Items>();
        this.villains = new ArrayList<Villain>() ;

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

    public String getTitle(){
        return title;
    }



}