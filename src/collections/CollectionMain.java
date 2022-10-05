package collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionMain {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        list.add(Integer.valueOf(1));  // Auto boxing process.

        Integer integ = 56;
        int b = integ.intValue();
        Double doub = 56.567;
        double d = doub.doubleValue(); // Auto unboxing process.

        String[] colors = {"red", "yellow", "blue"};

        LinkedList<String> li = new LinkedList<>(Arrays.asList(colors));
        li.add("black");

        colors = li.toArray(new String[li.size()]);

        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }
    }
}
