import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalExamples {
    public static void main(String[] args) {

        // 1. Using primitive double — fast but imprecise
        double n1 = 0.5;
        double n2 = 0.4;

        System.out.println("\t Using double:");
        System.out.println("Double n1: " + n1);
        System.out.println("Double n2: " + n2);
        double result = n1 - n2;
        System.out.println("Result (n1 - n2): " + result); // Might be 0.099999999...

        // 2. Incorrect use of BigDecimal constructor with double — leads to precision error
        BigDecimal n3 = new BigDecimal(n1); // risky
        BigDecimal n4 = new BigDecimal(n2); // risky
        BigDecimal result2 = n4.subtract(n3);
        System.out.println("\nResult using new BigDecimal(double): " + result2); // unexpected value

        // 3. Correct way: Use String constructor or valueOf()
        BigDecimal big1 = new BigDecimal("0.5");               // ✅ correct
        BigDecimal big2 = BigDecimal.valueOf(0.4);             // ✅ also correct

        System.out.println("\n\n\t Using BigDecimal (precise):");
        System.out.println("Big1: " + big1);
        System.out.println("Big2: " + big2);

        // Arithmetic operations
        BigDecimal addResult = big1.add(big2);
        System.out.println("\nAddition (big1 + big2): " + addResult);

        BigDecimal bigResult = big1.subtract(big2);
        System.out.println("Subtraction (big1 - big2): " + bigResult);

        BigDecimal mulResult = big1.multiply(big2);
        System.out.println("Multiplication (big1 * big2): " + mulResult);

        // Division requires scale and rounding mode (to avoid ArithmeticException)
        BigDecimal divResult = big1.divide(big2, 2, RoundingMode.HALF_UP);
        System.out.println("Division (big1 / big2): " + divResult);

        BigDecimal remainderResult = big1.remainder(big2);
        System.out.println("Remainder (big1 % big2): " + remainderResult);

        // 4. Comparison methods
        System.out.println("\n\t Comparisons:");

        int cmp = big1.compareTo(big2); // returns -1, 0, or 1
        if (cmp > 0)
            System.out.println("big1 is greater than big2");
        else if (cmp < 0)
            System.out.println("big1 is less than big2");
        else
            System.out.println("big1 is equal to big2");

        // 5. Min and Max
        BigDecimal max = big1.max(big2);
        BigDecimal min = big1.min(big2);
        System.out.println("Max of big1 and big2: " + max);
        System.out.println("Min of big1 and big2: " + min);

        // 6. Set scale (rounding decimal places)
        BigDecimal rounded = big1.divide(big2, 4, RoundingMode.HALF_EVEN);
        System.out.println("Rounded division (4 decimal places): " + rounded);

        // Finding PI value
        BigDecimal bigN1 = BigDecimal.valueOf(22);               // ✅ correct
        BigDecimal bigN2 = BigDecimal.valueOf(7);             // ✅ also correct

        System.out.println("\n\n\tUsing BigDecimal (For Finding Value of PI):");
        System.out.println("Big1: " + bigN1);
        System.out.println("Big2: " + bigN2);

        // BigDecimal pi = big1.divide(big2); -> java.lang.ArithmeticException: Non-terminating decimal expansion
        BigDecimal pi = bigN1.divide(bigN2, 20, RoundingMode.HALF_UP);
        System.out.println("Division (22 / 7): " + pi);

    }
}
