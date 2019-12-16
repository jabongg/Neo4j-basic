package basics.learning.java8.enums;

public class EnumAbstractMethodDemo {

    public static void getFavouriteProgrammingLanguage( ProgrammingLanguage language) {
        switch (language) {
            case CPRINT:
                System.out.println("C is my favourite language.");
                break;
            case JAVAPRINT:
                System.out.println("Java is my favourite language.");
                break;
            case CPLUSPLUSPRINT:
                System.out.println("C++ is my favourite language.");
        }
    }

    public static void main(String args[]) {
        getFavouriteProgrammingLanguage(ProgrammingLanguage.JAVAPRINT);
        ProgrammingLanguage.CPRINT.print();
    }
}
