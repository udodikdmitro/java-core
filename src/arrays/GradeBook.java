package arrays;

import java.util.Arrays;

public class GradeBook {
    public static void main(String[] args) {
        int[] [] gradesArray = {{85, 95, 66},
                {77, 73, 94},
                {78, 93, 82},
                {88, 77, 96},
                {92, 81, 79}};

        System.out.println(calcMin(gradesArray));

        processArrays();
        System.out.println(calcAverage(2.3,3.5,4.8));
    }

    public static int calcMin(int [] [] grades) {
        int min = 100;

        for(int[] row: grades) {
            for(int i: row) {
                if(min > i) {
                    min = i;
                }
            }
        }
        return min;
    }

    public static double calcAverage(double... args) {
        double sum = 0;

        for(double i: args) {
            sum = sum + i;
        }

        return sum/ args.length;
    }

    public static void processArrays() {
        double[] doubleArray = {8.3, 6.35, 65.4, 25.68};
        Arrays.sort(doubleArray);
        System.out.println(Arrays.toString(doubleArray));

        int[] filledArray = new int[4];
        Arrays.fill(filledArray,4);
        System.out.println(Arrays.toString(filledArray));

        int[] intArray = {1,2,3,4,5,6,7};
        int[] copyArray = new int [10];

        System.arraycopy(intArray, 0, copyArray,0,intArray.length);
        System.out.println(Arrays.toString(copyArray));

    }

}


