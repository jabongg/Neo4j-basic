package geeksforgeeks.arrays;

import java.util.Scanner;

public class MinimumPlatforms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arrival = new int[N];
            int[] departure = new int[N];

            for (int i = 0; i < N; i++) {
                arrival[i] = scanner.nextInt();
            }

            for (int i = 0; i < N; i++) {
                departure[i] = scanner.nextInt();
            }

            int minimumNumberOfPlatforms = calculateMinimumPlatformsRequired(arrival, departure, N);
            System.out.println(minimumNumberOfPlatforms);
        }
    }

    private static int calculateMinimumPlatformsRequired(int[] arrival, int[] departure, int N) {
        int numberOfPlaforms = 0;
        int[] dayTime = new int[2401];
        dayTime[2400] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = arrival[i]; j <= departure[i]; j++)
                dayTime[j]++;
        }

        for (int i = 0; i < 2400; i++) {
            if (numberOfPlaforms < dayTime[i])
                numberOfPlaforms = dayTime[i];
        }
        return numberOfPlaforms;

    }


    public static void print(int[] A) {
        for (int el : A) {
            System.out.print(el + " ");
        }
    }

}
