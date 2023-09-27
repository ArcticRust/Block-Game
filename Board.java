import java.util.ArrayList;
import java.util.HashMap;

public class Board {
  ArrayList<ArrayList<BoardSpot>> arr = new ArrayList<>();
  HashMap<Integer, String> colorConversion = new HashMap<>();

  Board() {
    colorConversion.put(1, "\u001B[31m");
    colorConversion.put(2, "\u001B[32m");
    colorConversion.put(3, "\u001B[33m");
    colorConversion.put(4, "\u001B[34m");
    colorConversion.put(5, "\u001B[35m");
    for (int i = 0; i < 14; i++) {
      arr.add(new ArrayList<>());
      for (int j = 0; j < 14; j++) {
        arr.get(i).add(new BoardSpot((int) Math.floor(Math.random() * 4 + 2)));
      }
    }
  }

  public void update(int x, int y, Card card, int player) {
    for (Coordinate coordinate : card.getCoordinates()) {
      arr.get(13 + coordinate.y - y).get(coordinate.x + x - 1).setControl(player);
    }
  }

  public void printDurability() {
    for (int i = 0; i < arr.size(); i++) {
      if (i > 4) {
        System.out.print(" ");
      }
      for (int j = 0; j < arr.get(0).size(); j++) {
        System.out.print(arr.get(i).get(j).getValue() + colorConversion.get(arr.get(i).get(j).getValue()));
        System.out.print("  ");
      }
      System.out.println("");
    }
  }

  public int calculateScore(int player) {

    int total = 0;

    for (int i = 0; i < arr.size(); i++) {
      for (int j = 0; j < arr.get(0).size(); j++) {
        if (arr.get(i).get(j).getPlayer() == player) {
          total += 1;
        }
      }
    }

    return total;
  }

  public void printOwnership() {
    for (int i = 0; i < arr.size(); i++) {
      for (int j = 0; j < arr.get(0).size(); j++) {
        int player = arr.get(i).get(j).getPlayer();
        switch (player) {
          case 0:
            System.out.print("\uD83D\uDD35");
            break;
          case 1:
            System.out.print("\uD83d\uDD34");
            break;
          case 2:
            System.out.print("\uD83D\uDD36");
            break;
        }
        System.out.print(" ");
      }
      System.out.println("");
    }
  }

  public void printOwnershipWithCoordinates() {
    for (int i = 0; i < arr.size(); i++) {
      System.out.print(String.format("%d:", 14 - i));
      if (i > 4) {
        System.out.print(" ");
      }
      for (int j = 0; j < arr.get(0).size(); j++) {
        int player = arr.get(i).get(j).getPlayer();
        switch (player) {
          case 0:
            System.out.print("\uD83D\uDD35");
            break;
          case 1:
            System.out.print("\uD83d\uDD34");
            break;
          case 2:
            System.out.print("\uD83D\uDD36");
            break;
        }
        System.out.print(" ");
      }
      System.out.println("");
    }
    System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12 13 14");
  }
}