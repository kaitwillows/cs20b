public class FishTester {
  public static void main(String[] args) {
    FlyFish joe = new FlyFish();
    joe.fly();
    joe.greeting();
    System.out.println(joe.toString());

    Fish mike = new Fish(37, "mike");
    mike.greeting();
    System.out.println(mike.toString());


  }
}
