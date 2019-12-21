package geeksforgeeks.trees.stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStrings {
    public static void main(String[] args) {
        //code
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            String str = scanner.next();
            reverseWords(str);
        }
    }

    public static void reverseWords(String str) {
        String[] stringArray = str.split("\\.");

        Stack<String> s = new Stack<>();
        for (int i = 0; i < stringArray.length; i++) {
            s.push(stringArray[i]);
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop());
            if (s.size() != 0)
                System.out.print(".");
        }

    }

}
