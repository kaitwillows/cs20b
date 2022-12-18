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
      IllegalArgumentException k = new IllegalArgumentException("piece is attacking the king");
      throw k;
    } else if (linearStatus == 0) {
      IllegalArgumentException i = new IllegalArgumentException("this move is illegal");
      throw i;
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
