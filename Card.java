import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

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
        // add functionality to this
        return true;
    }

    public void printCard() {
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;
        Set<List<Integer>> coordPairs = new HashSet<>();
        for (Coordinate coordinate : coordinates) {
            List<Integer> pair = new ArrayList<Integer>();
            pair.add(coordinate.x);
            pair.add(coordinate.y);
            coordPairs.add(pair);
            maxY = Math.max(maxY, coordinate.y);
            maxX = Math.max(maxX, coordinate.x);
        }
        for (int i = maxY; i >= minY; i--) {
            for (int j = maxX; j >= minX; j--) {
                Coordinate sampleCoordinate = new Coordinate(j, i);
                List<Integer> samplePair = new ArrayList<Integer>();
                samplePair.add(sampleCoordinate.x);
                samplePair.add(sampleCoordinate.y);
                if (coordPairs.contains(samplePair)) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}



