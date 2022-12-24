// Board is responsible for the creation and modification of the game

// import java.util.ArrayList;

class Board {

  // variable initialization 
  final String DEFAULT_BOARD = "rnbqkbnrpppppppp                                PPPPPPPPRNBQKBNR";
  Piece[][] board = new Piece[8][8];
  boolean gameWon = false;


  // constructor
  public Board(boolean useDefaultBoard) {
    if (useDefaultBoard) {
      initilizeBoard(DEFAULT_BOARD);
    }
  }

  // initialize a piece object for every piece that appears on the board
  void initilizeBoard(String boardString) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        char pieceChar = boardString.charAt(8*i+j);
        switch (pieceChar) { // initilize a...
          case 'P': // pawn
            board[i][j] = new Pawn(true);
            break;
          case 'p':
            board[i][j] = new Pawn(false);
            break;
          case 'R': // rook
            board[i][j] = new Rook(true);
            break;
          case 'r':
            board[i][j] = new Rook(false);
            break;
          case 'N': // knight
            board[i][j] = new Knight(true);
            break;
          case 'n':
            board[i][j] = new Knight(false);
            break;
          case 'B': // bishop
            board[i][j] = new Bishop(true);
            break;
          case 'b':
            board[i][j] = new Bishop(false);
            break;
          case 'Q': // queen
            board[i][j] = new Queen(true);
            break;
          case 'q':
            board[i][j] = new Queen(false);
            break;
          case 'K': // king
            board[i][j] = new King(true);
            break;
          case 'k':
            board[i][j] = new King(false);
            break;
        }
      }
    }
  }

  void printChar(int i, int j, boolean withIcons) {
    if (withIcons) {
      if (Math.abs((1+i) - (1+j)) % 2 == 0) {
        System.out.print("\u001B[47m"); // light square
      } else {
        System.out.print("\u001B[100m"); // dark square
      }
      try {
      switch (board[i][j].getPieceChar()) {
        case 'K':
          System.out.print("♔ ");
          break;
        case 'Q':
          System.out.print("♕ ");
          break;
        case 'R':
          System.out.print("♖ ");
          break;
        case 'B':
          System.out.print("♗ ");
          break;
        case 'N':
          System.out.print("♘ ");
          break;
        case 'P':
          System.out.print("♙ ");
          break;
        case 'k':
          System.out.print("♚ ");
          break;
        case 'q':
          System.out.print("♛ ");
          break;
        case 'r':
          System.out.print("♜ ");
          break;
        case 'b':
          System.out.print("♝ ");
          break;
        case 'n':
          System.out.print("♞ ");
          break;
        case 'p':
          System.out.print("♟︎ ");
          break;
        default:
          System.out.print("");
          break;
      }
    } catch (Exception e) {
      System.out.print("  ");
    } finally {
      System.out.print("\u001b[0m"); // reset colour
    }

    } else {
      if (Math.abs((1+i) - (1+j)) % 2 == 0) {
        System.out.print("\u001B[47m"); // light square
      } else {
        System.out.print("\u001B[100m"); // dark square
      }
      try {
        if (board[i][j].getIsWhite()) {
          System.out.print("\u001B[37mW");
        } else {
          System.out.print("\u001B[30mb");
        }
        System.out.print(board[i][j].getPieceChar());
      } catch (Exception e) {
        System.out.print("  ");
      } finally {
        System.out.print("\u001b[0m"); // reset colour
      }
    }
  }
  // print the board to the terminal with appropriate formatting
  void printBoard(boolean fromWhite, boolean withIcons) {
    if (fromWhite) { // print the board from white's perspective
      System.out.println("   A  B  C  D  E  F  G  H");
      for (int i = 0; i <= 7; i++) {
        System.out.print((8 - i) + " ");
        for (int j = 0; j <= 7; j++) {
          try {
            System.out.print("|");
            printChar(i, j, withIcons);
          }
          catch(NullPointerException e) { // for the blank spaces
            System.out.print(" ");
          }
        }
        System.out.print("|\n");
      }
    } else { // print the board from black's perspective
      System.out.println("   H  G  F  E  D  C  B  A");
      for (int i = 7; i >= 0; i--) {
        System.out.print((8 - i) + " ");
        for (int j = 7; j >= 0; j--) {
          try {
            System.out.print("|");
            printChar(i, j, withIcons);
          }
          catch(NullPointerException e) { // for the blank spaces
            System.out.print("| ");
          }
        }
        System.out.print("|\n");
      } 
    }
  }
  
  // check if a move is legal, then make the move. 
  // if the move is illegal, throw the exception to Main
  void move(int row1, int col1, int row2, int col2) {
    if (board[row1][col1].getIsWhite() != Main.isWhite) {
      IllegalMoveException e = new IllegalMoveException("trying to move opponents piece");
      throw e;
    }
    try {
      board[row1][col1].moveCheck(board, row1, col1, row2, col2); // check for legality
      board[row2][col2] = board[row1][col1]; // if there's no exception, move the piece
      board[row1][col1] = null;
    } catch (IllegalMoveException e) {
      throw e;
    } catch (KingAttackedException e) {
      throw e;
    }
  }
}