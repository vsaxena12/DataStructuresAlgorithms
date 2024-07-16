package org.core_java.collections.queue;

import java.util.Comparator;
import java.util.Objects;
import java.util.Queue;

public class PriorityQueue {
    public static void main(String[] args){
        java.util.PriorityQueue<int[]> pr = new java.util.PriorityQueue<>((a, b) -> (a[0] - b[0]));

        pr.add(new int[]{500});
        pr.add(new int[]{750});
        pr.add(new int[]{900});
        pr.add(new int[]{500});
        pr.add(new int[]{100});

        System.out.println(Objects.requireNonNull(pr.poll())[0]);
        System.out.println(pr.size());

        Queue<Integer> pq = new java.util.PriorityQueue<>();

        pq.offer(40);
        pq.offer(12);
        pq.offer(24);
        pq.offer(36);
        System.out.println(pq);
        pq.poll();
        System.out.println(pq);

        Queue<Integer> pq2 = new java.util.PriorityQueue<>(Comparator.reverseOrder());

        pq2.offer(40);
        pq2.offer(12);
        pq2.offer(24);
        pq2.offer(36);
        System.out.println(pq2);
        pq2.poll();
        System.out.println(pq2);
    }
}
