package basics.learning.java8.strings;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Student s = new Student("ABC", 101, new Date());
        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        System.out.println(s.getJoiningDate());

        // Uncommenting below line causes error
        // s.regNo = 102;
        s.getJoiningDate().setTime(1576828087);
        System.out.println(s.getJoiningDate());
    }
}
