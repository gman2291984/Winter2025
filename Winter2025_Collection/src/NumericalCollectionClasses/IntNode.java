package linkedListPackage;

public class IntNode {
     private int key;
     
     private IntNode previous, next;
     
     public IntNode(int key, IntNode previous, IntNode next) {
    	 this.key = key;
    	 this.previous = previous;
    	 this.next = next;
     }
     
     
     public void addNodeAfter(int key) {
    	 IntNode tmpRef = this.next; 
    	 
    	 this.next = new IntNode(key, this, tmpRef);
    	 
    	 if (tmpRef != null) {
    	     tmpRef.previous = this.next;
    	 }
    	 
     }
     
     
     public void deleteNodeAfter() {
     
    	 if (this.next != null) {
    	    this.next = this.next.next;
    	    
    	    if (this.next != null) {
    	       this.next.previous = this;
    	    }   
    	 } else {
    		    System.out.println("Sorry, no nodes were deleted.");
    	 }
     }
     
     
     public IntNode searchNode(int targetKey) {
    	 IntNode anchor = this;
    	 
    	 while (anchor != null) {
    		  if (anchor.key == targetKey) {
    			  System.out.println("Target node found on the right of the current node.");
    			  return anchor;
    		  } else {
    			      anchor = anchor.next;
    		  }
    	 }
    	 
    	 anchor = this.previous;
    	 
    	 while (anchor != null) {
   		       if (anchor.key == targetKey) {
   			      System.out.println("Target node found on the left of the current node.");
   			      return anchor;
   		       } else {
   			          anchor = anchor.previous;
   		       }
   	     }
    	 
    	 System.out.println("Target node not found.");
    	 
    	 return null;
     }
     
     
     public int countNodes() {
    	 IntNode countAnchor = this;
    	 
    	 int count = 0;
    	 
    	 while (countAnchor != null) {
    		 count++;
    		 countAnchor = countAnchor.next;
    	 }
    	 
    	 countAnchor = this.previous;
    	 
    	 while (countAnchor != null) {
    		 count++;
    		 countAnchor = countAnchor.previous;
    	 }
    	 
    	 return count;
     }
     
}




