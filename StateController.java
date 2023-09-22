import java.util.Scanner;
import java.util.ArrayList;



public class StateController {
    private enum State {
        ViewingDurability {
            @Override
            public void action() {
                board.printDurability();
                println("Press q to view Durability\nPress w to go Back to Options");
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
        },
        ViewingOwnership,
        PlacingCards,
        ViewingCards,
        AddingToCard,
        
        ChoosingOption {
            @Override
            public void action() {
                println("Choose an action:\n q - View Durability of Board\n a - View Board Ownership\n w - Place a Card\n s - Add to a Card\n e - View your Cards");
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
        };

        public void action() { println("not implemented yet"); };
    }
    private static int turn = 0;
    private static int playerTurn = 1;
    public static boolean gameOver = false;
    private static Board board = new Board();
    private static State currState = State.ChoosingOption;
    private static ArrayList<Card> player1Cards = new ArrayList<>();
    private static ArrayList<Card> player2Cards = new ArrayList<>();
    private static Deck deck = new Deck();
    private static Scanner scanner = new Scanner(System.in);
    private static String resultString = "";

    public void run() {
        clearTerminal();
        print(resultString);
        resultString = "";
        currState.action();
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
                println("this is broken, check inputs for giveCard function");
        }
    } 

    static String requestInput() {
        return scanner.nextLine();
    }

    void clearTerminal() {
        System.out.print("\033[H\033[2J");
    }


    static void println(String val) {
        System.out.println("\u001B[37m" + val);
    }
    
    static void print(String val) {
        System.out.print("\u001B[37m" + val);
    }
}
