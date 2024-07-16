package org.core_java.javaCollectionFramework.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LearnLinkedListQueue {

    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(12); //add element
        queue.offer(24);
        queue.offer(29);
        queue.offer(35);
        System.out.println("Queue: "+queue);
        int poll = queue.poll(); //remove and return
        System.out.println("Poll "+poll);
        System.out.println("Peek: "+queue.peek());
        System.out.println("Queue: "+queue);

     }
}
