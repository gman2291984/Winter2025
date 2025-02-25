//double linked list


package linkedListWorker;

import linkedListPackage.IntNode;

public class runnableLinkedList {

	public static void main(String[] args) {
		System.out.println("Hello human, this is code that works with a linked list data structure.");

		IntNode head = new IntNode(100, null, null);
		
		head.addNodeAfter(110);
		head.addNodeAfter(210);
		head.addNodeAfter(310);
		head.addNodeAfter(410);
		head.addNodeAfter(510);
		head.addNodeAfter(610);
		head.addNodeAfter(710);
		head.addNodeAfter(810);
		
		System.out.println("The number of nodes in the linked list at this time is: " + head.countNodes() + "\n");
		
		head.searchNode(110);
		
		//head.searchNode(910);
		
		IntNode targetNode = head.searchNode(210);
		targetNode.deleteNodeAfter();
	
		head.searchNode(110);
		
		System.out.println("The number of nodes in the linked list at this time is: " + head.countNodes());
	}

}


