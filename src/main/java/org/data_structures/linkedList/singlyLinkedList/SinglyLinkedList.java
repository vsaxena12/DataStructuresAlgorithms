package org.data_structures.linkedList.singlyLinkedList;

class ListNode {
    private int data;
    private ListNode next;
    public ListNode(int data) {
        this.data = data;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
}

public class SinglyLinkedList{

    private ListNode head;
    private int traverse;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.traverse = 0;
        this.size = 0;
    }

    public int length(ListNode head){
        int length = 0;
        ListNode current = head;
        while(current != null){
            length++;
            current = current.getNext();
        }
        return length;
    }

    //Insertion at the beginning, end, intermediate
    public void insertAtBeginning(int data){
        ListNode newNode = new ListNode(data);
        if(head != null) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    //Insertion at the end
    public void insertAtEnd(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
        }else{
            ListNode current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    //Insertion at the middle
    public void insertAtMid(int index, int data){
        ListNode newNode = new ListNode(data);
        if(index == 0){
            head = newNode;
        }else{
            ListNode current = head;
            while(current.getNext() != null){
                if(index-1 == traverse){
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    break;
                }
                current = current.getNext();
                traverse++;
            }
            current.setNext(newNode);
        }
    }

    //Search and Get Element
    public boolean searchElement(int element) {
        ListNode current = head;
        while(current != null){
            if(current.getData() == element){
                return true;
            }else{
                current = current.getNext();
            }
        }
        return false;
    }

    // Deletion at the beginning
    public void deleteAtHead() {
        if(head != null) {
            System.out.println("Element deleted: "+head.getData());
            head = head.getNext();
        }
    }

    // Deletion at the end
    public void deleteAtTail() {
        if(head == null) {
            return;
        }
        if(head.getNext() == null) {
            head = null;
            return;
        }
        ListNode current = head;
        while(current.getNext().getNext() != null) {
            current = current.getNext();
        }
        System.out.println("Element deleted: "+current.getNext().getData());
        current.setNext(null);

    }

    // Deletion at a specific index
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length(head)) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if(index == 0) {
            deleteAtHead();
            return;
        }
        ListNode current = head;
        for(int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        System.out.println("Element deleted: "+current.getNext().getData());
        current.setNext(current.getNext().getNext());

    }




    //Print LinkedList
    public void print(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }

    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(4);
        list.insertAtEnd(11);
        list.insertAtEnd(2);
        list.insertAtEnd(9);
        list.insertAtEnd(7);
        list.insertAtMid(2,21);

        list.insertAtBeginning(1);
        list.insertAtEnd(34);
        list.insertAtBeginning(5);
        System.out.println("List from Linked List: \n");
        list.print(list.head);
        System.out.println("\nLength: "+list.length(list.head));

        System.out.println("\nSearch Element: "+list.searchElement(10));

        list.deleteAtHead();
        list.deleteAtTail();
        list.deleteAtIndex(0);

        System.out.println("\nList after deletions: \n");
        list.print(list.head);
        System.out.println("\nLength: "+list.length(list.head));
    }


}
