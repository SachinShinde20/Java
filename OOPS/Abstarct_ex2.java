/*Scenario Explanation: Payment Gateway System
Imagine you are developing a payment gateway system, where payments can be processed using different methods such as credit card, PayPal, or UPI. Each payment method has its own unique way of processing transactions, but there are also some common steps that all payment methods follow, such as validating a transaction.
To represent this concept, we can use abstraction to define a common blueprint (PaymentProcessor) for all payment methods, and polymorphism to allow each payment method to define its specific behavior for processing payments.
 */

abstract class PaymentProcessor {
    abstract void processPayment(double amount);

    public void validateTransaction() {
        System.out.println("Validating transaction...");
    }
}

class CreditCardProcessor extends PaymentProcessor {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalProcessor extends PaymentProcessor {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class UPIProcessor extends PaymentProcessor {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing UPI payment of $" + amount);
    }
}

public class Abstarct_ex2 {
    public static void main(String[] args) {
        PaymentProcessor processor;

        System.out.println("\n// Processing payment via Credit Card");
        processor = new CreditCardProcessor();
        processor.validateTransaction();
        processor.processPayment(100.50);

        System.out.println("\n// Processing payment via PayPal");
        processor = new PayPalProcessor();
        processor.validateTransaction();
        processor.processPayment(200.75);

        System.out.println("\n// Processing payment via UPI");
        processor = new UPIProcessor();
        processor.validateTransaction();
        processor.processPayment(50.00);
    }
}
