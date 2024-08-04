package org.data_structures.arrays;

public class Sorting {
        
        public static void main(String[] args){
                int[] input = {1,2,3,4,5};
                int j = 0;
                for (int i = 0; i < input.length; i++) {
                        int key = input[i];
                        j = i - 1;
                        while (j >= 0 && input[j] > key) {
                        if (input[j] > key) {
                                int tmp = input[j];
                                input[j] = key;
                                input[j + 1] = tmp;
                                j--;
                                }
                        }
                }
        }
}
