package lambdas;

import lambdas.model.Circle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@FunctionalInterface
interface ElementProcessor<T extends Number>{
    double process (T element);
}

@FunctionalInterface
interface Operation {
    void process();

    static void measure(Operation function){
        long start = System.currentTimeMillis();
        function.process();
        long end = System.currentTimeMillis();
        System.out.println("Time spent " + (end - start) + " ms");
    }

    default Operation combineOperation(Operation that){
        return () -> {
            process();
            that.process();
        };
    }
}

public class LambdaExample {

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(6.3);
        doubleList.add(1.8);
        doubleList.add(11.2);
        doubleList.add(5.6);
        doubleList.add(6.8);

        processElement(intList,x -> Math.sin(x.doubleValue()));
        processElement(doubleList, x -> Math.sin(x.doubleValue()));

        Operation operation1 = () -> Arrays.sort(createRandomArray());
        Operation operation2 = () -> Arrays.sort(createRandomArray());
        Operation.measure(operation1.combineOperation(operation2));

        Circle circle = new Circle();
        System.out.println(circle.calcSomething());

        String s = "Hello";
        Double d = 0.123;

        /*
        CustomClass::staticMethod
        customClassInstance::nonStaticMethod
        CustomClass::nonStaticMethod
        CustomClass::new
        */

        TransformUtils<Double> doubleUtils = new TransformUtils<>();
        System.out.println(doubleUtils.transform(d, Math::sin));

        TransformUtils<String> stringUtils = new TransformUtils<>();
        System.out.println(stringUtils.transform(s, TransformUtils::exclaim));
        //stringUtils.transform(s, s1 -> TransformUtils.exclaim(s1));

        String suffix = " Alex";
        System.out.println(stringUtils.transform(suffix, s::concat));
        //stringUtils.transform(s, x -> x.concat(suffix));
        //s.concat(suffix);

        System.out.println(stringUtils.transform(s, String::toUpperCase));
        System.out.println(stringUtils.transform(s, String::new));

        LambdaScopeTest scope = new LambdaScopeTest();
        LambdaScopeTest.LambdaScopeInner inner = scope.new LambdaScopeInner();
        inner.testScope(9999.000);
    }

    public static <T extends Number> void processElement(List<T> intList, ElementProcessor functoin){
        List<Double> doubleList = new ArrayList<>();
        for (Number i : intList){
            doubleList.add(functoin.process(i));
        }
        System.out.println(doubleList);
    }

    private static double multiply(int x, int y){
        return x * y / 10.0;
    }

    private static int[] createRandomArray(){
        int[] myArray = new int[1000000];
        Random r = new Random();

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = r.nextInt(myArray.length);
        }
        return myArray;
    }
}
