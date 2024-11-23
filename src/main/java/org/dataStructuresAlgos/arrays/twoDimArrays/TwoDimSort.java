package org.dataStructuresAlgos.arrays.twoDimArrays;

import java.util.Arrays;

public class TwoDimSort {

    public static void main(String[] args){
        int[][] costs = {{10,20}, {400,50}, {30, 100}, {30,20}};
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        System.out.println(Arrays.deepToString(costs));

        int total = 0;

        for(int i=0; i< costs.length/2; i++){
            total = total + costs[i][0];
        }

        for(int i=costs.length-1; i>=costs.length/2; i--){
            total = total + costs[i][1];
        }

        System.out.println(total);

        Integer[] numbers = {3, 1, 4, 1, 5, 9, 2, 6};
        Arrays.sort(numbers, (a, b) -> b - a);
        System.out.print(Arrays.toString(numbers));

    }
}
