package org.core_java.collections;

import java.util.ArrayList;
import java.util.List;

public class JavaCollections {

    public static void main(String[] args) {
        List<Character> list = new ArrayList<>(10); //Initial Capacity increaseable

        list.add('A');
        list.add('F');
        list.add('G');
        System.out.println(list);

        list.add(0,'B');
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        list.remove(Character.valueOf('B')); //Pass Element as object
        System.out.println(list);

        list.get(1);
        list.set(0,'D'); //Override element
        list.size();
        list.isEmpty(); //return boolean
        list.contains('E'); //returns boolean
        list.indexOf('A');

        System.out.println(list);

    }
}
