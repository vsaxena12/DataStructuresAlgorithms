package org.codingParadigm.dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

    public static long gridTraveller(long m, long n){
        if(m == 1 && n == 1)
            return 1;
        if(m == 0 || n == 0)
            return 0;

        return gridTraveller(m-1, n) + gridTraveller(m, n-1);
    }

    public static long gridTravellerMemo(long m, long n, Map<String, Long> memo){
        String key = m + "," + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if(m == 1 && n == 1)
            return 1;
        if(m == 0 || n == 0)
            return 0;

        memo.put(key, gridTravellerMemo(m - 1, n, memo) + gridTravellerMemo(m, n - 1, memo));
        return memo.get(key);
    }

    public static void main(String[] args){
        System.out.println("Number of Grid Travelling: "+GridTraveller.gridTraveller(1,1));
        System.out.println("Number of Grid Travelling: "+GridTraveller.gridTraveller(2,3));
        System.out.println("Number of Grid Travelling: "+GridTraveller.gridTraveller(3,3));


//        long startTime = System.nanoTime();
//        long gridTravelled = GridTraveller.gridTraveller(18,18);
//        System.out.println("Number of Grid Travelling: "+gridTravelled); //2333606220
//        long endTime = System.nanoTime();
//        long totalTime = endTime - startTime;
//        double totalTimeInSecs = TimeUnit.NANOSECONDS.toSeconds(totalTime);
//        System.out.println("The total time elapsed is " + totalTimeInSecs + " seconds");

        Map<String, Long> memo = new HashMap<>();
        long result = gridTravellerMemo(18, 18, memo);
        System.out.println("Number of Grid Travelled Memo: "+result);
    }
}
