package org.dataStructuresAlgos.recursion;

import java.util.Arrays;

class OddFunction {
    boolean run(int num) {
        if (num % 2 == 0) {
            return false; }
        else {
            return true;
        }
    }
}

public class SomeRecursive {

    public static boolean someRecursive(int[] arr, OddFunction odd) {
        // TODO
        if (arr.length == 0 )
            return false;
        if(odd.run(arr[0]))
            return true;
        return someRecursive(Arrays.copyOfRange(arr, 1, arr.length), odd);
    }

}
