package linkedListWorker;

import linkedListPackage.IntNode;

public class runnableLinkedList {
    public static void main(String[] args) {
        // Prints a welcome message
        System.out.println("Hello human, this is code that works with a linked list data structure.");

        // Creates the head node with key 100
        IntNode head = new IntNode(100, null, null);

        // Adds nodes after the head
        head.addNodeAfter(110);
        head.addNodeAfter(210);
        head.addNodeAfter(310);
        head.addNodeAfter(410);
        head.addNodeAfter(510);
        head.addNodeAfter(610);
        head.addNodeAfter(710);
        head.addNodeAfter(810);

        // Prints total number of nodes
        System.out.println("\nThe number of nodes in the linked list at this time is: " + head.countNodes());

        // Searches for node with key 110
        head.searchNode(110);

        // Searches for node with key 210
        IntNode targetNode = head.searchNode(210);

        // If found, deletes the node after it
        if (targetNode != null) {
            targetNode.deleteNodeAfter();
        }

        // Searches for node with key 110 again
        head.searchNode(110);

        // Prints updated count
        System.out.println("\nThe number of nodes in the linked list at this time is: " + head.countNodes());
    }
}
