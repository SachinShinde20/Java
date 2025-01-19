class Array_1D {
    public static void main(String[] args) {
        // Method 1: Direct Initialization
        int[] array1 = { 1, 2, 3, 4 };
        System.out.println("Array (Direct Initialization): " + array1);
        System.out.println("(Method 1):");
        for (int element : array1) {
            System.out.println(element);
        }

        // Method 2: Anonymous Array Initialization
        System.out.println("\nArray (Anonymous Initialization):");
        int[] array2;
        array2 = new int[] { 1, 2, 3, 4 };
        System.out.println("(Method 2):");
        for (int element : array2) {
            System.out.println(element);
        }

        // Method 3: Dynamic Initialization
        System.out.println("\nArray (Dynamic Initialization):");
        int[] array3 = new int[4]; // Array of size 4 with default values (0s).
        for (int i = 0; i < array3.length; i++) {
            array3[i] = i * 2; // Assigning values dynamically (even numbers).
        }
        System.out.println("(Method 3):");
        for (int element : array3) {
            System.out.println(element);
        }
    }
}
