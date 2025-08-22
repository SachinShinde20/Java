package Basics;

import java.util.Scanner;

public class NewSwitchCase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Lottery Number: ");
        int num = sc.nextInt();

        // Enhanced switch for lottery number
        switch (num) {
            case 101 -> System.out.println("You got the First Prize");
            case 202 -> System.out.println("You got the Second Prize");
            case 10, 20, 30 -> System.out.println("You got the supplementary gifts");
            default -> System.out.println("Bad Luck! Try next time!");
        }

        System.out.println("\nOrder Detail");
        String orderStatus = "REFUND";

        // Enhanced switch for order status
        switch (orderStatus) {
            case "ORDER" -> {
                // Some Implementation
                System.out.println("Just Ordered.");
            }
            case "RETURN" -> {
                // Some Implementation
                System.out.println("Order is Returned.");
            }
            case "REFUND" -> {
                // Some Implementation
                System.out.println("Refund is in process.");
            }
            case "PAYMENT" -> {
                // Some Implementation
                System.out.println("Payment received.");
            }
            case "ACCOUNT" -> {
                // Some Implementation
                System.out.println("Account details updated.");
            }
            default -> {
                // Some Implementation
                System.out.println("Invalid order status.");
            }
        }
    }
}
/*
New Switch Expressions (Java 14+)
    Arrow (->) syntax
    No fall-through
    Can return values
    Supports multiple labels per case
*/

