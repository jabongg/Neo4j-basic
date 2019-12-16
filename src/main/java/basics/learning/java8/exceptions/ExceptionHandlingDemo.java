package basics.learning.java8.exceptions;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        try {
            double d = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("hello world!");
    }
}
