package org.dataStructuresAlgos.recursion;

public class GCD {
    static int gcd(int a, int b){
        if(a < 0 || b < 0)
            return -1;
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
}
