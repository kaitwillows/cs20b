public class FlyFish extends Fish {
  public FlyFish(int age, String name) {
    super(age, name); // call superclass constructor
  }
  public FlyFish() {
    super(); // call superclass constructor
  }

  public void greeting() { // overwritten from Fish
    System.out.println("yay, i can flyyyyy");
  }

  // fly picks a number 1-4 and "jumps" that number of times
  public int fly() {
    int jumps = (int)(Math.random() * 5);
    System.out.print(name + " ");
    if (jumps == 0) {
      System.out.println("failed to fly :(");
    } else if (jumps == 1) {
      System.out.println("flew once!");
    } else {
      System.out.println("flew " + jumps + " times!");
    }
    return jumps;
  }
}
