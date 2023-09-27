class Main {
  public static void main(String[] args) {
    /*
    Board testBoard = new Board();
    testBoard.printOwnership();
    testBoard.printDurability();
    */
    StateController stateController = new StateController(false);
    while (true) {
      stateController.run();
      if (stateController.getGameOver()) {
        break;
      }
    }
  }
}
