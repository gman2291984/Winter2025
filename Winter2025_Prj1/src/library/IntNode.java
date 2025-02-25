package library;


//real world applications -- undo & redo functionality, history logs in a browser, music and media players, OS task scheduling...

//notes: void doesnt return anything.

	//Train Analogy:
        //each train car is a node in the linked list
		//each car has a connector, link, pointing to the next car
		//the engine is the head like the head node
		//there is no direct link to the previous car like in a double linked list (DLL), you can only go forward...
		//the last car , the caboose, had no outgoing connection, just like the last node in an SLL. it points to null!
		//adding a new car is like inserting a node at the end or between existing cars
		//removing a car is like deleting a node from the list
		//traversing or looping through the list is like moving from the engine to the last car without going forward...




public class IntNode {

	//to disable the debugger comments then set false...true to see them in the console...
	private static final boolean DebuggerMODE = true;

	// Precondition:
	// Postcondition: All instance variables of the IntNode class are initialized.
	private int sequenceNumber; //the TCP sequence number -- the "key" -- unique ID of the train car
	private int data; //the packet's data -- the "pay load" -- contents of the train car
	private IntNode link; //the 'pointer' -- points to the NEXT node in our linked list -- the connector between the train cars

	
	//Constructor -- this initializes a new node with a sequenceNumber, data, and a link to the next node
	//Train analogy: initializes a new train car with a number, a link to the next car, and its contents
	public IntNode(int initialSequenceNumber, IntNode initialLink, int initialData) {
		
		this.sequenceNumber = initialSequenceNumber; //set the sequenceNumber -- assign a number to the train car (e.g. #1...)
		this.link = initialLink; // link this node to the next node in our list -- connect this train car to the next one
		this.data = initialData; // stores the packet's data --store the cargo/data into the train car

	}

	// Precondition: This instance of the IntNode class exists.
	// In other words, the object whose method is activated exists as a node in the linked list. 
	// Postcondition: A new node with attributes item and data is created. Item serves as sequenceNumber.
	// The new node is added to the linked list at a position that comes immediately after the node whose method is activated.	
	//A new node w/attributes -- (sequneceNumber, data) is added right after this node
	//train analogy: a new train car/node is added right after this train car
	public void addNodeAfter(int data, int item) {
		
		if (DebuggerMODE == true) {
		System.out.println("DEBUG: Starting addNodeAfter... \n");
		}
		
		if (DebuggerMODE == true) {//ie.DEBUG: Adding a new Node after the sequenceNumber 13
		System.out.println("DEBUG: Adding a new Node after the sequenceNumber " + this.sequenceNumber + "\n");
		
		//ie.DEBUG: The new Node's is:  (sequenceNumber: 17, data: 847897267)
		System.out.println("DEBUG: The new Node's is:  (sequenceNumber: " + item + ", data: " + data + ")\n");
		}
		
		this.link = new IntNode(item, this.link, data); //Insert a new node after  the current node -- insert a new train car after the current car
		
		if (DebuggerMODE == true) {//ie.DEBUG: The new Node was added! The next Node is now going to be sequenceNumber: 17
		System.out.println("DEBUG: The new Node was added! The next Node is now going to be sequenceNumber: " + this.link.sequenceNumber + "\n");
		}
		
	}
	
	
	// Precondition: This instance of the IntNode class exists.
	// In other words, the object whose method is activated exists as a node in the linked list. 
	// Postcondition: The specific node, which comes immediately after the node whose method is activated, 
	// is removed from the linked list.
	//The node  right after this node is removed from the list
	//train analogy: the train car/node right after this one is removed
	public void removeNodeAfter() {
		
		if (DebuggerMODE == true) {
		System.out.println("DEBUG: Starting removeNodeAfter... \n");
		}
		
		if(this.link == null) {
			
			if (DebuggerMODE == true) {//
			System.out.println("DEBUG: No Node to remove after sequenceNumber " + this.sequenceNumber + "The next Node is null)\n");
			}
			return;
		}
		
		if (DebuggerMODE == true) {//DEBUG: ***DUPLICATE FOUND!*** Removing the Node after sequenceNumber 16 (Target Node: 17)
			System.out.println("DEBUG: ~Found duplicate Node!~ Removing the Node after sequenceNumber " + this.sequenceNumber + " (Target Node: " + this.link.sequenceNumber + ")\n");
		}
		
		
			this.link = this.link.link; // skips the next node -- esssentially deleting by setting to null -- Unhook the next car and remove it from the train..bye bye, sooo long :)~
		
			
			
		if(this.link != null) { //if theres a next node, then remove it -- if theres another train car ahead, then
			
			if (DebuggerMODE == true) {//
			System.out.println("DEBUG: The Next Node after sequnceNumber " + this.sequenceNumber + " is "+ this.link.sequenceNumber +"\n");
			}
			
		} else {
			if (DebuggerMODE == true) {//DEBUG: The Node after sequenceNumber 13 is now Null. So this is the end of the list
			System.out.println("DEBUG: The Node after sequenceNumber " + this.sequenceNumber + " is now Null. So this is the end of the list\n");
			}
		}
	}
	
	
	
	// Precondition: This instance of the IntNode class exists.
	// Postcondition: The sequenceNumber of this node is returned, after setting detectionFlag to false.
	//the sequenceNumber is returned
	//train analogy: return the train car ID number
	public int getsequenceNumber(boolean detectionFlg) {
		
		detectionFlg = false;
		
		return this.sequenceNumber; //returns sequenceNumber of the current node --  return the number/ID of the current train car
		
	}
	
	// Precondition: This instance of the IntNode class exists.
	// Postcondition: The link of this node is returned.	
	//returns the next node in teh linked list
	//train analogy: return the next train car in the linked list
	public IntNode getLink() {
		
		return this.link; // return the next node's 
		
	}
	
	// Precondition: The linked list contains at least one element.
	// Postcondition: The (sequence number, data) pairs of each node in the linked list, starting with the head,
	// are displayed on the monitor. 
	//prints out the sequenceNumbers and data for each node
	//train analogy: prints out the seqNum/ID and date/cargo of all the train cars
	public void displayNodeData(IntNode head) {
		
		if (DebuggerMODE == true) {
		System.out.println("DEBUG: Starting displayNodeData... \n");
		}
		
		System.out.print("The (sequence number, data) pairs in the linked list are: ");
		
		IntNode current = head; //start from the head of our linked list -- start from the engine/head node
		
		while (current != null) { //loop through each node in the our list -- travel the train (SLL) until the last car/caboose
			
			//ie.The (sequence number, data) pairs in the linked list are: (13, 308329763) (14, 295106305) (15, 325615905) (16, 652976466) 
			System.out.print("(" + current.sequenceNumber + ", " + current.data + ") "); //print out data for the user to read -- print each train cars details
			
			current = current.link; //moves to the next node -- move to the next train car
			
		}
		
		System.out.println("\n\n\n"); //prints new lines for extra space, helps the debugger print out look better.
		
		
	}
	
	// Precondition: The head of the linked list is different than null, and its sequenceNumber is different than target.
	// Postcondition: The link to the specific node, which comes before the node whose sequenceNumber is equal to target, 
	// is returned. If the linked list does not contain a node with sequenceNumber equal to target, then null is returned.  
	//the previous node (before the target) is returned or null if the target is not found
	//train analogy: finds the train car/node just before the target train car
	public IntNode findPrevious(IntNode head, int target) {
		
		if (DebuggerMODE == true) {
		System.out.println("DEBUG: Starting findPrevious... \n");
		}
		
		IntNode current = head; //start from the head of our list -- start from the engine
		
		while (current.link != null) { //loop through the list until the last node is reached... last node ='s null... doesnt 'point' to anything -- travel the train until last train car
			
			if (DebuggerMODE == true) {
			System.out.println("DEBUG: Traversing the link list searching for previous Node. Current Node: (Sequence: " + current.sequenceNumber + "), Next Node: (Sequence: " + current.link.sequenceNumber + "), Target: (" + target + ")\n");
			}
			
			if (current.link.sequenceNumber == target) { //if the node has the target, then... -- if the next car is the target, then

				if (DebuggerMODE == true) {
				System.out.println("DEBUG: ~Found previous Node!~ Current Node: (Sequence: " + current.sequenceNumber + ") is before target (Sequence: " + target + ")\n");
				}
				
				return current; //return the the current node because its the predecessor -- return the current car (predecessor)
				
			}
			
			current = current.link; //moves to the next node -- move to the next train car
			
		}
		
		if (DebuggerMODE == true) {
		System.out.println("DEBUG: No Pre-existing node found for target in the list (Sequence: " + target + ")\n");
		}
		
		return null; //if no node with the target sequenceNumber is found, then return null -- return null bc target in no in the train
		
	}
	
	
	// Precondition: The head of the linked list is different than null, and its sequenceNumber is smaller than target.
	// Postcondition: The link to the specific node, which comes before the node that is the first in the linked list 
	// to have a sequenceNumber greater than target, is returned. 
	// If no such node is found, the link to the last node in the linked list is returned. 
	//the node before the correct insertion position is returned
	//train analogy: finds the correct position for inserting a new train car based on sequenceNumber/ID
	public IntNode locatePredecessor (IntNode head, int target) {
		
		if (DebuggerMODE == true) {
		System.out.println("DEBUG: Starting locatePredecessor. Searching for the correct insertion location for sequenceNumber: " + target + "\n");
		}
		
		IntNode current = head; // start from the head of the list -- start at the engine
		
		while (current.link != null && current.link.sequenceNumber < target) { //loop through while the next node has a lower sequenceNumber -- keep walking the train while the next car has a lower ID
			
			if (DebuggerMODE == true) {
			System.out.println("DEBUG: Traversing the link list to locatePrecessor... Current Node: (Sequence: " + current.sequenceNumber + ") Next Node: (Sequence; " + current.link.sequenceNumber + "), Target: (" + target + ")\n");
			}
			
			current = current.link; //move to the next node -- move to the next train car
			
		}

		
		if (current.link != null) {
			
			if (DebuggerMODE == true) {
			System.out.println("DEBUG: ~Found predeccesor!~ Inserting Before the Node with the sequenceNumber: " + current.link.sequenceNumber + " and after the Node with the sequenceNumber: " + current.sequenceNumber+ ")\n");
			}
		} else {
			
		}
			if (DebuggerMODE == true) {
			 System.out.println("DEBUG: ~Found predeccesor!~ Inserting at the end after Node with the sequenceNumber: " + current.sequenceNumber + "\n");
			}
		
		return current; //return the node before where the new node should be inserted -- return the train car before where the new one should be inserted
		
	}
	
	
} //end of IntNode Class


	
























































