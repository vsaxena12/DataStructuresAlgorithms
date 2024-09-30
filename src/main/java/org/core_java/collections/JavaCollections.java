package org.core_java.collections;

import java.util.Arrays;
import java.util.List;

public class JavaCollections {

    /**
     * DSA Notes/JavaCollectionsFramework/Java Collection Framework.md
     */
    public static void main(String[] args) {
        // Arrays
        int[] arrays = new int[10];

        for(int i = 0; i < arrays.length; i++){
            if(i % 2 == 0){
                arrays[i] = i;
            } else {
                arrays[i] = i - 5;
            }
        }

        System.out.println(Arrays.toString(arrays));

        Arrays.sort(arrays, 2, 4);
        System.out.println("Sorted In Range: "+Arrays.toString(arrays));

        Arrays.sort(arrays);
        int containsElement = Arrays.binarySearch(arrays, 2);
        System.out.println("Sorted: "+Arrays.toString(arrays));
        if(arrays[containsElement] == 2){
            System.out.println("Is 2 present: "+arrays[containsElement]);
        }

        Arrays.fill(arrays, -1);
        System.out.println(Arrays.toString(arrays));
        Arrays.fill(arrays, 2, 4, -100);
        System.out.println(Arrays.toString(arrays));

        int[] nums = {1,2,3};
        int[] copy = Arrays.copyOf(nums, 5);
        System.out.println(Arrays.toString(copy));

        int[] copyOfRange = Arrays.copyOfRange(nums, 2, 8);
        System.out.println(Arrays.toString(copyOfRange));

        List<int[]> list = Arrays.asList(nums); //[[I@18b4aac2]
        System.out.println(list);

        //Strings


        //HashMaps


        //HashSets
    }
}
