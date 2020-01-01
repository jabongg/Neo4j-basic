package com.datastructures.algorthims.arrays;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] A = {3, -4, 2, 5, -1, 6, 2};
        maximumSum(A);
    }

    // brute force approach
    public static int maximumSum(int[] A) {
        int currentSum;
        int startIndex = -1;
        int endIndex = -1;
        int maximumSum = Integer.MIN_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            currentSum = A[i];
            for (int j = i + 1; j < A.length; j++) {
                currentSum = currentSum + A[j];

                if (maximumSum < currentSum) {
                    maximumSum = currentSum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }

        System.out.println(startIndex + " " + endIndex);
        System.out.println(maximumSum);
        return maximumSum;
    }
}
