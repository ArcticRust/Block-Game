class Main {
  public static void main(String[] args) {
    Card cards[] = {
      new Card(
        new Coordinate(0, 0),
        new Coordinate(1, 0),
        new Coordinate(0, 1)
      ),
      new Card(
        new Coordinate(1, 0),
        new Coordinate(1, 1),
        new Coordinate(0, 1)
      ),
      new Card(
        new Coordinate(0, 0),
        new Coordinate(1, 0),
        new Coordinate(0, 1),
        new Coordinate(1, 1)
      ),
      new Card(
        new Coordinate(2, 0),
        new Coordinate(1, 0),
        new Coordinate(0, 0)
      ),
      new Card(
        new Coordinate(0, 0),
        new Coordinate(0, 1),
        new Coordinate(0, 2)
      ),
      new Card(
        new Coordinate(0, 1),
        new Coordinate(0, 0),
        new Coordinate(0, 2),
        new Coordinate(-1, 2),
        new Coordinate(1, 2)
      )
    };
    Board board = new Board();
    board.printDurability();
    board.printOwnership();
  }
}
