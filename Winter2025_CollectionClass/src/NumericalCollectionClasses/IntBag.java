package NumericalCollectionClasses;


/*
Methods --	What It Does:
====================
IntBag(size): Initializes an empty array of size size. Throws error if size < 2.
add(item): Adds item to the next available position. Throws error if full.
countInstances(target):	Counts how many times target appears in the array.
delete(target):	Removes the first occurrence of target. Replaces it with the last valid element.
 */


public class IntBag {

    private int[] sack; // Array to store integers
    private int size; // Maximum size of the array
    private int counter; // Tracks the number of elements in the array
    
    /**
     * Constructor to initialize the IntBag with a given size.
     * 
     * @param size The maximum number of elements the bag can hold.
     * @throws IllegalArgumentException if size is less than 2.
     */
    public IntBag(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Bob, wake up!! Your array size is not compliant with the precondition of this method");
        }
        
        this.size = size;
        sack = new int[size]; // Initialize array
        counter = 0; // Start with an empty bag     
    }
    
    /**
     * Adds an integer to the bag.
     * 
     * @param item The integer to add.
     * @throws IllegalArgumentException if the array is full.
     */
    public void add(int item) {

        // Prevent overflow by checking if the array is full
        if (counter == this.size) {
            throw new IllegalArgumentException("The array index is out of bounds. Unable to insert new data in the collection class.");
        }
        sack[counter++] = item; // Store item and increment counter
    }   //DEBUG: Adding an Item into the bag. The item is: 1. The bag's current size is: 1 out of 7
    
    /**
     * Counts the number of times a target integer appears in the bag.
     * 
     * @param target The integer to count occurrences of.
     * @return The number of times the target appears in the bag.
     */
    public int countInstances(int target) {
        int occurrences = 0;
        int scanIndex = 0; 
        
        // Loop through the array up to the number of inserted elements
        while (scanIndex < counter) {
            if (sack[scanIndex] == target) {
            	//check if the item is the target... ie is the item in array [0] the target?
                occurrences++;   
            }
            scanIndex++;//increment          
        }        
        return occurrences;             
    }
    
    /**
     * Deletes the first occurrence of a target integer in the bag.
     * 
     * @param target The integer to remove.
     * @return true if deletion was successful, false if target was not found.
     */
    public boolean delete(int target) {
        int scanIndex = 0;
        // If the bag is empty, return false
        if (counter == 0) {      	
            return false;  
        }
        
        // Search for the target element
        while (scanIndex < counter) {
            if (sack[scanIndex] == target) {
                // Replace the deleted element with the last valid element
                sack[scanIndex] = sack[--counter];
                return true; // Deletion successful	
            }
            scanIndex++;
        }      
        return false; // Target not found
    }
}
