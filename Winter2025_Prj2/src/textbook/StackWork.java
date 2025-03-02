package textbook; // Defines the package name for organizational purposes.

public class StackWork { // Defines a class that implements multiple stacks.

    private int[] S0; // Array representing stack S0.
    private int S0top; // Keeps track of the top index for stack S0.
    private int S0length; // Stores the maximum capacity of stack S0.

    private int[] S1; // Array representing stack S1.
    private int S1top; // Keeps track of the top index for stack S1.
    private int S1length; // Stores the maximum capacity of stack S1.

    private int[] S2; // Array representing stack S2.
    private int S2top; // Keeps track of the top index for stack S2.
    private int S2length; // Stores the maximum capacity of stack S2.

    // Debugger mode flag: Set to 'true' to enable debug messages.
    private static final boolean Debugger = true;

    // Constructor to initialize three stacks with given sizes.
    // Precondition: S0size, S1size, and S2size must be greater than 0.
    // Postcondition: Three stacks are created with their respective sizes.
    public StackWork(int S0size, int S1size, int S2size) {
        S0 = new int[S0size]; // Create stack S0 with specified size.
        S1 = new int[S1size]; // Create stack S1 with specified size.
        S2 = new int[S2size]; // Create stack S2 with specified size.

        S0top = -1; // Initialize S0top to -1 (stack is empty).
        S1top = -1; // Initialize S1top to -1 (stack is empty).
        S2top = -1; // Initialize S2top to -1 (stack is empty).

        S0length = S0size; // Store the maximum size for stack S0.
        S1length = S1size; // Store the maximum size for stack S1.
        S2length = S2size; // Store the maximum size for stack S2.
    }

    // Method to push an element onto the selected stack.
    // Precondition: StackSelector must be 0, 1, or 2.
    // Postcondition: The element x is added to the selected stack if it is not full.
    public void Push(int StackSelector, int x) { 
        if (StackSelector == 0) { // If stack S0 is selected.
            if (S0top < S0length - 1) { // Check if S0 is not full.
                S0[++S0top] = x; // Increment top and insert element x.
            } else {
                System.out.println("The S0 stack is full!!!"); // Display error if stack is full.
            }
        } else if (StackSelector == 1) { // If stack S1 is selected.
            if (S1top < S1length - 1) { // Check if S1 is not full.
                S1[++S1top] = x; // Increment top and insert element x.
            } else {
                System.out.println("The S1 stack is full!!!"); // Display error if stack is full.
            }
        } else if (StackSelector == 2) { // If stack S2 is selected.
            if (S2top < S2length - 1) { // Check if S2 is not full.
                S2[++S2top] = x; // Increment top and insert element x.
            } else {
                System.out.println("The S2 stack is full!!!"); // Display error if stack is full.
            }
        } else { // If an invalid stack is selected.
            System.out.println("You made an invalid stack choice!!!"); // Error message.
        }
    }

    // Method to pop an element from the selected stack.
    // Precondition: StackSelector must be 0, 1, or 2.
    // Postcondition: The top element from the selected stack is removed and returned.
    public int Pop(int StackSelector) {
        int poppedValue = -1; // Default return value if stack is empty.

        if (StackSelector == 0) { // If stack S0 is selected.
            if (S0top >= 0) { // Check if S0 is not empty.
                poppedValue = S0[S0top--]; // Retrieve and remove the top element.

                // Debugger output showing stack state after pop operation.
                if (Debugger) {
                    System.out.println("\n[DEBUG] Popping from S0: " + poppedValue);
                    System.out.print("[DEBUG] S0 after Pop: ");
                    for (int i = 0; i <= S0top; i++) {
                        System.out.print(S0[i] + " | ");
                    }
                    System.out.println(S0top >= 0 ? "" : " (empty)"); // Print "(empty)" if S0 is now empty.
                }
            }
        } else if (StackSelector == 1) { // If stack S1 is selected.
            if (S1top >= 0) { // Check if S1 is not empty.
                poppedValue = S1[S1top--]; // Retrieve and remove the top element.

                // Debugger output showing stack state after pop operation.
                if (Debugger) {
                    System.out.println("\n[DEBUG] Popping from S1: " + poppedValue);
                    System.out.print("[DEBUG] S1 after Pop: ");
                    for (int i = 0; i <= S1top; i++) {
                        System.out.print(S1[i] + " | ");
                    }
                    System.out.println(S1top >= 0 ? "" : " (empty)"); // Print "(empty)" if S1 is now empty.
                }
            }
        } else if (StackSelector == 2) { // If stack S2 is selected.
            if (S2top >= 0) { // Check if S2 is not empty.
                poppedValue = S2[S2top--]; // Retrieve and remove the top element.

                // Debugger output showing stack state after pop operation.
                if (Debugger) {
                    System.out.println("\n[DEBUG] Popping from S2: " + poppedValue);
                    System.out.print("[DEBUG] S2 after Pop: ");
                    for (int i = 0; i <= S2top; i++) {
                        System.out.print(S2[i] + " | ");
                    }
                    System.out.println(S2top >= 0 ? "" : " (empty)"); // Print "(empty)" if S2 is now empty.
                }
            }
        } else { // If an invalid stack is selected.
            System.out.println("[ERROR] Invalid Stack Selector!"); // Error message.
        }

        return poppedValue; // Return the popped value (or -1 if stack was empty).
    }

    // Method to display the contents of all stacks.
    // Precondition: None.
    // Postcondition: Prints all elements in stacks S0, S1, and S2.
    public void displayStackData() {
        System.out.print("Data in S0: "); // Print S0 from bottom to top.
        for (int i = 0; i <= S0top; i++) {
            System.out.print(S0[i] + " ");
        }
        System.out.println();

        System.out.print("Data in S1: "); // Print S1 from top to bottom.
        for (int i = S1top; i >= 0; i--) {
            System.out.print(S1[i] + " ");
        }
        System.out.println();

        System.out.print("Data in S2: "); // Print S2 from top to bottom.
        for (int i = S2top; i >= 0; i--) {
            System.out.print(S2[i] + " ");
        }
        System.out.println();
    }

    // Method to get the top index of stack S0.
    // Precondition: The StackWork object exists.
    // Postcondition: Returns the value of S0top.
    public int getS0top() {
        return S0top; // Return the top index of S0.
    }
}
