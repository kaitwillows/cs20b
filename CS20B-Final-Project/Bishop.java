class Bishop extends Piece {
  boolean isWhite;
  char pieceChar;



  public Bishop(boolean isWhite) {
    this.isWhite = isWhite;
    if (isWhite) {
      pieceChar = 'B';
    } else {
      pieceChar = 'b';
    }
  }

  void moveCheck() {
    if (isWhite) { // the piece is white
      
    } else { // the piece is black

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
