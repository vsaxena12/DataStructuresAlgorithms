package org.data_structures.dev.b.dataStructures.baseImpl;

import java.util.Arrays;
import java.util.Scanner;
public class StackScratchImpl {

    private Scanner scan;
    private int[] arrayStack;
    private int top = -1;
    private int size;
    public StackScratchImpl(){
        scan = new Scanner(System.in);
        System.out.print("Define the size of the Stack: ");
        size = scan.nextInt();
        arrayStack = new int[size];
    }

    public void push(int element){
        top++;
        arrayStack[top] = element;
    }

    public int pop(){
        if(top == -1) {
            System.out.println("Pop operation cannot be done. Stack is Empty");
            return -1;
        }

        int element = arrayStack[top];
        top--;
        return element;
    }

    public int peek(){
        if(top == -1) {
            System.out.println("Pop operation cannot be done. Stack is Empty");
            return -1;
        }
        return arrayStack[top];
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        if(top == -1){
            return true;
        }
        return false;
    }

    public String givenStack(){
        if(top == -1){
            return "[]";
        }
        int[] stackArr = new int[top+1];
        for(int i=0; i<=top; i++){
            stackArr[i] =  arrayStack[i];
        }
        return Arrays.toString(stackArr);
    }


}
