package geeksforgeeks.arrays;

import java.util.*;
        import java.lang.*;
        import java.io.*;
public class Sort012 {
    public static void main (String[] args)
    {
        //code


        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        while (T-- > 0) {
            int N = scan.nextInt();
            int[] A = new int[N];

            for (int j = 0; j < N; j++) {
                A[j] = scan.nextInt();
            }

            sortArrayOf012(A);
        }
    }

    public static void sortArrayOf012(int[] A) {
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;
        int currentIndex = 0;

        for (int i = 0; i < A.length; i++) {


            switch(A[i]) {
                case 0 :
                    count_0++; break;
                case 1 :
                    count_1++;	  break;
                case 2 :
                    count_2++;break;

                default:
            }

        }

        for (int i = 0; i < count_0; i++) {
            A[currentIndex++] = 0;
        }

        for (int i = 0; i < count_1; i++) {
            A[currentIndex++] = 1;
        }

        for (int i = 0; i < count_2; i++) {
            A[currentIndex++] = 2;
        }

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
}