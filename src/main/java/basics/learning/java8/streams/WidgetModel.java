package basics.learning.java8.streams;

public class WidgetModel {

    private int id;
    private String latestColour;
    private Integer optimumWeight;

    public WidgetModel(int id, String latestColour, Integer optimumWeight) {
        this.id = id;
        this.latestColour = latestColour;
        this.optimumWeight = optimumWeight;
    }


    public WidgetModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatestColour() {
        return latestColour;
    }

    public void setLatestColour(String latestColour) {
        this.latestColour = latestColour;
    }

    public Integer getOptimumWeight() {
        return optimumWeight;
    }

    public void setOptimumWeight(Integer optimumWeight) {
        this.optimumWeight = optimumWeight;
    }
}
