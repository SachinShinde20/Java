import java.util.Scanner;

class User {
    String username;
    String email;

    // Constructor to initialize User details
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public void displayUserDetails() {
        System.out.println("Username: " + username + " \tEmail: " + email);
    }
}

class Customer extends User {
    String[] cartItems;

    public Customer(String username, String email, String[] cartItems) {
        super(username, email); // Setting parent class properties
        this.cartItems = cartItems;
    }

    public void displayCustomerInfo() {
        displayUserDetails();
        System.out.print("Products added to the cart: ");
        for (String item : cartItems) {
            System.out.print(item + ", ");
        }
        System.out.println("\n");
    }
}

class Seller extends User {
    String[] products;

    public Seller(String username, String email, String[] products) {
        super(username, email); // Setting parent class properties
        this.products = products;
    }

    public void displaySellerInfo() {
        displayUserDetails();
        System.out.print("Products listed for sale: ");
        for (String product : products) {
            System.out.print(product + ", ");
        }
        System.out.println("\n");
    }
}

public class Inheritance_Hierarchical {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Customer
        System.out.print("Enter Customer Username: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String customerEmail = scanner.nextLine();
        System.out.print("Enter number of items in the cart: ");
        int numItems = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] cartItems = new String[numItems];
        for (int i = 0; i < numItems; i++) {
            System.out.print("Enter cart item " + (i + 1) + ": ");
            cartItems[i] = scanner.nextLine();
        }

        Customer customer = new Customer(customerName, customerEmail, cartItems);
        customer.displayCustomerInfo();

        // Input for Seller
        System.out.print("Enter Seller Username: ");
        String sellerName = scanner.nextLine();
        System.out.print("Enter Seller Email: ");
        String sellerEmail = scanner.nextLine();
        System.out.print("Enter number of products: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] products = new String[numProducts];
        for (int i = 0; i < numProducts; i++) {
            System.out.print("Enter product " + (i + 1) + ": ");
            products[i] = scanner.nextLine();
        }

        Seller seller = new Seller(sellerName, sellerEmail, products);
        seller.displaySellerInfo();

        scanner.close();
    }
}
