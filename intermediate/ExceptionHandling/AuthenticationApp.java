import java.util.Scanner;

class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}

class Login {
    public static void authenticate(String username, String password) throws InvalidCredentialsException {
        String validUsername = "admin";
        String validPassword = "admin";

        if (username.equals(validUsername) && password.equals(validPassword)) {
            System.out.println("\nLogin Successful!");
        } else {
            throw new InvalidCredentialsException("Invalid username or password.");
        }
    }
}

public class AuthenticationApp {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== Welcome to the Authentication System ===\n");

            System.out.print("Enter username: ");
            String username = sc.nextLine().trim();

            System.out.print("Enter password: ");
            String password = sc.nextLine().trim();

            try {
                Login.authenticate(username, password);
            } catch (InvalidCredentialsException e) {
                System.out.println("\nAuthentication Failed: \n\t" + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("\nAn unexpected error occurred. Please try again.");
        }
    }
}
