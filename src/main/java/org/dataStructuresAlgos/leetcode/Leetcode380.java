package org.data_structures.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Leetcode380 {

    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    Random random = new Random();

    public Leetcode380() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        //E remove(I)
        int lastElement = list.get(list.size() - 1);
        int idx = map.get(val);
        list.set(idx, lastElement);
        map.put(lastElement, idx);

        map.remove(val);
        list.remove(list.size() - 1);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }


    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    public static void main(String[] args){
        Leetcode380 leetcode380 = new Leetcode380();
        leetcode380.insert(0);
        leetcode380.insert(1);
        leetcode380.remove(0);
        leetcode380.insert(2);
        leetcode380.remove(1);

        System.out.println(leetcode380.getRandom());

        System.out.println("List: "+leetcode380);
    }
}
