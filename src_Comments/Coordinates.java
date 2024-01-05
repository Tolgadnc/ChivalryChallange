
import java.util.HashMap;

//We are not sure if we actually need this class but we wanted you to get your opinion on this.
public class Coordinates {
    private HashMap<Integer, Integer> coordinates;
/*This class is mainly used to setup the cordnates for the hero to 
    move and the villain are set in the coordinates*/
    public Coordinates(){
        this.coordinates = new HashMap<>();
    }
    public void addCoordinate(int x, int y){
        coordinates.put(x, y);


    }

    public HashMap<Integer, Integer> getCoordinates(){
        return coordinates;
    }
}
