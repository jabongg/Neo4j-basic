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

            findLeaders(A);
        }
    }

    public static void findLeaders(int[] A) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int currentLeader = A[A.length - 1];
        for (int j = A.length - 1; j >= 0; j--) {
            if (A[j] > currentLeader) {
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
}