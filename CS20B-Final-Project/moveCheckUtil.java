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
  static int linear(Piece[][] board, int row1, int col1, int direction, int spaces) {
    // get side variable
    boolean isWhite = board[row1][col1].getIsWhite();
    // TODO: add code to determine what direction and how many spaces to move
    // find the direction
    
      // for straights, if any cords are equal, find the difference; (direction and spaces)
      // for diagonals, if the diff from start to end is equal for both cords, find which is greater for each
    switch (direction) {
      case 8: // up, y is variable
        for (int i = row1; i > row1 - spaces; i--) {
          if (i == row1) { // if we haven't moved, move ahead
            continue;
          }
          else if (!(board[i][col1] instanceof Piece)) { // this space is empty, move ahead
            continue;
          } 
          else if (board[i][col1].getIsWhite() == isWhite) { // if this space is an ally, break
            return 0; // illegal
          }
          if (board[i][col1].getPieceChar() == 'K' || board[i][col1].getPieceChar() == 'k') { // if this piece is the enemy king
            return -1; // the king is in check
          }
          else if (i-1 == row1 - spaces) { // the piece is trying to move past an enemy piece
            return 0; // illegal;
          }
        }
        return 1; // the move is legal
        
    }


    return 0;
  }
}

/*
00 01 02 03 04 05 06 07 
10 11 12 13 14 15 16 17
20 21 22 23 24 25 26 27
30 31 32 33 34 35 36 37 -- break here
40 41 42 43 44 45 46 47
50 51 52 53 54 55 56 57
60 61 62 63 64 65 66 67 -- start
70 71 72 73 74 75 76 77
*/