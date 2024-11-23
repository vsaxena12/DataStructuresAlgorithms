package org.dataStructuresAlgos.recursion.gfg;

public class PrintNumbers {

    public static void OneToN(int n, int original) {
        if (n > 0) {
            OneToN(n - 1, original);
            System.out.println(n);
            if (n == original)
                System.out.println("***************************************");
        }
    }

    public static void NToOne(int n){
        if(n == 0) {
            System.out.println("---------------------------------------");
        }
        else {
            System.out.println(n);
            NToOne(n-1);
        }
    }

    public static void main(String[] args){
        int n = 5;
        OneToN(n, 4); //Time Complexity -> O(n) Space Complexity -> O(n)
        System.out.println("---------------------------------------");
        NToOne(n); //Time Complexity -> O(n) Space Complexity -> O(n)

    }
}
