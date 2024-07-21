package org.data_structures.linkedList.doublyLinkedList;

class Node{
    protected int data;
    protected Node next;
    protected Node prev;

    public Node(int num){
        data = num;
        next = null;
        prev = null;
    }
}

class DoublyLinkedList {
    static Node head;
    static Node tail;
    public void doublyLinkedListBasics(){
        Node a = new Node(5);
        Node b = new Node(10);
        Node c = new Node(15);
        Node d = new Node(25);
        Node e = new Node(35);

        if(head == null)
            head = a;
        tail = e;

        a.next = b;
        a.prev = null;
        b.next = c;
        b.prev = a;
        c.next = d;
        c.prev = b;
        d.next = e;
        d.prev = c;
        e.next = null;
        e.prev = d;


    }


    public void printNext(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printPrev(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public void printFromRandom(Node random){
        Node temp = random;
        while(temp.prev != null){
            temp = temp.prev;
        }

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class DoublyLinkedListDriver {

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.doublyLinkedListBasics();
        dll.printNext();
        dll.printPrev();
        dll.printFromRandom(dll.head.next.next);
    }
}
