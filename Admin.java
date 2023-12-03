import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<Customer> customers;

    public Admin(String username, String password) {
        super(username, password);
        this.customers = new ArrayList<>();
    }

    public void viewAllCustomers() {
        for (Customer customer : customers) {
            System.out.println("Customer: " + customer.getUsername());
        }
    }
}
