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
    fishList.add(joe);
    fishList.add(mike);
    while (true) {
      // menu 
      System.out.print("\nmenu:\n  [1] print a list of all the fish\n  [2] observe fish\n  [3] add a fish\n  [4] quit\n");
      int menuSelection = intScanner.nextInt();
      System.out.println("");
      switch (menuSelection) {
        case 1: // prints the fish in a list
          for (Fish i : fishList) {
            System.out.println(i.toString());
          }
          break;
        case 2: // shows the fishes greeting and methods
          System.out.println(joe.toString());
          joe.greeting();
          joe.fly();
          System.out.println("");

          System.out.println(mike.toString());
          mike.greeting();
          break;
        case 3: // adds fish based on user inputs 
          // add fish (in switch statement later idk)
          System.out.print("adding a fish...\nhow old is the fish? ");
          int age = intScanner.nextInt();
          System.out.print("what is the fishes name? ");
          String name = strScanner.nextLine();

          fishList.add(new Fish(age, name));
          break;
        case 4: // allows the user to quit the program
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
