class Bank {
    private int balance = 10_00_000;

    // Synchronized method ensures thread safety by locking the object
    public synchronized void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}

class DebitCard extends Thread {
    Bank bank;  // Reference to the shared Bank object

    // Constructor to initialize the Bank object
    DebitCard(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_00_000; i++) {
            bank.withdraw(2);
            System.out.println("Money is Deducted by: " + Thread.currentThread().getName());
        }
    }
}

public class RaceCondition {
    public static void main(String[] args) {
        Bank bank = new Bank(); // Shared Bank object

        // Creating two DebitCard threads sharing the same Bank account
        DebitCard card1 = new DebitCard(bank);
        DebitCard card2 = new DebitCard(bank);

        card1.setName("Bank of Maharashtra");
        card2.setName("Bank of India");

        card1.start();
        card2.start();

        // Ensuring both threads complete execution before calculating balance
        try {
            card1.join();
            card2.join();
        } catch (InterruptedException e) {
            System.out.println("[Error] Thread interrupted: " + e.getMessage());
        }

        // Expected Calculation - (synchronized)
        // card1 deducts 2,00,000 and card2 deducts 2,00,000
        // Total Deduction = 4,00,000
        // Expected Balance = 10,00,000 - 4,00,000 = 6,00,000
        System.out.println("\nFinal Bank Balance: " + bank.getBalance());
    }
}
