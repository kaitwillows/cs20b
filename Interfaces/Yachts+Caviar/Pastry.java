class Pastry extends Food {

  String flavour;
  
  Pastry(String name, double cost, int calories, String flavour) {
    super(name, cost, calories);
    flavour = this.flavour;
  }

  public String getFlavour {
    return flavour;
  }

  public void setFlavour(String flavour) {
    this.flavour = flavour;
  }

  public String toString() {
    return name + " -- Cost: " + cost + " Calories: " + calories + " Flavour: " + flavour;
  }
}
