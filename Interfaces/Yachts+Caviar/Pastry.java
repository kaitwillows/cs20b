// the Pastry class is an extention of Food.
// Food objects have the fields name, cost and calories.
// Pastries have an additional field called flavour
// this class had the methods setFlavour(), getFlavour() and toString()

class Pastry extends Food {

  String flavour;
  
  // constructor calls super() and adds flavour
  Pastry(String name, double cost, int calories, String flavour) {
    super(name, cost, calories);
    this.flavour = flavour;
  }

  public void setFlavour(String flavour) {
    this.flavour = flavour;
  }

  public String getFlavour() {
    return flavour;
  }

  public String toString() {
    return name + " -- Cost: $" + cost + "  Calories: " + calories + "  Flavour: " + flavour;
  }
  
  public String getDescription() {
    return calories + " calorie " + flavour + " " + name + ":                      $" + cost;
  }

}
