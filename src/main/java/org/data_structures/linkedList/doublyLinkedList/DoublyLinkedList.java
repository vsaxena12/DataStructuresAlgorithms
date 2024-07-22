package org.data_structures.linkedList.doublyLinkedList;

class ListNode{
    private int data;
    private ListNode next;
    private ListNode prev;

    public ListNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    public ListNode getNext(){
        return next;
    }

    public void setPrev(ListNode prev){
        this.prev = prev;
    }

    public ListNode getPrev(){
        return prev;
    }
}

class DoublyLinkedList {

    private ListNode head;

    public DoublyLinkedList() {
        this.head = null;
    }

    // Insert At Head
    public void insertAtHead(int data){
        ListNode newNode = new ListNode(data);
        if(head != null) {
            newNode.setNext(head);
            head.setPrev(newNode);
        }
        head = newNode;
        head.setPrev(null);
    }

    public void insertAtEnd(int data){
        ListNode newNode = new ListNode(data);
        if(head == null) {
            head = newNode;
            head.setPrev(null);
            head.setNext(null);
        }else{
            ListNode currentNode = head;
            
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
            newNode.setPrev(currentNode);
        }
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
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtEnd(1);
        list.insertAtHead(0);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        
        list.insertAtHead(-1);
        
        System.out.println("List from Linked List: \n");
        list.print(list.head);
        System.out.println("\nPrev: "+list.head.getPrev());

        System.out.println("\nNext: "+list.head.getNext());
        System.out.println("\nNext->Next: "+list.head.getNext().getNext());
    }
}
