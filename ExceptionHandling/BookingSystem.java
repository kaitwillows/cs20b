public class BookingSystem {
  public static void main(String[] args) {
    // initialize arrays
    int[][] leftSection = new int[8][4];
    int[][] rightSection = new int[8][4];
    int[][] middleSection = new int[8][20];
    int[][] backSection = new int[2][30];

    // populate arrays with random seats
    double num = Math.random();
    prePopulate(leftSection, 25);
    prePopulate(rightSection, 25);
    prePopulate(middleSection, 65); // demand is % how full the section will be
    prePopulate(backSection, 30);


    printTheater(leftSection, rightSection, middleSection, backSection);
    // printSection(backSection);


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
    // first 8 rows (mid+sides)
    for (int i = 0; i < middleSection.length; i++) {
      // left
      for (int j = 0; j < leftSection[0].length; j++) {
        printSeat(leftSection[i][j]);
        // System.out.print("l");
      }
      System.out.print("   ");
      // middle
      for (int j = 0; j < middleSection[0].length; j++) {
        printSeat(middleSection[i][j]);
      }
      System.out.print("   ");
      // right
      for (int j = 0; j < rightSection[0].length; j++) {
        printSeat(rightSection[i][j]);
      }
      System.out.print("\n");
    }
    System.out.print("\n  ");
    // back
    for (int i = 0; i < backSection.length; i++) {
      for (int j = 0; j < backSection[0].length; j++) {
        printSeat(backSection[i][j]);
      }
      System.out.print("\n  ");
    }
  }

    // printSection for "zooming" in to section and booking it and stuff
    static void printSection(int[][] section) {
      System.out.print("  ");
      for (int i = 0; i < section[0].length; i++) {
        System.out.print(i + " ");
      }
      System.out.print("\n");

      for (int i = 0; i < section.length; i++) {
        System.out.print("\u001B[37m" + (char) (i + 65) + " "); // row numbers
        for (int j = 0; j < section[0].length; j++) {
          printSeat(section[i][j]);
          System.out.print(" ");
        }
        System.out.print("\n");
      }
    }

  static void printSeat(int seat) {
    if (seat == 0) {
      System.out.print("\u001B[32m0"); // green (open)
    }
    else if (seat == 1) {
      System.out.print("\u001B[31m1"); // red (taken)
    }
  }

}





/*
3 seating sections
  - main
  - right
  - left
  - back/balcony
  like:

              [screen]
   llll mmmmmmmmmmmmmmmmmmmm rrrr
   llll mmmmmmmmmmmmmmmmmmmm rrrr
   llll mmmmmmmmmmmmmmmmmmmm rrrr
   llll mmmmmmmmmmmmmmmmmmmm rrrr
   llll mmmmmmmmmmmmmmmmmmmm rrrr
   llll mmmmmmmmmmmmmmmmmmmm rrrr
   llll mmmmmmmmmmmmmmmmmmmm rrrr
   llll mmmmmmmmmmmmmmmmmmmm rrrr
   bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
   bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb

- make the taken seats red or som
*/