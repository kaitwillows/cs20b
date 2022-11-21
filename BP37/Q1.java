import java.util.*;

class Q1 {
  static double balance = 500;
  static double lastBalance;

  
  public static void main(String[] args) { // prints balance and prompts user for withdraw amount
    Scanner scanner = new Scanner(System.in);
    System.out.print("Current account balance is $" + balance + "\nenter withdraw amount: ");
    withdraw(scanner.nextDouble());
    scanner.close();
  }

  static void withdraw(double amount) { // withdraws amount specified, throws an exception if an invalid amount is entered
    if (amount > balance || amount <= 0) {
      String s = "Withdrawl amound must be greater than 0 and within the account ballance.";
      IllegalArgumentException e = new IllegalArgumentException(s);
      throw e;
    }   
    lastBalance = balance;
    balance = balance - amount;
    System.out.println("Withdrew $" + amount + " from a balance of $" + lastBalance + ". Your new balance is $" + balance);
  }
}