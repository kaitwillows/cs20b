
class Piece {

  char pieceChar;
  boolean isWhite;

  void moveCheck(Piece[][] board, int row1, int col1, int row2, int col2) throws IllegalArgumentException { 
    
  }
  char getPieceChar() {
    return this.pieceChar;
  }
  boolean getIsWhite() {
    return this.isWhite;
  }
  
  // pieces should also include variables:
  // boolean piece side (should be able to be accessed by other pieces)
  // char piece - something to print or be able to test for when looking at a square maybe idk maybe not
  // boolean kingCheck(); this should be commented out until its implemented
  // boolean moveCheck(); what even is the point of interfaces
  // void movePiece(); this will have to happen in Board, where the board array is stored
  // oo unless if its just a regular class, then it can be used as the subclass type declaration for the array (for multiple subclass dummy)
}

