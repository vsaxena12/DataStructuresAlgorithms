package org.dataStructuresAlgos.interviewProblems;

public class EqualSumPartition {
    public static int findPartitionIndex(int[] A, int[] B) {
        if (A.length != B.length || A.length == 0) return -1; // Arrays must be non-empty and of the same length

        int totalSumA = 0, totalSumB = 0;
        for (int i = 0; i < A.length; i++) {
            totalSumA += A[i];
            totalSumB += B[i];
        }

        int runningSumA = 0, runningSumB = 0;
        for (int k = 0; k < A.length; k++) { // k starts from 1 because we need at least one element in both partitions
            runningSumA = runningSumA + A[k];
            runningSumB = runningSumB + B[k];

            int remainingSumA = totalSumA - runningSumA;
            int remainingSumB = totalSumB - runningSumB;

            if (runningSumA == remainingSumA && runningSumA == runningSumB && runningSumA == remainingSumB) {
                return k+1; // Found the partition index
            }
        }

        return -1; // No partition index found
    }

    public static void main(String[] args) {
        int[] A = {-1, 0, 4, 0, 3};
        int[] B = {-2, 1, 4, -1, 4};

        int partitionIndex = findPartitionIndex(A, B);

        if (partitionIndex != -1) {
            System.out.println("Partition index found at: " + partitionIndex);
        } else {
            System.out.println("No partition index found.");
        }
    }
}
