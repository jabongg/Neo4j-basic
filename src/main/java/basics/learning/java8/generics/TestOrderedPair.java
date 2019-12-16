package basics.learning.java8.generics;

public class TestOrderedPair {
    public static void main(String[] args) {
       Pair<Integer, String> carotPair = new OrderedPair<>(new Integer(1), "carot"); // can pass primitive/Boxed Value
       Pair<String, String> hondaPair = new OrderedPair<>("Client-Honda", "Honda");
    }
}
