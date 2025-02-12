import textbook.StackWork;

public class packetSelector {
    
    static StackWork packets;

    public static void main(String[] args) {
        System.out.println("Packet selector is now running...\n");

        // Initialize the StackWork object with three stacks
        packets = new StackWork(10, 10, 10);

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

    // Function to process stack S0 and distribute packets into S1 and S2
    public static void reorganizeNetworkTraffic(int flg) {
        int tempStackSize = packets.getS0top() + 1; // Number of elements in S0
        
        for (int i = 0; i < tempStackSize; i++) {
            int packet = packets.Pop(0); // Pop from S0

            // Sort into the appropriate stack
            if (packet <= 100) {
                packets.Push(1, packet); // Push to S1
            } else {
                packets.Push(2, packet); // Push to S2
            }
        }

        // Flip flag (per assignment instruction)
        flg = (flg == 1) ? 0 : 1;
    }
}
