
package packetSelector;

import textbook.StackWork;

public class runnablepacketSelector {
    
	private static final boolean DebuggerMODE = true;
	
    static StackWork packets;

    public static void main(String[] args) {
        System.out.println("Packet selector is now running...\n");

        // Initialize the StackWork object with three stacks
        packets = new StackWork(10, 10, 10);

    	
        
        if (DebuggerMODE) {System.out.println("DEBUG: Starting Push... \n");}
        
        // Push timestamps (network packets)
        packets.Push(0, 95);
        packets.Push(0, 103);
        packets.Push(0, 81);
        packets.Push(0, 120);
        packets.Push(0, 74);
        packets.Push(0, 134);
        packets.Push(0, 62);
        packets.Push(0, 101);
        packets.Push(0, 59);
        packets.Push(0, 148);

        // Display before reorganization
        packets.displayStackData();

        // Call method to reorganize network traffic
        reorganizeNetworkTraffic(1);

        // Display after reorganization
        packets.displayStackData();
    }

	// Precondition: The StackWork object packets is different than null.
	// Postcondition: The elements of the stack S0 that are equal to, or less than 100, are inserted in the stack S1.
	// The elements of the stack S0 that are greater than 100 are inserted in the stack S2.
    // The argument flg is flipped. In other words, if the caller passes 1, flg is set to 0. Similarly, if the caller passes 0, flg is set to 1. No further action is taken on flg. 
    // Function to process stack S0 and distribute packets into S1 and S2
    public static void reorganizeNetworkTraffic(int flg) {
        int tempStackSize = packets.getS0top() + 1; // Number of elements in S0
        int[] S1Temp = new int[tempStackSize]; // Temporary storage for S1
        int[] S2Temp = new int[tempStackSize]; // Temporary storage for S2

        int S1Index = 0, S2Index = 0;

        if (DebuggerMODE) {System.out.println("DEBUG: Starting Pop... \n");}
        
        // Pop all elements from S0 and distribute into temporary arrays
        for (int i = 0; i < tempStackSize; i++) {
            int packet = packets.Pop(0);
            
            if (packet <= 100) {
                S1Temp[S1Index++] = packet; // Store in S1Temp
                if (DebuggerMODE) {System.out.println("DEBUG: Storing : " + packet + " into S1Temp" + "\n");}
            } else {
                S2Temp[S2Index++] = packet; // Store in S2Temp
                if (DebuggerMODE) {System.out.println("DEBUG: Storing : " + packet + " into S2Temp" + "\n");}
            }
        }

        // Push back into S1 in REVERSE order to ensure correct display
        for (int i = S1Index - 1; i >= 0; i--) {
            packets.Push(1, S1Temp[i]);
            if (DebuggerMODE) {System.out.println("DEBUG: Pushing : " + S1Temp[i] + " back into S1" + "\n");}
        }

        // Push back into S2 in REVERSE order to ensure correct display
        for (int i = S2Index - 1; i >= 0; i--) {
            packets.Push(2, S2Temp[i]);
            if (DebuggerMODE) {System.out.println("DEBUG: Pushing : " + S2Temp[i] + " back into S2" + "\n");}
        }

        // Flip the flag (simple if-else instead of ternary)
        if (flg == 1) {
            flg = 0;
        } else {
            flg = 1;
        }
    }
}
