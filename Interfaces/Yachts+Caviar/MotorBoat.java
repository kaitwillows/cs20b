class MotorBoat extends Boat {

  int seats;

  // constructor
  public MotorBoat(String name, double cost, int horsepower, int seats) {
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
 
  public String getDescription() {
    return seats + "-seat " + horsepower + " horsepower motorboat " + name + ":             $" + cost + "0";
  }

}
