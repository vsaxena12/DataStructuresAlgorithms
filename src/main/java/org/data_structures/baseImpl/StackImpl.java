package org.data_structures.dev.b.dataStructures.baseImpl;

import java.util.Stack;

/**
 * Last In First Out
 */
public class StackImpl {
    private final Stack<Integer> stack;

    public StackImpl(){
        stack = new Stack<>();
    }

    public void push(int n){
        stack.push(n);
    }

    public int pop(){
        return stack.pop();
    }

    public int peek(){
        return stack.peek();
    }

    public int size(){
        return stack.size();
    }

    public boolean empty(){
        return stack.empty();
    }

    public int search(int n){
        return stack.search(n);
    }

    public Stack<Integer> givenStack(){
        return stack;
    }
}
