//define the package where the class belongs
package intrustionDetectorClass;

//Imports the IntNode class from the library package that we made
import library.IntNode;

//this defines the main class
public class runnableintrusionDetectorClass {

	//static = belongs to the class not the instance - shared amongst all instances.
	//static variable "head" is the first node of the linked list that we'll be making/running
	static IntNode head = null;
	
	
	public static void main(String[] args) {
		
		System.out.println("Prj1 is running.\n");
		
		//we initialize the linked list with a single node.
		//sequenceNumber = 13, data = 230185386
		head = new IntNode(13, head, 230185386);
		
		//this displays the node's data
	    head.displayNodeData(head);
		
	    //removing and adding nodes while preserving the order
	    //Tries to remove the node with the sequenceNumber 13
	    removeDuplicate(13);
	    
		if (head != null)
	       head.displayNodeData(head);
		else
		{
		   //System.out.print("The linked list is empty.\n");
		   //System.out.print(" \n");
		}
		
		//add Node with the sequenceNumber 13, data 308329763
		//the same logic applies for the others
		addNodeInOrder(13, 308329763);
	    head.displayNodeData(head);
	    
		removeDuplicate(14); 
	    head.displayNodeData(head);
		addNodeInOrder(14, 248041794);
	    head.displayNodeData(head);

		removeDuplicate(14); 
	    head.displayNodeData(head);
		addNodeInOrder(14, 295106305);
	    head.displayNodeData(head);
	    
		removeDuplicate(15); 
	    head.displayNodeData(head);
		addNodeInOrder(15, 325615905);
	    head.displayNodeData(head);
	    
		removeDuplicate(16); 
	    head.displayNodeData(head);
		addNodeInOrder(16, 652976466);
	    head.displayNodeData(head);
	    
		removeDuplicate(17); 
	    head.displayNodeData(head);
		addNodeInOrder(17, 847897267);
	    head.displayNodeData(head);

		removeDuplicate(17); 
	    head.displayNodeData(head);
		addNodeInOrder(17, 927847798);
	    head.displayNodeData(head);
	  
	    //printout a completion message
	    System.out.println("End of run.\n");
	    
	}
	
	
	//This removes a node with the given sequenceNumber (target) from the linked list. 
	//ensures uniqueness so there arent 2 nodes w the same  seq number ie (13,1111111)->(13,2222222) = no bueno!!
	 //Return updates head of the linked list.
	public static IntNode removeDuplicate(int target)   
	{
	    if (head == null)
	    	//if the list is empty then return
	    	return head;
		
		System.out.println("[DEBUG] Running removeDuplicate() on target " + target + " ensuring its not already in the linked list...Sending to findPrevious(IntNode head, int target)\n");
		
		IntNode previous = null;
		
		
		//if the target is at the head then update the head pointer
	    if (target == head.getsequenceNumber(true))
	    {
	    	head = head.getLink();
	    }	
	    else
	    	//locate the previous node before the target node
	        previous = head.findPrevious(head, target);
	    
	    //remove the target node if found
	    if (previous != null) 
	        previous.removeNodeAfter();
	    	    
	    return head;
	} 
	
	

	// The new node is added to the linked list so that its sequenceNumber preserves the ascending order of the linked list
	// relative to the sequenceNumber.
	public static IntNode addNodeInOrder(int target, int data)   
	{
        IntNode previous = null;
		
        System.out.println("[DEBUG] Running addNodeInOrder() on target " + target + " and data " + data + "...Sending to locatePredecessor(IntNode head, int target)\n");
        
        //if the list is empty then create the first Node
        if (head == null)
        {
           head = new IntNode(target, head, data);	
           return head;	
        }
        
        //if the target should be the new head (the smallest sequenceNumber)
        if (target < head.getsequenceNumber(true))
        	head = new IntNode(target, head, data);
        else
        	//finds the predecessor node where the new node should be inserted
		    previous = head.locatePredecessor(head, target);
		
        //inserts the new node at the correct location
		if (previous != null)
		   previous.addNodeAfter(data, target);
		
		
		//returns updated head
		return head;
	}

}


































