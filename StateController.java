import java.util.Scanner;
import java.util.ArrayList;



public class StateController {
    private enum State {
        ViewingDurability {
            @Override
            public void action() {
                board.printDurability();
                println("Press q to view Ownership\nPress w to go Back to Options");
                switch (requestInput()) {
                case "q":
                    currState = State.ViewingOwnership;
                    break;
                case "w":
                    currState = State.ChoosingOption;
                    break;
                default:
                    resultString = "Please Choose a Valid Input\n";
                    break;
                }
            }
        },
        
        ViewingOwnership {
            @Override
            public void action() {
                board.printOwnership();
                println("Press q to view Durability\nPress w to go Back to Options");
                switch (requestInput()) {
                    case "q":
                        currState = State.ViewingDurability;
                        break;
                    case "w":
                        currState = State.ChoosingOption;
                        break;
                    default:
                        resultString = "Please Choose a Valid Input\n";
                        break;
                }
            }
        },

        PlacingCards,

        DrawingCard {
            @Override
            public void action() {
                Card card1 = deck.getRandomCard();
                Card card2 = deck.getRandomCard();
                println("Card 1:");
                card1.printCard();
                println("Card 2:");
                card2.printCard();
                boolean invalidInput = true;
                println("Press 1 for Card 1, Press 2 for Card 2");
                while (invalidInput) {
                    switch (requestInput()) {
                        case "1":
                            if (playerTurn == 1) { player1Cards.add(card1); } else { player2Cards.add(card1); };
                            invalidInput = false;
                            break;
                        case "2":
                            if (playerTurn == 1) { player1Cards.add(card2); } else { player2Cards.add(card2); };
                            invalidInput = false;
                            break;
                        default:
                            println("Please input a valid card number");
                            break;
                    }
                }
                endTurn();
                currState = State.ChoosingOption;
            }
        },

        AddingToCard,

        ChoosingOption {
            @Override
            public void action() {
                println(String.format("Player %d turn:", playerTurn));
                println("Choose an action:\n q - View Durability of Board\n a - View Board Ownership\n w - Place a Card\n s - Add to a Card\n e - Draw a Card");
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
                        currState = State.DrawingCard;
                        break;
                    default:
                        resultString = "Please Choose a Valid Input\n";
                        break;
                }
            }
        };

        public void action() { 
            println("not implemented yet"); 
            gameOver = true;
        };
    }

    private static int playerTurn = 1;
    private static boolean gameOver = false;
    private static boolean AI = false;
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


    static void endTurn() {
        playerTurn = playerTurn == 1 ? 2 : 1;
        currState = State.ChoosingOption;
    }

    void giveCard(Card card) {
        switch (playerTurn) {
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
        if (AI && playerTurn == 1) {
            return AIDecision();
        }
        else {
            return scanner.nextLine().trim().toLowerCase();
        }
    }

    static String AIDecision() {
        return "not implemented";
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

    public boolean getGameOver() {
        return gameOver;
    }

    public StateController(boolean AIControlled) {
        AI = AIControlled;
    } 
}
