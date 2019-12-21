package basics.learning.java8.strings;

public class StringToCharJava {

    public static void main(String[] args) {
        String str = "journaldev";

        //string to char array
        char[] chars = str.toCharArray();
        System.out.println(chars.length);

        System.out.println(new String(chars));

        System.out.println("unhappy".substring(2)); //returns "happy"
        System.out.println("Harbison".substring(3)); //returns "bison"
        System.out.println("emptiness".substring(9));// returns "" (an empty string)

    }

    public native void hello();

}
