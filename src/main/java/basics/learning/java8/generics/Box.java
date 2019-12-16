package basics.learning.java8.generics;

/**
 * Generic version of the Box class.
 * @param <T> the type of the value being boxed
 */

public class Box<T> {
    // T stands for "Type"
    private T obj;

    public Box(T obj) {
        this.obj = obj;
    }

    public Box() {
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Box{" +
                "obj=" + obj +
                '}';
    }
}
