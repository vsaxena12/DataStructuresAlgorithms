package org.data_structures.dev.b.dataStructures.linkedList.singlyLinkedList;

class Node {
    protected int data;
    protected Node next;

    public Node(int num){
        this.data = num;
        next = null;
    }
}

class SinglyLinkedList{
    protected static Node head;
    protected static Node tail;
    protected  static int counter;

    public void insertAtEnd(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else {
            /**
             * If tail is not given, then traversal is needed to find the last node and add the new node at the back
             * of the last node in a linked list
             * Node temp = head;
             * while(temp.next != null){
             *      temp = temp.next;
             * }
             * temp.next = node;
             */
            tail.next = node;
        }
        tail = node;
        counter++;
    }

    public void insertAtHead(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        } else{
            node.next = head;
            head = node;
        }
        counter++;
    }

    public void insertAt(int data, int index){
        Node node = new Node(data);
        Node temp = head;

        if(index == 0){
            insertAtHead(data);
            return;
        } else if(size() == index){
            insertAtEnd(data);
            return;
        } else if(index<0 || index>size()){
            System.out.println("Wrong index");
            return;
        }

        for(int i=1; i<=index-1; i++){
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        counter++;
    }

    public int size(){
        return counter;
    }

    public int getAtIndex(int index){
        if(index<0 || index>size()){
            System.out.println("Wrong index");
            return -1;
        }

        Node temp = head;
        for(int i=1; i<=index; i++){
            temp = temp.next;
        }
        return temp.data;
    }

    public void deleteAtIndex(int index){
        if(index<0 || index>size()){
            System.out.println("Wrong index");
            return;
        }

        Node temp = head;



        if(index == 0){
            head = head.next;
            counter--;
            return;
        }

        for(int i=1; i<=index-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;

        if(index==size()-1){
            tail = temp;
        }
        counter--;
    }

    public void printSinglyLinkedList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("\n");
    }
}


public class SinglyLinkedListDriver {
    public static void main(String[] args){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertAtEnd(10); // 10
        singlyLinkedList.insertAtEnd(14); // 10 -> 14
        singlyLinkedList.insertAtEnd(17); // 10 -> 14- > 17
        singlyLinkedList.insertAtHead(5); // 5 -> 10 -> 14 -> 17

        singlyLinkedList.printSinglyLinkedList();

        System.out.println("Linked List Size: "+singlyLinkedList.size()+"\n\n");

        singlyLinkedList.insertAt(6,3);
        singlyLinkedList.printSinglyLinkedList();
        System.out.println("Linked List Size: "+singlyLinkedList.size());

        singlyLinkedList.insertAt(6,6);
        singlyLinkedList.printSinglyLinkedList();
        System.out.println("Linked List Size: "+singlyLinkedList.size());

        System.out.println("Element At Given Index: "+singlyLinkedList.getAtIndex(9));

        singlyLinkedList.deleteAtIndex(3); // 5, 10, 14, 6, 17
        singlyLinkedList.printSinglyLinkedList(); // 10, 14, 6, 17
        System.out.println("Linked List Size: "+singlyLinkedList.size()); // 4
        System.out.println("Head: "+SinglyLinkedList.head.data);
        System.out.println("Tail: "+SinglyLinkedList.tail.data);
    }
}
