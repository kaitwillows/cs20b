class Yacht extends Boat implements LuxuryItem {
  
  int cabins;

  // constructor 
  public Yacht(String name, double cost, int horsepower, int cabins) {
    super(name, cost, horsepower);
    this.cabins = cabins;
  }

  public void setCabins(int cabins) {
    this.cabins = cabins;
  }

  public int getCabins() {
    return cabins;
  }

  public String toString() {
    return name+" -- Cost: $"+cost+" Horsepower: "+horsepower+" Cabins: "+cabins;
  }

  public double calculateLuxuryTax() {
    final double TAX_AMOUNT = cost * 0.15;
    return TAX_AMOUNT;
  }

  public String getDescription() {
    return cabins + "-cabin " + horsepower + " horsepower yacht " + name + ":                $" + (cost + calculateLuxuryTax()) + "0 **luxury tax included**"; 
  }
  
}
