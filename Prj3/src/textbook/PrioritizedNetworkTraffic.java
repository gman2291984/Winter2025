package textbook;

public class PrioritizedNetworkTraffic {

	private int[] Q;
	private int head = -1;
	private int tail = 0;
	private int length;

	// Precondition: Priority queue Q is defined but not created.
	// Postcondition: Priority queue Q is created, and its size is set to "queueSize".
	//                All values of Q are initialized to -1.
	//                length is set to "queueSize".
	public PrioritizedNetworkTraffic(int queueSize) {
		length = queueSize;
		Q = new int[length];
		for (int i = 0; i < length; i++) {
			Q[i] = -1;
		}
	}

	
	
	// Precondition: Priority queue Q is existent.
	//               "tail" is already set to the index of Q where a new packet may be inserted. 
	//               "head" is already set to the index of Q where the packet with the highest priority is stored.
	// Postcondition: A new packet with priority "newElement" is inserted in the priority queue Q.
	//                "head" is set to the index of Q where the packet with the highest priority is stored.
	//                "tail" is set to the next index of Q that is available for storage of a new element.
	//                If Q is full, "tail" is to the index of Q where the packet with the lowest priority is stored.
	public void Enqueue(int newElement) {
		if (tail >= length) {
			tail = LocateNextTail(0, length - 1);
		}
		if (tail >= length) {
			System.out.println("Queue is full. Cannot insert new element.");
			return;
		}
		
		Q[tail] = newElement;
		
		// Update head to track the highest-priority element
		head = LocateNextHead(0, length - 1);
		tail = LocateNextTail(0, length - 1);

		System.out.println("At Enqueue: inserted " + newElement + " in index " + tail);
	}

	// Precondition: Priority queue Q is existent.
	//               "head" is already set to the index of Q where the packet with the highest priority is stored.
	//               If Q is empty, "head" is -1.
	//               "tail" is already set to the index of Q where a new packet may be inserted.
	// Postcondition: The packet with index equal to "head" is removed from Q and is returned to the caller.
	//                -1 is inserted in its place, namely in the cell of Q where the removed packet was previously stored. 
    //                "head" is set to the index of Q where the packet with the highest priority is stored.
    //                "tail" is set to the next index of Q that is available for storage of a new element.
    //                If Q is empty, "head" is set to -1 and "tail" is set to 0. 
    //                The argument flg is flipped. In other words, if the caller passes 1, flg is set to 0. Similarly, if the caller passes 0, flg is set to 1. No further action is taken on flg. 
	public int Dequeue(int flg) {
		if (head == -1) {
			System.out.println("Queue is empty. Nothing to dequeue.");
			return -1;
		}

		int removedElement = Q[head];
		Q[head] = -1;
		head = LocateNextHead(0, length - 1);
		tail = LocateNextTail(0, length - 1);

		if (head == -1) {
			tail = 0;
		}

		System.out.println("At Dequeue: removed " + removedElement + " from index " + head);
		return removedElement;
	}

	// Precondition: Priority queue Q is existent.
	//               "startIndex" and "endIndex" are indices of Q that define the beginning and the end, respectively, of the subarray of Q that needs to be searched.
	//               "startIndex" and "endIndex" may refer to the entire Q. 
	// Postcondition: The index of Q, where the packet with the highest priority is stored, is found and is returned to the caller. 
	public int LocateNextHead(int startIndex, int endIndex) {
		int maxIndex = -1;
		int maxValue = -1;
		for (int i = startIndex; i <= endIndex; i++) {
			if (Q[i] != -1 && Q[i] > maxValue) {
				maxValue = Q[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	// Precondition: Priority queue Q is existent.
	//               "startIndex" and "endIndex", abbreviated sindx and eindx, respectively, are indices of Q that define the beginning and the end, respectively, of the subarray of Q that needs to be searched.
	//               "startIndex" and "endIndex" may refer to the entire Q. 
	// Postcondition: The index of Q, where the packet with the lowest priority is stored, is found and is returned to the caller. 
	public int LocateNextTail(int sindx, int eindx) {
		// First, check for an empty slot (-1)
		for (int i = sindx; i <= eindx; i++) {
			if (Q[i] == -1) {
				return i;
			}
		}
		// If no empty slots, set tail right after the highest-priority element
		return LocateNextHead(sindx, eindx) + 1;
	}

	// Precondition: Priority queue Q is existent. 
	// Postcondition: The index and priority of each packet in Q are displayed on the monitor.
	public void DisplayPriorityQueue() {
		System.out.println("-------------------------------------------------------------");
		System.out.println("Displaying priority queue data...");
		for (int i = 0; i < length; i++) {
			System.out.println("Index: " + i + " Packet Priority: " + Q[i]);
		}
		System.out.println("Current Head: " + head + "; Current Tail: " + tail);
		System.out.println("-------------------------------------------------------------");
	}
}
