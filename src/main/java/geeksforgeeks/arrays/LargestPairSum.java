package geeksforgeeks.arrays;

import java.util.Scanner;

/**
 * Find the largest pair sum in an unsorted array
 * Given an unsorted of distinct integers, find the largest pair sum in it. For example, the largest pair sum in {12, 34, 10, 6, 40} is 74.
 * Difficulty Level: Rookie
 * Expected Time Complexity: O(n) [Only one traversal of array is allowed]
 */
public class LargestPairSum implements Cloneable {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        while (T-- > 0) {
            int N = scan.nextInt();
            int[] A = new int[N];

            for (int j = 0; j < N; j++) {
                A[j] = scan.nextInt();
            }

            int largestPairSum = findLargestPairSum(A);
            System.out.println(largestPairSum);
        }
    }

    private static int findLargestPairSum(int[] A) {
        int L = 0;
        int R = A.length - 1;
        int lMax = 0;
        int rMax = 0;


        while (L < R) {
            if (A[L] > A[R]) {
                if (lMax < A[L]) {
                    lMax = A[L];
                }
                L++;
            } else {
                if (rMax < A[R]) {
                    rMax = A[R];
                }
                R--;
            }
        }
        return lMax + rMax;
    }
}