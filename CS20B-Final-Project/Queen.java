class Queen extends Piece {
  boolean isWhite;
  char pieceChar;



  public Queen(boolean isWhite) {
    this.isWhite = isWhite;
    if (isWhite) {
      pieceChar = 'Q';
    } else {
      pieceChar = 'q';
    }
  }

  void moveCheck(Piece[][] board, int row1, int col1, int row2, int col2) throws IllegalArgumentException { 
    int linearStatus = MoveCheckUtil.linear(board, row1, col1, row2, col2);
    if (linearStatus == -1) {
      KingAttackedException e = new KingAttackedException("piece is attacking the king");
      throw e;
    } else if (linearStatus == 0) {
      IllegalMoveException e = new IllegalMoveException("this move is illegal");
      throw e;
    }
  }

  // appear in piece.java
  char getPieceChar() {
    return pieceChar;
  }
  boolean getIsWhite() {
    return isWhite;
  }

}

// sidewhite
//
