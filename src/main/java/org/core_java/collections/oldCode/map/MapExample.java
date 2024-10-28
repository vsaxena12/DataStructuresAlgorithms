package org.core_java.collections.oldCode.map;

import java.util.HashMap;
import java.util.Map;

class Book{
    int id;
    int quantity;
    String name;
    String author;
    String publisher;

    public Book(int id, int quantity, String name, String author, String publisher){
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

}
public class MapExample {

    public static void main(String[] args){
        Book book1 = new Book(1,500,"Game Of Thrones","RR Martain", "Wiley");
        Book book2 = new Book(2,421,"Iron Man","Stan Lee", "Comics");
        Book book3 = new Book(3,132,"IDK","XXX", null);

        Map<Integer, Book> map = new HashMap<>();
        map.put(101, book1);
        map.put(102, book2);
        map.put(103, book3);

        for(Map.Entry<Integer, Book> m: map.entrySet()){
            int key = m.getKey();
            Book b = m.getValue();

            System.out.println("Details Key: "+key);
            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity+"\n");
        }
    }
}
