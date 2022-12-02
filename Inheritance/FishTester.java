import java.util.ArrayList;
import java.util.Scanner;

public class FishTester {
  public static void main(String[] args) {
    Scanner intScanner = new Scanner(System.in);
    Scanner strScanner = new Scanner(System.in);
    FlyFish joe = new FlyFish(23, "joe");
    // joe.fly();
    // joe.greeting();
    // System.out.println(joe.toString());

    Fish mike = new Fish(37, "mike");
    // mike.greeting();
    // System.out.println(mike.toString());



    ArrayList<Fish> fishList = new ArrayList<Fish>();
    while (true) {
     // menu 
      System.out.print("menu:\n  [1] print a list of all the fish\n  [2] observe fish\n  [3] add a fish\n  [4] quit");
      int menuSelection = intScanner.nextInt();
      switch (menuSelection) {
        case 3:
          // add fish (in switch statement later idk)
          System.out.print("adding a fish...\nhow old is the fish? ");
          int age = intScanner.nextInt();
          System.out.print("what is the fishes name? ");
          String name = strScanner.nextLine();

          fishList.add(new Fish(age, name));
          break;
        case 4:
          System.exit(0);
      }

      /*
      menu:
        add fish
        list fish
        watch fish (make a random method happen idk);
      */


    }
    
  }
}
