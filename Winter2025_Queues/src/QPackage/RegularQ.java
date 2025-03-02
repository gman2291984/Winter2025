package QPackage;

/*A queue is a linear data structure that follows the FIFO (First-In-First-Out) principle, 
 * meaning elements are added at one end (rear/tail) and removed from the other end (front/head).*/

//The FIFO policy emulates a line of customers waiting to pay a cashier...

//the example below is Circular queue because of modulo operation.


public class RegularQ {
	
	private static final boolean DEBUG = true; // Set to true to enable debug messages, false to disable
	
    private int[] Q; // Array to store queue elements
    private int head, tail; // Head and tail pointers
    private int QSize; // Maximum size of the queue
    
    public RegularQ(int QSize) {
        Q = new int[QSize]; // Initialize queue array
        this.QSize = QSize; // Set queue size
        tail = 0; // Tail starts at 0
        head = -1; // Head starts at -1 to indicate an empty queue
    }
    
    public void Enqueue(int input) {//The enqueue operation adds an element to the rear (tail) of the queue.
    	//If the queue is full (in a fixed-size implementation), the enqueue operation may fail or overwrite data in a circular queue.
    	
    	if (DEBUG) System.out.println("Starting Enqueue...");
    	
        Q[tail] = input; // Insert element at tail
        tail = ++tail % QSize; // Circular increment of tail using modulo
        //tail = ++tail % 8 = (0+1) % 8 = 1
        //tail = ++tail % 8 = (1+1) % 8 = 2...etc...
        //tail = ++tail % 8 = (7+1) % 8 = 0 --> wrap around will occur
        if (head == -1) { // If queue was empty, set head to 0
            head = 0;
        }
        if (DEBUG) System.out.println("Adding: [" + input + "] to the queue\n");
    }
    
    public int Dequeue() {//The dequeue operation removes an element from the front (head) of the queue.
        //If the queue is empty, an error message or exception should be handled.
    	
    	if (DEBUG) System.out.println("Starting Dequeue...\n");
    	
    	int data = 0;
        
        if (head != -1) { // Check if queue is not empty
            data = Q[head]; // Retrieve element from head
            if (DEBUG) System.out.println("Deleting: " + data + " from the head");
            head = ++head % QSize; // Circular increment of head using modulo
            if (DEBUG) System.out.println("The head is now in position: " + head + " of " + QSize + "\n");
            return data;
        } else {
            System.out.println("The queue is empty"); // Error message when queue is empty
        }
        
        return data; // Return data (0 if empty)
    }
    
    public void displayQ() {
    	  
    	    System.out.print("Here is the Queue: ");
    	    
    	    for (int i = 0; i < QSize; i++) {
    	        if (i == head && i == tail) {
    	            System.out.print("[h/t] "); // Case where head and tail are at the same position
    	        } else if (i == head) {
    	            System.out.print("[h" + Q[i] + "] "); // Mark head position
    	        } else if (i == tail) {
    	            System.out.print("[t] "); // Mark tail position
    	        } else if (i >= head && i < tail || (head > tail && (i >= head || i < tail))) {
    	            System.out.print("[" + Q[i] + "] "); // Occupied positions
    	        } else {
    	            System.out.print("[] "); // Empty positions
    	        }
    	    }
    	    
    	    System.out.println("\nThe head is now in position: " + head + " of " + QSize);
    	    System.out.println("The tail is now in position: " + tail + " of " + QSize + "\n");
    	}
}

	