package org.dataStructuresAlgos.recursion;

public class Power {
    static double power(int base, int exp){
        if(exp < 0) //Unintentional case
            return 1.0 / power(base, -exp);
        if(exp == 0) //Base case
            return 1;
        return base * power(base, exp-1); //Recursion
    }
}
