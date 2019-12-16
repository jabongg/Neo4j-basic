package basics.learning.java8.enums;

import java.util.EnumSet;

public enum Day {
    MONDAY, WEDNESDAY, FRIDAY, SATURDAY, SUNDAY;

    final Day BOHRDAY = null;
    public static void getDays() {
        System.out.printf("day : ");
        for (Day d : Day.values()) {
            System.out.printf( d + " ");
        }
    }


    public static void main(String[] args) {
        System.out.print("Weekdays: ");
        for (Day d : EnumSet.range(Day.MONDAY, Day.FRIDAY))
            System.out.print(d + " ");
    }

}
