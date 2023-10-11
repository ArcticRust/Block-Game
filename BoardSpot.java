public class BoardSpot {

    private int value;
    private int controlledBy; 
    // -1 designates broken, 0 designates blank, 1 designates player 1, 2 designates player 2   


    BoardSpot(int value) {
        this.value = value;
        controlledBy = 0;
    }

    public boolean setControl(int player) {
        if (player == 0) {
            value++;
        }
        if (value <= 1) {
            controlledBy = -1;
        }
        else if (controlledBy == 0) {
            value--;
            controlledBy = player;
            return true;
        }
        return false;
    }

    public int getValue() {
        return value;
    }

    public int getPlayer() {
        return controlledBy;
    }
}
