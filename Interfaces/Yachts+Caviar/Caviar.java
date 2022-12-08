class Caviar extends Food implements LuxuryItem {
  public Caviar(String name, double cost, int calories, String origin) {
    super(name, cost, calories);
    String origin = this.origin;
  }

  

  String origin;
  public double calculateLuxuryTax() {
    return 7;
  }
}
