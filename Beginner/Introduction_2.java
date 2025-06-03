public class Introduction_2 {
    public static void main(String[] args) {
        // 1. If-Else Syntax
        /*
         * if (condition) {
         * // Code to execute if condition is true
         * } else if (anotherCondition) {
         * // Code to execute if anotherCondition is true
         * } else {
         * // Code to execute if none of the above conditions are true
         * }
         */
        int num = 10;
        if (num == 0) {
            System.out.println("The number is zero.");
        } else if (num < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is positive.");
        }

        // 2. Ternary Operator Example
        int a = 5, b = 10;
        int max = (a > b) ? a : b; // Syntax: (condition) ? valueIfTrue : valueIfFalse;
        System.out.println("The larger number is: " + max);

        // 3. Switch Case Syntax
        /*
         * switch (expression) {
         * case value1:
         * // Code to execute if expression equals value1
         * break;
         * case value2:
         * // Code to execute if expression equals value2
         * break;
         * default:
         * // Code to execute if no case matches
         * }
         */
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // 4. For Loop Syntax
        /*
         * for (initialization; condition; increment/decrement) {
         * // Code to execute in each iteration
         * }
         */
        for (int i = 0; i < 5; i++) {
            System.out.println("For loop iteration: " + i);
        }

        // 5. While Loop Syntax
        /*
         * while (condition) {
         * // Code to execute as long as condition is true
         * }
         */
        int count = 0;
        while (count < 5) {
            System.out.println("While loop count: " + count);
            count++;
        }

        // 6. Do-While Loop Syntax
        /*
         * do {
         * // Code to execute at least once
         * } while (condition);
         */
        int num2 = 0;
        do {
            System.out.println("Do-while loop count: " + num2);
            num2++;
        } while (num2 < 5);

        // 7. Enhanced For Loop Syntax (For-Each Loop)
        /*
         * for (type variable : collection) {
         * // Code to execute for each element
         * }
         */
        int[] numbers = { 1, 2, 3, 4, 5 };
        for (int n : numbers) {
            System.out.println("Enhanced for loop value: " + n);
        }

        // 8. Loop with Keywords
        /*
         * The continue keyword is used to skip the current iteration of a loop and
         * immediately jump to the next iteration. It does not terminate the loop
         * entirely.
         * The break keyword is used to terminate the entire loop immediately. Once
         * break is executed, the loop stops, and the program's execution continues with
         * the statement immediately following the loop.
         */
        a = 1;
        while (a != 12) {
            if (a == 7) {
                a++;
                System.out.println("Continue");
                continue;
            }

            System.out.println(a);
            a++;

            if (a == 9) {
                System.out.println("Break");
                break;
            }
        }
        // Difference between continue, break and return?
    }
}
