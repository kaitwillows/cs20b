import java.util.*;

class Main {

  private static boolean undoMove = false;
  private static boolean moveLegal = false;
  private static char turn = 'w';
  private static char pieceTaken = ' ';

  public static void main(String[] args) {
    System.out.println("\033[H\033[2J");
    Scanner gameScanner = new Scanner(System.in);

    char[][] gameBoard = {
        { 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r' },
        { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
        { 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W' },
        { 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' },
    };

    // welcome/message
    System.out.print(
        "Hi welcome to the chess game, please select an option from the menu:\n  new game [1]\n  load existing game [2]\n  view extended rules [3]\n\n enter number: ");
    String rawBoard = "";
    char readChar = ' ';
    switch (gameScanner.next().charAt(0)) {
      case '1':
        Game defaultGame = new Game("initial");
        rawBoard = defaultGame.loadBoard();
        readChar = 0;
        for (int i = 0; i < 8; i++) {
          for (int j = 0; j < 8; j++) {
            gameBoard[i][j] = rawBoard.charAt(readChar);
            readChar++;
          }
        }
        break;
      case '2':
        System.out.print("Enter game name: ");
        String gameID = gameScanner.next();
        Game game = new Game(gameID);
        rawBoard = game.loadBoard();
        readChar = 0;
        for (int i = 0; i < 8; i++) {
          for (int j = 0; j < 8; j++) {
            gameBoard[i][j] = rawBoard.charAt(readChar);
            readChar++;
          }
        }
        break;
      case '3':
        System.out.println("\033[H\033[2J");
        System.out.println(
            "This program allows you to play chess with another person. To win, caputre the other player's king before they can capture yours.\n\nOn your move, enter the cordinates of your move, \nEx. if you wanted to move white's e pawn two squares up, you would type 'e2 e4'.\nDon't worry about memorizing the cordinates, as they will be displayed on the board.\n\nEn passant, castling, promotion, and game determiners like stalemate and checkmate are currently not avalable.\n\nEach piece is reperesented by a symbol that is the first letter of its name, Ex. queen = q.\nThe only exceptions are knights, which are reperesented by 'N' and 'n' to differentiate them from the kings and white pawns, which are reperesented by 'W' to better differentiate them from the black pawns.\nWhite pieces are capital letters while black pieces are lowercase letters\n\n Lastly you may type 'save' instead of entering a move to save your current game and resume it later.\nMake sure to name it something unique, as entering the same name twice (even if its someone else) will overwrite your game.\n\nHave fun!\n\n");
        System.exit(0);
    }
    

    boolean gameInProgress = true;

    String cancel = " ";
    printBoard(gameBoard, turn);
    Scanner scanner = new Scanner(System.in);
    while (gameInProgress) {

      // enter move
      System.out.print("\nenter move: ");
      String moveNote = scanner.nextLine();

      // if the user wants to save
      if (moveNote.compareTo("save") == 0) {
        System.out.println("\033[H\033[2J");
        System.out.print("enter game name: ");
        String saveID = scanner.nextLine();
        Game saveGame = new Game(saveID);
        saveGame.saveBoard(gameBoard, saveID);
        printBoard(gameBoard, turn);
        continue;
      }

      // move piece (changes user input to intager cords)
      int pieceX = noteToCord('x', moveNote); // lowercase = move from
      int pieceY = noteToCord('y', moveNote);
      int spaceX = noteToCord('X', moveNote); // move to
      int spaceY = noteToCord('Y', moveNote);

      movePiece(gameBoard, pieceX, pieceY, spaceX, spaceY); // ITS CHANGING THE BOTH ARRAYS WTH
                                                            // its a scoping issue with gameboard
                                                            // no its not you dumby idk why it's like that
                                                            // ITS BECAUSE OF ARRAYS WHY ARE THEY LIKE THAT AAAAAA
                                                            // it's okay i have a workaround

      if (moveLegal) { // move confirmation
        printBoard(gameBoard, turn);
        System.out.print("\npress enter to confirm move or enter 'x' to cancel :");
        cancel = scanner.nextLine();
        try {
          if (cancel.charAt(0) != ' ') { // cancelled
            undoMove = true;
            movePiece(gameBoard, spaceX, spaceY, pieceX, pieceY);
            printBoard(gameBoard, turn);
            undoMove = false;
          }
        } catch (Exception e) { // not cancelled
          if (turn == 'w') {
            turn = 'b';
          } else {
            turn = 'w';
          }
          printBoard(gameBoard, turn);
        }
      } else {
        printBoard(gameBoard, turn);
        System.out.print("\nillegal move (press enter)");
        scanner.nextLine();
        printBoard(gameBoard, turn);
      }

    }
    scanner.close();
  }

  // move piece
  static char[][] movePiece(char[][] board, int pieceX, int pieceY, int spaceX, int spaceY) {
    char piece = board[pieceX][pieceY];
    if (undoMove == true) { // undo move
      board[pieceX][pieceY] = pieceTaken;
      board[spaceX][spaceY] = piece;
      return board;
    }
    moveLegal = false;

    // piece rules (equal signs are used for headers)
    if ((pieceX == spaceX) && (pieceY == spaceY)) {
      // moveLegal = false;
    } else if (turn == 'w') { // ================================================================== // white
                              // pieces
      switch (piece) {
        case 'W': // ============================================================ white pawn
          if (pieceY == spaceY &&
              (pieceX - 1) == spaceX &&
              (board[spaceX][spaceY] == ' ')) {
            moveLegal = true; // move up once
          } else if (pieceY == spaceY &&
              pieceX == 6 &&
              spaceX == 4 &&
              (board[spaceX][spaceY] == ' ')) {
            moveLegal = true; // move up twice
          } else if (((int) board[spaceX][spaceY] > 96 && (int) board[spaceX][spaceY] < 123) &&
              (pieceX - 1) == spaceX &&
              (pieceY + 1 == spaceY || pieceY - 1 == spaceY)) {
            moveLegal = true; // attack!!!
          }
          break;
        case 'N': // ============================================================ white knight
          if (board[spaceX][spaceY] > 64 && board[spaceX][spaceY] < 91) { // cannot take white piece
            moveLegal = false;
          } else if (((pieceY == spaceY - 2) && ((pieceX == spaceX - 1) || (pieceX == spaceX + 1))) || // up
              ((pieceY == spaceY + 2) && ((pieceX == spaceX - 1) || (pieceX == spaceX + 1))) || // down
              ((pieceX == spaceX - 2) && ((pieceY == spaceY - 1) || (pieceY == spaceY + 1))) || // left
              ((pieceX == spaceX + 2) && ((pieceY == spaceY - 1) || (pieceY == spaceY + 1)))) { // right
            moveLegal = true;
          }
          break;
        case 'R': // ============================================================ white rook
          moveLegal = true;
          if (board[spaceX][spaceY] > 64 && board[spaceX][spaceY] < 91) {
            moveLegal = false;
          } else if (pieceY == spaceY) { // up/down
            if (pieceX > spaceX) { // up
              for (int i = pieceX; i > spaceX; i--) {
                if (board[i - 1][spaceY] != ' ') {

                  if (i - 1 == spaceX) { // last check
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }

                }
              }
            }
            if (pieceX < spaceX) { // down
              for (int i = pieceX; i < spaceX; i++) {
                if (board[i + 1][spaceY] != ' ') {
                  if (i + 1 == spaceX) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }
                }
              }
            }
          } else if (pieceX == spaceX) { // left/right
            if (pieceY > spaceY) { // left
              for (int i = pieceY; i > spaceY; i--) {
                if (board[spaceX][i - 1] != ' ') {
                  if (i - 1 == spaceY) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }
                }
              }
            }
            if (pieceY < spaceY) { // right
              for (int i = pieceY; i < spaceY; i++) {
                if (board[spaceX][i + 1] != ' ') {
                  if (i + 1 == spaceY) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }
                }
              }
            }
          } else {
            moveLegal = false;
          }
          break;
        case 'B': // ============================================================ white bishop
          if (board[spaceX][spaceY] > 64 && board[spaceX][spaceY] < 91) {
            moveLegal = false;
          } else if (pieceX > spaceX && pieceY > spaceY &&
              pieceX - spaceX == pieceY - spaceY) { // up left?, -x-y
            for (int i = 1; i <= (pieceX - spaceX); i++) {
              if (board[pieceX - i][pieceY - i] != ' ' && i != (pieceX - spaceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceX > spaceX && pieceY < spaceY &&
              pieceX - spaceX == spaceY - pieceY) { // up left?, -x+y
            for (int i = 1; i <= (pieceX - spaceX); i++) {
              if (board[pieceX - i][pieceY + i] != ' ' && i != (pieceX - spaceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceX < spaceX && pieceY < spaceY &&
              spaceX - pieceX == spaceY - pieceY) { // up left?, +x+y
            for (int i = 1; i <= (spaceX - pieceX); i++) {
              if (board[pieceX + i][pieceY + i] != ' ' && i != (spaceX - pieceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceX < spaceX && pieceY > spaceY &&
              spaceX - pieceX == pieceY - spaceY) { // up left?, +x-y
            for (int i = 1; i <= (spaceX - pieceX); i++) {
              if (board[pieceX + i][pieceY - i] != ' ' && i != (spaceX - pieceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          }
          break;
        case 'K': // ============================================================ white king
          if (board[spaceX][spaceY] > 64 && board[spaceX][spaceY] < 91) {
            moveLegal = false;
          } else if (((pieceY == spaceY - 1)
              && ((pieceX == spaceX - 1) || (pieceX == spaceX + 1) || (pieceX == spaceX))) || // up
              ((pieceY == spaceY + 1) && ((pieceX == spaceX - 1) || (pieceX == spaceX + 1) || (pieceX == spaceX))) || // down
              ((pieceX == spaceX - 1) && ((pieceY == spaceY - 1) || (pieceY == spaceY + 1) || (pieceY == spaceY))) || // left
              ((pieceX == spaceX + 1) && ((pieceY == spaceY - 1) || (pieceY == spaceY + 1) || (pieceY == spaceY)))) { // right
            moveLegal = true;
          }
          break;
        case 'Q': // ============================================================ white queen
          moveLegal = true;
          if (board[spaceX][spaceY] > 64 && board[spaceX][spaceY] < 91) { // diagonal moves
            moveLegal = false;
          } else if (pieceX > spaceX && pieceY > spaceY &&
              pieceX - spaceX == pieceY - spaceY) { // up left?, -x-y
            for (int i = 1; i <= (pieceX - spaceX); i++) {
              if (board[pieceX - i][pieceY - i] != ' ' && i != (pieceX - spaceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceX > spaceX && pieceY < spaceY &&
              pieceX - spaceX == spaceY - pieceY) { // up left?, -x+y
            for (int i = 1; i <= (pieceX - spaceX); i++) {
              if (board[pieceX - i][pieceY + i] != ' ' && i != (pieceX - spaceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceX < spaceX && pieceY < spaceY &&
              spaceX - pieceX == spaceY - pieceY) { // up left?, +x+y
            for (int i = 1; i <= (spaceX - pieceX); i++) {
              if (board[pieceX + i][pieceY + i] != ' ' && i != (spaceX - pieceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceX < spaceX && pieceY > spaceY &&
              spaceX - pieceX == pieceY - spaceY) { // up left?, +x-y
            for (int i = 1; i <= (spaceX - pieceX); i++) {
              if (board[pieceX + i][pieceY - i] != ' ' && i != (spaceX - pieceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceY == spaceY) { // up/down
            if (pieceX > spaceX) { // up
              for (int i = pieceX; i > spaceX; i--) {
                if (board[i - 1][spaceY] != ' ') {

                  if (i - 1 == spaceX) { // last check
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }

                }
              }
            }
            if (pieceX < spaceX) { // down
              for (int i = pieceX; i < spaceX; i++) {
                if (board[i + 1][spaceY] != ' ') {
                  if (i + 1 == spaceX) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }
                }
              }
            }
          } else if (pieceX == spaceX) { // left/right
            if (pieceY > spaceY) { // left
              for (int i = pieceY; i > spaceY; i--) {
                if (board[spaceX][i - 1] != ' ') {
                  if (i - 1 == spaceY) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }
                }
              }
            }
            if (pieceY < spaceY) { // right
              for (int i = pieceY; i < spaceY; i++) {
                if (board[spaceX][i + 1] != ' ') {
                  if (i + 1 == spaceY) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }
                }
              }
            }
          } else {
            moveLegal = false;
          }
          break;
      }
    } else if (turn == 'b') { // ================================================================== // black
                              // pieces
      switch (piece) {
        case 'p': // ============================================================ black pawn
          if (pieceY == spaceY &&
              (pieceX + 1) == spaceX &&
              (board[spaceX][spaceY] == ' ')) {
            moveLegal = true; // move up once
          } else if (pieceY == spaceY &&
              pieceX == 1 &&
              spaceX == 3 && // BROKEN
              (board[spaceX][spaceY] == ' ')) {
            moveLegal = true; // move up twice
          } else if (((int) board[spaceX][spaceY] > 96 && (int) board[spaceX][spaceY] < 123) &&
              (pieceX + 1) == spaceX &&
              (pieceY + 1 == spaceY || pieceY - 1 == spaceY)) {
            moveLegal = true; // attack!!!
          }
          break;
        case 'n': // ============================================================ black knight
          if (board[spaceX][spaceY] > 96 && board[spaceX][spaceY] < 123) { // cannot take black piece
            moveLegal = false;
          } else if (((pieceY == spaceY - 2) && ((pieceX == spaceX - 1) || (pieceX == spaceX + 1))) || // up
              ((pieceY == spaceY + 2) && ((pieceX == spaceX - 1) || (pieceX == spaceX + 1))) || // down
              ((pieceX == spaceX - 2) && ((pieceY == spaceY - 1) || (pieceY == spaceY + 1))) || // left
              ((pieceX == spaceX + 2) && ((pieceY == spaceY - 1) || (pieceY == spaceY + 1)))) { // right
            moveLegal = true;
          }
          break;
        case 'r': // ============================================================ black rook
          moveLegal = true;
          if (board[spaceX][spaceY] > 96 && board[spaceX][spaceY] < 123) {
            moveLegal = false;
          } else if (pieceY == spaceY) { // up/down
            if (pieceX > spaceX) { // up
              for (int i = pieceX; i > spaceX; i--) {
                if (board[i - 1][spaceY] != ' ') {

                  if (i - 1 == spaceX) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }

                }
              }
            }
            if (pieceX < spaceX) { // down
              for (int i = pieceX; i < spaceX; i++) {
                if (board[i + 1][spaceY] != ' ') {
                  if (i + 1 == spaceX) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }
                }
              }
            }
          } else if (pieceX == spaceX) { // left/right
            if (pieceY > spaceY) { // left
              for (int i = pieceY; i > spaceY; i--) {
                if (board[spaceX][i - 1] != ' ') {
                  if (i - 1 == spaceY) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }
                }
              }
            }
            if (pieceY < spaceY) { // right
              for (int i = pieceY; i < spaceY; i++) {
                if (board[spaceX][i + 1] != ' ') {
                  if (i + 1 == spaceY) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }
                }
              }
            }
          } else {
            moveLegal = false;
          }
          break;
        case 'k': // ============================================================ white king
          if (board[spaceX][spaceY] > 96 && board[spaceX][spaceY] < 123) {
            moveLegal = false;
          } else if (((pieceY == spaceY - 1)
              && ((pieceX == spaceX - 1) || (pieceX == spaceX + 1) || (pieceX == spaceX))) || // up
              ((pieceY == spaceY + 1) && ((pieceX == spaceX - 1) || (pieceX == spaceX + 1) || (pieceX == spaceX))) || // down
              ((pieceX == spaceX - 1) && ((pieceY == spaceY - 1) || (pieceY == spaceY + 1) || (pieceY == spaceY))) || // left
              ((pieceX == spaceX + 1) && ((pieceY == spaceY - 1) || (pieceY == spaceY + 1) || (pieceY == spaceY)))) { // right
            moveLegal = true;
          }
          break;
        case 'b': // ============================================================ white bishop
          if (board[spaceX][spaceY] > 96 && board[spaceX][spaceY] < 123) {
            moveLegal = false;
          } else if (pieceX > spaceX && pieceY > spaceY &&
              pieceX - spaceX == pieceY - spaceY) { // up left?, -x-y
            for (int i = 1; i <= (pieceX - spaceX); i++) {
              if (board[pieceX - i][pieceY - i] != ' ' && i != (pieceX - spaceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceX > spaceX && pieceY < spaceY &&
              pieceX - spaceX == spaceY - pieceY) { // up left?, -x+y
            for (int i = 1; i <= (pieceX - spaceX); i++) {
              if (board[pieceX - i][pieceY + i] != ' ' && i != (pieceX - spaceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceX < spaceX && pieceY < spaceY &&
              spaceX - pieceX == spaceY - pieceY) { // up left?, +x+y
            for (int i = 1; i <= (spaceX - pieceX); i++) {
              if (board[pieceX + i][pieceY + i] != ' ' && i != (spaceX - pieceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceX < spaceX && pieceY > spaceY &&
              spaceX - pieceX == pieceY - spaceY) { // up left?, +x-y
            for (int i = 1; i <= (spaceX - pieceX); i++) {
              if (board[pieceX + i][pieceY - i] != ' ' && i != (spaceX - pieceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          }
          break;
        case 'q': // ============================================================ white queen
          moveLegal = true;
          if (board[spaceX][spaceY] > 96 && board[spaceX][spaceY] < 123) { // diagonal moves
            moveLegal = false;
          } else if (pieceX > spaceX && pieceY > spaceY &&
              pieceX - spaceX == pieceY - spaceY) { // up left?, -x-y
            for (int i = 1; i <= (pieceX - spaceX); i++) {
              if (board[pieceX - i][pieceY - i] != ' ' && i != (pieceX - spaceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceX > spaceX && pieceY < spaceY &&
              pieceX - spaceX == spaceY - pieceY) { // up left?, -x+y
            for (int i = 1; i <= (pieceX - spaceX); i++) {
              if (board[pieceX - i][pieceY + i] != ' ' && i != (pieceX - spaceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceX < spaceX && pieceY < spaceY &&
              spaceX - pieceX == spaceY - pieceY) { // up left?, +x+y
            for (int i = 1; i <= (spaceX - pieceX); i++) {
              if (board[pieceX + i][pieceY + i] != ' ' && i != (spaceX - pieceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceX < spaceX && pieceY > spaceY &&
              spaceX - pieceX == pieceY - spaceY) { // up left?, +x-y
            for (int i = 1; i <= (spaceX - pieceX); i++) {
              if (board[pieceX + i][pieceY - i] != ' ' && i != (spaceX - pieceX)) {
                moveLegal = false;
                break;
              } else {
                moveLegal = true;
              }
            }
          } else if (pieceY == spaceY) { // up/down
            if (pieceX > spaceX) { // up
              for (int i = pieceX; i > spaceX; i--) {
                if (board[i - 1][spaceY] != ' ') {

                  if (i - 1 == spaceX) { // last check
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }

                }
              }
            }
            if (pieceX < spaceX) { // down
              for (int i = pieceX; i < spaceX; i++) {
                if (board[i + 1][spaceY] != ' ') {
                  if (i + 1 == spaceX) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }
                }
              }
            }
          } else if (pieceX == spaceX) { // left/right
            if (pieceY > spaceY) { // left
              for (int i = pieceY; i > spaceY; i--) {
                if (board[spaceX][i - 1] != ' ') {
                  if (i - 1 == spaceY) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }
                }
              }
            }
            if (pieceY < spaceY) { // right
              for (int i = pieceY; i < spaceY; i++) {
                if (board[spaceX][i + 1] != ' ') {
                  if (i + 1 == spaceY) {
                    moveLegal = true;
                  } else {
                    moveLegal = false;
                    break;
                  }
                }
              }
            }
          } else {
            moveLegal = false;
          }
          break;
      }
    }

    if (moveLegal) {
      pieceTaken = board[spaceX][spaceY];
      board[pieceX][pieceY] = ' ';
      board[spaceX][spaceY] = piece;
      return board;
    }
    return board;
  }

  // convert move notation to coordinate number
  static int noteToCord(char returnAxis, String moveNote) {
    int moveNum = 0;
    switch (returnAxis) {
      case 'y': // take the first letter and convert it to int
        moveNum = (int) (moveNote.charAt(0) - 97);
        break;
      case 'x':
        moveNum = (int) (moveNote.charAt(1) - 49);
        break;
      case 'Y': // take the first letter and convert it to int
        moveNum = (int) (moveNote.charAt(3) - 97);

        break;
      case 'X':
        moveNum = (int) (moveNote.charAt(4) - 49);
        break;
      default:
        return -1;
    }
    if (returnAxis == 'x' || returnAxis == 'X') { // this essentially "flips" the x axis as its printed top to bottom,
                                                  // opposite of the ranks
      moveNum = flipAxis(moveNum);
    }
    return moveNum;
  }

  // flip x axis
  static int flipAxis(int moveNum) {
    switch (moveNum) {
      case 0:
        moveNum = 7;
        break;
      case 1:
        moveNum = 6;
        break;
      case 2:
        moveNum = 5;
        break;
      case 3:
        moveNum = 4;
        break;
      case 4:
        moveNum = 3;
        break;
      case 5:
        moveNum = 2;
        break;
      case 6:
        moveNum = 1;
        break;
      case 7:
        moveNum = 0;
        break;
    }
    return moveNum;
  }

  // // print board (debugging version)
  // static void printBoard(char[][] board, char perspective) {
  // // System.out.println("\033[H\033[2J");
  // if (perspective == 'w') {
  // System.out.println(" WHITE to move:\n");
  // System.out.println(" 7 6 5 4 3 2 1 0");
  // for (int i = 0; i <= 7; i++) {
  // System.out.print(flipAxis(i) + " ");
  // for (int j = 0; j <= 7; j++) {
  // System.out.print("|" + (char) board[i][j]);
  // }
  // System.out.print("|\n");
  // }
  // } else if (perspective == 'b') {
  // System.out.println(" BLACK to move:\n");
  // System.out.println(" H G F E D C B A");
  // for (int i = 7; i >= 0; i--) {
  // System.out.print((i + 1) + " ");
  // for (int j = 7; j >= 0; j--) {
  // System.out.print("|" + (char) board[i][j]);
  // }
  // System.out.print("|\n");
  // }
  // }
  // }
  // }

  // // print board
  static void printBoard(char[][] board, char perspective) {
    System.out.println("\033[H\033[2J");
    if (perspective == 'w') {
      System.out.println(" WHITE to move:\n");
      System.out.println("   A B C D E F G H");
      for (int i = 0; i <= 7; i++) {
        System.out.print((flipAxis(i) + 1) + " ");
        for (int j = 0; j <= 7; j++) {
          System.out.print("|" + (char) board[i][j]);
        }
        System.out.print("|\n");
      }
    } else if (perspective == 'b') {
      System.out.println(" BLACK to move:\n");
      System.out.println("   H G F E D C B A");
      for (int i = 7; i >= 0; i--) {
        System.out.print((flipAxis(i) + 1) + " ");
        for (int j = 7; j >= 0; j--) {
          System.out.print("|" + (char) board[i][j]);
        }
        System.out.print("|\n");
      }
    }
  }

  // test for win
  static void testForWin(char[][] board) {
    boolean whiteWin = true;
    boolean blackWin = true;
    for (char[] i : board) {
      for (char j : i) {
        if (j == 'K') {
          blackWin = false;
        }
        if (j == 'k') {
          whiteWin = false;
        }
      }
    }
    if (whiteWin == true) {
      // System.out.println("\033[H\033[2J");
      System.out.println("\nBlack's king has been captured, white wins!\n");
      System.exit(0);
    }
    if (blackWin == true) {
      // System.out.println("\033[H\033[2J");
      System.out.println("\nWhite's king has been captured, black wins!\n");
      System.exit(0);
    }
  }
}
