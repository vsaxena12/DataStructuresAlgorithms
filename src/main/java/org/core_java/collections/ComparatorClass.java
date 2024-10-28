package org.core_java.collections;

import java.util.*;

public class ComparatorClass {
    public static void comparatorClass(){

        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if(a%10 > b%10)
                    return 1;
                else
                    return 0;
            }
        };

        List<Integer> list = new ArrayList<Integer>();
        list.add(43);
        list.add(31);
        list.add(72);
        list.add(29);
        list.add(50);

        Collections.sort(list, comparator);
        System.out.println(list);

        int[][] intervals = {{0,30},{5,10},{15,20}};
        boolean result = canAttendMeetings(intervals);
        System.out.println("Can book room: "+result);

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));



        for(int i=0; i<intervals.length; i++){
            System.out.println(Arrays.toString(intervals[i]));
        }
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (overlap(intervals[i], intervals[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean overlap(int[] interval1, int[] interval2) {
        return (interval1[0] >= interval2[0] && interval1[0] < interval2[1])
                || (interval2[0] >= interval1[0] && interval2[0] < interval1[1]);
    }

}
