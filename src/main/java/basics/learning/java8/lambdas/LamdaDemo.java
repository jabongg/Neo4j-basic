package basics.learning.java8.lambdas;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LamdaDemo {

    private static final Logger JUBILANT_LOGGER = LoggerFactory.getLogger("jubilantLogger");
    private static final Logger LOGINEXT_LOGGER = LoggerFactory.getLogger("loginextLogger");


    public static void main(String[] args) {
        LamdaI lamda = (a, b) -> System.out.println(a + b);
        lamda.add(15, 30);

        LamdaI i = new Demo();
       // i.add(15, 20);

        JUBILANT_LOGGER.info("hello world! + JUBILANT + jubilantt" + System.currentTimeMillis());
        LOGINEXT_LOGGER.info("hello world! + LOGINEXT + loginextt" + System.currentTimeMillis());
    }
}

interface LamdaI {
    void add(int a, int b);
}

class Demo implements LamdaI {
    public void add(int a, int b) {
        System.out.println(a + b);
    }

}
