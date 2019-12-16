package basics.learning.java8.strings;


public class StringBuilderDemo {

    public static void main(String[] args) {
        String city = null;
        StringBuilder address = new StringBuilder();
        address.append("jmd megapolis").append("minda").append(city).append("Haryana").append("India");

        System.out.println(address);
    }
}
