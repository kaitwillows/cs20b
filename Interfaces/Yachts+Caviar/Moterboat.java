class Moterboat extends Boat {

  int seats;

  // constructor
  public Moterboat(String name, double cost, int horsepower, int seats) {
    super(name, cost, horsepower);
    this.seats = seats;
  }

  public void setSeats(int seats) {
    this.seats = seats;
  }

  public int getSeats() {
    return seats;
  }
  
  public String toString() {
    return name + " -- Cost: $" + cost + " horsepower: " + horsepower + " seats: " + seats;
  }
 
}
