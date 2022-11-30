public class FlyFish extends Fish {
  public void greeting() {
    System.out.println("yay, i can flyyyyy");
  }

  public int fly() {
    int jumps = (int)(Math.random() * 5);
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
