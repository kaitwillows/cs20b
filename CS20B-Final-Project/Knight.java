class Knight extends Piece {

  // variable initialization
  boolean isWhite;
  char pieceChar;

  // constructor
  public Knight(boolean isWhite) {
    this.isWhite = isWhite;
    if (isWhite) {
      pieceChar = 'N';
    } else {
      pieceChar = 'n';
    }
  }

  // check if the move is legal
  // if not, throw the exception to the Board object
  void moveCheck(Piece[][] board, int row1, int col1, int row2, int col2) throws IllegalArgumentException { 
    int moveStatus = MoveCheckUtil.knight(board, row1, col1, row2, col2);
    if (moveStatus == -1) {
      KingAttackedException e = new KingAttackedException("piece is attacking the king");
      throw e;
    } else if (moveStatus == 0) {
      IllegalMoveException e = new IllegalMoveException("this move is illegal");
      throw e;
    }
  }

  // get...() methods allow variables from different subclasses of Piece to be accessed from a Piece[] board (array)
  char getPieceChar() {
    return pieceChar;
  }
  boolean getIsWhite() {
    return isWhite;
  }

}