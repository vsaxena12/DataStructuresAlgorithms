package org.recursion.gfg;

public class Sum {

    public static void main(String[] args){
        int n = 3;
        System.out.println(totalSum(n));
    }

    private static int totalSum(int n) {
        if(n==1){
            return 1;
        }
        return n + totalSum(n-1);
    }
}
