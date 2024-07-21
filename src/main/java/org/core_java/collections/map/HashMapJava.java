package org.core_java.collections.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapJava {

    private final Map<Integer, String> map;

    public HashMapJava(){
        this.map = new HashMap<>();
    }

    public void mapBasicOperations(){
        //V put(K, V); //Put key value pair in a hashmap
        map.put(1,"Test");
        map.put(2,"Map");
        map.put(3,"Data");
        map.put(4,"Structures");

        System.out.println("Map: "+map);

        boolean isKeyPresent = map.containsKey(3);
        System.out.println("Is Key Present: "+isKeyPresent);

        boolean isValuePresent = map.containsValue("Data");
        System.out.println("Is Key Present: "+isValuePresent);

        // get value when key is passed
        String value = map.get(1);
        System.out.println("Get value when key is passed: "+value);

        boolean empty = map.isEmpty();
        System.out.println("Is map empty: "+empty);

        String val = map.remove(2); // return value
        System.out.println("Remove 102: "+val);
        System.out.println("Map: "+map);

        //Keys are unique in HashMaps
        map.replace(3,"Hashmap");
        System.out.println("Map: "+map);

        int size = map.size();
        System.out.println("Map size: "+size);

        for(Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println(entry.getKey()+" -> "+entry.getValue()+" "+entry);
        }
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        System.out.println("Set: "+set);

        // Comparing By Key - Map
        System.out.println("-----------------------------------------------");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        System.out.println("-----------------------------------------------");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);

        System.out.println("-----------------------------------------------");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        System.out.println("-----------------------------------------------");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

        map.putIfAbsent(103, "Gaurav");
        System.out.println("After invoking putIfAbsent() method ");
        for(@SuppressWarnings("rawtypes") Map.Entry m:map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        HashMap<Integer,String> map2=new HashMap<Integer,String>();
        map2.put(104,"Ravi");
        System.out.println("Map2"+map2);
        map2.putAll(map);
        System.out.println("After invoking putAll() method "+map2);

        for(@SuppressWarnings("rawtypes") Map.Entry m:map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
        map.clear(); // return void
        System.out.println("Map: "+map); //Map is cleared

        Map<Integer, String> map3 = new HashMap<>(1);
        map3.put(1,"M");
        map3.put(2,"M");
        map3.put(3,"M");
        System.out.println("Map3: "+map3+" Capacity: "+map3.size());

    }

    public static void main(String[] args){
        HashMapJava hashMap = new HashMapJava();
        hashMap.mapBasicOperations();
    }
}
