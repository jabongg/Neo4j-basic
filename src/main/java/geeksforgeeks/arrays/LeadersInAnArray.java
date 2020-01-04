package geeksforgeeks.arrays;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class LeadersInAnArray {
    public static void main(String[] args) {
        //code

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int[] A = new int[N];

            for (int j = 0; j < N; j++) {
                A[j] = scan.nextInt();
            }

            leadersInArray(A);
        }
    }

    // O(n^2) time complexity
    public static void findLeadersInArray(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] < A[j]) {
                    break;
                }

                if (j == A.length - 1) {
                    System.out.print(A[i] + " ");
                }
            }
        }

        System.out.print(A[A.length - 1]);
        System.out.println();

    }

    // better O(n) time complexity but TLE
    public static void findLeaders(int[] A) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int currentLeader = A[A.length - 1];
        for (int j = A.length - 1; j >= 0; j--) {
            if (A[j] >= currentLeader) {
                //System.out.print(currentLeader + " ");
                leaders.add(currentLeader);
                currentLeader = A[j];
            }

            if (j == 0) {
                //System.out.print(currentLeader);
                leaders.add(currentLeader);
            }
        }

        Collections.reverse(leaders);

        for (Integer el : leaders) {
            System.out.print(el + " ");
        }

        System.out.println();
    }


    // better O(n) time complexity
    public static void leadersInArray(int[] A) {
        int potentialLeader = A[0];
        int currentMaxElement;
        for (int j = 0; j <= A.length - 1; j++) {
            if (A[j] >= potentialLeader) {
                potentialLeader = A[j];

                currentMaxElement  = (A[j + 1]);
                if (currentMaxElement < A[j]) {
                    System.out.print(potentialLeader + " ");
                    potentialLeader = A[j];
                }
            }
            //potentialLeader = A[j + 1];
            if (j == A.length - 1) {
                //System.out.print(potentialLeader +" ");
                System.out.print(A[A.length - 1]);
            }
        }

        System.out.println();
    }
}