import java.util.Scanner;

class Array_2D {
    public static void main(String[] args) {

        /********************************
         * // Static Initialization of 2D Array
         **********************************/
        int[][] staticArray = {
                { 1, 2 },
                { 4, 5 },
                { 7, 8 }
        };
        System.out.println("Static 2D Array:");
        for (int[] row : staticArray) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println("Number of Rows: " + staticArray.length);
        System.out.println("Number of Columns in Row 0: " + staticArray[0].length);

        /********************************
         * // Dynamic Initialization of 2D Array with User Input
         **********************************/
        System.out.println("\nDynamic 2D Array:");
        Scanner scanner = new Scanner(System.in);
        int rows = 2, cols = 4; // Defining dimensions of the array
        int[][] dynamicArray = new int[rows][cols];
        System.out.println("Enter " + (rows * cols) + " elements:");

        // Populate the array with user input
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dynamicArray[row][col] = scanner.nextInt();
            }
        }
        scanner.close();

        // Displaying
        System.out.println("Dynamic Array Contents:");
        for (int[] row : dynamicArray) {
            for (int element : row) {
                System.out.print(element + "  ");
            }
            System.out.println();
        }

        /********************************
         * // Advanced Calculations on the Array
         **********************************/
        int totalSum = 0;
        int elementCount = 0;
        int largestElement = dynamicArray[0][0];
        int smallestElement = dynamicArray[0][0];

        for (int[] row : dynamicArray) {
            for (int element : row) {
                totalSum += element;
                elementCount++;
                if (element > largestElement) {
                    largestElement = element;
                }
                if (element < smallestElement) {
                    smallestElement = element;
                }
            }
        }

        double average = (double) totalSum / elementCount;

        System.out.println("\nArray Analysis:");
        System.out.println("Sum of all elements: " + totalSum);
        System.out.println("Average of elements: " + average);
        System.out.println("Largest element: " + largestElement);
        System.out.println("Smallest element: " + smallestElement);
    }
}
