package basics.learning.java8.generics;

public class MyGenerics<T> {
    T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "MyGenerics{" +
                "obj=" + obj +
                '}';
    }
}
