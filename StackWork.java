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

    // Push method inserts elements into the respective stacks
    public void Push(int StackSelector, int x) {    
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

    // Pop method removes and returns elements from the respective stacks
    public int Pop(int StackSelector) {
        if (StackSelector == 0) {
            if (S0top >= 0) {
                return S0[S0top--];
            }
        } else if (StackSelector == 1) {
            if (S1top >= 0) {
                return S1[S1top--];
            }
        } else if (StackSelector == 2) {
            if (S2top >= 0) {
                return S2[S2top--];
            }
        }
        System.out.println("Stack is empty or invalid Stack Selector!");
        return -1; // Return an invalid value if nothing to pop
    }

    // Display method prints all stacks
    public void displayStackData() {
        System.out.print("Data in S0: ");
        for (int i = S0top; i >= 0; i--) {
            System.out.print(S0[i] + " ");
        }
        System.out.println();

        System.out.print("Data in S1: ");
        for (int i = S1top; i >= 0; i--) {
            System.out.print(S1[i] + " ");
        }
        System.out.println();

        System.out.print("Data in S2: ");
        for (int i = S2top; i >= 0; i--) {
            System.out.print(S2[i] + " ");
        }
        System.out.println();
    }

    // Returns the top index of S0 (for processing)
    public int getS0top() {   
        return S0top;
    }
}
