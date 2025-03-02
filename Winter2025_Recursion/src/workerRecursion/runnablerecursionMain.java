package workerRecursion;

import RecursionPackage.findMax;

/**
 * The runnablerecursionMain class demonstrates the usage of the findMax class
 * by inserting temperature readings and finding the largest and smallest values.
 */
public class runnablerecursionMain {

    public static void main(String[] args) {
        // Create an instance of findMax with an array size of 7
        findMax recursionObj = new findMax(7);

        // Insert temperature readings into the array
        recursionObj.insertData(10);
        recursionObj.insertData(100);
        recursionObj.insertData(110);
        recursionObj.insertData(120);
        recursionObj.insertData(130);
        recursionObj.insertData(140);
        recursionObj.insertData(150);

        // Find and display the highest temperature in the array with tree-formatted debug output
        System.out.println("\n=== Finding Largest Temperature ===");
        System.out.println("findLargest(0,6)");
        int maxValue = recursionObj.findLargest(0, 6, "├── ");
        System.out.println("The highest temperature stored in the array is: " + maxValue);

        // Find and display the lowest temperature in the array with tree-formatted debug output
        System.out.println("\n=== Finding Smallest Temperature ===");
        System.out.println("findSmallest(0,6)");
        int minValue = recursionObj.findSmallest(0, 6, "├── ");
        System.out.println("The lowest temperature stored in the array is: " + minValue);
    }
}
