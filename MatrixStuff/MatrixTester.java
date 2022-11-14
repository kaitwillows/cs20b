import java.util.*;

// asdfasdfasdfasdf
// works
// but if i change this

class MatrixTester {
  public static void main(String[] args) {
    System.out.println("\033[H\033[2J");
    Scanner scanner = new Scanner(System.in);
    int array1[][] = {
        { 1, 2, -2, 0 },
        { -3, 4, 7, 2 },
        { 6, 0, 3, 1 }
    };
    int array2[][] = {
        { -1, 3 },
        { 0, 9 },
        { 1, -11 },
        { 4, -5 }
    };

    System.out.print("use default arrays [1] or inputted arrays [2]? "); // menu options
    int choice = scanner.nextInt();

    switch (choice) {
      case 1: // use default arrays (initialized above)
        int matrix[][] = MatrixMult.mult(array1, array2);
        System.out.print("\nresult:\n");
        MatrixMult.printArray(matrix);
        break;

      case 2: // input and use user arrays
        System.out.println("\nfirst array:");
        int userArray1[][] = MatrixMult.arrayInput();
        System.out.println("\nsecond array:");
        int userArray2[][] = MatrixMult.arrayInput();
        int userMatrix[][] = MatrixMult.mult(userArray1, userArray2);
        System.out.print("\nresult:\n");
        MatrixMult.printArray(userMatrix);
        break;
    }
    scanner.close();
  }
}

// im gonna change this now this