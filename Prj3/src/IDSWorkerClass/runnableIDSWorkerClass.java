package IDSWorkerClass;

import textbook.PrioritizedNetworkTraffic;

public class runnableIDSWorkerClass {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			int arraySize = 8;
			
			int Max = 0;
			
			System.out.println("IDS analysis of prioritized network traffic is running...\n");
			
			PrioritizedNetworkTraffic ptraffic = new PrioritizedNetworkTraffic(arraySize);
	        
			ptraffic.DisplayPriorityQueue();
			
	        ptraffic.Enqueue(4);
	        ptraffic.DisplayPriorityQueue();
	        
	        ptraffic.Enqueue(9);
	        ptraffic.DisplayPriorityQueue();
	        
	        ptraffic.Enqueue(15);
	        ptraffic.DisplayPriorityQueue();
	        
	        ptraffic.Enqueue(1);
	        ptraffic.DisplayPriorityQueue();
	        
	        ptraffic.Enqueue(4);
	        ptraffic.DisplayPriorityQueue();
	        
	        ptraffic.Enqueue(10);
	        ptraffic.DisplayPriorityQueue();
	        
	        ptraffic.Enqueue(5);
	        ptraffic.DisplayPriorityQueue();
	        
	        ptraffic.Enqueue(3);
	        ptraffic.DisplayPriorityQueue();
	        
	        ptraffic.Dequeue(0);
	        ptraffic.DisplayPriorityQueue();
	        
	        ptraffic.Enqueue(17);
	        ptraffic.DisplayPriorityQueue();
	        

	}

}
