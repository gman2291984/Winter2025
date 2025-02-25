package textbook;



public class StackWork {
    private int[] S0;
    private int S0top;   
    private int S0length;
   
    private int[] S1;
    private int S1top;   
    private int S1length;
   
    private int[] S2;
    private int S2top;   
    private int S2length;
    
    //to disable the debugger comments then set false...true to see them in the console...
  	private static final boolean DebuggerMODE = false;
   
    // Precondition: S0size, S1size, and S2size are greater than 0.
    // Postcondition: The stacks S0, S1, and S2, are created, and their respective lengths are initialized.
    // Constructor initializes stack arrays
    public StackWork(int S0size, int S1size, int S2size) {
        S0 = new int[S0size];
        S1 = new int[S1size];
        S2 = new int[S2size];

        S0top = -1;
        S1top = -1;
        S2top = -1;

        S0length = S0size;
        S1length = S1size;
        S2length = S2size;
    }

    
    // Precondition: S0size, S1size, and S2size are greater than 0.
    // Postcondition: The stacks S0, S1, and S2, are created, and their respective lengths are initialized.
    // Push method inserts elements into the respective stacks
    public void Push(int StackSelector, int x) {
    	
    	//A stack always follows the LIFO (Last-In-First-Out) principle.
    	//if you want to reverse taht then we will make it in reverse order then store poped elements in a temparray -- then push them...
        if (StackSelector == 0) {
            if (S0top < S0length - 1) {
                S0[++S0top] = x;   
            } else {
                System.out.println("Stack S0 is full!");
            }
        } else if (StackSelector == 1) {
            if (S1top < S1length - 1) {
                S1[++S1top] = x; 
            } else {
                System.out.println("Stack S1 is full!");
            }
        } else if (StackSelector == 2) {
            if (S2top < S2length - 1) {
                S2[++S2top] = x;
            } else {
                System.out.println("Stack S2 is full!");
            }
        } else {
            System.out.println("Invalid Stack Selector!");
        }
    }


    // Precondition: StackSelector is equal to 0, 1, or 2.
    // Postcondition: If StackSelector is 0, then an element is taken out of stack S0 and is returned to the caller. 
    // If StackSelector is 1, then an element is taken out of stack S1 and is returned to the caller.
    // If StackSelector is 2, then an element is taken out of stack S2 and is returned to the caller.
    // Pop method removes and returns elements from the respective stacks
    public int Pop(int StackSelector) {
        if (StackSelector == 0) {
            if (S0top >= 0) {
                if (DebuggerMODE) {
                    System.out.print("DEBUG: S0 Top before Pop: " + S0top + " \nDEBUG: Packets before Pop in S0: ");
                    for (int i = 0; i <= S0top; i++) {
                        System.out.print(S0[i] + " ");
                    }
                    System.out.println();
                    
                    // Optionally, if you want to show the state after pop, you can compute what it will be:
                    System.out.print("DEBUG: S0 Top after Pop: " + (S0top - 1) + " \nDEBUG: Packets after Pop in S0: ");
                    for (int i = 0; i <= S0top - 1; i++) {
                        System.out.print(S0[i] + " ");
                    }
                    System.out.println();
                }
                return S0[S0top--];
            }
        } else if (StackSelector == 1) {
            if (S1top >= 0) {
                if (DebuggerMODE) {System.out.print("DEBUG: S1 Top before Pop: " + S1top + " \nDEBUG: Packets before Pop in S1: ");
                    for (int i = 0; i <= S1top; i++) {
                        System.out.print(S1[i] + " ");
                    }
                    System.out.println();
                    
                    // Optionally, if you want to show the state after pop, you can compute what it will be:
                    System.out.print("DEBUG: S1 Top after Pop: " + (S1top - 1) + " \nDEBUG: Packets after Pop in S1: ");
                    for (int i = 0; i <= S1top - 1; i++) {
                        System.out.print(S1[i] + " ");
                    }
                    System.out.println();
                }
                return S1[S1top--];
            }
        } else if (StackSelector == 2) {
            if (S2top >= 0) {
                if (DebuggerMODE) {System.out.print("DEBUG: S1 Top before Pop: " + S2top + " \nDEBUG: Packets before Pop in S2: ");
                    for (int i = 0; i <= S2top; i++) {
                        System.out.print(S2[i] + " ");
                    }
                    System.out.println();
                    
                    // Optionally, if you want to show the state after pop, you can compute what it will be:
                    System.out.print("DEBUG: S2 Top after Pop: " + (S2top - 1) + " \nDEBUG: Packets after Pop in S2: ");
                    for (int i = 0; i <= S2top - 1; i++) {
                        System.out.print(S2[i] + " ");
                    }
                    System.out.println();
                }
                return S2[S2top--];
            }
        }
        System.out.println("Stack is empty or invalid Stack Selector!");
        return -1; // Return an invalid value if nothing to pop
    }

    // Precondition: 
    // Postcondition: The elements of the stack S0 are displayed, followed by the elements of the stack S1, and in the end
    // the elements of the Stack S2.
    // Display method prints all stacks
    public void displayStackData() {
    	
    	
    	   // Print S0 from bottom to top (correct order)
        System.out.print("Data in S0: ");
        for (int i = 0; i <= S0top; i++) { // 🔹 FIX: Print in push order
            System.out.print(S0[i] + " ");
        }
        System.out.println();

        // Print S1 from top to bottom (LIFO order)
        System.out.print("Data in S1: ");
        for (int i = S1top; i >= 0; i--) {
            System.out.print(S1[i] + " ");
        }
        System.out.println();

        // Print S2 from top to bottom (LIFO order)
        System.out.print("Data in S2: ");
        for (int i = S2top; i >= 0; i--) {
            System.out.print(S2[i] + " ");
        }
        System.out.println();
    }


    // Precondition: The StackWork object exists.
    // Postcondition: The instance variable S0top is returned.
    // Returns the top index of S0 (for processing)
    public int getS0top() {   
        return S0top;
    }
    
    
    
    
    
    
}





