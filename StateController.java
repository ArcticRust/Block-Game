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
}
