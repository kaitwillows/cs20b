interface LuxuryItem {
  public double calculateLuxuryTax();
}

class Caviar extends Food implements LuxuryItem {
  public double calculateLuxuryTax() {
    //for testing purposes its always 5 idk
    return 5;
  }
}
