import java.util.ArrayList;

public class TrainigRoom extends Area {
    public TrainigRoom(String title, String description, int villainCount, ArrayList<Items> itemsInArea, ArrayList<Exits> exits, ArrayList<Coordinates> coordinates, ArrayList<Villain> villains){
        super(title, description, villainCount, itemsInArea, exits, coordinates, villains);
    }

}
