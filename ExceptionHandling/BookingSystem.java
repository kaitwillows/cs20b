import java.util.Scanner;

public class BookingSystem {
  public static void main(String[] args) {
    System.out.print("\033[H\033[2J\n\n");
    Scanner strScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);
    // initialize arrays
    int[][] leftSection = new int[8][4];
    int[][] rightSection = new int[8][4];
    int[][] middleSection = new int[8][20];
    int[][] backSection = new int[2][31];

    // populate arrays with random seats

    prePopulate(leftSection, 25);
    prePopulate(rightSection, 25);
    prePopulate(middleSection, 65); // demand is % how full the section will be
    prePopulate(backSection, 30);

    // System.out.print("\033[H\033[2J\n");
    printTheater(leftSection, rightSection, middleSection, backSection);
    // printSection(backSection);

    System.out.print("How many friends do you think you have: ");
    int friends = intScanner.nextInt();

    for (int i = 0; i <= friends;) { // killing off the friends one by one

      System.out.print("\033[H\033[2J\n"); // clearscreen
      System.out.println("Booking seat " + (i + 1) + " of " + (friends + 1) + "...");
      printTheater(leftSection, rightSection, middleSection, backSection);

      System.out.print("What section would you like to view? (enter m, l, r, or b for middle left right or back): ");
      char section = strScanner.next().charAt(0);

      System.out.print("\033[H\033[2J\n\n\n"); // clearscreen
      while (true) {

        switch (section) {
          case 'M':
          case 'm':
            printSection(middleSection);
            break;
          case 'L':
          case 'l':
            printSection(leftSection);
            break;
          case 'R':
          case 'r':
            printSection(rightSection);
            break;
          case 'B':
          case 'b':
            printSection(backSection);
            break;
          default:
            i--;
        }
        try {
          // book from section
          switch (section) {
            case 'M':
            case 'm':
              bookSeat(middleSection);
              break;
            case 'L':
            case 'l':
              bookSeat(leftSection);
              break;
            case 'R':
            case 'r':
              bookSeat(rightSection);
              break;
            case 'B':
            case 'b':
              bookSeat(backSection);
              break;

          }

          i++; // take a friend off lol
          break;
        } catch (IllegalArgumentException occupiedMsg) {
          System.out.print("\033[H\033[2J\n"); // clearscreen
          System.out.println("That seat is taken, please choose another.\n");
        }
      }
    }
    System.out.print("\033[H\033[2J"); // clearscreen
    System.out.print("All seats have been booked successfully.\n\n");
    printTheater(leftSection, rightSection, middleSection, backSection);

  }

  static void bookSeat(int[][] section) throws IllegalArgumentException, IndexOutOfBoundsException {
    Scanner intScanner = new Scanner(System.in);
    Scanner strScanner = new Scanner(System.in);
    System.out.print("\u001B[37m");
    System.out.print("\nenter row letter: ");
    int row = strScanner.next().charAt(0) - 97;
    System.out.print("enter column number: ");
    int col = intScanner.nextInt() - 1;
    // intScanner.close();

    if (section[row][col] == 1) { // seat taken
      String occupiedMsg = "Seat is occupied.";
      IllegalArgumentException occupiedException = new IllegalArgumentException(occupiedMsg);
      throw occupiedException;
    }
    section[row][col] = 1;
    System.out.println("Seat booked successfully.");
  }

  // prepopulate seats by section, demand determines how full that section will be
  static void prePopulate(int[][] section, int demand) {
    for (int i = 0; i < section.length; i++) {
      for (int j = 0; j < section[0].length; j++) {
        int taken = (int) Math.floor(Math.random() * 101);
        if (taken <= demand) {
          section[i][j] = 1;
        }
        // System.out.println(taken);
        // System.out.println(Math.random() * demand);
      }
    }

  }

  static void printTheater(int[][] leftSection, int[][] rightSection, int[][] middleSection, int[][] backSection) {
    System.out.print("                          [screen]\n\n");

    // first 8 rows (mid+sides)
    for (int i = 0; i < middleSection.length; i++) {
      // left
      for (int j = 0; j < leftSection[0].length; j++) {
        printSeat(leftSection[i][j]);
        System.out.print(" ");
      }
      System.out.print("   ");
      // middle
      for (int j = 0; j < middleSection[0].length; j++) {
        printSeat(middleSection[i][j]);
        System.out.print(" ");
      }
      System.out.print("   ");
      // right
      for (int j = 0; j < rightSection[0].length; j++) {
        printSeat(rightSection[i][j]);
        System.out.print(" ");
      }
      System.out.print("\n");
    }
    System.out.print("\n");
    // back
    for (int i = 0; i < backSection.length; i++) {
      for (int j = 0; j < backSection[0].length; j++) {
        printSeat(backSection[i][j]);
        System.out.print(" ");
      }
      System.out.print("\n");
    }
    System.out.print("\n");
    System.out.print("\u001B[37m");
  }

  // printSection for "zooming" in to section and booking it and stuff
  static void printSection(int[][] section) {
    // System.out.print("\033[H\033[2J");
    System.out.print("   ");
    for (int i = 0; i < section[0].length; i++) {
      if (i < 9) {
        System.out.print((i + 1) + "  ");
      } else {
        System.out.print((i + 1) + " ");
      }

    }
    System.out.print("\n");

    for (int i = 0; i < section.length; i++) {
      System.out.print("\u001B[37m" + (char) (i + 65) + "  "); // row numbers
      for (int j = 0; j < section[0].length; j++) {
        printSeat(section[i][j]);
        System.out.print("  ");
      }
      System.out.print("\n");
    }
  }

  static void printSeat(int seat) {
    if (seat == 0) {
      System.out.print("\u001B[32m0"); // green (open)
    } else if (seat == 1) {
      System.out.print("\u001B[31m1"); // red (taken)
    }
  }

}

/*
 * 3 seating sections
 * - main
 * - right
 * - left
 * - back/balcony
 * like:
 * 
 * [screen]
 * llll mmmmmmmmmmmmmmmmmmmm rrrr
 * llll mmmmmmmmmmmmmmmmmmmm rrrr
 * llll mmmmmmmmmmmmmmmmmmmm rrrr
 * llll mmmmmmmmmmmmmmmmmmmm rrrr
 * llll mmmmmmmmmmmmmmmmmmmm rrrr
 * llll mmmmmmmmmmmmmmmmmmmm rrrr
 * llll mmmmmmmmmmmmmmmmmmmm rrrr
 * llll mmmmmmmmmmmmmmmmmmmm rrrr
 * bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
 * bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
 * 
 * - make the taken seats red or som
 */