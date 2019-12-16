package externals.tostring.tojson;

public class JavaToStringToJsonConvertor {

    public static void main(String[] args) {
        Employee emp1 = new Employee("Aaryan", 111);
        Employee emp2 = new Employee("Aarjoo", 112);

        System.out.println(emp1);
        System.out.println(emp2);

        String emp1Str = String.valueOf(emp1);
        System.out.print(emp1Str);


    }

    private void prepareToStringObject(String emp1Str) {

    }

    private void getEquivalentToStringString(Object emp1) {

    }
}
