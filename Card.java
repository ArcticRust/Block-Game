import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Card {
    ArrayList<Coordinate> coordinates = new ArrayList<>();

    public Card(Coordinate... inputs) {
        addCoordinates(0, 0, inputs);
    }

    public Card(List<Coordinate> coordinates2) {
        addCoordinates(0, 0, coordinates2);
    }

    private void addCoordinates(int x, int y, List<Coordinate> coordinates2) {
        for (Coordinate input : coordinates2) {
            coordinates.add(new Coordinate(input.x + x, input.y + y));
        }
    }

    public void addCoordinates(int x, int y, Coordinate... inputs) {
        for (Coordinate input : inputs) {
            coordinates.add(new Coordinate(input.x + x, input.y + y));
        }
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void printCard() {
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;
        Set<List<Integer>> coordPairs = new HashSet<>();
        for (Coordinate coordinate : coordinates) {
            List<Integer> pair = new ArrayList<>();
            pair.add(coordinate.x);
            pair.add(coordinate.y);
            coordPairs.add(pair);
            maxY = Math.max(maxY, coordinate.y);
            maxX = Math.max(maxX, coordinate.x);
            minX = Math.min(minX, coordinate.x);
            maxY = Math.min(minY, coordinate.y);
        }
        for (int i = maxY; i >= minY; i--) {
            for (int j = maxX; j >= minX; j--) {
                Coordinate sampleCoordinate = new Coordinate(j, maxY - i);
                List<Integer> samplePair = new ArrayList<Integer>();
                samplePair.add(sampleCoordinate.x);
                samplePair.add(sampleCoordinate.y);
                if (coordPairs.contains(samplePair)) {
                
                    System.out.print("◼");
                } else {
                    System.out.print("◻");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean checkAvailability(int x, int y, List<Coordinate> inputs) {
        ArrayList<Integer> pairs = new ArrayList<Integer>();
        for (Coordinate coordinate : coordinates) {
            pairs.add(coordinate.x);
            pairs.add(coordinate.y);
        }
        ArrayList<Coordinate> adjustedCoordinates = new ArrayList<>();
        for (Coordinate coordinate : inputs) {
            adjustedCoordinates.add(new Coordinate(x + coordinate.x, y + coordinate.y));
        }
        for (Coordinate coordinate : adjustedCoordinates) {
            List<Integer> samplePair = new ArrayList<Integer>();
            samplePair.add(coordinate.x);
            samplePair.add(coordinate.y);
            if (pairs.contains(samplePair)) {
                return false;
            }
        }
        return true;
    }
}

class AlteredPair {
    List<Integer> pair;
    boolean added = false;
    AlteredPair(int x, int y, boolean added) {
        pair.add(x);
        pair.add(y);
        this.added = added;
    }
}



