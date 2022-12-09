class Main {
	public static void main(String[] args) {
    System.out.println(""); // new line

    // a pastry named "Croissant", costing $1.99, with 200 calories and flavour "Chocolate"
    Pastry pastryItem = new Pastry("Croissant", 1.99, 200, "Chocolate");
    // System.out.println(pastryItem.toString());
    System.out.println(pastryItem.getDescription());

    MotorBoat motorItem = new MotorBoat("Evinrude", 3475.00, 400, 5);
    // System.out.println(motorItem.toString());
    System.out.println(motorItem.getDescription());

    Yacht yachtItem = new Yacht("Oceano", 950000, 1500, 12);
    // System.out.println(yachtItem.toString());
    System.out.println(yachtItem.getDescription());


    Caviar fishItem = new Caviar("Beluga", 570, 800, "Caspian Sea"); // lux item 
    // System.out.println(fishItem.toString());
    System.out.println(fishItem.getDescription());

    
    System.out.println(""); // new line

    // totaling
    double subtotal = pastryItem.cost + motorItem.cost + yachtItem.cost + yachtItem.calculateLuxuryTax() + fishItem.cost + fishItem.calculateLuxuryTax();
    double tax = subtotal * 0.08;
    double grandTotal = subtotal + subtotal;

    System.out.println("Sub Total:   " + subtotal);
    System.out.println("Tax:         " + tax);
    System.out.println("Grand Total: " + grandTotal);

    System.out.println(""); // new line
	}
}
