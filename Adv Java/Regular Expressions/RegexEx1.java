import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
            Username validation (First letter Capital, contain lowercase, numbers)
        */
        String usernameRegex = "^[A-Z][A-Za-z0-9]{7,20}$";
        System.out.print("Enter Username: ");
        String userName = sc.nextLine();

        // Compile the regex
        Pattern usernamePattern = Pattern.compile(usernameRegex);
        // Create a matcher for the given input
        Matcher usernameMatcher = usernamePattern.matcher(userName);
        // usernameMatcher.matches() -> Returns boolean Result
        System.out.println(usernameMatcher.matches() ? "✅ Valid Username" : "❌ Invalid Username");

        /*
            Mobile number validation (Indian format: starts with 6-9 and total 10 digits)
        */
        String mobileRegex = "^[6-9]\\d{9}$";
        System.out.print("Enter Mobile Number: ");
        String mobileNumber = sc.nextLine();

        Pattern mobilePattern = Pattern.compile(mobileRegex);
        Matcher mobileMatcher = mobilePattern.matcher(mobileNumber);
        System.out.println(mobileMatcher.matches() ? "✅ Valid Mobile Number" : "❌ Invalid Mobile Number");

        sc.close();
    }
}