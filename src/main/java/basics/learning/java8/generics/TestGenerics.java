package basics.learning.java8.generics;

public class TestGenerics {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>(15);
        Box<String> stringBox = new Box<>();
        Box box = stringBox;
        box.setObj(8);
    }
}
