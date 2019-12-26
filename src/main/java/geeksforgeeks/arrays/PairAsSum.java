package geeksforgeeks.arrays;

import java.util.Arrays;

/**
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 */
public class PairAsSum {
    public static void main(String[] args) {

        int[] A = {1, 4, 45, 6, 10, -8};
        int K = 2;

        System.out.println(hasArrayTwoCandidates(A, A.length, K));
    }

    // Function to check if array has 2 elements
    // whose sum is equal to the given value
    static boolean hasArrayTwoCandidates(int A[], int arr_size, int sum) {
        Arrays.sort(A); // sort the array first
        return containsPairWithGivenSum(A, sum);
    }

    static boolean containsPairWithGivenSum(int[] A, int sum) {
        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            if (A[i] + A[j] == sum) {
                return true;
            }
            if (A[i] + A[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
