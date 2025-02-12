package WorkerQ;

import QPackage.RegularQ;

public class runnablefifo {
    
    public static void main(String[] args) {
        System.out.println("Hello human... this is code that works with a regular queue.\n");

        RegularQ qObj = new RegularQ(8); // Create queue object with size 8
        
        qObj.Enqueue(100);
        qObj.Enqueue(200);
        qObj.Enqueue(300);
        qObj.Enqueue(400);
        qObj.Enqueue(500);
        
        qObj.displayQ(); // Display queue contents
        
        System.out.println("Dequeued: " + qObj.Dequeue()); // Dequeue one element
        
        qObj.displayQ(); // Display queue after dequeue operation
        
        qObj.prettyPrint();
    }
}
