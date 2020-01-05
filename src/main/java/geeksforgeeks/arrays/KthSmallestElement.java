package geeksforgeeks.arrays;

import java.util.*;

public class KthSmallestElement {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int[] A = new int[N];

            for (int j = 0; j < N; j++) {
                A[j] = scan.nextInt();
            }

            int K = scan.nextInt();
            int kthElement = findKthSmallestElement(A, K);
            System.out.println(kthElement);
        }
    }

    private static int findKthSmallestElement(int[] A, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int kthElement = 0;

        for (int el : A) {
            minHeap.add(el);
        }

        while (K-- > 0) {
            kthElement = minHeap.poll();
        }
        return kthElement;
    }
}
