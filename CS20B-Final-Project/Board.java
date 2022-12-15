// Board is responsible for the creation and modification of the game

// import java.util.ArrayList;

class Board {
  
  // ArrayList<ArrayList<Piece>> board = new ArrayList<ArrayList<Piece>>();
  Piece[][] board = new Piece[7][7];

  final String DEFAULT_BOARD = "rnbqkbnrpppppppp                                PPPPPPPPRNBQKBNR";


  public Board(boolean useDefaultBoard) {
    if (useDefaultBoard) {
      initilizeBoard(DEFAULT_BOARD);
    }
  }

  void initilizeBoard(String boardString) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        char pieceChar = boardString.charAt(8*i+j);
        switch (pieceChar) { // initilize a...
          case 'P': // white pawn
            board[i][j] = new Pawn(true);
            break;
        }
        
      }
    }
  }
  
  public static void main(String[] args) { // for testing
    Board board = new Board(true);
  }
}

// this class will initilize the board by creating all the neccisary piece objects in an array list (which is capable of holding objects within itself)
// based off of the characters in the input board
//
