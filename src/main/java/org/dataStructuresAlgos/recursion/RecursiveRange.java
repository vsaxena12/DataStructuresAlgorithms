package org.dataStructuresAlgos.recursion;

public class RecursiveRange {
    public static int recursiveRange(int num) {
        //  TODO
        if(num == 0)
            return 0;
        return num + recursiveRange(num-1);
    }
}
