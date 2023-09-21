import java.util.Scanner;

enum State {
    ViewingDurability,
    ViewingOwnership,
    PlacingCards,
    ViewingCards,
    AddingToCard,
}

public class StateController {
    int turn = 0;
    int playerTurn = 1;
    State currState;
    
    String requestInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }
}
