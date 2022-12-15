// this class will help with the checks needed to test for legal moves

/* int direction works like this:

7 8 9
4 5 6
1 2 3

it mimicks the numberpad on a standard keyboard
5 should never be used
*/

public class moveCheckUtil {
  // linear will return 0 if:
  // a piece has been "stepped over" or
  // the piece landed on is an ally
  // canTake -1 = cannot, 0 = black, 1 = white
  static int linear(Piece[][] board, int xCord, int yCord, int direction, int spaces, boolean isWhite) {
    // TODO
    switch (direction) {
      case 8: // up, y is variable
        for (int i = 0; i < spaces; i++) {
          if (!(board[i+1][xCord] instanceof Piece)) { // if the space in front is empty, move ahead
            continue;
          } 
          else if (board[i+1][xCord].getIsWhite() == isWhite) { // if the piece ahead is/isnt an ally
            
          }
        }
        
    }

    System.out.println(board[0][0].getPieceChar());
    return 0;
  }
}

/*
00 01 02 03 04 05 06 07 
10 11 12 13 14 15 16 17
20 21 22 23 24 25 26 27
30 31 32 33 34 35 36 37
40 41 42 43 44 45 46 47
50 51 52 53 54 55 56 57
60 61 62 63 64 65 66 67
70 71 72 73 74 75 76 77
*/