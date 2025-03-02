// Double linked list implementation in Java
package linkedListPackage; // Defines the package name for organizational purposes.

public class IntNode { // Defines the class representing a node in a doubly linked list.

    @Override
    public String toString() { // Overrides the toString() method to provide a readable representation of the node.
        return "[Key: " + key + "]"; // Returns a string showing the key value of the node.
    }

    // Debugger mode flag: Set to 'true' to enable debug messages.
    private static final boolean DebuggerMODE = true; 

    private int key; // Stores the unique value (key) of the node.
    private IntNode previous, next; // Pointers to the previous and next nodes in the doubly linked list.

    // Constructor to initialize a new node with a key, previous node, and next node.
    public IntNode(int key, IntNode previous, IntNode next) {
        this.key = key; // Assigns the given key value to this node.
        this.previous = previous; // Links this node to the previous node.
        this.next = next; // Links this node to the next node.
    }

    // Method to add a node **after** the current node.
    public void addNodeAfter(int key) {
        IntNode tmpRef = this.next; // Temporarily stores reference to the current 'next' node.

        // Debugger output to show the insertion process.
        if (DebuggerMODE) {
            System.out.println("\n-------------------------------");
            System.out.println("DEBUG: Adding node after " + this + " with new [Key: " + key + "]");
            System.out.println("DEBUG: Next node before update: " + tmpRef);
        }

        // Create a new node and insert it between 'this' and 'tmpRef'.
        this.next = new IntNode(key, this, tmpRef);

        // If tmpRef is not null, update the previous pointer of the next node.
        if (tmpRef != null) {
            tmpRef.previous = this.next;
        }

        // Debugger output to show the updated pointers.
        if (DebuggerMODE) {
            System.out.println("DEBUG: tmpRef.previous: " + (tmpRef != null ? tmpRef.previous : "null"));
            System.out.println("DEBUG: this.next: " + this.next);
        }

        // Print the updated list after adding.
        printList();
    }

    // Method to delete the node **after** the current node.
    public void deleteNodeAfter() {
        // Debugger output indicating the deletion process.
        if (DebuggerMODE) {
            System.out.println("\n-------------------------------");
            System.out.println("DEBUG: Attempting to delete node after " + this);
        }

        if (this.next != null) { // Check to see if the next node exists.
            this.next = this.next.next; // Bypass the next node by linking 'this' directly to the node after it.

            if (this.next != null) { // If a node exists after the deleted one, update its previous pointer.
                this.next.previous = this;
            }

            // Print the updated list after deletion.
            printList();
        } else {
            System.out.println("Sorry, no nodes were deleted."); // No deletion if 'this.next' is null.
        }
    }

    // Method to print the doubly linked list showing both next (→) and previous (←) links.
    public void printList() {
        IntNode start = this; // Start from the current node.

        // Move to the head of the list.
        while (start.previous != null) {
            start = start.previous;
        }

        // Print forward traversal from head to tail.
        System.out.print("Forward List: ");
        IntNode temp = start;
        while (temp != null) {
            System.out.print(temp + (temp.next != null ? " → " : " → NULL"));
            temp = temp.next; // Move to the next node.
        }
        System.out.println(); // New line for separation.

        // Move to the tail of the list.
        while (start.next != null) {
            start = start.next;
        }

        // Print backward traversal from tail to head.
        System.out.print("Backward List: ");
        temp = start;
        while (temp != null) {
            System.out.print(temp + (temp.previous != null ? " ← " : " ← NULL"));
            temp = temp.previous; // Move to the previous node.
        }
        System.out.println("\n"); // Extra new line for readability.
    }

    // Method to search for a node with a given key and show its position relative to the current node.
    public IntNode searchNode(int targetKey) {
        System.out.println("\n==============================");
        System.out.println("DEBUG: Searching for node with key: " + targetKey);
        System.out.println("==============================");

        printList(); // Show the list before searching.

        IntNode anchor = this; // Start searching from the current node.

        // Search forward (right) through the list.
        while (anchor != null) {
            if (anchor.key == targetKey) { // If the key matches, return the node.
                System.out.println("✅ Target node [Key: " + targetKey + "] found to the RIGHT of [Key: " + 
                                   (anchor.previous != null ? anchor.previous.key : "NULL") + "].");
                return anchor;
            }
            anchor = anchor.next; // Move to the next node.
        }

        // Reset search to go backward (left).
        anchor = this.previous;

        // Search backward (left) through the list.
        while (anchor != null) {
            if (anchor.key == targetKey) { // If the key matches, return the node.
                System.out.println("✅ Target node [Key: " + targetKey + "] found to the LEFT of [Key: " + 
                                   (anchor.next != null ? anchor.next.key : "NULL") + "].");
                return anchor;
            }
            anchor = anchor.previous; // Move to the previous node.
        }

        System.out.println("❌ Target node [Key: " + targetKey + "] not found."); // If no match is found.
        return null;
    }

    // Method to count total nodes in the doubly linked list.
    public int countNodes() {
        IntNode countAnchor = this; // Start counting from the current node.
        int count = 0; // Initialize count to zero.

        while (countAnchor != null) { // Traverse through the list.
            count++; // Increment the count for each node encountered.
            countAnchor = countAnchor.next; // Move to the next node.
        }

        return count; // Return the total node count.
    }
}
