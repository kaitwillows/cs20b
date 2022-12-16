// Board is responsible for the creation and modification of the game

// import java.util.ArrayList;

class Board {
  
  // ArrayList<ArrayList<Piece>> board = new ArrayList<ArrayList<Piece>>();
  Piece[][] board = new Piece[8][8];

  // final String DEFAULT_BOARD = "rnbqkbnrpppppppp                                PPPPPPPPRNBQKBNR";
  final String DEFAULT_BOARD = "rnbqkbnrpppppppp            q                       Q           ";



  public Board(boolean useDefaultBoard) {
    if (useDefaultBoard) {
      initilizeBoard(DEFAULT_BOARD);
    }
  }

  void initilizeBoard(String boardString) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        char pieceChar = boardString.charAt(8*i+j);

        // System.out.print(i + " " + j + "\n ");

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

  void printBoard() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        try {
          System.out.print(board[i][j].getPieceChar());
        }
        catch(NullPointerException e) { // for the blank spaces probably
          System.out.print(" ");
        }
      }
      System.out.print("\n");
    }
  }
  
  void testMove() { // for testing; this needs a better implementation
    int r1 = 6;
    int c1 = 4;
    int r2 = 2;
    int c2 = 4;
    if (MoveCheckUtil.linear(board, r1, c1, r2, c2) == 1) { // piece at 4, 6, move up(8) 1 time(s)
      board[r2][c2] = board[r1][c1];
      board[r1][c1] = null;
    }
  }
}

// this class will initilize the board by creating all the neccisary piece objects in an array list (which is capable of holding objects within itself)
// based off of the characters in the input board
//
