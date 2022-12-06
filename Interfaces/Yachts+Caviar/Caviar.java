class Caviar extends Food implements LuxuryItem {
  public Caviar(String name, double cost, int calories) {
    super(name, cost, calories);
  }
  String origin;
  public double calculateLuxuryTax() {
    return 7;
  }
}
