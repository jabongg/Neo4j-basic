package basics.learning.java8.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToStreamDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(14);
        list.add(62);
        list.add(37);
        list.add(45);
        list.add(23);
        list.add(93);

        System.out.println(list);


       List<Integer> newList= list.stream().filter(integer -> integer % 3 == 0).collect(Collectors.toList());
        System.out.println(newList);


        Collection<Widget> widgets = new ArrayList<>();

        Widget widget1 = new Widget("RED", 26);
        Widget widget2 = new Widget("YELLOW", 87);
        Widget widget3 = new Widget("RED", 23);
        Widget widget4 = new Widget("GREEN", 76);
        Widget widget5 = new Widget("RED", 90);
        Widget widget6 = new Widget("BLUE", 78);
       // Widget widget7 = new Widget("BLUE", 78);


        widgets.add(widget1);
        widgets.add(widget2);
        widgets.add(widget3);
        widgets.add(widget4);
        widgets.add(widget5);
        widgets.add(widget6);
       // widgets.add(widget7);

        List<Widget> widgetCollection = widgets.stream()
                .filter(Objects::isNull)
                .filter(widget -> widget.getColor() == "RED")
                .filter(widget -> widget.getWeight() > 50)
                .collect(Collectors.toList());

        System.out.println(widgetCollection);



        int sum = widgets.stream()
                .filter(widget -> widget.getColor() == "RED")
                .mapToInt(Widget::getWeight)
                .sum();

        System.out.println(sum);


        Map<Integer, Widget> widgetMap = widgets.stream()
                .collect(Collectors.toMap(Widget::getWeight, Function.identity(),
                        (widgetu, widgetw) -> {
                    return widget1;
                }));
        System.out.println(widgetMap);


        List<WidgetModel> models = widgets.stream().filter(Objects::isNull)
                .map(master -> {
                    WidgetModel widgetModel = new WidgetModel();
                    widgetModel.setId(new Random().nextInt());
                    widgetModel.setLatestColour(master.getColor());
                    widgetModel.setOptimumWeight(master.getWeight());
                    return widgetModel;
                }).collect(Collectors.toList());


        System.out.println(models);

    }
}
