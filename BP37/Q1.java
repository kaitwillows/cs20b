class Q1 {
    static double balance = 500;
    public static void main(String[] args) {
        withdraw(200);
    }

    static void withdraw(double amount) {
        if (amount > balance || amount <= 0) {
            String s = "Can't withdraw more than the balance.";
            IllegalArgumentException e = new IllegalArgumentException(s);
            throw e;
        }
    }
}