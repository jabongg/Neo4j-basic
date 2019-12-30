package leetcode.weeklycontest._169;

import java.util.Scanner;

public class RandomUniqueNumbersAddToZero {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        if (N == 1) {
            System.out.println(0);
        }

        for (int i = N / 2; i > 0; i--) {
                System.out.print(" " + i + " " + -i);
        }

        if (N % 2 != 0) {
            System.out.print(" " + 0);
        }

    }

}
