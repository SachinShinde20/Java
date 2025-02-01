import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {

    private static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 100) {
            throw new InvalidAgeException("Invalid age. Please enter a value between 0 and 100.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter your age: ");
            int age = scanner.nextInt();

            validateAge(age);
            System.out.println("Your age is: " + age);
        } catch (InvalidAgeException e) {
            System.err.println("\nCustom Exception Caught:");
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\nGeneral Exception Caught:");
            e.printStackTrace();
        }
    }
}
