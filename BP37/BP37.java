import java.util.*;
class BP37 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    
    while (true) {
      System.out.println("enter question number (0 to quit): ");
      int input = scanner.nextInt();
      if (input == 0) {
        break;
      }
      try {
        switch (input) {

          case 1:
            // question 1
            Q1 q1 = new Q1(500); // balance of 500
            q1.withdraw(501); // withdrawls 
            break;
          case 2:
            // question 2


        }
      }
      catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("invalid input.");
      }
    }
    scanner.close();
  }
}