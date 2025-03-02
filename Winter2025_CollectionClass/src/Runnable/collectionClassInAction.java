package Runnable; // Declares the package name, grouping related classes together.

import NumericalCollectionClasses.IntBag; // Imports the IntBag class from the NumericalCollectionClasses package.

public class collectionClassInAction { // Defines the main class.

	public static void main(String[] args) { // Main method, the entry point of the program.
		System.out.println("Hello human... we are a collection class in action, and we work with... you guessed it... collection classes\n\n");
        // Prints an introductory message to the console.

		IntBag bag1 = new IntBag(7); // Creates an instance of IntBag with an initial size of 7.
		
		IntBag bag2 = new IntBag(10); // Creates another instance of IntBag with an initial size of 10.
		
		// Adds elements to bag1
		bag1.add(1);
		bag1.add(2);
		bag1.add(3);
		bag1.add(2);
		bag1.add(4);
		bag1.add(5);
		bag1.add(2);
		
		System.out.println("\n\n"); // Prints empty lines for spacing.
		
		// Adds elements to bag2
		bag2.add(6);
		bag2.add(7);
		bag2.add(8);
		bag2.add(9);
		bag2.add(10);
		
		int target = 2; // Specifies the target value to search for in bag1.
		
		int instances = bag1.countInstances(target); // Counts occurrences of '2' in bag1.
		
		System.out.println("Before delete - The number of instances of target data " + target + " is: " + instances + " in bag1.\n");
        // Displays the count of target value (2) in bag1 before deletion.

        target = 10; // Changes the target to 10 for bag2.
		
		instances = bag2.countInstances(target); // Counts occurrences of '10' in bag2.
		
		System.out.println("Before delete - The number of instances of target data " + target + " is: " + instances + " in bag2.\n");
        // Displays the count of target value (10) in bag2 before deletion.

		bag1.delete(2); // Deletes all occurrences of '2' from bag1.
		bag2.delete(10); // Deletes all occurrences of '10' from bag2.
		
		target = 2; // Resets the target value to check bag1 again.
		
        instances = bag1.countInstances(target); // Counts occurrences of '2' in bag1 after deletion.
		
		System.out.println("After delete - The number of instances of target data " + target + " is: " + instances + " in bag1.\n");
        // Displays the count of target value (2) in bag1 after deletion.

        target = 10; // Changes target to 10 to check bag2 again.
		
		instances = bag2.countInstances(target); // Counts occurrences of '10' in bag2 after deletion.
		
		System.out.println("After delete - The number of instances of target data " + target + " is: " + instances + " in bag2.\n");
        // Displays the count of target value (10) in bag2 after deletion.
		
	} // End of main method

} // End of class





















