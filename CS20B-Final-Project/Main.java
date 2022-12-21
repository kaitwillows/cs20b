import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // System.out.println("how does print work");
    // GUI.main(null);


    Board gameObj = new Board(true);
    Scanner stringScanner = new Scanner(System.in);
    boolean isWhite = true;
    int row1;
    int col1;
    int row2;
    int col2;

    System.out.print("\033[H\033[2J\n");

    while (true) {
      System.out.print("\n");
      if (isWhite) {
        System.out.print("White ");
      } else {
        System.out.print("Black ");
      }
      System.out.println("to move...");
      gameObj.printBoard(isWhite);
      
      System.out.print("\nenter move: ");
      String moveString = stringScanner.nextLine();

      try {
        row1 = MoveCheckUtil.parseNotation(2, moveString);
        col1 = MoveCheckUtil.parseNotation(1, moveString);
        row2 = MoveCheckUtil.parseNotation(4, moveString);
        col2 = MoveCheckUtil.parseNotation(3, moveString);
      } catch (Exception e) {
        System.out.print("\033[H\033[2J");
        System.out.println("The entered move is not valid, please enter a move like \"g1 f3\".");
        continue; // restart the loop
      }

      try {
        gameObj.move(row1, col1, row2, col2);
      } catch (IllegalMoveException e) {
        System.out.print("\033[H\033[2J");
        System.out.println("That move is illegal, please enter a legal move");
        continue;
      }

      System.out.print("\033[H\033[2J\n");
      isWhite = !isWhite;
    }
  }
}
