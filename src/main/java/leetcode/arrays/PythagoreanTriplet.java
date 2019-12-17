package leetcode.arrays;

import java.util.Arrays;

public class PythagoreanTriplet {

    public static void main(String[] args) {
        int a[] = {3, 2, 4, 6, 5}; //
       // print(a);
        findPythagorianTriplets(a);
        Arrays.sort(a);
       // print(a);

    }

    private static void findPythagorianTriplets(int[] a) {

        int[] squaredA = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            squaredA[i] = a[i] * a[i];
        }
        print(squaredA);
        Arrays.sort(squaredA);
        print(squaredA);

    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
