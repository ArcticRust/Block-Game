import java.util.Scanner;
import java.util.ArrayList;

enum State {
    ViewingDurability,
    ViewingOwnership,
    PlacingCards,
    ViewingCards,
    AddingToCard,
    ChoosingOption,
}

public class StateController {
    public int turn = 0;
    public int playerTurn = 1;
    public boolean gameOver = false;
    Board board = new Board();
    private State currState = State.ChoosingOption;
    private ArrayList<Card> player1Cards = new ArrayList<>();
    private ArrayList<Card> player2Cards = new ArrayList<>();
    Deck deck = new Deck();
    Scanner scanner = new Scanner(System.in);
    String resultString = "";
    String white = "\u001B[37m";

    public void run() {
        clearTerminal();
        System.out.print(resultString);
        resultString = "";
        switch (currState) {   

            case ChoosingOption:
                ChoosingOptionFunc();
                break;
            case ViewingDurability:
                ViewingDurabilityFunc();
                break;
            case PlacingCards:
                break;
            case ViewingCards: 
                break;
            case AddingToCard:
                break;
        }
    }


    void endTurn() {
        turn++;
    }

    void giveCard(int player, Card card) {
        switch (player) {
            case 1:
                player1Cards.add(card);
                break;
            case 2:
                player2Cards.add(card);
                break;
            default:
                System.out.println("this is broken, check inputs for giveCard function");
        }
    } 

    String requestInput() {
        return scanner.nextLine();
    }

    void clearTerminal() {
        System.out.print("\033[H\033[2J");
    }

    void ViewingDurabilityFunc() {
        board.printDurability();
        System.out.println("Press q to view Durability\nPress w to go Back to Options");
        switch (requestInput()) {
            case "q":
                currState = State.ViewingDurability;
                break;
            case "w":
                currState = State.ChoosingOption;
                break;
            default:
                resultString = "Please Choose a Valid Input";
                break;
        }
    }

    void ChoosingOptionFunc() {
        System.out.println("Choose an action:\n q - View Durability of Board\n a - View Board Ownership\n w - Place a Card\n s - Add to a Card\n e - View your Cards");
        String input = requestInput();
        switch (input) {
            case "q":
                currState = State.ViewingDurability;
                break;
            case "a":
                currState = State.ViewingOwnership;
                break;
            case "w":
                currState = State.PlacingCards;
                break;
            case "s":
                currState = State.AddingToCard;
                break;
            case "e":
                currState = State.ViewingCards;
                break;
            default:
                resultString = "Please Choose a Valid Input\n";
                break;
        }
    }

    void print(String val) {
        System.out.println(white + val);
    }
}
