// Define the package where the class belongs
package library;

// Real-world applications -- undo & redo functionality, history logs in a browser, 
// music and media players, OS task scheduling...

// Train Analogy:
// Each train car is a node in the linked list.
// Each car has a connector (link), pointing to the next car.
// The engine is the head, like the head node.
// There is no direct link to the previous car, unlike a doubly linked list (DLL); you can only go forward.
// The last car (the caboose) has no outgoing connection, just like the last node in an SLL; it points to null.
// Adding a new car is like inserting a node at the end or between existing cars.
// Removing a car is like deleting a node from the list.
// Traversing or looping through the list is like moving from the engine to the last car without going back.

public class IntNode {
    
    @Override
    public String toString() {
        return "[Key: " + sequenceNumber + ", Data: " + data + "]";
    }

    // To disable the debugger comments, set false. Set to true to see them in the console.
    private static final boolean DebuggerMODE = true;

    // Precondition:
    // Postcondition: All instance variables of the IntNode class are initialized.
    private int sequenceNumber; // The unique identifier (key) of the train car.
    private int data; // The payload or contents of the train car.
    private IntNode link; // Pointer to the NEXT node in the linked list.

    // Constructor: Initializes a new node with a sequenceNumber, data, and a link to the next node.
    public IntNode(int initialSequenceNumber, IntNode initialLink, int initialData) {
        this.sequenceNumber = initialSequenceNumber; // Assign sequence number.
        this.link = initialLink; // Connect to the next node.
        this.data = initialData; // Store data payload.
    }

    // =============================
    // Method: addNodeAfter
    // Precondition: This instance of the IntNode class exists.
    // Postcondition: A new node with the given key and data is added right after this node.
    // =============================
    public void addNodeAfter(int data, int key) {
        if (DebuggerMODE) {
        	System.out.println("\n[DEBUG] ~METHOD START: addNodeAfter()~");
        	System.out.println("------------------------------------------");
            System.out.println("[DEBUG] Adding new Node after " + this + " → [Key: " + key + ", Data: " + data + "]\n");
        }
        this.link = new IntNode(key, this.link, data);
        if (DebuggerMODE) {
            System.out.println("[DEBUG] New Node added! Next Node is now " + this.link + "\n");
        }
    }

    // =============================
    // Method: removeNodeAfter
    // Precondition: This instance of the IntNode class exists.
    // Postcondition: The specific node that comes immediately after this node is removed.
    // =============================
    public void removeNodeAfter() {
        if (DebuggerMODE) {
        	System.out.println("\n[DEBUG] ~METHOD START: removeNodeAfter()~");
        	System.out.println("------------------------------------------");
            System.out.println("[DEBUG] Removing node after " + this + "\n");
        }
        
        if (this.link == null) {
            if (DebuggerMODE) {
                System.out.println("[DEBUG] No node to remove after " + this + " (Next node is null)\n");
            }
            return;
        }
        
        if (DebuggerMODE) {
            System.out.println("[DEBUG] Removing node: " + this.link + "\n");
        }
        this.link = this.link.link;
        if (DebuggerMODE && this.link != null) {
            System.out.println("[DEBUG] Next node is now " + this.link + "\n");
        }
    }

    // =============================
    // Method: displayNodeData
    // Precondition: The linked list contains at least one element.
    // Postcondition: The (sequence number, data) pairs of each node in the linked list are displayed.
    // =============================
    public void displayNodeData(IntNode head) {
        if (DebuggerMODE) {
        	System.out.println("\n[DEBUG] ~METHOD START: displayNodeData()~");
        	System.out.println("------------------------------------------");
            System.out.println("[DEBUG] Displaying linked list data:\n");
        }
        
        System.out.print("[DEBUG] Current List: ");
        IntNode current = head;
        while (current != null) {
            System.out.print(current + " → ");
            current = current.link;
        }
        System.out.println("NULL\n");
    }

    // =============================
    // Method: findPrevious
    // Precondition: The linked list contains at least one element.
    // Postcondition: The previous node before the target node is returned, or null if not found.
    // =============================
    public IntNode findPrevious(IntNode head, int target) {
        if (DebuggerMODE) {
        	System.out.println("\n[DEBUG] ~METHOD START: findPrevious()~");
        	System.out.println("------------------------------------------");
            System.out.println("[DEBUG] Searching for pre-existing node for: Target " + target + "\n");
        }
        
        IntNode current = head;
        while (current.link != null) {
            if (current.link.sequenceNumber == target) {
                if (DebuggerMODE) {
                    System.out.println("[DEBUG] Found pre-existing node: " + current + " before target " + target + "\n");
                }
                return current;
            }
            current = current.link;
        }
        
        if (DebuggerMODE) {
            System.out.println("[DEBUG] No pre-existing node found for: Target " + target + "\n");
        }
        return null;
    }

    // =============================
    // Method: locatePredecessor
    // Precondition: The linked list contains at least one element.
    // Postcondition: Returns the predecessor node where the new node should be inserted.
    // =============================
    public IntNode locatePredecessor(IntNode head, int target) {
        if (DebuggerMODE) {
        	
        	System.out.println("\n[DEBUG] ~METHOD START: locatePredecessor()~");
        	System.out.println("------------------------------------------");
            System.out.println("[DEBUG] Locating predecessor for target " + target + "\n");
        }
        
        IntNode current = head;
        while (current.link != null && current.link.sequenceNumber < target) {
            current = current.link;
        }
        
        if (DebuggerMODE) {
            System.out.println("[DEBUG] Predecessor found: " + current + "\n");
        }
        return current;
    }

    // =============================
    // Method: getsequenceNumber
    // Precondition: This instance of the IntNode class exists.
    // Postcondition: The sequenceNumber of this node is returned.
    // =============================
    public int getsequenceNumber(boolean detectionFlg) {
        detectionFlg = false;
        return this.sequenceNumber;
    }

    // =============================
    // Method: getLink
    // Precondition: This instance of the IntNode class exists.
    // Postcondition: The link of this node is returned.
    // =============================
    public IntNode getLink() {
        return this.link;
    }
}
