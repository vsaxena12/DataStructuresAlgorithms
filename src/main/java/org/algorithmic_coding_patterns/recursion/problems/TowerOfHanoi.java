package org.algorithmic_coding_patterns.recursion.problems;

import java.util.Stack;

/**
 *
 */
public class TowerOfHanoi {

    private static void towerOfHanoi(int n, int start, int end){
        if(n == 1)
            System.out.println("Move "+start+" to "+end);
        else{
            int aux = 6 - (start+end);
            towerOfHanoi(n-1, start, aux);
            System.out.println("Move "+start+" to "+end+" ");
            towerOfHanoi(n-1, aux, end);

        }
    }

    private static void towerOfHanoi(int n, char start, char aux, char end){
        if(n == 1)
            System.out.println("Move "+start+" to "+end);
        else{
            towerOfHanoi(n-1, start, end, aux);
            System.out.println("Move "+start+" to "+end+" ");
            towerOfHanoi(n-1, aux, start, end);

        }
    }

    private static void solveHanoi(int n) {
        Stack<Integer>[] rods = new Stack[3];
        for(int i=0; i<rods.length; i++){
            rods[i] = new Stack<>();
        }

        for(int i = n; i>0; i--){
            rods[0].push(i);
        }

        int numOfIterator = (int) Math.pow(2,n) - 1;
        int start, end;

        for(int i=1; i<=numOfIterator; i++){
            start = (i & i - 1) % 3; // Determine start peg for this move
            end = ((i | i - 1) + 1) % 3;

            if(!rods[start].isEmpty()){
                int topDisk = rods[start].pop();
                rods[end].push(topDisk);
                System.out.println("Move disk " + topDisk + " from " + (char) ('A' + start) + " to " + (char) ('A' + end));
            }
        }

    }

    /**
     * The time complexity of both the recursive and the iterative solutions for the Tower of Hanoi
     * problem is determined by the total number of moves made.
     * For n disks, the total number of moves required is 2^n - 1.
     * @param args
     */
    public static void main(String[] args){
        int n = 3; // Number of disks
        towerOfHanoi(n, 1, 3);

        System.out.println("----------------------------------------");
        towerOfHanoi(n, 'A', 'B', 'C'); // A, B and C are names of rods

        System.out.println("----------------------------------------");
        solveHanoi(n);
    }

}
