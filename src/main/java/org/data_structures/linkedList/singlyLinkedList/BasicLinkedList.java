package org.data_structures.dev.b.dataStructures.linkedList.singlyLinkedList;


public class BasicLinkedList {

    static class Node {
        protected int data; //Data
        protected Node next; //Address
        public Node(int data){
            this.data=data;
        }
    }

    static void printLinkedList(Node a){
        Node temp = a;
        for(int i=1; i<=5; i++){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");

        System.out.println("\n-----------------------------------------------");

        Node node = a;
        while(node != null){
            System.out.print(node.data+"->");
            node = node.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args){
        System.out.println("Basic Linked List");
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(7);
        Node d = new Node(1);
        Node e = new Node(8);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(a.data);
        System.out.println(a.next);
        System.out.println(b);

        System.out.print(a.data+"->");
        System.out.print(a.next.data+"->");
        System.out.print(a.next.next.data+"->");
        System.out.print(a.next.next.next.data+"->");
        System.out.print(a.next.next.next.next.data+"->null");

        System.out.println("\n-----------------------------------------------");

        printLinkedList(a);





    }
}
