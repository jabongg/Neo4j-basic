package geeksforgeeks.arrays;

public class CountZeros {


    public static void main(String[] args) {
        int[][] A = {{0, 0, 0}, {0, 0, 1}, {0, 1, 1}};
        System.out.println(countZeros(A));
    }
    /*you are required to complete this method*/
    private static int countZeros(int A[][])
    {
        int zerosCount = 0;
        // Your code here
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) {
                    zerosCount++;
                }
            }
        }
        return zerosCount;
    }
}
