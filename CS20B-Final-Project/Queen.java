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
