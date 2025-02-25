
//double linked list

package linkedListPackage;

public class IntNode {
	
	//to disable the debugger comments then set false...true to see them in the console...
	private static final boolean DebuggerMODE = true;
	
     private int key;
     
     private IntNode previous, next;
     
     public IntNode(int key, IntNode previous, IntNode next) {
    	 this.key = key;
    	 this.previous = previous;
    	 this.next = next;
     }
     
     
     public void addNodeAfter(int key) {
    	 IntNode tmpRef = this.next; 
    	 
 		if (DebuggerMODE){System.out.println("\nDEBUG: Starting addNodeAfter...");
 			}
    	 
    	 this.next = new IntNode(key, this, tmpRef);
    	 
 		if (DebuggerMODE) {System.out.println("DEBUG: Key:..............." + key + "\nDEBUG: this:.............." + this +
 			"\nDEBUG: tempRef:..........." + tmpRef);
 			}
    	 
    	 if (tmpRef != null) {
 
    	     tmpRef.previous = this.next;
    	     
 	 		if (DebuggerMODE){System.out.println("DEBUG: tmpRef.previous:..." + 
	 			tmpRef.previous + "\nDEBUG: this.next:........." + this.next + "\n");
	 			}
    	     
    	 }

     }
     
     
     public void deleteNodeAfter() {
     
  		if (DebuggerMODE) {System.out.println("\nDEBUG: Starting deleteNodeAfter...");
 			}
    	 
    	 if (this.next != null) {
    	    this.next = this.next.next;
    	    
    	    if (this.next != null) {
    	       this.next.previous = this;
    	    }   
    	 } else {
      		if (DebuggerMODE) {System.out.println("DEBUG: this.next:..............." + this.next
     					+ "\nDEBUG: this.next.next:.............." + this.next.next + "\n");
     			}
    		    System.out.println("Sorry, no nodes were deleted.");
    	 }
     }
     
     
     public IntNode searchNode(int targetKey) {
    	 
   		if (DebuggerMODE){System.out.println("\nDEBUG: Starting searchNode...");	
  			}
    	 
    	 IntNode anchor = this;
    	 
    	 while (anchor != null) {
    		 
       		if (DebuggerMODE){System.out.println("DEBUG: anchor:..............." + anchor);		
      			}
    		 
    		  if (anchor.key == targetKey) {
    			  System.out.println("\nTarget node found on the right of the current node.\n");
    			  
    			  
    			  return anchor;
    		  } else {
    			      anchor = anchor.next;
    			      
      	       		if (DebuggerMODE) {System.out.println("DEBUG: anchor.key:..........." + anchor.key
      	      					+ "\nDEBUG: targetKey:............" + targetKey);		
      	      			}
    		  }
    	 }
    	 
    	 anchor = this.previous;
    	 
    	 while (anchor != null) {
    		 
        		if (DebuggerMODE) {System.out.println("DEBUG: anchor:..............." + anchor);		
          			}
    		 
   		       if (anchor.key == targetKey) {
   			      System.out.println("Target node found on the left of the current node.");
   			      
//  	       		if (DebuggerMODE == true) {//ie.DEBUG: Adding a new Node after the sequenceNumber 13
//  	      			System.out.println("DEBUG: anchor.key:..........." + anchor.key + 
//  	      					"\nDEBUG: targetKey:............" + targetKey);		
//  	      			}
   			      
   			      return anchor;
   		       } else {
   			          anchor = anchor.previous;
   			          
   	  	       		if (DebuggerMODE) {System.out.println("DEBUG: anchor.previous:..........." + anchor.previous);
   	  	      				//+	"\nDEBUG: anchor.previous:............" + anchor.previous);		
   	  	      			}
   			          
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




