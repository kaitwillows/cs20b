
interface Piece {
  // pieces should also include variables:
  // boolean piece side (should be able to be accessed by other pieces)
  // char piece - something to print or be able to test for when looking at a square maybe idk maybe not
  // boolean kingCheck(); this should be commented out until its implemented
  boolean moveCheck();
  // void movePiece(); this will have to happen in Board, where the board array is stored
}

