class Introduction {
    public static void main(String[] args) {
        /*********************************
         * Datatypes
         **********************************/
        byte a = 127; // Size: 1 byte, Range: -128 to 127
        short b = 32000; // Size: 2 bytes, Range: -32,768 to 32,767
        int c = 213456789; // Size: 4 bytes, Range: -2^31 to 2^31-1
        long d = 99999999999999L; // Size: 8 bytes, Range: -2^63 to 2^63-1

        float e = 11.12f; // Size: 4 bytes, Approx Range: ±3.4x10^-38 to ±3.4x10^38
        double f = 12345.12345; // Size: 8 bytes, Approx Range: ±1.7x10^-308 to ±1.7x10^308

        char g = 'c'; // Size: 2 bytes, Range: 0 to 65,535 (Unicode values)

        boolean h = true; // Size: 1 bit (logical values, true/false)

        /*********************************
         * Casting
         **********************************/
        // Implicit Casting (Widening)
        short i = a; // byte to short
        int j = i; // short to int
        long k = j; // int to long
        float l = k; // long to float
        double m = l; // float to double

        // Displaying values after implicit casting
        System.out.println("Implicit Casting (Widening):");
        System.out.println("Short: " + i);
        System.out.println("Int: " + j);
        System.out.println("Long: " + k);
        System.out.println("Float: " + l);
        System.out.println("Double: " + m);

        // Explicit Casting (Narrowing)
        float n = (float) l; // double to float
        long o = (long) n; // float to long
        int p = (int) o; // long to int
        short q = (short) p; // int to short
        byte r = (byte) q; // short to byte
        char s = (char) p; // int to char

        // Displaying values after explicit casting
        System.out.println("\nExplicit Casting (Narrowing):");
        System.out.println("Float: " + n);
        System.out.println("Long: " + o);
        System.out.println("Int: " + p);
        System.out.println("Short: " + q);
        System.out.println("Byte: " + r);
        System.out.println("Char: " + s);

        // Casting -Example
        // IEEE 754 floating-point standard for float and double uses exponential
        // notation,
        // allowing storage of larger values than int and long.
        // In Java, implicit type casting (widening conversion) depends on the range
        // and compatibility of data types, not just their size.
        long ll = 999999999;
        float ff = (float) ll * 9;
        double dd = (double) ll * 9;

        System.out.println("999999999 * 9 Result in: 8,99,99,99,991");
        System.out.println("Float: " + ff);
        System.out.println("Double: " + dd);

        /*********************************
         * Rules of Type Promotion
         **********************************/
        /*
         * Binary Operations:
         * - If one operand is long, the result is promoted to long.
         * - If one operand is float, the result is promoted to float.
         * - If one operand is double, the result is promoted to double.
         *
         * Unary Operations:
         * - Increment (++) or decrement (--) operations promote the operand to int
         * if it is of type byte, short, or char.
         */

        // Performing Arithmetic Operations
        // Note: All arithmetic operations involving byte/short are promoted to int by
        // default.

        int t = a + a; // byte + byte = int
        System.out.println("Sum of byte values (a + a), promoted to int: " + t);

        int u = b + b; // short + short = int
        System.out.println("Sum of short values (b + b), promoted to int: " + u);

        float v = a + a; // byte + byte = int, then promoted to float
        System.out.println("Sum of byte values (a + a), promoted to float: " + v);

        double w = a + a; // byte + byte = int, then promoted to double
        System.out.println("Sum of byte values (a + a), promoted to double: " + w);

        // Detailed Explanation:
        /*
         * 1. When performing arithmetic operations on byte/short, Java promotes the
         * values to int.
         * Hence, the result of (a + a) or (b + b) is stored in an int variable.
         *
         * 2. If the result is assigned to a float or double, the int result is further
         * promoted.
         * - Example: `float v = a + a;` => int result is converted to float.
         *
         * 3. This behavior ensures that calculations are safe and do not overflow
         * within
         * the smaller type (byte/short), but it might cause loss of precision in float
         * or double.
         */

        int x = 11;
        long y = 100l;
        long z;
        int z2;

        z = x + y; // Type Promotion
        z2 = (int) (x + y); // Explicit Casting (Narrowing)
    }
}
