package geeksforgeeks.arrays;

/**
 * Let us discuss Longest Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic Programming.
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * longest-increasing-subsequence
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] A = {78, 22, 9, 33, 21, 50, 41, 60, 80};
        int[] lis = new int[A.length];

        // since each element itself is an increasing subsequence
        // we will initialize all elements of lis by 1;

        for (int i = 0; i < lis.length; i++) {
            lis[i] = 1;
        }

        int[] returnedArray = lis(A, lis);

        increasingSubsequence(returnedArray, A);
        System.out.println();
        System.out.println(findMaxElement(returnedArray));

    }

    private static void increasingSubsequence(int[] lis, int[] A) {
        if (A[0] < A[1]) {
            System.out.print(A[0] + " ");
        }

        for (int i = 0; i < lis.length - 1; i++) {
            if (lis[i + 1] > lis[i]) {
                System.out.print(A[i + 1] + " ");
            }
        }
    }

    /**
     * this method calculates the longest increasing subsequence
     * time complexity : O(n2)
     * @param A
     * @param lis
     * @return
     */
    public static int[] lis(int[] A, int[] lis) {

        // iterate over the array A
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {

                // check conditions if A[i] > A[j]
                if (A[i] > A[j]) {

                    // check condition if lis[i] is already greater than lis[j]
                    // then do not update the value of lis[i]
                    if (lis[i] < lis[j] + 1) {
                        lis[i] = lis[j] + 1;
                    }
                }
            }
        }

        return lis;
    }

    /**
     * this method calculates the maximum element from any given array
     * @param A
     * @return
     */
    public static int findMaxElement(int[] A) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }

        return max;
    }
}
