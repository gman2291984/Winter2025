package packetSelector; // Defines the package name for organizational purposes.

import textbook.StackWork; // Imports the StackWork class to use stack operations.

public class runnablepacketSelector { // Defines a class that manages network packet selection.

    // Toggle debug messages on/off
    private static final boolean Debugger = true;

    // StackWork instance to manage multiple stacks
    static StackWork packets;

    public static void main(String[] args) { // Main method, the entry point of the program.

        System.out.println("\n===== Packet Selector Initialized =====\n");

        // Initialize StackWork with 3 stacks, each with a size of 10.
        packets = new StackWork(10, 10, 10);

        // Define an array of initial packets to be pushed into stack S0.
        int[] initialPackets = {95, 103, 81, 120, 74, 134, 62, 101, 59, 148};

        // Loop through the array and push each packet into stack S0.
        for (int packet : initialPackets) {
            packets.Push(0, packet); // Insert the packet into S0.
        }

        // Debugger output: Show initial state of stacks after pushing packets into S0.
        if (Debugger) {
            System.out.println("\n[DEBUG] All packets have been pushed into S0.");
            System.out.println("[DEBUG] Initial Stack Contents:");
            packets.displayStackData(); // Display stack contents.
        }

        // Call function to reorganize network traffic based on packet values.
        reorganizeNetworkTraffic(1);

        // Debugger output: Show final state of stacks after reorganization.
        if (Debugger) {
            System.out.println("\n[DEBUG] Final Stack Contents After Reorganization:");
        }
        packets.displayStackData(); // Display final stack contents.
    }

    /**
     * Reorganizes packets from stack S0:
     * - Packets with values ≤ 100 go into S1 (low-priority packets).
     * - Packets with values > 100 go into S2 (high-priority packets).
     * - Ensures correct ordering is maintained.
     */
    public static void reorganizeNetworkTraffic(int flg) {
        int tempStackSize = packets.getS0top() + 1; // Determine the number of packets in S0.
        int[] S1Temp = new int[tempStackSize]; // Temporary storage for packets moving to S1.
        int[] S2Temp = new int[tempStackSize]; // Temporary storage for packets moving to S2.

        int S1Index = 0; // Keeps track of how many elements are added to S1Temp.
        int S2Index = 0; // Keeps track of how many elements are added to S2Temp.

        // Debugger output: Indicate start of packet reorganization.
        if (Debugger) {
            System.out.println("\n===== Reorganizing Network Traffic =====");
            System.out.println("[DEBUG] Starting packet extraction from S0...\n");
        }

        // Step 1: Pop all elements from S0 and store them in temporary arrays.
        for (int i = 0; i < tempStackSize; i++) {
            int packet = packets.Pop(0); // Remove the top element from S0.

            // Categorize packets: ≤ 100 go to S1Temp, > 100 go to S2Temp.
            if (packet <= 100) {
                S1Temp[S1Index++] = packet; // Store packet in S1Temp and increment index.
            } else {
                S2Temp[S2Index++] = packet; // Store packet in S2Temp and increment index.
            }

            // Debugger output: Show which temporary stack the packet was assigned to.
            if (Debugger) {
                System.out.println("[DEBUG] Packet " + packet + " -> " + (packet <= 100 ? "S1Temp" : "S2Temp"));
            }
        }

        // Debugger output: Show extracted packets before reinsertion.
        if (Debugger) {
            System.out.println("\n[DEBUG] Finished extracting packets from S0.");

            // Print contents of S1Temp.
            System.out.print("[DEBUG] S1Temp: ");
            for (int i = 0; i < S1Index; i++) System.out.print(S1Temp[i] + " | ");
            System.out.println(); // New line for formatting.

            // Print contents of S2Temp.
            System.out.print("[DEBUG] S2Temp: ");
            for (int i = 0; i < S2Index; i++) System.out.print(S2Temp[i] + " | ");
            System.out.println("\n"); // New line for formatting.
        }

        // Step 2: Push elements back into S1 and S2 in **reverse order** to maintain stack behavior.
        if (Debugger) {
            System.out.println("[DEBUG] Reinserting packets into S1 and S2...\n");
        }

        // Insert packets into S1 (low-priority) in **reverse order**.
        for (int i = S1Index - 1; i >= 0; i--) {
            packets.Push(1, S1Temp[i]); // Push the element back into S1.
            if (Debugger) {
                System.out.println("[DEBUG] Pushed " + S1Temp[i] + " into S1.");
            }
        }

        // Insert packets into S2 (high-priority) in **reverse order**.
        for (int i = S2Index - 1; i >= 0; i--) {
            packets.Push(2, S2Temp[i]); // Push the element back into S2.
            if (Debugger) {
                System.out.println("[DEBUG] Pushed " + S2Temp[i] + " into S2.");
            }
        }

        // Debugger output: Indicate end of reorganization process.
        if (Debugger) {
            System.out.println("\n[DEBUG] Packet reorganization complete.");
        }
    }
}
