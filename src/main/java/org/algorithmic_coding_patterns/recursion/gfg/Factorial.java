package org.algorithmic_coding_patterns.recursion.gfg;

interface Task {
    void execute();
}

public abstract class Factorial {

    private static long fact(int n){
        if(n == 1 || n == 0)
            return 1;
        else
            return n * fact(n-1);//T(O(n)) and S(O(n))
    }

    public static void main(String[] args){
        int n = 10;
        Task factorialTask = () -> System.out.println("Find factorial: "+fact(n));
        findTime(factorialTask);

        Task factorialTask2 = () -> System.out.println("Find factorial Terminal: "+fact2(n));
        findTime(factorialTask2);
    }

    private static long fact2(int n) {
        long result = 1;
        int i = 1;
        for(i=2; i<=n; i++){
            result = result * i;
        }

        return result;
    }

    private static void findTime(Task task){
        double startTime = System.nanoTime()/1000.0;
        task.execute();
        double endTime = System.nanoTime()/1000.0;

        double total = (endTime-startTime);
        System.out.printf("Elapsed time: %.3f microseconds\n", total);
    }
}
