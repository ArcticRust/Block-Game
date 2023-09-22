class Main {
  public static void main(String[] args) {
    StateController stateController = new StateController(false);
    while (true) {
      stateController.run();
      if (stateController.getGameOver()) {
        break;
      }
    }
  }
}
