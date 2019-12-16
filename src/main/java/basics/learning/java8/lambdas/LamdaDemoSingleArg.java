package basics.learning.java8.lambdas;

public class LamdaDemoSingleArg {
    public static void main(String[] args) {
        LamdaISingleArg i = (n) -> {return n * n;};
        System.out.println(i.square(5));
    }
}

interface LamdaISingleArg {
    int square(int n);
}