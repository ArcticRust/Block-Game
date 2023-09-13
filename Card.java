import java.net.CookiePolicy;
import java.util.ArrayList;

public class Card {
    ArrayList<Coordinate> coordinates = new ArrayList<>();

    public Card(Coordinate... inputs) {
        addCoordinates(inputs);
    }

    public void addCoordinates(Coordinate... inputs) {
        for (Coordinate input : inputs) {
            coordinates.add(input);
        }
    }

    public boolean checkAvailability(Coordinate... inputs) {
        return true;
    }
}


