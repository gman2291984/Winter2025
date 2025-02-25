
package intStack;

/*
Summary of Stacks
A stack is a linear data structure that follows the LIFO (Last In, First Out) principle. 
This means that the last element added is the first one to be removed—similar to a stack of plates.

Key Operations:
Push → Add an element to the top of the stack.
Pop → Remove and return the top element.
Peek (Top) → View the top element without removing it.
isEmpty → Check if the stack is empty.
isFull → Check if the stack is full (for fixed-size stacks).
dumpStack → Print all elements in the stack from top to bottom.
*/

public class StackDataStructure {
    private int[] Stack;
    private int top;
    private int stackCapacity;
    private static final boolean DEBUG = true; // Set to true to enable debug messages, false to disable

    // Constructor to initialize stack
    public StackDataStructure(int stackCapacity) {
        this.stackCapacity = stackCapacity;
        Stack = new int[stackCapacity];
        top = -1; // Indicates an empty stack
        if (DEBUG) System.out.println("Stack initialized with capacity: (" + stackCapacity + ")");
    }

    // Method to push an element onto the stack
    public void Push(int tempReading) {
    	
        if (isFull()) {
            throw new java.lang.IndexOutOfBoundsException("Stack overflow: Cannot push, stack is full.");
        } else {
            Stack[++top] = tempReading;
            if (DEBUG) System.out.println("Pushed [" + tempReading + "] onto stack. Current top: (" + top + ")");
        }
    }

    // Method to pop an element from the stack
    //In the context of a stack data structure, popping refers to the process of removing the top element from the stack. 
    //The stack follows the LIFO (Last In, First Out) principle, meaning the most recently added item is the first one to be removed.
    public int Pop() {
        if (isEmpty()) {
            throw new java.lang.IndexOutOfBoundsException("Stack underflow: Cannot pop, stack is empty.");
        }
        if (DEBUG) System.out.println("Popped [" + Stack[top] + "] from stack. New top: (" + (top - 1)+ ")");
        return Stack[top--];
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == (stackCapacity - 1));
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to print stack contents
    //dumpStack() method prints all elements of the stack to the console, 
    //starting from the topmost element down to the bottom.
    public void dumpStack() {
        if (!isEmpty()) {
            System.out.println("Dumping the stack:");
            for (int i = top; i >= 0; i--) {
                System.out.println("["+ Stack[i] + "],(" + i + ")");
            }
        } else {
            System.out.println("The stack is empty.");
        }
    }
    
    public int Peek() {
        if (top >= 0) { // Ensure the stack is not empty
            return Stack[top]; // Return the top element without removing it
        } else {
            System.out.println("Stack is empty, no top element.");
            return -1; // Return a default value (can be changed based on your needs)
        }
    }

    
    
    
    
    
}