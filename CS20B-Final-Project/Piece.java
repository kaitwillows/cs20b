
interface Piece {
  // pieces should also include variables:
  // int x (position)
  // int y (position)
  // boolean piece side (should be able to be accessed by other pieces)
  boolean kingCheck();
  boolean moveCheck();
  void movePiece();
}

