package basics.learning.java8.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArraylistNull {
    public static void main(String[] args) {
        ArrayList<Object> list1 = new ArrayList<Object>();
        ArrayList<Object> list2 = new ArrayList<Object>();
        list1.add(null);
        list1.add(null);
        list1.add(null);
        list1.add(null);
        list1.add(null);

        System.out.println(list1.contains(null));  //prints true!
        System.out.println(list2.contains(null));  //prints false

        System.out.println(list1.size());  //prints 1
        System.out.println(list2.size());  //prints 0


        Set<Object> s = new HashSet<>();
        s.add(null);
        s.add(null);
        s.add(null);
        s.add(null);
        s.add(null);
        s.add(null);

        System.out.println(s.size());
        System.out.println(s.contains(null));



    }
}
