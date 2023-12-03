import java.util.ArrayList;

public class Bank {
    private ArrayList<User> users;

    public Bank() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        if (user instanceof Customer) {
            Customer customer = (Customer) user;
            customer.setBank(this);
        }
    }

    public void transferMoney(Customer sender, Customer receiver, double amount) {
        // Implement transferMoney logic
        // You need to deduct the amount from sender's account and add it to receiver's account
        sender.getAccounts().get(0).withdraw(amount);
        receiver.getAccounts().get(0).deposit(amount);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
