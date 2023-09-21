class Main {
  public static void main(String[] args) {
    StateController stateController = new StateController();
    Board board = new Board();
    board.printDurability();
    board.printOwnership();
    Deck deck = new Deck();
    deck.getRandomCard().printCard();
    System.out.println(stateController.requestInput());
  }
}
