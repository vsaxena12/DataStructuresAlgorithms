package org.recursion;

public class Decimal2Binary {
    static int decimal2Binary(int num){
        if(num == 0){
            return 0;
        }
        return num%2 + 10*decimal2Binary(num/2);
    }
}
