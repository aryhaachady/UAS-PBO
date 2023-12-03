import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        // Input data admin
        System.out.println("Input data admin:");
        System.out.print("Username: ");
        String adminUsername = scanner.next();
        System.out.print("Password: ");
        String adminPassword = scanner.next();
        Admin admin = new Admin(adminUsername, adminPassword);
        bank.addUser(admin);

        // Input data customer 1
        System.out.println("\nInput data customer 1:");
        System.out.print("Username: ");
        String customer1Username = scanner.next();
        System.out.print("Password: ");
        String customer1Password = scanner.next();
        Customer customer1 = new Customer(customer1Username, customer1Password);
        customer1.createAccount("123456");
        bank.addUser(customer1);

        // Input data customer 2
        System.out.println("\nInput data customer 2:");
        System.out.print("Username: ");
        String customer2Username = scanner.next();
        System.out.print("Password: ");
        String customer2Password = scanner.next();
        Customer customer2 = new Customer(customer2Username, customer2Password);
        customer2.createAccount("654321");
        bank.addUser(customer2);

        // Input jumlah transfer
        System.out.println("\nInput jumlah transfer dari " + customer1.getUsername() + " ke " + customer2.getUsername() + ":");
        double transferAmount = scanner.nextDouble();

        // Validasi jumlah transfer
        if (transferAmount > 0) {
            // Transfer uang dari customer1 ke customer2
            bank.transferMoney(customer1, customer2, transferAmount);
            System.out.println("Transfer berhasil!");
        } else {
            System.out.println("Jumlah transfer tidak valid. Harap masukkan nilai positif lebih dari nol.");
        }

        // Admin melihat semua pelanggan
        System.out.println("\nAdmin melihat semua pelanggan:");
        admin.viewAllCustomers();
        System.out.println("==================================");

        // Pelanggan 1 melihat transaksi sendiri
        System.out.println("\nPelanggan 1 melihat transaksi sendiri:");
        Customer customer1View = findCustomerByUsername(bank, customer1.getUsername());
        printTransactions(customer1View);
        System.out.println("==================================");

        // Pelanggan 2 melihat transaksi sendiri
        System.out.println("\nPelanggan 2 melihat transaksi sendiri:");
        Customer customer2View = findCustomerByUsername(bank, customer2.getUsername());
        printTransactions(customer2View);
        System.out.println("==================================");

        // Output informasi tambahan untuk Admin:
        System.out.println("\nAdmin melihat semua transaksi:");
        double totalBankBalance = 0;
        for (User user : bank.getUsers()) {
            if (user instanceof Customer) {
                Customer customer = (Customer) user;
                System.out.println("Transaksi " + customer.getUsername() + ":");
                double customerBalance = 0;

                if (!customer.getAccounts().isEmpty()) {
                    for (BankTransaction transaction : customer.getAccounts().get(0).getTransactions()) {
                        if (transaction.getAmount() > 0) {
                            System.out.println("  + Penyetoran: " + transaction.getAmount());
                            customerBalance += transaction.getAmount();
                            totalBankBalance += transaction.getAmount();
                        } else {
                            System.out.println("  - Penarikan: " + Math.abs(transaction.getAmount()));
                        }
                    }
                } else {
                    System.out.println("Tidak ada transaksi ditemukan untuk " + customer.getUsername());
                }

                System.out.println("Total saldo " + customer.getUsername() + ": " + customerBalance);
                System.out.println("==================================");
            }
        }

        System.out.println("Total saldo bank: " + totalBankBalance);

        scanner.close();
    }

    private static Customer findCustomerByUsername(Bank bank, String username) {
        for (User user : bank.getUsers()) {
            if (user instanceof Customer && user.getUsername().equals(username)) {
                return (Customer) user;
            }
        }
        return null;
    }

    private static void printTransactions(Customer customer) {
        if (customer != null && !customer.getAccounts().isEmpty()) {
            for (BankTransaction transaction : customer.getAccounts().get(0).getTransactions()) {
                System.out.println("  Transaksi: " + transaction.getAmount() + " (" + transaction.getType() + ")");
            }
        } else {
            System.out.println("Tidak ada transaksi ditemukan untuk " + customer.getUsername() + ".");
        }
    }
}
