class Main {
  public static void main(String[] args) {
    StateController stateController = new StateController();
    while (true) {
      stateController.run();
      if (stateController.gameOver) {
        break;
      }
    }
  }
}
