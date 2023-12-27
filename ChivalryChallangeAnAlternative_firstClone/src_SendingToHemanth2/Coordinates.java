import java.util.ArrayList;
import java.util.HashMap;

//We are not sure if we actually need this class but we wanted you to get your opinion on this.
public class Coordinates {
    private HashMap<Integer, Integer> coordinates;

    public Coordinates(){
        this.coordinates = new HashMap<>();
    }
    public void addCoordinate(int x, int y){
        coordinates.put(x, y);


    }

    public HashMap<Integer, Integer> getCoordinates(){
        return coordinates;
    }
    public
}
