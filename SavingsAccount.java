public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount() {
        super();
        this.interestRate = 0.02; // Contoh nilai bunga 2%
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        // Implementasi logika pemberian bunga
        double currentBalance = getBalance();
        double interestEarned = currentBalance * interestRate;
        deposit(interestEarned);
    }
}

