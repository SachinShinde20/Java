class Bank {
    public void processTransaction(int amount) {
        // Local class inside the method
        final class Transaction {
            int balance = 100;

            public void execute() {
                if (amount > balance) {
                    System.out.println("Insufficient balance.");
                } else {
                    balance -= amount; // Deduct the amount from balance
                    System.out.println("Money has been withdrawn.");
                    System.out.println("Current Balance: " + balance);
                }
            }
        }

        // Creating an instance of the local class and calling the method
        Transaction transaction = new Transaction();
        transaction.execute();
    }
}

public class LocalClass {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.processTransaction(25); // Example transaction
    }
}
