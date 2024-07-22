# Stack and Queues

## Stack in Java

Use the concept of Last In First Out.
![Stack.png](../../../../../docImages/img/stackAndQueues/Stack.png)

Here is the table format that lists the methods used in a typical Stack implementation, along with their space and time complexity:

| Method                         | Time Complexity | Space Complexity |
|--------------------------------|-----------------|------------------|
| `boolean empty() or isEmpty()` | O(1)            | O(1)             |
| `E push(E)`                    | O(1)            | O(1)             |
| `E pop()`                      | O(1)            | O(1)             |
| `E peek()`                     | O(1)            | O(1)             |
| `int search(Object)`           | O(n)            | O(1)             |

### Queue in Java

First in first out

![Queue.png](../../../../../docImages/img/stackAndQueues/Queue.png)

        add() -> Insert the specified element into the queue If the task is successful, it 
        returns true if not it throws an exception.

        offer() -> Insert the specified element into the queue If the task is successful, it 
        returns true if not it returns false. 

        element() -> Returns the head of the queue. Throws an exception if the queue is empty.
        peek() -> Returns the head of the queue. Returns null if the queue is empty.

        remove() -> Remove and returns the head of the queue. Throws an exception if the queue is empty.
        poll() -> Remove and returns the head of the queue. Returns null if the queue is empty.

#### PriorityQueue

It uses heap data structure, where the top priority queue is entered into the queue and then queue
operations are performed.

The PriorityQueue in Java is a part of the Java Collections Framework and is used to implement a priority queue data structure. It is an unbounded queue based on a priority heap and provides O(log(n)) time for the enqueuing and dequeuing methods (offer, poll, remove() and add).

Key Features and Methods

1. Creating a PriorityQueue

- Default Constructor: Creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //Initial Capacity: Creates a PriorityQueue with the specified initial capacity.
        PriorityQueue<Integer> pq = new PriorityQueue<>(20);

        //Custom Comparator: Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.
        PriorityQueue<Integer> pq = new PriorityQueue<>(20, Comparator.reverseOrder());

        //add(E e): Inserts the specified element into this priority queue.
        pq.add(10);

        //offer(E e): Inserts the specified element into this priority queue.
        pq.offer(20);

        //poll(): Retrieves and removes the head of this queue, or returns null if this queue is empty.
        Integer head = pq.poll();

        //remove(): Retrieves and removes the head of this queue.
        pq.remove();

        //peek(): Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        Integer head = pq.peek();

        //size(): Returns the number of elements in this collection.
        int size = pq.size();

        //clear(): Removes all of the elements from this priority queue.
        pq.clear();

        for (Integer val : pq) {
                System.out.println(val);
        }

        import java.util.PriorityQueue;

        public class Main {
                public static void main(String[] args) {
                        PriorityQueue<Integer> pq = new PriorityQueue<>();
                        pq.add(4);
                        pq.add(2);
                        pq.add(5);
                        pq.add(1);
                        
                        while (!pq.isEmpty()) {
                        System.out.println(pq.poll()); // Output: 1, 2, 4, 5
                        }
                }
        }

        import java.util.PriorityQueue;
        import java.util.Comparator;

        public class Main {
                public static void main(String[] args) {
                        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
                        pq.add(4);
                        pq.add(2);
                        pq.add(5);
                        pq.add(1);
                        
                        while (!pq.isEmpty()) {
                        System.out.println(pq.poll()); // Output: 5, 4, 2, 1
                        }
                }
        }

#### ArrayDequeue

Offer element from rear end and front end.
E.g. Window proper

        ArrayDeque<Integer> arrayDeque = new ArrayDequeue<>();
        arrayDeque.offer(23);
        arrayDeque.offerFirst(12);
        arrayDeque.offerLast(45); 

        arrayDeque.peek();
        arrayDeque.peekFirst();
        arrayDeque.peekLast();

        arrayDeque.poll();
        arrayDeque.pollFirst();
        arrayDeque.pollLast();
