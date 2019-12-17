package leetcode.arrays;

public class RotateArrays {

    public static void main(String[] args) {
        int[] elements = {1, 2, 54, -5, 343, 17};
        int rotationCount = 2;
        String rotationDirection = "left";
        rotateArray(elements, rotationCount, rotationDirection);
        }

    private static void rotateArray(int[] elements, int rotationCount, String rotationDirection) {

        switch (rotationDirection) {
            case "left" :
                arrayRotateLeft(elements, rotationCount);
                break;

            case "right":
                arrayRotateRight(elements, rotationCount);
                break;
        }
    }

    /**
     * rotate array by k elements to the right
     * @param elements
     * @param rotationCount
     */
    public static void arrayRotateRight(int[] elements, int rotationCount) {
        int temp = 0;
        for (int j = rotationCount; j > 0; j--) {
            temp = elements[elements.length - 1];
            for (int i = elements.length - 1; i > 0; i--) {
                elements[i] = elements[i - 1];
                if (i - 1 == 0) {
                    elements[i - 1] = temp;
                }
            }
        }

        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }

    }


    /**
     * rotate array by k elements to the left
     * @param elements
     * @param rotationCount
     */
    public static void arrayRotateLeft(int[] elements, int rotationCount) {
        int temp = 0;
        for (int j = rotationCount; j > 0; j--) {
            temp = elements[0];
            for (int i = 0; i < elements.length - 1; i++) {
                elements[i] = elements[i + 1];
                if (i + 1 == elements.length - 1) {
                    elements[i + 1] = temp;
                }
            }
        }

        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }

    }
}
