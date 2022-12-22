class King extends Piece {
  boolean isWhite;
  char pieceChar;
  boolean hasMoved = false; // for castleing



  public King(boolean isWhite) {
    this.isWhite = isWhite;
    if (isWhite) {
      pieceChar = 'K';
    } else {
      pieceChar = 'k';
    }
  }

  void moveCheck(Piece[][] board, int row1, int col1, int row2, int col2) {
    int moveStatus = MoveCheckUtil.king(board, row1, col1, row2, col2);
    if (moveStatus == -1) {
      KingAttackedException e = new KingAttackedException("piece is attacking the king");
      throw e;
    } else if (moveStatus == 0) {
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
  boolean getHasMoved() {
    return hasMoved;
  }

}

// sidewhite
//
