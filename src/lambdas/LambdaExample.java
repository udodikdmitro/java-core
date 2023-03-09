package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@FunctionalInterface
interface ElementProcessor<T extends Number>{
    double process (T element);
}

@FunctionalInterface
interface ExecutiveFunction{
    void process();
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

        TimeUtil.measure(() -> Arrays.sort(createRandomArray()));
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

    private static class TimeUtil{

        private static void measure(ExecutiveFunction function){
            long start = System.currentTimeMillis();
            function.process();
            long end = System.currentTimeMillis();
            System.out.println("Time spent " + (end - start) + " ms");
        }
    }
}
