class Knight extends Piece {
  boolean isWhite;
  char pieceChar;



  public Knight(boolean isWhite) {
    this.isWhite = isWhite;
    if (isWhite) {
      pieceChar = 'N';
    } else {
      pieceChar = 'n';
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
