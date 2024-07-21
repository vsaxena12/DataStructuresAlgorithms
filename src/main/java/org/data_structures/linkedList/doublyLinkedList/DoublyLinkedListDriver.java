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

    

    public static void main(String[] args){

    }
}
