import java.util.ArrayList;

public class Customer extends User {
    private ArrayList<Account> accounts;
    private Bank bank;

    public Customer(String username, String password) {
        super(username, password);
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String accountNumber) {
        // Implement account creation logic
        accounts.add(new Account());
    }

    public void createSavingsAccount(String accountNumber) {
        // Implement savings account creation logic
        accounts.add(new SavingsAccount());
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void deposit(double amount) {
        // Deposit money into the first account (you may want to modify this based on your logic)
        if (!accounts.isEmpty()) {
            accounts.get(0).deposit(amount);
        }
    }

    // Metode atau fungsi yang melibatkan variabel bank
    public void doSomethingWithBank() {
        if (bank != null) {
            // Lakukan sesuatu dengan bank
        }
    }
}
