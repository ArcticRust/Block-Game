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
      new Coordinate(1, 1),
      new Coordinate(1, 0),
      new Coordinate(1, 2),
      new Coordinate(0, 2),
      new Coordinate(2, 2)
    )
  };

  public Card getRandomCard() {
    return cards[(int) Math.floor(Math.random() * cards.length)];
  }

}