package geeksforgeeks.arrays;

public class ContiguousArray {
    //Given an unsorted array A of size N of non-negative integers,
    // find a continuous sub-array which adds to a given number S.

    public static void main(String[] args) {

        int[] A = {4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2, 11};
        findMaximumSumSubarray(A);
    }

    public static void findMaximumSumSubarray(int[] A) {

        int maxSoFar = A[0];
        int maxEndingHere = 0;

        int start = 0;
        int end = 0;
        int s = 0;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            maxEndingHere = maxEndingHere + A[i];
            sum = sum + A[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;

                start = s;
                end = i;
            }

            if (maxEndingHere < 0) {
                maxEndingHere = 0;

                s = i + 1;
            }
        }

        System.out.println("start and end indexes are : " + start + " -> " + end);
        System.out.println("sum : " + sum); // not correct : todo
    }

}
