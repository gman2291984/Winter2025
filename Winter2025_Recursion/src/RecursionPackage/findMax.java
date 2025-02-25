package RecursionPackage;

/**
 * The findMax class manages an array of temperature readings
 * and provides methods to find the largest and smallest readings
 * using recursive algorithms.
 */
public class findMax {
    private int[] temperatures; // Array to store temperature readings
    private int cnt; // Counter to track the number of inserted readings

    /**
     * Constructor to initialize the temperatures array with a specified size.
     * @param size The maximum number of temperature readings the array can hold.
     */
    public findMax(int size) {
        temperatures = new int[size];
        cnt = 0;
    }

    /**
     * Inserts a new temperature reading into the array.
     * @param newTemperatureReading The temperature value to be added.
     * If the array is full, the new reading is not added.
     */
    public void insertData(int newTemperatureReading) {
        if (cnt < temperatures.length) {
            temperatures[cnt++] = newTemperatureReading;
        }
    }

    /**
     * Recursively finds the largest temperature reading in the array
     * between the specified indices.
     * @param beginning The starting index of the range to search.
     * @param end The ending index of the range to search.
     * @return The largest temperature reading in the specified range.
     */
    public int findLargest(int beginning, int end) {
        // Base case: if the range contains only one element
        if (beginning == end) {
            return temperatures[beginning];
        }

        // Calculate the midpoint of the current range
        int halfDistance = (end - beginning) / 2;

        // Recursively find the largest in the left half
        int leftLargest = findLargest(beginning, beginning + halfDistance);

        // Recursively find the largest in the right half
        int rightLargest = findLargest(beginning + halfDistance + 1, end);

        // Return the larger of the two values
        return Math.max(leftLargest, rightLargest);
    }

    /**
     * Recursively finds the smallest temperature reading in the array
     * between the specified indices.
     * @param beginning The starting index of the range to search.
     * @param end The ending index of the range to search.
     * @return The smallest temperature reading in the specified range.
     */
    public int findSmallest(int beginning, int end) {findLargest(0, 5);

        // Base case: if the range contains only one element
        if (beginning == end) {
            return temperatures[beginning];
        }

        // Calculate the midpoint of the current range
        int halfDistance = (end - beginning) / 2;

        // Recursively find the smallest in the left half
        int leftSmallest = findSmallest(beginning, beginning + halfDistance);

        // Recursively find the smallest in the right half
        int rightSmallest = findSmallest(beginning + halfDistance + 1, end);

        // Return the smaller of the two values
        return Math.min(leftSmallest, rightSmallest);
    }
}
