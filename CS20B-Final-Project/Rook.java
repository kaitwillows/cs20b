class Rook extends Piece {
  boolean isWhite;
  char pieceChar;



  public Rook(boolean isWhite) {
    this.isWhite = isWhite;
    if (isWhite) {
      pieceChar = 'R';
    } else {
      pieceChar = 'r';
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
