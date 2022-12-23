// these classes allow additional exceptions exclusive to chess situations be thrown and distinguished from each other.

// the king is trying to be attacked.
// the current implementation of this project does not allow for king check checks.
// one possible way of implementing check, would be to check every possible move on the board, 
// then catch this exception, and tell the user they are in check.
class KingAttackedException extends RuntimeException {
  public KingAttackedException(String errorMessage) {
    super(errorMessage);
  }
}

class IllegalMoveException extends RuntimeException {
  public IllegalMoveException(String errorMessage) {
    super(errorMessage);
  }
}

