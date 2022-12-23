import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    // variable and object initialization
    Board gameObj = new Board(true);
    Scanner stringScanner = new Scanner(System.in);
    boolean isWhite = true;
    int row1;
    int col1;
    int row2;
    int col2;

    // clear screen
    System.out.print("\033[H\033[2J\n");
    System.out.println("        CCCCCCCCCCCCCHHHHHHHHH     HHHHHHHHHEEEEEEEEEEEEEEEEEEEEEE   SSSSSSSSSSSSSSS    SSSSSSSSSSSSSSS \n     CCC::::::::::::CH:::::::H     H:::::::HE::::::::::::::::::::E SS:::::::::::::::S SS:::::::::::::::S\n   CC:::::::::::::::CH:::::::H     H:::::::HE::::::::::::::::::::ES:::::SSSSSS::::::SS:::::SSSSSS::::::S\n  C:::::CCCCCCCC::::CHH::::::H     H::::::HHEE::::::EEEEEEEEE::::ES:::::S     SSSSSSSS:::::S     SSSSSSS\n C:::::C       CCCCCC  H:::::H     H:::::H    E:::::E       EEEEEES:::::S            S:::::S            \nC:::::C                H:::::H     H:::::H    E:::::E             S:::::S            S:::::S            \nC:::::C                H::::::HHHHH::::::H    E::::::EEEEEEEEEE    S::::SSSS          S::::SSSS         \nC:::::C                H:::::::::::::::::H    E:::::::::::::::E     SS::::::SSSSS      SS::::::SSSSS    \nC:::::C                H:::::::::::::::::H    E:::::::::::::::E       SSS::::::::SS      SSS::::::::SS  \nC:::::C                H::::::HHHHH::::::H    E::::::EEEEEEEEEE          SSSSSS::::S        SSSSSS::::S \nC:::::C                H:::::H     H:::::H    E:::::E                         S:::::S            S:::::S\n C:::::C       CCCCCC  H:::::H     H:::::H    E:::::E       EEEEEE            S:::::S            S:::::S\n  C:::::CCCCCCCC::::CHH::::::H     H::::::HHEE::::::EEEEEEEE:::::ESSSSSSS     S:::::SSSSSSSS     S:::::S\n   CC:::::::::::::::CH:::::::H     H:::::::HE::::::::::::::::::::ES::::::SSSSSS:::::SS::::::SSSSSS:::::S\n     CCC::::::::::::CH:::::::H     H:::::::HE::::::::::::::::::::ES:::::::::::::::SS S:::::::::::::::SS \n        CCCCCCCCCCCCCHHHHHHHHH     HHHHHHHHHEEEEEEEEEEEEEEEEEEEEEE SSSSSSSSSSSSSSS    SSSSSSSSSSSSSSS");
    try {
      System.out.print("\n\n                                               press enter...");
      stringScanner.nextLine();
    } catch (Exception e) {
      
    }
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
        System.out.println("The entered move (" + moveString + ") is not a valid move. Please enter a move like \"g1 f3\".");
        continue; // restart the loop
      }

      try {
        gameObj.move(row1, col1, row2, col2);
      } catch (IllegalMoveException e) {
        System.out.print("\033[H\033[2J");
        System.out.println("That move (" + moveString + ") is illegal, please enter a legal move");
        continue;
      } catch (NullPointerException e) {
        System.out.print("\033[H\033[2J");
        System.out.println("That move (" + moveString + ") is illegal, please enter a legal move");
      }

      System.out.print("\033[H\033[2J\n");
      isWhite = !isWhite;

      if (gameObj.gameWon) {
        stringScanner.close();
        break;
      }
    }

    // stringScanner.close();
  }
}
