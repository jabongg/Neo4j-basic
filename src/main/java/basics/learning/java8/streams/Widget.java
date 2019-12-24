package basics.learning.java8.streams;

public class Widget {

    private String color;
    private Integer weight;

    public Widget(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Widget{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
