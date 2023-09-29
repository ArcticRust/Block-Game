public class Coordinate {

    public int x;
    public int y;
    public boolean partOfAdding = false;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Coordinate(int x, int y, boolean partOfAdding) {
        this.x = x;
        this.y = y;
        this.partOfAdding = partOfAdding;
    }
}
