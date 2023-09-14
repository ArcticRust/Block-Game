class Main {
  public static void main(String[] args) {
    Board board = new Board();
    board.printDurability();
    board.printOwnership();
    Deck deck = new Deck();
    deck.getRandomCard().printCard();

  }
}
