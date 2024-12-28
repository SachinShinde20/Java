public class Array_JaggedArray {
    public static void main(String[] args) {

        int[][] jaggedArray = new int[3][];
        jaggedArray[0] = new int[4]; // Row 0 with 4 Columns
        jaggedArray[1] = new int[2]; // Row 1 with 2 Columns
        jaggedArray[2] = new int[3]; // Row 2 with 3 Columns

        // Adding Random Elements to the Array
        System.out.println("Adding Elements to the Jagged Array:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = (int) (Math.random() * 100) + 10; // (e.g., 10 to 100)
            }
        }

        // Displaying the Elements of the Jagged Array
        System.out.println("\nDisplaying Elements of the Jagged Array:");
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
