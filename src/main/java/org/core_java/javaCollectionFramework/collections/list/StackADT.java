package org.core_java.javaCollectionFramework.collections.list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

/**
 * In Java, Stack is a class that falls under the Collection framework
 * that extends the Vector class. It also implements interfaces List,
 * Collection, Iterable, Cloneable, Serializable. It represents the LIFO
 * stack of objects.
 */
public class StackADT {
    public static void main(String[] args){
        /*
         * ----------------METHODS OF STACK CLASS----------------
         * boolean empty();
         * E push(element); -> push element into the stack
         * E pop(); -> remove top element from the stack
         * E peek(); -> top element
         * int search(object); -> It returns the object location from the top of the stack.
         * If it returns -1, it means that the object is not on the stack.
         */
        Stack<Integer> stack = new Stack<>();

        boolean isEmpty = stack.empty();
        System.out.println("Stack Empty: "+isEmpty+"->"+stack); //empty stack->true

        for(int i=0; i<10; i++){
            stack.push((i+1)*10); //E push(E)
        }
        System.out.println("Stack Push: "+stack);

        int peek = stack.peek(); //E peek()
        System.out.println("Stack Peek: "+peek);

        int pop = stack.pop(); //E pop()
        System.out.println("Stack Pop: "+pop+"->"+stack);

        int searchObject = stack.search(90); //Returns the index of the searched element from the top
        System.out.println("Stack Search Index: "+searchObject);

        /*
         * Since Stack is a class under Collection framework.
         * We can use Collection methods too in Stack class
         */
        int sizeOfTheStack = stack.size();
        System.out.println("Size of the Stack : "+sizeOfTheStack);

        /*
         * Iterate means to fetch the elements repeatedly of the stack.
         * We can fetch elements of the stack using three different methods are as follows:
         * iterator();
         * forEach();
         * listIterator();
         */
        //iterator();
        System.out.print("Iterator\n");
        Iterator<Integer> iterator = stack.iterator();
        while(iterator.hasNext())
        {
            Object values = iterator.next();
            System.out.print(values+" ");
        }
        System.out.print("\n");

        //For Each
        System.out.print("For Each\n");
        for (Object values : stack) {
            System.out.print(values+" ");
        }
        System.out.print("\n");

        System.out.print("For Each Invoking Each\n");
        stack.forEach(n -> System.out.print(n+" "));
        System.out.print("\n");

        //List Iterator
        ListIterator<Integer> ListIterator = stack.listIterator(stack.size());
        System.out.println("Iteration over the Stack from top to bottom:");
        while (ListIterator.hasPrevious())
        {
            Integer avg = ListIterator.previous();
            System.out.print(avg+" ");
        }
        System.out.print("\n");
    }
}
