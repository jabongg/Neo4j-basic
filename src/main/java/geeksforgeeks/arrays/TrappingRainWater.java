package geeksforgeeks.arrays;

import java.util.Scanner;

public class TrappingRainWater {
    public static void main(String[] args) {
        //code

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        while (T-- > 0) {
            int N = scan.nextInt();
            int[] A = new int[N];

            for (int j = 0; j < N; j++) {
                A[j] = scan.nextInt();
            }

            int trappedWaterVolume = findTrappedWaterVolume(A);
            System.out.println(trappedWaterVolume);
        }
    }

    //7 4 0 19 0 5 10
    private static int findTrappedWaterVolume(int[] A) {
        int left = 0, leftMax = 0, rightMax = 0, trappedRainWaterVolume = 0;
        int right = A.length - 1;

        while (left < right) {
            if (A[left] < A[right]) {
                if (A[left] > leftMax) {
                    leftMax = A[left];
                } else {
                    trappedRainWaterVolume = trappedRainWaterVolume + (leftMax - A[left]);
                }
                left++;
            }

            else {
                if (A[right] > rightMax) {
                    rightMax = A[right];
                } else {
                    trappedRainWaterVolume = trappedRainWaterVolume + (rightMax - A[right]);
                }
                right--;
            }
        }
        return trappedRainWaterVolume;
    }
}
