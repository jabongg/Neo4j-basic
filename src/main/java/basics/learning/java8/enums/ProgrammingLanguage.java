package basics.learning.java8.enums;

public enum  ProgrammingLanguage {
    JAVAPRINT {
        @Override
        public void print() {
            System.out.println("learning Java");
        }
    },
    CPRINT {
        @Override
        public void print() {
            System.out.println("learning C");
        }
    },
    CPLUSPLUSPRINT {
        @Override
        public void print() {
            System.out.println("learning C++");
        }
    };

    public abstract void print();
}
