
package stackWorker;

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

//

import intStack.StackDataStructure;

public class RunnableStack {
    public static void main(String[] args) {
        System.out.println("Hello human, this is Java code that works with a stack data structure.");

        StackDataStructure stack = new StackDataStructure(10);//capacity set to 10

        // Pushing elements onto the stack
        stack.Push(20);
        stack.Push(30);
        stack.Push(40);
        stack.Push(50);
        stack.Push(60);
        stack.Push(200);
        stack.Push(300);
        stack.Push(400);
        stack.Push(500);
        stack.Push(600);

        stack.dumpStack(); // Display stack contents

        // Check if stack is full
        if (stack.isFull()) {
            System.out.println("The stack is full.");
        } else {
            System.out.println("The stack is not full.");
        }

        // Popping an element from the stack
        int data = stack.Pop();
        System.out.println("Peeking at the top gives us: [" + stack.Peek() + "]");

        stack.dumpStack(); // Display stack contents after pop
    }
}