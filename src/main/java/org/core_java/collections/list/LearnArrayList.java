package org.core_java.collections.list;

import java.util.ArrayList;
import java.util.List;

public class LearnArrayList {

    public static void main(String[] args){
        List<String> studentName = new ArrayList<>();

        studentName.add("Var");
        studentName.add("Saxena");
        System.out.println("Size: "+studentName.size());
        studentName.add(1,"S");
        System.out.println(studentName);

        String i = String.valueOf(0);
        System.out.println(i);

    }
}
