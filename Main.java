import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    boolean AIControlled = false;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Play Against AI? (Y/N)");
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
    
    StateController stateController = new StateController(AIControlled);
    while (true) {
      stateController.run();
      if (stateController.getGameOver()) {
        break;
      }
    }
  }
}
