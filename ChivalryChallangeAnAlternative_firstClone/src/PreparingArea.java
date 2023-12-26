import java.util.ArrayList;

public class PreparingArea extends Area {
    public PreparingArea(int villainCount, ArrayList<Coordinates> coordinates, ArrayList<Items> itemsInArea, String title, String description, ArrayList<Exits> exits, ArrayList<Villain> villains) {
        super(title, description, villainCount, itemsInArea, exits, coordinates, villains);


    }

}
