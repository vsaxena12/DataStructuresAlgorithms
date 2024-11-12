package org.data_structures.computationalMathematics.problems;

public class GCD_LCM {

    public static void calculateTimeLapse(){
        long startTime = System.nanoTime();
        System.out.println("GCD is: "+bruteGCD(20,15));
        long endTime = System.nanoTime();
        double timeTakenInSecs = (endTime-startTime)/1e9;
        String time = String.format("%e",timeTakenInSecs);
        System.out.println("Time taken in Brute force: "+time+"seconds");

        startTime = System.nanoTime();
        System.out.println("GCD is: "+optimizedGCD(20,15));
        endTime = System.nanoTime();
        timeTakenInSecs = (endTime-startTime)/1e9;
        time = String.format("%e",timeTakenInSecs);
        System.out.println("Time taken in Optimized solution: "+time +" seconds");
    }

    public static void print(){
        System.out.println("GCD is: "+optimizedGCD(20,15));
        System.out.println("LCM is: "+optimizedLCM(20,15));
    }

    private static int bruteGCD(int a, int b){
        //O(min(a,b))
        int min = 0;
        if(a>b){
            min = b;
        }else{
            min = a;
        }
        for(int i=min; i>-1; i--){
            if(a%i == 0 && b%i == 0)
                return i;
        }
        return 1;
    }

    private static int optimizedGCD(int a, int b){
        ////O(log(min(a,b)))
        while(a!=0 && b!=0){
            if(a>b){
                a=a%b;
            }else{
                b=b%a;
            }
        }

        if(a!=0)
            return a;
        else
            return b;
    }

    private static int optimizedLCM(int a, int b){
        return a*b/optimizedGCD(a, b);
    }
}
