// Board is responsible for the creation and modification of the game

// import java.util.ArrayList;

class Board {
  
  // ArrayList<ArrayList<Piece>> board = new ArrayList<ArrayList<Piece>>();
  Piece[][] board = new Piece[8][8];

  final String DEFAULT_BOARD = "rnbqkbnrpppppppp                                PPPPPPPPRNBQKBNR";
    //  final String DEFAULT_BOARD = "                            Q                                    ";



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

  void printBoard(boolean fromWhite) {
    if (fromWhite) {
      System.out.println("   A B C D E F G H");
      for (int i = 0; i <= 7; i++) {
        System.out.print((8 - i) + " ");
        for (int j = 0; j <= 7; j++) {
          try {
            System.out.print("|" + board[i][j].getPieceChar());
          }
          catch(NullPointerException e) { // for the blank spaces
            System.out.print("| ");
          }
        }
        System.out.print("|\n");
      }
    } else {
      System.out.println("   H G F E D C B A");
      for (int i = 7; i >= 0; i--) {
        System.out.print((8 - i) + " ");
        for (int j = 7; j >= 0; j--) {
          try {
            System.out.print("|" + board[i][j].getPieceChar());
          }
          catch(NullPointerException e) { // for the blank spaces
            System.out.print("| ");
          }
        }
        System.out.print("|\n");
      } 
    }
  }
  
  void move(int row1, int col1, int row2, int col2) { // im so tired rn
    // check if the move can be made
    try {
      // the following line will throw an exception to main if the move is illegal or the king is in check, terminating the rest of the code
      board[row1][col1].moveCheck(board, row1, col1, row2, col2);
      board[row1][col1] = board[row1][col1];
      board[row1][col1] = null;
    } catch (IllegalMoveException e) {
      throw e;
    } catch (KingAttackedException e) {
      throw e;
    }
  }

  void testMove() { // for testing; this needs a WAY better implementation
    int r1 = 3;
    int c1 = 4;
    int r2 = 5;
    int c2 = 4;
    if (MoveCheckUtil.linear(board, r1, c1, r2, c2) == 1) { // piece at 4, 6, move up(8) 1 time(s)
      System.out.println("great success");
      board[r2][c2] = board[r1][c1];
      board[r1][c1] = null;
    } else {
      System.out.println("great un-success");
    }
  }
}

/*
00 01 02 03 04 05 06 07 
10 11 12 13 14 15 16 17
20 21 22 23 24 25 26 27
30 31 32 33*34*35 36 37
40 41 42 43 44 45 46 47
50 51 52 53 54 55 56 57
60 61 62 63 64 65*66*67
70 71 72 73 74 75 76 77
*/
