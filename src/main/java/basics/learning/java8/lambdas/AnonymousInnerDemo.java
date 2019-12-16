package basics.learning.java8.lambdas;

public class AnonymousInnerDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new thread created");
            }
        }).start();
    }
}

