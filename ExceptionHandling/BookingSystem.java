public class BookingSystem {
  public static void main(String[] args) {
    // initialize arrays
    int[][] leftSection = new int[8][4];
    int[][] rightSection = new int[8][4];
    int[][] middleSection = new int[8][20];
    int[][] backSection = new int[2][30];

    // populate arrays with random seats
    double num = Math.random();
    // System.out.println(num + " " +  Math.round(num));
    printTheater(leftSection, rightSection, middleSection, backSection);


  }

  // prepopulate seats by section, demand determines how full that section will be
  static void prePopulate(int[][] section, double demand) {

  }

  static void printTheater(int[][] leftSection, int[][] rightSection, int[][] middleSection, int[][] backSection) {
    // first 8 rows (mid+sides)
    for (int i = 0; i < 8; i++) {
      // left
      for (int j = 0; j < 4; j++) {
        System.out.print(leftSection[i][j]);
        // System.out.print("l");
      }
      System.out.print(" ");
      // middle
      for (int j = 0; j < 20; j++) {
        System.out.print(middleSection[i][j]);
      }
      System.out.print(" ");
      // right
      for (int j = 0; j < 4; j++) {
        System.out.print(rightSection[i][j]);
      }
      System.out.print("\n");
    }
    // System.out.print("\n");
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 30; j++) {
        System.out.print(backSection[i][j]);
      }
      System.out.print("\n");
    }
  }
  
  // printSection for "zooming" in to section and booking it and stuff
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