class Main {
  public static void main(String[] args) {
    // System.out.println("how does print work");
    // GUI.main(null);
    Board gameObj = new Board(true);
    gameObj.printBoard(true);
    System.out.println("");
    gameObj.printBoard(false);

  }
}
