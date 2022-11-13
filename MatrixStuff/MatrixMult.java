import java.util.*;

/* 
class MatrixMult helps with the management of 2d int arrays and has 3 methods:
int[][] mult(int[][], int[][]) returns the product one inputted matrix multiplied by another inputted  matrix
int[][] arrayInput() uses print statements and a scanner to return an inputted array from the user
void printArray(int[][]) prints an array in a grid 
*/

class MatrixMult {
  static int[][] mult(int array1[][], int array2[][]) {
    // variables
    int aRows = array1.length;
    int bCols = array2[0].length;
    int product[][] = new int[aRows][bCols]; // create a product array
    int thisSum = 0;

    // for loops
    for (int rowA = 0; rowA < aRows; rowA++) { // for every row in a
      for (int colB = 0; colB < bCols; colB++) { // against each column in b
        for (int i = 0; i < array1[0].length; i++) { // iterate through each matching pair, multiply and sum
          thisSum = thisSum + array1[rowA][i] * array2[i][colB];
        } 
        product[rowA][colB] = thisSum; // add the sum to product array
        thisSum = 0; // reset the sum
      }
    }
    return product;
  }
  
  static int[][] arrayInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("# of rows: ");
    int rows = scanner.nextInt();
    System.out.print("# of columns: ");
    int columns = scanner.nextInt();

    int array[][] = new int[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        System.out.print("input row " + (i+1) + ", column " + (j+1) + ": ");
        int input = scanner.nextInt();
        array[i][j] = input;
      }
    }
    // scanner.close();
    return array;
  }
  static void printArray(int matrix[][]) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
          System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
      }
  }
}
