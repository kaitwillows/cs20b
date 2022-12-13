// Board is responcible for the creation and modification of the game

import java.util.ArrayList;

class Board {
  
  ArrayList<ArrayList> board = new ArrayList<ArrayList>();

  final String DEFAULT_BOARD = "rnbqkbnrpppppppp                                PPPPPPPPRNBQKBNR";


  public Board(boolean useDefaultBoard) {
    if (useDefaultBoard) {
      initilizeBoard(DEFAULT_BOARD);
    }
  }

  void initilizeBoard(String boardString) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        System.out.print(boardString.charAt(8*i+j));

        // TODO: when all piece class exist, create a switch statement that adds an instance of each piece to the board arraylist
      }
    }
  }
  
  public static void main(String[] args) {
    Board board = new Board(true);
  }
}

// this class will initilize the board by creating all the neccisary piece objects in an array list (which is capable of holding objects within itself)
// based off of the characters in the input board
//
