import java.util.ArrayList;

public class Account {
    private ArrayList<BankTransaction> transactions;

    public Account() {
        this.transactions = new ArrayList<>();
    }

    public void withdraw(double amount) {
        // Implement withdrawal logic
        transactions.add(new BankTransaction("Withdrawal", -amount, "Withdrawal"));
    }

    public void deposit(double amount) {
        // Implement deposit logic
        transactions.add(new BankTransaction("Deposit", amount, "Deposit"));
    }

    public double getBalance() {
        double balance = 0;
        for (BankTransaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public ArrayList<BankTransaction> getTransactions() {
        return transactions;
    }
}
