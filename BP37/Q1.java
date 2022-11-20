class Q1 {
    double balance = 500;
    public Q1(double balance) {
        balance = this.balance;
    }

    public void withdraw(double amount) {
        if (amount > balance || amount <= 0) {
            String s = "Withdrawl amound must be greater than 0 and within the account ballance.";
            IllegalArgumentException e = new IllegalArgumentException(s);
            throw e;
        }
        System.out.println("withdrawled");
    }
}