package org.core_java.collections.queue;

import java.util.ArrayDeque;

public class Dequeue {
    /**
     * Queues -> First In First Out
     * Queue has front for remove(poll)
     * Queue has rear for add
     *
     */
    public static void main(String[] args){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(); //LinkedList<>();

        arrayDeque.offer(23);
        arrayDeque.offerFirst(12);
        arrayDeque.offerLast(45);

        arrayDeque.peek();
        arrayDeque.peekFirst();
        arrayDeque.peekLast();

        arrayDeque.poll();
        arrayDeque.pollFirst();
        arrayDeque.pollLast();
        System.out.println(arrayDeque);

        //queue.offer(integer); -> same as add

        arrayDeque.remove();
        System.out.println(arrayDeque);
        arrayDeque.poll();
        System.out.println(arrayDeque);

        System.out.println(arrayDeque.element());
        System.out.println(arrayDeque.peek());

        System.out.println(arrayDeque.size());
        System.out.println(arrayDeque.isEmpty());


    }
}
