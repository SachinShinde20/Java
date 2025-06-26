import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexEx2 {

    // Utility method for checking regex
    public static boolean check(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    // Validate both username and password
    public static boolean validate(String username, String password) {
        // Simpler, cleaner regexes
        String userNameRegex = "^[a-zA-Z0-9._]{5,15}$";
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[\\S]{8,}$";

        boolean userValid = check(userNameRegex, username);
        boolean passValid = check(passwordRegex, password);

        if (!userValid) {
            System.out.println("❌ Invalid Username. Use 5-15 letters, numbers, dots or underscores only.");
        }
        if (!passValid) {
            System.out.println("❌ Invalid Password. Must be 8+ chars, include upper/lowercase, number, and special character.");
        }

        return userValid && passValid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean valid = false;

        while (!valid) {
            System.out.print("Enter Username: ");
            String name = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            valid = validate(name, password); // Loop continues if invalid
        }

        System.out.println("✅ Login successful!");
    }
}
