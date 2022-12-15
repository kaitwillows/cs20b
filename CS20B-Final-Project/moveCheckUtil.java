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
  static int linear(Piece[][] board, int col, int row, int direction, int spaces, boolean isWhite) {
    System.out.println("piece chosen is a " + board[row][col].getPieceChar());
    // TODO
    switch (direction) {
      case 8: // up, y is variable
        for (int i = row; i < spaces + row; i--) {
          if (i == row) { // if we haven't moved, move ahead
            continue;
          }
          else if (!(board[i][col] instanceof Piece)) { // this space is empty, move ahead
            continue;
          } 
          else if (board[i][col].getIsWhite() == isWhite) { // if this piece is an ally, break
            return 0; // illegal
          }
          if (board[i][col].getPieceChar() == 'K' || board[i][col].getPieceChar() == 'k') { // if this piece is the enemy king
            return -1; // the king is in check
          }
          else { // the current piece is an enemy
            System.out.println("ayo dont skip me hello??");
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
30 31 32 33 34 35 36 37
40 41 42 43 44 45 46 47
50 51 52 53 54 55 56 57
60 61 62 63 64 65 66 67
70 71 72 73 74 75 76 77
*/