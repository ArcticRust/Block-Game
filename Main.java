import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    boolean AIControlled = false;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Play Against AI? (UNFINISHED) (Y/N)");
    boolean moveForward = false;
    while (!moveForward) {
      switch (scanner.nextLine()) {
      case "Y":
        AIControlled = true;
        moveForward = true;
        break;
      case "N":
        AIControlled = false;
        moveForward = true;
        break;
      default:
        System.out.println("Please Choose A Valid Input");
      }
    }
    moveForward = false;
    System.out.println("Read the Rules? (Y/N)");
    while (!moveForward) {
      switch (scanner.nextLine()) {
      case "Y":
        System.out.println("Each player can draw cards made up of blocks which they can place on a board. \nEach board spot has a durability - each time a block is placed on it, it decreases by 1. \nIf a board spot hits 0 durability, it is rendered useless and will not contribute to points. \nA player can 'add' to a card, adding 2 random blocks to it. \nMost owned blocks on the board at the end wins. \nPress any button to continue");
        scanner.nextLine();
        moveForward = true;
        break;
      case "N":
        moveForward = true;
        break;
      default:
        System.out.println("Please Choose A Valid Input");
      }
    }
    
    StateController stateController = new StateController(AIControlled);
    while (true) {
      stateController.run();
      if (stateController.getGameOver()) {
        break;
      }
    }
  }
}
