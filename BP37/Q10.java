public class Q10 {
  public static void main(String[] args) {
    try {
      String carName = car(0);
    }
    catch (ArithmeticException e) {
      System.out.println("invalid input.");
    }
  }

  static String car(int xs) {
    int number = 5 / xs;
    return "folkswagon"; // just for fun
  }
}
