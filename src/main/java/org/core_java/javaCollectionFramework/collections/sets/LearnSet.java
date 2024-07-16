package org.core_java.javaCollectionFramework.collections.sets;

import java.util.Set;
import java.util.TreeSet;

public class LearnSet {

    public static void main(String[] args){
        Set<Student> set = new TreeSet<>();
        set.add(new Student("Varun", 1));
        set.add(new Student("Varun", 1));
        set.add(new Student("Varun", 2));
        set.add(new Student("Ash", 2));

        System.out.println(set);
    }
}
