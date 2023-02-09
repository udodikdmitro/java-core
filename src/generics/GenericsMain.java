package generics;

public class GenericsMain {

    public static void main(String[] args) {

        Container<Integer> box = new Container(1);
        Container<String> box2 = new Container("1");
        System.out.println(box.getObject());
    }
}
