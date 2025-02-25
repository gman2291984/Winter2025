

package Runnable;

import NumericalCollectionClasses.IntBag;

public class collectionClassInAction {

	public static void main(String[] args) {
		System.out.println("Hello human... we are a collection class in action, and we work with... you guessed it... collection classes\n\n");

		IntBag bag1 = new IntBag(7);
		
		IntBag bag2 = new IntBag(10);
		
		bag1.add(1);
		bag1.add(2);
		bag1.add(3);
		bag1.add(2);
		bag1.add(4);
		bag1.add(5);
		bag1.add(2);
		
		System.out.println("\n\n");
		
		bag2.add(6);
		bag2.add(7);
		bag2.add(8);
		bag2.add(9);
		bag2.add(10);
		
		int target = 2;
		
		int instances = bag1.countInstances(target);
		
		System.out.println("Before delete - The number of instances of target data " + target + " is: " + instances + " in bag1.\n");
		
        target = 10;
		
		instances = bag2.countInstances(target);
		
		System.out.println("Before delete - The number of instances of target data " + target + " is: " + instances + " in bag2.\n");
		
		bag1.delete(2);
		bag2.delete(10);
		
		target = 2;
		
        instances = bag1.countInstances(target);
		
		System.out.println("After delete - The number of instances of target data " + target + " is: " + instances + " in bag1.\n");
		
        target = 10;
		
		instances = bag2.countInstances(target);
		
		System.out.println("After delete - The number of instances of target data " + target + " is: " + instances + " in bag2.\n");
		
	}

}
