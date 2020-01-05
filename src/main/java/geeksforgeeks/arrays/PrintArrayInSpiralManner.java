package geeksforgeeks.arrays;

public class PrintArrayInSpiralManner {

    /**
     * 2 4 6 8
     * 5 9 12 16
     * 2 11 5 9
     * 3 2 1 8
     *
     * @param args
     */
    public static void main(String[] args) {

        int[][] A = {
                { 52, 4, 6, 7, 78},
                { 35, 19, 12, 16, 45},
                { 92, 11, 5, 89, 65},
                { 3, 62, 10, 18, 33}
        };

        printArraySpirally(A);
    }

    private static void printArraySpirally(int[][] A) {
        int T, R, B, L;
        T = 0;
        R = A[0].length - 1;
        B = A.length - 1;
        L = 0;

        //int direction = 0;
        while (T <= B && L <= R) {

            // code order is very important

            // left -> right direction
            for (int i = L; i <= R; i++) {
                System.out.println(A[T][i]);
            }
            T++;

            // top -> down direction
            for (int i = T; i <= B; i++) {
                System.out.println(A[i][R]);
            }
            R--;

            // right -> left direction
            for (int i = R; i >= L; i--) {
                System.out.println(A[B][i]);
            }
            B--;

            // down -> top direction
            for (int i = B; i >= T; i--) {
                System.out.println(A[i][L]);
            }
            L++;

        }
    }
}
