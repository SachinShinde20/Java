package Basics;

import java.util.Arrays;

public class ArraysClass {
    public static void main(String[] args) {

        // Demonstrate array equality check
        System.out.println("Checking Array Equality...");
        int[] firstArray = {11, 29, 23, 14};
        int[] secondArray = {29, 11, 14, 23};

        // Check equality without sorting (order matters)
        System.out.println("Are arrays equal before sorting? " + Arrays.equals(firstArray, secondArray));

        // Sort both arrays and check equality again
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        System.out.println("Are arrays equal after sorting? " + Arrays.equals(firstArray, secondArray));

        // Demonstrate usage of Arrays.binarySearch()
        System.out.println("\nUsing Arrays.binarySearch:");
        System.out.println("Sorted firstArray: " + Arrays.toString(firstArray));

        // Search for a value that does not exist (returns insertion point as negative)
        System.out.println("Index of 30 in firstArray: " + Arrays.binarySearch(firstArray, 30));
        // Search for an existing value
        System.out.println("Index of 23 in firstArray: " + Arrays.binarySearch(firstArray, 23));

        // Demonstrate copying an array with a larger size
        System.out.println("\nCopying array with new length:");
        int[] extendedArray = Arrays.copyOf(firstArray, firstArray.length * 2);
        System.out.println("Extended array: " + Arrays.toString(extendedArray));

        // Demonstrate filling an array with a single value
        System.out.println("\nFilling an array:");
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 101);
        System.out.println("Filled array: " + Arrays.toString(filledArray));

        // Multi-dimensional array operations
        System.out.println("\nMulti-dimensional Array:");
        int[][] multiDimensionalArray = {
                {11, 2, 9, 5},
                {24, 12, 32, 11},
                {9, 2, 4, 1}
        };

        // Print original multi-dimensional array rows
        System.out.println("Original array:");
        for (int[] row : multiDimensionalArray) {
            System.out.println(Arrays.toString(row));
        }

        // Sort each row and print again
        System.out.println("After sorting each row:");
        for (int i = 0; i < multiDimensionalArray.length; i++) {
            Arrays.sort(multiDimensionalArray[i]);
            System.out.println(Arrays.toString(multiDimensionalArray[i]));
        }
    }
}
