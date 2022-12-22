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
