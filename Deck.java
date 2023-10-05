public class Deck {
  public Card cards[] = {
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
      new Coordinate(0, 0)
    ),
    new Card(
      new Coordinate(0, 0),
      new Coordinate(0, 1)
    ),
    new Card(
      new Coordinate(0, 0),
      new Coordinate(0, 1),
      new Coordinate(1, 0)
    )
  };

  public Card getRandomCard() {
    return new Card(cards[(int) Math.floor(Math.random() * cards.length)].getCoordinates());
  }

}
