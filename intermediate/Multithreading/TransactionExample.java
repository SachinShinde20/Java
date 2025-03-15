// Custom Exception for insufficient balance
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

// ATM class that handles balance and transactions
class ATM {
    private int balance = 10_000;
    private int transactionId = 100;

    // 🔒 Synchronized method to ensure thread-safe withdrawal
    public synchronized void withdraw(int amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException(
                    "[Error] Insufficient Balance! Failed withdrawal attempt of ₹" + amount
            );
        }
        balance -= amount;
        transactionId++; // 🔒 Ensured atomic increment inside synchronized block
        System.out.println("Transaction ID: " + transactionId +
                " | ₹" + amount + " withdrawn by " + Thread.currentThread().getName() +
                " | Remaining Balance: ₹" + balance);
    }

//    withdraw() method is already synchronized, So It properly protects the shared variables (balance and transactionId)
    public int getBalance() {
        return balance;
    }

    public int getTransactionId() {
        return transactionId;
    }
}

// User class representing customers performing transactions
class User extends Thread {
    private final ATM atm; // Shared ATM object

    User(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void run() {
        int amount = 100; // Each withdrawal amount
        for (int i = 0; i < 51; i++) {
            try {
                atm.withdraw(amount); // Withdraw ₹100
            } catch (InsufficientBalanceException e) {
                System.err.println(e.getMessage());
                break; // Stop further attempts if balance is insufficient
            }
        }
    }
}

// Main class to simulate ATM transactions
public class TransactionExample  {
    public static void main(String[] args) {
        ATM atm = new ATM();

        // Creating two users sharing the same ATM object
        User user1 = new User(atm);
        User user2 = new User(atm);

        user1.setName("Rahul");
        user2.setName("Kedar");

        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            System.err.println("[Error] Thread interrupted: " + e.getMessage());
        }

        System.out.println("\nFinal Balance: ₹" + atm.getBalance());
        System.out.println("Last Transaction ID: " + atm.getTransactionId());
    }
}