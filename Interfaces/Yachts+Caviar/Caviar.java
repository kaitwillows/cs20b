class Caviar extends Food implements LuxuryItem {

  String origin;

  // constructor 
  public Caviar(String name, double cost, int calories, String origin) {
    super(name, cost, calories);
    this.origin = origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getOrigin() {
    return origin;
  }

  public double calculateLuxuryTax() {
    final double TAX_AMOUNT = cost * 0.15; // tax excludes cost (total = TAX_AMOUNT + cost)
    return TAX_AMOUNT;
  }

  public String getDescription() {
    return calories + " calorie " + name + " caviar from " + origin + ":           $" + cost + calculateLuxuryTax() + "0 **luxury tax included**";
  }

}
