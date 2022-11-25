import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcetionTest {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    int x = 0;
    while(true){
      try{
          System.out.println("Insert a number: ");
          x = myScanner.nextInt();
          break;
      }catch(InputMismatchException e){
          System.out.println("Invalid, try again.");
          myScanner.next(); // skip the invalid token
          // continue; is not required
      }
    }
  }
}
