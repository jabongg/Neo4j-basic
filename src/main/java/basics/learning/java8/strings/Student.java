package basics.learning.java8.strings;

import java.util.Date;

public class Student {
    private final String name;
    private final int regNo;
    private final Date joiningDate;

    public Student(String name, int regNo, Date joiningDate) {
        this.name = name;
        this.regNo = regNo;
        this.joiningDate = joiningDate;
    }

    public String getName() {
        return name;
    }

    public int getRegNo() {
        return regNo;
    }

    public Date getJoiningDate() {

        //return joiningDate; // This will make your class mutable.

        // Instead use,
        return new Date(this.joiningDate.getTime()); // This will make sure your date field cannot be changed.

    }
}
