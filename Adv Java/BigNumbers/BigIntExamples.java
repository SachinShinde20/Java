import java.math.BigInteger;

public class BigIntExamples {
    public static void main(String[] args) {

        BigInteger num1 = new BigInteger("998877665544332211");
        BigInteger num2 = new BigInteger("112233445566778899");

        System.out.println("Number 1: " + num1);
        System.out.println("Number 2: " + num2);

        // Addition
        BigInteger addResult = num1.add(num2);
        System.out.println("\nAddition (a + b): " + addResult);

        // Subtraction
        BigInteger subtractResult = num1.subtract(num2);
        System.out.println("Subtraction (a - b): " + subtractResult);

        // Multiplication
        BigInteger multiplyResult = num1.multiply(num2);
        System.out.println("Multiplication (a * b): " + multiplyResult);

        // Division
        if (!num2.equals(BigInteger.ZERO)) {
            BigInteger divideResult = num1.divide(num2);
            System.out.println("Division (a / b): " + divideResult);
        } else {
            System.out.println("Division by zero is not allowed.");
        }

        // Remainder
        if (!num2.equals(BigInteger.ZERO)) {
            BigInteger remainderResult = num1.remainder(num2);
            System.out.println("Remainder (a % b): " + remainderResult);
        } else {
            System.out.println("Modulo by zero is not allowed.");
        }

        // Power (num1 ^ 10)
        BigInteger powerResult = num1.pow(10);  // exponent must be int
        System.out.println("Power (base^10): " + powerResult);

        // Max and Min
        BigInteger max = num1.max(num2);
        BigInteger min = num1.min(num2);
        System.out.println("Max of (a, b): " + max);
        System.out.println("Min of (a, b): " + min);

        // Modulus with 100
        // BigInteger modulus = BigInteger.valueOf(100);
        BigInteger modulus = new BigInteger(String.valueOf((int)100.555));

        if (modulus.signum() > 0) {
            BigInteger modResult = num1.mod(modulus);  // result always positive
            System.out.println("Modulus (a mod 100): " + modResult);
        } else {
            System.out.println("Modulus must be positive.");
        }

        System.out.print("\nComparision: ");

        int res = num1.compareTo(num2);
        switch (res) {
            case -1:
                System.out.println("Num-2 is Bigger");
                break;
            case 0:
                System.out.println("Both are Same");
                break;
            default:
                System.out.println("Num-1 is Bigger");
        }
    }
}
