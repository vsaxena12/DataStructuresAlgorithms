package org.core_java.collections;

import java.util.HashMap;
import java.util.Map;

public class MapSetClass {

    public static void mapMethod() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");

        System.out.println(map);

        int size = map.size();
        System.out.println(size); //5

        boolean isEmpty = map.isEmpty();
        System.out.println(isEmpty); //false

        //map.clear();

        //Get Value when Key is passed
        String value = map.get(2);
        System.out.println(value); //two

        value = map.get(10);
        System.out.println(value); //null

        String defaultValue = "Hello";
        value = map.getOrDefault(6, defaultValue);
        System.out.println(value); //Hello

        //map.put(K,V);
        map.putIfAbsent(5, "");
        map.putIfAbsent(6, "six");
        System.out.println(map);

        //map.putAll(map2);

        boolean containsValue = map.containsValue("three");
        System.out.println(containsValue);

        boolean containsKey = map.containsKey(3);
        System.out.println(containsKey);

        String returnValue = map.remove(6);
        System.out.println(returnValue);

        //Loops
        for(Map.Entry<Integer, String> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.getKey()
                    + " " + mapEntry.getValue());
        }
    }

    public static void setMethod() {

    }
}
